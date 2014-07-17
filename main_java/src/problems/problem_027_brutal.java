package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas on 8/07/2014.
 *
 * i was too soft on the question
 * <p>
 * URL: https://projecteuler.net/problem=27
 * LATEST RESULT: SUCCESS
 * RATING: EASY
 * GITHUB: ALGORITHM MIRROR.
 */
public class problem_027_brutal {

    public static void main(String[] args) {
        int maxSuccesses = 0;
        int correspondingA = 0;
        int correspondingB = 0;
        for (int a = -999; a <= 999; a++) {
            // a from range -999 to 999
            for (int b = -999; b <= 999; b++) {
                // b from range -999 to 999
                int successes = 0;
                for (int n = 0; true; n++) {
                    // n from 0 to infinity
                    int result = n * n + a * n + b;
                    if (problem_007.is_prime(result))
                        successes++;
                    else {
                        if (successes > maxSuccesses) {
                            maxSuccesses = successes;
                            correspondingA = a;
                            correspondingB = b;
                        }
                        break;
                    }
                    
                }
            }
        }
//        System.out.println(maxSuccesses);
        System.out.printf("when a = %d, b = %d the equation gives %d consecutive primes\n", correspondingA, correspondingB, maxSuccesses);
        System.out.println("answer: " + correspondingA * correspondingB);
    }

}
