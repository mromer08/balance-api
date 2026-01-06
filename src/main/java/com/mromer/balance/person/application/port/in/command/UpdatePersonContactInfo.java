package com.mromer.balance.person.application.port.in.command;

import com.mromer.balance.person.application.dto.PersonResponseDTO;

public interface UpdatePersonContactInfo {
    PersonResponseDTO updatePersonContactInfo(UpdatePersonContactInfoCommand command);
}
