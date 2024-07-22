package com.dp.restservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.dp.restservice.dto.Cliente;
import com.dp.restservice.entity.ClienteEntity;
import com.dp.restservice.repository.ClienteRepository;
import com.dp.restservice.service.ClienteService;

public class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testObtenerCliente() {
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setTipoDocumento("C");
        clienteEntity.setIdDocumento("23445322");
        clienteEntity.setPrimerNombre("Juan");
        clienteEntity.setSegundoNombre("Carlos");
        clienteEntity.setPrimerApellido("Pérez");
        clienteEntity.setSegundoApellido("García");
        clienteEntity.setTelefono("123456789");
        clienteEntity.setDireccion("Calle Falsa 123");
        clienteEntity.setCiudadResidencia("Bogotá");

        when(clienteRepository.findByTipoDocumentoAndIdDocumento("C", "23445322")).thenReturn(clienteEntity);

        Cliente cliente = clienteService.obtenerCliente("C", "23445322");

        assertEquals("Juan", cliente.getPrimerNombre());
        assertEquals("Carlos", cliente.getSegundoNombre());
        assertEquals("Pérez", cliente.getPrimerApellido());
        assertEquals("García", cliente.getSegundoApellido());
        assertEquals("123456789", cliente.getTelefono());
        assertEquals("Calle Falsa 123", cliente.getDireccion());
        assertEquals("Bogotá", cliente.getCiudadResidencia());
    }

    @Test
    public void testObtenerClienteNoEncontrado() {
        when(clienteRepository.findByTipoDocumentoAndIdDocumento("C", "99999999")).thenReturn(null);

        Cliente cliente = clienteService.obtenerCliente("C", "99999999");

        assertNull(cliente);
    }
}
