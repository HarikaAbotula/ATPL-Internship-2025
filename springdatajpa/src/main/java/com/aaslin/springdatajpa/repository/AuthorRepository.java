package com.aaslin.springdatajpa.repository;

import com.aaslin.springdatajpa.entity.Author;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthorRepository extends JpaRepository<Author, Long> {
	
	 // Custom Query - Authors whose name starts with letter
    @Query(value = "SELECT name FROM authorTable WHERE name LIKE :letter%", nativeQuery = true)
    List<Author> findAuthorsByStartingLetter(@Param("letter") String letter);

    // Custom Query - Authors with more than X books
    @Query("SELECT a FROM Author a WHERE SIZE(a.books) > :count")
    List<Author> findAuthorsWithMoreThanBooks(@Param("count") int count);
}
