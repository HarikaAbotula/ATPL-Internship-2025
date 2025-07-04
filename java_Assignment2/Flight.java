//Create a Flight class with default and parameterized constructors. Include fields like flightNumber, destination, and duration. Create objects using both constructors.

public class Flight{
    int flightNum;
    String destination;
    String duration;
    Flight(){
        flightNum=100;
        destination="hyderabad";
        duration="one hour";
    }
    public Flight(int flightNum,String dest,String duration){
        this.flightNum=flightNum;
        this.destination=dest;
        this.duration=duration;
    }
    void display(){
        System.out.println("FlightNumber: "+flightNum +" destination: "+ destination +" duration: " + duration);
    }
    public static void main(String args[]){
        Flight f1=new Flight();//default constructor
        f1.display();
        Flight f2=new Flight(101,"vizag","2 hrs");//parameterized constructor
        f2.display();

    }
}