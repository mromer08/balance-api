package com.mromer.balance.persona.dto.request;

import java.util.Set;

import com.mromer.balance.persona.model.Genero;
import com.mromer.balance.persona.model.Honorifico;

public record ObtenerPersonasRequestDTO(
    String searchTerm,
    Set<Honorifico> honorificos,
    Set<Genero> generos
) {}
