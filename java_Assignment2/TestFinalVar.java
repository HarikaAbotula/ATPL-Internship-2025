//Create a class with a final variable and show it cannot be reassigned.
public class TestFinalVar{
    final static int a=10;
    public static void main(String args[]){
        a=11; //cannot reassign a value to final var
        System.out.println(a);
    }
}