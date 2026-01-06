package com.mromer.balance.person.application.exception;

import com.mromer.balance.common.application.exception.DuplicateEntityException;

public class DuplicatePersonException extends DuplicateEntityException{
    public DuplicatePersonException(String message) {
        super(message);
    }

    public static DuplicatePersonException withId(String id) {
        return new DuplicatePersonException("Persona con el ID: " + id + " ya existe");
    }

    public static DuplicatePersonException withCui(String cui) {
        return new DuplicatePersonException("Persona con el CUI: " + cui + " ya existe");
    }
}
