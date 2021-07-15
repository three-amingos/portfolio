package com.wpn.model;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.*;
@Document(collection = "Person")
public class Account {

   // private final List<GrantedAuthority> authorities = AuthorityUtils
         //   .createAuthorityList("ROLE_USER");

    @Id
    @Getter @Setter private String id;
    @Getter @Setter private String name;
    @Getter @Setter private  String email;
   //@Getter @Setter private String givenName;
   // @Getter @Setter private String familyName;
   // @Getter @Setter Map<String, Object> attributes;

    //@JsonCreator
    public Account(@JsonProperty("id") String id,
                   @JsonProperty("name") String name,
                   @JsonProperty("email") String email
                  ) {
        this.id = id;
        this.name= name;
        this.email=email;
       /* this.givenName = name.get("givenName");
        this.familyName = name.get("familyName");
        Map<String, Object> attr = new LinkedHashMap<>();
        attr.put("id", this.id);
        attr.put("email", this.email);
        attr.putAll(name);
        this.attributes = Collections.unmodifiableMap(attr);*/

    }


    /*@Override
    public <A> A getAttribute(String name) {
        return null;
    }




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    @Override
    public String toString() {
        return "Account{" + "authorities=" + authorities + ", id='" + id + '\''
                + ", email='" + email + '\'' + ", givenName='" + givenName + '\''
                + ", familyName='" + familyName + '\'' + ", attributes=" + attributes
                + '}';
    }*/
}
