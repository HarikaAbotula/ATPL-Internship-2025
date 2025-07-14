import java.io.*;

public class SerializableDemo {
    public static void main(String[] args) {
        Student s1 = new Student(101, "John");

        try {
            FileOutputStream fos = new FileOutputStream("Student.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(s1);  // Serialize the object
            oos.close();
            fos.close();

            System.out.println("Object has been serialized.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

