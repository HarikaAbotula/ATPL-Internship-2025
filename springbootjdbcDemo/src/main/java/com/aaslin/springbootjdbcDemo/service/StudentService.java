package com.aaslin.springbootjdbcDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaslin.springbootjdbcDemo.model.Student;
import com.aaslin.springbootjdbcDemo.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public String addStudent(Student student) {
		int rows = studentRepository.addStudent(student);
		return rows > 0 ? "Student inserted":"failed";
	}
	
	public List<Student> getAllStudents(){
		return studentRepository.getAllStudents();
	}
	
	public Student getStudentById(int id) {
		return studentRepository.getStudentById(id);
	}
	
	public int updateStudent(Student student) {
	return studentRepository.updateStudent(student);
		
	}
	
	public boolean deleteStudent(int id) {
		return studentRepository.deleteStudent(id)>0;
	}
}
