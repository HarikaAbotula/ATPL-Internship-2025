package com.aaslin.library.controller;

import com.aaslin.library.dao.IssuedBookDao;
import com.aaslin.library.model.IssuedBook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewAllIssuedBooks")
public class ViewAllIssuedBooksServlet extends HttpServlet {
   
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userIdParam = request.getParameter("userId");
        IssuedBookDao dao = new IssuedBookDao();
        List<IssuedBook> issuedBooks;

        if (userIdParam != null && !userIdParam.trim().isEmpty()) {
            try {
                int userId = Integer.parseInt(userIdParam);
                issuedBooks = dao.getIssuedBooksByUserId(userId);
            } catch (NumberFormatException e) {
                issuedBooks = dao.getAllIssuedBooks();
                request.setAttribute("message", "Invalid user ID entered.");
            }
        } else {
            issuedBooks = dao.getAllIssuedBooks();
        }

        request.setAttribute("issuedBooks", issuedBooks);
        request.getRequestDispatcher("view_all_issued_books.jsp").forward(request, response);
    }
}
