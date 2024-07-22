package com.dp.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dp.restservice.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, String> {
    ClienteEntity findByTipoDocumentoAndIdDocumento(String tipoDocumento, String idDocumento);
}
