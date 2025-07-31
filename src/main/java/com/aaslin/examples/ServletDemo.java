package com.aaslin.examples;

import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class ServletDemo extends HttpServlet {
	
	private static final String db_url = "jdbc:mysql://192.168.71.15:3306/intern";
	private static final String db_userName = "intern2025";
	private static final String db_passWord = "intern2025";
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		out.println("<form action='formDetails' method='post'>");
		out.println("UserName: <input type='text' name='uname'> <br> <br>");
		out.println("Password: <input type='password' name='password'> <br> <br>");
		out.println("Email: <input type='email' name='email' ><br><br>");
		out.println("&ensp;<button type='submit'>Submit</button>");
		out.println("</form>");
		out.println("</body></html>");
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		String username = request.getParameter("uname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		System.out.println("Name: "+username);
		System.out.println("password: "+password);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try(Connection connection = DriverManager.getConnection(db_url,db_userName,db_passWord);
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO UserServlet_Harika(username,password,email) VALUES(?,?,?)");)
			{
				preparedStatement.setString(1,username);
				preparedStatement.setString(2, password);
				preparedStatement.setString(3, email);
				
				int result = preparedStatement.executeUpdate();
				System.out.println("Result: "+result);
				out.println("<html><body>");
				if(result > 0) {
					out.println("<h2>Data Saved Successfully</h2>");
				}
				else {
					out.println("<h2 style='color:red;'>Error while saving the data</h2>");
				}
				
				
			} 
		 catch (SQLException e) {
				out.println("<h3 style='color:red;'>"+  e.getMessage() + "</h3>");
			}
		out.println("</body></html>");
	}
	
}
