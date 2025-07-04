//Use this() to call one constructor from another within the same class.
public class UseThisMethod {
    private String name;
    private int age;

    public UseThisMethod(String name) {
        this(20);
        System.out.println("Name of person : " + name);
    }

    public UseThisMethod(int age){
        System.out.println("Age of person: " + age);
    }
    public UseThisMethod(){
        this("ThisMethod");
    }

    public static void main(String[] args)
    {
        UseThisMethod obj = new UseThisMethod();
    }
}