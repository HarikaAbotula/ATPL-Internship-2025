package com.aaslin.springboot.service;

import com.aaslin.springboot.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    private final Map<Long, Product> productMap = new HashMap<>();
    private long idCounter = 1;

    // Add new product
    public Product addProduct(Product product) {
        product.setId(idCounter++);
        productMap.put(product.getId(), product);
        return product;
    }

    // Get all products
    public List<Product> getAllProducts() {
        return new ArrayList<>(productMap.values());
    }

    // Update product
    public Product updateProduct(Long id, Product updatedProduct) {
        if (productMap.containsKey(id)) {
            updatedProduct.setId(id);
            productMap.put(id, updatedProduct);
            return updatedProduct;
        }
        return null;
    }

    // Delete product
    public boolean deleteProduct(Long id) {
        return productMap.remove(id) != null;
    }
}

