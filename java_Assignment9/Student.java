import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L; // version control

    private int id;
    private String name;
    private int age;
    private String department;
    private double gpa;

    public Student(int id, String name,int age, String department,double gpa) {
        this.id = id;
        this.name = name;
        this.age=age;
        this.department=department;
        this.gpa=gpa;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Department: " + department + ", GPA: " + gpa;
    }
}
