package com.mromer.balance.negocio.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mromer.balance.negocio.dto.request.*;
import com.mromer.balance.negocio.dto.response.NegocioResponseDTO;

public interface NegocioService {
    NegocioResponseDTO obtenerNegocioPorId(UUID id);
    List<NegocioResponseDTO> obtenerNegociosPorContribuyente(String nitContribuyente);
    Page<NegocioResponseDTO> obtenerNegocios(ObtenerNegociosRequestDTO requestDTO, Pageable pageable);
    NegocioResponseDTO registrarNegocio(RegistrarNegocioRequestDTO request);
    NegocioResponseDTO actualizarNegocio(UUID id, ActualizarNegocioRequestDTO request);
    boolean eliminarNegocio(UUID id);
}
