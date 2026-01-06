package com.mromer.balance.person.application.port.in.command;

import com.mromer.balance.person.application.dto.PersonResponseDTO;
import com.mromer.balance.person.domain.value.PersonId;

public interface UpdatePersonContactInfo {
    PersonResponseDTO updatePersonContactInfo(PersonId id, UpdatePersonContactInfoCommand command);
}
