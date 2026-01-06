package com.mromer.balance.person.application.port.in.command;

import jakarta.validation.constraints.*;

public record UpdatePersonContactInfoCommand(
        @Pattern(regexp = "\\d{8}", message = "Phone number must be 8 digits")
        String phoneNumber,
        
        @Email
        String email
) {}
