package com.mromer.balance.person.application.mapper;

import com.mromer.balance.person.application.dto.PersonResponseDTO;
import com.mromer.balance.person.application.port.in.command.RegisterPersonCommand;
import com.mromer.balance.person.domain.Person;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PersonAppMapper {
    public Person fromRegisterCommandToDomain(RegisterPersonCommand command) {
        return Person.register(
                command.cui(),
                command.firstname(),
                command.lastname(),
                command.honorific(),
                command.gender(),
                command.phoneNumber(),
                command.email(),
                command.birthDate());
    }

    public PersonResponseDTO fromDomainToResponseDTO(Person person) {
        return new PersonResponseDTO(
                person.getId().value(),
                person.getCui(),
                person.getFirstname(),
                person.getLastname(),
                person.getFullName(),
                person.getHonorific(),
                person.getGender(),
                person.getPhoneNumber(),
                person.getEmail(),
                person.getBirthDate());
    }
}
