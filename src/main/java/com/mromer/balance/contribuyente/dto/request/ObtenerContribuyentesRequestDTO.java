package com.mromer.balance.contribuyente.dto.request;

import java.util.Set;

import com.mromer.balance.contribuyente.model.RegimenTributario;
import com.mromer.balance.contribuyente.model.TipoContribuyente;
import com.mromer.balance.contribuyente.model.TipoEmpresa;

public record ObtenerContribuyentesRequestDTO(
    String searchTerm,
    Set<TipoContribuyente> tipos,
    Set<RegimenTributario> regimenes,
    Set<TipoEmpresa> tiposEmpresa
) {}
