package com.aaslin.assignments;
import java.util.*;
public class EmployeeSkillTracker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Set<String>> empSkills= new HashMap<>();
		
		empSkills.put("John",new  HashSet<>(Arrays.asList("Java","Python","Ruby","SQL")));
		empSkills.put("Harry",new HashSet<>(Arrays.asList("Python","RubyOnRails")));
		empSkills.put("Nancy",new HashSet<>(Arrays.asList("C++","Microservices","Machine Learnng")));
		empSkills.put("Steve",new HashSet<>(Arrays.asList("Java","C","SQL")));
		
		//Specific skill
		String specificSkill="Java"; 
		System.out.println("Employees with Specific skill " + specificSkill + ":");
		for(Map.Entry<String,Set<String>> entry : empSkills.entrySet()) {
			if(entry.getValue().contains(specificSkill)) {
				System.out.println(entry.getKey());
			}
		}
		//Fetching common skills between two employees
		Set<String> skillsA = empSkills.get("John");
		Set<String> skillsB = empSkills.get("Steve");
		
		Set<String> common = new HashSet<>(skillsA);
        common.retainAll(skillsB);
        System.out.println("Common skills between John and Steve: " + common);
	}
}
