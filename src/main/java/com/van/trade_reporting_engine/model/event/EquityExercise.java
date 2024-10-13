package com.van.trade_reporting_engine.model.event;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public final class EquityExercise {
    private EquityEuropeanExercise equityEuropeanExercise;
    private boolean automaticExercise;
    private EquityValuation equityValuation;
    private String settlementCurrency;
    private String settlementType;
}
