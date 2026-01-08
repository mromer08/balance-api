package com.mromer.balance.common.config;

import org.mapstruct.MapperConfig;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.mromer.balance.common.text.TextNormalizer;

@MapperConfig(
    componentModel = MappingConstants.ComponentModel.SPRING,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    imports = { TextNormalizer.class }
)
public interface MapStructConfig {
}
