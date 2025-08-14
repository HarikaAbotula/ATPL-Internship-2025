package com.aaslin.springqualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainQualifier {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigQualifier.class);

        Project project = context.getBean(Project.class);
        project.startProject();
    }
}
