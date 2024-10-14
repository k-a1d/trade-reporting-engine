package com.van.trade_reporting_engine.filter;

import com.van.trade_reporting_engine.model.data.TradeReport;
import org.junit.jupiter.api.Test;

import static com.van.trade_reporting_engine.filter.TradeReportFilterChain.filter;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TradeReportFilterChainTest {

    @Test
    public void filterEmuAndAudPasses() {
        TradeReport report = TradeReport.builder()
            .buyerParty("A_BANK")
            .sellerParty("EMU_BANK")
            .currency("AUD")
            .build();

        assertEquals(filter(report), report);
    }

    @Test
    public void filterBisonAndUsdPasses() {
        TradeReport report = TradeReport.builder()
            .buyerParty("A_BANK")
            .sellerParty("BISON_BANK")
            .currency("USD")
            .build();

        assertEquals(filter(report), report);
    }

    @Test
    public void filterInvalidBankFails() {
        TradeReport report = TradeReport.builder()
            .buyerParty("A_BANK")
            .sellerParty("INVALID_BANK")
            .currency("AUD")
            .build();

        assertNull(filter(report));
    }

    @Test
    public void filterInvalidCombinationFails() {
        TradeReport report = TradeReport.builder()
            .buyerParty("A_BANK")
            .sellerParty("EMU_BANK")
            .currency("USD")
            .build();

        assertNull(filter(report));
    }

    @Test
    public void filterAnagramFails() {
        TradeReport report = TradeReport.builder()
            .buyerParty("BANK_EMU")
            .sellerParty("EMU_BANK")
            .currency("AUD")
            .build();

        assertNull(filter(report));
    }

    @Test
    public void filterEmptyReportFails() {
        TradeReport report = TradeReport.builder().build();

        assertNull(filter(report));
    }
}
