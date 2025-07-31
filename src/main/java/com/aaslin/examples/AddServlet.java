package com.aaslin.examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException  {
		
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int k =i+j;
		//PrintWriter out = res.getWriter();
		//out.println("Sum of numbers: "+k);
		//req.setAttribute("servlet2", k);
		//RequestDispatcher rd= req.getRequestDispatcher("squareRes"); 
		//rd.include(req,res);
		//rd.forward(req, res);	
		
		res.sendRedirect("squareRes?k=" +k);
		
		
		
	}
	
}
