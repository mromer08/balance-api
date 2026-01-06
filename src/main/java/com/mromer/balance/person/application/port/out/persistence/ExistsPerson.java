package com.mromer.balance.person.application.port.out.persistence;

public interface ExistsPerson {
    boolean existsByCui(String cui);
    boolean existsById(Long id);
}
