import java.util.*;
public class EvenOddCount{
    public static void main(String args[]){
        int oddCount=0;
        int evenCount=0;
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0){
               evenCount++;
            }
            else{
                oddCount++;
            }
        }
        System.out.println("Even Count: "+evenCount);
        System.out.println("Odd Count: "+oddCount);
    }
}