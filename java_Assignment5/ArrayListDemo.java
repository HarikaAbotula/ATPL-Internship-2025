import java.util.*;
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("John");
        list.add("Ron");
        list.add("Harry");
        list.add("Hermoine");
        list.add("Dumbledore");
        
        System.out.println("Printing Elements using for loop");
        for(int index=0; index<list.size();index++){
            System.out.println(list.get(index));
        }

        System.out.println("Printing Elements using Enhanced for loop");
        for(String names : list){
            System.out.println(names);
        }

        //Removing 3rd element
        list.remove(3);
        System.out.println("The updated list,after removing 3rd element: "+list);

    }
}
