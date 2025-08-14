package com.aaslin.springcore;

public class UniversityLibrary {
	String sectionName;
	int countOfBooks;
	
	public UniversityLibrary() {
		System.out.println("Library Default Constructor");
	}
	//setter
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
		System.out.println("Library setSectionName() called");
	}
	
	public void setCountOfBooks(int countOfBooks) {
		this.countOfBooks = countOfBooks;
	}
	
	public String toString() {
		return "Section Name: "+sectionName+"\nCount of Books: "+countOfBooks;
	}
	
	
	
	
}
