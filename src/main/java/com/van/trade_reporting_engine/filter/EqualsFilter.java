package com.van.trade_reporting_engine.filter;

import com.van.trade_reporting_engine.model.data.TradeReport;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EqualsFilter implements TradeReportFilter {

    private TradeReportFilter next;
    private final String expectedValue;
    private final String actualValue;

    @Override
    public TradeReport filter(TradeReport report) {
        if (expectedValue.equals(actualValue)) {
            return next == null ? report : next.filter(report);
        }
        return null;
    }

    @Override
    public TradeReportFilter setNext(TradeReportFilter next) {
        this.next = next;
        return this;
    }

}
