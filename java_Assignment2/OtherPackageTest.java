package otherpackage;

import samepackage.AccessModifiersDemo;

public class OtherPackageTest extends AccessModifiersDemo {
    public static void main(String[] args) {
        AccessModifiersDemo obj = new AccessModifiersDemo();

        System.out.println(obj.privateVar);     // Not accessible from other package
        System.out.println(obj.defaultVar);     // Not accessible from other package
        System.out.println(obj.protectedVar);   //Not accessible via obj
        System.out.println(obj.publicVar);         // Accessible from other package

        // Access protected via inheritance
        OtherPackageTest subclassObj = new OtherPackageTest();
        System.out.println("Accessing protected via inheritance: " + subclassObj.protectedVar); 
    }
}

