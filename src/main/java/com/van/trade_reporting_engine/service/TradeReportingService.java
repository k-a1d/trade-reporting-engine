package com.van.trade_reporting_engine.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.van.trade_reporting_engine.filter.TradeReportFilterChain;
import com.van.trade_reporting_engine.model.api.TradeReportRequest;
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
import java.util.Optional;

import static com.van.trade_reporting_engine.util.FileUtil.readFiles;

@Service
@RequiredArgsConstructor
@Slf4j
public class TradeReportingService {

    private static final String REPORT_DIRECTORY = "xml";

    private final XmlFileParser<RequestConfirmation> fileParser;
    private final TradeReportingRepository repository;
    private final ObjectMapper objectMapper;

    @PostConstruct
    private void postConstruct() {
        // Initialise DB with trade reports
        parseTradeReports();
    }

    public Optional<TradeReportResponse> getFilteredTradeReport(TradeReportRequest request) {
        return repository.findByBuyerPartyAndSellerPartyAndAmountAndCurrency(request.getBuyerParty(),
                request.getSellerParty(), request.getAmount(), request.getCurrency())
            .map(TradeReportFilterChain::filter)
            .map(this::buildTradeReportResponse);
    }

    @SneakyThrows
    private void parseTradeReports() {
        URI resource = getClass().getClassLoader().getResource(REPORT_DIRECTORY).toURI();
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
