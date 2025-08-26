package com.aaslin.StudentManagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.aaslin.StudentManagement.model.Student;
import com.aaslin.StudentManagement.exception.StudentNotFoundException;

@Service
public class StudentService {

    private List<Student> studentsList = new ArrayList<>();
    
    //add student
    public void addStudent(Student student) {
        studentsList.add(student);
    }

    //get student by specified id
    public Student getStudentById(String id) {
        for (int i = 0; i < studentsList.size(); i++) {
            Student s = studentsList.get(i);
            if (s.getId().equals(id)) {
                return s;
            }
        }
        throw new StudentNotFoundException("Student ID " + id + " not found");
    }

    //get all student details
    public List<Student> getAllStudents() {
        return studentsList;
    }

    public void updateStudent(Student updatedStudent) {
        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getId().equals(updatedStudent.getId())) {
                studentsList.set(i, updatedStudent);
                return;
            }
        }
        throw new StudentNotFoundException("Student ID " + updatedStudent.getId() + " not found");
    }

    public String deleteStudent(String id) {
    	for (int i = 0; i < studentsList.size(); i++) {
    		if(studentsList.get(i).getId().equals(id)) {
    			studentsList.remove(i);
    			return "Deleted";
    		}
    	}
        throw new StudentNotFoundException("Student ID " + id + " not found");
    }
   
}
