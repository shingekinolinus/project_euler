package problems;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.BitSet;

/**
 * Created by Thomas on 9/07/2014.
 * <p>
 * encapsulating most demanded functionality
 */
public final class MathLib {

    /**
     * calculates the factorial of a number
     *
     * @param number positive integer or zero
     * @return accurate BigInteger representation of the result
     */
    public static BigInteger fc(int number) {
        if (number < 0)
            throw new IllegalArgumentException("number to calculate factorial must be positive or 0");
        BigInteger result = BigInteger.ONE;
        // NOTE: 0 fc is 1
        for (int i = 2; i <= number; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    /**
     * calculates the fc of a SMALL number
     *
     * @param number integer from 0 to 12 (inclusive)
     * @return accurate integer representation of the result
     */
    public static int fcs(int number) {
        if (number < 0 || number > 12)
            throw new IllegalArgumentException("number must be between 0 and 12 (inclusive)");
//        int result = 1;
//        // NOTE: 0 fc is 1
//        for (int i = 2; i <= number; i++) {
//            result = result * i;
//        }
        return FACTORIALS[number];
    }

    private static final int[] FACTORIALS = new int[]{
            1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600
    };

    /**
     * return the digits of a number
     *
     * @param n non negative integer to split into digits
     * @return array of bytes, each between 0 and 9 (inclusive)
     */
    public static byte[] digits(int n) {
        if (n < 1)
            throw new IllegalArgumentException("number must be positive or zero");
        byte[] digits = new byte[String.valueOf(n).length()];
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = (byte) (n % 10);
            n = Math.floorDiv(n, 10);
        }
        return digits;
    }

    /**
     * tests if the number is a prime
     *
     * @param number positive integer
     * @return whether the number is a prime number
     */
    public static boolean ip(int number) {
        if (number < 1)
            throw new IllegalArgumentException("number must be positive");
        int max = Math.min((int) Math.sqrt(number), number - 1);
        // at max the iterator cannot reach the number itself
        if (number == 1)
            return false; // hard coded logic
        for (int i = 2; i <= max; i++)
            if (number % i == 0)
                return false;
        return true;
    }

    /**
     * converts a number to a boolean (binary) array
     * @param n non negative integer to split into binary digits
     * @return binary digits
     */
    public static boolean[] tb(int n) {
        if (n < 0)
            throw new IllegalArgumentException("number must be positive or zero");
        // Math.log(n) / Math.log(2) = Math log base 2 val n
        int length = (int) Math.ceil(Math.log(n+1) / Math.log(2));
        boolean[] digits = new boolean[length];
        for (int i = digits.length - 1; i >= 0; i--) {
            if (n % 2 == 1)
                digits[i] = true;
            n = Math.floorDiv(n, 2);
        }
        return digits;
    }

    /**
     * find the max common denominator
     * @param n array of numbers
     * @return max common denominator of the numbers
     */
    public static int fmcd(int... n) {
        Arrays.sort(n);
        int s = n[0]; // smallest number
        ol:
        for (int d = s; d > 1; d--) {
            // from s to 1
            for (int aN : n) {
                if (aN % d != 0)
                    continue ol;
            }
            return d; // if this process has not been skipped
        }
        return 1; // the common denominator is at least 1
    }

}
