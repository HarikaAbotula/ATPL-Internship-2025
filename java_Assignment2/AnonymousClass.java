//Create an interface Greeting with method sayHello(). Use an anonymous class to implement and print a message.

interface Greeting {
    void sayHello();
}

public class AnonymousClass {
    public static void main(String[] args) {
        Greeting obj = new Greeting() {
            public void sayHello() {
                System.out.println("HI,THIS IS AN ANONYMOUS CLASS");
            }
        };
        obj.sayHello();
    }
}