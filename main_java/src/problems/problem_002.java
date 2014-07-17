package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Legend on 5/07/2014.
 * <p>
 * URL: http://projecteuler.net/problem=2
 * LATEST RESULT: SUCCESS
 */
public class problem_002 {

    public static void main(String[] args) {
        List<Integer> sequence = new ArrayList<>();
        sequence.add(1);
        sequence.add(2);
        for (int i = 0; true; i++) {
            int new_number = sequence.get(i) + sequence.get(i + 1);
            if (new_number > 4_000_000) {
                break;
            } else {
                // number could be exactly four million
                sequence.add(new_number);
            }
        }

        int total = 0;
        // the sequence is ready up to now
        for (int number : sequence) {
            if (number % 2 == 0) {
                total += number;
            }
        }

        System.out.println(total);

    }

}
