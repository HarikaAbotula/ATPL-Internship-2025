package com.aaslin.SpringBootExceptionHandling.controller;

import com.aaslin.SpringBootExceptionHandling.exception.NotFoundException;
import com.aaslin.SpringBootExceptionHandling.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private List<Employee> employees = new ArrayList<Employee>();

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        employees.add(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }


    @GetMapping("/{email}")
    public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable String email) {
        for (Employee e : employees) {
            if (e.getEmail().equalsIgnoreCase(email)) {
                return ResponseEntity.ok(e);
            }
        }
        throw new NotFoundException("Employee with email " + email + " not found");
    }
}
