import java.io.*;

public class SerializableDemo {
    public static void main(String[] args) {
        Student studentOne = new Student(101, "John",23,"CSE",9.8);
        Student studentTwo = new Student(102, "Ron",21,"CSE",8.8);
        Student studentThree = new Student(103, "Jessy",21,"ECE",7.9);
        Student studentFour = new Student(104, "Steve",22,"IT",8.7);
        Student studentFive = new Student(105, "Nancy",21,"CSE",8.2);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("student.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(studentOne); 
            objectOutputStream.writeObject(studentTwo); // Serialize the object
            objectOutputStream.writeObject(studentThree);
            objectOutputStream.writeObject(studentFour);
            objectOutputStream.writeObject(studentFive);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Object has been serialized.");
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

