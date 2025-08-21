package com.aaslin.library.controller;

import com.aaslin.library.dao.BookDao;
import com.aaslin.library.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

//Servlet to fetch and display active books.
 
@WebServlet("/viewBooks")
public class ViewBooksServlet extends HttpServlet {
   
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao dao = new BookDao();
        List<Book> books = dao.getAllBooks();
        request.setAttribute("books", books);
        request.getRequestDispatcher("view_books.jsp").forward(request, response);
    }
}
