package com.van.trade_reporting_engine.filter;

import com.van.trade_reporting_engine.model.data.TradeReport;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public class AnagramFilter implements TradeReportFilter {

    private TradeReportFilter next;
    private final String valueOne;
    private final String valueTwo;

    @Override
    public TradeReport filter(TradeReport report) {
        if (!areAnagrams(valueOne, valueTwo)) {
            return next == null ? report : next.filter(report);
        }
        return null;
    }

    @Override
    public TradeReportFilter setNext(TradeReportFilter next) {
        this.next = next;
        return this;
    }

    private boolean areAnagrams(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}
