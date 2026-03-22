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

    @BeforeEach
    void setUp() {
        fixedRandom = new Random(42);
        generator = new MelodyGenerator(fixedRandom);
    }

    @Test
    void testGenerateMelodyValidRange() {
        String melody = generator.generateMelody(3);
        assertNotNull(melody);
        assertTrue(melody.endsWith("||"));
        assertEquals(3, melody.split("\\|").length);
    }

    @Test
    void testFirstAndLastNoteAreSame() {
        String melody = generator.generateMelody(2);
        String[] parts = melody.replace(" ||", "").split(" \\| ");
        String[] firstMeasure = parts[0].split(" ");
        String[] lastMeasure = parts[1].split(" ");

        assertEquals(firstMeasure[0], lastMeasure[3]);
    }

    @Test
    void testInvalidMeasuresCountThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> generator.generateMelody(0));
        assertThrows(IllegalArgumentException.class, () -> generator.generateMelody(8));
    }
}