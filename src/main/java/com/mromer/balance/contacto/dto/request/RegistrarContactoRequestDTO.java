package com.mromer.balance.contacto.dto.request;

import com.mromer.balance.contacto.model.Genero;
import com.mromer.balance.contacto.model.Honorifico;

import jakarta.validation.constraints.*;

public record RegistrarContactoRequestDTO(
    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "\\d{8}", message = "El numero de telefono debe contener exactamente 8 dígitos numéricos")
    String telefono,

    @NotBlank(message = "Los nombres son obligatorios")
    @Size(min = 2, max = 50, message = "Los nombres deben tener entre 2 y 50 caracteres")
    String nombres,

    @NotBlank(message = "Los apellidos son obligatorios")
    @Size(min = 2, max = 50, message = "Los apellidos deben tener entre 2 y 50 caracteres")
    String apellidos,

    Honorifico honorifico,
    Genero genero,

    @Pattern(regexp = "\\d{8}", message = "El numero de telefono debe contener exactamente 8 dígitos numéricos")
    String telefonoSecundario,

    @Email(message = "El correo electrónico no es válido")
    String email
) {}
