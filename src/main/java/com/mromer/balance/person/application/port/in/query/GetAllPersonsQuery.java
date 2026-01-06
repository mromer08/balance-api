package com.mromer.balance.person.application.port.in.query;

import java.util.Set;

import com.mromer.balance.person.domain.Gender;
import com.mromer.balance.person.domain.Honorific;

public record GetAllPersonsQuery(
    String searchTerm,
    Set<Honorific> honorifics,
    Set<Gender> genders
) {}
