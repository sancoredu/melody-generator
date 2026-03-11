package org.dawone.melodygenerator;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MelodyGeneratorTest {

    @Test
    void generateMelody_SiCompasesVale0_DevuelveException() {
        MelodyGenerator melodyGenerator = new MelodyGenerator(new Random());
        assertThrows(IllegalArgumentException.class, () ->   melodyGenerator.generateMelody(0));
    }

    @Test
    void generateMelody_SiCompasesVale8_DevuelveException(){
        MelodyGenerator melodyGenerator = new MelodyGenerator(new Random());
        assertThrows(IllegalArgumentException.class, () ->   melodyGenerator.generateMelody(8));
    }

    @Test
    void generateMelody_SiCompasesVale1_DevuelveCompas(){
        int numeroCompases = 1;
        MelodyGenerator melodyGenerator = new MelodyGenerator(new Random());
        String melody = melodyGenerator.generateMelody(numeroCompases);

        String[] notasMelodia = melody.split(" ");

        int expected = 5;
        int cantidadNotas = notasMelodia.length;

        assertEquals(expected, cantidadNotas);
    }

    @Test
    void generateMelody_SiCompasesVale2_DevuelveCompas(){
        int numeroCompases = 2;
        MelodyGenerator melodyGenerator = new MelodyGenerator(new Random());
        String melody = melodyGenerator.generateMelody(numeroCompases);

        String[] notasMelodia = melody.split(" ");

        int expected = 10;
        int cantidadNotas = notasMelodia.length;

        assertEquals(expected, cantidadNotas);
    }


}