package com.mromer.balance.person.application.port.in.query;

import java.util.Set;

import org.springframework.data.domain.Pageable;

import com.mromer.balance.person.domain.Gender;
import com.mromer.balance.person.domain.Honorific;

public record GetAllPersonsQuery(
    String searchTerm,
    Set<Honorific> honorific,
    Set<Gender> gender,
    Pageable pageable
) {}
