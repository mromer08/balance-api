package com.mromer.balance.contacto.model;

import java.util.Objects;

public enum Honorifico {

    NINGUNO(
            new Variante("Sr.", "Sra.", "Sr./Sra.")),

    LICENCIADO(
            new Variante("Lic.", "Licda.", "Lic./Licda.")),

    INGENIERO(
            new Variante("Ing.", "Inga.", "Ing./Inga.")),

    DOCTOR(
            new Variante("Dr.", "Dra.", "Dr./Dra.")),

    ARQUITECTO(
            new Variante("Arq.", "Arq.", "Arq."));

    private final Variante variante;

    Honorifico(Variante variante) {
        this.variante = Objects.requireNonNull(variante);
    }

    public String display(Genero genero) {
        if (genero == null) {
            genero = Genero.OTRO;
        }
        return variante.forGender(genero);
    }

    private record Variante(
            String masculino,
            String femenino,
            String otro) {
        String forGender(Genero genero) {
            return switch (genero) {
                case MASCULINO -> masculino;
                case FEMENINO -> femenino;
                case OTRO -> otro;
            };
        }
    }
}
