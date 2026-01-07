package com.mromer.balance.contacto.exception;

import java.util.UUID;

import com.mromer.balance.common.exception.EntityNotFoundException;

public class ContactoNotFoundException extends EntityNotFoundException{
    private ContactoNotFoundException(String message){
        super(message);
    }

    public static ContactoNotFoundException forId(UUID id){
        return new ContactoNotFoundException(
            String.format("No se encontró ningún contacto con el id %s", id.toString())
        );
    }

    public static ContactoNotFoundException forTelefono(String telefono){
        return new ContactoNotFoundException(
            String.format("No se encontró ningún contacto con el teléfono '%s'", telefono)
        );
    }
}
