package com.mromer.balance.negocio.dto.request;

import com.mromer.balance.negocio.model.ActividadEconomica;

public record ActualizarNegocioRequestDTO(
    String razonSocial,
    ActividadEconomica actividadEconomica
) {}
