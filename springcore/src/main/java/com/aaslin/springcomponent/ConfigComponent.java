package com.aaslin.springcomponent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.aaslin.springcomponent")
public class ConfigComponent {
	
	@Bean
	public Trainer trainer(){
		return new Trainer();
	}
	
	@Bean
	public TrainingCenter trainingCenter() {
		return new TrainingCenter();
	}
}
