package com.adreeana.oneteam.infrastructure.persistence;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.join;
import static java.util.Arrays.asList;

@Converter
public class StringListConverter implements AttributeConverter<List<String>, String> {
    private static final String SPLIT_CHAR = ";";

    @Override
    public String convertToDatabaseColumn(List<String> stringList) {
        return stringList.isEmpty() ? null : join(SPLIT_CHAR, stringList);
    }

    @Override
    public List<String> convertToEntityAttribute(String string) {
        return string == null ? new ArrayList<>() : asList(string.split(SPLIT_CHAR));
    }
}