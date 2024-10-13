package com.van.trade_reporting_engine.model.event;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public record EquityExercise(
    EquityEuropeanExercise equityEuropeanExercise,
    boolean automaticExercise,
    EquityValuation equityValuation,
    String settlementCurrency,
    String settlementType
) {
}
