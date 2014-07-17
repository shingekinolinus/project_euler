package problems;

import java.math.BigInteger;

/**
 * Created by Legend on 6/07/2014.
 * <p>
 * URL: https://projecteuler.net/problem=15
 * LATEST RESULT: SUCCESS
 */
public class problem_015 {

    public static void main(String[] args) {
        // think of the grid as commands
        // there MUST be 20 LFT commands and 20 DWN commands
        // and there are 137846528820 ways to place them
        System.out.println("answer: " + (factorial(40).divide(factorial(20)).divide(factorial(20))));
    }

    private static BigInteger factorial(int number) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= number; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

}
