package com.mromer.balance.common.application.exception;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(){
        this("Business exception occurred");
    }
}
