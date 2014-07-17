package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Thomas on 7/07/2014.
 * <p>
 * URL: https://projecteuler.net/problem=24
 * LATEST RESULT: SUCCESS
 * RATING: NORMAL
 */
public class problem_024 {

    public static void main(String[] args) {
        int currentNum = 1_000_000 - 1; // this operates same as array index
        List<Object> items = new ArrayList<>(Arrays.asList(
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
        ));
        int divisor = getFactorial(items.size());
        List<Integer> order = new LinkedList<>();
        for (int i = items.size(); i > 0; i--) {
            divisor /= i;
            int digit = Math.floorDiv(currentNum, divisor);
//            if (digit > 0)
            order.add(digit);
            currentNum = currentNum % divisor;
        }

        for (int index : order) {
            System.out.print(items.get(index));
            items.remove(index);
        }
    }

    private static int getFactorial(int number) {
        int factorial = 1;
        for (int i = 2; i <= number; i++)
            factorial *= i;
        return factorial;
    }

}
