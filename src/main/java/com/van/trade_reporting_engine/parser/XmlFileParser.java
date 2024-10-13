package com.van.trade_reporting_engine.parser;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
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

        return resultClass.cast(unmarshaller.unmarshal(file));
    }

}
