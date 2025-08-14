package com.aaslin.springcomponent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainComponent {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigComponent.class);
	        
	    TrainingCenter center = context.getBean(TrainingCenter.class);
	    center.showTrainerInfo();
	    
	}

}
