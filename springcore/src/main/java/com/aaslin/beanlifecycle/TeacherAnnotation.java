  package com.aaslin.beanlifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class TeacherAnnotation {
    public TeacherAnnotation() {
        System.out.println("Constructor: TeacherAnnotation created");
    }

    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct: init() called");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("@PreDestroy: cleanup() called");
    }
}

