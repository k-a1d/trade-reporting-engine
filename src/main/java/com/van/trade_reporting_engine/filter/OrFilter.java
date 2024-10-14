package com.van.trade_reporting_engine.filter;

import com.van.trade_reporting_engine.model.data.TradeReport;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class OrFilter implements TradeReportFilter {

    private TradeReportFilter next;
    private final List<TradeReportFilter> filters;

    @Override
    public TradeReport filter(TradeReport report) {
        for (TradeReportFilter filter : filters) {
            if (filter.filter(report) != null) {
                return next == null ? report : next.filter(report);
            }
        }
        return null; // All filters returned false
    }

    @Override
    public TradeReportFilter setNext(TradeReportFilter next) {
        this.next = next;
        return this;
    }

}

