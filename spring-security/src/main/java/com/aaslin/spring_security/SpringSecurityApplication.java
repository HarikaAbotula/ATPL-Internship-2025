package com.aaslin.spring_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//	    System.out.println(encoder.encode("admin12"));
//	    System.out.println(encoder.encode("harika08"));
	}
	
}
