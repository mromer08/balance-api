package com.mromer.balance.contribuyente.service;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.mromer.balance.common.dto.PagedResponseDTO;
import com.mromer.balance.contribuyente.dto.request.CambiarContactoContribuyenteRequestDTO;
import com.mromer.balance.contribuyente.dto.request.ObtenerContribuyentesRequestDTO;
import com.mromer.balance.contribuyente.dto.request.RegistrarContribuyenteGeneralRequestDTO;
import com.mromer.balance.contribuyente.dto.request.RegistrarPequenoContribuyenteRequestDTO;
import com.mromer.balance.contribuyente.dto.response.ContribuyenteResponseDTO;

public interface ContribuyenteService {
    ContribuyenteResponseDTO obtenerContribuyentePorNit(String nit);
    PagedResponseDTO<ContribuyenteResponseDTO> obtenerContribuyentes(ObtenerContribuyentesRequestDTO requestDTO, Pageable pageable);
    ContribuyenteResponseDTO registrarPequenoContribuyente(RegistrarPequenoContribuyenteRequestDTO requestDTO);
    ContribuyenteResponseDTO registrarContribuyenteGeneral(RegistrarContribuyenteGeneralRequestDTO requestDTO);
    ContribuyenteResponseDTO cambiarContacto(UUID id, CambiarContactoContribuyenteRequestDTO requestDTO);
    boolean eliminarContribuyente(UUID id);
}
