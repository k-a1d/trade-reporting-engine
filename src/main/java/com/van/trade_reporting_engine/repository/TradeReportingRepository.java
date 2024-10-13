package com.van.trade_reporting_engine.repository;

import com.van.trade_reporting_engine.model.TradeReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeReportingRepository extends JpaRepository<TradeReport, String> {

}