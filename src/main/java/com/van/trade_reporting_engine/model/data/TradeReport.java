package com.van.trade_reporting_engine.model.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public final class TradeReport {

    @Id
    @GeneratedValue
    private Long id;

    private String buyerParty;

    private String sellerParty;

    private double amount;

    private String currency;

    @Lob
    private String requestConfirmation; // Storing as CLOB to avoid managing too many tables

}