package com.aaslin.SpringBootExceptionHandling.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Employee {
	 @NotBlank(message = "Name must not be blank")
	 private String name;

	 @Email(message = "Email is invalid")
	 @NotBlank(message = "Email must not be blank")
	 private String email;

	 @Min(value = 1, message = "Salary must be greater than 0")
	 private double salary;

	 public Employee() {}

	 public Employee(String name, String email, double salary) {
	        this.name = name;
	        this.email = email;
	        this.salary = salary;
	    }

	    // Getters and Setters
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public String getEmail() {
	        return email;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    public double getSalary() {
	        return salary;
	    }
	    public void setSalary(double salary) {
	        this.salary = salary;
	    }
}
