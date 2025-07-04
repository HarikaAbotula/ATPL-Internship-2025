//Create a class Library with a non-static inner class Book. Show how to instantiate and access inner class from outer.
class Library{
    class Book {
        String bName = "Harry Potter";
    }
}
public class InnerClass {
    public static void main(String[] args)
    {
        Library outer = new Library();   // Creating an instance of outer class
        Library.Book inner = outer.new Book();  // Creating an instance of inner class using outer class
        System.out.println("Accessing inner class data member,bookName: "+inner.bName);  // Accessing inner class data member
    }
}