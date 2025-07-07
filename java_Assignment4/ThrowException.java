import java.util.Scanner;
public class ThrowException{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        checkPositive(num);
        sc.close();
    }
    public static void checkPositive(int num){
        if(num<0){
            throw new IllegalArgumentException("Number cannot br negative");
        }
        System.out.println(num+" is postive number");
    }
}