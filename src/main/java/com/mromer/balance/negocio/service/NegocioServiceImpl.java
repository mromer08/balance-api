package com.mromer.balance.negocio.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mromer.balance.contribuyente.exception.ContribuyenteNotFoundException;
import com.mromer.balance.contribuyente.model.Contribuyente;
import com.mromer.balance.contribuyente.repository.ContribuyenteRepository;
import com.mromer.balance.negocio.dto.request.ActualizarNegocioRequestDTO;
import com.mromer.balance.negocio.dto.request.ObtenerNegociosRequestDTO;
import com.mromer.balance.negocio.dto.request.RegistrarNegocioRequestDTO;
import com.mromer.balance.negocio.dto.response.NegocioResponseDTO;
import com.mromer.balance.negocio.exception.NegocioNotFoundException;
import com.mromer.balance.negocio.mapper.NegocioMapper;
import com.mromer.balance.negocio.model.EstadoNegocio;
import com.mromer.balance.negocio.model.Negocio;
import com.mromer.balance.negocio.repository.NegocioRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class NegocioServiceImpl implements NegocioService {

    private final NegocioRepository negocioRepository;
    private final ContribuyenteRepository contribuyenteRepository;
    private final NegocioMapper negocioMapper;

    @Override
    public NegocioResponseDTO obtenerNegocioPorId(UUID id) {
        Negocio negocio = negocioRepository.findById(id)
                .orElseThrow(() -> NegocioNotFoundException.forId(id));

        return negocioMapper.toResponseDTO(negocio);
    }

    @Override
    public List<NegocioResponseDTO> obtenerNegociosPorContribuyente(String nitContribuyente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerNegociosPorContribuyente'");
    }

    @Override
    public Page<NegocioResponseDTO> obtenerNegocios(ObtenerNegociosRequestDTO requestDTO, Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerNegocios'");
    }

    @Override
    public NegocioResponseDTO registrarNegocio(RegistrarNegocioRequestDTO request) {
        Contribuyente contribuyente = contribuyenteRepository.findByNit(request.nitContribuyente())
                .orElseThrow(() -> ContribuyenteNotFoundException.forNit(request.nitContribuyente()));

        Negocio negocio = negocioMapper.toEntity(request);
        negocio.setContribuyente(contribuyente);
        negocio.setEstado(EstadoNegocio.ABIERTO);
        return negocioMapper.toResponseDTO(negocioRepository.save(negocio));
    }

    @Override
    public NegocioResponseDTO actualizarNegocio(UUID id, ActualizarNegocioRequestDTO request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarNegocio'");
    }

    @Override
    public boolean eliminarNegocio(UUID id) {
        if (!negocioRepository.existsById(id)) {
            throw NegocioNotFoundException.forId(id);
        }
        negocioRepository.deleteById(id);
        return true;
    }

}
