package com.frvazquez.bankayohr.service;

import com.frvazquez.bankayohr.constants.Constants;

public class MetodoPow {
	
	public double getPow(int a, int b) {

		if(b == 0)
			throw new ArithmeticException(Constants.MSG_ERROR_POW);
		
		double resultado = 0;
		int sum = 0;
		for (int i = 0; i < a; i++) {
			sum += a;
		}
				
		for (int j = 0; j < b-2; j++) {
			sum = getSumFor(sum, a);
		}
		resultado =sum;
		return resultado;
	}
	
	private int getSumFor(int valor, int ciclo) {
		int resultado = valor;
		for (int i = 0; i < ciclo-1; i++) {
			resultado += valor;
		}
		return resultado;
	}
}
