package problems;

import java.util.*;

/**
 * Created by Thomas on 7/07/2014.
 * <p>
 * URL: https://projecteuler.net/problem=23
 * LATEST RESULT: SUCCESS
 * RATING: NORMAL
 */
public class problem_023 {

    public static void main(String[] args) {
        // NEVER retrieve using an index
        List<Integer> abundantNumbers = new LinkedList<>();
        for (int i = 1; i < 28123; i++) {
            Collection<Integer> divisors = problem_021.getProperDivisors(i);
            int divisorTotal = 0;
            for (int divisor : divisors) {
                divisorTotal += divisor;
            }
            if (divisorTotal > i) {
                // i is abundant
                abundantNumbers.add(i);
            }
        }

        boolean[] isReachable = new boolean[28123];
        for (int abundantNumberA : abundantNumbers) {
            innerLoop:
            for (int abundantNumberB : abundantNumbers) {
                int total = abundantNumberA + abundantNumberB;
                if (total > 28123) {
                    break;
                } else {
                    isReachable[total - 1] = true;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < isReachable.length; i++) {
            boolean b = isReachable[i];
            if (!b) {
                // i + 1 is not reachable
                sum += i + 1;
            }
        }
        System.out.println("answer: " + sum);
    }

}
