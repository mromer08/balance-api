package com.mromer.balance.person.infrastructure.out.persistence;

import com.mromer.balance.person.domain.Person;
import com.mromer.balance.person.domain.value.PersonId;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PersonEntityMapper {
    public PersonEntity toEntity(Person person) {
        return new PersonEntity(
                person.getId().value(),
                person.getCui(),
                person.getFirstname(),
                person.getLastname(),
                person.getHonorific(),
                person.getGender(),
                person.getPhoneNumber(),
                person.getEmail(),
                person.getBirthDate());
    }

    public Person toDomain(PersonEntity entity) {
        return Person.rehydrate(
                PersonId.of(entity.getId()),
                entity.getCui(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getHonorific(),
                entity.getGender(),
                entity.getPhoneNumber(),
                entity.getEmail(),
                entity.getBirthDate());
    }
}
