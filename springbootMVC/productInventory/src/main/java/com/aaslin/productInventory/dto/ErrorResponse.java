package com.aaslin.productInventory.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {
    private String timestamp;
    private int status;
    private List<String> errors;

    public ErrorResponse(int status, List<String> errors) {
        this.timestamp = LocalDateTime.now().toString();
        this.status = status;
        this.errors = errors;
    }

    public String getTimestamp() { 
    	return timestamp; 
    }
    
    public int getStatus() { 
    	return status;
    }
    
    public List<String> getErrors() { 
    	return errors; 
    }
}
