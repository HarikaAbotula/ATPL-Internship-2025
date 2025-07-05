package samepackage;

public class SamePackageTest {
    public static void main(String[] args) {
        AccessModifiersDemo obj = new AccessModifiersDemo();

        System.out.println("Same Package:");
        System.out.println(obj.privateVar);   // Compile error
        System.out.println(obj.defaultVar);      // Accessible within same package
        System.out.println(obj.protectedVar);    // Accessible within same package
        System.out.println(obj.publicVar);       // Accessible within same package
    }
}
