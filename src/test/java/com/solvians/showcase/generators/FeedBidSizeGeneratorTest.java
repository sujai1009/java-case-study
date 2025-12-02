package com.solvians.showcase.generators;

import com.solvians.showcase.App;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeedBidSizeGeneratorTest {
    @Test
    void testBidSizeGeneratedValue() {
        FeedBidSizeGenerator gen = new FeedBidSizeGenerator();
        gen.setRange(5, 10);
        Integer val = gen.generate();
        assert(val < 10);
        assert(val > 5);
    }

    @Test
    void testBidSizeSettingInvalidValue() {
        FeedBidSizeGenerator gen = new FeedBidSizeGenerator();
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            gen.setRange(10, 5);
        });
        assertEquals(exception.getMessage(), "Invalid range values " + 10 + "," + 5);
    }
}
