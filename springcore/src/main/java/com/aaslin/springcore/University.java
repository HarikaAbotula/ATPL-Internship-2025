package com.aaslin.springcore;

public class University {
	private UniversityFaculty universityFaculty;
	private UniversityLibrary universityLibrary;
	
	public University(UniversityFaculty universityFaculty) {
		this.universityFaculty=universityFaculty;
		System.out.println("University Faculty constructor called");
	}
	
	public void setUniversityLibrary(UniversityLibrary universityLibrary) {
		this.universityLibrary=universityLibrary;
		System.out.println("University setLibrary() called");
	}
	
	public void showDetails() {
		System.out.println("Faculty Details: "+universityFaculty);
		System.out.println("Library Details: "+universityLibrary);
	}
}
