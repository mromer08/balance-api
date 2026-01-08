package com.mromer.balance.negocio.dto.request;

import com.mromer.balance.negocio.model.ActividadEconomica;

public record RegistrarNegocioRequestDTO(
    String nitContribuyente,
    String razonSocial,
    ActividadEconomica actividadEconomica    
) {}
