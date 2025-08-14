package com.aaslin.springvalue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainValue {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigValue.class);

        ServerConfig config = context.getBean(ServerConfig.class);
        config.printConfig();
    }
}
