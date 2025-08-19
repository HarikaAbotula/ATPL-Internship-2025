package com.aaslin.springdatajpa.repository;

import com.aaslin.springdatajpa.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> { 
	
}

