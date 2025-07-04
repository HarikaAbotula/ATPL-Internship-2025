//Create an abstract class Appliance with methods turnOn() and turnOff().Implement it in Fan, TV.
abstract class Appliance{
    public abstract void turnOn();
    public abstract void turnOff();
}
class Fan extends Appliance{
    public void turnOn(){
        System.out.println("Fan turned ON");
    }
     public void turnOff(){
        System.out.println("Fan turned OFF");
    }
}
class TV extends Appliance{
    public void turnOn(){
        System.out.println("TV turned ON");
    }
     public void turnOff(){
        System.out.println("TV turned OFF");
    }
}
public class ApplianceAbstract{
    public static void main(String args[]){
        Appliance fan=new Fan();
        Appliance tv=new TV();
        fan.turnOn();
        fan.turnOff();
        tv.turnOn();
        tv.turnOff();
    }
}
