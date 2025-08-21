package com.aaslin.library.controller;

import com.aaslin.library.dao.IssuedBookDao;
import com.aaslin.library.model.IssuedBook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@WebServlet("/issueBook")
public class IssueBookServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int bookId = Integer.parseInt(request.getParameter("book_id"));
            int userId = Integer.parseInt(request.getParameter("user_id"));
            Date issueDate = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(issueDate);
            cal.add(Calendar.DAY_OF_MONTH, 14);
            Date dueDate = cal.getTime();
            String notes = request.getParameter("notes");

            

            IssuedBook ib = new IssuedBook();
            ib.setBookId(bookId);
            ib.setUserId(userId);
            ib.setIssueDate(issueDate);
            ib.setDueDate(dueDate);
            ib.setReturned(false);
            ib.setNotes(notes);
            ib.setCreatedDate(issueDate);
            ib.setCreatedBy("admin");
            ib.setUpdatedDate(issueDate);
            ib.setUpdatedBy("admin");

            IssuedBookDao dao = new IssuedBookDao();
            boolean result = dao.issueBook(ib);

            request.setAttribute("message", result ? "Book issued successfully! Due Date: " + new SimpleDateFormat("yyyy-MM-dd").format(dueDate) : "Failed to issue book.");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Error: " + e.getMessage());
        }
        request.getRequestDispatcher("issue_book.jsp").forward(request, response);
    }
}
