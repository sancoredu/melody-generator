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
    void generateMelody_SiCompasesVale4_Devuelve4Compas(){
        int numeroCompases = 4;
        MelodyGenerator melodyGenerator = new MelodyGenerator(new Random());
        String melody = melodyGenerator.generateMelody(numeroCompases);

        String[] notasMelodia = melody.split(" ");

        int expected = (numeroCompases * 4) + 1 + (numeroCompases - 1);
        int cantidadNotasYSeparadores = notasMelodia.length;

        assertEquals(expected, cantidadNotasYSeparadores);
    }


}