package com.example.springsecuritydemo.controller;

import com.example.springsecuritydemo.entity.UserAuthEntity;
import com.example.springsecuritydemo.service.UserAuthEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserAuthController {

    @Autowired
    private UserAuthEntityService userAuthEntityService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserAuthEntity userAuthDetails) {
        userAuthDetails.setPassword(passwordEncoder.encode(userAuthDetails.getPassword()));
        userAuthEntityService.save(userAuthDetails);
        return ResponseEntity.ok("User registered successfully!");
    }
}