
resource "random_string" "random" {

  length = 4
  special = false
  upper = false
}

resource "aws_dynamodb_table" "state" {
  hash_key = "LockID"
  write_capacity = 10
  read_capacity = 10
  name = "${var.stack_name}-${terraform.workspace}-${random_string.random.result}-state-db"
  attribute {
    name = "LockID"
    type = "S"
  }
  lifecycle {
    prevent_destroy = false
  }
  tags = merge(
  {
    "Name" = format("%s-%s-%s-%s",var.stack_name,terraform.workspace,random_string.random.result,"state-lock")
  },
  var.tags,
  )
}

resource "aws_s3_bucket" "state" {
  bucket = "${var.stack_name}-${terraform.workspace}-${random_string.random.result}-tfstate-bucket"
  acl = "private"
  lifecycle {
    prevent_destroy = false
  }
  versioning {
    enabled = true
  }

  server_side_encryption_configuration {
    rule {
      apply_server_side_encryption_by_default {
        sse_algorithm = var.kms_key_id == ""? "AES256" : "aws:kms"
        kms_master_key_id = var.kms_key_id
      }
    }
  }
  tags = merge(
  {
    "Name" = format("%s-%s-%s-%s",var.stack_name,terraform.workspace,random_string.random.result,"tfstate-bucket")
  },
  var.tags,
  )
}


#create s3 terraform state bucket policy docucment
data "aws_iam_policy_document" "bucket-policy-document" {
  statement {
    sid = "RequireEncryptedTransport"
    effect = "Deny"
    actions = [
      "s3:*",
    ]
    resources = [
      "${aws_s3_bucket.state.arn}/*"
    ]
    condition {
      test = "Bool"
      variable = "aws:SecureTransport"
      values = [
        false,
      ]
    }
    principals {
      type = "*"
      identifiers = ["*"]
    }
  }

  statement {
    sid = "RequireEncryptedStorage"
    effect = "Deny"
    actions = [
      "s3:PutObject",
    ]
    resources = [
      "${aws_s3_bucket.state.arn}/*"
    ]
    condition {
      test = "StringNotEquals"
      variable = "s3:x-amz-server-side-encryption"
      values = [
        var.kms_key_id == "" ? "AES256" : "aws:kms"
      ]
    }
    principals {
      type = "*"
      identifiers = ["*"]
    }
  }
}

#create bucket policy for the terraform state backend
resource "aws_s3_bucket_policy" "bucket-policy" {
  bucket = aws_s3_bucket.state.id
  policy = data.aws_iam_policy_document.bucket-policy-document.json
}
