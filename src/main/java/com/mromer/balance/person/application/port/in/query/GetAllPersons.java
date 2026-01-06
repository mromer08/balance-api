package com.mromer.balance.person.application.port.in.query;

import com.mromer.balance.common.application.dto.PagedResponseDTO;
import com.mromer.balance.person.application.dto.PersonResponseDTO;

public interface GetAllPersons {
    PagedResponseDTO<PersonResponseDTO> getAllPersons(GetAllPersonsQuery query);
}
