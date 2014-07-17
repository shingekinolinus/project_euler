package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Thomas on 8/07/2014.
 * <p>
 * URL: https://projecteuler.net/problem=30
 * LATEST RESULT: SUCCESS
 * RATING: NORMAL
 * GITHUB: SMARTER
 */
public class problem_030 {

    private static final AtomicReference<List<Integer>> FOUND_NUMBERS =
            new AtomicReference<>(new ArrayList<>());

    // stores if each thread has executed
    private static final boolean[] EXECUTION_COMPLETE = new boolean[6];

    private static Thread mainThread;

    public static void main(String[] args) throws InterruptedException {
        mainThread = Thread.currentThread();
        int answer = 0;
        // fire each and every thread
        // NOTICE! theoretically the number cannot have 7 digits,
        // since 9^5 * 7 is smaller than 1_000_000
        int chunkSize = 1_000_000;
        for (int i = 0; i < 6; i++) {
            // few numbers will be evaluated twice, but that does not matter
            int start = chunkSize * i + 2;
            int end = chunkSize * (i + 1) + 2;
            new Thread(new EvaluatorRunnable(start, end, i)).start(); // start a new thread
        }
        try {
            mainThread.sleep(Long.MAX_VALUE); // wait for other threads to start it
        } catch (InterruptedException e) {
            for (int number : FOUND_NUMBERS.get()) {
                answer += number;
            }
            System.out.println("answer: " + answer);
        }
    }

    private static final class EvaluatorRunnable implements Runnable {

        private final int start;
        private final int end;
        private final int index;

        private EvaluatorRunnable(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public void run() {
            for (int i = start; i <= end; i++) {
                char[] chars = String.valueOf(i).toCharArray();
                int total = 0;
                for (int n = 0; n < chars.length; n++) {
                    byte digit = Byte.valueOf(String.valueOf(chars[n]));
                    total += digit * digit * digit * digit * digit; // digit ** 5
                }
                if (total == i)
                    FOUND_NUMBERS.get().add(total);
            }
            EXECUTION_COMPLETE[index] = true;
            if (allExecuted()) {
                mainThread.interrupt();
            }
        }
    }

    private static boolean allExecuted() {
        // check if all the values in the array are true
        for (boolean b : EXECUTION_COMPLETE)
            if (!b)
                return false;
        return true;
    }

}
