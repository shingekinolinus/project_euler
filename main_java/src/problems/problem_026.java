package problems;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas on 7/07/2014.
 * <p>
 * URL: https://projecteuler.net/problem=26
 * LATEST RESULT: SUCCESS
 * RATING: NORMAL
 */
public class problem_026 {

    public static void main(String[] args) {
        int maxRecursionLength = 0;
        int correspondingDivisor = -1;
        for (int d = 1; d < 1000; d++) {
            int recursionLength = findRecursionLength(1, d);
            if (recursionLength > maxRecursionLength) {
                correspondingDivisor = d;
                maxRecursionLength = recursionLength;
            }
        }
        System.out.println("answer: " + correspondingDivisor);
    }

    /**
     * this algorithm is not fully understood
     * but it works well so don't f*ck with it
     * @param n number to be divided
     * @param d divisor (integer)
     * @return recursion length, e.g. 1 / 983 has recursion length 982
     */
    private static int findRecursionLength(int n, int d) {
        if (n > d) {
            n = n % d; // only decimal area matters
        }
        List<Integer> decimals = new ArrayList<>();
        List<Integer> remainders = new ArrayList<>();
        while (true) {
            n *= 10;
            int result = Math.floorDiv(n, d);
            decimals.add(Math.floorDiv(n, d));
            n %= d;
            if (remainders.contains(n)) {
                return remainders.size() - remainders.indexOf(n); // same remainders "divided"
                // by same divisor yields same results
            } else {
                remainders.add(n);
            }
            if (n == 0) {
                return 0; // no remainder - number can be fully divided
            }
        }
    }

}
