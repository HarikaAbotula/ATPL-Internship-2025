//Take input like " Java Programming" and perform: trim(),toLowerCase(),toUpperCase()
// replace("", "-") ,substring(), indexOf("a") 
import java.util.*;
public class StringMethods{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println("Trimming spaces: "+str.trim());
        System.out.println("Converting to lowercase: "+str.toLowerCase());
        System.out.println("Converting to uppercase: "+str.toUpperCase());
        System.out.println("space replaced with hyphen: "+str.replace("","-"));
        System.out.println("Returns substring from string: "+str.substring(4, 10));
        System.out.println("Index of a in string: "+str.indexOf("a"));
        sc.close();
    }
}