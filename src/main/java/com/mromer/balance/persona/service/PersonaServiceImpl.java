package com.mromer.balance.persona.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mromer.balance.common.dto.PagedResponseDTO;
import com.mromer.balance.common.mapper.PageMapper;
import com.mromer.balance.persona.dto.request.ActualizarPersonaRequestDTO;
import com.mromer.balance.persona.dto.request.ObtenerPersonasRequestDTO;
import com.mromer.balance.persona.dto.request.RegistrarPersonaRequestDTO;
import com.mromer.balance.persona.dto.response.PersonaResponseDTO;
import com.mromer.balance.persona.exception.DuplicatePersonaException;
import com.mromer.balance.persona.exception.PersonaNotFoundException;
import com.mromer.balance.persona.mapper.PersonaMapper;
import com.mromer.balance.persona.model.Persona;
import com.mromer.balance.persona.repository.PersonaRepository;
import com.mromer.balance.persona.specification.PersonaSpecs;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;
    private final PersonaMapper personaMapper;

    @Override
    public PersonaResponseDTO obtenerPersonaPorId(UUID id) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> PersonaNotFoundException.forId(id));
        return personaMapper.toResponseDTO(persona);
    }

    @Override
    public PagedResponseDTO<PersonaResponseDTO> obtenerPersonas(ObtenerPersonasRequestDTO requestDTO,
            Pageable pageable) {
        Specification<Persona> specification = PersonaSpecs.withFilters(
                requestDTO.searchTerm(),
                requestDTO.honorificos(),
                requestDTO.generos());

        Page<Persona> personaPage = personaRepository.findAll(specification, pageable);
        Page<PersonaResponseDTO> dtoPage = personaPage.map(personaMapper::toResponseDTO);
        return PageMapper.toPagedResponse(dtoPage);
    }

    @Override
    public PersonaResponseDTO registrarPersona(RegistrarPersonaRequestDTO requestDTO) {
        if (personaRepository.existsByNit(requestDTO.nit())) {
            throw DuplicatePersonaException.forNit(requestDTO.nit());
        }

        if (personaRepository.existsByCui(requestDTO.cui())) {
            throw DuplicatePersonaException.forCui(requestDTO.cui());
        }
        Persona persona = personaMapper.toEntity(requestDTO);
        Persona savedPersona = personaRepository.save(persona);
        return personaMapper.toResponseDTO(savedPersona);
    }

    @Override
    public PersonaResponseDTO actualizarPersona(UUID id, ActualizarPersonaRequestDTO requestDTO) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> PersonaNotFoundException.forId(id));

        if (personaRepository.existsByNitAndIdNot(requestDTO.nit(), id)) {
            throw DuplicatePersonaException.forNit(requestDTO.nit());
        }

        if (personaRepository.existsByCuiAndIdNot(requestDTO.cui(), id)) {
            throw DuplicatePersonaException.forCui(requestDTO.cui());
        }

        personaMapper.updateEntityFromDTO(requestDTO, persona);
        Persona updatedPersona = personaRepository.save(persona);
        return personaMapper.toResponseDTO(updatedPersona);
    }

    @Override
    public boolean eliminarPersona(UUID id) {
        if (!personaRepository.existsById(id)) {
            throw PersonaNotFoundException.forId(id);
        }
        personaRepository.deleteById(id);
        return true;
    }
}
