package com.solvians.showcase.generators;

import org.junit.jupiter.api.Test;

public class FeedPrizeGeneratorTest {

    @Test
    void testPrizeGeneratedValue() {
        FeedPrizeGenerator gen = new FeedPrizeGenerator();
        Double val = gen.generate();
        assert(val < FeedPrizeGenerator.MAX);
        assert(val > FeedPrizeGenerator.MIN);
    }
}
