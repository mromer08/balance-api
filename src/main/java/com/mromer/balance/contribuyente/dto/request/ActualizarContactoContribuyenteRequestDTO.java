package com.mromer.balance.contribuyente.dto.request;

import jakarta.validation.constraints.*;

public record ActualizarContactoContribuyenteRequestDTO(
    @NotBlank(message = "El telefono de contacto es obligatorio")
    @Pattern(regexp = "\\d{8}", message = "El numero de telefono debe contener exactamente 8 dígitos numéricos")
    String telefonoContacto
) {}
