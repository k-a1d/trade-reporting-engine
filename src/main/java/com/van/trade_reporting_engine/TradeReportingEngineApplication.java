package com.van.trade_reporting_engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.van.trade_reporting_engine.model")
public class TradeReportingEngineApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeReportingEngineApplication.class, args);
    }

}
