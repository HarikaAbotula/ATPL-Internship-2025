//Use super to call a parent class constructor from a subclass.
class Parent{
    Parent(){
        System.out.println("Parent constructor called from child class using super");
    }
}
class Child extends Parent{
    Child(){
        super();
    }
}
public class Supermethod{
    public static void main(String args[]){
        Parent p=new Child();
    }
}