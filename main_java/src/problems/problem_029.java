package problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Thomas on 8/07/2014.
 * <p>
 * URL: https://projecteuler.net/problem=29
 * LATEST RESULT: SUCCESS
 * RATING: NORMAL
 */
public class problem_029 {

    public static void main(String[] args) {
        int answer = 0;
        // these integers are BIGGGGG
        ArrayList<BigInteger> uniqueTerms = new ArrayList<>();
        for (int a = 2; a <= 100; a++) {
            for (int b = 2; b <= 100; b++) {
                BigInteger result = BigInteger.valueOf(a).pow(b);
//                System.out.printf("%d ** %d = %d\n", a, b, result);
                if (!uniqueTerms.contains(result))
                    uniqueTerms.add(result);
            }
        }
        answer = uniqueTerms.size();
        System.out.println("answer: " + answer);
    }

}
