package com.aaslin.library.controller;

import com.aaslin.library.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {
   
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        String role = (String) session.getAttribute("role");
        String username = (String) session.getAttribute("username");

        if (session == null || !"admin".equals(role)) {
            session.setAttribute("message", "Only admin can delete books.");
            response.sendRedirect("viewBooks");
            return;
        }

        try {
            int bookId = Integer.parseInt(request.getParameter("id"));
            BookDao dao = new BookDao();
            boolean result = dao.softDeleteBook(bookId, username, new Date());

            if (result) {
                session.setAttribute("message", "Book deleted successfully.");
            } else {
                session.setAttribute("message", "Failed to delete the book.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("message", "Error: " + e.getMessage());
        }

        response.sendRedirect("viewBooks");
    }
}
