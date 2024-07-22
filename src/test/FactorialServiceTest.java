package com.dp.restservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class FactorialServiceTest {
	@InjectMocks
	private FactorialService factorialService;

	public FactorialServiceTest() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testCalcularFactorial() {
		assertEquals(1, factorialService.calcularFactorial(0));
		assertEquals(1, factorialService.calcularFactorial(1));
		assertEquals(2, factorialService.calcularFactorial(2));
		assertEquals(6, factorialService.calcularFactorial(3));
		assertEquals(24, factorialService.calcularFactorial(4));
	}
}
