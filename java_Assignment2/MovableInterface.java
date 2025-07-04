//Define an interface Movable with method move(). Implement it in Car, Robot,and Drone.
interface Movable {
    void move();
}
class Car implements Movable{
    public void move(){
        System.out.println("Car is moving");
    }
}
class Robot implements Movable{
    public void move(){
        System.out.println("Robot is moving");
    }
}
class Drone implements Movable{
    public void move(){
        System.out.println("Drone is flying");
    }
}
public class MovableInterface{
    public static void main(String args[]){
        Car c1=new Car();
        Robot r1=new Robot();
        Drone d1=new Drone();
        c1.move();
        r1.move();
        d1.move();
    }
}
