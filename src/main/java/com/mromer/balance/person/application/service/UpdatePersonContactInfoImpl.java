package com.mromer.balance.person.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mromer.balance.person.application.dto.PersonResponseDTO;
import com.mromer.balance.person.application.exception.PersonNotFoundException;
import com.mromer.balance.person.application.mapper.PersonAppMapper;
import com.mromer.balance.person.application.port.in.command.UpdatePersonContactInfo;
import com.mromer.balance.person.application.port.in.command.UpdatePersonContactInfoCommand;
import com.mromer.balance.person.application.port.out.persistence.FindPersons;
import com.mromer.balance.person.application.port.out.persistence.SavePerson;
import com.mromer.balance.person.domain.Person;
import com.mromer.balance.person.domain.value.PersonId;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class UpdatePersonContactInfoImpl implements UpdatePersonContactInfo {
    
    private final FindPersons findPersons;
    private final SavePerson savePerson;

    @Override
    public PersonResponseDTO updatePersonContactInfo(PersonId id, UpdatePersonContactInfoCommand command) {
        Person person = findPersons.findPersonById(id).orElseThrow(
                () -> PersonNotFoundException.forId(id));

        person.updateContactInformation(
                command.phoneNumber(),
                command.email());
        savePerson.save(person);
        return PersonAppMapper.fromDomainToResponseDTO(person);
    }
}
