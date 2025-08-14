package com.aaslin.springautowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeField {
	
    @Autowired
    private Department department;
    
    public void display() {
    	System.out.println("Field Injection: ");
        department.show();
    }
}
