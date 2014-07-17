package problems;

/**
 * Created by Legend on 6/07/2014.
 * <p>
 * URL: https://projecteuler.net/problem=17
 * LATEST RESULT: SUCCESS
 */
public class problem_017 {

    public static void main(String[] args) {
        int total = 0;
        for (int i = 1; i <= 1000; i++) {
            total += count_letters(express_in_british(i));
        }
        System.out.print("answer: " + total);
    }

    private static final char[] ALPHABET_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    static int count_letters(String string) {
        string = string.toUpperCase(); // uppercase is required
        int total = 0;
        letterLoop:
        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < ALPHABET_CHARS.length; j++) {
                if (ALPHABET_CHARS[j] == string.charAt(i)) {
                    total++;
                    continue letterLoop;
                }
            }
        }
        return total;
    }

    static String express_in_british(int number) {

        // the core performance-related dependency of this algorithm
        final StringBuilder builder = new StringBuilder();

        if (number < 0) {
            builder.append("minus ");
            number *= -1;
        } else if (number == 0) {
            return "zero"; // zero is not used anywhere else
        }

        // step 1: split number into segments
        final String number_string = String.valueOf(number);
        int str_len = number_string.length();

        int highest_segment_len = str_len % 3;
        if (highest_segment_len == 0) {
            highest_segment_len = 3;
        }
        int segment_count = str_len % 3 == 0 ? str_len / 3 : str_len / 3 + 1;

        int[] segments = new int[segment_count];
        for (int i = 0; i < segment_count; i++) {
            if (i == 0) {
                // first segment
                segments[0] = Integer.valueOf(number_string.substring(0, highest_segment_len));
            } else {
                // java substring has no length mode
                // it sucks i know
                segments[i] = Integer.valueOf(
                        number_string.substring(highest_segment_len + i * 3 - 3, highest_segment_len + i * 3));
            }
        }

        for (int i = 0; i < segments.length; i++) {
            int segment = segments[i];
            int segment_power_index = segments.length - i - 1;
            if (segment != 0) {
                // the data will be injected into builder
                express_segment_in_british(segment, builder);
                if (segment_power_index > 0) {
                    builder.append(" ");
                    builder.append(NAMES_OF_SEGMENTS[segment_power_index]);
                }
                // not too efficient algorithm, looks for after segments
                // and if any are not empty, a ", " or "and " will be appended
                boolean afterwards_all_empty = true;
                for (int j = i + 1; j < segments.length; j++) {
                    if (segments[j] != 0)
                        afterwards_all_empty = false;
                }
//                if (i < segments.length - 1)
//                    // variable 'segment' is not the last segment
                if (!afterwards_all_empty)
                    if (segment_power_index > 1)
                        // after millions, billions etc
                        builder.append(", ");
                    else if (segment_power_index > 0) {
                        // after thousands
                        builder.append(" and ");
                    }
            }
        }

        return builder.toString();
    }

    private static final String[] NAMES_OF_SEGMENTS = new String[]{
            "ERROR", "thousand", "million", "billion" // note empty string is used as "ones"
    };

    /**
     * expresses a segment of a number in british
     * for example, to express the 031 in 330,031,291
     *
     * @param segment number smaller than 1000
     * @param builder result will be stored in here
     */
    private static void express_segment_in_british(int segment, StringBuilder builder) {
        if (segment >= 1000) {
            throw new IllegalArgumentException("segments cannot be larger than or equal to 1000!");
        }
        final String segment_string = String.valueOf(segment);
        final int hundreds = Math.floorDiv(segment, 100);
        final int tens = Math.floorDiv(segment - hundreds * 100, 10);
        final int ones = segment - hundreds * 100 - tens * 10; // the rest are ones
        if (hundreds > 0) {
            builder.append(DIGIT_STRING[hundreds]).append(" hundred");
            if (tens > 0 || ones > 0) {
                builder.append(" and ");
            }
        }
        if (tens == 1) {
            // range from 11 to 19
            builder.append(TEEN_STRING[ones]);
        } else if (tens > 1) {
            // from 20 and so on
            builder.append(TEN_STRING[tens]);
            if (ones > 0) {
                builder.append("-");
                builder.append(DIGIT_STRING[ones]);
            }
        }
        if (tens == 0 & ones > 0) {
            builder.append(DIGIT_STRING[ones]);
        }
    }

    private static final String[] DIGIT_STRING = new String[]{
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    private static final String[] TEEN_STRING = new String[]{
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] TEN_STRING = new String[]{
            "ERROR", "ERROR", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };


}
