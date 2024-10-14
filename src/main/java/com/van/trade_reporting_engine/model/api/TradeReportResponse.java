package com.van.trade_reporting_engine.model.api;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TradeReportResponse {
    private JsonNode responseBody;
}
