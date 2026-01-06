package com.mromer.balance.person.domain.value;

import java.util.UUID;

public record PersonId(UUID value) {

    public PersonId {
        if (value == null) {
            throw new IllegalArgumentException("PersonId value cannot be null");
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
