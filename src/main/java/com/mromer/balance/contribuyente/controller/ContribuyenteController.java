package com.mromer.balance.contribuyente.controller;

import org.springframework.web.bind.annotation.*;

import com.mromer.balance.common.dto.PagedResponseDTO;
import com.mromer.balance.contribuyente.dto.request.*;
import com.mromer.balance.contribuyente.dto.response.ContribuyenteResponseDTO;
import com.mromer.balance.contribuyente.model.*;
import com.mromer.balance.contribuyente.service.ContribuyenteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/v1/contribuyentes")
@RequiredArgsConstructor
public class ContribuyenteController {
    private final ContribuyenteService contribuyenteService;

    @GetMapping()
    public ResponseEntity<PagedResponseDTO<ContribuyenteResponseDTO>> obtenerContribuyentes(
            ObtenerContribuyentesRequestDTO requestDTO,
            @PageableDefault Pageable pageable) {
        PagedResponseDTO<ContribuyenteResponseDTO> response = contribuyenteService.obtenerContribuyentes(requestDTO,
                pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/generales")
    public ResponseEntity<PagedResponseDTO<ContribuyenteResponseDTO>> obtenerContribuyentesGenerales(
            @RequestParam(required = false) String searchTerm,
            @RequestParam(required = false) Set<RegimenTributario> regimenes,
            @RequestParam(required = false) Set<TipoEmpresa> tiposEmpresa,
            @PageableDefault Pageable pageable) {
        ObtenerContribuyentesRequestDTO requestDTO = new ObtenerContribuyentesRequestDTO(
                searchTerm,
                Set.of(TipoContribuyente.CONTRIBUYENTE_GENERAL),
                regimenes,
                tiposEmpresa);
        PagedResponseDTO<ContribuyenteResponseDTO> response = contribuyenteService.obtenerContribuyentes(requestDTO,
                pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/pequenos")
    public ResponseEntity<PagedResponseDTO<ContribuyenteResponseDTO>> obtenerPequenosContribuyentes(
            @RequestParam(required = false) String searchTerm,
            @PageableDefault Pageable pageable) {
        ObtenerContribuyentesRequestDTO requestDTO = new ObtenerContribuyentesRequestDTO(
                searchTerm,
                Set.of(TipoContribuyente.PEQUENO_CONTRIBUYENTE),
                Set.of(),
                Set.of());
        PagedResponseDTO<ContribuyenteResponseDTO> response = contribuyenteService.obtenerContribuyentes(requestDTO,
                pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{nit}")
    public ResponseEntity<ContribuyenteResponseDTO> obtenerContribuyentePorNit(@PathVariable String nit) {
        ContribuyenteResponseDTO responseDTO = contribuyenteService.obtenerContribuyentePorNit(nit);
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/pequeno")
    public ResponseEntity<ContribuyenteResponseDTO> registrarPequenoContribuyente(
            @RequestBody @Valid RegistrarPequenoContribuyenteRequestDTO requestDTO) {
        ContribuyenteResponseDTO responseDTO = contribuyenteService.registrarPequenoContribuyente(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/general")
    public ResponseEntity<ContribuyenteResponseDTO> registrarContribuyenteGeneral(
            @RequestBody @Valid RegistrarContribuyenteGeneralRequestDTO requestDTO) {
        ContribuyenteResponseDTO responseDTO = contribuyenteService.registrarContribuyenteGeneral(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @PatchMapping("/{id}/cambiar-contacto")
    public ResponseEntity<ContribuyenteResponseDTO> cambiarContactoContribuyente(@PathVariable UUID id,
            @RequestBody @Valid CambiarContactoContribuyenteRequestDTO requestDTO) {
        ContribuyenteResponseDTO responseDTO = contribuyenteService.cambiarContacto(id, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarContribuyente(@PathVariable UUID id) {
        contribuyenteService.eliminarContribuyente(id);
        return ResponseEntity.noContent().build();
    }
}
