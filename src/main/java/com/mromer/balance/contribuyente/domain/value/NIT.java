package com.mromer.balance.contribuyente.domain.value;

import com.mromer.balance.common.domain.exception.DomainException;

public record NIT(String value) {

    public NIT {
        if (value == null) {
            throw new DomainException("NIT value cannot be null");
        }
        if (!value.matches("\\d{9}")) {
            throw new IllegalArgumentException("El NIT debe tener exactamente 9 digitos");
        }
    }
    
    public static NIT of(String value) {
        return new NIT(value);
    }
}