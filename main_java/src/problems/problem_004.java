package problems;

import java.util.Arrays;

/**
 * Created by Legend on 5/07/2014.
 * <p>
 * URL: http://projecteuler.net/problem=4
 * LATEST RESULT: SUCCESS
 */
public class problem_004 {

    public static void main(String[] args) {
        int largest_palindromic = 0;
        int[] corresponding_xy = new int[]{
                100, 100
        };
        for (int x = 100; x < 1000; x++) {
            for (int y = 100; y < 1000; y++) {
                int product = x * y;
                String product_string = String.valueOf(product);
                if (new StringBuilder(product_string).reverse()
                        .toString().equals(product_string)) {
                    // largest thing found
                    if (product > largest_palindromic) {
                        largest_palindromic = product;
                        corresponding_xy[0] = x;
                        corresponding_xy[1] = y;
                    }
                }
            }
        }
        System.out.println(largest_palindromic);
        System.out.println(Arrays.toString(corresponding_xy));
    }

}
