package com.van.trade_reporting_engine.parser;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.ValidationEvent;
import jakarta.xml.bind.ValidationEventHandler;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.File;

@RequiredArgsConstructor
public class XmlFileParser<T> implements FileParser<T> {

    private final Class<T> resultClass;

    @SneakyThrows
    public T parse(File file) {
        JAXBContext jc = JAXBContext.newInstance(resultClass);
        Unmarshaller unmarshaller = jc.createUnmarshaller();

        unmarshaller.setEventHandler(
            event -> {
                throw new RuntimeException(event.getMessage(),
                    event.getLinkedException());
            });

        return resultClass.cast(unmarshaller.unmarshal(file));
    }

}
