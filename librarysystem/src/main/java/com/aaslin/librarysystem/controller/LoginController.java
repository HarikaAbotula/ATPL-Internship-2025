package com.aaslin.librarysystem.controller;

import com.aaslin.librarysystem.model.UserLogin;
import com.aaslin.librarysystem.model.AdminLogin;
import com.aaslin.librarysystem.repository.UserLoginRepository;
import com.aaslin.librarysystem.repository.AdminLoginRepository;
import com.aaslin.librarysystem.repository.BookRepository;
import com.aaslin.librarysystem.repository.IssuedBookRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserLoginRepository userLoginRepo;

    @Autowired
    private AdminLoginRepository adminLoginRepo;

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private IssuedBookRepository issuedBookRepo;

    @GetMapping("/login")
    public String loginPage(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        // --- USER LOGIN ---
        Optional<UserLogin> userOpt = userLoginRepo.findByUsernameAndUserNum(username, password);
        if (userOpt.isPresent() && userOpt.get().getRole().equalsIgnoreCase("user")) {
            UserLogin userLogin = userOpt.get();
            session.setAttribute("username", userLogin.getUsername());
            session.setAttribute("userNum", userLogin.getUserNum());

            model.addAttribute("books", bookRepo.findByIsActiveTrue());
            model.addAttribute("issuedBooks", issuedBookRepo.findByUser_UserNum(userLogin.getUserNum()));

            return "user-dashboard";
        }

        // --- ADMIN LOGIN ---
        Optional<AdminLogin> adminOpt = adminLoginRepo.findByUsernameAndPassword(username, password);
        if (adminOpt.isPresent() && adminOpt.get().getRole().equalsIgnoreCase("admin")) {
            session.setAttribute("username", adminOpt.get().getUsername());
            // preload books so admin-dashboard renders table
            model.addAttribute("books", bookRepo.findByIsActiveTrue());
            return "admin-dashboard";
        }

        // --- INVALID CREDENTIALS ---
        model.addAttribute("error", "Invalid Credentials!");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
