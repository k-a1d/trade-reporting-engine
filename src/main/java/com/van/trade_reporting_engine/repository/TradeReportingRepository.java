package com.van.trade_reporting_engine.repository;

import com.van.trade_reporting_engine.model.TradeReport;
import com.van.trade_reporting_engine.model.event.RequestConfirmation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.data.relational.core.query.Criteria.where;
import static org.springframework.data.relational.core.query.Query.query;

@Repository
@RequiredArgsConstructor
public class TradeReportingRepository {

    private final R2dbcEntityTemplate template;

    public Flux<TradeReport> save(RequestConfirmation requestConfirmation) {
        return Flux.just(requestConfirmation)
            .map(this::buildTradeReport)
            .flatMap(this::save);
    }

    public Mono<TradeReport> findById(String id) {
        return template.select(TradeReport.class)
            .matching(query(where("id").is(id)))
            .one();
    }

    private Mono<TradeReport> save(TradeReport tradeReport) {
        return template
            .insert(TradeReport.class)
            .using(tradeReport);
    }

    private TradeReport buildTradeReport(RequestConfirmation requestConfirmation) {
        return TradeReport.builder()
            .requestConfirmation(requestConfirmation)
            .build();
    }
}
