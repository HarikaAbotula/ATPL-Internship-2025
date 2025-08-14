package com.aaslin.springinjection;

public class Book {
	private String title;
	private String author;
	private int isbn;
	
	public Book() {
		System.out.println("Book Deafult Constructor");
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
	public String toString() {
		return "Title of book: "+title+ "\nAuthor: "+author+ "\nISBN: "+isbn;
	}
	
}
