package com.mromer.balance.person.infrastructure.out.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PersonJpaRepository extends
        JpaRepository<PersonEntity, UUID>,
        JpaSpecificationExecutor<PersonEntity> {
    
    boolean existsByCui(String cui);
}
