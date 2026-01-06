package com.mromer.balance.contribuyente.domain.value;

import java.util.UUID;

import com.mromer.balance.common.domain.exception.DomainException;

public record ContribuyenteId(UUID value) {
    public ContribuyenteId {
        if (value == null) {
            throw new DomainException("PersonId value cannot be null");
        }
    }

    public static ContribuyenteId of(UUID value) {
        return new ContribuyenteId(value);
    }

    public static ContribuyenteId generate() {
        return new ContribuyenteId(UUID.randomUUID());
    }

    @Override
    public String toString() {
        return value().toString();
    }
}
