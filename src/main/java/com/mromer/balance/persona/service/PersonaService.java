package com.mromer.balance.persona.service;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.mromer.balance.common.dto.PagedResponseDTO;
import com.mromer.balance.persona.dto.request.ActualizarPersonaRequestDTO;
import com.mromer.balance.persona.dto.request.ObtenerPersonasRequestDTO;
import com.mromer.balance.persona.dto.request.RegistrarPersonaRequestDTO;
import com.mromer.balance.persona.dto.response.PersonaResponseDTO;

public interface PersonaService {
    PersonaResponseDTO obtenerPersonaPorId(UUID id);
    PagedResponseDTO<PersonaResponseDTO> obtenerPersonas(ObtenerPersonasRequestDTO requestDTO, Pageable pageable);
    PersonaResponseDTO registrarPersona(RegistrarPersonaRequestDTO requestDTO);
    PersonaResponseDTO actualizarPersona(UUID id, ActualizarPersonaRequestDTO requestDTO);
    boolean eliminarPersona(UUID id);
}
