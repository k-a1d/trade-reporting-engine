package com.van.trade_reporting_engine.service;

import com.van.trade_reporting_engine.model.TradeReport;
import com.van.trade_reporting_engine.model.api.TradeReportResponse;
import com.van.trade_reporting_engine.model.event.RequestConfirmation;
import com.van.trade_reporting_engine.parser.XmlFileParser;
import com.van.trade_reporting_engine.repository.TradeReportingRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import static com.van.trade_reporting_engine.util.FileUtil.readFiles;

@Service
@RequiredArgsConstructor
public class TradeReportingService {

    private final static String REPORT_PATH = "xml";

    private final XmlFileParser<RequestConfirmation> fileParser;
    private final TradeReportingRepository repository;

    @PostConstruct
    private void postConstruct() {
        parseTradeReports().
            subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<TradeReportResponse> getTradeReportById(String id) {
        return repository.findById(id)
            .map(this::buildTradeReportResponse);
    }

    @SneakyThrows
    public Flux<TradeReport> parseTradeReports() {
        var resource = getClass().getClassLoader().getResource(REPORT_PATH).toURI();
        var files = readFiles(resource);
        return Flux.just(files)
            .map(fileParser::parse)
            .flatMap(repository::save)
            .doOnError(Exception.class, Throwable::getCause);
    }

    private TradeReportResponse buildTradeReportResponse(TradeReport tradeReport) {
        return TradeReportResponse.builder()
            .build();
    }

}
