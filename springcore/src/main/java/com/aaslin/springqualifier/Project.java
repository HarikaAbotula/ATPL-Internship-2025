package com.aaslin.springqualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Project {

    @Autowired
   // @Qualifier("teamLead") // specify which bean to inject
    @Qualifier("manager")
    private Leader leader;  //Multiple beans implement Leader, Spring doesn’t know which one to inject, so it throws an error without qualifier.

    public void startProject() {
        System.out.println("Project started...");
        leader.guideTeam();
    }
}

