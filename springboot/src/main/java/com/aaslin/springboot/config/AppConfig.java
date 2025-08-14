package com.aaslin.springboot.config;

import com.aaslin.springboot.service.GreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  
public class AppConfig {

    @Bean  // Registers GreetingService in the Spring context
    public GreetingService greetingService() {
        return new GreetingService();
    }
}


