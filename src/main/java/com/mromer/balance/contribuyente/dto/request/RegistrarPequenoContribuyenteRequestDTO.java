package com.mromer.balance.contribuyente.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.*;

public record RegistrarPequenoContribuyenteRequestDTO(
    @NotBlank(message = "El telefono de contacto es obligatorio")
    @Pattern(regexp = "\\d{8}", message = "El numero de telefono debe contener exactamente 8 dígitos numéricos")
    String telefonoContacto,

    @NotBlank(message = "El NIT es obligatorio")
    @Pattern(
        regexp = "^\\d{6,8}[a-zA-Z0-9]$",
        message = "El NIT debe tener entre 7 y 9 caracteres y terminar en número o letra"
    )
    String nit,
    
    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser una fecha pasada")
    LocalDate fechaNacimiento
) {}
