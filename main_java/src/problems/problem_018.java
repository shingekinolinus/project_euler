package problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas on 7/07/2014.
 * <p>
 * URL: https://projecteuler.net/problem=18
 * LATEST RESULT: SUCCESS
 */
public class problem_018 {

    public static void main(final String[] args) throws Throwable {
        final BufferedReader reader = new BufferedReader(new FileReader("problem_018_input.txt"));
        String line;
        final List<int[]> dataList = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            final String[] sections = line.split(" ");
            final int[] numberArray = new int[sections.length];
            for (int i = 0; i < sections.length; i++) {
                String section = sections[i];
                numberArray[i] = Integer.parseInt(section);
            }
            dataList.add(numberArray);
        }

        // data list is ready up to this point
        for (int i = dataList.size() - 1; i > 0; i--) {
            // iterate from last to SECOND element
            int[] numberArray = dataList.get(i);
            int[] prevNumberArray = dataList.get(i - 1);
            for (int j = 0; j < prevNumberArray.length; j++) {
                int numberA = numberArray[j];
                int numberB = numberArray[j + 1];
                prevNumberArray[j] += Math.max(numberA, numberB);
            }
        }

        System.out.println("answer: " + dataList.get(0)[0]);
    }

}
