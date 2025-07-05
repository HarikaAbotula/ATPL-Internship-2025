//Create a package a with class A, and package b with class B. Try accessing protected/default members from B.
package a;

public class A {
    protected String protectedMsg = "Protected in A";
    String defaultMsg = "Default in A"; 
}

