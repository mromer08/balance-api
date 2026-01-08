package com.mromer.balance.contribuyente.mapper;

import org.mapstruct.Mapper;

import com.mromer.balance.common.config.MapStructConfig;
import com.mromer.balance.contribuyente.dto.response.ContribuyenteResponseDTO;
import com.mromer.balance.contribuyente.model.Contribuyente;

@Mapper(config = MapStructConfig.class)
public interface ContribuyenteMapper {
    
    ContribuyenteResponseDTO toResponseDTO(Contribuyente contribuyente);
}
