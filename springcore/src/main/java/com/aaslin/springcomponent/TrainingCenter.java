package com.aaslin.springcomponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrainingCenter {
	
	@Autowired
	private Trainer trainer;
	
	public void showTrainerInfo() {
		System.out.println("Welcome to the Training Center");
        System.out.println(trainer.getTrainerDetails());
    }
}
