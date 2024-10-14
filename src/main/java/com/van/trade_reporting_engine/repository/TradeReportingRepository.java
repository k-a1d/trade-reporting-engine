package com.van.trade_reporting_engine.repository;

import com.van.trade_reporting_engine.model.data.TradeReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TradeReportingRepository extends JpaRepository<TradeReport, String> {

    Optional<TradeReport> findByBuyerPartyAndSellerPartyAndAmountAndCurrency(String buyerParty, String sellerParty, double amount, String currency);

}