package com.aaslin.springspel;

import com.aaslin.springspel.ConfigProduct;
import com.aaslin.springspel.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainProduct{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigProduct.class);
        Product product = context.getBean(Product.class);
        product.printDetails();
        context.close();
    }
}

