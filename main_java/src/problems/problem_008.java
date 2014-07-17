package problems;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Legend on 5/07/2014.
 * <p>
 * URL: http://projecteuler.net/problem=8
 * LATEST RESULT: SUCCESS
 */
public class problem_008 {

    public static void main(String[] args) throws Throwable {
        final BufferedReader reader =
                new BufferedReader(new FileReader("problem_008_input.txt"));
        final StringBuilder builder = new StringBuilder();
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            builder.append(line);
        }
        final String input_data = builder.toString();
        final char[] input_chars = input_data.toCharArray();
        long current_max = 0;
        long corresponding_index = -1;
        for (int i = 0; i < input_chars.length - 13; i++) {
            long temp_max = 1;
            for (int j = i; j < i + 13; j++) {
                temp_max *= Integer.valueOf(String.valueOf(input_chars[j])); // multiply
            }
            if (temp_max > current_max) {
                current_max = temp_max;
                corresponding_index = i;
            }
        }
        System.out.println(current_max);
//        System.out.println(input_data.substring((int) corresponding_index, (int) corresponding_index + 13));
        reader.close();
    }

}
