package com.aaslin.springdatajpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaslin.springdatajpa.entity.Author;
import com.aaslin.springdatajpa.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
    private AuthorRepository authorRepository;  

    // Author CRUD
    public Author createAuthor(Author author) { 
    	return authorRepository.save(author); 
    }
    
    public List<Author> getAllAuthors() { 
    	return authorRepository.findAll(); 
    }
    
    public Author updateAuthor(Long id, String newName) {
        Author author = authorRepository.findById(id).orElseThrow();
        author.setName(newName);
        return authorRepository.save(author);
    }
    
    public void deleteAuthor(Long id) { 
    	authorRepository.deleteById(id); 
    }
    
 // Custom Queries
    public List<Author> getAuthorsByNamePrefix(String prefix) {
        return authorRepository.findAuthorsByStartingLetter(prefix);
    }

    public List<Author> getAuthorsWithMoreThanBooks(int count) {
        return authorRepository.findAuthorsWithMoreThanBooks(count);
    }
}
