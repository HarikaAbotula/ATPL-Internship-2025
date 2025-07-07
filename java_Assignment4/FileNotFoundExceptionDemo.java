import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class FileNotFoundExceptionDemo {
    public static void main(String[] args) throws IOException{
        FileReader fr=null;
        try {
            fr = new FileReader("password.txt");
            System.out.println("File opened successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Caught FileNotFoundException: " + e.getMessage());
        }
    }
}
