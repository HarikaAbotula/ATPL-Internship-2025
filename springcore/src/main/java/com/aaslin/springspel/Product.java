package com.aaslin.springspel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Product {

    @Value("${product.name}")
    private String name;

    @Value("${product.price}")
    private double price;

    // SpEL: Compute 10% discount
    @Value("#{${product.price} * 0.9}")
    private double discountedPrice;

    @Value("${product.inStock}")
    private boolean inStock;

    // Conditional message using SpEL (Ternary)
    @Value("#{${product.inStock} ? 'Available Now' : 'Out of stock'}")
    private String availabilityMessage;

    public void printDetails() {
        System.out.println("Product Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Discounted Price: " + discountedPrice);
        System.out.println("In Stock: " + inStock);
        System.out.println("Availability: " + availabilityMessage);
    }
}

