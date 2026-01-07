package com.mromer.balance.contacto.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mromer.balance.contacto.dto.request.ActualizarContactoRequestDTO;
import com.mromer.balance.contacto.dto.request.ObtenerContactosRequestDTO;
import com.mromer.balance.contacto.dto.request.RegistrarContactoRequestDTO;
import com.mromer.balance.contacto.dto.response.ContactoResponseDTO;

public interface ContactoService {
    ContactoResponseDTO obtenerContactoPorTelefono(String telefono);
    Page<ContactoResponseDTO> obtenerContactos(ObtenerContactosRequestDTO requestDTO, Pageable pageable);
    ContactoResponseDTO registrarContacto(RegistrarContactoRequestDTO requestDTO);
    ContactoResponseDTO actualizarContacto(UUID id, ActualizarContactoRequestDTO requestDTO);
    boolean eliminarContacto(UUID id);
}
