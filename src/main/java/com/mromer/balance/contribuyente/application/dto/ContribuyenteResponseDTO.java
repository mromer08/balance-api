package com.mromer.balance.contribuyente.application.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.mromer.balance.contribuyente.domain.EstadoContribuyente;
import com.mromer.balance.contribuyente.domain.RegimenTributario;
import com.mromer.balance.contribuyente.domain.RentaBruta;
import com.mromer.balance.contribuyente.domain.TipoContribuyente;
import com.mromer.balance.contribuyente.domain.TipoEmpresa;
import com.mromer.balance.person.application.dto.PersonResponseDTO;

public record ContribuyenteResponseDTO(
    UUID id,
    String nit,
    String razonSocial,
    TipoContribuyente tipoContribuyente,
    RegimenTributario regimenTributario,
    TipoEmpresa tipoEmpresa,
    EstadoContribuyente estado,
    RentaBruta rentaBruta,
    PersonResponseDTO representante,
    LocalDate fechaApertura
) {}
