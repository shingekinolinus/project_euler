package problems;

import static problems.MathLib.*;

/**
 * Created by Thomas on 8/07/2014.
 * <p>
 * URL: https://projecteuler.net/problem=34
 * LATEST RESULT: SUCCESS
 * RATING: NORMAL
 * GITHUB: EVEN MATCH
 */
public class problem_034 {

    public static void main(String[] args) {
        int ans = 0;
        // a curious number cannot be larger than 7 digits
        // or more accurately, the number shown below
        for (int i = 10; i < 2540160; i++) {
            byte[] digits = digits(i);
            int t = 0;
            for (byte d : digits) {
                t += fcs(d);
            }
            if (t == i)
                ans += i;
        }
        System.out.println("answer: " + ans);
    }

}
