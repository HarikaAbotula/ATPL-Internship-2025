package com.aaslin.springcomponent;

import org.springframework.stereotype.Component;

@Component
public class Trainer {
	private String name = "Harika";
    private String subject = "Spring Framework";

    public String getTrainerDetails() {
        return "Trainer Name: " + name + ", Subject: " + subject;
    }
}
