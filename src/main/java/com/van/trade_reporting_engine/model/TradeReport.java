package com.van.trade_reporting_engine.model;

import com.van.trade_reporting_engine.model.event.RequestConfirmation;
import jakarta.persistence.Table;
import lombok.Builder;

@Table(schema = "tradeReports")
@Builder
public record TradeReport(
    RequestConfirmation requestConfirmation
) {
}
