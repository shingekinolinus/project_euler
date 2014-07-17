package problems;

import static problems.MathLib.*;

/**
 * Created by Thomas on 8/07/2014.
 * <p>
 * URL: https://projecteuler.net/problem=36
 * LATEST RESULT: SUCCESS
 * RATING: NORMAL
 * GITHUB: UNRATED
 */
public class problem_036 {

    public static void main(String[] args) {
        int ans = 0;
        ml:
        for (int i = 1; i < 1_000_000; i++) {
            byte[] digits = digits(i);
            boolean[] binDigits = tb(i);
            for (int a = 0; a < Math.floorDiv(digits.length, 2); a++)
                if (digits[a] != digits[digits.length - a - 1])
                    continue ml; // digit mismatch
            for (int b = 0; b < Math.floorDiv(binDigits.length, 2); b++) {
                if (binDigits[b] != binDigits[binDigits.length - b - 1])
                    continue ml; // binary digit mismatch
            }
            ans += i;
        }
        System.out.println("answer: " + ans);
    }

}
