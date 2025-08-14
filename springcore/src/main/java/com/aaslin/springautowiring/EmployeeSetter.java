package com.aaslin.springautowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeSetter {
    private Department department;

    @Autowired
    public void setDepartment(Department department) {
        this.department = department;
    }

    public void display() {
    	System.out.println("Setter Injection: ");
        department.show();
    }
}
