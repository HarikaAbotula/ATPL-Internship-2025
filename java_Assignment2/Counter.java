//Create a Counter class that increments a static variable every time a new object is created. Display total instances created.
public class Counter{
    private static int count=0;
    Counter(){
        count++;
        System.out.println("New object created: "+count);
    }
    public static int getCount(){
        return count;
    }
    public static void main(String args[]){
        Counter obj1=new Counter();
        Counter obj2=new Counter();
        System.out.println("Total Instances created: "+obj1.getCount());
    }
}