package com.aaslin.springinjection;

public class Library {
	private Book book;
	//Setter
	public void setBook(Book book) {
		this.book=book;
	}
	
	public void display() {
		System.out.println("Available books in library");
		System.out.println(book);
	}
}
