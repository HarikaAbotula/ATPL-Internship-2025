package com.aaslin.library.controller;

import com.aaslin.library.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/updateBook")
public class UpdateBookServlet extends HttpServlet {
   
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");

        if (!"admin".equals(role)) {
            session.setAttribute("message", "Only admin can update books.");
            response.sendRedirect("viewBooks");
            return;
        }

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String isbn = request.getParameter("isbn");
            boolean available = Boolean.parseBoolean(request.getParameter("available"));

            BookDao dao = new BookDao();
            boolean updated = dao.updateBook(id, title, author, isbn, available);

            if (updated) {
                session.setAttribute("message", "Book updated successfully.");
            } else {
                session.setAttribute("message", "Update failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("message", "Error updating book.");
        }

        response.sendRedirect("viewBooks");
    }
}
