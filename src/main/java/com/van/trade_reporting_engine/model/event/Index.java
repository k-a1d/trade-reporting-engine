package com.van.trade_reporting_engine.model.event;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.xml.bind.annotation.XmlAccessType.FIELD;

@Data
@NoArgsConstructor
@XmlAccessorType(FIELD)
public final class Index {
    private InstrumentId instrumentId;
    private String description;
    @XmlAttribute(name = "exchangeIdScheme")
    private String exchangeIdScheme;
    private String exchangeId;
    private String relatedExchangeId;
}