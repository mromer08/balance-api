package com.mromer.balance.contribuyente.application.port.in.command;

import com.mromer.balance.person.application.dto.PersonResponseDTO;

public interface RegisterContribuyente {
    PersonResponseDTO registerContribuyente(RegisterContribuyenteCommand command);
}
