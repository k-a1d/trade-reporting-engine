package com.van.trade_reporting_engine.model.event;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;

import static jakarta.xml.bind.annotation.XmlAccessType.FIELD;

@XmlAccessorType(FIELD)
public record Index(
    @XmlAttribute(name = "instrumentIdScheme") String instrumentIdScheme,
    @XmlValue String description,
    @XmlAttribute(name = "exchangeIdScheme") String exchangeIdScheme,
    String exchangeId,
    String relatedExchangeId
) {}
