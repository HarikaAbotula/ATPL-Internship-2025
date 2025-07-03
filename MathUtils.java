//Create a MathUtils class with overloaded methods calculate(int a, int b) for addition, and calculate(double a, double b) for multiplication.
public class MathUtils{

    public int calculate(int a,int b){
        return a+b;
    }
    public double calculate(double a,double b){
        return a*b;
    }
    public static void main(String args[]){
       MathUtils obj1=new MathUtils();
       int sum=obj1.calculate(2,3);
       System.out.println("Addition of two numbers: "+sum);
       double res=obj1.calculate(2.00,4.00);
       System.out.println("Multiplication of two nums: "+res);
    }
}
