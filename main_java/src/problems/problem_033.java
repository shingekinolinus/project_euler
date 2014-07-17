package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas on 8/07/2014.
 * <p>
 * URL: https://projecteuler.net/problem=33
 * LATEST RESULT: SUCCESS
 * RATING: HARDER
 * GITHUB: SIMPLIFIED
 */
public class problem_033 {

    public static void main(String[] args) {
        int answer = 0;
        int bigA = 1;
        int bigB = 1;
        // note the search zone is smaller
        for (int a = 10; a < 50; a++) {
            for (int b = 50; b < 100; b++) {
                if (a == b)
                    continue;
                // shorten your code: define multiple variables in the same line
                // you don't have to use str to remove last / first digit
                final List<Byte> commons = new ArrayList<>();
                final String aStr = String.valueOf(a);
                final String bStr = String.valueOf(b);
                for (int i = 0; i < aStr.length(); i++) {
                    if (aStr.charAt(i) != '0' && bStr.contains(String.valueOf(aStr.charAt(i))))
                        commons.add(Byte.valueOf(String.valueOf(aStr.charAt(i)))); // add the character as a byte
                }
                for (int n = 0; n < commons.size(); n++) {
                    byte common = commons.get(n);
                    int newA = Integer.valueOf(aStr.replaceFirst(String.valueOf(common), ""));
                    int newB = Integer.valueOf(bStr.replaceFirst(String.valueOf(common), ""));
                    if ((double) a / b == (double) newA / newB) {
                        System.out.println(a + " " + b);
                        bigA *= a < b ? a : b;
                        bigB *= a < b ? b : a;
                    }
                }
            }
        }
        // i refuse to encapsulate this
        List<Long> primeFactorsA = problem_003.find_prime_factors(bigA);
        List<Long> primeFactorsB = problem_003.find_prime_factors(bigB);
        for (long primeFactor : primeFactorsA) {
            if (primeFactorsB.contains(primeFactor)) {
                bigA /= primeFactor;
                bigB /= primeFactor;
            }
        }
        answer = bigB;
        System.out.println("answer: " + answer);
    }

}
