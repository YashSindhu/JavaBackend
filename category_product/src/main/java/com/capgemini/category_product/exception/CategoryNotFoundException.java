package com.capgemini.category_product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String msg) {
        super(msg);
    }
}