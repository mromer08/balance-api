package com.mromer.balance.contacto.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mromer.balance.common.text.TextNormalizer;
import com.mromer.balance.contacto.dto.request.ActualizarContactoRequestDTO;
import com.mromer.balance.contacto.dto.request.ObtenerContactosRequestDTO;
import com.mromer.balance.contacto.dto.request.RegistrarContactoRequestDTO;
import com.mromer.balance.contacto.dto.response.ContactoResponseDTO;
import com.mromer.balance.contacto.exception.ContactoNotFoundException;
import com.mromer.balance.contacto.exception.DuplicateContactoException;
import com.mromer.balance.contacto.mapper.ContactoMapper;
import com.mromer.balance.contacto.model.Contacto;
import com.mromer.balance.contacto.repository.ContactoRepository;
import com.mromer.balance.contacto.specification.ContactoSpecs;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class ContactoServiceImpl implements ContactoService{
    private final ContactoRepository contactoRepository;
    private final ContactoMapper contactoMapper;
    @Override
    public ContactoResponseDTO obtenerContactoPorTelefono(String telefono) {
        Contacto contacto = contactoRepository.findByTelefono(telefono)
                .orElseThrow(() -> ContactoNotFoundException.forTelefono(telefono));
        return contactoMapper.toResponseDTO(contacto);
    }

    @Override
    public Page<ContactoResponseDTO> obtenerContactos(ObtenerContactosRequestDTO requestDTO, Pageable pageable) {
        Specification<Contacto> specification = ContactoSpecs.withFilters(
                requestDTO.searchTerm(),
                requestDTO.honorificos(),
                requestDTO.generos());
        return contactoRepository.findAll(specification, pageable)
                .map(contactoMapper::toResponseDTO);
    }

    @Override
    public ContactoResponseDTO registrarContacto(RegistrarContactoRequestDTO requestDTO) {
        if (contactoRepository.existsByTelefono(requestDTO.telefono())) {
            throw DuplicateContactoException.forTelefono(requestDTO.telefono());
        }

        String email = TextNormalizer.normalizeEmailLowercase(requestDTO.email());
        if (email != null && contactoRepository.existsByEmail(email)) {
            throw DuplicateContactoException.forEmail(email);
        }

        Contacto contacto = contactoMapper.toEntity(requestDTO);
        return contactoMapper.toResponseDTO(contactoRepository.save(contacto));
    }

    @Override
    public ContactoResponseDTO actualizarContacto(UUID id, ActualizarContactoRequestDTO requestDTO) {
        Contacto contacto = contactoRepository.findById(id)
                .orElseThrow(() -> ContactoNotFoundException.forId(id));

        if (contactoRepository.existsByTelefonoAndIdNot(requestDTO.telefono(), id)) {
            throw DuplicateContactoException.forTelefono(requestDTO.telefono());
        }

        String email = TextNormalizer.normalizeEmailLowercase(requestDTO.email());

        if (contactoRepository.existsByEmailAndIdNot(email, id)) {
            throw DuplicateContactoException.forEmail(email);
        }

        contactoMapper.updateEntityFromDTO(requestDTO, contacto);
        return contactoMapper.toResponseDTO(contactoRepository.save(contacto));
    }

    @Override
    public boolean eliminarContacto(UUID id) {
        if (!contactoRepository.existsById(id)) {
            throw ContactoNotFoundException.forId(id);
        }
        contactoRepository.deleteById(id);
        return true;
    }
    
}
