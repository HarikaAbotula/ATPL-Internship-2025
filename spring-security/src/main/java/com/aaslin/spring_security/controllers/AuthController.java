package com.aaslin.spring_security.controllers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aaslin.spring_security.model.LoginRequest;
import com.aaslin.spring_security.service.JwtUtil;

@RestController
public class AuthController {
	private final JwtUtil jwtUtil;

	public AuthController(AuthenticationManager authManager, JwtUtil jwtUtil) { 
		this.jwtUtil = jwtUtil;
	}

	@PostMapping("/login")
	public String login(@RequestBody LoginRequest request) {
	    return jwtUtil.generateToken(request.getUsername());
	}
}
