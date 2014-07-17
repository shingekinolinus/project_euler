package problems;

/**
 * Created by Legend on 6/07/2014.
 * <p>
 * finally up to 2 digits
 * URL: http://projecteuler.net/problem=10
 * LATEST RESULT: SUCCESS
 */
public class problem_010 {

    public static void main(String[] args) {
        long total = 0;
        for (int i = 2; i < 2_000_000; i++) {
            if (problem_007.is_prime(i)) {
                total += i;
            }
        }
        System.out.println(total);
    }

}
