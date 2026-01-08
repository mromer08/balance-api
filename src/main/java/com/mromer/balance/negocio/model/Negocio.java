package com.mromer.balance.negocio.model;

import java.util.UUID;

import com.mromer.balance.contribuyente.model.Contribuyente;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "negocios")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Negocio {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    private String razonSocial;

    @Enumerated(EnumType.STRING)
    private ActividadEconomica actividadEconomica;

    @Enumerated(EnumType.STRING)
    private EstadoNegocio estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contribuyente_id", nullable = false)
    private Contribuyente contribuyente;
}
