package org.dawone.melodygenerator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MelodyGeneratorTest {

    @Test
    void generateMelody() {
    }

    private MelodyGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new MelodyGenerator(new Random());
    }

    @Test
    void generateMelody_CompasMenorAlMinimo_LanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            generator.generateMelody(0);
        });
    }

    @Test
    void generateMelody_CompasMayorAlMaximo_LanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            generator.generateMelody(8);
        });
    }

    @Test
    void generateMelody_CuatroCompases_DevuelveCuatroCompases() {
        int cantidadEsperada = 4;
        String melodia = generator.generateMelody(cantidadEsperada);

        // Separamos por la barra simple de compás
        // El replace es para no contar la doble barra final como un separador extra
        String[] compases = melodia.replace(" ||", "").split(" \\| ");

        assertEquals(cantidadEsperada, compases.length, "La melodía debe tener exactamente 4 compases.");
    }

    @Test
    void generateMelody_CualquierEntradaValida_PrimeraNotaIgualALaUltima() {
        String melodia = generator.generateMelody(3);

        // Limpiamos la cadena para obtener solo las notas separadas por espacios
        String notasLimpias = melodia.replace(" ||", "").replace(" |", "");
        String[] notas = notasLimpias.split(" ");

        String primeraNota = notas[0];
        String ultimaNota = notas[notas.length - 1];

        assertEquals(primeraNota, ultimaNota, "La primera nota de la melodía debe ser idéntica a la última.");
    }

    @Test
    void generateMelody_CualquierEntradaValida_FinalizaConDobleBarra() {
        String melodia = generator.generateMelody(2);

        assertTrue(melodia.endsWith(" ||"), "La melodía debe terminar siempre con el formato ' ||'.");
    }

    @Test
    void generateMelody_CadaCompas_ContieneCuatroNotas() {
        String melodia = generator.generateMelody(3);
        String[] compases = melodia.replace(" ||", "").split(" \\| ");

        for (String compas : compases) {
            String[] notas = compas.trim().split(" ");
            assertEquals(4, notas.length, "Cada compás individual debe tener 4 notas.");
        }
    }
}