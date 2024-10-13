package com.van.trade_reporting_engine.model.tradeevent;

import jakarta.xml.bind.annotation.XmlAccessorType;

import java.time.LocalDate;

import static jakarta.xml.bind.annotation.XmlAccessType.FIELD;

@XmlAccessorType(FIELD)
public record MasterConfirmation(
    String masterConfirmationType,
    LocalDate masterConfirmationDate,
    LocalDate masterConfirmationAnnexDate,
    String masterConfirmationAnnexType
) {
}
