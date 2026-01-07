package com.mromer.balance.persona.exception;

import java.util.UUID;

import com.mromer.balance.common.exception.EntityNotFoundException;

public class PersonaNotFoundException extends EntityNotFoundException {
    private PersonaNotFoundException(String message) {
        super(message);
    }

    public static PersonaNotFoundException forId(UUID id) {
        return new PersonaNotFoundException("Persona with ID " + id.toString() + " not found.");
    }
    
}
