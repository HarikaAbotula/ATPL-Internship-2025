import java.util.*;
public class StackDemo {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
        Stack<Integer> stack=new Stack<>();
        System.out.println("Enter Integer input to push on stack,Type FINISH after entering");
        while(sc.hasNext()){
            if(sc.hasNextInt()){
                int num=sc.nextInt();
                stack.push(num);
               // System.out.println(num);
            }
            else{
                String inp=sc.next();
                if(inp.equalsIgnoreCase("Finish")){
                    break;
                }
                System.out.println("Invalid input.please provide Integer input");
            }
        }
        System.out.println("ORIGINAL STACK: "+stack);
        stack.pop();
        stack.pop();
        System.out.println("STACK AFTER POPPING ELEMENTS: "+stack);
        sc.close();
        
    }
}
