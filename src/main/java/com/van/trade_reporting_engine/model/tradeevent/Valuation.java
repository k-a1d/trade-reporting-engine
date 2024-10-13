package com.van.trade_reporting_engine.model.tradeevent;

import jakarta.xml.bind.annotation.XmlAccessorType;

import static jakarta.xml.bind.annotation.XmlAccessType.FIELD;

@XmlAccessorType(FIELD)
public record Valuation(
    ValuationDate valuationDate,
    boolean futuresPriceValuation
) {
}
