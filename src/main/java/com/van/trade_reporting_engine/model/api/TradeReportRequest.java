package com.van.trade_reporting_engine.model.api;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TradeReportRequest {
    private String buyerParty;
    private String sellerParty;
    private double amount;
    private String currency;
}
