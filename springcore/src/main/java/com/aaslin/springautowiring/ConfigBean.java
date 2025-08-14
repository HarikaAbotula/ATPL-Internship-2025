package com.aaslin.springautowiring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.aaslin.springautowiring")
public class ConfigBean {
	
	@Bean
	public Department department() {
        return new Department();
    }
	
	@Bean
	 public EmployeeField employeeField() {
        return new EmployeeField();
    }
	
	@Bean
    public EmployeeSetter employeeSetter() {
        return new EmployeeSetter();
    }

    @Bean
    public EmployeeConstructor employeeConstructor() {
        return new EmployeeConstructor(department());
    }
}
