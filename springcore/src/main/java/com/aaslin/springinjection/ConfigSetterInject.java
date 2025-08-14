package com.aaslin.springinjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigSetterInject {
	@Bean
	public Book book() {
		Book books = new Book();
		books.setTitle("Spring Framework");
		books.setAuthor("Rod Johnson");
		books.setIsbn(23898);
		return books;
	}
	
	@Bean
	public Library library() {
		Library library = new Library();
		library.setBook(book());
		return library;
	}
}
