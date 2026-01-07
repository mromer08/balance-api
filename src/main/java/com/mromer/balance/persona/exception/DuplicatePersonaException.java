package com.mromer.balance.persona.exception;

import com.mromer.balance.common.exception.BusinessException;

public class DuplicatePersonaException extends BusinessException{
    private DuplicatePersonaException(String message) {
        super(message);
    }
    public static DuplicatePersonaException forNit(String nit) {
        return new DuplicatePersonaException("Ya existe una persona con el NIT " + nit);
    }
    public static DuplicatePersonaException forCui(String cui) {
        return new DuplicatePersonaException("Ya existe una persona con el CUI " + cui);
    }
}
