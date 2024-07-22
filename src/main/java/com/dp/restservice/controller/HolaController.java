package com.dp.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dp.restservice.service.FactorialService;


@RestController
@RequestMapping("/api")
public class HolaController {
	
	@Autowired
    private FactorialService factorialService;

	@GetMapping("/hola")
    public String saludo() {
        return "{\"mensaje\": \"Soy el equipo ROMA\"}";
    }

    @GetMapping("/factorial/{numero}")
    public ResponseEntity<?> calcularFactorial(@PathVariable int numero) {
        try {
            if (numero < 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El número debe ser no negativo");
            }
            long resultado = factorialService.calcularFactorial(numero);
            return ResponseEntity.ok("{\"factorial\": " + resultado + "}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }
}

