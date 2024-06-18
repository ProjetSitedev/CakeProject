package com.example.site_vitrine.service;

import com.example.site_vitrine.dto.SignupDTO;
import com.example.site_vitrine.dto.UserDTO;

public interface UserService {
    UserDTO createUser(SignupDTO signupDTO);

    boolean hasUserWithEmail(String email);
}
