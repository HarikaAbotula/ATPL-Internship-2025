package com.aaslin.spring_security.controllers;

import org.springframework.web.bind.annotation.*;

import com.aaslin.spring_security.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Only ADMIN can access
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    // Only USER can access
    @GetMapping("/{username}")
    public String viewProfile(@PathVariable String username) {
        return userService.viewProfile(username);
    }
}

