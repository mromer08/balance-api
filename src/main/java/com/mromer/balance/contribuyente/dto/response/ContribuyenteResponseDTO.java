package com.mromer.balance.contribuyente.dto.response;

import java.time.LocalDate;
import java.util.UUID;

import com.mromer.balance.contacto.dto.response.ContactoResponseDTO;
import com.mromer.balance.contribuyente.model.*;

public record ContribuyenteResponseDTO(
    UUID id,
    String nit,
    String nombre,
    TipoContribuyente tipo,
    RegimenTributario regimen,
    TipoEmpresa tipoEmpresa,
    EstadoContribuyente estado,
    ContactoResponseDTO contacto,
    LocalDate fechaNacimiento
) {}
