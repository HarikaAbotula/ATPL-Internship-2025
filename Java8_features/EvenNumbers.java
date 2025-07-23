import java.util.ArrayList;

public class EvenNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> numberList = new ArrayList<>();
        for(int i=1;i<=10;i++){
            numberList.add(i);
        }
        System.out.println("Display even numbers");
        numberList.forEach(number ->{
            if(number%2==0)
                System.out.print(number+" ");
        });
    }
    
}
