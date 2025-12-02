package com.solvians.showcase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CertificateUpdateTest {
    @Test
    void testCertificateQuotesGenerator() throws Exception {
        CertificateUpdate update = new CertificateUpdate();

        String quoteGenerated = update.call();

        assertNotNull(quoteGenerated);
        String[] quotesParts = quoteGenerated.split(",");
        assertEquals(6, quotesParts.length);

        // Check timestamp
        long ts = Long.parseLong(quotesParts[0]);
        assertTrue(ts > 0);

        // Check isin
        String isin = quotesParts[1];
        assertEquals(12, isin.length());

        // check Bid price and size
        double bid = Double.parseDouble(quotesParts[2]);
        int bidSize = Integer.parseInt(quotesParts[3]);
        assertTrue(bid >= 100.0 && bid <= 200.0 + 0.01);
        assertTrue(bidSize >= 1000 && bidSize <= 5000);

        // Check ask price and size
        double ask = Double.parseDouble(quotesParts[4]);
        int askSize = Integer.parseInt(quotesParts[5]);
        assertTrue(ask >= 100.0 && ask <= 200.0 + 0.01);
        assertTrue(askSize >= 1000 && askSize <= 10000);
    }
}
