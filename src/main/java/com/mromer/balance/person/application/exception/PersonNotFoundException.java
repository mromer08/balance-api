package com.mromer.balance.person.application.exception;

import com.mromer.balance.common.application.exception.EntityNotFoundException;
import com.mromer.balance.person.domain.value.PersonId;

public class PersonNotFoundException extends EntityNotFoundException {
    public PersonNotFoundException(String message) {
        super(message);
    }

    public static PersonNotFoundException forId(PersonId id) {
        return new PersonNotFoundException("No se ha encontrado a la persona con ID: " + id);
    }
    
}
