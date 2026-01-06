package com.mromer.balance.person.application.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mromer.balance.common.application.dto.PagedResponseDTO;
import com.mromer.balance.common.application.mapper.PageMapper;
import com.mromer.balance.person.application.dto.PersonResponseDTO;
import com.mromer.balance.person.application.mapper.PersonAppMapper;
import com.mromer.balance.person.application.port.in.query.GetAllPersons;
import com.mromer.balance.person.application.port.in.query.GetAllPersonsQuery;
import com.mromer.balance.person.application.port.out.persistence.FindPersons;
import com.mromer.balance.person.domain.Person;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetAllPersonsImpl implements GetAllPersons {
    private final FindPersons findPersons;

    @Override
    public PagedResponseDTO<PersonResponseDTO> getAllPersons(GetAllPersonsQuery query, Pageable pageable) {

        Page<Person> personsPage = findPersons.findAllPersons(query, pageable);
        return PageMapper.toPagedResponse(personsPage.map(PersonAppMapper::fromDomainToResponseDTO));
    }
}
