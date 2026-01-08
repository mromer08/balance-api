package com.mromer.balance.negocio.exception;

import java.util.UUID;

import com.mromer.balance.common.exception.EntityNotFoundException;

public class NegocioNotFoundException extends EntityNotFoundException{
    private NegocioNotFoundException(String message) {
        super(message);
    }

    public static NegocioNotFoundException forId(UUID id) {
        return new NegocioNotFoundException("Negocio no encontrado con id: " + id.toString());
    }
}
