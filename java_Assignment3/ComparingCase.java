//Case-sensitive and case-insensitive comparison 

import java.util.Scanner;

public class ComparingCase {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1="Java";
        String s2="java";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));
        //comparison is case-sensitive, so 'J' (74) and 'j' (106) are treated differently.
        System.out.println(s1.compareTo(s2));//-32,becoz unicode values(106-74);why neg? "J" comes before "j"
        sc.close();
    }
}
