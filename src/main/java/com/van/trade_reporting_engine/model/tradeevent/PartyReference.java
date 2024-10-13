package com.van.trade_reporting_engine.model.tradeevent;


import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

import static jakarta.xml.bind.annotation.XmlAccessType.FIELD;

@XmlAccessorType(FIELD)
public record PartyReference(
        @XmlAttribute(name = "href") String href
) {
}
