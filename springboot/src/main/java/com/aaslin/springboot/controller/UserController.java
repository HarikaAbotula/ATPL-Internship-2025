package com.aaslin.springboot.controller;

import com.aaslin.springboot.model.User;
import com.aaslin.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // GET (/users/{id})
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        User user = userRepository.getUserById(id);
        if (user == null) {
            throw new RuntimeException("User not found with ID: " + id);
        }
        return user;
    }

    // POST (/users)
    @PostMapping
    public String addUser(@RequestBody User user) {
        userRepository.addUser(user);
        return "User added successfully!";
    }

    // GET /users (List all)
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}

