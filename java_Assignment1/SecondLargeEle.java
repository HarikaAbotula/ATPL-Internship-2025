import java.util.*;
public class SecondLargeEle {
   public static void main(String args[]){
     Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr = new int[n];
         if(n<2){
         System.out.println("Array must contain atleast two elements");
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
       
      int max = arr[0];
      int secondmax = Integer.MIN_VALUE;
      for(int i=1;i<arr.length;i++){
         if(arr[i]>max){
            secondmax=max;
            max=arr[i];
         }
         else if (arr[i] > secondmax && arr[i] != max) {
            secondmax = arr[i];
         }
      }
      System.out.println("The second largest number is: "+secondmax);
   }
}