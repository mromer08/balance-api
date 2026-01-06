package com.mromer.balance.person.application.port.in.command;

import java.time.LocalDate;

import com.mromer.balance.person.domain.Gender;
import com.mromer.balance.person.domain.Honorific;

import jakarta.validation.constraints.*;

public record UpdatePersonMainInfoCommand(
        @Pattern(regexp = "\\d{13}", message = "CUI must be 13 digits")
        String cui,
        
        @Size(min = 2, max = 50)
        String firstname,
        
        @Size(min = 2, max = 50)
        String lastname,

        Honorific honorific,
        Gender gender,

        @Past(message = "Birth date must be in the past")
        LocalDate birthDate
) {}
