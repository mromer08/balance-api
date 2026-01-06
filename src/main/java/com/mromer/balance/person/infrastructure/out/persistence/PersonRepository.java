package com.mromer.balance.person.infrastructure.out.persistence;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import com.mromer.balance.person.application.port.in.query.GetAllPersonsQuery;
import com.mromer.balance.person.application.port.out.persistence.ExistsPerson;
import com.mromer.balance.person.application.port.out.persistence.FindPersons;
import com.mromer.balance.person.application.port.out.persistence.SavePerson;
import com.mromer.balance.person.domain.Person;
import com.mromer.balance.person.domain.value.PersonId;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PersonRepository implements
        SavePerson,
        FindPersons,
        ExistsPerson {

    private final PersonJpaRepository jpaRepository;

    @Override
    public boolean existsByCui(String cui) {
        return jpaRepository.existsByCui(cui);
    }

    @Override
    public boolean existsById(PersonId id) {
        return jpaRepository.existsById(id.value());
    }

    @Override
    public Optional<Person> findPersonById(PersonId id) {
        return jpaRepository.findById(id.value())
                .map(PersonEntityMapper::toDomain);
    }

    @Override
    public Page<Person> findAllPersons(GetAllPersonsQuery query, Pageable pageable) {
        Specification<PersonEntity> spec = PersonSpecs.withFilters(
            query.searchTerm(), 
            query.honorifics(), 
        query.genders());

        Page<PersonEntity> page = jpaRepository.findAll(spec, pageable);
        return page.map(PersonEntityMapper::toDomain);
    }

    @Override
    public Person save(Person person) {
        PersonEntity entity = PersonEntityMapper.toEntity(person);
        PersonEntity savedEntity = jpaRepository.save(entity);
        return PersonEntityMapper.toDomain(savedEntity);
    }

}
