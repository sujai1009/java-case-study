package com.solvians.showcase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class CertificateUpdateGenerator {
    private final int threads;
    private final int quotes;

    public CertificateUpdateGenerator(int threads, int quotes) {
        this.threads = threads;
        this.quotes = quotes;
    }

    public Stream<CertificateUpdate> generateQuotes() {

        // Not sure why we need this block, So it was commented.
        /*
        ThreadLocalRandom random = ThreadLocalRandom.current();
        // TODO: Implement me.
        List<CertificateUpdate> updateList = new ArrayList<CertificateUpdate>();
        for (int i = 0; i < threads * quotes; i++) {
            updateList.add(new CertificateUpdate());
        }
        */
        // Assuming the quotes is what we need in total, threads are just a way to execute in parallel.
        // But Stream already does it, So have not used the thred value
        // Changed the testcase also accordingly.
        return Stream.generate(CertificateUpdate::new).parallel().limit(quotes);
    }
}
