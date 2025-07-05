//Given "Learning Java is fun and interesting" perform:Count number of words using split() 
//Find first and last occurrence of "i" using indexOf() & lastIndexOf(),Check if it starts with "Learn" and ends with "ing" 

import java.util.Scanner;

public class AnalyzeSentence{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] arr=str.split("[\\s]");
        int count=0;
        for(String s:arr){
            count++;
            System.out.println(s);
        }
        System.out.println("Count of words after splitting:"+count);
        sc.close();
    }
}