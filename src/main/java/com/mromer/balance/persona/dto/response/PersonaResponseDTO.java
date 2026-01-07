package com.mromer.balance.persona.dto.response;

import java.time.LocalDate;
import java.util.UUID;

import com.mromer.balance.persona.model.*;

public record PersonaResponseDTO (
    UUID id,
    String nit,
    String cui,
    String nombres,
    String apellidos,
    String nombreCompleto,
    Honorifico honorifico,
    Genero genero,
    String telefono,
    String email,
    LocalDate fechaNacimiento
) {}
