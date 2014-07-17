package problems;

/**
 * Created by Legend on 5/07/2014.
 * <p>
 * URL: http://projecteuler.net/problem=6
 * LATEST RESULT: SUCCESS
 */
public class problem_006 {

    public static void main(String[] args) {
        int square_sum = 0;
        int sum = 0;
        // it does not matter if zero is included
        for (int i = 1; i <= 100; i++) {
            square_sum += i * i;
            sum += i;
        }

        int sum_squared = sum * sum;
        System.out.println(sum_squared - square_sum);
    }

}
