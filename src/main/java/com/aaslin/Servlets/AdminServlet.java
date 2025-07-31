package com.aaslin.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aaslin.util.DbUtil;

public class AdminServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		 String idParam = request.getParameter("id");
		 //String role=request.getParameter("role");
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        
	        if (idParam == null){
	        	out.println("<h3>Missing id parameter</h3>");
	        	return;
	        }
	       int id = Integer.parseInt(idParam);
	        try(Connection connection = DbUtil.getConnection()) {
	        	PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM UserServlet_Harika WHERE userId = ?");
	        	preparedStatement.setInt(1, id);
	        	ResultSet resultSet = preparedStatement.executeQuery();
	                 
	                 if(resultSet.next()) {
	                	 out.println("<h4> userId: " + resultSet.getInt("userId")+ " username: " +resultSet.getString("username") 
	                	 + " Password: "+ resultSet.getString("password") + " Age: " +resultSet.getInt("age"));
	                 }
	                 else {
	                	 out.println("<h3>User not found</h3>");
	                 }
               }
	          catch (SQLException e) {
				e.printStackTrace();
	          }
	}
}
