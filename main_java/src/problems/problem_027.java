package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas on 8/07/2014.
 * <p>
 * URL: https://projecteuler.net/problem=27
 * LATEST RESULT: FAIL
 * RATING: CHALLENGING
 */
public class problem_027 {

    public static void main(String[] args) {
        // b is prime
        // a + b + 1 is prime
        // b > 0
        // when n = |a| + 1, p(n) = 1681
        List<Integer> primes = new ArrayList<>();
        for (int i = 1; i < 2000; i++) {
            if (problem_007.is_prime(i)) {
                primes.add(i);
            }
        }
        System.out.println(primes);

        List<int[]> listABs = new ArrayList<>();
        for (int prime : primes) {
            int b = prime;
            double a = Math.sqrt(4 * prime - 163);
            if (Math.round(a) == a) {
                listABs.add(new int[] {
                        (int) Math.round(a), b
                });
            }
        }

        System.out.println(listABs);

        int maxSuccesses = 0; // maximum successful primes in a row starting from 0
        for (int[] abPair : listABs) {
            int successes = 0;
            for (int n = 0; n < 1000; n++) {
                int result = n * n + abPair[0] * n + abPair[1];
                if (!problem_007.is_prime(result)) {
                    break;
                } else {
                    successes ++;
                }
            }
            if (successes > maxSuccesses) {
                maxSuccesses = successes;
            }
        }

        System.out.println(maxSuccesses);
    }

}
