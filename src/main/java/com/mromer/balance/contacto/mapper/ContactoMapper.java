package com.mromer.balance.contacto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.mromer.balance.contacto.dto.request.ActualizarContactoRequestDTO;
import com.mromer.balance.contacto.dto.request.RegistrarContactoRequestDTO;
import com.mromer.balance.contacto.dto.response.ContactoResponseDTO;
import com.mromer.balance.contacto.model.Contacto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContactoMapper {
    ContactoResponseDTO toResponseDTO(Contacto contacto);
    
    @Mapping(target = "id", ignore = true)
    Contacto toEntity(RegistrarContactoRequestDTO responseDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(ActualizarContactoRequestDTO requestDTO, @MappingTarget Contacto contacto);
    
}
