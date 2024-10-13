package com.van.trade_reporting_engine;

import com.van.trade_reporting_engine.model.api.TradeReportResponse;
import com.van.trade_reporting_engine.service.TradeReportingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/trade")
@RequiredArgsConstructor
public class TradeReportingController {

    private final TradeReportingService tradeReportingService;

//    @GetMapping("/reports")
//    public Mono<TradeReportResponse> getTradeReport(@RequestParam String buyerParty,
//                                                    @RequestParam String sellerParty,
//                                                    @RequestParam float amount,
//                                                    @RequestParam String currency
//    ) {
//        return tradeReportingService.getTradeReport();
//    }

    @GetMapping("/reports")
    public Mono<ResponseEntity<TradeReportResponse>> getTradeReport(@RequestParam String id) {
        return tradeReportingService.getTradeReportById(id)
            .map(ResponseEntity::ok)
            .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

}
