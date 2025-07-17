import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class FileNotFoundExceptionDemo {
    public static void main(String[] args) throws IOException{
        FileReader fileReader=null;
        try {
            fileReader = new FileReader("password.txt");
            System.out.println("File opened successfully.");
            fileReader.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("Caught FileNotFoundException: " + e.getMessage());
        }
    }
}
