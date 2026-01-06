package com.mromer.balance.person.application.port.out.persistence;

import com.mromer.balance.person.domain.value.PersonId;

public interface ExistsPerson {
    boolean existsByCui(String cui);
    boolean existsById(PersonId id);
}
