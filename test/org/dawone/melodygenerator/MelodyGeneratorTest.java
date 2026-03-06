package org.dawone.melodygenerator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MelodyGeneratorTest {
    private MelodyGenerator melodyGenerator;
    private Random random;

    @BeforeEach
    void setUp() {
        random = mock(Random.class);
        melodyGenerator = new MelodyGenerator(random);
    }

    @Test
    void generateMelody_Generates2Measures_Return2Groups() {
        int measuresCount = 2;
        String expectedMelody = "do re mi fa | sol la si do ||";
        when(random.nextInt(7))
            .thenReturn(0) // "do"
            .thenReturn(1) // "re"
            .thenReturn(2) // "mi"
            .thenReturn(3) // "fa"

            .thenReturn(4) // "sol"
            .thenReturn(5) // "la"
            .thenReturn(6);// "si"

        String actualMelody = melodyGenerator.generateMelody(measuresCount);

        assertEquals(expectedMelody, actualMelody);
    }
}