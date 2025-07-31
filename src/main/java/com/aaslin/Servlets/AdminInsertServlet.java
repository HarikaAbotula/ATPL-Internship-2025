package com.aaslin.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aaslin.util.DbUtil;

public class AdminInsertServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String idParam = request.getParameter("id");
    	String username = request.getParameter("username");
    	String password= request.getParameter("pass");
        String ageParam = request.getParameter("age");
        String is_active = request.getParameter("is_active");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try(Connection connection = DbUtil.getConnection();) {
        	
        	int userid = Integer.parseInt(idParam);
            int age = Integer.parseInt(ageParam);
        	String query="INSERT INTO UserServlet_Harika(userid,username,password,age,is_active) values(?,?,?,?,?)";
 
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, userid);
	        preparedStatement.setString(2, username);
	        preparedStatement.setString(3, password);
	        preparedStatement.setInt(4, age);
	        preparedStatement.setString(5, is_active);
	        
	        int rows = preparedStatement.executeUpdate();
	        
	        if(rows>0) {
	        	out.println("<h3>role is matched,User inserted sucessfully</h3>");
	        }
	        else {
	        	out.println("<h3>Inserted failed</h3>");
	        }	
        }    
        catch(Exception e) {
        	out.println("<h4>"+ e.getMessage()+"</h4>");
        }
	}
}
