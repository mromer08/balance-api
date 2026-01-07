package com.mromer.balance.contacto.dto.request;

import com.mromer.balance.contacto.model.Genero;
import com.mromer.balance.contacto.model.Honorifico;

import jakarta.validation.constraints.*;

public record ActualizarContactoRequestDTO(
    @Pattern(regexp = "\\d{8}", message = "El numero de telefono debe contener exactamente 8 dígitos numéricos")
    String telefono,

    @Size(min = 2, max = 50, message = "Los nombres deben tener entre 2 y 50 caracteres")
    String nombres,

    @Size(min = 2, max = 50, message = "Los apellidos deben tener entre 2 y 50 caracteres")
    String apellidos,
    Honorifico honorifico,
    Genero genero,
    String telefonoSecundario,
    String email
) {}
