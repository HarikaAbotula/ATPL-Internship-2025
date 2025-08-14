package com.aaslin.springvalue;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.aaslin.springvalue")
@PropertySource("classpath:application.properties")
public class ConfigValue {
	
}
