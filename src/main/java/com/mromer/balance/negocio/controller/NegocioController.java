package com.mromer.balance.negocio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mromer.balance.negocio.dto.request.RegistrarNegocioRequestDTO;
import com.mromer.balance.negocio.dto.response.NegocioResponseDTO;
import com.mromer.balance.negocio.service.NegocioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/negocios")
@RequiredArgsConstructor
public class NegocioController {
    private final NegocioService negocioService;

    @GetMapping("/{id}")
    public ResponseEntity<NegocioResponseDTO> obtenerNegocioPorIdEntity(@PathVariable UUID id) {
        NegocioResponseDTO negocio = negocioService.obtenerNegocioPorId(id);
        return ResponseEntity.ok(negocio);
    }

    @PostMapping
    public ResponseEntity<NegocioResponseDTO> registrarNegocio(@RequestBody @Valid RegistrarNegocioRequestDTO requestDTO) {
        NegocioResponseDTO negocio = negocioService.registrarNegocio(requestDTO);
        return ResponseEntity.ok(negocio);
    }

    @DeleteMapping
    public ResponseEntity<Void> eliminarNegocio(@RequestParam UUID id) {
        negocioService.eliminarNegocio(id);
        return ResponseEntity.noContent().build();
    }
}
