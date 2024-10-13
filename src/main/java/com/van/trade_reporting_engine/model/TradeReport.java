package com.van.trade_reporting_engine.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
public final class TradeReport {
    @Id
    @GeneratedValue
    private final Long id;
    private final String buyerParty;
    private final String sellerParty;
    private final double amount;
    private final String currency;
    @Lob
    private final String requestConfirmation;
}