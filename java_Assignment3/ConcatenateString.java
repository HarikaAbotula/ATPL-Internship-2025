//Concatenate Strings,Measure and compare performance using System.nanoTime().
import java.util.*;
public class ConcatenateString{
    public static void main(String args[]){
       List<String> str=Arrays.asList("How","are","you");
        long startTime = System.nanoTime();
       String concatedString="";
       for(int i=0;i<str.size();i++){
         concatedString+=str.get(i);
       }
        long endTime = System.nanoTime();
       System.out.println("Concatenated String: "+concatedString);
       System.out.println("Time taken (+ operator): " + (endTime - startTime) + " nanoseconds");

        //String buffer
       startTime = System.nanoTime();
       StringBuffer sbf=new StringBuffer();
       for(int i=0;i<str.size();i++){
         sbf.append(str.get(i));
       }
       endTime = System.nanoTime();
       System.out.println("Concatenated String (StringBuffer): " + sbf.toString());
       System.out.println("Time taken (StringBuffer): " + (endTime - startTime) + " nanoseconds");

       //String builder
       startTime = System.nanoTime();
       StringBuilder sb=new StringBuilder();
       for(int i=0;i<str.size();i++){
         sb.append(str.get(i));
       }
       endTime = System.nanoTime();
       System.out.println("Concatenated String (StringBuilder): " + sb.toString());
       System.out.println("Time taken (StringBuilder): " + (endTime - startTime) + " nanoseconds");

    }
}