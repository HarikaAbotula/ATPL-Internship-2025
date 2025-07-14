import java.io.*;

public class DeserializeDemo {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("Student.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Student s2 = (Student) ois.readObject();  // Deserialize the object

            ois.close();
            fis.close();

            System.out.println("Deserialized Object: " + s2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
