package com.aaslin.librarysystem.controller;

import com.aaslin.librarysystem.repository.BookRepository;
import com.aaslin.librarysystem.repository.IssuedBookRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private IssuedBookRepository issuedBookRepo;

    @GetMapping("/user/dashboard")
    public String userDashboard(HttpSession session, Model model) {
        String userNum = (String) session.getAttribute("userNum");
        model.addAttribute("books", bookRepo.findByIsActiveTrue());
        model.addAttribute("issuedBooks", issuedBookRepo.findByUser_UserNum(userNum));
        return "user-dashboard";
    }

    @GetMapping("/user/issued")
    public String userIssuedBooks(HttpSession session, Model model) {
        String userNum = (String) session.getAttribute("userNum");
        model.addAttribute("issuedBooks", issuedBookRepo.findByUser_UserNum(userNum));
        return "userIssuedBooks";
    }
}
