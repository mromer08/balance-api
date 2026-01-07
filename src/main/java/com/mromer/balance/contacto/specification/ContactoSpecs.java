package com.mromer.balance.contacto.specification;

import java.util.Set;

import org.springframework.data.jpa.domain.Specification;

import com.mromer.balance.contacto.model.*;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ContactoSpecs {
    public Specification<Contacto> withFilters(
            String searchTerm,
            Set<Honorifico> honorificos,
            Set<Genero> generos) {
        return Specification.allOf(
                searchTermInAttributes(searchTerm),
                honorificoInSet(honorificos),
                generoInSet(generos));
    }

    public Specification<Contacto> searchTermInAttributes(String searchTerm) {
        return Specification.anyOf(
                nombresContains(searchTerm),
                apellidosContains(searchTerm),
                telefonoEquals(searchTerm),
                emailEquals(searchTerm));
    }

    public Specification<Contacto> nombresContains(String nombres) {
        return (root, query, criteriaBuilder) -> (nombres == null || nombres.isBlank())
                ? null
                : criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("nombres")),
                        "%" + nombres.toLowerCase() + "%");
    }

    public Specification<Contacto> apellidosContains(String apellidos) {
        return (root, query, criteriaBuilder) -> (apellidos == null || apellidos.isBlank())
                ? null
                : criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("apellidos")),
                        "%" + apellidos.toLowerCase() + "%");
    }

    public Specification<Contacto> telefonoEquals(String telefono) {
        return (root, query, criteriaBuilder) -> (telefono == null || telefono.isBlank())
                ? null
                : criteriaBuilder.equal(root.get("telefono"), telefono);
    }

    public Specification<Contacto> emailEquals(String email) {
        return (root, query, criteriaBuilder) -> (email == null || email.isBlank())
                ? null
                : criteriaBuilder.equal(root.get("email"), email);
    }

    public Specification<Contacto> honorificoInSet(Set<Honorifico> honorificos) {
        return (root, query, criteriaBuilder) -> (honorificos == null || honorificos.isEmpty())
                ? null
                : root.get("honorifico").in(honorificos);
    }

    public Specification<Contacto> generoInSet(Set<Genero> generos) {
        return (root, query, criteriaBuilder) -> (generos == null || generos.isEmpty())
                ? null
                : root.get("genero").in(generos);
    }
}
