package com.aaslin.springdatajpa.controller;

import com.aaslin.springdatajpa.entity.Book;
import com.aaslin.springdatajpa.entity.Author;
import com.aaslin.springdatajpa.repository.BookRepository;
import com.aaslin.springdatajpa.service.BookService;
import com.aaslin.springdatajpa.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books") // Base URL: /books
public class BookController {

    @Autowired
    private BookService bookService;

    // Create Book
    @PostMapping
    public Book createBook(@RequestBody Book book ,  @RequestParam Long authorId) {
        return bookService.createBookWithAuthor(authorId, book.getTitle(), book.getGenre());
    }

    // Read All Books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // Update Book Title
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestParam String newTitle) {
        return bookService.updateBook(id, newTitle);
    }

    // Delete Book
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "Book with ID " + id + " deleted successfully!";
    }

    // Custom Query 1: Find Books by Author Name
    @GetMapping("/by-author")
    public List<Book> getBooksByAuthorName(@RequestParam String name) {
        return bookService.getBooksByAuthorName(name);
    }

    // Custom Query 2: Search Books by Title
    @GetMapping("/search")
    public List<Book> searchBooksByTitle(@RequestParam String title) {
        return bookService.searchBooksByTitle(title);
    }
    
 // Pagination by Genre
    // Example: /books/genre?genre=Fantasy&page=0&size=10
    @GetMapping("/genre")
    public Page<Book> getBooksByGenre(@RequestParam String genre,
                                      @RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size) {
        return bookService.getBooksByGenre(genre, page, size);
    }

    // Part 4: Sorting by Title
    // Example: /books/sorted?dir=asc  or  /books/sorted?dir=desc
    @GetMapping("/sorted")
    public List<Book> getBooksSorted(@RequestParam(defaultValue = "asc") String dir) {
        return bookService.getBooksSortedByTitle(dir);
    }
}
