package problems;

/**
 * Created by Legend on 5/07/2014.
 * <p>
 * URL: http://projecteuler.net/problem=1
 * LATEST RESULT: SUCCESS
 */
public class problem_001 {

    public static void main(String[] args) {
        int total = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                total += i;
            }
        }
        System.out.println(total);
    }

}
