package com.aaslin.examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SquareServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		//int sumRes = (int)req.getAttribute("servlet2");
		
		int sumRes = Integer.parseInt(req.getParameter("k"));
		int squareRes =sumRes * sumRes;
		PrintWriter out = res.getWriter();
		out.println("Square of numbers: "+squareRes);
	}
}
