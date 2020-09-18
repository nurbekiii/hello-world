package com.test.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author NIsaev on 08.07.2020
 */
public class Test55 {
    private static final Logger LOGGER = LoggerFactory.getLogger(Test55.class);

    private final static String DATE_FORMAT_SHORT = "dd.MM.yyyy";
    private final static String DATE_FORMAT_SHORT_EX = "yyyy-MM-dd";

    public static void main(String[] args) {
        Test55 t = new Test55();
        System.out.println(t.convertToDate("15.05.2020"));
        System.out.println(t.convertToDateEx("2020-06-19"));
        System.out.println(t.convertToDateEx("2020-06-0"));
        System.out.println(t.convertToDate("2020-06-0"));
    }

    private Date convertToDate(String dateStr) {
        if (dateStr == null || dateStr.isEmpty())
            return null;

        try {
            LocalDate dt = LocalDate.parse(dateStr.substring(0, 10), DateTimeFormatter.ofPattern(DATE_FORMAT_SHORT));
            return Date.from(dt.atStartOfDay(ZoneId.systemDefault()).toInstant());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    private Date convertToDateEx(String dateStr) {
        if (dateStr == null || dateStr.isEmpty())
            return null;

        try {
            LocalDate dt = LocalDate.parse(dateStr.substring(0, 10), DateTimeFormatter.ofPattern(DATE_FORMAT_SHORT_EX));
            return Date.from(dt.atStartOfDay(ZoneId.systemDefault()).toInstant());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }
}
