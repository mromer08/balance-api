package com.mromer.balance.persona.controller;

import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mromer.balance.common.dto.PagedResponseDTO;
import com.mromer.balance.persona.dto.request.ActualizarPersonaRequestDTO;
import com.mromer.balance.persona.dto.request.ObtenerPersonasRequestDTO;
import com.mromer.balance.persona.dto.request.RegistrarPersonaRequestDTO;
import com.mromer.balance.persona.dto.response.PersonaResponseDTO;
import com.mromer.balance.persona.service.PersonaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/personas")
@RequiredArgsConstructor
public class PersonaController {
    private final PersonaService personaService;

    @GetMapping
    public ResponseEntity<PagedResponseDTO<PersonaResponseDTO>> obtenerPersonas(
        @RequestBody(required = false) ObtenerPersonasRequestDTO requestDTO,
        @PageableDefault Pageable pageable
    ) {
        return ResponseEntity.ok(personaService.obtenerPersonas(requestDTO, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaResponseDTO> obtenerPersonaPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(personaService.obtenerPersonaPorId(id));
    }

    @PostMapping
    public ResponseEntity<PersonaResponseDTO> registrarPersona(@RequestBody @Valid RegistrarPersonaRequestDTO requestDTO) {
        PersonaResponseDTO responseDTO = personaService.registrarPersona(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);        
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PersonaResponseDTO> actualizarPersona(
        @PathVariable UUID id,
        @RequestBody @Valid ActualizarPersonaRequestDTO requestDTO
    ) {
        PersonaResponseDTO responseDTO = personaService.actualizarPersona(id, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable UUID id) {
        personaService.eliminarPersona(id);
        return ResponseEntity.noContent().build();
    }
    
}
