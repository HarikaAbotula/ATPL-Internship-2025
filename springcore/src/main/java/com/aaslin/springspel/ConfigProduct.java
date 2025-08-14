package com.aaslin.springspel;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.aaslin.springspel") 
@PropertySource("classpath:application.properties")
public class ConfigProduct {
}
