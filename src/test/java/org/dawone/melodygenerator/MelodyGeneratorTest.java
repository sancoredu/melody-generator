package org.dawone.melodygenerator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;


class MelodyGeneratorTest {
    MelodyGenerator melodyGenerator;



    @Test
    void testGenerateMelody_goodNumbers_doesnThrowException() {
        int variable = 3;
        for (int i = 3; i < 8; i++) {
            melodyGenerator.generateMelody(variable);
            variable++;
        }

    }
    @Test
    void testGenerateMelody_wrongMeasures_throwException() {
        int variableDescendente = 0;
        int variableAscendente = 8;
        for (int i = 0; i > -3; i--) {
            assertThrows(IllegalArgumentException.class, () -> melodyGenerator.generateMelody(variableDescendente));
        }
        for (int i = 8; i <12; i++) {
            assertThrows(IllegalArgumentException.class, () -> melodyGenerator.generateMelody(variableAscendente));
        }

    }

    @Test
    void testGenerateMelody_checkMeasures_correct() {
        String resultado = melodyGenerator.generateMelody(4);
        System.out.printf("resultado: %s\n", resultado);
        int resultado2 = resultado.split("\\|").length;
        assertEquals(4,resultado2);
    }
    @Test
    void testGenerateMelody_checkFinal_correct() {
        String resultado = melodyGenerator.generateMelody(4);
        String resultado2 = resultado.substring(resultado.length()-2, resultado.length());
        System.out.printf("resultado: %s\n", resultado2);
        assertEquals("||",resultado2);
    }
    @Test
    void testGenerateMelody_4Measures_correct() {
        String resultado = melodyGenerator.generateMelody(4);

        String[] measures = Arrays.stream(resultado.split("[|]"))
                .map(String::trim)
                .filter(word -> !word.isEmpty())
                .toArray(String[]::new);

        assertEquals(4,measures.length);

    }
    @Test
    void testGenerateMelody_28Notes_correct() {
        String resultado = melodyGenerator.generateMelody(7);
        String[] measuresWithOutBar= resultado.split("\\|");
        String measuresResultado = new String();
        for (int i = 0; i < measuresWithOutBar.length; i++) {
            measuresResultado += measuresWithOutBar[i];
        }

        String[] measures = Arrays.stream(measuresResultado.split(" "))
                .map(String::trim)
                .filter(word -> !word.isEmpty())
                .toArray(String[]::new);
        for(String measure : measures) {
            System.out.printf("measure: %s", measure+ " ");
        }
        assertEquals(28,measures.length);
    }
    @Test
    void testGenerateMelody_4Notes_corredt(){
        String resultado = melodyGenerator.generateMelody(1);
        String[] measuresWithOutBar= resultado.split("\\|");
        String measuresResultado = new String();
        for (int i = 0; i < measuresWithOutBar.length; i++) {
            measuresResultado += measuresWithOutBar[i];
        }

        String[] measures = Arrays.stream(measuresResultado.split(" "))
                .map(String::trim)
                .filter(word -> !word.isEmpty())
                .toArray(String[]::new);
        for(String measure : measures) {
            System.out.printf("measure: %s", measure+ " ");
        }
        assertEquals(4,measures.length);
    }

    @Test
    void testGenerateMelody_startAndEnd_Correct(){
        String resultado = melodyGenerator.generateMelody(4);
        resultado = resultado.substring(0,resultado.length()-2);
        resultado = resultado.trim();
        assertEquals(resultado.substring(0,2),resultado.substring(resultado.length()-2,resultado.length()));
    }

    @BeforeEach
    void setUp() {
     melodyGenerator = new MelodyGenerator(new Random());
    }


}