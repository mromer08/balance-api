package com.mromer.balance.persona.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.mromer.balance.persona.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, UUID>, JpaSpecificationExecutor<Persona> {
    boolean existsByNit(String nit);
    boolean existsByCui(String cui);
    boolean existsByNitAndIdNot(String nit, UUID id);
    boolean existsByCuiAndIdNot(String cui, UUID id);
    Optional<Persona> findByNit(String nit);
}
