package com.wpn.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class JwtFromLogin {

    @NonNull
    private String jwt;

}
