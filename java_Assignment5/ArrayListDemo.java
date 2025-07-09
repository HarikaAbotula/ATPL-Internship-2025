import java.util.*;
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> list =new ArrayList<>();
        list.add("Apple");
        list.add("Mango");
        list.add("grapes");
        list.add("kiwi");
        list.add("banana");
        System.out.println("Printing using for loop: ");
        for(int index=0;index<list.size();index++){
            System.out.println(list.get(index));
        }
        //enhanced loop
         System.out.println("Printing using for each loop: ");
        for(String values: list){
             System.out.println(values);
        }
        //removing 3rd element
        System.out.println("The updated list, after removing 3rd element from the list: "+list.remove(2));
        
    }
}
