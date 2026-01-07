package com.mromer.balance.persona.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "personas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nit;
    private String cui;
    private String nombres;
    private String apellidos;

    @Enumerated(EnumType.STRING)
    private Honorifico honorifico;

    @Enumerated(EnumType.STRING)
    private Genero genero;
    
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;

    public String getNombreCompleto() {
        return String.format("%s, %s", this.apellidos, this.nombres);
    }

}
