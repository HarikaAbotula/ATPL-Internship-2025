import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListDemo {
   public LinkedListDemo() {
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter the size of the linkedlist: ");
      int size = scanner.nextInt();
      LinkedList<Integer> linkedlist = new LinkedList<>();

      for(int index = 0; index < size; ++index) {
         linkedlist.add(scanner.nextInt());
      }

      System.out.println("Elements in linkedlist: " + linkedlist);
      linkedlist.addFirst(5);
      linkedlist.addLast(60);
      linkedlist.remove(2);
      System.out.println("Elements present in linked list after performing actions: " + linkedlist);
      scanner.close();
   }
}

