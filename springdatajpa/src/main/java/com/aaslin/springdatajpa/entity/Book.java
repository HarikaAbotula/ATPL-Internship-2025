package com.aaslin.springdatajpa.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="booktable")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String genre;

    // Many books can belong to one author
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
    
 // Many-to-many with Publisher
    @ManyToMany
    @JoinTable(
        name = "book_publisher",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "publisher_id")
    )
    private List<Publisher> publishers;

    public Long getId() { 
    	return id; 
    }
    
    public void setId(Long id) { 
    	this.id = id; 
    }

    public String getTitle() {
    	return title; 
    }
    
    public void setTitle(String title) {
    	this.title = title; 
    }

    public String getGenre() { 
    	return genre; 
    }
    
    public void setGenre(String genre) {
    	this.genre = genre;
    }

    public Author getAuthor() { 
    	return author; 
    }
    public void setAuthor(Author author) {
    	this.author = author; 
    }
    
    public List<Publisher> getPublishers() { 
    	return publishers; 
    }
    public void setPublishers(List<Publisher> publishers) { 
    	this.publishers = publishers; 
    }
}
