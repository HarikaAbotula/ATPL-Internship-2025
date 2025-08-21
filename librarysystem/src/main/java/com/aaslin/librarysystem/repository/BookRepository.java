package com.aaslin.librarysystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aaslin.librarysystem.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByIsActiveTrue();
}