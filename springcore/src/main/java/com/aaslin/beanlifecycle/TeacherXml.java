package com.aaslin.beanlifecycle;

public class TeacherXml {
	public TeacherXml() {
		System.out.println("Constructor TeacherXml Created");
	}
	public void customInit() {
		System.out.println("TeacherXml customInit() called");
	}
	
	public void customDestroy() {
		System.out.println("TeacherXml customDestroy() called");
	}
	
}
