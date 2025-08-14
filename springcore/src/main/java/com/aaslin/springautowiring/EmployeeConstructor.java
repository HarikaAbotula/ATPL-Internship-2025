package com.aaslin.springautowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConstructor {
    private Department department;

    @Autowired
    public EmployeeConstructor(Department department) {
        this.department = department;
    }

    public void display() {
    	System.out.println("Constructor Injection: ");
        department.show();
    }
}
