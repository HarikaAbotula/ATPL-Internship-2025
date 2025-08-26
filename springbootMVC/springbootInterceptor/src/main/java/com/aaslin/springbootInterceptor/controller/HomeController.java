package com.aaslin.springbootInterceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/hello")
    public String sayHello(Model model) {
        System.out.println("[Controller] Handling /hello request");
        model.addAttribute("message", "Hello from Spring MVC!");
        return "hello"; // resolved by ViewResolver
    }
    
    @GetMapping("/json")
    @ResponseBody
    public String jsonResponse() {
        return "{\"status\":\"ok\"}";
    }
    
}

