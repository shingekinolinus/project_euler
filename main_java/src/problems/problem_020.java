package problems;

import java.math.BigInteger;

/**
 * Created by Thomas on 7/07/2014.
 * <p>
 * URL: https://projecteuler.net/problem=20
 * LATEST RESULT: SUCCESS
 * RATING: SUPER EASY
 */
public class problem_020 {

    public static void main(String[] args) {
        BigInteger fact100 = BigInteger.ONE;
        // calculating fc 100
        for (int i = 2; i < 100; i++) {
            fact100 = fact100.multiply(BigInteger.valueOf(i));
        }
        String fact100String = fact100.toString();
        int fact100Sum = 0;
        for (int i = 0; i < fact100String.length(); i++) {
            // "123456" -> "2" -> 2 sth like that
            fact100Sum += Integer.valueOf(String.valueOf(fact100String.charAt(i)));
        }
        System.out.println("answer: " + fact100Sum);
    }

}
