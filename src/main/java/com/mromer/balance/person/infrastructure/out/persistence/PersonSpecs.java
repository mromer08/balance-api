package com.mromer.balance.person.infrastructure.out.persistence;

import java.util.Set;

import org.springframework.data.jpa.domain.Specification;

import com.mromer.balance.person.domain.Gender;
import com.mromer.balance.person.domain.Honorific;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PersonSpecs {

    public Specification<PersonEntity> withFilters(
            String searchTerm,
            Set<Honorific> honorifics,
            Set<Gender> genders) {
        return Specification.allOf(
                searchTermInAttributes(searchTerm),
                honorificInSet(honorifics),
                genderInSet(genders));
    }

    public Specification<PersonEntity> searchTermInAttributes(String searchTerm) {
        return Specification.anyOf(
                firstNameContains(searchTerm),
                lasteNameContains(searchTerm),
                cuiEquals(searchTerm),
                phoneNumberEquals(searchTerm),
                emailEquals(searchTerm));
    }

    public Specification<PersonEntity> firstNameContains(String firstName) {
        return (root, query, criteriaBuilder) -> (firstName == null || firstName.isBlank())
                ? null
                : criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("firstName")),
                        "%" + firstName.toLowerCase() + "%");
    }

    public Specification<PersonEntity> lasteNameContains(String lasteName) {
        return (root, query, criteriaBuilder) -> (lasteName == null || lasteName.isBlank())
                ? null
                : criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("lasteName")),
                        "%" + lasteName.toLowerCase() + "%");
    }

    public Specification<PersonEntity> cuiEquals(String cui) {
        return (root, query, criteriaBuilder) -> (cui == null || cui.isBlank())
                ? null
                : criteriaBuilder.equal(root.get("cui"), cui);
    }

    public Specification<PersonEntity> phoneNumberEquals(String phoneNumber) {
        return (root, query, criteriaBuilder) -> (phoneNumber == null || phoneNumber.isBlank())
                ? null
                : criteriaBuilder.equal(root.get("phoneNumber"), phoneNumber);
    }

    public Specification<PersonEntity> emailEquals(String email) {
        return (root, query, criteriaBuilder) -> (email == null || email.isBlank())
                ? null
                : criteriaBuilder.equal(root.get("email"), email);
    }

    public Specification<PersonEntity> honorificInSet(Set<Honorific> honorifics) {
        return (root, query, criteriaBuilder) -> (honorifics == null || honorifics.isEmpty())
                ? null
                : root.get("honorific").in(honorifics);
    }

    public Specification<PersonEntity> genderInSet(Set<Gender> genders) {
        return (root, query, criteriaBuilder) -> (genders == null || genders.isEmpty())
                ? null
                : root.get("gender").in(genders);
    }

}
