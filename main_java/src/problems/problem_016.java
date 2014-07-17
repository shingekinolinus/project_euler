package problems;

import java.math.BigInteger;

/**
 * Created by Legend on 6/07/2014.
 * <p>
 * URL: https://projecteuler.net/problem=16
 * LATEST RESULT: SUCCESS
 */
public class problem_016 {

    public static void main(String[] args) {
        char[] chars_of_two_to_1000 = BigInteger.valueOf(2).pow(1000).toString().toCharArray();
        int total = 0;
        for (char c : chars_of_two_to_1000) {
            total += Integer.valueOf(String.valueOf(c));
        }
        System.out.println("answer: " + total);
    }

}
