package com.mromer.balance.negocio.dto.response;

import java.util.UUID;

import com.mromer.balance.negocio.model.ActividadEconomica;
import com.mromer.balance.negocio.model.EstadoNegocio;

public record NegocioResponseDTO(
    UUID id,
    String razonSocial,
    ActividadEconomica actividadEconomica,
    EstadoNegocio estado,
    String nitContribuyente,
    String nombreContribuyente
) {}
