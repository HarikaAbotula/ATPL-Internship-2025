package com.aaslin.springqualifier;

import org.springframework.stereotype.Component;

@Component("manager")
public class Manager implements Leader {
    @Override
    public void guideTeam() {
        System.out.println("Manager is guiding the team.");
    }
}
