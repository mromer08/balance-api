package com.mromer.balance.contacto.model;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contactos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String telefono;
    private String nombres;
    private String apellidos;
    @Enumerated(EnumType.STRING)
    private Honorifico honorifico;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    private String telefonoSecundario;
    private String email;

    public String getFullName() {
        return nombres + " " + apellidos;
    }
}
