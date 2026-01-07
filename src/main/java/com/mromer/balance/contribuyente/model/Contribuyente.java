package com.mromer.balance.contribuyente.model;

import java.time.LocalDate;
import java.util.UUID;

import com.mromer.balance.persona.model.Persona;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contribuyentes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contribuyente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nit;
    private String razonSocial;

    @Enumerated(EnumType.STRING)
    private TipoContribuyente tipo;

    @Enumerated(EnumType.STRING)
    private RegimenTributario regimen;

    @Enumerated(EnumType.STRING)
    private TipoEmpresa tipoEmpresa;

    @Enumerated(EnumType.STRING)
    private EstadoContribuyente estado;
    
    @Enumerated(EnumType.STRING)
    private RentaBruta rentaBruta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "representante_id", nullable = false)
    private Persona representante;
    
    private LocalDate fechaApertura;
}
