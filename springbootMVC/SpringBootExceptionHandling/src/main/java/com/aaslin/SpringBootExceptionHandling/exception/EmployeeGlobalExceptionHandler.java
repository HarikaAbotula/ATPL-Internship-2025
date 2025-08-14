package com.aaslin.SpringBootExceptionHandling.exception;

import com.aaslin.SpringBootExceptionHandling.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class EmployeeGlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException exception) {
        List<String> errors = new ArrayList<String>();
//        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
//            errors.add(error.getDefaultMessage());
//        }
        exception.getBindingResult().getFieldErrors().            //we can do using field error also
        forEach(error -> errors.add(error.getDefaultMessage()));
        
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), errors));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(NotFoundException ex) {
        List<String> errors = new ArrayList<String>();
        errors.add(ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), errors));
    }
}

