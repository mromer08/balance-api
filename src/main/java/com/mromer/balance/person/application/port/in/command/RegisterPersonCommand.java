package com.mromer.balance.person.application.port.in.command;

import java.time.LocalDate;

import com.mromer.balance.person.domain.Gender;
import com.mromer.balance.person.domain.Honorific;

import jakarta.validation.constraints.*;

public record RegisterPersonCommand(
        @Pattern(regexp = "\\d{13}", message = "CUI must be 13 digits")
        String cui,
        
        @NotBlank @Size(min = 2, max = 50)
        String firstname,
        
        @NotBlank @Size(min = 2, max = 50)
        String lastname,

        Honorific honorific,
        Gender gender,
        
        @Pattern(regexp = "\\d{8}", message = "Phone number must be 8 digits")
        String phoneNumber,
        
        @Email
        String email,

        @NotNull(message = "Birth date is required")
        @Past(message = "Birth date must be in the past")
        LocalDate birthDate
) {}
