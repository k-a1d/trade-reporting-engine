package com.van.trade_reporting_engine.model.event;

import jakarta.xml.bind.annotation.XmlAccessorType;

import static jakarta.xml.bind.annotation.XmlAccessType.FIELD;

@XmlAccessorType(FIELD)
public record VarianceLeg(
    PartyReference payerPartyReference,
    PartyReference receiverPartyReference,
    Underlyer underlyer,
    String settlementType,
    SettlementDate settlementDate,
    String settlementCurrency,
    Valuation valuation,
    Amount amount
) {
}
