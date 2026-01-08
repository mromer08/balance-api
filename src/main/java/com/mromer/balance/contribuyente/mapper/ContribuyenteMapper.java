package com.mromer.balance.contribuyente.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.mromer.balance.contribuyente.dto.response.ContribuyenteResponseDTO;
import com.mromer.balance.contribuyente.model.Contribuyente;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContribuyenteMapper {
    
    ContribuyenteResponseDTO toResponseDTO(Contribuyente contribuyente);
}
