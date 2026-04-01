package org.memoeslink;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.Calendar;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeHelperTest {

    private static final String ISO_8601_DATE_TIME_REGEX = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\+0000";
    private static final String ISO_8601_DATE_REGEX = "\\d{4}-\\d{2}-\\d{2}";
    private static final String ISO_8601_TIME_REGEX = "\\d{2}:\\d{2}:\\d{2}\\+0000";

    private static Calendar fixedCalendar() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(2024, Calendar.JUNE, 15, 10, 30, 45);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    @Nested
    class GetCurrentDateTimeStr {

        @Test
        void withCurrentTime_returnsIso8601FormattedString() {
            assertTrue(DateTimeHelper.getCurrentDateTimeStr().matches(ISO_8601_DATE_TIME_REGEX));
        }

        @Test
        void withCurrentTime_returnsNonNullString() {
            assertNotNull(DateTimeHelper.getCurrentDateTimeStr());
        }
    }

    @Nested
    class GetCurrentDateStr {

        @Test
        void withCurrentTime_returnsIso8601FormattedString() {
            assertTrue(DateTimeHelper.getCurrentDateStr().matches(ISO_8601_DATE_REGEX));
        }

        @Test
        void withCurrentTime_returnsNonNullString() {
            assertNotNull(DateTimeHelper.getCurrentDateStr());
        }
    }

    @Nested
    class GetCurrentTimeStr {

        @Test
        void withCurrentTime_returnsIso8601FormattedString() {
            assertTrue(DateTimeHelper.getCurrentTimeStr().matches(ISO_8601_TIME_REGEX));
        }

        @Test
        void withCurrentTime_returnsNonNullString() {
            assertNotNull(DateTimeHelper.getCurrentTimeStr());
        }
    }

    @Nested
    class ToIso8601DateTimeStr {

        @Test
        void withNull_returnsNull() {
            assertNull(DateTimeHelper.toIso8601DateTimeStr(null));
        }

        @Test
        void withValidDateTime_returnsFormattedString() {
            LocalDateTime dateTime = LocalDateTime.of(2024, 6, 15, 10, 30, 45);
            assertEquals("2024-06-15T10:30:45+0000", DateTimeHelper.toIso8601DateTimeStr(dateTime));
        }

        @Test
        void withMidnight_returnsFormattedString() {
            LocalDateTime dateTime = LocalDateTime.of(2024, 1, 1, 0, 0, 0);
            assertEquals("2024-01-01T00:00:00+0000", DateTimeHelper.toIso8601DateTimeStr(dateTime));
        }
    }

    @Nested
    class ToIso8601DateStr {

        @Test
        void withNull_returnsNull() {
            assertNull(DateTimeHelper.toIso8601DateStr(null));
        }

        @Test
        void withValidDate_returnsFormattedString() {
            LocalDate date = LocalDate.of(2024, 6, 15);
            assertEquals("2024-06-15", DateTimeHelper.toIso8601DateStr(date));
        }

        @Test
        void withFirstDayOfYear_returnsFormattedString() {
            LocalDate date = LocalDate.of(2024, 1, 1);
            assertEquals("2024-01-01", DateTimeHelper.toIso8601DateStr(date));
        }

        @Test
        void withLastDayOfYear_returnsFormattedString() {
            LocalDate date = LocalDate.of(2024, 12, 31);
            assertEquals("2024-12-31", DateTimeHelper.toIso8601DateStr(date));
        }
    }

    @Nested
    class ToIso8601TimeStr {

        @Test
        void withNull_returnsNull() {
            assertNull(DateTimeHelper.toIso8601TimeStr(null));
        }

        @Test
        void withValidTime_returnsFormattedString() {
            LocalTime time = LocalTime.of(10, 30, 45);
            assertEquals("10:30:45+0000", DateTimeHelper.toIso8601TimeStr(time));
        }

        @Test
        void withMidnight_returnsFormattedString() {
            LocalTime time = LocalTime.of(0, 0, 0);
            assertEquals("00:00:00+0000", DateTimeHelper.toIso8601TimeStr(time));
        }

        @Test
        void withEndOfDay_returnsFormattedString() {
            LocalTime time = LocalTime.of(23, 59, 59);
            assertEquals("23:59:59+0000", DateTimeHelper.toIso8601TimeStr(time));
        }
    }

    @Nested
    class ToLocalDateTimeFromCalendar {

        @Test
        void withNull_returnsNull() {
            assertNull(DateTimeHelper.toLocalDateTime((Calendar) null));
        }

        @Test
        void withFixedCalendar_returnsCorrectLocalDateTime() {
            LocalDateTime result = DateTimeHelper.toLocalDateTime(fixedCalendar());
            assertAll(
                    () -> assertEquals(2024, result.getYear()),
                    () -> assertEquals(6, result.getMonthValue()),
                    () -> assertEquals(15, result.getDayOfMonth()),
                    () -> assertEquals(10, result.getHour()),
                    () -> assertEquals(30, result.getMinute()),
                    () -> assertEquals(45, result.getSecond())
            );
        }
    }

    @Nested
    class ToLocalDateTimeFromString {

        @Test
        void withNull_returnsNull() {
            assertNull(DateTimeHelper.toLocalDateTime((String) null));
        }

        @Test
        void withBlank_returnsNull() {
            assertNull(DateTimeHelper.toLocalDateTime("   "));
        }

        @Test
        void withInvalidFormat_returnsNull() {
            assertNull(DateTimeHelper.toLocalDateTime("not-a-date"));
        }

        @Test
        void withValidString_returnsCorrectLocalDateTime() {
            LocalDateTime result = DateTimeHelper.toLocalDateTime("2024-06-15T10:30:45+0000");
            assertAll(
                    () -> assertEquals(2024, result.getYear()),
                    () -> assertEquals(6, result.getMonthValue()),
                    () -> assertEquals(15, result.getDayOfMonth()),
                    () -> assertEquals(10, result.getHour()),
                    () -> assertEquals(30, result.getMinute()),
                    () -> assertEquals(45, result.getSecond())
            );
        }
    }

    @Nested
    class ToLocalDateFromCalendar {

        @Test
        void withNull_returnsNull() {
            assertNull(DateTimeHelper.toLocalDate((Calendar) null));
        }

        @Test
        void withFixedCalendar_returnsCorrectLocalDate() {
            LocalDate result = DateTimeHelper.toLocalDate(fixedCalendar());
            assertAll(
                    () -> assertEquals(2024, result.getYear()),
                    () -> assertEquals(6, result.getMonthValue()),
                    () -> assertEquals(15, result.getDayOfMonth())
            );
        }
    }

    @Nested
    class ToLocalDateFromString {

        @Test
        void withNull_returnsNull() {
            assertNull(DateTimeHelper.toLocalDate((String) null));
        }

        @Test
        void withBlank_returnsNull() {
            assertNull(DateTimeHelper.toLocalDate("   "));
        }

        @Test
        void withInvalidFormat_returnsNull() {
            assertNull(DateTimeHelper.toLocalDate("not-a-date"));
        }

        @Test
        void withValidString_returnsCorrectLocalDate() {
            LocalDate result = DateTimeHelper.toLocalDate("2024-06-15");
            assertAll(
                    () -> assertEquals(2024, result.getYear()),
                    () -> assertEquals(6, result.getMonthValue()),
                    () -> assertEquals(15, result.getDayOfMonth())
            );
        }
    }

    @Nested
    class ToLocalTimeFromCalendar {

        @Test
        void withNull_returnsNull() {
            assertNull(DateTimeHelper.toLocalTime((Calendar) null));
        }

        @Test
        void withFixedCalendar_returnsCorrectLocalTime() {
            LocalTime result = DateTimeHelper.toLocalTime(fixedCalendar());
            assertAll(
                    () -> assertEquals(10, result.getHour()),
                    () -> assertEquals(30, result.getMinute()),
                    () -> assertEquals(45, result.getSecond())
            );
        }
    }

    @Nested
    class ToLocalTimeFromString {

        @Test
        void withNull_returnsNull() {
            assertNull(DateTimeHelper.toLocalTime((String) null));
        }

        @Test
        void withBlank_returnsNull() {
            assertNull(DateTimeHelper.toLocalTime("   "));
        }

        @Test
        void withInvalidFormat_returnsNull() {
            assertNull(DateTimeHelper.toLocalTime("not-a-time"));
        }

        @Test
        void withValidString_returnsCorrectLocalTime() {
            LocalTime result = DateTimeHelper.toLocalTime("10:30:45+0000");
            assertAll(
                    () -> assertEquals(10, result.getHour()),
                    () -> assertEquals(30, result.getMinute()),
                    () -> assertEquals(45, result.getSecond())
            );
        }
    }

    @Nested
    class GetDifferenceInDays {

        @Test
        void withBothNull_returnsZero() {
            assertEquals(0L, DateTimeHelper.getDifferenceInDays(null, null));
        }

        @Test
        void withFirstNull_returnsZero() {
            assertEquals(0L, DateTimeHelper.getDifferenceInDays(null, "2024-06-15"));
        }

        @Test
        void withSecondNull_returnsZero() {
            assertEquals(0L, DateTimeHelper.getDifferenceInDays("2024-06-15", null));
        }

        @Test
        void withInvalidFirstDate_returnsZero() {
            assertEquals(0L, DateTimeHelper.getDifferenceInDays("not-a-date", "2024-06-15"));
        }

        @Test
        void withSameDates_returnsZero() {
            assertEquals(0L, DateTimeHelper.getDifferenceInDays("2024-06-15", "2024-06-15"));
        }

        @Test
        void withSecondAfterFirst_returnsPositiveDifference() {
            assertEquals(10L, DateTimeHelper.getDifferenceInDays("2024-06-15", "2024-06-25"));
        }

        @Test
        void withSecondBeforeFirst_returnsNegativeDifference() {
            assertEquals(-10L, DateTimeHelper.getDifferenceInDays("2024-06-25", "2024-06-15"));
        }

        @Test
        void withDatesAcrossMonths_returnsCorrectDifference() {
            assertEquals(31L, DateTimeHelper.getDifferenceInDays("2024-01-01", "2024-02-01"));
        }
    }

    @Nested
    class GetTimeBetween {

        @Test
        void withBothNull_returnsPeriodZero() {
            assertEquals(Period.ZERO, DateTimeHelper.getTimeBetween(null, null));
        }

        @Test
        void withFirstNull_returnsPeriodZero() {
            assertEquals(Period.ZERO, DateTimeHelper.getTimeBetween(null, "2024-06-15"));
        }

        @Test
        void withSecondNull_returnsPeriodZero() {
            assertEquals(Period.ZERO, DateTimeHelper.getTimeBetween("2024-06-15", null));
        }

        @Test
        void withInvalidDate_returnsPeriodZero() {
            assertEquals(Period.ZERO, DateTimeHelper.getTimeBetween("not-a-date", "2024-06-15"));
        }

        @Test
        void withSameDates_returnsPeriodZero() {
            assertEquals(Period.ZERO, DateTimeHelper.getTimeBetween("2024-06-15", "2024-06-15"));
        }

        @Test
        void withOneMonthApart_returnsCorrectPeriod() {
            Period result = DateTimeHelper.getTimeBetween("2024-06-15", "2024-07-15");
            assertEquals(Period.ofMonths(1), result);
        }

        @Test
        void withOneYearApart_returnsCorrectPeriod() {
            Period result = DateTimeHelper.getTimeBetween("2023-06-15", "2024-06-15");
            assertEquals(Period.ofYears(1), result);
        }

        @Test
        void withSecondBeforeFirst_returnsNegativePeriod() {
            Period result = DateTimeHelper.getTimeBetween("2024-07-15", "2024-06-15");
            assertEquals(Period.ofMonths(-1), result);
        }
    }

    @Nested
    class GetStrDatePlusDays {

        @Test
        void withNullDate_returnsNull() {
            assertNull(DateTimeHelper.getStrDatePlusDays(null, 5));
        }

        @Test
        void withInvalidDate_returnsNull() {
            assertNull(DateTimeHelper.getStrDatePlusDays("not-a-date", 5));
        }

        @Test
        void withZeroDays_returnsUnchangedDate() {
            assertEquals("2024-06-15", DateTimeHelper.getStrDatePlusDays("2024-06-15", 0));
        }

        @Test
        void withPositiveDays_returnsCorrectDate() {
            assertEquals("2024-06-25", DateTimeHelper.getStrDatePlusDays("2024-06-15", 10));
        }

        @Test
        void withNegativeDays_returnsCorrectDate() {
            assertEquals("2024-06-05", DateTimeHelper.getStrDatePlusDays("2024-06-15", -10));
        }

        @Test
        void withDaysSpanningMonthBoundary_returnsCorrectDate() {
            assertEquals("2024-07-01", DateTimeHelper.getStrDatePlusDays("2024-06-30", 1));
        }

        @Test
        void withDaysSpanningYearBoundary_returnsCorrectDate() {
            assertEquals("2025-01-01", DateTimeHelper.getStrDatePlusDays("2024-12-31", 1));
        }
    }

    @Nested
    class GetStrDateMinusDays {

        @Test
        void withNullDate_returnsNull() {
            assertNull(DateTimeHelper.getStrDateMinusDays(null, 5));
        }

        @Test
        void withInvalidDate_returnsNull() {
            assertNull(DateTimeHelper.getStrDateMinusDays("not-a-date", 5));
        }

        @Test
        void withZeroDays_returnsUnchangedDate() {
            assertEquals("2024-06-15", DateTimeHelper.getStrDateMinusDays("2024-06-15", 0));
        }

        @Test
        void withPositiveDays_returnsCorrectDate() {
            assertEquals("2024-06-05", DateTimeHelper.getStrDateMinusDays("2024-06-15", 10));
        }

        @Test
        void withNegativeDays_returnsCorrectDate() {
            assertEquals("2024-06-25", DateTimeHelper.getStrDateMinusDays("2024-06-15", -10));
        }

        @Test
        void withDaysSpanningMonthBoundary_returnsCorrectDate() {
            assertEquals("2024-05-31", DateTimeHelper.getStrDateMinusDays("2024-06-01", 1));
        }

        @Test
        void withDaysSpanningYearBoundary_returnsCorrectDate() {
            assertEquals("2023-12-31", DateTimeHelper.getStrDateMinusDays("2024-01-01", 1));
        }
    }
}
