package com.mromer.balance.person.domain;

import java.util.Objects;

public enum Honorific {

    NONE(
        new Variant("Sr.", "Sra.", "Sr./Sra.")
    ),

    LICENSED_PROFESSIONAL(
        new Variant("Lic.", "Licda.", "Lic./Licda.")
    ),

    ENGINEER(
        new Variant("Ing.", "Inga.", "Ing./Inga.")
    ),

    DOCTOR(
        new Variant("Dr.", "Dra.", "Dr./Dra.")
    ),

    ARCHITECT(
        new Variant("Arq.", "Arq.", "Arq.")
    );

    private final Variant variant;

    Honorific(Variant variant) {
        this.variant = Objects.requireNonNull(variant);
    }

    public String display(Gender gender) {
        if (gender == null) {
            gender = Gender.OTHER;
        }
        return variant.forGender(gender);
    }

    private record Variant(
        String male,
        String female,
        String other
    ) {
        String forGender(Gender gender) {
            return switch (gender) {
                case MALE -> male;
                case FEMALE -> female;
                case OTHER -> other;
            };
        }
    }
}
