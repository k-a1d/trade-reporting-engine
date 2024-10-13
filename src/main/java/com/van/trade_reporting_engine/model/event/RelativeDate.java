package com.van.trade_reporting_engine.model.event;

import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.xml.bind.annotation.XmlAccessType.FIELD;

@Data
@NoArgsConstructor
@XmlAccessorType(FIELD)
public final class RelativeDate {
    private int periodMultiplier;
    private String period;
    private String dayType;
    private String businessDayConvention;
    private PartyReference dateRelativeTo;
}