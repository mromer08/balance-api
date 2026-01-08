package com.mromer.balance.negocio.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.mromer.balance.negocio.model.Negocio;
import com.mromer.balance.contribuyente.model.Contribuyente;


public interface NegocioRepository extends
    JpaRepository<Negocio, UUID>,
    JpaSpecificationExecutor<Negocio> {
    List<Negocio> findByContribuyente(Contribuyente contribuyente);
}
