package com.mromer.balance.contribuyente.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.mromer.balance.contribuyente.model.Contribuyente;
import com.mromer.balance.contribuyente.model.TipoContribuyente;

public interface ContribuyenteRepository extends
    JpaRepository<Contribuyente, UUID>,
    JpaSpecificationExecutor<Contribuyente> {
    boolean existsByNit(String nit);
    boolean existsByNitAndIdNot(String nit, UUID id);
    boolean existsByRazonSocial(String razonSocial);
    boolean existsByRazonSocialAndIdNot(String razonSocial, UUID id);
    Optional<Contribuyente> findByNit(String nit);
    Optional<Contribuyente> findByNitAndTipo(String nit, TipoContribuyente tipo);
}
