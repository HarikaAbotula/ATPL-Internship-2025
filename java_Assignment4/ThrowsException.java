import java.util.Scanner;
import java.io.*;
public class ThrowsException{
    public static void main(String args[]) {
       // Scanner sc=new Scanner(System.in);
        String fileName="D://Git Repo//password.txt";
        ThrowsException obj=new ThrowsException();
        try{
            obj.readFile(fileName);
        }
        catch(IOException e){
            System.out.println("Error reading file: "+e.getMessage());
        }
    }

    public static void readFile(String fileName) throws IOException{
        BufferedReader bfr=null;
        try{
             bfr=new BufferedReader(new FileReader(fileName));
             String line;
             while((line=bfr.readLine())!=null){
                System.out.println("content: "+line);
             }
            }
        finally{
            if(bfr!=null){
                bfr.close();
            }
        }    
    }
}