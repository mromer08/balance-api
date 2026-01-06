package com.mromer.balance.contribuyente.application.port.in.command;

import java.time.LocalDate;
import java.util.UUID;

import com.mromer.balance.contribuyente.domain.*;

import jakarta.validation.constraints.*;

public record RegisterContribuyenteCommand(
    
    @NotBlank(message = "El NIT es obligatorio")
    @Size(min = 9, max = 9, message = "El NIT debe tener 9 caracteres")
    String nit,

    @NotBlank(message = "La razón social es obligatoria")
    @Size(min = 3, max = 100, message = "La razón social debe tener entre 3 y 100 caracteres")
    String razonSocial,

    @NotNull(message = "El tipo de contribuyente es obligatorio")
    TipoContribuyente tipoContribuyente,
    @NotNull(message = "El régimen tributario es obligatorio")
    RegimenTributario regimenTributario,
    
    TipoEmpresa tipoEmpresa,
    RentaBruta rentaBruta,

    @NotNull(message = "El representante es obligatorio")
    UUID representante,
    
    LocalDate fechaApertura
) {}
