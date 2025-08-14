package com.aaslin.springvalue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServerConfig {
	
	@Value("${server.port}")
	private int port;
	
	@Value("${server.host}")
	private String host;
	
	 @Value("${server.username}")
	 private String username;

	 @Value("${server.password}")
	 private String password;

	 public void printConfig() {
		 System.out.println("Server Configuration:");
	     System.out.println("Host: " + host);
	     System.out.println("Port: " + port);
	     System.out.println("Username: " + username);
	     System.out.println("Password: " + password);
	    }
}
