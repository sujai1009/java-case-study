package com.solvians.showcase;

import com.solvians.showcase.generators.FeedBidSizeGenerator;
import com.solvians.showcase.generators.FeedIsinGenerator;
import com.solvians.showcase.generators.FeedPrizeGenerator;
import com.solvians.showcase.generators.FeedTimeStampGenerator;

import java.util.concurrent.Callable;

public class CertificateUpdate implements Callable<String> {
    // TODO: implement me.

    private final FeedTimeStampGenerator timeStampGenerator = new FeedTimeStampGenerator();
    private final FeedIsinGenerator isinGenerator = new FeedIsinGenerator();
    private final FeedPrizeGenerator prizeGenerator = new FeedPrizeGenerator();
    private final FeedBidSizeGenerator bidSizeGenerator = new FeedBidSizeGenerator();

    private static final String SEPERATOR = ",";
    @Override
    public String call() throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(timeStampGenerator.generate());
        sb.append(SEPERATOR);
        sb.append(isinGenerator.generate());
        sb.append(SEPERATOR);
        sb.append(prizeGenerator.generate());
        sb.append(SEPERATOR);
        sb.append(bidSizeGenerator.setRange(1000, 5000).generate());
        sb.append(SEPERATOR);
        sb.append(prizeGenerator.generate());
        sb.append(SEPERATOR);
        sb.append(bidSizeGenerator.setRange(1000, 10000).generate());
        return sb.toString();
    }
}
