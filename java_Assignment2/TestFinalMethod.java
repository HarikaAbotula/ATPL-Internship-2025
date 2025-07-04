//Create a class with a final method and try to override it — observe compile-time error.
class Parent{
    public final void testOverride(){
        System.out.println("can't override the final method");
    }
}
class Child extends Parent{
     public final void testOverride(){
        System.out.println("Trying to override the final meethod");
    }
}
public class TestFinalMethod{
    public static void main(String args[]){
        Parent p=new Child();
    }
}
