package com.aaslin.springinjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigConstructorInjection {
	@Bean
	public Course course() {
		return new Course("Spring Framework");
	}
	
	@Bean
	public Faculty faculty() {
		return new Faculty(course());
	}
}
