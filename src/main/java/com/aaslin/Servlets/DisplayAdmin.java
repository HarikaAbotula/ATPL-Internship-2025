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

public class DisplayAdmin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        
	        try(Connection connection = DbUtil.getConnection()) {
	        	PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM UserServlet_Harika");
	        	ResultSet resultSet = preparedStatement.executeQuery();
	                 
	                 while(resultSet.next()) {
	                	 out.println("<h4> userId: " + resultSet.getInt("userId")+
	                			 " , username: " +resultSet.getString("username") +
	                			 " , Password: "+ resultSet.getString("password") + 
	                			 " , Age: " +resultSet.getInt("age")+
	                			 " , is_Active: "+resultSet.getString("is_active"));
	                 }
               }
	          catch (SQLException e) {
				e.printStackTrace();
	          }
	} 

}
