package com.mromer.balance.contribuyente.exception;

import java.util.UUID;

import com.mromer.balance.common.exception.EntityNotFoundException;

public class ContribuyenteNotFoundException extends EntityNotFoundException {
    private ContribuyenteNotFoundException(String message) {
        super(message);
    }

    public static ContribuyenteNotFoundException forId(UUID id) {
        return new ContribuyenteNotFoundException("Contribuyente no encontrado con ID: " + id.toString());
    }

    public static ContribuyenteNotFoundException forNit(String nit) {
        return new ContribuyenteNotFoundException("Contribuyente no encontrado con NIT: " + nit);
    }
    
}
