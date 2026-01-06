package com.mromer.balance.common.domain.exception;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }

    public DomainException(){
        this("Domain exception occurred");
    }
    
}
