package com.aaslin.springinjection;

public class Faculty {
	private Course course;
	//Constructor
	public Faculty(Course course) {
		this.course=course;
		//System.out.println("Faculty constructor called");
	}
	public void showDetails() {
		System.out.println("Faculty teaches "+course.getCourseName());
	}
}
