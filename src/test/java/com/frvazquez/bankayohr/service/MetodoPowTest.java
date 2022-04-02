package com.frvazquez.bankayohr.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.frvazquez.bankayohr.constants.Constants;

public class MetodoPowTest {

	
	MetodoPow metodo;
	
	@BeforeEach
	public void setUp() {
		metodo = new MetodoPow();
	}
	
	
	@Test
	public void powTest() {
		double resultado = metodo.getPow(2, 4);
		
		assertEquals(16.0, resultado);
		
	}
	
	@Test
	public void powExceptionTest() {
		Exception resultado = assertThrows(ArithmeticException.class, () -> metodo.getPow(3, 0));

		assertEquals(ArithmeticException.class, resultado.getClass());
		assertEquals(Constants.MSG_ERROR_POW, resultado.getMessage());		
	}
	
	@AfterEach
	public void tearDown() {
		metodo=null;
	}
	
}
