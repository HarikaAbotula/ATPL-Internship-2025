package com.aaslin.productInventory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

import com.aaslin.productInventory.model.Product;

@Service
public class ProductService {
	
	private List<Product> productList = new ArrayList<>();
	private long idCounter = 1;
	
	
	//get all product details
    public List<Product> getAllProducts() {
        return productList;
    }
	
    //get product by id
    public Product getProductById(Long id) {
        for (Product product : productList) {
            if (product.getId() == id) 
            	return product;
        }
        throw new NoSuchElementException("Product id " + id + " not found");
    }
    
	//add product
	public Product addProduct(Product product) {
		product.setId(idCounter++);
         productList.add(product);
         return product;
	}
    
    //update product
    public Product updateProduct(Long id, Product updatedProduct) {
    	for(Product product : productList) {
    		if(product.getId().equals(id)) {
    			product.setName(updatedProduct.getName());
    			product.setPrice(updatedProduct.getPrice());
    			product.setQuantity(updatedProduct.getQuantity());
    			return product;
    		}
    	}
    	throw new NoSuchElementException("Product id " + id + " not found");
    }
    
    //delete product
    public void deleteProduct(Long id) {
    	Product product = getProductById(id);
    	productList.remove(product);
    }	
}
