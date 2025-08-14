package com.aaslin.StudentManagement.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.aaslin.StudentManagement.model.Student;
import com.aaslin.StudentManagement.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student-list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    @PostMapping("/add")
    public String addStudent(@Valid @ModelAttribute("student") Student student,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "student-form";
        }
        studentService.addStudent(student);
        return "redirect:/students";
    }
    
    @GetMapping("/add/{id}")
    public String viewStudent(@PathVariable String id,Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student",student);
        return "student-view";
    }
    
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable String id,Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student",student);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable String id,@Valid @ModelAttribute("student") Student student,
                                BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
        	student.setId(id);
        	model.addAttribute("student",student);
            return "update";
        }
        student.setId(id);
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
