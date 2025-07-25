 import java.util.*;
import java.util.function.*;

public class ProductDiscount {
    public static void main(String[] args) {
       
        Map<String, Double> productPrices = new HashMap<>();
            productPrices.put( "Laptop", 50000.0);
            productPrices.put( "Mouse", 1200.0);
            productPrices.put( "Keyboard", 2500.0);
            productPrices.put( "Smart Watch", 50000.0);
            
        String product ="Keyboard" ; 

        Function<Double, Double> applyDiscount = ProductDiscount::discount;

        Optional<Double> priceOptional = Optional.ofNullable(productPrices.get(product));

        //  Apply discount if price is present
        double finalPrice = priceOptional
            .map(applyDiscount)   
            .orElse(0.0);         
        System.out.println(" Final price of " + product + ":" + finalPrice);
    }

    public static Double discount(Double price) {
        return price - (price * 0.10);
    }
}

