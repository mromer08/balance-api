package com.mromer.balance.contribuyente.domain;

import java.time.LocalDate;

import com.mromer.balance.common.domain.exception.DomainException;
import com.mromer.balance.contribuyente.domain.value.ContribuyenteId;
import com.mromer.balance.contribuyente.domain.value.NIT;
import com.mromer.balance.person.domain.Person;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(of = "nit")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Contribuyente {
    private ContribuyenteId id;
    private NIT nit;
    private String razonSocial;
    private TipoContribuyente tipo;
    private RegimenTributario regimen;
    private TipoEmpresa tipoEmpresa;
    private EstadoContribuyente estado;
    private RentaBruta rentaBruta;
    private Person representante;
    private LocalDate fechaApertura;

    public static Contribuyente register(
            NIT nit,
            String razonSocial,
            TipoContribuyente tipo,
            RegimenTributario regimen,
            TipoEmpresa tipoEmpresa,
            RentaBruta rentaBruta,
            Person representante,
            LocalDate fechaApertura) {
        if (fechaApertura != null &&
                tipoEmpresa != TipoEmpresa.SOCIEDAD_ANONIMA &&
                tipoEmpresa != TipoEmpresa.ORGANIZACION_CIVIL) {
            throw new DomainException(
                    "Solo las sociedades anónimas u organizaciones civiles pueden tener fecha de apertura");
        }

        if (tipo == TipoContribuyente.PEQUENO_CONTRIBUYENTE && 
            regimen != RegimenTributario.PEQUENO_CONTRIBUYENTE
        ) {
            throw new DomainException(
                    "Los pequeños contribuyentes deben pertenecer al régimen de pequeño contribuyente");
        }

        return new Contribuyente(
                ContribuyenteId.generate(),
                nit,
                razonSocial.trim().toUpperCase(),
                tipo,
                regimen,
                tipoEmpresa,
                EstadoContribuyente.ACTIVO,
                rentaBruta,
                representante,
                fechaApertura);
    }

    public static Contribuyente rehydrate(
            ContribuyenteId id,
            NIT nit,
            String razonSocial,
            TipoContribuyente tipo,
            RegimenTributario regimen,
            TipoEmpresa tipoEmpresa,
            EstadoContribuyente estadoContribuyente,
            RentaBruta rentaBruta,
            Person representante,
            LocalDate fechaApertura) {
        return new Contribuyente(
                id,
                nit,
                razonSocial,
                tipo,
                regimen,
                tipoEmpresa,
                estadoContribuyente,
                rentaBruta,
                representante,
                fechaApertura);
    }

    public void updateContribuyente(
            NIT nit,
            String razonSocial,
            TipoContribuyente tipo,
            RegimenTributario regimen,
            TipoEmpresa tipoEmpresa,
            RentaBruta rentaBruta,
            LocalDate fechaApertura) {
        if (this.estado != EstadoContribuyente.ACTIVO) {
            throw new DomainException("Solo los contribuyentes activos pueden ser modificados");
        }

        if (nit != null) {
            this.nit = nit;
        }
        if (razonSocial != null && !razonSocial.isBlank()) {
            this.razonSocial = razonSocial.trim().toUpperCase();
        }
        if (tipo != null) {
            this.tipo = tipo;
        }
        if (regimen != null) {
            this.regimen = regimen;
        }
        if (tipoEmpresa != null) {
            this.tipoEmpresa = tipoEmpresa;
        }
        if (rentaBruta != null) {
            this.rentaBruta = rentaBruta;
        }
        if (fechaApertura != null) {
            this.fechaApertura = fechaApertura;
        }
    }

    public void changeRepresentante(Person newRepresentante) {
        if (this.estado != EstadoContribuyente.ACTIVO) {
            throw new DomainException("Solo los contribuyentes activos pueden cambiar de representante legal");
            
        }
        if (newRepresentante == null) {
            throw new DomainException("El representante legal no puede ser nulo");
        }
        this.representante = newRepresentante;
    }
}
