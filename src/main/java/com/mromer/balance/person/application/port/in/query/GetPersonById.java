package com.mromer.balance.person.application.port.in.query;

import com.mromer.balance.person.application.dto.PersonResponseDTO;
import com.mromer.balance.person.domain.value.PersonId;

public interface GetPersonById {
    PersonResponseDTO getPersonById(PersonId id);
}
