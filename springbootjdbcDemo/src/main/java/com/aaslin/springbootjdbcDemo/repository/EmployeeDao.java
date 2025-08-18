package com.aaslin.springbootjdbcDemo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aaslin.springbootjdbcDemo.model.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//insert data
	 public int addEmployee(Employee e) {
	    String sql = "INSERT INTO employeeTable(name, salary) VALUES (?, ?)";
	    return jdbcTemplate.update(sql, e.getName(), e.getSalary());
	 }

	    // Retrieve all employees
	 public List<Employee> getAllEmployees() {
	    String sql = "SELECT * FROM employeeTable";
	    return jdbcTemplate.query(sql, new EmployeeRowMapper());
	 }
}
