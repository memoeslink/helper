package org.memoeslink;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.UrlValidator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class Validation {
    public static final String NAME_REGEX = "^\\p{L}+[\\p{L}\\p{Z}\\p{M}\\-.,'ªº]*$";
    public static final Pattern NAME_PATTERN = Pattern.compile(NAME_REGEX);
    public static final String USERNAME_REGEX = "^[\\w\\-.]+$";
    public static final Pattern USERNAME_PATTERN = Pattern.compile(USERNAME_REGEX);
    private static final String PHONE_REGEX = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$";
    private static final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);
    private static final String HEX_COLOR_REGEX = "^#([0-9a-f]{3}|[0-9a-f]{6}|[0-9a-f]{8})$";
    private static final Pattern HEX_COLOR_PATTERN = Pattern.compile(HEX_COLOR_REGEX);
    private static final String UTF_REGEX = "^U\\+[0-9A-Fa-f]{4,5}$";
    private static final Pattern UTF_PATTERN = Pattern.compile(UTF_REGEX);
    private static final String LOCALE_REGEX = "^[a-z]{2}([_-][A-Z]{2})?$";
    private static final Pattern LOCALE_PATTERN = Pattern.compile(LOCALE_REGEX);
    private static final String YYYY_MM_DD_DATE_REGEX = "^[0-9]{4,}\\D?[0-9]{2}\\D?[0-9]{2}$";
    private static final Pattern YYYY_MM_DD_DATE_PATTERN = Pattern.compile(YYYY_MM_DD_DATE_REGEX);

    private Validation() {
    }

    /**
     * Verifies if a string is a valid name.
     * Examples: John Doe, Laureen Kesner-Graver, José de la Cruz Nuñez.
     *
     * @param name the string containing the name
     * @return true if the pattern is met, false otherwise
     */
    public static boolean isName(String name) {
        return NAME_PATTERN.matcher(name).matches();
    }

    /**
     * Verifies if a string is a valid username.
     * Examples: user2000, GreenRobot, doom_master
     *
     * @param username the string containing the username
     * @return true if the pattern is met, false otherwise
     */
    public static boolean isUsername(String username) {
        return USERNAME_PATTERN.matcher(username).matches();
    }

    /**
     * Verifies if a string is a valid username within a length range.
     * Examples: user2000, GreenRobot, doom_master
     *
     * @param username  the string containing the username
     * @param minLength the minimum username length
     * @param maxLength the maximum username length
     * @return true if the pattern is met and the length is within the range, false otherwise
     */
    public static boolean isUsername(String username, int minLength, int maxLength) {
        return NAME_PATTERN.matcher(username).matches() && IntegerHelper.isBetween(username.length(), minLength, maxLength);
    }

    /**
     * Verifies if a string is a valid email address.
     * Examples: example@mail.com, test.email@sample-domain.com.
     *
     * @param email the string containing the email address
     * @return true if the pattern is met, false otherwise
     */
    public static boolean isEmailAddress(String email) {
        return EmailValidator.getInstance().isValid(email);
    }

    /**
     * Verifies if a string is a valid URL address.
     * Examples: www.test.com, https://www.google.com/.
     *
     * @param url the string containing the URL address
     * @return true if the pattern is met, false otherwise
     */
    public static boolean isUrl(String url) {
        return UrlValidator.getInstance().isValid(url);
    }

    /**
     * Verifies if a string is a phone number. It may contain country codes,
     * separators such as '-', '.', or single spaces.
     * Examples: +52 (449) 100 9999, 33-0000-9999, 5500001234.
     *
     * @param phone the string containing the phone number
     * @return true if the pattern is met, false otherwise
     */
    public static boolean isPhone(String phone) {
        if (StringHelper.isNotNullOrBlank(phone)) return PHONE_PATTERN.matcher(phone).matches();
        return false;
    }

    /**
     * Verifies if a string is a hexadecimal color with the format "#FFF",
     * "#FFFFFF", "#FFFFFFFF", or using lowercase.
     *
     * @param color the string containing the color
     * @return true if the pattern is met, false otherwise
     */
    public static boolean isHexColor(String color) {
        if (StringHelper.isNotNullOrBlank(color)) return HEX_COLOR_PATTERN.matcher(color.toLowerCase()).matches();
        return false;
    }

    /**
     * Verifies if a string is a UTF character.
     *
     * @param utf the string containing the character
     * @return true if the pattern is met, false otherwise
     */
    public static boolean isUtf(String utf) {
        if (StringHelper.isNotNullOrBlank(utf)) return UTF_PATTERN.matcher(utf).matches();
        return false;
    }

    /**
     * Verifies if a string has a locale format.
     * Examples: es, en-US, pt_BR
     *
     * @param locale the string containing the locale
     * @return true if the pattern is met, false otherwise
     */
    public static boolean isLocale(String locale) {
        if (StringHelper.isNotNullOrBlank(locale)) return LOCALE_PATTERN.matcher(locale).matches();
        return false;
    }

    /**
     * Verifies if a string is a date with the format "yyyy-MM-dd" (2000-01-31),
     * "yyyy/MM/dd" (2000/01/31), "yyyyMMdd" (20000131), or similar.
     *
     * @param strDate the string containing the date
     * @return true if any pattern is met and the date is valid, false otherwise
     */
    public static boolean isDate(String strDate) {
        return isYyyyMmDdDate(strDate) || isIsoDate(strDate);
    }

    /**
     * Verifies if a string is a date with the ISO 8601 format,
     * which includes "yyyy-MM-dd" (2000-01-31), and "yyyyMMdd" (20000131).
     *
     * @param strDate the string containing the date
     * @return true if pattern is met and the date is valid, false otherwise
     */
    public static boolean isIsoDate(String strDate) {
        try {
            LocalDate.parse(strDate, DateTimeFormatter.ISO_DATE);
            return true;
        } catch (DateTimeParseException ignored) {
        }

        try {
            LocalDate.parse(strDate, DateTimeFormatter.BASIC_ISO_DATE);
            return true;
        } catch (DateTimeParseException ignored) {
        }
        return false;
    }

    /**
     * Verifies if a string is a date with the format "yyyy-MM-dd" (2000-01-31),
     * "yyyy/MM/dd" (2000/01/31), "yyyyMMdd" (20000131), or similar.
     *
     * @param strDate the string containing the date
     * @return true if pattern is met and the date is valid, false otherwise
     */
    public static boolean isYyyyMmDdDate(String strDate) {
        if (StringHelper.isNullOrBlank(strDate) || strDate.length() < "yyyyMMdd".length() || !YYYY_MM_DD_DATE_PATTERN.matcher(strDate).matches())
            return false;
        strDate = strDate.replaceAll("\\D", "");
        long date;

        try {
            date = Long.parseLong(strDate);
        } catch (NumberFormatException e) {
            return false;
        }
        int year = (int) (date / 10000);
        int month = (int) (date % 10000 / 100);
        int day = (int) (date % 100);

        // Leap years calculation not valid before 1581
        boolean yearOk = (year >= 1581) && (year <= 2500);
        boolean monthOk = (month >= 1) && (month <= 12);
        boolean dayOk = (day >= 1) && (day <= daysInMonth(year, month));
        return (yearOk && monthOk && dayOk);
    }

    /**
     * Returns the number of days that a month, from a specific year,
     * has. The leap years are considered.
     *
     * @param year  an integer for the year
     * @param month an integer for the month
     * @return an integer with the number of days; 30 by default
     */
    private static int daysInMonth(int year, int month) {
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                return 31;
            }
            case 2 -> {
                if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) return 29;
                else return 28;
            }
            default -> {
                return 30;
            }
        }
    }
}
