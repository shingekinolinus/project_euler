package problems;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Thomas on 7/07/2014.
 * <p>
 * URL: https://projecteuler.net/problem=21
 * LATEST RESULT: SUCCESS
 * RATING: EASY
 */
public class problem_021 {

    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>();
        int sum = 0;
        for (int a = 1; a < 10000; a++) {
            int b = d(a);
            if (d(b) == a && a != b) {
                numbers.add(a);
                if (b < 10000)
                    numbers.add(b);
            }
        }
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("answer: " + sum);
    }

    private static int d(int number) {
        // adds up all the factors of a set
        int total = 0;
        Collection<Integer> factors = getProperDivisors(number);
        for (int factor : factors) {
            total += factor;
        }
        return total;
    }

    static Collection<Integer> getProperDivisors(int number) {
        HashSet factors = new HashSet();
        int rootOfNumber = (int) Math.sqrt(number);
        for (int i = 1; i <= rootOfNumber; i++) {
            if (number % i == 0) {
                factors.add(i);
                factors.add(number / i);
            }
        }
        factors.remove(number); // remove the original
        return factors; // there will be no duplicates
    }

}
