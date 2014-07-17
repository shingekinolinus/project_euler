package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Legend on 5/07/2014.
 * <p>
 * "I'm sorry, i've been too soft on Gasai-san lately" - Akise Aru
 * time to use violent methods to solve the puzzle
 * <p>
 * URL: http://projecteuler.net/problem=7
 * LATEST RESULT: SUCCESS
 */
public class problem_007 {

    public static void main(String[] args) {
        List<Integer> primes = new ArrayList<>();
        int i = 2;
        while (primes.size() < 10_001) {
            if (is_prime(i))
                primes.add(i);
            i++;
        }
        System.out.println(primes.get(10_000));
    }

    static boolean is_prime(int number) {
        if (number <= 0)
            return false;
//            throw new RuntimeException("number must be positive");
        if (number == 1)
            return false; // 1 is NOT a prime number
        // ALWAYS use less OR equals here
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

}
