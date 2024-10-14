package com.van.trade_reporting_engine.filter;

import com.van.trade_reporting_engine.model.data.TradeReport;

public interface TradeReportFilter {

    TradeReportFilter setNext(TradeReportFilter tradeReportFilter);

    TradeReport filter(TradeReport tradeReport);

}
