package com.example.site_vitrine.dto;

import com.example.site_vitrine.enums.UserRole;

import java.util.UUID;

public class UserDTO {

    private UUID id;

    private  String name;

    private  String email;

    private  String password;
    
    private UserRole userRole;


    public UserDTO() {
    }

    public void setId(UUID id) {
    }

    public void setName(String name) {
    }

    public void setEmail(String email) {
    }

    public void setUserRole(UserRole userRole) {

    }
}
