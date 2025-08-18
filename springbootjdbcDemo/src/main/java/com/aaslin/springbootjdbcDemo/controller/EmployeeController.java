package com.aaslin.springbootjdbcDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.aaslin.springbootjdbcDemo.model.Employee;
import com.aaslin.springbootjdbcDemo.repository.EmployeeDao;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
     
	@Autowired
	private EmployeeDao empdao;
	
	@PostMapping
    public String addEmployee(@RequestBody Employee e) {
        int rows = empdao.addEmployee(e);
        return rows > 0 ? "Employee added!" : "Insert failed!";
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return empdao.getAllEmployees();
    }


}
