package com.aaslin.springboot.controller;

import com.aaslin.springboot.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    private final GreetingService greetingService;

    // Constructor injection
    @Autowired
    public GreetController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greet1")
    public String greet() {
        return greetingService.getGreeting();
    }
}

