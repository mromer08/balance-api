package com.mromer.balance.person.domain;

import java.time.LocalDate;

import com.mromer.balance.contribuyente.domain.value.NIT;
import com.mromer.balance.person.domain.value.PersonId;

import lombok.*;

@Getter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Person {

    private PersonId id;
    @NonNull
    private NIT nit;
    private String cui;
    @NonNull
    private String firstname;
    @NonNull
    private String lastname;
    private Honorific honorific;
    private Gender gender;
    private String phoneNumber;
    private String email;
    private LocalDate birthDate;

    public static Person register(
            NIT nit,
            String cui,
            String firstname,
            String lastname,
            Honorific honorific,
            Gender gender,
            String phoneNumber,
            String email,
            LocalDate birthDate) {
        return new Person(
                PersonId.generate(),
                nit,
                cui,
                firstname.trim().toUpperCase(),
                lastname.trim().toUpperCase(),
                honorific != null ? honorific : Honorific.NONE,
                gender != null ? gender : Gender.OTHER,
                phoneNumber,
                email,
                birthDate);
    }

    public static Person rehydrate(
            PersonId id,
            NIT nit,
            String cui,
            String firstname,
            String lastname,
            Honorific honorific,
            Gender gender,
            String phoneNumber,
            String email,
            LocalDate birthDate) {
        return new Person(
                id,
                nit,
                cui,
                firstname,
                lastname,
                honorific,
                gender,
                phoneNumber,
                email,
                birthDate);
    }

    public String getFullName() {
        return String.format("%s %s", firstname, lastname);
    }

    public void updateMainInformation(
            String cui,
            String firstname,
            String lastname,
            Honorific honorific,
            Gender gender,
            LocalDate birthDate) {
        if (cui != null && !cui.isBlank()) {
            this.cui = cui;
        }
        if (firstname != null && !firstname.isBlank()) {
            this.firstname = firstname.trim().toUpperCase();
        }
        if (lastname != null && !lastname.isBlank()) {
            this.lastname = lastname.trim().toUpperCase();
        }
        if (honorific != null) {
            this.honorific = honorific;
        }
        if (gender != null) {
            this.gender = gender;
        }
        if (birthDate != null) {
            this.birthDate = birthDate;
        }
    }

    public void updateContactInformation(
            String phoneNumber,
            String email) {
        if (phoneNumber != null && !phoneNumber.isBlank()) {
            this.phoneNumber = phoneNumber;
        }
        if (email != null && !email.isBlank()) {
            this.email = email;
        }
    }

    public void updateNIT(NIT nit) {
        this.nit = nit;
    }
}
