package com.mromer.balance.contacto.controller;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mromer.balance.common.dto.PagedResponseDTO;
import com.mromer.balance.common.mapper.PageMapper;
import com.mromer.balance.contacto.dto.request.*;
import com.mromer.balance.contacto.dto.response.ContactoResponseDTO;
import com.mromer.balance.contacto.service.ContactoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/v1/contactos")
@RequiredArgsConstructor
public class ContactoController {
    private final ContactoService contactoService;

    @GetMapping
    public ResponseEntity<PagedResponseDTO<ContactoResponseDTO>> obtenerContactos(
        ObtenerContactosRequestDTO requestDTO,
        @PageableDefault Pageable pageable
    ) {
        Page<ContactoResponseDTO> contactos = contactoService.obtenerContactos(requestDTO, pageable);
        return ResponseEntity.ok(PageMapper.toPagedResponse(contactos));
    }

    @GetMapping("/{telefono}")
    public ResponseEntity<ContactoResponseDTO> obtenerContactoPorTelefono(@PathVariable String telefono) {
        return ResponseEntity.ok(contactoService.obtenerContactoPorTelefono(telefono));
    }

    @PostMapping
    public ResponseEntity<ContactoResponseDTO> registrarContacto(@RequestBody @Valid RegistrarContactoRequestDTO requestDTO) {
        ContactoResponseDTO responseDTO = contactoService.registrarContacto(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ContactoResponseDTO> actualizarContacto(
        @PathVariable UUID id,
        @RequestBody @Valid ActualizarContactoRequestDTO requestDTO
    ) {
        ContactoResponseDTO responseDTO = contactoService.actualizarContacto(id, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarContacto(@PathVariable UUID id) {
        contactoService.eliminarContacto(id);
        return ResponseEntity.noContent().build();
    }
}