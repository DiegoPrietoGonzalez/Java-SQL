package com.dp.restservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dp.restservice.dto.Cliente;
import com.dp.restservice.entity.ClienteEntity;
import com.dp.restservice.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente obtenerCliente(String tipoDocumento, String numeroDocumento) {
        ClienteEntity clienteEntity = clienteRepository.findByTipoDocumentoAndIdDocumento(tipoDocumento, numeroDocumento);
        if (clienteEntity != null) {
            Cliente cliente = new Cliente();
            cliente.setPrimerNombre(clienteEntity.getPrimerNombre());
            cliente.setSegundoNombre(clienteEntity.getSegundoNombre());
            cliente.setPrimerApellido(clienteEntity.getPrimerApellido());
            cliente.setSegundoApellido(clienteEntity.getSegundoApellido());
            cliente.setTelefono(clienteEntity.getTelefono());
            cliente.setDireccion(clienteEntity.getDireccion());
            cliente.setCiudadResidencia(clienteEntity.getCiudadResidencia());
            return cliente;
        }
        return null;
    }
}
