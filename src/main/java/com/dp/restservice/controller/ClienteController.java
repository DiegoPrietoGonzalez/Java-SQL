package com.dp.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dp.restservice.dto.Cliente;

import com.dp.restservice.service.ClienteService;


@RestController
	// CONTRUCTOR N/A -- Direct to class
public class ClienteController {	
	
	@Autowired
    private ClienteService clienteService;

	@GetMapping("/api/cliente")
    public ResponseEntity<?> obtenerCliente(@RequestParam String tipoDocumento, @RequestParam String numeroDocumento) {
        try {
            if (!tipoDocumento.equals("C") && !tipoDocumento.equals("P")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tipo de documento inválido");
            }

            Cliente cliente = clienteService.obtenerCliente(tipoDocumento, numeroDocumento);
            if (cliente == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
            }

            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }
}

