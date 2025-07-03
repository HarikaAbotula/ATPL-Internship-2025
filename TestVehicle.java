//Create a Vehicle class and extend it with Bike and Car classes. Override a method like start() in each subclass.
 class Vehicle{
     public void start(){
        System.out.println("Start Vehicle");
     }
}
 class Bike extends Vehicle{
    public void start(){
        System.out.println("Start Bike");
     }
}
 class Car extends Vehicle{
    public void start(){
        System.out.println("Start Car");
    }
}
public class TestVehicle{
 public static void main(String args[]){
    Vehicle ob1 = new Vehicle();
    ob1.start();
    Vehicle ob2 = new Car();
    ob2.start();
   }
}