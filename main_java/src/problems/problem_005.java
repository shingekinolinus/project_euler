package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Legend on 5/07/2014.
 * <p>
 * finds the smallest number divisible by numbers 1 to 20
 * <p>
 * URL: http://projecteuler.net/problem=5
 * LATEST RESULT: SUCCESS
 */
public class problem_005 {

    public static void main(String[] args) {
        ArrayList<Long> required_primes = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            List<Long> new_primes = problem_003.find_prime_factors(i);
            for (long existing_prime : required_primes) {
                new_primes.remove(existing_prime);
            }
            required_primes.addAll(new_primes);
        }
        System.out.println(required_primes);
        long smallest_common_divisor = 1;
        for (long required_prime : required_primes) {
            smallest_common_divisor *= required_prime;
        }
        System.out.println(smallest_common_divisor);
    }

}
