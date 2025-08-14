package com.aaslin.CustomValidatorIntegration.dto;

import com.aaslin.CustomValidatorIntegration.validator.PasswordMatches;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@PasswordMatches // Custom annotation
public class UserRegistration {

    @NotBlank(message = "Username must not be blank")
    private String username;

    @NotBlank(message = "Password must not be blank")
    private String password;

    @NotBlank(message = "Confirm Password must not be blank")
    private String confirmPassword;

    @Min(value = 18, message = "Age must be at least 18")
    private int age;

    public UserRegistration() {
    }

    public UserRegistration(String username, String password, String confirmPassword, int age) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.age = age;
    }

    // Getters & Setters
    public String getUsername() { 
    	return username; 
    }
    
    public void setUsername(String username) {
    	this.username = username; 
    }
    
    public String getPassword() { 
    	return password;
    }
    
    public void setPassword(String password) { 
    	this.password = password; 
    }
    
    public String getConfirmPassword() {
    	return confirmPassword;
    }
    
    public void setConfirmPassword(String confirmPassword) { 
    	this.confirmPassword = confirmPassword; 
    }
    
    public int getAge() { 
    	return age; 
    }
    
    public void setAge(int age) { 
    	this.age = age;
    }
}