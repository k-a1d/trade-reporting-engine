package com.van.trade_reporting_engine.parser;

import java.io.File;

public interface FileParser<T> {

    public T parse(File file);

}
