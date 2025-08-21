package com.aaslin.librarysystem.controller;

import com.aaslin.librarysystem.model.Book;
import com.aaslin.librarysystem.model.IssuedBook;
import com.aaslin.librarysystem.model.User;
import com.aaslin.librarysystem.repository.IssuedBookRepository;
import com.aaslin.librarysystem.service.BookService;
import com.aaslin.librarysystem.service.IssuedBookService;
import com.aaslin.librarysystem.service.UserService;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IssuedBookRepository issuedBookRepo; // still used for a few direct lookups

    @Autowired
    private BookService bookService;

    @Autowired
    private IssuedBookService issuedBookService;

    @Autowired
    private UserService userService;

    // View all books
    @GetMapping("/books")
    public String viewBooks(Model model) {
        model.addAttribute("books", bookService.getActiveBooks());
        model.addAttribute("issuedBooks", issuedBookService.getOpenIssues());
        return "admin-dashboard";
    }

    // Issued books page with search
    @GetMapping("/issued")
    public String issuedBooks(@RequestParam(required = false) String userNum, Model model) {
        model.addAttribute("query", userNum);
        if (userNum == null || userNum.isBlank()) {
            model.addAttribute("records", null);
            return "issuedBooks";
        }

        // validate user num existence
        boolean userExists = userService.exists(userNum);
        if (!userExists) {
            model.addAttribute("error", "User number not found. Enter a valid number.");
            model.addAttribute("records", null);
            return "issuedBooks";
        }

        var records = issuedBookService.getUserHistory(userNum);
        if (records == null || records.isEmpty()) {
            model.addAttribute("info", "No books found for this user number.");
        }
        model.addAttribute("records", records);
        return "issuedBooks";
    }

    // Add a new book
    @GetMapping("/books/add")
    public String addBookForm() {
        return "addBooks";
    }

    // Add a new book
    @PostMapping("/books/add")
    public String addBook(@ModelAttribute Book book, Model model) {
        bookService.createNewBook(book, "admin");
        model.addAttribute("success", "Book added successfully");
        return "addBooks";
    }

    // Edit book form
    @GetMapping("/books/edit/{id}")
    public String editBook(@PathVariable Integer id, Model model) {
        bookService.findById(id).ifPresent(b -> model.addAttribute("book", b));
        return "editBook";
    }

    // Update book
    @PostMapping("/books/update")
    public String updateBook(@ModelAttribute Book book, Model model) {
        Book saved = bookService.updateBook(book, "admin");
        model.addAttribute("book", saved);
        model.addAttribute("success", "Book updated successfully");
        return "editBook";
    }

    // Soft delete book
    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable Integer id) {
        bookService.softDelete(id, "admin");
        return "redirect:/admin/books";
    }

    // Issue book to user
    @GetMapping("/books/issue/{bookId}")
    public String issueBookForm(@PathVariable Integer bookId, Model model) {
        Book book = bookService.findById(bookId).orElse(null);
        if (book == null) {
            model.addAttribute("error", "Book not found");
        } else if (!Boolean.TRUE.equals(book.getIsAvailable())) {
            model.addAttribute("error", "Book is currently not available");
        }
        model.addAttribute("book", book);
        return "issueBook";
    }

    @PostMapping("/books/issue")
    @Transactional
    public String issueBook(@RequestParam Integer bookId,
                            @RequestParam String userNum,
                            @RequestParam(required = false) String notes,
                            Model model) {
        Book book = bookService.findById(bookId).orElse(null);
        User user = userService.findByUserNum(userNum).orElse(null);

        if (book == null || user == null) {
            model.addAttribute("error", "Invalid book or user");
            model.addAttribute("book", book);
            return "issueBook";
        }
        if (!Boolean.TRUE.equals(book.getIsAvailable())) {
            model.addAttribute("error", "Book is currently not available");
            model.addAttribute("book", book);
            return "issueBook";
        }

        bookService.markAvailability(book, false, "admin");
        IssuedBook issuedBook = issuedBookService.issueBook(book, user, notes, "admin");

        model.addAttribute("book", book);
        model.addAttribute("success", "Book issued successfully");
        model.addAttribute("dueDate", issuedBook.getDueDate());
        return "issueBook";
    }

    // Return book
    @PostMapping("/books/return")
    @Transactional
    public String returnBook(@RequestParam Integer issueId) {
        IssuedBook issued = issuedBookRepo.findById(issueId).orElse(null);
        if (issued != null && !issued.getIsReturned()) {
            issuedBookService.markReturned(issued, "admin");
            Book book = issued.getBook();
            bookService.markAvailability(book, true, "admin");
        }
        return "redirect:/admin/books";
    }

    // Return book by bookId (convenient from table)
    @PostMapping("/books/returnByBook")
    @Transactional
    public String returnByBook(@RequestParam Integer bookId) {
        IssuedBook issued = issuedBookService.getActiveIssueForBook(bookId);
        if (issued != null) {
            issuedBookService.markReturned(issued, "admin");
            Book book = issued.getBook();
            bookService.markAvailability(book, true, "admin");
        }
        return "redirect:/admin/books";
    }

    // Show return form by bookId
    @GetMapping("/books/return/{bookId}")
    public String returnBookForm(@PathVariable Integer bookId, Model model) {
        IssuedBook issued = issuedBookService.getActiveIssueForBook(bookId);
        if (issued == null) {
            model.addAttribute("error", "No active issue found for this book");
            return "returnBook";
        }
        model.addAttribute("issued", issued);
        model.addAttribute("today", LocalDate.now());
        return "returnBook";
    }

    // Confirm return
    @PostMapping("/books/returnConfirm")
    @Transactional
    public String returnBookConfirm(@RequestParam Integer issueId, Model model) {
        IssuedBook issued = issuedBookRepo.findById(issueId).orElse(null);
        if (issued == null || Boolean.TRUE.equals(issued.getIsReturned())) {
            model.addAttribute("error", "Invalid or already returned issue record");
            return "returnBook";
        }

        issuedBookService.markReturned(issued, "admin");
        Book book = issued.getBook();
        bookService.markAvailability(book, true, "admin");

        model.addAttribute("issued", issued);
        model.addAttribute("today", LocalDate.now());
        model.addAttribute("success", "Book returned successfully");
        return "returnBook";
    }
}
