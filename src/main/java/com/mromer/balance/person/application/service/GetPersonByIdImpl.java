package com.mromer.balance.person.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mromer.balance.person.application.dto.PersonResponseDTO;
import com.mromer.balance.person.application.mapper.PersonAppMapper;
import com.mromer.balance.person.application.port.in.query.GetPersonById;
import com.mromer.balance.person.application.port.out.persistence.FindPersons;
import com.mromer.balance.person.domain.Person;
import com.mromer.balance.person.domain.value.PersonId;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetPersonByIdImpl implements GetPersonById {
    private final FindPersons findPersons;

    @Override
    public PersonResponseDTO getPersonById(PersonId id) {
        Person person = findPersons.findPersonById(id);
        return PersonAppMapper.fromDomainToResponseDTO(person);
    }

}
