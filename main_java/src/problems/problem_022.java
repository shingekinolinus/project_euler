package problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Thomas on 7/07/2014.
 * <p>
 * URL: https://projecteuler.net/problem=22
 * LATEST RESULT: SUCCESS
 * RATING: EASY
 */
public class problem_022 {

    private static final List<Character> ALPHABET_CHARS;

    static {
        ALPHABET_CHARS = new ArrayList<>();
        final char[] ALPHABET_CHAR_ARRAY = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        for (char c : ALPHABET_CHAR_ARRAY) {
            ALPHABET_CHARS.add(c);
        }
    }

    public static void main(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader("problem_022_input.txt"));
        String originalString = reader.readLine().replace("\"", ""); // delete all dbl quotes
        originalString = originalString.toUpperCase(); // upper case required
        String[] segments = originalString.split(",");

        Arrays.parallelSort(segments);

        int totalScore = 0;
        for (int i = 0; i < segments.length; i++) {
            int index = i + 1; // also the "base value"
            int totalCharValue = 0;
            char[] chars = segments[i].toCharArray();
            for (char c : chars) {
                totalCharValue += ALPHABET_CHARS.indexOf(c) + 1;
            }
            totalScore += index * totalCharValue;
        }

        System.out.println("answer: " + totalScore);
    }

}
