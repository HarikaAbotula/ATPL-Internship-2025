package com.aaslin.springdatajpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.aaslin.springdatajpa.entity.Author;
import com.aaslin.springdatajpa.entity.Book;
import com.aaslin.springdatajpa.repository.AuthorRepository;
import com.aaslin.springdatajpa.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	private AuthorRepository authorRepository;
	
	 	public Book createBook(Book book) { 
	    	return bookRepository.save(book); 
	    }
	    
	    public List<Book> getAllBooks() { 
	    	return bookRepository.findAll(); 
	    }
	    
	    public Book updateBook(Long id, String newTitle) {
	        Book book = bookRepository.findById(id).orElseThrow();
	        book.setTitle(newTitle);
	        return bookRepository.save(book);
	    }
	    
	    public void deleteBook(Long id) { 
	    	bookRepository.deleteById(id); 
	    }
	    
	    //custom queries
	    public List<Book> getBooksByAuthorName(String name) {
	    	return bookRepository.findBooksByAuthorName(name);
	    }

	    public List<Book> searchBooksByTitle(String title) {
	    	return bookRepository.searchBooksByTitle(title);
	    }
	    
	    //Part 3: Transactional (create book & link to existing author)
	    @Transactional
	    public Book createBookWithAuthor(Long authorId, String title, String genre) {
	        Optional<Author> opt = authorRepository.findById(authorId);
	        if (!opt.isPresent()) {
	            throw new RuntimeException("Author not found: " + authorId);
	        }
	        Author author = opt.get();

	        Book b = new Book();
	        b.setTitle(title);
	        b.setGenre(genre);
	        b.setAuthor(author);

	        // If any of these fails, transaction rolls back
	        return bookRepository.save(b);
	    }
	    
	 // Part 4: Pagination & Sorting
	    public Page<Book> getBooksByGenre(String genre, int page, int size) {
	        Pageable pageable = PageRequest.of(page, size);
	        return bookRepository.findByGenre(genre, pageable);
	    }

	    public List<Book> getBooksSortedByTitleAsc() {
	        return bookRepository.findAllByOrderByTitleAsc();
	    }

	    public List<Book> getBooksSortedByTitleDesc() {
	        return bookRepository.findAllByOrderByTitleDesc();
	    }

	    public List<Book> getBooksSortedByTitle(String direction) {
	        Sort sort = "desc".equalsIgnoreCase(direction) ? Sort.by("title").descending()
	                                                       : Sort.by("title").ascending();
	        return bookRepository.findAll(sort);
	    }
}
