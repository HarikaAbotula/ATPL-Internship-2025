//Sorting Strings 

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Sorting {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine(); 
        String[] arr= new String[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextLine(); //[apple,mango,Apple,kiwi,Kiwi]
        }
        Arrays.sort(arr);
        System.out.println("Ascending order: "+Arrays.toString(arr)); //[Apple, Kiwi, apple, kiwi, mango]
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println("Descending order: " + Arrays.toString(arr));//[mango, kiwi, apple, Kiwi, Apple]
        sc.close();
    }
}
