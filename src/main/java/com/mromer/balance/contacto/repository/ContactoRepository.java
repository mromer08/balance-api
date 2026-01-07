package com.mromer.balance.contacto.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.mromer.balance.contacto.model.Contacto;

public interface ContactoRepository extends 
    JpaRepository<Contacto, UUID>,
    JpaSpecificationExecutor<Contacto> {

    Optional<Contacto> findByTelefono(String telefono);
    boolean existsByTelefono(String telefono);
    boolean existsByTelefonoAndIdNot(String telefono, UUID id);
    boolean existsByEmail(String email);
    boolean existsByEmailAndIdNot(String email, UUID id);
}
