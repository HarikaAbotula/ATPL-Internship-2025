package samepackage;

public class AccessModifiersDemo {
    private String privateVar = "Private";
    String defaultVar = "Default";
    protected String protectedVar = "Protected";
    public String publicVar = "Public";

    public void accessWithinSameClass() {
        System.out.println("Same Class:");
        System.out.println(privateVar);    // Access private var within same class
        System.out.println(defaultVar);    // Access def var within same class
        System.out.println(protectedVar);  // Access protected var within same class
        System.out.println(publicVar);     // Access public var within same class
    }
}

