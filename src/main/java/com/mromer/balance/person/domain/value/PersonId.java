package com.mromer.balance.person.domain.value;

import java.util.UUID;

import com.mromer.balance.common.domain.exception.DomainException;

public record PersonId(UUID value) {

    public PersonId {
        if (value == null) {
            throw new DomainException("PersonId value cannot be null");
        }
    }
    
    public static PersonId of(UUID value) {
        return new PersonId(value);
    }

    public static PersonId generate() {
        return new PersonId(UUID.randomUUID());
    }

    @Override
    public String toString() {
        return value().toString();
    }
}
