package com.aaslin.springdatajpa.entity;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name="authortable")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // One author can have many books
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books;

    // Getters & Setters
    public Long getId() { 
    	return id; 
    }
    
    public void setId(Long id) {
    	this.id = id; 
    }

    public String getName() { 
    	return name; 
    }
    
    public void setName(String name) {
    	this.name = name; 
    }

    public List<Book> getBooks() { 
    	return books; 
    }
    public void setBooks(List<Book> books) {
    	this.books = books; 
    }
}

