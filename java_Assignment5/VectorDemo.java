import java.util.*;
public class VectorDemo {
    public static void main(String[] args) {
        Vector<Double> decimalNumbers = new Vector<>();

        decimalNumbers.add(10.5);
        decimalNumbers.add(20.75);
        decimalNumbers.add(30.25);
        decimalNumbers.add(40.0);

        Enumeration<Double> e = decimalNumbers.elements();
        System.out.println("Decimal numbers in Vector:");
        while (e.hasMoreElements()) {
            Double value = e.nextElement();
            System.out.println(value);
        }
    }
}

