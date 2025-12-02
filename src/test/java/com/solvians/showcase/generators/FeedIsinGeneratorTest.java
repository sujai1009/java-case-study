package com.solvians.showcase.generators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FeedIsinGeneratorTest {

    @Test
    void testIsinGeneratedValue() {
        FeedIsinGenerator gen = new FeedIsinGenerator();
        String val = gen.generate();
        assertNotNull(val);
        assertEquals(12, val.length());
        String without = val.substring(0, 11);
        int expectedCheckDigit = gen.checkDigit(without);
        int actualCheckDigit = val.charAt(11) - '0';
        assertEquals(expectedCheckDigit, actualCheckDigit, "Generated as expected");
    }

    @Test
    void testProperCheckValue() {
        FeedIsinGenerator gen = new FeedIsinGenerator();
        String checkValue = "TJ3618833683";

        int checkdigit = gen.checkDigit(checkValue.substring(0, checkValue.length() - 1));
        int parsedCheckDigit = Integer.parseInt(checkValue.substring(checkValue.length() - 1));

        assertEquals(checkdigit, parsedCheckDigit);
        assertEquals(checkdigit, 3);
    }

    @Test
    void testInvalidCheckValue() {
        FeedIsinGenerator gen = new FeedIsinGenerator();
        String checkValue = "OQ9990110902";

        int checkdigit = gen.checkDigit(checkValue.substring(0, checkValue.length() - 1));
        int parsedCheckDigit = Integer.parseInt(checkValue.substring(checkValue.length() - 1));

        assertNotEquals(checkdigit, parsedCheckDigit);
    }
}
