package problems;

import java.util.Arrays;

import static problems.MathLib.*;

/**
 * Created by Thomas on 8/07/2014.
 * <p>
 * URL: https://projecteuler.net/problem=29
 * LATEST RESULT: SUCCESS
 * RATING: HARDER
 * GITHUB: UNRATED
 */
public class problem_038 {

    public static void main(String[] args) {
        int maxPandigital = 0;
        int ans = 0;
        for (int i = 1; i < 10000; i++) {
            // original integer is always less than 10000
            String str = String.valueOf(i);
            for (int j = 2; str.length() < 9; j++) {
                str += String.valueOf(i * j);
            }
            if (str.length() == 9) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars); // thanks to nayuki
                if (new String(chars).equals("123456789")) {
//                    System.out.println(str);
                    int pandigital = Integer.valueOf(str);
                    if (pandigital > maxPandigital) {
                        maxPandigital = pandigital;
                    }
                }
            }
        }
        ans = maxPandigital;
        System.out.println("answer: " + ans);
    }

}
