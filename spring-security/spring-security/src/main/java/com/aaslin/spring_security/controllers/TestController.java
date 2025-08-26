package com.aaslin.spring_security.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/user")
    public String userEndpoint() {
        return "Welcome User!";
    }

    @GetMapping("/admin")
    public String adminEndpoint() {
        return "Welcome Admin!";
    }
}