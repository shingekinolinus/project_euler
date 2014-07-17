package problems;

/**
 * Created by Legend on 6/07/2014.
 * <p>
 * URL: https://projecteuler.net/problem=14
 * LATEST RESULT: SUCCESS
 */
public class problem_014 {

    public static void main(String[] args) {
        // note longs are used everywhere
        // because large numbers are detected
        long longest_chain = 0;
        long corresponding_number = -1;
        for (long i = 1; i < 1_000_000; i++) {
            long iterations = 1;
            long number = i;
            while (number != 1) {
                if (number % 2 == 0) {
                    // number is even
                    number /= 2;
                } else {
                    // number is odd
                    number = 3 * number + 1;
                }
                iterations++;
            }
            if (iterations > longest_chain) {
                longest_chain = iterations;
                corresponding_number = i;
            }
        }
        System.out.println("answer: " + corresponding_number);
    }

}
