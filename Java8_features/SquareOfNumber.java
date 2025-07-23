import java.util.ArrayList;

public class SquareOfNumber {
    public static void main(String[] args) {
        ArrayList<Integer> numberList = new ArrayList<>();
        for(int i=1;i<=5;i++){
            numberList.add(i);
        }
        System.out.println("Printing squares of each number");
        numberList.forEach(number -> System.out.print(number*number+ " "));
    }
}
