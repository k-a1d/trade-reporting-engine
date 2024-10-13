package com.van.trade_reporting_engine.model.tradeevent;


import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;

import static jakarta.xml.bind.annotation.XmlAccessType.FIELD;

@XmlAccessorType(FIELD)
public record TradeId(
    @XmlAttribute(name = "tradeIdScheme") String tradeIdScheme,
    @XmlValue String value
) {
}
