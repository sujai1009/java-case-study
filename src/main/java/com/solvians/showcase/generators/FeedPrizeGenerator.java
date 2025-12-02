package com.solvians.showcase.generators;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

public class FeedPrizeGenerator implements Generator<Double> {

    public static final int MIN = 100;
    public static final int MAX = 200;

    @Override
    public Double generate() {
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        BigDecimal toRoundScale = BigDecimal.valueOf(rnd.nextDouble(MIN, MAX));
        toRoundScale = toRoundScale.setScale(2, RoundingMode.HALF_UP);
        return toRoundScale.doubleValue();
    }
}
