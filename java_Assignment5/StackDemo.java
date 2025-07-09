import java.util.*;
public class StackDemo {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Stack<Integer> stack=new Stack<>();
        System.out.println("Enter Integer elements to push on stack,Type FINISH after entering: ");

        while(scanner.hasNext()){
            if(scanner.hasNextInt()){
                int elements=scanner.nextInt();
                stack.push(elements);
            }
            else{
                String stringinput=scanner.next();
                if(stringinput.equalsIgnoreCase("Finish")){
                    break;
                }
                System.out.println("Invalid input.please provide Integer input");
            }
        }

        System.out.println("ORIGINAL STACK: "+stack);
        stack.pop();
        stack.pop();
        System.out.println("STACK AFTER POPPING ELEMENTS: "+stack);
        scanner.close();
        
    }
}
