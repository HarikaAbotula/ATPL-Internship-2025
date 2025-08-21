package com.aaslin.librarysystem.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaslin.librarysystem.model.Book;
import com.aaslin.librarysystem.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> getActiveBooks() {
		return bookRepository.findByIsActiveTrue();
	}

	public Optional<Book> findById(Integer bookId) {
		return bookRepository.findById(bookId);
	}

	public Book createNewBook(Book book, String createdBy) {
		book.setIsActive(true);
		book.setIsAvailable(true);
		book.setCreatedDate(LocalDateTime.now());
		book.setCreatedBy(createdBy);
		return bookRepository.save(book);
	}

	public Book updateBook(Book book, String updatedBy) {
		book.setUpdatedDate(LocalDateTime.now());
		book.setUpdatedBy(updatedBy);
		return bookRepository.save(book);
	}

	public void softDelete(Integer bookId, String updatedBy) {
		bookRepository.findById(bookId).ifPresent(book -> {
			book.setIsActive(false);
			book.setUpdatedDate(LocalDateTime.now());
			book.setUpdatedBy(updatedBy);
			bookRepository.save(book);
		});
	}

	public Book markAvailability(Book book, boolean isAvailable, String updatedBy) {
		book.setIsAvailable(isAvailable);
		book.setUpdatedDate(LocalDateTime.now());
		book.setUpdatedBy(updatedBy);
		return bookRepository.save(book);
	}
}


