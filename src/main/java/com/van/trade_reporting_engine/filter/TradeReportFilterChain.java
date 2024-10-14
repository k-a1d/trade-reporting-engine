package com.van.trade_reporting_engine.filter;

import com.van.trade_reporting_engine.model.data.TradeReport;

import java.util.Arrays;

public class TradeReportFilterChain {

    private static final String EMU = "EMU_BANK";
    private static final String BISON = "BISON_BANK";
    private static final String AUD = "AUD";
    private static final String USD = "USD";

    public static TradeReport filter(TradeReport report) {
        var buyerSellerFilter = new AnagramFilter(report.getBuyerParty(), report.getSellerParty());

        var emuAndAudFilter = new EqualsFilter(EMU, report.getSellerParty())
            .setNext(new EqualsFilter(AUD, report.getCurrency())
                .setNext(buyerSellerFilter));

        var bisonAndUsdFilter = new EqualsFilter(BISON, report.getSellerParty())
            .setNext(new EqualsFilter(USD, report.getCurrency())
                .setNext(buyerSellerFilter));

        return new OrFilter(Arrays.asList(emuAndAudFilter, bisonAndUsdFilter))
            .filter(report);
    }

}
