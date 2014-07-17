package problems;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Legend on 6/07/2014.
 * <p>
 * URL: http://projecteuler.net/problem=11
 * LATEST RESULT: SUCCESS
 */
public class problem_011 {

    private static int DATA_WIDTH = 20;
    private static int DATA_HEIGHT = 20;
    private static int SEQUENCE_LENGTH = 4; // sequences of 4 numbers are to be considered

    public static void main(String[] args) throws Throwable {
        final BufferedReader reader =
                new BufferedReader(new FileReader("problem_011_input.txt"));
        // each number 0 <= x < 100
        final byte[][] data = new byte[20][20];
        for (int y = 0; y < DATA_HEIGHT; y++) {
            final String line = reader.readLine();
            final String[] segments = line.split(" ");
            for (int x = 0; x < segments.length; x++) {
                String segment = segments[x];
                data[y][x] = Byte.valueOf(segment); // insert the data into the 2D array
            }
        }

        int largest_total = 0;
        for (int y = 0; y < DATA_HEIGHT; y++) {
            for (int x = 0; x < DATA_WIDTH - SEQUENCE_LENGTH; x++) {
                // horizontal check
                int total = 1;
                for (int n = 0; n < SEQUENCE_LENGTH; n++) {
                    total *= data[y][x + n];
                }
                if (total > largest_total) {
                    largest_total = total;
                }
            }
        }

        for (int y = 0; y < DATA_HEIGHT - SEQUENCE_LENGTH; y++) {
            for (int x = 0; x < DATA_WIDTH; x++) {
                // vertical check
                int total = 1;
                for (int n = 0; n < SEQUENCE_LENGTH; n++) {
                    total *= data[y + n][x];
                }
                if (total > largest_total) {
                    largest_total = total;
                }
            }
        }

        for (int y = 0; y < DATA_HEIGHT - SEQUENCE_LENGTH; y++) {
            for (int x = 0; x < DATA_WIDTH - SEQUENCE_LENGTH; x++) {
                // vertical check A \
                int total = 1;
                for (int n = 0; n < SEQUENCE_LENGTH; n++) {
                    total *= data[y + n][x + n];
                }
                if (total > largest_total) {
                    largest_total = total;
                }
            }
        }

        for (int y = 0; y < DATA_HEIGHT - SEQUENCE_LENGTH; y++) {
            for (int x = 0; x < DATA_WIDTH - SEQUENCE_LENGTH; x++) {
                // vertical check B /
                int total = 1;
                for (int n = 0; n < SEQUENCE_LENGTH; n++) {
                    total *= data[y + n][x + 3 - n];
                }
                if (total > largest_total) {
                    largest_total = total;
                }
            }
        }

        System.out.println(largest_total);
        reader.close();

    }

}
