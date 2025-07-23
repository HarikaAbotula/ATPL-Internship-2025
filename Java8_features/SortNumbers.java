import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortNumbers {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(5,2,8,1,9);
        System.out.println("Original List: "+numberList);

        // Sorting in descending order using lambda expression
        Comparator<Integer> comparator = (number2,number1) -> (number1<number2) ? -1 : (number1>number2) ? 1 : 0;
         
        Collections.sort(numberList,comparator); 
        System.out.println("Descending order List:" + numberList);  
     }
}
