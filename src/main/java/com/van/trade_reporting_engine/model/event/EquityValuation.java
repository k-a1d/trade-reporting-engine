package com.van.trade_reporting_engine.model.event;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.xml.bind.annotation.XmlAccessType.FIELD;

@Data
@NoArgsConstructor
@XmlAccessorType(FIELD)
public final class EquityValuation {
    @XmlAttribute(name = "id")
    private String id;
    private boolean futuresPriceValuation;
}