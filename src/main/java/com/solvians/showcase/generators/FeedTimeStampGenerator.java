package com.solvians.showcase.generators;

import java.time.Instant;

public class FeedTimeStampGenerator implements Generator<Long> {
    @Override
    public Long generate() {
        return Instant.now().toEpochMilli();
    }
}
