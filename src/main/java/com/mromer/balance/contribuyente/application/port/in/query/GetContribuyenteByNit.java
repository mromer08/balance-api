package com.mromer.balance.contribuyente.application.port.in.query;

import com.mromer.balance.contribuyente.application.dto.ContribuyenteResponseDTO;
import com.mromer.balance.contribuyente.domain.value.NIT;

public interface GetContribuyenteByNit {
    ContribuyenteResponseDTO getContribuyenteByNit(NIT nit);
}
