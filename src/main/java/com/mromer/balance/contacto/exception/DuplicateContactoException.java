package com.mromer.balance.contacto.exception;

import com.mromer.balance.common.exception.DuplicateEntityException;

public class DuplicateContactoException extends DuplicateEntityException{
    private DuplicateContactoException(String message){
        super(message);
    }
    public static DuplicateContactoException forTelefono(String telefono){
        return new DuplicateContactoException(
            String.format("Ya existe un contacto con el teléfono '%s'", telefono)
        );
    }
    public static DuplicateContactoException forEmail(String email){
        return new DuplicateContactoException(
            String.format("Ya existe un contacto con el email '%s'", email)
        );
    }
}
