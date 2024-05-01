package org.memoeslink;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class DateTimeHelper {
    public static final String ISO_8601_DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final String ISO_8601_DATE_PATTERN = "yyyy-MM-dd";
    public static final String ISO_8601_TIME_PATTERN = "HH:mm:ssZ";

    private DateTimeHelper() {
    }

    /**
     * Returns the current date and time in UTC as a string formatted according to the ISO 8601 standard.
     *
     * @return a string representation of the current date and time in UTC
     */
    public static String getCurrentDateTimeStr() {
        return toIso8601DateTimeStr(LocalDateTime.now(ZoneOffset.UTC));
    }

    /**
     * Returns the current date in UTC as a string formatted according to the ISO 8601 standard.
     *
     * @return a string representation of the current date in UTC
     */
    public static String getCurrentDateStr() {
        return toIso8601DateStr(LocalDate.now(ZoneOffset.UTC));
    }

    /**
     * Returns the current time in UTC as a string formatted according to the ISO 8601 standard.
     *
     * @return a string representation of the current time in UTC
     */
    public static String getCurrentTimeStr() {
        return toIso8601TimeStr(LocalTime.now(ZoneOffset.UTC));
    }

    /**
     * Converts a {@link LocalDateTime} object to a string formatted as ISO 8601 date and time.
     *
     * @param dateTime the {@link LocalDateTime} to format
     * @return an ISO 8601 formatted date and time string, or {@code null} if input is {@code null}
     */
    public static String toIso8601DateTimeStr(LocalDateTime dateTime) {
        if (dateTime == null) return null;
        return dateTime.atZone(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern(ISO_8601_DATE_TIME_PATTERN));
    }

    /**
     * Converts a {@link LocalDate} object to a string formatted as ISO 8601 date.
     *
     * @param date the {@link LocalDate} to format
     * @return an ISO 8601 formatted date string, or {@code null} if input is {@code null}
     */
    public static String toIso8601DateStr(LocalDate date) {
        if (date == null) return null;
        return date.format(DateTimeFormatter.ofPattern(ISO_8601_DATE_PATTERN));
    }

    /**
     * Converts a {@link LocalTime} object to a string formatted as ISO 8601 time.
     *
     * @param time the {@link LocalTime} to format
     * @return an ISO 8601 formatted time string, or {@code null} if input is {@code null}
     */
    public static String toIso8601TimeStr(LocalTime time) {
        if (time == null) return null;
        return time.atOffset(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern(ISO_8601_TIME_PATTERN));
    }

    /**
     * Calculates the difference in days between two dates provided as ISO 8601 formatted strings.
     *
     * @param firstDate  the starting date as an ISO 8601 string
     * @param secondDate the ending date as an ISO 8601 string
     * @return the difference in days between the two dates, or 0 if either date is invalid or {@code null}
     */
    public static long getDifferenceInDays(String firstDate, String secondDate) {
        LocalDate initialDate = toLocalDate(firstDate);
        LocalDate finalDate = toLocalDate(secondDate);

        if (initialDate == null || finalDate == null) return 0L;
        return ChronoUnit.DAYS.between(initialDate, finalDate);
    }

    /**
     * Calculates the period between two dates provided as ISO 8601 formatted strings.
     *
     * @param firstDate  the starting date as an ISO 8601 string
     * @param secondDate the ending date as an ISO 8601 string
     * @return a {@link Period} representing the time between the two dates,
     * or {@link Period#ZERO} if either date is invalid or {@code null}
     */
    public static Period getTimeBetween(String firstDate, String secondDate) {
        LocalDate initialDate = toLocalDate(firstDate);
        LocalDate finalDate = toLocalDate(secondDate);

        if (initialDate == null || finalDate == null) return Period.ZERO;
        return Period.between(initialDate, finalDate);
    }

    /**
     * Subtracts a specified number of days from a date provided as an ISO 8601 formatted string.
     *
     * @param strDate the date from which days will be subtracted
     * @param days    the number of days to subtract
     * @return an ISO 8601 formatted date string with the specified days subtracted,
     * or {@code null} if the input date is invalid or {@code null}
     */
    public static String getStrDateMinusDays(String strDate, int days) {
        return manipulateDate(strDate, -days);
    }

    /**
     * Adds a specified number of days to a date provided as an ISO 8601 formatted string.
     *
     * @param strDate the date to which days will be added
     * @param days    the number of days to add
     * @return an ISO 8601 formatted date string with the specified days added,
     * or {@code null} if the input date is invalid or {@code null}
     */
    public static String getStrDatePlusDays(String strDate, int days) {
        return manipulateDate(strDate, days);
    }

    /**
     * Manipulates a date provided as an ISO 8601 formatted string by adding or subtracting a specified number of days.
     *
     * @param strDate the ISO 8601 formatted date string to manipulate
     * @param amount  the number of days to add (positive) or subtract (negative) from the date
     * @return an ISO 8601 formatted date string after adding or subtracting the specified number of days,
     * or {@code null} if the input date is invalid, {@code null}, or if the resulting date cannot be formatted
     */
    private static String manipulateDate(String strDate, int amount) {
        LocalDate date = toLocalDate(strDate);

        if (date == null) return null;
        return date.plusDays(amount).format(DateTimeFormatter.ofPattern(ISO_8601_DATE_PATTERN));
    }

    /**
     * Converts a {@link Calendar} instance to a {@link LocalDateTime} object in UTC.
     *
     * @param calendar the {@link Calendar} to convert
     * @return a {@link LocalDateTime} object representing the same moment in UTC,
     * or {@code null} if input is {@code null}
     */
    public static LocalDateTime toLocalDateTime(Calendar calendar) {
        return calendar != null ? LocalDateTime.ofInstant(calendar.toInstant(), ZoneOffset.UTC) : null;
    }

    /**
     * Parses an ISO 8601 formatted date and time string into a {@link LocalDateTime} object.
     * Returns {@code null} if the string is {@code null}, blank, or cannot be parsed.
     *
     * @param strDateTime the ISO 8601 formatted date and time string to parse
     * @return a {@link LocalDateTime} object representing the specified date and time, or {@code null} if parsing fails
     */
    public static LocalDateTime toLocalDateTime(String strDateTime) {
        if (StringHelper.isNullOrBlank(strDateTime)) return null;

        try {
            return LocalDateTime.parse(strDateTime, DateTimeFormatter.ofPattern(ISO_8601_DATE_TIME_PATTERN));
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    /**
     * Converts a {@link Calendar} instance to a {@link LocalDate} object in UTC.
     *
     * @param calendar the {@link Calendar} to convert
     * @return a {@link LocalDate} object representing the same date in UTC, or {@code null} if input is {@code null}
     */
    public static LocalDate toLocalDate(Calendar calendar) {
        return calendar != null ? LocalDateTime.ofInstant(calendar.toInstant(), ZoneOffset.UTC).toLocalDate() : null;
    }

    /**
     * Parses an ISO 8601 formatted date string into a {@link LocalDate} object.
     * Returns {@code null} if the string is {@code null}, blank, or cannot be parsed.
     *
     * @param strDate the ISO 8601 formatted date string to parse
     * @return a {@link LocalDate} object representing the specified date, or {@code null} if parsing fails
     */
    public static LocalDate toLocalDate(String strDate) {
        if (StringHelper.isNullOrBlank(strDate)) return null;

        try {
            return LocalDate.parse(strDate, DateTimeFormatter.ofPattern(ISO_8601_DATE_PATTERN));
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    /**
     * Converts a {@link Calendar} instance to a {@link LocalTime} object in UTC.
     *
     * @param calendar the {@link Calendar} to convert
     * @return a {@link LocalTime} object representing the same time in UTC, or {@code null} if input is {@code null}
     */
    public static LocalTime toLocalTime(Calendar calendar) {
        return calendar != null ? LocalDateTime.ofInstant(calendar.toInstant(), ZoneOffset.UTC).toLocalTime() : null;
    }

    /**
     * Parses an ISO 8601 formatted time string into a {@link LocalTime} object.
     * Returns {@code null} if the string is {@code null}, blank, or cannot be parsed.
     *
     * @param strTime the ISO 8601 formatted time string to parse
     * @return a {@link LocalTime} object representing the specified time, or {@code null} if parsing fails
     */
    public static LocalTime toLocalTime(String strTime) {
        if (StringHelper.isNullOrBlank(strTime)) return null;

        try {
            return LocalTime.parse(strTime, DateTimeFormatter.ofPattern(ISO_8601_TIME_PATTERN));
        } catch (DateTimeParseException e) {
            return null;
        }
    }
}
