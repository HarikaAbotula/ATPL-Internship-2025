package com.aaslin.springdatajpa.repository;

import com.aaslin.springdatajpa.entity.Book;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	   // Custom Query - Find books by author name
    @Query("SELECT b FROM Book b WHERE b.author.name = :authorName")
    List<Book> findBooksByAuthorName(@Param("authorName") String authorName);

    // Custom Query - Search books by title
    @Query("SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Book> searchBooksByTitle(@Param("keyword") String keyword);
    
    // Find books by genre with pagination
    Page<Book> findByGenre(String genre, Pageable pageable);

    // Sort by title
    List<Book> findAllByOrderByTitleAsc();
    List<Book> findAllByOrderByTitleDesc();
}

