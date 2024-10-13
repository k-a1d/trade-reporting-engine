package com.van.trade_reporting_engine.parser;

public interface Parser<T> {
  public String parse(T element);
}