
import java.io.*;
public class ThrowsException{
    public static void main(String args[]) {
        String fileName="D://Git Repo//password.txt";
        try{
            ThrowsException.readFile(fileName);
        }
        catch(IOException e){
            System.out.println("Error reading file: "+e.getMessage());
        }
    }

    public static void readFile(String fileName) throws IOException{
        BufferedReader bufferedReader=null;
        try{
             bufferedReader=new BufferedReader(new FileReader(fileName));
             String line;

             while((line=bufferedReader.readLine())!=null){
                System.out.println("content: "+line);
             }
             
        }
        finally{
            if(bufferedReader!=null){
                bufferedReader.close();
            }
        }    
    }
}