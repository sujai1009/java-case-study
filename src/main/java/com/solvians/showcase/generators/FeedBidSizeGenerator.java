package com.solvians.showcase.generators;

import java.util.concurrent.ThreadLocalRandom;

public class FeedBidSizeGenerator implements Generator<Integer> {

    private int rangeMin;
    private int rangeMax;

    public FeedBidSizeGenerator setRange(int min, int max) {

        if ( min > max) {
            throw new RuntimeException("Invalid range values " + min + "," + max);
        }
        this.rangeMin = min;
        this.rangeMax = max;

        return this;
    }

    @Override
    public Integer generate() {
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        return rnd.nextInt(rangeMin, rangeMax);
    }
}
