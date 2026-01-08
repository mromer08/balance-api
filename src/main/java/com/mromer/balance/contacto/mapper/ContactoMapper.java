package com.mromer.balance.contacto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.mromer.balance.common.config.MapStructConfig;
import com.mromer.balance.contacto.dto.request.ActualizarContactoRequestDTO;
import com.mromer.balance.contacto.dto.request.RegistrarContactoRequestDTO;
import com.mromer.balance.contacto.dto.response.ContactoResponseDTO;
import com.mromer.balance.contacto.model.Contacto;

@Mapper(config = MapStructConfig.class)
public interface ContactoMapper {
    ContactoResponseDTO toResponseDTO(Contacto contacto);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(
        target = "nombres",
        expression = "java(TextNormalizer.normalizeUppercase(requestDTO.nombres()))"
    )
    @Mapping(
        target = "apellidos",
        expression = "java(TextNormalizer.normalizeUppercase(requestDTO.apellidos()))"
    )
    @Mapping(
        target = "email",
        expression = "java(TextNormalizer.normalizeEmailLowercase(requestDTO.email()))"
    )
    Contacto toEntity(RegistrarContactoRequestDTO requestDTO);

    @Mapping(target = "id", ignore = true)
    
        @Mapping(
        target = "nombres",
        expression = "java(TextNormalizer.normalizeUppercase(requestDTO.nombres()))"
    )
    @Mapping(
        target = "apellidos",
        expression = "java(TextNormalizer.normalizeUppercase(requestDTO.apellidos()))"
    )
    void updateEntityFromDTO(ActualizarContactoRequestDTO requestDTO, @MappingTarget Contacto contacto);
}
