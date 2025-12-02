package com.solvians.showcase.generators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FeedTimeStampGeneratorTest {

    @Test
    void testTimeStampGenerated() {
        FeedTimeStampGenerator gen = new FeedTimeStampGenerator();
        Long val = gen.generate();
        assertNotNull(val);
        assert(val > 0);
        Long reverseRestructured = new Long(val.toString());
        assertEquals(val, reverseRestructured);
    }
}
