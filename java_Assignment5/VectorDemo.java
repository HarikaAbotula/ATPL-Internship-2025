import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;

public class VectorDemo {
   public VectorDemo() {
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      Vector<Double> vector = new Vector<>();
      System.out.println("Enter the elements into the vector");
      int size = scanner.nextInt();

      for(int index = 0; index < size; ++index) {
         vector.add(scanner.nextDouble());
      }

      Enumeration<Double> enumeration = vector.elements();
      System.out.println("Decimal numbers in Vector:");

      while(enumeration.hasMoreElements()) {
         Double value = (Double)enumeration.nextElement();
         System.out.println(value);
      }

      scanner.close();
   }
}
