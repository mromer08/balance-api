package com.mromer.balance.contribuyente.exception;

import com.mromer.balance.common.exception.DuplicateEntityException;

public class DuplicateContribuyenteException extends DuplicateEntityException {
    private DuplicateContribuyenteException(String message) {
        super(message);
    }

    public static DuplicateContribuyenteException forNit(String nit) {
        return new DuplicateContribuyenteException("Contribuyente ya existe con NIT: " + nit);
    }

    public static DuplicateContribuyenteException forRazonSocial(String razonSocial) {
        return new DuplicateContribuyenteException("Contribuyente ya existe con Razon Social: " + razonSocial);
    }
}
