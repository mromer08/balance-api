package com.mromer.balance.person.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mromer.balance.person.application.dto.PersonResponseDTO;
import com.mromer.balance.person.application.exception.DuplicatePersonException;
import com.mromer.balance.person.application.mapper.PersonAppMapper;
import com.mromer.balance.person.application.port.in.command.RegisterPerson;
import com.mromer.balance.person.application.port.in.command.RegisterPersonCommand;
import com.mromer.balance.person.application.port.out.persistence.ExistsPerson;
import com.mromer.balance.person.application.port.out.persistence.SavePerson;
import com.mromer.balance.person.domain.Person;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class RegisterPersonImpl implements RegisterPerson {
    private final ExistsPerson existsPerson;
    private final SavePerson savePerson;

    @Override
    public PersonResponseDTO registerPerson(RegisterPersonCommand command) {
        if (command.cui() != null && existsPerson.existsByCui(command.cui())) {
            throw DuplicatePersonException.withCui(command.cui());
        }
        Person person = PersonAppMapper.fromRegisterCommandToDomain(command);
        savePerson.save(person);
        return PersonAppMapper.fromDomainToResponseDTO(person);
    }

}
