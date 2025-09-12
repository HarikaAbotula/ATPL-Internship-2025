package com.aaslin.cbt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EntityScan(basePackages = "com.aaslin.cbt.super_admin.model")
public class CbtApplication {

	public static void main(String[] args) {
		SpringApplication.run(CbtApplication.class, args);
	}

}
