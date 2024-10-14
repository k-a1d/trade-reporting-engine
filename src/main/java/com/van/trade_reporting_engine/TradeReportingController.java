package com.van.trade_reporting_engine;

import com.van.trade_reporting_engine.model.api.TradeReportResponse;
import com.van.trade_reporting_engine.service.TradeReportingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/trade")
@RequiredArgsConstructor
public class TradeReportingController {

    private final TradeReportingService tradeReportingService;

    @GetMapping("/reports")
    public ResponseEntity<TradeReportResponse> getTradeReportById(@RequestParam String id) {
        TradeReportResponse response = tradeReportingService.getTradeReportById(id);
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

//    @GetMapping("/reports")
//    public ResponseEntity<TradeReportResponse> getTradeReport(@RequestParam String buyerParty,
//                                                              @RequestParam String sellerParty,
//                                                              @RequestParam double amount,
//                                                              @RequestParam String currency) {
//        TradeReportResponse response = tradeReportingService.getTradeReportById(id);
//        if (response != null) {
//            return ResponseEntity.ok(response);
//        } else {
//            return ResponseEntity.badRequest().build();
//        }
//    }

}
