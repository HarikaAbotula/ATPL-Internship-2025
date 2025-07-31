package com.aaslin.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AdminRoleFilter implements Filter {
	
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException, ServletException{
		String role  = request.getParameter("role");
		
		if("admin".equalsIgnoreCase(role)) {
			chain.doFilter(request, response);
		}
		else {
			response.setContentType("text/pain");
			response.getWriter().write("Access denied: admin role is required ");
		}
	}

}
