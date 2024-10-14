package com.van.trade_reporting_engine.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.van.trade_reporting_engine.model.api.TradeReportRequest;
import com.van.trade_reporting_engine.model.api.TradeReportResponse;
import com.van.trade_reporting_engine.model.data.TradeReport;
import com.van.trade_reporting_engine.model.event.RequestConfirmation;
import com.van.trade_reporting_engine.parser.XmlFileParser;
import com.van.trade_reporting_engine.repository.TradeReportingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TradeReportingServiceTest {

    @Mock
    private XmlFileParser<RequestConfirmation> fileParser;

    @Mock
    private TradeReportingRepository repository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @InjectMocks
    private TradeReportingService tradeReportingService;

    @BeforeEach
    public void setUp() {
        tradeReportingService = new TradeReportingService(fileParser, repository, objectMapper);
    }

    @Test
    public void givenValidRequestReturnsAResponse() throws Exception {
        TradeReportRequest request = TradeReportRequest.builder()
            .buyerParty("a test bank")
            .sellerParty("EMU_BANK")
            .amount(100.0)
            .currency("AUD")
            .build();

        TradeReport tradeReport = TradeReport.builder()
            .buyerParty("a test bank")
            .sellerParty("EMU_BANK")
            .amount(100.0)
            .currency("AUD")
            .requestConfirmation("{\"someField\":\"someValue\"}")
            .build();

        when(repository.findByBuyerPartyAndSellerPartyAndAmountAndCurrency("a test bank", "EMU_BANK", 100.0, "AUD")).thenReturn(Optional.of(tradeReport));

        Optional<TradeReportResponse> response = tradeReportingService.getFilteredTradeReport(request);

        assertTrue(response.isPresent());
        assertEquals(tradeReport.getRequestConfirmation(), response.get().getResponseBody().toString());
        verify(repository, times(1)).findByBuyerPartyAndSellerPartyAndAmountAndCurrency("a test bank", "EMU_BANK", 100.0, "AUD");
    }

    @Test
    public void nonExistentReportShouldReturnEmpty() {
        TradeReportRequest request = TradeReportRequest.builder()
            .buyerParty("a test bank")
            .sellerParty("INVALID")
            .amount(100.0)
            .currency("AUD")
            .build();

        when(repository.findByBuyerPartyAndSellerPartyAndAmountAndCurrency("a test bank", "INVALID", 100.0, "AUD")).thenReturn(Optional.empty());

        Optional<TradeReportResponse> response = tradeReportingService.getFilteredTradeReport(request);

        assertFalse(response.isPresent());
        verify(repository, times(1)).findByBuyerPartyAndSellerPartyAndAmountAndCurrency("a test bank", "INVALID", 100.0, "AUD");
    }

}
