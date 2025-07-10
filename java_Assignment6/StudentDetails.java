package com.aaslin.assignments;
import java.util.*;
public class StudentDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Integer> studentMap = new HashMap<>();
		studentMap.put("John",80);
		studentMap.put("Ron",89);
		studentMap.put("Jessy",93);
		studentMap.put("Nancy",77);
		studentMap.put("Steve",68);
		
		String topStudent="";
		String lowStudent="";
		int maxMarks=Integer.MIN_VALUE;
		int minMarks=Integer.MAX_VALUE;
		
		for(Map.Entry<String,Integer> entry : studentMap.entrySet()) {
			if(entry.getValue() > maxMarks) {
				maxMarks=entry.getValue();
				topStudent = entry.getKey();
			}
			if(entry.getValue() < minMarks) {
				minMarks=entry.getValue();
				lowStudent = entry.getKey();
			}		
		}
		System.out.println("Student "+topStudent+" got highest marks: "+ maxMarks);
		System.out.println("Student "+lowStudent+" got highest marks: "+ minMarks);	
		scanner.close();
	}

}

