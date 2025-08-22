package com.aaslin.spring_security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaslin.spring_security.Repository.UserRepository;
import com.aaslin.spring_security.model.UserEntity;

@RestController
@RequestMapping("/api")
public class AllControllers {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/hello")
	public String helloUser() {
		return "Hello user is authenticated"; 
	}
	
	@GetMapping("/dev")
	public String dev() {
		return "Hello Developer,no login needed";
	}
	
	@GetMapping("/admin/dashboard")
	public String admin() {
		return "Accessible only to ADMIN";
	}
	
	@GetMapping("/user/profile")
	public String user() {
		return "Accessible only to USER";
	}
	
	@PostMapping("/register")
	public String register(@RequestBody UserEntity user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "user registered successfully";
	}
}
