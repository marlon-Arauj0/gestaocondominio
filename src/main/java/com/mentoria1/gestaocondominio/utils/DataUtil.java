package com.mentoria1.gestaocondominio.utils;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataUtil {

    private static final String FORMATO_DATA_PADRAO = "dd/MM/yyyy";

    public static LocalDate stringToLocalDate(String data) {
        if (StringUtils.isBlank(data)) return null;
        var dataFormatter = DateTimeFormatter.ofPattern(FORMATO_DATA_PADRAO);
        return LocalDate.parse(data, dataFormatter);
    }
}
