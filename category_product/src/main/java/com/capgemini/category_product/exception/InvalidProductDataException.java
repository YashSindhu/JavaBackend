package com.capgemini.category_product.exception;


public class InvalidProductDataException extends RuntimeException {
    public InvalidProductDataException(String msg) {
        super(msg);
    }
}