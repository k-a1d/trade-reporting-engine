package com.van.trade_reporting_engine.service;

import ch.qos.logback.core.encoder.JsonEscapeUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.van.trade_reporting_engine.model.api.TradeReportResponse;
import com.van.trade_reporting_engine.model.data.TradeReport;
import com.van.trade_reporting_engine.model.event.RequestConfirmation;
import com.van.trade_reporting_engine.parser.XmlFileParser;
import com.van.trade_reporting_engine.repository.TradeReportingRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URI;

import static com.van.trade_reporting_engine.util.FileUtil.readFiles;

@Service
@RequiredArgsConstructor
@Slf4j
public class TradeReportingService {

    private static final String REPORT_PATH = "xml";

    private final XmlFileParser<RequestConfirmation> fileParser;
    private final TradeReportingRepository repository;
    private final ObjectMapper objectMapper;

    @PostConstruct
    private void postConstruct() {
        // Initialise DB with trade reports
        parseTradeReports();
    }

    public TradeReportResponse getTradeReportById(String id) {
        return repository.findById(id)
            .map(this::buildTradeReportResponse)
            .orElse(null);
    }

    @SneakyThrows
    private void parseTradeReports() {
        URI resource = getClass().getClassLoader().getResource(REPORT_PATH).toURI();
        File[] files = readFiles(resource);

        for (File file : files) {
            RequestConfirmation requestConfirmation = fileParser.parse(file);
            TradeReport tradeReport = buildTradeReport(requestConfirmation);
            repository.save(tradeReport);
        }
        log.info("Reports successfully saved");
    }

    @SneakyThrows
    private TradeReportResponse buildTradeReportResponse(TradeReport tradeReport) {
        return TradeReportResponse.builder()
            .responseBody(objectMapper.readTree(tradeReport.getRequestConfirmation()))
            .build();
    }

    @SneakyThrows
    private TradeReport buildTradeReport(RequestConfirmation requestConfirmation) {
        return TradeReport.builder()
            .buyerParty(requestConfirmation.getBuyerParty())
            .sellerParty(requestConfirmation.getSellerParty())
            .amount(requestConfirmation.getAmount())
            .currency(requestConfirmation.getCurrency())
            .requestConfirmation(objectMapper.writeValueAsString(requestConfirmation))
            .build();
    }
}
