package com.aaslin.library.controller;

import com.aaslin.library.dao.UserLoginDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get username and password from login form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate credentials using DAO
        UserLoginDao dao = new UserLoginDao();
        String role = dao.validateUser(username, password); // returns "admin", "user", or null

        // Start session and store info
        HttpSession session = request.getSession();

        if ("admin".equals(role)) {
            session.setAttribute("username", username);
            session.setAttribute("role", "admin");
            response.sendRedirect("viewBooks"); // redirect to admin dashboard
        } else if ("user".equals(role)) {
            session.setAttribute("username", username);
            session.setAttribute("role", "user");
            response.sendRedirect("viewBooks"); // redirect to user dashboard
        } else {
            request.setAttribute("error", "Invalid credentials. Please try again.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
