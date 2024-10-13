package com.van.trade_reporting_engine.model.event;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.xml.bind.annotation.XmlAccessType.FIELD;


@Data
@NoArgsConstructor
@XmlAccessorType(FIELD)
public class InstrumentId {
    @XmlAttribute(name = "instrumentIdScheme")
    private String instrumentIdScheme;
    @XmlValue
    private String value;
}
