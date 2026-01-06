package com.mromer.balance.person.infrastructure.out.persistence;

import java.time.LocalDate;
import java.util.UUID;

import com.mromer.balance.person.domain.Gender;
import com.mromer.balance.person.domain.Honorific;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity {
    @Id
    private UUID id;
    
    private String cui;
    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Honorific honorific;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String phoneNumber;
    private String email;
    private LocalDate birthDate;
}
