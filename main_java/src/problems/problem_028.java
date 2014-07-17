package problems;

/**
 * Created by Thomas on 8/07/2014.
 *
 * URL: https://projecteuler.net/problem=28
 * LATEST RESULT: SUCCESS
 * RATING: NORMAL
 */
public class problem_028 {

    public static void main(String[] args) {
        int total = 1; // note 1 is already appended
        int currNum = 1;
        int incrementer = 2;
        for (int i = 1; i <= 2000; i++) {
            // increment the number properly
            // then append it to the total
            currNum += incrementer;
            if (i % 4 == 0) {
                incrementer += 2;
            }
            total += currNum;
        }
        System.out.println("answer: " + total);
    }

}
