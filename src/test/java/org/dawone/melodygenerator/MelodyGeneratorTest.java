package org.dawone.melodygenerator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MelodyGeneratorTest {

    @Test
    void generateMelody_measure_throws_exception() {
        MelodyGenerator generadorMelodia = new MelodyGenerator(new Random());
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            generadorMelodia.generateMelody(0);
        });
        int numeroCompases=0;
        String expectedMesaage="measuresCount must be between 1 and 7";
        String actualMessage= exception.getMessage();



        assertThrows(IllegalArgumentException.class, ()-> generadorMelodia.generateMelody(numeroCompases));
        assertEquals(expectedMesaage,actualMessage);
    }
    @Test
    void generateMelody_returns_melodiaConDosBarrasFinales() {
        MelodyGenerator generadorMelodia = new MelodyGenerator(new Random());
        //El generador de melodía genera una melodia
        String melodia1= generadorMelodia.generateMelody(3);
        assertTrue(melodia1.endsWith("||"));
    }

    @Test
    void  generateMelody_returns_melodia_mismaNotaInicialFinal(){
        MelodyGenerator generadorMelodia = new MelodyGenerator(new Random());
        String melodia1=generadorMelodia.generateMelody(1);
        String notaInicial= melodia1.substring(1,3);
        assertTrue(melodia1.endsWith(notaInicial+"||"));
    }

    @Test
    void generateMelody_returns_melodiaSeparadaPorBarra(){
        MelodyGenerator generadorMelodia = new MelodyGenerator(new Random());
        String melodia1=generadorMelodia.generateMelody(1);
        String melodia2= melodia1.trim();
        String primeraSeparacion= melodia2.substring(1,13);
        assertTrue(primeraSeparacion.contains("|"));
    }


}