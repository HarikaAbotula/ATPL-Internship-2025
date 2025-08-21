package com.aaslin.library.controller;

import com.aaslin.library.dao.BookDao;
import com.aaslin.library.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Servlet to handle book addition form.
 
@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Book book = new Book();
            book.setBookId(Integer.parseInt(request.getParameter("book_id")));
            book.setTitle(request.getParameter("title"));
            book.setAuthor(request.getParameter("author"));
            book.setIsbn(request.getParameter("isbn"));
            book.setAvailable(true);
            book.setActive(true);

            Date now = new Date();
            book.setCreatedDate(now);
            book.setUpdatedDate(now);
            book.setCreatedBy("admin");
            book.setUpdatedBy("admin");

            BookDao dao = new BookDao();
            boolean result = dao.addBook(book);

            if (result) {
                request.setAttribute("message", "Book added successfully!");
            } else {
                request.setAttribute("message", "Error while adding book.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Exception occurred: " + e.getMessage());
        }
        request.getRequestDispatcher("add_book.jsp").forward(request, response);
    }
}
