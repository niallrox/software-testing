package com.ifmo.task3.model;

public class NotAvailableException extends RuntimeException {
    public NotAvailableException(String message){
        super(message);
    }
}
