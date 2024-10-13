package com.van.trade_reporting_engine.parser;

import com.van.trade_reporting_engine.model.event.RequestConfirmation;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class RequestConfirmationParser extends XmlFileParser<RequestConfirmation> {

    public RequestConfirmationParser() {
        super(RequestConfirmation.class);
    }

    public RequestConfirmation parse(File file) {
        return super
            .parse(file);
    }

}
