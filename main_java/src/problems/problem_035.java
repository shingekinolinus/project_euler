package problems;

import static problems.MathLib.*;

/**
 * Created by Thomas on 8/07/2014.
 * <p>
 * URL: https://projecteuler.net/problem=35
 * LATEST RESULT: SUCCESS
 * RATING: NORMAL
 * GITHUB: EVEN MATCH
 */
public class problem_035 {

    public static void main(String[] args) {
        int ans = 0;
        ml:
        for (int i = 1; i < 1_000_000; i++) {
            if (ip(i)) {
                // i is a prime number
                String s = String.valueOf(i);
                for (int j = 0; j < s.length() - 1; j++) {
                    s = s.substring(1) + s.substring(0, 1);
                    if (!ip(Integer.valueOf(s)))
                        continue ml;
                }
                ans ++;
            }
        }
        System.out.println("answer: " + ans);
    }

}
