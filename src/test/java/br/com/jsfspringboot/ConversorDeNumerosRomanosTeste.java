package br.com.jsfspringboot;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.jsfspringboot.romanos.ConversorDeNumerosRomanos;

public class ConversorDeNumerosRomanosTeste {
	
	@Test
	public void deveEntenderOSimboloI() {
		ConversorDeNumerosRomanos romano = new ConversorDeNumerosRomanos();
		int numero = romano.converte("I");
		assertEquals(1, numero);
	}
	
	@Test
	public void deveEntenderOSimboloV() {
		ConversorDeNumerosRomanos romano = new ConversorDeNumerosRomanos();
		int numero = romano.converte("V");
		assertEquals(5, numero);
	}
	
	@Test
	public void deveEntenderOSimboloComoII() {
		ConversorDeNumerosRomanos romano = new ConversorDeNumerosRomanos();
		int numero = romano.converte("II");
		assertEquals(2, numero);
	}
	
	@Test
	public void deveEntenderNumerosComoXXII() {
		ConversorDeNumerosRomanos romano = new ConversorDeNumerosRomanos();
		int numero = romano.converte("XXII");
		assertEquals(22, numero);
	}
	
	@Test
	public void deveEntenderNumerosComoIX() {
		ConversorDeNumerosRomanos romano = new ConversorDeNumerosRomanos();
		int numero = romano.converte("IX");
		assertEquals(9, numero);
	}
	

	@Test
	public void deveEntenderNumerosComoXXIV() {
		ConversorDeNumerosRomanos romano = new ConversorDeNumerosRomanos();
		int numero = romano.converte("XXIV");
		assertEquals(24, numero);
	}

}
