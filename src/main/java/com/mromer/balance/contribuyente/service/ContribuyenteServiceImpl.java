package com.mromer.balance.contribuyente.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mromer.balance.common.dto.PagedResponseDTO;
import com.mromer.balance.common.mapper.PageMapper;
import com.mromer.balance.contacto.exception.ContactoNotFoundException;
import com.mromer.balance.contacto.model.Contacto;
import com.mromer.balance.contacto.repository.ContactoRepository;
import com.mromer.balance.contribuyente.dto.request.*;
import com.mromer.balance.contribuyente.dto.response.*;
import com.mromer.balance.contribuyente.exception.*;
import com.mromer.balance.contribuyente.mapper.ContribuyenteMapper;
import com.mromer.balance.contribuyente.model.*;
import com.mromer.balance.contribuyente.repository.ContribuyenteRepository;
import com.mromer.balance.contribuyente.specification.ContribuyenteSpecs;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class ContribuyenteServiceImpl implements ContribuyenteService {
    private final ContribuyenteRepository contribuyenteRepository;
    private final ContactoRepository contactoRepository;
    private final ContribuyenteMapper contribuyenteMapper;

    @Override
    public ContribuyenteResponseDTO obtenerContribuyentePorNit(String nit) {
        Contribuyente contribuyente = contribuyenteRepository.findByNit(nit)
                .orElseThrow(() -> new RuntimeException("Contribuyente no encontrado con NIT: " + nit));
        return contribuyenteMapper.toResponseDTO(contribuyente);
    }

    @Override
    public PagedResponseDTO<ContribuyenteResponseDTO> obtenerContribuyentes(ObtenerContribuyentesRequestDTO requestDTO,
            Pageable pageable) {
        Specification<Contribuyente> specification = ContribuyenteSpecs.withFilters(
                requestDTO.searchTerm(),
                requestDTO.tipos(),
                requestDTO.regimenes(),
                requestDTO.tiposEmpresa());
        Page<Contribuyente> contribuyentePage = contribuyenteRepository.findAll(specification, pageable);
        Page<ContribuyenteResponseDTO> dtoPage = contribuyentePage.map(contribuyenteMapper::toResponseDTO);
        return PageMapper.toPagedResponse(dtoPage);
    }

    @Override
    public ContribuyenteResponseDTO registrarPequenoContribuyente(RegistrarPequenoContribuyenteRequestDTO requestDTO) {
        Contacto contacto = contactoRepository.findByTelefono(requestDTO.telefonoContacto()).orElseThrow(
            () -> ContactoNotFoundException.forTelefono(requestDTO.telefonoContacto())
        );

        if (contribuyenteRepository.existsByNit(requestDTO.nit())) {
            throw DuplicateContribuyenteException.forNit(requestDTO.nit());
        }

        Contribuyente contribuyente = Contribuyente.builder()
            .nit(requestDTO.nit())
            .nombre(contacto.getFullName())
            .tipo(TipoContribuyente.PEQUENO_CONTRIBUYENTE)
            .regimen(RegimenTributario.PEQUENO_CONTRIBUYENTE)
            .tipoEmpresa(TipoEmpresa.PERSONAL)
            .estado(EstadoContribuyente.ACTIVO)
            .contacto(contacto)
            .fechaNacimiento(requestDTO.fechaNacimiento())
            .build();
        
        Contribuyente savedContribuyente = contribuyenteRepository.save(contribuyente);
        return contribuyenteMapper.toResponseDTO(savedContribuyente);
    }

    @Override
    public ContribuyenteResponseDTO registrarContribuyenteGeneral(RegistrarContribuyenteGeneralRequestDTO requestDTO) {
        Contacto contacto = contactoRepository.findByTelefono(requestDTO.telefonoContacto()).orElseThrow(
            () -> ContactoNotFoundException.forTelefono(requestDTO.telefonoContacto())
        );

        if (contribuyenteRepository.existsByNit(requestDTO.nit())) {
            throw DuplicateContribuyenteException.forNit(requestDTO.nit());
        }

        Contribuyente contribuyente = Contribuyente.builder()
            .nit(requestDTO.nit())
            .nombre(requestDTO.nombre())
            .tipo(TipoContribuyente.CONTRIBUYENTE_GENERAL)
            .regimen(requestDTO.regimen())
            .tipoEmpresa(requestDTO.tipoEmpresa())
            .estado(EstadoContribuyente.ACTIVO)
            .contacto(contacto)
            .fechaNacimiento(requestDTO.fechaNacimiento())
            .build();
        
        Contribuyente savedContribuyente = contribuyenteRepository.save(contribuyente);
        return contribuyenteMapper.toResponseDTO(savedContribuyente);
    }


    @Override
    public ContribuyenteResponseDTO actualizarContacto(UUID id, ActualizarContactoContribuyenteRequestDTO requestDTO) {
        Contribuyente contribuyente = contribuyenteRepository.findById(id)
            .orElseThrow(
                () -> ContribuyenteNotFoundException.forId(id)
            );
        Contacto nuevoContacto = contactoRepository.findByTelefono(requestDTO.telefonoContacto())
            .orElseThrow(
                () -> ContactoNotFoundException.forTelefono(requestDTO.telefonoContacto())
            );
        contribuyente.setContacto(nuevoContacto);
        Contribuyente updatedContribuyente = contribuyenteRepository.save(contribuyente);
        return contribuyenteMapper.toResponseDTO(updatedContribuyente);
    }

    @Override
    public boolean eliminarContribuyente(UUID id) {
        if (!contribuyenteRepository.existsById(id)) {
            throw ContribuyenteNotFoundException.forId(id);
        }
        contribuyenteRepository.deleteById(id);
        return true;
    }
}
