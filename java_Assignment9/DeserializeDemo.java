import java.io.*;

public class DeserializeDemo {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("student.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Student studentobject1 = (Student) objectInputStream.readObject();  // Deserialize the object
            Student studentobject2 = (Student) objectInputStream.readObject(); 
            Student studentobject3 = (Student) objectInputStream.readObject(); 
            Student studentobject4 = (Student) objectInputStream.readObject(); 
            Student studentobject5 = (Student) objectInputStream.readObject(); 

            objectInputStream.close();
            fileInputStream.close();

            System.out.println("Deserialized Object: " + studentobject1);
            System.out.println("Deserialized Object: " + studentobject2);
            System.out.println("Deserialized Object: " + studentobject3);
            System.out.println("Deserialized Object: " + studentobject4);
            System.out.println("Deserialized Object: " + studentobject5);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
