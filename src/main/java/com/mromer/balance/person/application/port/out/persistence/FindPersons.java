package com.mromer.balance.person.application.port.out.persistence;

import com.mromer.balance.common.application.dto.PagedResponseDTO;
import com.mromer.balance.person.application.dto.PersonResponseDTO;
import com.mromer.balance.person.application.port.in.query.GetAllPersonsQuery;
import com.mromer.balance.person.domain.Person;
import com.mromer.balance.person.domain.value.PersonId;

public interface FindPersons {
    Person findPersonById(PersonId id);
    PagedResponseDTO<PersonResponseDTO> findAllPersons(GetAllPersonsQuery query);
}
