package com.aaslin.assignments;

import java.util.*;

class NameComparator implements Comparator<Student> {
  
	public int compare(Student s1, Student s2) {
        return s1.getName().compareToIgnoreCase(s2.getName());
    }
}

class MarksDescendingComparator implements Comparator<Student> {
    
	public int compare(Student s1, Student s2) {
        return Double.compare(s2.getMarks(), s1.getMarks());
    }
}

class AgeComparator implements Comparator<Student> {
    
	public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getAge(), s2.getAge());
    }
}

public class CustomObjectComparator {
   
	public static void main(String[] args) {
       
		List<Student> students = new ArrayList<>();
		
        students.add(new Student(101, "John", 32, 85.0));
        students.add(new Student(102, "Nancy", 32, 92.5));
        students.add(new Student(103, "Pradhan", 25, 72.8));
        students.add(new Student(104, "Ron", 28, 92.5));
        students.add(new Student(105, "Mike",18, 60.0));

        System.out.println("Original List:");
        for (Student s : students) {
            System.out.println(s);
        }

        // Sort by Name
        Collections.sort(students, new NameComparator());
        System.out.println("\nSorted by Name:");
        for (Student s : students) {
            System.out.println(s);
        }

        // Sort by Marks (Descending)
        Collections.sort(students, new MarksDescendingComparator());
        System.out.println("\nSorted by Marks (descending):");
        for (Student s : students) {
            System.out.println(s);
        }

        // Sort by Age (Ascending)
        Collections.sort(students, new AgeComparator());
        System.out.println("\nSorted by Age (ascending):");
        for (Student s : students) {
            System.out.println(s);
        }

        // Sort by Marks Descending, then Name Ascending (chained)
        Collections.sort(students, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                int markCompare = Double.compare(s2.getMarks(), s1.getMarks());
                if (markCompare == 0) {
                    return s1.getName().compareToIgnoreCase(s2.getName());
                }
                return markCompare;
            }
        });
        
        System.out.println("\nSorted by Marks (desc), then Name (asc):");
        for (Student s : students) {
            System.out.println(s);
        }

        // Sort integers in descending order using anonymous Comparator
        List<Integer> numbers = Arrays.asList(10, 3, 5, 7, 2, 9);
        numbers.sort(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        
        System.out.println("\nIntegers sorted in descending order:");
        for (Integer n : numbers) {
            System.out.println(n);
        }
    }
}


