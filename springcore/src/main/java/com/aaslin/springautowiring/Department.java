package com.aaslin.springautowiring;

import org.springframework.stereotype.Component;

@Component
public class Department {
    private String deptName;

    public Department() {
        this.deptName = "Development";
        System.out.println("Department created");
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void show() {
        System.out.println("Department: " + deptName);
    }
}
