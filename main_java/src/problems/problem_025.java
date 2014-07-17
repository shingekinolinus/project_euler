package problems;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Thomas on 7/07/2014.
 * <p>
 * DAMN THE FIBONACCI SEQUENCE USED IS NOT OFFICIAL, IT STARTS FROM 1, 1 RATHER THAN 0, 1
 * URL: https://projecteuler.net/problem=25
 * LATEST RESULT: SUCCESS
 * RATING: NORMAL
 */
public class problem_025 {

    public static void main(String[] args) {
        BigInteger prevNum = BigInteger.ONE;
        BigInteger currNum = BigInteger.ONE;
        final BigInteger target = BigInteger.TEN.pow(999);
        // this means fib #3 will be generated later on ????
        int index = 2; // I SHOULD NEVER HAVE CHANGED THIS TO 3
        while (currNum.compareTo(target) < 0) {
            // target not reached yet
            index ++;
            BigInteger oldCurrNum = currNum;
            currNum = prevNum.add(currNum);
            prevNum = oldCurrNum;
        }
        System.out.println(index);
        System.out.println(currNum.toString());
    }

}
