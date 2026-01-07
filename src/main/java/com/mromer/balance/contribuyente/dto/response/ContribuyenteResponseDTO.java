package com.mromer.balance.contribuyente.dto.response;

import java.time.LocalDate;
import java.util.UUID;

import com.mromer.balance.contribuyente.model.*;
import com.mromer.balance.persona.dto.response.PersonaResponseDTO;

public record ContribuyenteResponseDTO(
    UUID id,
    String nit,
    String razonSocial,
    TipoContribuyente tipoContribuyente,
    RegimenTributario regimenTributario,
    TipoEmpresa tipoEmpresa,
    EstadoContribuyente estado,
    RentaBruta rentaBruta,
    PersonaResponseDTO representante,
    LocalDate fechaApertura
) {}
