package problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;

/**
 * Created by Legend on 6/07/2014.
 * <p>
 * URL: https://projecteuler.net/problem=13
 * LATEST RESULT: SUCCESS
 */
public class problem_013 {

    public static void main(String[] args) throws Throwable {
        final BufferedReader reader = new BufferedReader(new FileReader("problem_013_input.txt"));
        BigInteger total = BigInteger.ZERO;
        String line;
        while ((line = reader.readLine()) != null) {
            BigInteger number = new BigInteger(line);
            total = total.add(number);
        }

        System.out.println("answer: " + total.toString().substring(0, 10));
        reader.close();
    }

}
