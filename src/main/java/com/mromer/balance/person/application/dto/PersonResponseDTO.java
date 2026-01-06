package com.mromer.balance.person.application.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.mromer.balance.person.domain.Gender;
import com.mromer.balance.person.domain.Honorific;

public record PersonResponseDTO (
    UUID id,
    String cui,
    String firstname,
    String lastname,
    Honorific honorific,
    Gender gender,
    String phoneNumber,
    String email,
    LocalDate birthDate
){}
