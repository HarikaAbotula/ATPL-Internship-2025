package com.aaslin.assignments;

import java.util.*;

public class EmployeeManager {
    public static void main(String[] args) {
        // Add 10 employees with salary parsed from String
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(Integer.valueOf(101), "John", "HR", Double.parseDouble("55000")));
        employees.add(new Employee(Integer.valueOf(102), "Nancy", "IT", Double.parseDouble("65000")));
        employees.add(new Employee(Integer.valueOf(103), "Mike", "Finance", Double.parseDouble("72000")));
        employees.add(new Employee(Integer.valueOf(104), "Dustin", "HR", Double.parseDouble("58000")));
        employees.add(new Employee(Integer.valueOf(105), "Maxi", "IT", Double.parseDouble("63000")));
        employees.add(new Employee(Integer.valueOf(106), "Steve", "Admin", Double.parseDouble("50000")));
        employees.add(new Employee(Integer.valueOf(107), "Lissy", "Finance", Double.parseDouble("71000")));
        employees.add(new Employee(Integer.valueOf(108), "George", "Marketing", Double.parseDouble("60000")));
        employees.add(new Employee(Integer.valueOf(109), "Jessy", "Sales", Double.parseDouble("59000")));
        employees.add(new Employee(Integer.valueOf(110), "Catherine", "IT", Double.parseDouble("67000")));

        System.out.println("Original List:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        // Sort employees by salary using Comparator
        employees.sort(new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                return Double.compare(e1.getSalary(), e2.getSalary());
            }
        });

        System.out.println("\nSorted by Salary:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        // Remove employees from HR department using Iterator
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (emp.getDepartment().equalsIgnoreCase("HR")) {
                iterator.remove();
            }
        }

        System.out.println("\nAfter removing HR department employees:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}

