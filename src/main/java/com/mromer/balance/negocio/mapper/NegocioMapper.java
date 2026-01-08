package com.mromer.balance.negocio.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.mromer.balance.negocio.dto.request.RegistrarNegocioRequestDTO;
import com.mromer.balance.negocio.dto.response.NegocioResponseDTO;
import com.mromer.balance.negocio.model.Negocio;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface NegocioMapper {
    @Mapping(target = "nitContribuyente", source = "negocio.contribuyente.nit")
    @Mapping(target = "nombreContribuyente", source = "negocio.contribuyente.nombre")
    NegocioResponseDTO toResponseDTO(Negocio negocio);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "contribuyente", ignore = true)
    Negocio toEntity(RegistrarNegocioRequestDTO requestDTO);
}
