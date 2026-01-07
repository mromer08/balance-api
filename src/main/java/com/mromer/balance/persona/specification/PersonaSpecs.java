package com.mromer.balance.persona.specification;

import java.util.Set;

import org.springframework.data.jpa.domain.Specification;

import com.mromer.balance.persona.model.*;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PersonaSpecs {
    public Specification<Persona> withFilters(
            String searchTerm,
            Set<Honorifico> honorificos,
            Set<Genero> generos) {
        return Specification.allOf(
                searchTermInAttributes(searchTerm),
                honorificoInSet(honorificos),
                generoInSet(generos));
    }

    public Specification<Persona> searchTermInAttributes(String searchTerm) {
        return Specification.anyOf(
                nombresContains(searchTerm),
                apellidosContains(searchTerm),
                cuiEquals(searchTerm),
                telefonoEquals(searchTerm),
                emailEquals(searchTerm));
    }

    public Specification<Persona> nombresContains(String nombres) {
        return (root, query, criteriaBuilder) -> (nombres == null || nombres.isBlank())
                ? null
                : criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("nombres")),
                        "%" + nombres.toLowerCase() + "%");
    }

    public Specification<Persona> apellidosContains(String apellidos) {
        return (root, query, criteriaBuilder) -> (apellidos == null || apellidos.isBlank())
                ? null
                : criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("apellidos")),
                        "%" + apellidos.toLowerCase() + "%");
    }

    public Specification<Persona> cuiEquals(String cui) {
        return (root, query, criteriaBuilder) -> (cui == null || cui.isBlank())
                ? null
                : criteriaBuilder.equal(root.get("cui"), cui);
    }

    public Specification<Persona> telefonoEquals(String telefono) {
        return (root, query, criteriaBuilder) -> (telefono == null || telefono.isBlank())
                ? null
                : criteriaBuilder.equal(root.get("telefono"), telefono);
    }

    public Specification<Persona> emailEquals(String email) {
        return (root, query, criteriaBuilder) -> (email == null || email.isBlank())
                ? null
                : criteriaBuilder.equal(root.get("email"), email);
    }

    public Specification<Persona> honorificoInSet(Set<Honorifico> honorificos) {
        return (root, query, criteriaBuilder) -> (honorificos == null || honorificos.isEmpty())
                ? null
                : root.get("honorifico").in(honorificos);
    }

    public Specification<Persona> generoInSet(Set<Genero> generos) {
        return (root, query, criteriaBuilder) -> (generos == null || generos.isEmpty())
                ? null
                : root.get("genero").in(generos);
    }
}
