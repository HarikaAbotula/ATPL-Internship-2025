package com.aaslin.springcore;

public class UniversityFaculty {
	private String name;
	private int id;
	//constructor
	public UniversityFaculty(String name,int id) {
		this.name=name;
		this.id=id;
	}
	
	public String toString() {
		return "Faculty Name: "+name+"\nFaculty ID: "+id;
	}
}
