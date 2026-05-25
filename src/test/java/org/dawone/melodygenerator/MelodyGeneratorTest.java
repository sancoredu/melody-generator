package org.dawone.melodygenerator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class MelodyGeneratorTest {
	private MelodyGenerator generator;
	private Random fixedRandom;

	private MelodyGenerator generador;

	@BeforeEach
	void setUp() {
		generator = new MelodyGenerator(new Random(42));
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 8, -5})
	void testGenerateMelody_CantidadCompasesInvalida_DeberiaLanzarIllegalArgumentException(int compasesErroneos) {
		// Act & Assert
		IllegalArgumentException excepcion = assertThrows(IllegalArgumentException.class, () -> {
			generator.generateMelody(compasesErroneos);
		}, "Debería lanzar excepción si el número de compases no vale");

		String mensajeEsperado = "measuresCount must be between 1 and 7";
		assertEquals(mensajeEsperado, excepcion.getMessage());
	}

	@Test
	void testGenerateMelody_CantidadCompasesValida_DevuelveEstructuraConBarrasSimplesSeparadoras() {
		int cantidadCompases = 4;

		String melodia = generator.generateMelody(cantidadCompases);

		assertNotNull(melodia, "La melodía generada no debería ser nula");

		String parteLimpia = melodia.substring(0, melodia.indexOf("||")).trim();
		long conteoBarras = parteLimpia.chars().filter(ch -> ch == '|').count();

		assertEquals(cantidadCompases - 1, conteoBarras);
	}

	@Test
	void testGenerateMelody_CualquierCantidadCompasesValida_DevuelveMelodiaTerminadaEnDobleBarra() {
		int cantidadCompases = 3;

		String melodia = generator.generateMelody(cantidadCompases);

		assertTrue(melodia.endsWith("||"));
	}

	@Test
	void testGenerateMelody_CantidadCompasesValida_DevuelveNumeroTotalDeNotasEsperado() {

		int cantidadCompases = 3;
		int notasPorCompas = 4;
		int totalNotasEsperadas = cantidadCompases * notasPorCompas;

		String melodia = generator.generateMelody(cantidadCompases);

		String melodiaLimpia = melodia.replace("||", "").replace("|", "").trim();
		String[] notas = melodiaLimpia.split("\\s+");

		assertEquals(totalNotasEsperadas, notas.length);
	}

	@Test
	void testGenerateMelody_CantidadCompasesValida_DevuelvePrimeraYUltimaNotaIdenticas() {

		int cantidadCompases = 2;

		String melodia = generator.generateMelody(cantidadCompases);
		String melodiaLimpia = melodia.replace("||", "").replace("|", "").trim();
		String[] notas = melodiaLimpia.split("\\s+");

		String primeraNota = notas[0];
		String ultimaNota = notas[notas.length - 1];

		assertEquals(primeraNota, ultimaNota);
	}

	@Test
	void testGenerateMelody_CantidadCompasesCero_LanzaIllegalArgumentExceptionConMensajeCorrecto() {

		IllegalArgumentException excepcion = assertThrows(IllegalArgumentException.class, () -> {
			generator.generateMelody(0);
		}, "Debería lanzar IllegalArgumentException si el número de compases es menor que 1");

		String mensajeEsperado = "measuresCount must be between 1 and 7";
		assertEquals(mensajeEsperado, excepcion.getMessage());
	}

	@Test
	void testGenerateMelody_CantidadCompasesMayorAlMaximo_LanzaIllegalArgumentExceptionConMensajeCorrecto() {

		IllegalArgumentException excepcion = assertThrows(IllegalArgumentException.class, () -> {
			generator.generateMelody(8);
		}, "Debería lanzar IllegalArgumentException si el número de compases es mayor que 7");

		String mensajeEsperado = "measuresCount must be between 1 and 7";
		assertEquals(mensajeEsperado, excepcion.getMessage());
	}

	@Test
	void testGenerateMelody_CantidadCompasesNegativa_LanzaIllegalArgumentExceptionConMensajeCorrecto() {

		IllegalArgumentException excepcion = assertThrows(IllegalArgumentException.class, () -> {
			generator.generateMelody(-5);
		}, "Debería lanzar IllegalArgumentException si el número de compases es negativo");

		String mensajeEsperado = "measuresCount must be between 1 and 7";
		assertEquals(mensajeEsperado, excepcion.getMessage());
	}
}