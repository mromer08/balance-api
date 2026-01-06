package com.mromer.balance.person.application.port.out.persistence;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mromer.balance.person.application.port.in.query.GetAllPersonsQuery;
import com.mromer.balance.person.domain.Person;
import com.mromer.balance.person.domain.value.PersonId;

public interface FindPersons {
    Optional<Person> findPersonById(PersonId id);
    Page<Person> findAllPersons(GetAllPersonsQuery query, Pageable pageable);
}
