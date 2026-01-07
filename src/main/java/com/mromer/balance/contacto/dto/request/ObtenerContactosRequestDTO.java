package com.mromer.balance.contacto.dto.request;

import java.util.Set;

import com.mromer.balance.contacto.model.Genero;
import com.mromer.balance.contacto.model.Honorifico;

public record ObtenerContactosRequestDTO(
    String searchTerm,
    Set<Honorifico> honorificos,
    Set<Genero> generos
) {}
