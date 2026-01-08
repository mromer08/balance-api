package com.mromer.balance.negocio.dto.request;

import java.util.Set;

import com.mromer.balance.negocio.model.ActividadEconomica;
import com.mromer.balance.negocio.model.EstadoNegocio;

public record ObtenerNegociosRequestDTO(
    String searchTerm,
    Set<ActividadEconomica> actividades,
    Set<EstadoNegocio> estados
) {}
