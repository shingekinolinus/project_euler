package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Legend on 5/07/2014.
 * <p>
 * URL: http://projecteuler.net/problem=3
 * LATEST RESULT: SUCCESS
 */
public class problem_003 {

    public static void main(String[] args) {
        long number = 600_851_475_143L; // this number is big
        System.out.println(number);
        System.out.println(find_prime_factors(number));
    }

    static List<Long> find_prime_factors(long number) {
        List<Long> prime_factors = new ArrayList<>();
//        int max_search = (int) Math.sqrt(number); // max number to search for factors
        // the smallest factor is always a prime factor!
        // note searching starts from 2, so if the number is 1, the loop will be skipped
        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                // a prime factor is found
                prime_factors.add((long) i);
                prime_factors.addAll(find_prime_factors(number / i));
                break;
            }
        }
        return prime_factors;
    }

}
