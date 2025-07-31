package com.aaslin.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aaslin.dao.UserDAO;
import com.aaslin.model.User;

public class UserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private UserDAO userDao = new UserDAO();
	//get user info based on id
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("id");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
        	 if (idParam != null) {
                 int id = Integer.parseInt(idParam);
                 User user = userDao.getUserById(id);
                 
                 if (user != null) {
                     out.println("<h2>User Info:</h2>");
                     out.println("<p>" + user + "</p>");
                 } else {
                	 response.sendError(id, "User not found with ID: " + id);
                 }
        	 }
        	 else {
                 // Print all users
                 List<User> users = userDao.getAllUserInfo();
                 out.println("<h2>All Users:</h2>");
                 out.println("<ul>");
                 for (User u : users) {
                     out.println("<li>" + u + "</li>");
                 }
                 out.println("</ul>");
            } 
        } 
        catch (SQLException e) {
            throw new ServletException("Database error: " + e.getMessage(), e);
        }
    }
    
    //to store info in db
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
    	String idParam = request.getParameter("userId");
    	String name = request.getParameter("username");
    	String password= request.getParameter("pass");
        String ageParam = request.getParameter("age");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
        	int id = Integer.parseInt(idParam);
            int age = Integer.parseInt(ageParam);
            userDao.insertUserIntoDb(id,name,password,age);
            out.println("<h3>User added successfully!</h3>");
        } 
        
        catch (Exception e) {
            throw new ServletException("Insert failed: " + e.getMessage(), e);
        }
    }
}