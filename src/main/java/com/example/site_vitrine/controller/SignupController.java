package com.example.site_vitrine.controller;


import com.example.site_vitrine.dto.SignupDTO;
import com.example.site_vitrine.dto.UserDTO;
import com.example.site_vitrine.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

    @Autowired
    private UserService userService;

    @PatchMapping("/sign-up")
    public ResponseEntity<?> signupUser(@RequestBody SignupDTO signupDTO){

        if (userService.hasUserWithEmail(signupDTO.getEmail())){
            return new ResponseEntity<>("Email already exists", HttpStatus.NOT_ACCEPTABLE);
        }

        UserDTO createdUser = userService.createUser(signupDTO);
        if (createdUser != null) {
            return new ResponseEntity<>("User not created. Come again Later!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
