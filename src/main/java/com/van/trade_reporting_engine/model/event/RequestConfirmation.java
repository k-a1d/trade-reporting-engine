package com.van.trade_reporting_engine.model.event;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.xml.bind.annotation.XmlAccessType.FIELD;


@XmlRootElement(name = "requestConfirmation")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@XmlAccessorType(FIELD)
public final class RequestConfirmation {

    @XmlElement(name = "header")
    private RequestHeader requestHeader;
    private boolean isCorrection;
    private String correlationId;
    private int sequenceNumber;
    private Trade trade;
    private Party[] party;

    public String getBuyerParty() {
        return trade.getVarianceOptionTransactionSupplement().getBuyerPartyReference().getHref();
    }

    public String getSellerParty() {
        return trade.getVarianceOptionTransactionSupplement().getSellerPartyReference().getHref();
    }

    public double getAmount() {
        return trade.getVarianceOptionTransactionSupplement().getEquityPremium().getPaymentAmount().getAmount();
    }

    public String getCurrency() {
        return trade.getVarianceOptionTransactionSupplement().getEquityPremium().getPaymentAmount().getCurrency();
    }

}
