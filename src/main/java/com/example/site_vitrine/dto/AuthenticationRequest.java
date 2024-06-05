package com.example.site_vitrine.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String username;

    private String password;

    public AuthenticationRequest(String jwt) {
    }
}
