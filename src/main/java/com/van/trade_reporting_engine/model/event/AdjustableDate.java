package com.van.trade_reporting_engine.model.event;

import jakarta.xml.bind.annotation.XmlAccessorType;

import java.time.LocalDate;

import static jakarta.xml.bind.annotation.XmlAccessType.FIELD;

@XmlAccessorType(FIELD)
public record AdjustableDate(
    LocalDate unadjustedDate,
    DateAdjustments dateAdjustments
) {
}
