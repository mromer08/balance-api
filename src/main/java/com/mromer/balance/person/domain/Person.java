package com.mromer.balance.person.domain;

import java.time.LocalDate;

import com.mromer.balance.person.domain.value.PersonId;

import lombok.*;

@Getter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Person {

    private PersonId id;
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
        this.cui = cui;
        this.firstname = firstname.trim().toUpperCase();
        this.lastname = lastname.trim().toUpperCase();
        this.honorific = honorific;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public void updateContactInformation(
            String phoneNumber,
            String email) {
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
