//Reverse a String using all 3 approaches 
import java.util.*;
public class ReverseOfString{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        char[] arr=str.toCharArray();
        for(int i=arr.length-1;i>=0;i--){
            System.out.print(arr[i]);
        }
        StringBuilder sb = new StringBuilder(str);
        System.out.println("\nReverse of String using StringBuilder reverse : "+sb.reverse());
        StringBuffer sbf = new StringBuffer(str);
         System.out.println("\nReverse of String using StringBuffer reverse : "+sbf.reverse());
         sc.close();
    }
}
