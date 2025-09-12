package com.aaslin.cbt.super_admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aaslin.cbt.super_admin.Dto.LoginRequest;
import com.aaslin.cbt.super_admin.Dto.CreateUserRequest;
import com.aaslin.cbt.super_admin.model.User;
import com.aaslin.cbt.super_admin.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/auth")
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpSession session) {
	        User user = userService.login(loginRequest.getUsername(), loginRequest.getPassword());

	        if (user != null) {
	            session.setAttribute("loggedInUser", user);
	            return ResponseEntity.ok(user);
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
	        }
	    }
	
	@PostMapping("/create-superadmin")
	public ResponseEntity<User> createSuperAdmin(@RequestBody CreateUserRequest request,
	                                             HttpSession session) {
	    User sa = userService.createSuperAdmin(request.getUsername(), request.getPassword());

	    // Store super admin in session
	    session.setAttribute("loggedInUser", sa);

	    return ResponseEntity.status(HttpStatus.CREATED).body(sa);
	}

	@PostMapping("/create-developer")
	public ResponseEntity<?> createDeveloper(@RequestBody CreateUserRequest request,
	                                         HttpSession session) {
	    User loggedInUser = (User) session.getAttribute("loggedInUser");

	    if (loggedInUser == null || !"SUPER ADMIN".equalsIgnoreCase(loggedInUser.getRole().getRoleName())) {
	        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Only Super Admin can create Developers");
	    }

	    User dev = userService.createDeveloper(request.getUsername(), request.getPassword(), loggedInUser.getUserId());
	    return ResponseEntity.status(HttpStatus.CREATED).body(dev);
	}
	
	@PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("Logged out successfully");
    }
}
