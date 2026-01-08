package com.mromer.balance.contribuyente.model;

import java.time.LocalDate;
import java.util.UUID;

import com.mromer.balance.contacto.model.Contacto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contribuyentes")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contribuyente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nit;
    private String nombre;

    @Enumerated(EnumType.STRING)
    private TipoContribuyente tipo;

    @Enumerated(EnumType.STRING)
    private RegimenTributario regimen;

    @Enumerated(EnumType.STRING)
    private TipoEmpresa tipoEmpresa;

    @Enumerated(EnumType.STRING)
    private EstadoContribuyente estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contacto_id", nullable = false)
    private Contacto contacto;
    
    private LocalDate fechaNacimiento;
}
