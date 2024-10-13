package com.van.trade_reporting_engine.model.tradeevent;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import static jakarta.xml.bind.annotation.XmlAccessType.FIELD;


@XmlRootElement(name = "requestConfirmation", namespace = "http://www.fpml.org/FpML-5/confirmation")
@XmlAccessorType(FIELD)
public record Request(
    @XmlElement(name = "header") RequestHeader requestHeader,
    boolean isCorrection,
    String correlationId,
    int sequenceNumber,
    Trade trade,
    List<Party> party
) {
}
