package com.mromer.balance.person.application.port.out.persistence;

import com.mromer.balance.person.domain.Person;

public interface SavePerson {
    Person save(Person person);
}
