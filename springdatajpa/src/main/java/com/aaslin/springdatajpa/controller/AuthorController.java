package com.aaslin.springdatajpa.controller;

import com.aaslin.springdatajpa.entity.*;
import com.aaslin.springdatajpa.repository.*;
import com.aaslin.springdatajpa.service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/authors") // Base URL: /authors
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    // Create Author
    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    // Read All Authors
    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    // Update Author Name
    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestParam String newName) {
        return authorService.updateAuthor(id, newName);
    }

    // Delete Author
    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return "Author with ID " + id + " deleted successfully!";
    }

    // Custom Query 1: Find Authors by Name Prefix
    @GetMapping("/starts-with")
    public List<Author> getAuthorsByNamePrefix(@RequestParam String prefix) {
        return authorService.getAuthorsByNamePrefix(prefix);
    }

    // Custom Query 2: Find Authors with More Than X Books
    @GetMapping("/with-more-books")
    public List<Author> getAuthorsWithMoreThanBooks(@RequestParam int count) {
        return authorService.getAuthorsWithMoreThanBooks(count);
    }
}

