//Create a Laptop class where the parameterized constructor sets brand, RAM, and processor. Use constructor overloading to provide flexibility.
public class Laptop{
    String brand;
    int RAM;
    String processor;
    Laptop(){
        brand="hp";
        RAM=8;
        processor="intel core i7";
    }
    public Laptop(String brand){
        this.brand=brand;
        this.RAM=16;

    }
    public Laptop(String brand,int RAM,String processor){
        this.brand=brand;
        this.RAM=RAM;
        this.processor=processor;
    }
    void display(){
        System.out.println("Brand name: "+brand + "RAM: "+ RAM + "processor: "+processor);
    }
    public static void main(String args[]){
        Laptop l1=new Laptop();
        l1.display();
        Laptop l2=new Laptop("dell",4,"intelcore i11");
        l2.display();
        Laptop l3=new Laptop("ACER");
        l3.display();
    }
}