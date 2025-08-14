package com.aaslin.SpringBootExceptionHandling.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}

