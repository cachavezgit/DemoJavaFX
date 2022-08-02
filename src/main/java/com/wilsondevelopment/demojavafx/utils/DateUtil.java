package com.wilsondevelopment.demojavafx.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DateUtil {
    private static final String FORMATO = "dd.MM.yyyy";

    private static final DateTimeFormatter FORMATEADOR_FECHA =
            DateTimeFormatter.ofPattern((FORMATO));

    public static String format (LocalDate date) {
        if (date == null) {
            return null;
        }
        return FORMATEADOR_FECHA.format(date);
    }

    public static LocalDate parse(String dateString) {
        try  {
            return FORMATEADOR_FECHA.parse(dateString, LocalDate::from);
        } catch(DateTimeParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean validDate(String dateString) {
        return DateUtil.parse(dateString) != null;
    }
}
