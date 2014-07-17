package problems;

/**
 * Created by Legend on 5/07/2014.
 * <p>
 * URL: http://projecteuler.net/problem=9
 * LATEST RESULT: SUCCESS
 */
public class problem_009 {

    public static void main(String[] args) throws InterruptedException {
        for (int c = 1000; c > 333; c--) {
            // from 1000 to 667
            int reserve = 1000 - c;
            for (int b = reserve; b > reserve / 2; b--) {
                int a = 1000 - b - c;
                Thread.sleep(0, 1);
//                System.out.printf("%d^2 + %d^2 = %d^2\n", a, b, c);
                if (a * a + b * b == c * c) {
                    System.out.printf("%d^2 + %d^2 = %d^2\n%d * %d * %d = %d\n", a, b, c, a, b, c, a * b * c);
                }
            }
        }
    }

}
