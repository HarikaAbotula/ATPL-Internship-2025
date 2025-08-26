package com.aaslin.springbootjdbcDemo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aaslin.springbootjdbcDemo.model.Student;

@Repository
public class StudentRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int addStudent(Student student) {
		String insertQuery = "insert into student_table(name,phone_num,address) values (?,?,?) ";
		return jdbcTemplate.update(insertQuery,student.getName(),student.getPhoneNum(),student.getAddress());
	}
	
	public List<Student> getAllStudents(){
		String selectQuery = "select*from student_table";
		List<Student> allList = jdbcTemplate.query(selectQuery, new BeanPropertyRowMapper<Student>(Student.class));
		return allList;
	}
	
	public Student getStudentById(int id) {
		String selectByIdQuery = "Select * from student_table where id = ?";
		Student student = jdbcTemplate.queryForObject(selectByIdQuery,new BeanPropertyRowMapper<>(Student.class),id);
		return student;
	}
	
	public int updateStudent(Student student) {
		String updateQuery = "update student_table set name=?,phone_num=?,address=? where id = ?";
		return jdbcTemplate.update(updateQuery,student.getName(),student.getPhoneNum(),student.getAddress(),student.getId());
	}
	
	public int deleteStudent(int id) {
		String deleteQuery = "delete from student_table where id= ?";
		return jdbcTemplate.update(deleteQuery,id);
	}
}
