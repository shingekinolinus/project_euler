package problems;

import java.util.HashSet;

/**
 * Created by Legend on 6/07/2014.
 * <p>
 * URL: http://projecteuler.net/problem=12
 * LATEST STATUS: SUCCESS
 */
public class problem_012 {

    public static void main(String[] args) {
        int number = 1;
        int i = 2;
        while (get_factor_count(number) < 500) {
            number += i;
            i += 1;
        }
        System.out.println("number = " + number);
    }

    private static int get_factor_count(int number) {
        HashSet<Integer> factor_set = new HashSet<>();
        int number_root = (int) Math.sqrt(number);
        for (int i = 1; i <= number_root; i++) {
            if (number % i == 0) {
                factor_set.add(i);
                factor_set.add(number / i);
            }
        }
        return factor_set.size();
    }

}
