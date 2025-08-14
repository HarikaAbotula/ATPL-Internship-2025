package com.aaslin.CustomValidatorIntegration.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aaslin.CustomValidatorIntegration.dto.UserRegistration;

import jakarta.validation.Valid;

import org.springframework.validation.BindingResult;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@Valid @RequestBody UserRegistration user,
                                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
        	return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        return ResponseEntity.ok("User registered successfully!");
    }
}
