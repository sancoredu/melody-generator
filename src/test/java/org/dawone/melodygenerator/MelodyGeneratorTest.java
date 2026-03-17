package org.dawone.melodygenerator;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MelodyGeneratorTest {

    @Test
    void generateMelody_ifMeasureis0_ThrowException() {
        MelodyGenerator melodyGenerator=new MelodyGenerator(new Random());
        int measures=0;

        assertThrows(IllegalArgumentException.class,()->melodyGenerator.generateMelody(measures));
    }
    @Test
    void generateMelody_ifMeasureis1_Return1Notes() {
        MelodyGenerator melodyGenerator=new MelodyGenerator(new Random());
        int measures=1;
        int expected=(4*measures) + measures;

        String actual=melodyGenerator.generateMelody(measures);
        String[] notasSeparadas=actual.split(" ");
        int cantidadNotas=notasSeparadas.length;

        assertEquals(expected,cantidadNotas);

    }

    @Test

    void generateMelody_ifMeasureis7_Return7Notes() {
        MelodyGenerator melodyGenerator=new MelodyGenerator(new Random());
        int measures=7;
        int expected=(4*measures) + measures;

        String actual=melodyGenerator.generateMelody(measures);
        String[] notasSeparadas=actual.split(" ");
        int cantidadNotas=notasSeparadas.length;

        assertEquals(expected,cantidadNotas);
    }

    @Test
    void generateMelody_ifMeasureis8_ThrowException() {
        MelodyGenerator melodyGenerator=new MelodyGenerator(new Random());
        int measures=8;

        assertThrows(IllegalArgumentException.class,()->melodyGenerator.generateMelody(measures));
    }
    @Test
    void generateMelody_ifMeasureis2_Return2Measures(){
        MelodyGenerator melodyGenerator=new MelodyGenerator(new Random());
        int measures=2;
        int expected=measures;

        String actual=melodyGenerator.generateMelody(measures);
        String[] compasesSeparados=actual.split("\\|");
        int cantidadCompases=compasesSeparados.length;

        assertEquals(expected,cantidadCompases);
    }

    @Test
    void generateMelody_ifMeasureis1_FirstAndLastNotesEquals(){
        MelodyGenerator melodyGenerator=new MelodyGenerator(new Random());
        int measures=1;

        String actual=melodyGenerator.generateMelody(measures);
        String[] compasesSeparados=actual.split(" ");
        String firstNote=compasesSeparados[0];
        String lastNote=compasesSeparados[compasesSeparados.length-2];
        assertEquals(firstNote,lastNote);
    }

    @Test
    void generateMelody_ifMeasureis3_FinishWithDoublePipe(){
        MelodyGenerator melodyGenerator=new MelodyGenerator(new Random());
        String expectedFinal="||";
        int measures=3;
        String actual=melodyGenerator.generateMelody(measures);
        String[] compasesSeparados=actual.split(" ");
        String lastArrayPart=compasesSeparados[compasesSeparados.length-1];
        assertEquals(expectedFinal,lastArrayPart);
    }
}