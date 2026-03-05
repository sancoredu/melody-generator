package org.dawone.melodygenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MelodyGenerator {
    private static final String[] NOTES = {"do", "re", "mi", "fa", "sol", "la", "si"};
    private static final int MIN_MEASURES = 1;
    private static final int MAX_MEASURES = 7;
    private static final int NOTES_PER_MEASURE = 4;
    private final Random random;

    public MelodyGenerator(Random random) {
        this.random = random;
    }

    public String generateMelody(int measuresCount) {
        List<String> measures = new ArrayList<>();
        boolean isFirstMeasure = true;
        boolean isLastMeasure = false;
        String firstNote = generateRandomNote();

        if (measuresCount < MIN_MEASURES || measuresCount > MAX_MEASURES) {
            throw new IllegalArgumentException("measuresCount must be between " + MIN_MEASURES + " and " + MAX_MEASURES);
        }

        for (int measureIndex = 0; measureIndex < measuresCount; measureIndex++) {
            isLastMeasure = (measureIndex == measuresCount - 1);
            List<String> measure = generateMeasure(isFirstMeasure, isLastMeasure, firstNote);
            measures.add(formatMeasure(measure));
            isFirstMeasure = false;
        }

        return formatMelody(measures);
    }

    private String generateRandomNote() {
        return NOTES[random.nextInt(NOTES.length)];
    }

    private List<String> generateMeasure(boolean isFirstMeasure, boolean isLastMeasure, String firstNote) {
        List<String> measure = new ArrayList<>();

        for (int i = 0; i < NOTES_PER_MEASURE; i++) {
            if (isFirstMeasure && i == 0) {
                measure.add(firstNote);
            } else if (isLastMeasure && i == NOTES_PER_MEASURE - 1) {
                measure.add(firstNote);
            } else {
                measure.add(generateRandomNote());
            }
        }

        return measure;
    }

    private String formatMeasure(List<String> measure) {
        return String.join(" ", measure);
    }

    private String formatMelody(List<String> measures) {
        return String.join(" | ", measures) + " ||";
    }

    public static void main(String[] args) {
        MelodyGenerator generator = new MelodyGenerator(new Random());
        System.out.println(generator.generateMelody(3));
    }
}