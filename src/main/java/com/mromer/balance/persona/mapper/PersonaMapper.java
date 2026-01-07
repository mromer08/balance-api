package com.mromer.balance.persona.mapper;


import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.mromer.balance.persona.dto.request.*;
import com.mromer.balance.persona.dto.response.*;
import com.mromer.balance.persona.model.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonaMapper {

    @Mapping(target = "nombreCompleto", expression = "java(persona.getNombreCompleto())")
    PersonaResponseDTO toResponseDTO(Persona persona);

    @Mapping(target = "id", ignore = true)
    Persona toEntity(RegistrarPersonaRequestDTO requestDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(ActualizarPersonaRequestDTO requestDTO, @MappingTarget Persona persona);
}
