package com.aaslin.productInventory.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Product {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Price cannot be null")
    @Min(value = 1, message = "Price must be at least 1")
    private Double price;

    @NotNull(message = "Quantity cannot be null")
    @Min(value = 0, message = "Quantity cannot be negative")
    private Integer quantity;

    // Getters and setters
    public Long getId() { 
    	return id; 
    }
    
    public void setId(Long id) { 
    	this.id = id;
    }
    
    public String getName() { 
    	return name;
    }
    
    public void setName(String name) { 
    	this.name = name; 
    }
    
    public Double getPrice() { 
    	return price; 
    }
    
    public void setPrice(Double price) { 
    	this.price = price;
    }
    
    public Integer getQuantity() { 
    	return quantity; 
    }
    
    public void setQuantity(Integer quantity) { 
    	this.quantity = quantity;
    }
}
