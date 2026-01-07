package com.mromer.balance.contacto.dto.response;

import java.util.UUID;

import com.mromer.balance.contacto.model.Genero;
import com.mromer.balance.contacto.model.Honorifico;

public record ContactoResponseDTO(
    UUID id,
    String telefono,
    String nombres,
    String apellidos,
    Honorifico honorifico,
    Genero genero,
    String telefonoSecundario,
    String email
) {}
