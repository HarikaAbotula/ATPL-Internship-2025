import java.util.Scanner;
public class ArithmeticExceptionDemo{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        int res;
        try{
           res=n1/n2; 
           System.out.println("Result: "+res);
        }
      catch(ArithmeticException ae){
        System.out.println("Division by zero Exception:" +ae.getMessage());
      }
      finally{
        System.out.println("Executedd irrrespective of try and catch blocks!!");
      }
    //System.out.println(n1/n2);
    sc.close();
    }
}