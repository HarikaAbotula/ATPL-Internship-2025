package com.aaslin.examples;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserDetails extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private static final String db_url = "jdbc:mysql://192.168.71.15:3306/intern";
	private static final String db_userName = "intern2025";
	private static final String db_passWord = "intern2025";
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		
		//String idParam = request.getParameter("userid");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		//int id = Integer.parseInt(idParam);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(db_url,db_userName,db_passWord);
			System.out.println("Connection established");
			//PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM UserServlet_Harika where userid=?");
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM UserServlet_Harika");
			//preparedStatement.setString(1, idParam);
			
			ResultSet rs= preparedStatement.executeQuery();
			out.println("<!DOCTYPE html>");
			out.println("<body>");
			
			while(rs.next()) {
				
				out.println("<h3> Username: "+rs.getString("username") +" "+ "Password: "+rs.getString("password")+"</h3>");
				
			}
			out.println("</body></html>");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
