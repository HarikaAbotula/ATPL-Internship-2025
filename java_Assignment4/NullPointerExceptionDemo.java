import java.io.*;
public class NullPointerExceptionDemo{
    public static void main(String args[]){
        String str1=null;
        // try{
        //     System.out.println(str1.equals("matches"));
           
        // }
        // catch(NullPointerException npe){
        //     System.out.println("Cannot comparing the values with null: "+npe.getMessage());
        // }
        System.out.println(str1.equals("matches"));
    }
}