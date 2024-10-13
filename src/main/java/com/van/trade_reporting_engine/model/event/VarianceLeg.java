package com.van.trade_reporting_engine.model.event;

import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.xml.bind.annotation.XmlAccessType.FIELD;

@Data
@NoArgsConstructor
@XmlAccessorType(FIELD)
public final class VarianceLeg {
    private PartyReference payerPartyReference;
    private PartyReference receiverPartyReference;
    private Underlyer underlyer;
    private String settlementType;
    private SettlementDate settlementDate;
    private String settlementCurrency;
    private Valuation valuation;
    private Amount amount;
}