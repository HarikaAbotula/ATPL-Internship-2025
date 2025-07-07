import java.io.*;
public class IOExceptionDemo{
    public static void main(String args[])throws IOException {
        String fileName="D://Git Repo//password.txttt";
        BufferedReader bfr=null;
        try{
             bfr=new BufferedReader(new FileReader(fileName));
             String line;
             while((line=bfr.readLine())!=null){
                System.out.println("content: "+line);
             }
            }
         catch(IOException e){
            System.out.println("Error reading file: "+e.getMessage());
        }   
        finally {
            System.out.println("Finally block will always executed, irrespective of occurence of issue");
        }
    }
}