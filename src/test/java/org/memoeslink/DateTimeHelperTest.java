package org.memoeslink;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DateTimeHelperTest {

    @Test
    void getCurrentDateTimeStr() {
        String result = DateTimeHelper.getCurrentDateTimeStr();
        LocalDateTime parsedResult = LocalDateTime.parse(result, DateTimeFormatter.ofPattern(DateTimeHelper.ISO_8601_DATE_TIME_PATTERN));
        assertEquals(LocalDateTime.now(ZoneOffset.UTC).truncatedTo(ChronoUnit.SECONDS), parsedResult.truncatedTo(ChronoUnit.SECONDS));
    }

    @Test
    void getCurrentDateStr() {
        String result = DateTimeHelper.getCurrentDateStr();
        LocalDate parsedResult = LocalDate.parse(result, DateTimeFormatter.ofPattern(DateTimeHelper.ISO_8601_DATE_PATTERN));
        assertEquals(LocalDate.now(ZoneOffset.UTC), parsedResult);
    }

    @Test
    void getCurrentTimeStr() {
        String result = DateTimeHelper.getCurrentTimeStr();
        LocalTime parsedResult = LocalTime.parse(result.substring(0, 8), DateTimeFormatter.ofPattern(DateTimeHelper.ISO_8601_TIME_PATTERN.substring(0, 8)));
        assertEquals(LocalTime.now(ZoneOffset.UTC).truncatedTo(ChronoUnit.SECONDS), parsedResult.truncatedTo(ChronoUnit.SECONDS));
    }

    @Test
    void toIso8601DateTimeStr_returnsNull_whenInputIsNull() {
        assertNull(DateTimeHelper.toIso8601DateTimeStr(null));
    }

    @Test
    void toIso8601DateTimeStr_returnsIso8601FormattedDateTime_whenInputIsValid() {
        LocalDateTime dateTime = LocalDateTime.of(2022, 1, 1, 12, 0);
        String result = DateTimeHelper.toIso8601DateTimeStr(dateTime);
        assertEquals("2022-01-01T12:00:00+0000", result);
    }

    @Test
    void toIso8601DateStr_returnsNull_whenInputIsNull() {
        assertNull(DateTimeHelper.toIso8601DateStr(null));
    }

    @Test
    void toIso8601DateStr_returnsIso8601FormattedDate_whenInputIsValid() {
        LocalDate date = LocalDate.of(2022, 1, 1);
        String result = DateTimeHelper.toIso8601DateStr(date);
        assertEquals("2022-01-01", result);
    }

    @Test
    void toIso8601TimeStr_returnsNull_whenInputIsNull() {
        assertNull(DateTimeHelper.toIso8601TimeStr(null));
    }

    @Test
    void toIso8601TimeStr_returnsIso8601FormattedTime_whenInputIsValid() {
        LocalTime time = LocalTime.of(12, 0);
        String result = DateTimeHelper.toIso8601TimeStr(time);
        assertEquals("12:00:00+0000", result);
    }

    @Test
    void getDifferenceInDays_returnsZero_whenFirstDateIsNull() {
        long result = DateTimeHelper.getDifferenceInDays(null, "2022-01-01");
        assertEquals(0, result);
    }

    @Test
    void getDifferenceInDays_returnsZero_whenSecondDateIsNull() {
        long result = DateTimeHelper.getDifferenceInDays("2022-01-01", null);
        assertEquals(0, result);
    }

    @Test
    void getDifferenceInDays_returnsCorrectDifference_whenDatesAreValid() {
        long result = DateTimeHelper.getDifferenceInDays("2022-01-01", "2022-01-10");
        assertEquals(9, result);
    }

    @Test
    void getTimeBetween_returnsZeroPeriod_whenFirstDateIsNull() {
        Period result = DateTimeHelper.getTimeBetween(null, "2022-01-01");
        assertEquals(Period.ZERO, result);
    }

    @Test
    void getTimeBetween_returnsZeroPeriod_whenSecondDateIsNull() {
        Period result = DateTimeHelper.getTimeBetween("2022-01-01", null);
        assertEquals(Period.ZERO, result);
    }

    @Test
    void getTimeBetween_returnsCorrectPeriod_whenDatesAreValid() {
        Period result = DateTimeHelper.getTimeBetween("2022-01-01", "2022-02-01");
        assertEquals(Period.ofMonths(1), result);
    }

    @Test
    void getStrDateMinusDays_returnsNull_whenDateIsNull() {
        String result = DateTimeHelper.getStrDateMinusDays(null, 1);
        assertNull(result);
    }

    @Test
    void getStrDateMinusDays_returnsCorrectDate_whenDateIsValid() {
        String result = DateTimeHelper.getStrDateMinusDays("2022-01-10", 1);
        assertEquals("2022-01-09", result);
    }

    @Test
    void getStrDatePlusDays_returnsNull_whenDateIsNull() {
        String result = DateTimeHelper.getStrDatePlusDays(null, 1);
        assertNull(result);
    }

    @Test
    void getStrDatePlusDays_returnsCorrectDate_whenDateIsValid() {
        String result = DateTimeHelper.getStrDatePlusDays("2022-01-10", 1);
        assertEquals("2022-01-11", result);
    }

    @Test
    void toLocalDateTime_returnsNull_whenCalendarIsNull() {
        assertNull(DateTimeHelper.toLocalDateTime((Calendar) null));
    }

    @Test
    void toLocalDateTime_returnsCorrectLocalDateTime_whenCalendarIsValid() {
        Calendar calendar = new GregorianCalendar(2022, Calendar.JANUARY, 1, 12, 0);
        LocalDateTime expected = LocalDateTime.of(2022, 1, 1, 18, 0);
        assertEquals(expected, DateTimeHelper.toLocalDateTime(calendar));
    }

    @Test
    void toLocalDateTime_returnsNull_whenStringIsNull() {
        assertNull(DateTimeHelper.toLocalDateTime((String) null));
    }

    @Test
    void toLocalDateTime_returnsNull_whenStringIsBlank() {
        assertNull(DateTimeHelper.toLocalDateTime(" "));
    }

    @Test
    void toLocalDateTime_returnsNull_whenStringIsInvalid() {
        assertNull(DateTimeHelper.toLocalDateTime("invalid"));
    }

    @Test
    void toLocalDateTime_returnsCorrectLocalDateTime_whenStringIsValid() {
        String dateTimeStr = "2022-01-01T12:00:00+0000";
        LocalDateTime expected = LocalDateTime.of(2022, 1, 1, 12, 0);
        assertEquals(expected, DateTimeHelper.toLocalDateTime(dateTimeStr));
    }

    @Test
    void toLocalDate_returnsNull_whenCalendarIsNull() {
        assertNull(DateTimeHelper.toLocalDate((Calendar) null));
    }

    @Test
    void toLocalDate_returnsCorrectLocalDate_whenCalendarIsValid() {
        Calendar calendar = new GregorianCalendar(2022, Calendar.JANUARY, 1);
        LocalDate expected = LocalDate.of(2022, 1, 1);
        assertEquals(expected, DateTimeHelper.toLocalDate(calendar));
    }

    @Test
    void toLocalDate_returnsNull_whenStringIsNull() {
        assertNull(DateTimeHelper.toLocalDate((String) null));
    }

    @Test
    void toLocalDate_returnsNull_whenStringIsBlank() {
        assertNull(DateTimeHelper.toLocalDate(" "));
    }

    @Test
    void toLocalDate_returnsNull_whenStringIsInvalid() {
        assertNull(DateTimeHelper.toLocalDate("invalid"));
    }

    @Test
    void toLocalDate_returnsCorrectLocalDate_whenStringIsValid() {
        String dateStr = "2022-01-01";
        LocalDate expected = LocalDate.of(2022, 1, 1);
        assertEquals(expected, DateTimeHelper.toLocalDate(dateStr));
    }

    @Test
    void toLocalTime_returnsNull_whenCalendarIsNull() {
        assertNull(DateTimeHelper.toLocalTime((Calendar) null));
    }

    @Test
    void toLocalTime_returnsCorrectLocalTime_whenCalendarIsValid() {
        Calendar calendar = new GregorianCalendar(2022, Calendar.JANUARY, 1, 12, 0);
        LocalTime expected = LocalTime.of(18, 0);
        assertEquals(expected, DateTimeHelper.toLocalTime(calendar));
    }

    @Test
    void toLocalTime_returnsNull_whenStringIsNull() {
        assertNull(DateTimeHelper.toLocalTime((String) null));
    }

    @Test
    void toLocalTime_returnsNull_whenStringIsBlank() {
        assertNull(DateTimeHelper.toLocalTime(" "));
    }

    @Test
    void toLocalTime_returnsNull_whenStringIsInvalid() {
        assertNull(DateTimeHelper.toLocalTime("invalid"));
    }

    @Test
    void toLocalTime_returnsCorrectLocalTime_whenStringIsValid() {
        String timeStr = "12:00:00+0000";
        LocalTime expected = LocalTime.of(12, 0);
        assertEquals(expected, DateTimeHelper.toLocalTime(timeStr));
    }
}
