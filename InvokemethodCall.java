//Use super to invoke a method from the parent class that has been overridden in the child class.

class Parent{
   public void methodOne()
   {
     System.out.println("super incoked to call method from parent");
   }
}

class Child extends Parent{
   public void methodOne()
   {
      super.methodOne();
      System.out.println("B");
   }
}
public class InvokemethodCall{
    public static void main(String args[]){
    Parent p=new Child();
    p.methodOne();
}
}
