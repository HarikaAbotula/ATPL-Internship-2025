import java.util.*;
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> ll =new LinkedList<>();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.add(40);
        ll.add(50);
        ll.addFirst(5);
        ll.addLast(60);
        ll.remove(2);
        System.out.println("Elements present in linked list: "+ll);
    }
}
