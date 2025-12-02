package com.solvians.showcase.generators;

import java.util.concurrent.ThreadLocalRandom;

public class FeedIsinGenerator implements Generator<String> {

    private static final char[] ALLOWED = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final int MAX_INTEGER_LIMIT = 9;
    @Override
    public String generate() {
        StringBuilder sb = new StringBuilder(12);
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        sb.append(ALLOWED[rnd.nextInt(ALLOWED.length)]);
        sb.append(ALLOWED[rnd.nextInt(ALLOWED.length)]);

        generateRandomNumbersForSize(MAX_INTEGER_LIMIT, sb, rnd);
        String beforeCheckDigit = sb.toString();
        sb.append(checkDigit(beforeCheckDigit));

        return sb.toString();
    }

    private void generateRandomNumbersForSize(int length, StringBuilder sb, ThreadLocalRandom rnd) {
        for (int i=0; i < length; i++) {
            sb.append(rnd.nextInt(0, 10));
        }
    }

    public int checkDigit(String generated) {
        // Step 1, Convert the string to numbers
        StringBuilder numbers = new StringBuilder();
        for (char c : generated.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                // A - A + 10 = 10, A = 10
                numbers.append(c - 'A' + 10);
            }

            if (Character.isDigit(c)) {
                numbers.append(c);
            }
        }

        int total = 0;
        boolean needsMultiply = true;
        // Step 2 multiply alternative digit by 2 from last and add
        for ( int i = numbers.length() - 1; i > 0; i--) {
            int val = numbers.charAt(i) - '0';
            if (needsMultiply) {
                val = val * 2;
            }

            total += val / 10 + val % 10;
        }

        // Step 3 Convert to nearest 10th value
        return 10 - (total % 10);
    }
}
