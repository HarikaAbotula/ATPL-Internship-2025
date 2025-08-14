package com.aaslin.springcore;

public class College {
	private String collegeName;
	
	public College() {
		System.out.println("College default constructor");
	}
	
	public College(String collegeName) {
		this.collegeName=collegeName;
	}
	
	public void setCollegeName(String collegeName) {
		this.collegeName=collegeName;
	}
	
	public void displayCollegeName() {
		System.out.println("College Name: "+collegeName);
	}
	
}
