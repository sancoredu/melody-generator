package org.dawone.melodygenerator;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MelodyGeneratorTest {

    @Test
    void generateMelody_SiCompasesVale0_DevuelveException() {
        int numeroCompases = 0;
        MelodyGenerator melodyGenerator = new MelodyGenerator(new Random());
        assertThrows(IllegalArgumentException.class, () ->   melodyGenerator.generateMelody(numeroCompases));
    }

    @Test
    void generateMelody_SiCompasesVale8_DevuelveException(){
        int numeroCompases = 8;
        MelodyGenerator melodyGenerator = new MelodyGenerator(new Random());
        assertThrows(IllegalArgumentException.class, () ->   melodyGenerator.generateMelody(numeroCompases));
    }

    @Test
    void generateMelody_SiCompasesVale1_DevuelveCompas(){
        int numeroCompases = 1;
        MelodyGenerator melodyGenerator = new MelodyGenerator(new Random());
        String melody = melodyGenerator.generateMelody(numeroCompases);

        String[] notasMelodia = melody.split(" ");

        int expected = (numeroCompases * 4) + 1 + (numeroCompases - 1);
        int cantidadNotasYSeparadores = notasMelodia.length;

        assertEquals(expected, cantidadNotasYSeparadores);
    }

    @Test
    void generateMelody_SiCompasesVale7_Devuelve7Compas(){
        int numeroCompases = 7;
        MelodyGenerator melodyGenerator = new MelodyGenerator(new Random());
        String melody = melodyGenerator.generateMelody(numeroCompases);

        String[] notasMelodia = melody.split(" ");

        int expected = (numeroCompases * 4) + 1 + (numeroCompases - 1);
        int cantidadNotasYSeparadores = notasMelodia.length;

        assertEquals(expected, cantidadNotasYSeparadores);
    }

    @Test
    void generateMelody_SiCompasesVale2_TerminaDobleBarra(){
        int numeroCompases = 2;
        MelodyGenerator melodyGenerator = new MelodyGenerator(new Random());
        String melody = melodyGenerator.generateMelody(numeroCompases);
        String[] notasMelodia = melody.split(" ");

        String expected = "||";

        assertEquals(expected,notasMelodia[notasMelodia.length-1]);
    }

    @Test
    void generateMelody_SiCompasesVale2_TerminaEmpiezaIgual(){
        int numeroCompases = 2;
        MelodyGenerator melodyGenerator = new MelodyGenerator(new Random());
        String melody = melodyGenerator.generateMelody(numeroCompases);
        String[] notasMelodia = melody.split(" ");
        String primeraNota = notasMelodia[0];
        String ultimaNota = notasMelodia[notasMelodia.length-2];
        boolean expected = true;
        boolean actual = false;

        if(primeraNota.equals(ultimaNota)){
            actual = true;
        }

        assertEquals(expected,actual);
    }

    @Test
    void generateMelody_SiCompasesVale2_SeparadosPorBarra(){
        int numeroCompases = 6;
        MelodyGenerator melodyGenerator = new MelodyGenerator(new Random());
        String melody = melodyGenerator.generateMelody(numeroCompases);

        String[] compases = melody.split("\\|");

        int expected = numeroCompases;
        int cantidadCompases = compases.length;

        assertEquals(expected, cantidadCompases);
    }

}