import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L; // version control

    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}
