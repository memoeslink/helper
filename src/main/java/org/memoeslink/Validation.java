package org.memoeslink;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class Validation {
    private static final String NAME_REGEX = "^\\p{L}+[\\p{L}\\p{Z}\\p{M}\\-.,'ªº]*$";
    private static final Pattern NAME_PATTERN = Pattern.compile(NAME_REGEX);
    private static final String USERNAME_REGEX = "^[\\w\\-.]+$";
    private static final Pattern USERNAME_PATTERN = Pattern.compile(USERNAME_REGEX);
    private static final String EMAIL_REGEX = "^([\\p{L}0-9-_.%+]+){1,64}@[\\p{L}0-9]+([-.][\\p{L}0-9]+)*\\.[a-zA-Z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final String URL_REGEX = "^((https?://)?([a-zA-Z0-9-]+\\.)?[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})*(/[\\w\\-.~:?#@!$&'()*+,;=\\[\\]]*)*|(ftp|ftps|sftp)?://(\\S+(:\\S+)?@)?[\\w-./]+:(\\d+)?(/\\S*)?)$";
    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
    private static final String PHONE_REGEX = "^((\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3}))?[- .]?\\d{3,4}[- .]?\\d{4}$";
    private static final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);
    private static final String IP_ADDRESS_REGEX = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    private static final Pattern IP_ADDRESS_PATTERN = Pattern.compile(IP_ADDRESS_REGEX);
    private static final String IPV6_ADDRESS_REGEX = "^(([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}|(([0-9a-fA-F]{1,4}:){1,7}:)|(([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4})|(([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2})|(([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3})|(([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4})|(([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5})|([0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6}))|(:((:[0-9a-fA-F]{1,4}){1,7}|:))|(::([fF]{4}(:0{1,4})?:)?((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))|(([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)))$";
    private static final Pattern IPV6_ADDRESS_PATTERN = Pattern.compile(IPV6_ADDRESS_REGEX);
    private static final String MAC_ADDRESS_REGEX = "^([0-9a-fA-F]{2}[:\\-]){5}[0-9a-fA-F]{2}$";
    private static final Pattern MAC_ADDRESS_PATTERN = Pattern.compile(MAC_ADDRESS_REGEX);
    private static final String SLUG_REGEX = "^[a-z0-9]+(-[a-z0-9]+)*$";
    private static final Pattern SLUG_PATTERN = Pattern.compile(SLUG_REGEX);
    private static final String HEX_COLOR_REGEX = "^#([0-9a-f]{3}|[0-9a-f]{6}|[0-9a-f]{8})$";
    private static final Pattern HEX_COLOR_PATTERN = Pattern.compile(HEX_COLOR_REGEX);
    private static final String UTF_REGEX = "^U\\+[0-9A-Fa-f]{4,5}$";
    private static final Pattern UTF_PATTERN = Pattern.compile(UTF_REGEX);
    private static final String LOCALE_REGEX = "^[a-zA-Z]{2,4}([_-][a-zA-Z]{4})?([_-]([a-zA-Z]{2}|[0-9]{3}))?$";
    private static final Pattern LOCALE_PATTERN = Pattern.compile(LOCALE_REGEX);
    private static final String UUID_REGEX = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
    private static final Pattern UUID_PATTERN = Pattern.compile(UUID_REGEX);
    private static final String ISBN_10_REGEX = "^\\d{9}[\\dX]$";
    private static final Pattern ISBN_10_PATTERN = Pattern.compile(ISBN_10_REGEX);
    private static final String ISBN_13_REGEX = "^97[89]\\d{10}$";
    private static final Pattern ISBN_13_PATTERN = Pattern.compile(ISBN_13_REGEX);
    private static final String CREDIT_CARD_REGEX = "^\\d{13,19}$";
    private static final Pattern CREDIT_CARD_PATTERN = Pattern.compile(CREDIT_CARD_REGEX);
    private static final String IBAN_REGEX = "^[A-Z]{2}\\d{2}[A-Z0-9]{1,30}$";
    private static final Pattern IBAN_PATTERN = Pattern.compile(IBAN_REGEX);
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z\\d]).+$";
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);
    private static final int PASSWORD_MIN_LENGTH = 8;
    private static final int PASSWORD_MAX_LENGTH = 64;
    private static final String YYYY_MM_DD_DATE_REGEX = "^[0-9]{4,}\\D?[0-9]{2}\\D?[0-9]{2}$";
    private static final Pattern YYYY_MM_DD_DATE_PATTERN = Pattern.compile(YYYY_MM_DD_DATE_REGEX);

    private Validation() {
    }

    /**
     * Verifies if a string is a valid name.
     * Examples: {@code John Doe}, {@code Laureen Kesner-Graver}, {@code José de la Cruz Nuñez}.
     *
     * @param name the string containing the name
     * @return {@code true} if the pattern is met, {@code false} otherwise
     */
    public static boolean isName(String name) {
        if (StringHelper.isNotNullOrBlank(name)) return NAME_PATTERN.matcher(name).matches();
        return false;
    }

    /**
     * Verifies if a string is a valid username.
     * Examples: {@code user2000}, {@code GreenRobot}, {@code doom_master}.
     *
     * @param username the string containing the username
     * @return {@code true} if the pattern is met, {@code false} otherwise
     */
    public static boolean isUsername(String username) {
        if (StringHelper.isNotNullOrBlank(username)) return USERNAME_PATTERN.matcher(username).matches();
        return false;
    }

    /**
     * Verifies if a string is a valid username within a length range.
     * Examples: {@code user2000}, {@code GreenRobot}, {@code doom_master}.
     *
     * @param username  the string containing the username
     * @param minLength the minimum username length
     * @param maxLength the maximum username length
     * @return {@code true} if the pattern is met and the length is within the range, {@code false} otherwise
     */
    public static boolean isUsername(String username, int minLength, int maxLength) {
        if (StringHelper.isNotNullOrBlank(username))
            return USERNAME_PATTERN.matcher(username).matches() && IntegerHelper.isBetween(username.length(), minLength, maxLength);
        return false;
    }

    /**
     * Verifies if a string is a valid email address.
     * Examples: {@code example@mail.com}, {@code test.email@sample-domain.com}.
     *
     * @param email the string containing the email address
     * @return {@code true} if the pattern is met, {@code false} otherwise
     */
    public static boolean isEmailAddress(String email) {
        if (StringHelper.isNotNullOrBlank(email)) return EMAIL_PATTERN.matcher(email).matches();
        return false;
    }

    /**
     * Verifies if a string is a valid URL address.
     * Examples: {@code www.test.com}, {@code https://www.google.com/}.
     *
     * @param url the string containing the URL address
     * @return {@code true} if the pattern is met, {@code false} otherwise
     */
    public static boolean isUrl(String url) {
        if (StringHelper.isNotNullOrBlank(url)) return URL_PATTERN.matcher(url).matches();
        return false;
    }

    /**
     * Verifies if a string is a phone number. It may contain country codes,
     * separators such as {@code -}, {@code .}, or single spaces.
     * Examples: {@code +52 (449) 100 9999}, {@code 33-0000-9999}, {@code 5500001234}.
     *
     * @param phone the string containing the phone number
     * @return {@code true} if the pattern is met, {@code false} otherwise
     */
    public static boolean isPhone(String phone) {
        if (StringHelper.isNullOrBlank(phone)) return false;

        if (!PHONE_PATTERN.matcher(phone).matches()) {
            phone = RegexFilter.removeSpace(phone);
            return PHONE_PATTERN.matcher(phone).matches();
        }
        return true;
    }

    /**
     * Verifies if a string is a valid IPv4 address.
     * Examples: {@code 192.168.0.1}, {@code 10.0.0.255}.
     *
     * @param ipAddress the string containing the IP address
     * @return {@code true} if the pattern is met, {@code false} otherwise
     */
    public static boolean isIpAddress(String ipAddress) {
        if (StringHelper.isNotNullOrBlank(ipAddress)) return IP_ADDRESS_PATTERN.matcher(ipAddress).matches();
        return false;
    }

    /**
     * Verifies if a string is a valid IPv6 address.
     * Examples: {@code 2001:0db8:85a3:0000:0000:8a2e:0370:7334}, {@code ::1}.
     *
     * @param ipAddress the string containing the IPv6 address
     * @return {@code true} if the pattern is met, {@code false} otherwise
     */
    public static boolean isIpv6Address(String ipAddress) {
        if (StringHelper.isNotNullOrBlank(ipAddress)) return IPV6_ADDRESS_PATTERN.matcher(ipAddress).matches();
        return false;
    }

    /**
     * Verifies if a string is a valid MAC address, using either {@code :} or {@code -} as separators.
     * Examples: {@code 00:1A:2B:3C:4D:5E}, {@code 00-1A-2B-3C-4D-5E}.
     *
     * @param macAddress the string containing the MAC address
     * @return {@code true} if the pattern is met, {@code false} otherwise
     */
    public static boolean isMacAddress(String macAddress) {
        if (StringHelper.isNotNullOrBlank(macAddress)) return MAC_ADDRESS_PATTERN.matcher(macAddress).matches();
        return false;
    }

    /**
     * Verifies if a string is a valid URL slug.
     * Examples: {@code my-article-title}, {@code hello-world}, {@code post-123}.
     *
     * @param slug the string containing the slug
     * @return {@code true} if the pattern is met, {@code false} otherwise
     */
    public static boolean isSlug(String slug) {
        if (StringHelper.isNotNullOrBlank(slug)) return SLUG_PATTERN.matcher(slug).matches();
        return false;
    }

    /**
     * Verifies if a string is a hexadecimal color with the format {@code #FFF},
     * {@code #FFFFFF}, {@code #FFFFFFFF}, or using lowercase.
     *
     * @param color the string containing the color
     * @return {@code true} if the pattern is met, {@code false} otherwise
     */
    public static boolean isHexColor(String color) {
        if (StringHelper.isNotNullOrBlank(color)) return HEX_COLOR_PATTERN.matcher(color.toLowerCase()).matches();
        return false;
    }

    /**
     * Verifies if a string is a UTF character.
     *
     * @param utf the string containing the character
     * @return {@code true} if the pattern is met, {@code false} otherwise
     */
    public static boolean isUtf(String utf) {
        if (StringHelper.isNotNullOrBlank(utf)) return UTF_PATTERN.matcher(utf).matches();
        return false;
    }

    /**
     * Verifies if a string has a locale format.
     * Examples: {@code es}, {@code en-US}, {@code pt_BR}.
     *
     * @param locale the string containing the locale
     * @return {@code true} if the pattern is met, {@code false} otherwise
     */
    public static boolean isLocale(String locale) {
        if (StringHelper.isNotNullOrBlank(locale)) return LOCALE_PATTERN.matcher(locale).matches();
        return false;
    }

    /**
     * Verifies if a string is a valid UUID (Universally Unique Identifier).
     * Examples: {@code 550e8400-e29b-41d4-a716-446655440000}, {@code 6ba7b810-9dad-11d1-80b4-00c04fd430c8}.
     *
     * @param uuid the string containing the UUID
     * @return {@code true} if the pattern is met, {@code false} otherwise
     */
    public static boolean isUuid(String uuid) {
        if (StringHelper.isNotNullOrBlank(uuid)) return UUID_PATTERN.matcher(uuid).matches();
        return false;
    }

    /**
     * Verifies if a string is a valid ISBN-10 or ISBN-13.
     * Examples: {@code 0306406152}, {@code 9780306406157}.
     *
     * @param isbn the string containing the ISBN, with no hyphens or spaces
     * @return {@code true} if the checksum and format are valid, {@code false} otherwise
     */
    public static boolean isIsbn(String isbn) {
        return isIsbn10(isbn) || isIsbn13(isbn);
    }

    /**
     * Verifies if a string is a valid ISBN-10.
     * The last character may be {@code X}, which represents value 10.
     *
     * @param isbn the string containing the ISBN-10, with no hyphens or spaces
     * @return {@code true} if the checksum and format are valid, {@code false} otherwise
     */
    public static boolean isIsbn10(String isbn) {
        if (StringHelper.isNullOrBlank(isbn) || !ISBN_10_PATTERN.matcher(isbn).matches()) return false;
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            sum += (isbn.charAt(i) - '0') * (10 - i);
        }
        char last = isbn.charAt(9);
        sum += (last == 'X' || last == 'x') ? 10 : (last - '0');
        return sum % 11 == 0;
    }

    /**
     * Verifies if a string is a valid ISBN-13.
     * The string must start with either {@code 978} or {@code 979}.
     *
     * @param isbn the string containing the ISBN-13, with no hyphens or spaces
     * @return {@code true} if the checksum and format are valid, {@code false} otherwise
     */
    public static boolean isIsbn13(String isbn) {
        if (StringHelper.isNullOrBlank(isbn) || !ISBN_13_PATTERN.matcher(isbn).matches()) return false;
        int sum = 0;

        for (int i = 0; i < 12; i++) {
            sum += (isbn.charAt(i) - '0') * (i % 2 == 0 ? 1 : 3);
        }
        int checkDigit = (10 - (sum % 10)) % 10;
        return checkDigit == (isbn.charAt(12) - '0');
    }

    /**
     * Verifies if a string is a valid credit card number using the Luhn algorithm.
     * The number must contain between 13 and 19 digits, with no spaces or separators.
     *
     * @param creditCard the string containing the credit card number
     * @return {@code true} if the Luhn checksum is valid, {@code false} otherwise
     */
    public static boolean isCreditCard(String creditCard) {
        if (StringHelper.isNullOrBlank(creditCard) || !CREDIT_CARD_PATTERN.matcher(creditCard).matches()) return false;
        int sum = 0;
        boolean alternate = false;

        for (int i = creditCard.length() - 1; i >= 0; i--) {
            int digit = creditCard.charAt(i) - '0';

            if (alternate) {
                digit *= 2;
                if (digit > 9) digit -= 9;
            }
            sum += digit;
            alternate = !alternate;
        }
        return sum % 10 == 0;
    }

    /**
     * Verifies if a string is a valid IBAN (International Bank Account Number).
     * The string must have no spaces or separators.
     * Examples: {@code GB82WEST12345698765432}, {@code DE89370400440532013000}.
     *
     * @param iban the string containing the IBAN
     * @return {@code true} if the format and checksum are valid, {@code false} otherwise
     */
    public static boolean isIban(String iban) {
        if (StringHelper.isNullOrBlank(iban) || !IBAN_PATTERN.matcher(iban).matches()) return false;
        String rearranged = iban.substring(4) + iban.substring(0, 4);
        StringBuilder numericIban = new StringBuilder();

        for (char c : rearranged.toCharArray()) {
            if (Character.isLetter(c)) {
                numericIban.append(c - 'A' + 10);
            } else {
                numericIban.append(c);
            }
        }
        java.math.BigInteger ibanNumber;

        try {
            ibanNumber = new java.math.BigInteger(numericIban.toString());
        } catch (NumberFormatException e) {
            return false;
        }
        return ibanNumber.mod(java.math.BigInteger.valueOf(97)).intValue() == 1;
    }

    /**
     * Verifies if a string is a strong password using the default length range
     * ({@value PASSWORD_MIN_LENGTH}–{@value PASSWORD_MAX_LENGTH} characters).
     * A strong password must contain at least one lowercase letter, one uppercase letter,
     * one digit, and one special character.
     *
     * @param password the string containing the password
     * @return {@code true} if the pattern is met and the length is within the default range, {@code false} otherwise
     */
    public static boolean isPassword(String password) {
        return isPassword(password, PASSWORD_MIN_LENGTH, PASSWORD_MAX_LENGTH);
    }

    /**
     * Verifies if a string is a strong password within a length range.
     * A strong password must contain at least one lowercase letter, one uppercase letter,
     * one digit, and one special character.
     *
     * @param password  the string containing the password
     * @param minLength the minimum password length
     * @param maxLength the maximum password length
     * @return {@code true} if the pattern is met and the length is within the range, {@code false} otherwise
     */
    public static boolean isPassword(String password, int minLength, int maxLength) {
        if (StringHelper.isNotNullOrBlank(password))
            return PASSWORD_PATTERN.matcher(password).matches() && IntegerHelper.isBetween(password.length(), minLength, maxLength);
        return false;
    }

    /**
     * Verifies if a string is a date with the format {@code yyyy-MM-dd} (e.g. {@code 2000-01-31}),
     * {@code yyyy/MM/dd} (e.g. {@code 2000/01/31}), {@code yyyyMMdd} (e.g. {@code 20000131}), or similar.
     *
     * @param strDate the string containing the date
     * @return {@code true} if any pattern is met and the date is valid, {@code false} otherwise
     */
    public static boolean isDate(String strDate) {
        return isYyyyMmDdDate(strDate) || isIsoDate(strDate);
    }

    /**
     * Verifies if a string is a date with the ISO 8601 format,
     * which includes {@code yyyy-MM-dd} (e.g. {@code 2000-01-31}) and {@code yyyyMMdd} (e.g. {@code 20000131}).
     *
     * @param strDate the string containing the date
     * @return {@code true} if pattern is met and the date is valid, {@code false} otherwise
     */
    public static boolean isIsoDate(String strDate) {
        if (StringHelper.isNullOrBlank(strDate)) return false;

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
     * Verifies if a string is a date with the format {@code yyyy-MM-dd} (e.g. {@code 2000-01-31}),
     * {@code yyyy/MM/dd} (e.g. {@code 2000/01/31}), {@code yyyyMMdd} (e.g. {@code 20000131}), or similar, provided
     * that the year is between 1581 and 2500.
     *
     * @param strDate the string containing the date
     * @return {@code true} if pattern is met and the date is valid, {@code false} otherwise
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
