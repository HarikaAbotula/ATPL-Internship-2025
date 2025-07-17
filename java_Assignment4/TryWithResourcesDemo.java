import java.util.*;
import java.io.*;
public class TryWithResourcesDemo{
    public static void main(String args[]) {
       // Scanner sc=new Scanner(System.in);
        String fileName="D://Git Repo//password.txt";
        TryWithResourcesDemo obj = new TryWithResourcesDemo();
        try{
            obj.readFileSafely(fileName);
        }
        catch(IOException e){
            System.out.println("Error reading file: "+e.getMessage());
        }
    }

    public static void readFileSafely(String fileName) throws IOException{
        try(BufferedReader bfr=new BufferedReader(new FileReader(fileName));){
             String line;
             while((line=bfr.readLine())!=null){
                System.out.println("content: "+line);
             }
             bfr.close();
        }
            
        finally{
                System.out.println("Resources are autoclosable");
        }
    }    
}