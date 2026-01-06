package com.mromer.balance.person.application.port.in.command;

import com.mromer.balance.person.application.dto.PersonResponseDTO;
import com.mromer.balance.person.domain.value.PersonId;

public interface UpdatePersonMainInfo {
    PersonResponseDTO updatePersonMainInfo(PersonId id, UpdatePersonMainInfoCommand command);
}
