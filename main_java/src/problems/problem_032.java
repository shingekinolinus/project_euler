package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Thomas on 8/07/2014.
 * <p>
 * URL: https://projecteuler.net/problem=32
 * LATEST RESULT: UNTESTED
 * RATING: NORMAL
 * GITHUB: SMARTASS
 */
public class problem_032 {

    private static final char[] numberChars = "123456789".toCharArray();

    public static void main(String[] args) {
        int answer = 0;
        final HashSet<Integer> uniqueNumbers = new HashSet<>();
        // a * b < 100_000
        for (int a = 1; a < 100_000; a++) {
            for (int b = 1; b < Math.floorDiv(100_000, a); b++) {
                int product = a * b;
                String wholeString = String.valueOf(a) + String.valueOf(b) + String.valueOf(product);
                if (isValid(wholeString.toCharArray())) {
                    uniqueNumbers.add(product);
                }
            }
        }
        for (int product : uniqueNumbers) {
            answer += product;
        }
        System.out.println("answer: " + answer);
    }

    private static boolean isValid(char[] chars) {
        // NOTE: use the Arrays.sort function
        if (chars.length != 9)
            return false;
        for (char numChar : numberChars) {
            boolean hasThisNumberChar = false;
            for (char c : chars) {
                if (numChar == c) {
                    hasThisNumberChar = true;
                    break;
                }
            }
            if (!hasThisNumberChar) {
                return false;
            }
        }
        return true;
    }

}
