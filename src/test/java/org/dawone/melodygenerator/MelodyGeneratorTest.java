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
        String expected = "";
        MelodyGenerator melodyGenerator = new MelodyGenerator(new Random());
        assertEquals(expected, melodyGenerator.generateMelody(1));
    }


}