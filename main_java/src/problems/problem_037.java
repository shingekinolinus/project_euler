package problems;

import static problems.MathLib.*;

/**
 * Created by Thomas on 8/07/2014.
 * <p>
 * URL: https://projecteuler.net/problem=37
 * LATEST RESULT: SUCCESS
 * RATING: NORMAL
 * GITHUB: UNRATED
 */
public class problem_037 {

    public static void main(String[] args) {
        int ans = 0;
        ml:
        for (int i = 10; i < 1_000_000; i++) {
            if (ip(i)) {
                String ns = String.valueOf(i);
                String nsL = ns;
                String nsR = ns;
                for (int n = 0; n < ns.length() - 1; n++) {
                    nsL = nsL.substring(0, nsL.length() - 1);
                    if (!ip(Integer.valueOf(nsL)))
                        continue ml;
                }
                for (int n = 0; n < ns.length() - 1; n++) {
                    nsR = nsR.substring(1);
                    if (!ip(Integer.valueOf(nsR)))
                        continue ml;
                }
                ans += i;
            }
        }
        System.out.println("answer: " + ans);
    }

}
