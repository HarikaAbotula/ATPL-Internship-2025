package com.aaslin.springbootjdbcDemo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.aaslin.springbootjdbcDemo.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee>{
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException{
		Employee employe = new Employee();
		employe.setId(rs.getInt(1));
		employe.setName(rs.getString(2));
		employe.setSalary(rs.getDouble("salary"));
        return employe;
	}
}
