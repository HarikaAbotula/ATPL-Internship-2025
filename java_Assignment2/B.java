package b;

import a.A;

public class B extends A {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.defaultMsg);    // Not accessible
        System.out.println(a.protectedMsg);  // Not accessible via object

        // Access protected via inheritance
        B b = new B();
        System.out.println("Accessing protected via inheritance: " + b.protectedMsg); 
    }
}
