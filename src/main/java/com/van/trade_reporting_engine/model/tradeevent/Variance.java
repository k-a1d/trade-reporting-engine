package com.van.trade_reporting_engine.model.tradeevent;

import jakarta.xml.bind.annotation.XmlAccessorType;

import static jakarta.xml.bind.annotation.XmlAccessType.FIELD;

@XmlAccessorType(FIELD)
public record Variance(
    boolean closingLevel,
    int expectedN,
    VarianceAmount varianceAmount,
    double varianceStrikePrice,
    boolean varianceCap,
    double vegaNotionalAmount
) {
}
