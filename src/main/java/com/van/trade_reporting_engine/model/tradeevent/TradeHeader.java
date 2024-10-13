package com.van.trade_reporting_engine.model.tradeevent;

import jakarta.xml.bind.annotation.XmlAccessorType;

import java.time.LocalDate;
import java.util.List;

import static jakarta.xml.bind.annotation.XmlAccessType.FIELD;

@XmlAccessorType(FIELD)
public record TradeHeader(
    List<PartyTradeIdentifier> partyTradeIdentifier,
    LocalDate tradeDate
) {
}
