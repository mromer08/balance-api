package com.mromer.balance.persona.dto.request;

import java.time.LocalDate;

import com.mromer.balance.persona.model.Genero;
import com.mromer.balance.persona.model.Honorifico;

import jakarta.validation.constraints.*;

public record RegistrarPersonaRequestDTO(
    @NotBlank(message = "El NIT es obligatorio")
    @Pattern(regexp = "\\d{9}", message = "El NIT debe contener exactamente 9 dígitos numéricos")
    String nit,

    @Pattern(regexp = "\\d{13}", message = "El CUI debe contener exactamente 13 dígitos numéricos")
    String cui,

    @NotBlank(message = "Los nombres son obligatorios")
    @Size(min = 2, max = 50, message = "Los nombres deben tener entre 2 y 50 caracteres")
    String nombres,

    @NotBlank(message = "Los apellidos son obligatorios")
    @Size(min = 2, max = 50, message = "Los apellidos deben tener entre 2 y 50 caracteres")
    String apellidos,

    Honorifico honorifico,
    Genero genero,
    String telefono,
    String email,
    LocalDate fechaNacimiento
) {}
