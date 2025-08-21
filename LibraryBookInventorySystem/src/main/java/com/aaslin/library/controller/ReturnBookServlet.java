package com.aaslin.library.controller;

import com.aaslin.library.dao.IssuedBookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
//import java.util.Date;

//Servlet to handle book return.

@WebServlet("/returnBook")
public class ReturnBookServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int issueId = Integer.parseInt(request.getParameter("issue_id"));
            int bookId = Integer.parseInt(request.getParameter("book_id"));
            String returnDateStr = request.getParameter("return_date");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = sdf.parse(returnDateStr);
            java.sql.Date returnDate = new java.sql.Date(parsedDate.getTime());


            IssuedBookDao dao = new IssuedBookDao();
            boolean result = dao.returnBook(issueId, bookId, returnDate, "admin");

            request.setAttribute("message", result ? "Book returned successfully!" : "Failed to return book.");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Error: " + e.getMessage());
        }
        request.getRequestDispatcher("return_book.jsp").forward(request, response);
    }
}
