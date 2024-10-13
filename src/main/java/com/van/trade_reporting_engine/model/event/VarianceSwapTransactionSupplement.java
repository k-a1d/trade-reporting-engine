package com.van.trade_reporting_engine.model.event;

import jakarta.xml.bind.annotation.XmlAccessorType;

import static jakarta.xml.bind.annotation.XmlAccessType.FIELD;

@XmlAccessorType(FIELD)
public record VarianceSwapTransactionSupplement(
    VarianceLeg varianceLeg,
    boolean multipleExchangeIndexAnnexFallback
) {
}
