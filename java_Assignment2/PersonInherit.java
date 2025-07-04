//Build a Person class and extend it with Student and Teacher. Implement common methods and add role-specific behavior.

class Person{
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
     void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
class Student extends Person{
     String grade;
     int stdId;
    Student(String name, int age, String grade,int stdId) {
        super(name, age);
        this.grade = grade;
        this.stdId=stdId;
    }
    void study() {
        System.out.println(name + " holding ID " + stdId + " got "+ grade + " grade ");
    }
     void displayInfo() {
        super.displayInfo();
        System.out.println("Grade: " + grade);
    }

}
class Teacher extends Person {
    String subject;
    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    void teach() {
        System.out.println(name + " is teaching " + subject);
    }
    void displayInfo() {
        super.displayInfo();
        System.out.println("Subject: " + subject);
    }
}
public class PersonInherit {
    public static void main(String[] args) {
        Student s = new Student("Hary", 15, "A",101);
        Teacher t = new Teacher("Mr.Sharon", 40, "Math");

        System.out.println("Student Info ");
        s.displayInfo();
        s.study();

        System.out.println("\nTeacher Info");
        t.displayInfo();
        t.teach();
    }
}