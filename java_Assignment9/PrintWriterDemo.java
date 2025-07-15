import java.io.*;
import java.util.*;

class Student{
    String name;
    int age;
    String department;
    double gpa;

    Student(String name,int age,String department,double gpa){
        this.name=name;
        this.age=age;
        this.department=department;
        this.gpa=gpa;
    }
}

public class PrintWriterDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try{
            PrintWriter printWriter = new PrintWriter("students.txt");
            for(int i=1;i<=5;i++){
                System.out.println("Enter student"+i+"details: ");
                System.out.println("Enter Student name");
                String name = scanner.next();

                System.out.println("Enter Student Age");
                int age=scanner.nextInt();

                System.out.println("Enter Student Department");
                String department=scanner.next();

                System.out.println("Enter Student GPA");
                double gpa=scanner.nextDouble();
                String formattedString = String.format("Student"+i+"[Name=%s, Age=%d, Department=%s, GPA=%.2f]",name,age,department,gpa);

            printWriter.println(formattedString);
            }
            printWriter.close();
        } 
        catch(IOException e){
            System.out.println("Error while reading the file: "+e.getMessage());
        } 
        scanner.close();
    }
}
