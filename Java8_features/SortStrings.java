import java.util.*;
public class SortStrings {
    public static void main(String[] args) {

        ArrayList<String> fruitsList = new ArrayList<>();

        fruitsList.add("Banana");
        fruitsList.add("Apple");
        fruitsList.add("Mango");
        fruitsList.add("Cherry");

        System.out.println("Elements in list: "+fruitsList);
        Collections.sort(fruitsList,(string1,string2) -> string1.compareTo(string2));
        System.out.println("Elements in Ascending order: "+fruitsList);

         Collections.sort(fruitsList,(string1,string2) -> string2.compareTo(string1));
         System.out.println("Elements in Descending order: "+fruitsList);
    }
}
