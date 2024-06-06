//package com.example.site_vitrine.controller;

//import com.example.site_vitrine.dto.AuthenticationRequest;
//import com.example.site_vitrine.entities.User;
//import com.example.site_vitrine.repository.UserRepository;
//import com.example.site_vitrine.service.user.UserService;
//import com.example.site_vitrine.utils.JwtUtil;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;

//import java.io.IOException;

//@RestController
//public class AuthenticationController {

//@Autowired
//private UserService userService;

//@Autowired
//private AuthenticationManager authenticationManager;

//@Autowired
//private UserDetailsService userDetailsService;

//@Autowired
//private JwtUtil jwtUtil;

//@Autowired
//private UserRepository userRepository;

//@PostMapping("/authenticate")

//public void createAuticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws BadCredentialsException, DisabledException, UsernameNotFoundException, IOException, ServletException {
//try {
//authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
//} catch (BadCredentialsException e) {
//throw new BadCredentialsException("Invalid username or password", e);
//} catch (DisabledException disabledException) {
//response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "User is not activated");
//return;
//}
//final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//User user = userRepository.findByEmail(authenticationRequest.getUsername());
//final String jwt = jwtUtil.generateToken(authenticationRequest.getUsername());
//return; new AuthenticationRequest(jwt);

//}
//}
