package problems;

/**
 * Created by Thomas on 7/07/2014.
 * <p>
 * URL: https://projecteuler.net/problem=19
 * LATEST RESULT: SUCCESS
 */
public class problem_019 {

    private static final int[] DAYS_OF_MONTHS = new int[]{
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    }; // remember february has 29 on a leap year

    public static void main(String[] args) {
        // since Jan 1 1900 was a Monday
        int days_from_first_sunday = 1;
        int sundays = 0;
        for (int y = 1900; y <= 2000; y++) {
            for (int m = 0; m < 12; m++) {
                // counting starts from year 1901
                if (days_from_first_sunday % 7 == 0 && y > 1900) {
                    System.out.printf("the first of %d, %d is a sunday\n", m + 1, y);
                    sundays++;
                }
                days_from_first_sunday += DAYS_OF_MONTHS[m];
//                if (m == 1 && (i % 4 == 0 && !(i % 100 == 0) && (i % 400 != 0))) {
//                    // valid leap year
//                    days_from_first_sunday ++;
//                }
                if (m == 1) {
                    if (y % 4 == 0) {
                        if (y % 100 == 0) {
                            if (y % 400 == 0) {
//                                System.out.printf("year %d is a leap year\n", y);
                                days_from_first_sunday++;
                            }
                        } else {
//                            System.out.printf("year %d is a leap year\n", y);
                            days_from_first_sunday++;
                        }
                    }
                }
            }
        }
        System.out.println("answer: " + sundays);
    }

}
