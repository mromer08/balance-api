package com.mromer.balance.contribuyente.specification;

import java.util.Set;

import org.springframework.data.jpa.domain.Specification;

import com.mromer.balance.contribuyente.model.Contribuyente;
import com.mromer.balance.contribuyente.model.RegimenTributario;
import com.mromer.balance.contribuyente.model.TipoContribuyente;
import com.mromer.balance.contribuyente.model.TipoEmpresa;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ContribuyenteSpecs {

    public Specification<Contribuyente> withFilters(
            String searchTerm,
            Set<TipoContribuyente> tipos,
            Set<RegimenTributario> regimenes,
            Set<TipoEmpresa> tiposEmpresa) {
        return Specification.allOf(
                searchTermInAttributes(searchTerm),
                tipoInSet(tipos),
                regimenInSet(regimenes),
                tipoEmpresaInSet(tiposEmpresa));
    }

    public Specification<Contribuyente> searchTermInAttributes(String searchTerm) {
        return Specification.anyOf(
                nitEquals(searchTerm),
                nombreContains(searchTerm),
                nombresContactoContains(searchTerm),
                apellidosContactoContains(searchTerm));
    }

    public Specification<Contribuyente> nitEquals(String nit) {
        return (root, query, criteriaBuilder) -> (nit == null || nit.isBlank())
                ? null
                : criteriaBuilder.equal(root.get("nit"), nit);
    }

    public Specification<Contribuyente> nombreContains(String nombre) {
        return (root, query, criteriaBuilder) -> (nombre == null || nombre.isBlank())
                ? null
                : criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("nombre")),
                        "%" + nombre.toLowerCase() + "%");
    }

    public Specification<Contribuyente> tipoInSet(Set<TipoContribuyente> tipos){
        return (root, query, criteriaBuilder) -> (tipos == null || tipos.isEmpty())
            ? null
            : root.get("tipo").in(tipos);
    }

        public Specification<Contribuyente> regimenInSet(Set<RegimenTributario> regimenes){
        return (root, query, criteriaBuilder) -> (regimenes == null || regimenes.isEmpty())
            ? null
            : root.get("regimen").in(regimenes);
    }

    public Specification<Contribuyente> tipoEmpresaInSet(Set<TipoEmpresa> tiposEmpresa){
        return (root, query, criteriaBuilder) -> (tiposEmpresa == null || tiposEmpresa.isEmpty())
            ? null
            : root.get("tipoEmpresa").in(tiposEmpresa);
    }

    public Specification<Contribuyente> nombresContactoContains(String nombres) {
        return (root, query, criteriaBuilder) -> (nombres == null || nombres.isBlank())
                ? null
                : criteriaBuilder.like(
                        criteriaBuilder.lower(root.join("contacto").get("nombres")),
                        "%" + nombres.toLowerCase() + "%");
    }

    public Specification<Contribuyente> apellidosContactoContains(String apellidos) {
        return (root, query, criteriaBuilder) -> (apellidos == null || apellidos.isBlank())
                ? null
                : criteriaBuilder.like(
                        criteriaBuilder.lower(root.join("contacto").get("apellidos")),
                        "%" + apellidos.toLowerCase() + "%");
    }
}
