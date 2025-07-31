package com.aaslin.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aaslin.util.DbUtil;

public class AdminUpdate extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String idParam = request.getParameter("userId");
		String isActive = request.getParameter("is_active");
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
		try(Connection connection = DbUtil.getConnection();){
			int userid = Integer.parseInt(idParam);
			String query = "UPDATE UserServlet_Harika set is_active=? where userid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,isActive );
	        preparedStatement.setInt(2, userid);
	        int rows = preparedStatement.executeUpdate();
	        
	        if(rows>0) {
	        	out.println("<h3>role is matched,Status updated sucessfully</h3>");
	        }
	        else {
	        	out.println("<h3>Updation failed</h3>");
	        }	
			
		} catch (SQLException e) {
			
			out.println("<h4> e.getMessage()</h4>");
		}
	}
}
