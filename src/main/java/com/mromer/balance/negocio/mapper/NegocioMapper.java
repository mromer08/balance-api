package com.mromer.balance.negocio.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mromer.balance.common.config.MapStructConfig;
import com.mromer.balance.negocio.dto.request.RegistrarNegocioRequestDTO;
import com.mromer.balance.negocio.dto.response.NegocioResponseDTO;
import com.mromer.balance.negocio.model.Negocio;

@Mapper(config = MapStructConfig.class)
public interface NegocioMapper {
    @Mapping(target = "nitContribuyente", source = "negocio.contribuyente.nit")
    @Mapping(target = "nombreContribuyente", source = "negocio.contribuyente.nombre")
    NegocioResponseDTO toResponseDTO(Negocio negocio);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "contribuyente", ignore = true)
    @Mapping(target = "razonSocial", expression = "java(TextNormalizer.normalizeUppercase(requestDTO.razonSocial()))")
    Negocio toEntity(RegistrarNegocioRequestDTO requestDTO);
}
