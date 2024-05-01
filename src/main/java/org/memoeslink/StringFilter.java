package org.memoeslink;

import java.util.function.Predicate;

public class StringFilter {

    private StringFilter() {
    }

    /**
     * Processes each character of the string according to the given predicate,
     * retaining only those that match.
     *
     * @param s         the original string
     * @param predicate a predicate to test each character
     * @return the processed string
     */
    private static String filter(String s, Predicate<Character> predicate) {
        if (StringHelper.isNullOrEmpty(s)) return s;
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (predicate.test(c)) sb.append(c);
        }
        return sb.toString();
    }

    /**
     * Returns a string containing only the whitespace characters from the input string.
     *
     * @param s the string to filter
     * @return string with only whitespace characters
     */
    public static String keepWhitespaces(String s) {
        return filter(s, CharHelper::isWhitespace);
    }

    /**
     * Returns a string containing only the zero-width characters from the input string.
     * <p>
     * This method preserves several specific zero-width characters, including:
     * <ul>
     *     <li>Zero Width Space (U+200B)</li>
     *     <li>Zero Width Non-Joiner (U+200C)</li>
     *     <li>Zero Width Joiner (U+200D)</li>
     *     <li>Word Joiner (U+2060)</li>
     *     <li>Zero Width No-Break Space (U+FEFF), also known as Byte Order Mark (BOM)</li>
     * </ul>
     *
     * @param s the string to filter
     * @return string with only zero-width characters
     */
    public static String keepZeroWidthSpaces(String s) {
        return filter(s, CharHelper::isZeroWidthChar);
    }

    /**
     * Returns a string containing only the letter characters from the input string.
     *
     * @param s the string to filter
     * @return string with only letters
     */
    public static String keepLetters(String s) {
        return filter(s, CharHelper::isLetter);
    }

    /**
     * Returns a string containing only the lowercase letter characters from the input string.
     *
     * @param s the string to filter
     * @return string with only lowercase letters
     */
    public static String keepLowercase(String s) {
        return filter(s, CharHelper::isLowercase);
    }

    /**
     * Returns a string containing only the uppercase letter characters from the input string.
     *
     * @param s the string to filter
     * @return string with only uppercase letters
     */
    public static String keepUppercase(String s) {
        return filter(s, CharHelper::isUppercase);
    }

    /**
     * Returns a string containing only the digit characters from the input string.
     *
     * @param s the string to filter
     * @return string with only digits
     */
    public static String keepDigits(String s) {
        return filter(s, CharHelper::isDigit);
    }

    /**
     * Returns a string containing only the letter or whitespace characters from the input string.
     *
     * @param s the string to filter
     * @return string with only letters or whitespaces
     */
    public static String keepLettersOrWhitespaces(String s) {
        return filter(s, CharHelper::isLetterOrWhitespace);
    }

    /**
     * Returns a string containing only the letter or digit characters from the input string.
     *
     * @param s the string to filter
     * @return string with only letters or digits
     */
    public static String keepLettersOrDigits(String s) {
        return filter(s, CharHelper::isLetterOrDigit);
    }

    /**
     * Returns a string containing only the letter, digit, or whitespace characters from the input string.
     *
     * @param s the string to filter
     * @return string with only letters, digits, or whitespaces
     */
    public static String keepLettersDigitsOrWhitespaces(String s) {
        return filter(s, CharHelper::isLetterDigitOrWhitespace);
    }

    /**
     * Returns a string containing only the alphabetic characters from the input string.
     *
     * @param s the string to filter
     * @return string with only alphabetic characters
     */
    public static String keepAlphabetic(String s) {
        return filter(s, CharHelper::isAlphabetic);
    }

    /**
     * Returns a string containing only the alphabetic or whitespace characters from the input string.
     *
     * @param s the string to filter
     * @return string with only alphabetic characters or whitespaces
     */
    public static String keepAlphabeticOrWhitespaces(String s) {
        return filter(s, CharHelper::isAlphabeticOrWhitespace);
    }

    /**
     * Returns a string containing only the alphabetic or digit characters from the input string.
     *
     * @param s the string to filter
     * @return string with only alphabetic characters or digits
     */
    public static String keepAlphabeticOrDigits(String s) {
        return filter(s, CharHelper::isAlphabeticOrDigit);
    }

    /**
     * Returns a string containing only the alphanumeric or whitespace characters from the input string.
     *
     * @param s the string to filter
     * @return string with only alphanumeric characters or whitespaces
     */
    public static String keepAlphanumericOrWhitespaces(String s) {
        return filter(s, CharHelper::isAlphanumericOrWhitespace);
    }

    /**
     * Returns a string containing only the special characters from the input string.
     *
     * @param s the string to filter
     * @return string with only special characters
     */
    public static String keepSpecialChars(String s) {
        return filter(s, CharHelper::isSpecialChar);
    }

    /**
     * Returns a string containing only the ASCII characters from the input string.
     *
     * @param s the string to filter
     * @return string with only ASCII characters
     */
    public static String keepAscii(String s) {
        return filter(s, CharHelper::isAscii);
    }

    /**
     * Returns a string containing only the ASCII spaces (\u0020) from the input string.
     *
     * @param s the string to filter
     * @return string with only ASCII spaces
     */
    public static String keepAsciiSpaces(String s) {
        return filter(s, CharHelper::isAsciiSpace);
    }

    /**
     * Returns a string containing only the ASCII whitespaces from the input string.
     *
     * @param s the string to filter
     * @return string with only ASCII whitespaces
     */
    public static String keepAsciiWhitespaces(String s) {
        return filter(s, CharHelper::isAsciiWhitespace);
    }

    /**
     * Returns a string containing only the ASCII alphabetic characters (a-z, A-Z) from the input string.
     *
     * @param s the string to filter
     * @return string with only ASCII alphabetic characters
     */
    public static String keepAsciiAlpha(String s) {
        return filter(s, CharHelper::isAsciiAlpha);
    }

    /**
     * Returns a string containing only the ASCII lowercase alphabetic characters (a-z) from the input string.
     *
     * @param s the string to filter
     * @return string with only ASCII lowercase alphabetic characters
     */
    public static String keepAsciiAlphaLower(String s) {
        return filter(s, CharHelper::isAsciiAlphaLower);
    }

    /**
     * Returns a string containing only the ASCII uppercase alphabetic characters (A-Z) from the input string.
     *
     * @param s the string to filter
     * @return string with only ASCII uppercase alphabetic characters
     */
    public static String keepAsciiAlphaUpper(String s) {
        return filter(s, CharHelper::isAsciiAlphaUpper);
    }

    /**
     * Returns a string containing only the ASCII numeric characters (0-9) from the input string.
     *
     * @param s the string to filter
     * @return string with only ASCII numeric characters
     */
    public static String keepAsciiNumeric(String s) {
        return filter(s, CharHelper::isAsciiNumeric);
    }

    /**
     * Returns a string containing only the ASCII alphabetic characters (a-z, A-Z)
     * or spaces (\u0020) from the input string.
     *
     * @param s the string to filter
     * @return string with only ASCII alphabetic characters or spaces
     */
    public static String keepAsciiAlphaOrSpaces(String s) {
        return filter(s, CharHelper::isAsciiAlphaOrSpace);
    }

    /**
     * Returns a string containing only the ASCII alphabetic characters (a-z, A-Z)
     * or whitespace characters from the input string.
     *
     * @param s the string to filter
     * @return string with only ASCII alphabetic characters or whitespace characters
     */
    public static String keepAsciiAlphaOrWhitespaces(String s) {
        return filter(s, CharHelper::isAsciiAlphaOrWhitespace);
    }

    /**
     * Returns a string containing only the ASCII alphanumeric characters (a-z, A-Z, 0-9) from the input string.
     *
     * @param s the string to filter
     * @return string with only ASCII alphanumeric characters
     */
    public static String keepAsciiAlphanumeric(String s) {
        return filter(s, CharHelper::isAsciiAlphanumeric);
    }

    /**
     * Returns a string containing only the ASCII alphanumeric characters (a-z, A-Z, 0-9)
     * or spaces (\u0020) from the input string.
     *
     * @param s the string to filter
     * @return string with only ASCII alphanumeric characters or spaces
     */
    public static String keepAsciiAlphanumericOrSpaces(String s) {
        return filter(s, CharHelper::isAsciiAlphanumericOrSpace);
    }

    /**
     * Returns a string containing only the ASCII alphanumeric characters (a-z, A-Z, 0-9)
     * or whitespace characters from the input string.
     *
     * @param s the string to filter
     * @return string with only ASCII alphanumeric characters or whitespace characters
     */
    public static String keepAsciiAlphanumericOrWhitespaces(String s) {
        return filter(s, CharHelper::isAsciiAlphanumericOrWhitespace);
    }

    /**
     * Returns a string with all whitespace characters removed.
     *
     * @param s the string to filter
     * @return string without whitespace characters
     */
    public static String removeWhitespaces(String s) {
        return filter(s, c -> !CharHelper.isWhitespace(c));
    }

    /**
     * Returns a string with all zero-width characters removed.
     * <p>
     * This method targets the removal of several specific zero-width characters, including:
     * <ul>
     *     <li>Zero Width Space (U+200B)</li>
     *     <li>Zero Width Non-Joiner (U+200C)</li>
     *     <li>Zero Width Joiner (U+200D)</li>
     *     <li>Word Joiner (U+2060)</li>
     *     <li>Zero Width No-Break Space (U+FEFF), also known as Byte Order Mark (BOM)</li>
     * </ul>
     * These characters are often used for text formatting in HTML and other document standards but
     * can be invisible in plain text, leading to potential issues in processing or displaying text.
     *
     * @param s the string to filter
     * @return string without zero-width characters
     */
    public static String removeZeroWidthSpaces(String s) {
        return filter(s, c -> !CharHelper.isZeroWidthChar(c));
    }

    /**
     * Returns a string with all letter characters removed.
     *
     * @param s the string to filter
     * @return string without letter characters
     */
    public static String removeLetters(String s) {
        return filter(s, c -> !CharHelper.isLetter(c));
    }

    /**
     * Returns a string with all lowercase letter characters removed.
     *
     * @param s the string to filter
     * @return string without lowercase letters
     */
    public static String removeLowercase(String s) {
        return filter(s, c -> !CharHelper.isLowercase(c));
    }

    /**
     * Returns a string with all uppercase letter characters removed.
     *
     * @param s the string to filter
     * @return string without uppercase letters
     */
    public static String removeUppercase(String s) {
        return filter(s, c -> !CharHelper.isUppercase(c));
    }

    /**
     * Returns a string with all digit characters removed.
     *
     * @param s the string to filter
     * @return string without digit characters
     */
    public static String removeDigits(String s) {
        return filter(s, c -> !CharHelper.isDigit(c));
    }

    /**
     * Returns a string with all letters or whitespace characters removed.
     *
     * @param s the string to filter
     * @return string without letters or whitespaces
     */
    public static String removeLettersOrWhitespaces(String s) {
        return filter(s, c -> !CharHelper.isLetterOrWhitespace(c));
    }

    /**
     * Returns a string with all letters or digits removed.
     *
     * @param s the string to filter
     * @return string without letters or digits
     */
    public static String removeLettersOrDigits(String s) {
        return filter(s, c -> !CharHelper.isLetterOrDigit(c));
    }

    /**
     * Returns a string with all letters, digits, or whitespace characters removed.
     *
     * @param s the string to filter
     * @return string without letters, digits, or whitespaces
     */
    public static String removeLettersDigitsOrWhitespaces(String s) {
        return filter(s, c -> !CharHelper.isLetterDigitOrWhitespace(c));
    }

    /**
     * Returns a string with all alphabetic characters removed.
     *
     * @param s the string to filter
     * @return string without alphabetic characters
     */
    public static String removeAlphabetic(String s) {
        return filter(s, c -> !CharHelper.isAlphabetic(c));
    }

    /**
     * Returns a string with all alphabetic or whitespace characters removed.
     *
     * @param s the string to filter
     * @return string without alphabetic characters or whitespaces
     */
    public static String removeAlphabeticOrWhitespaces(String s) {
        return filter(s, c -> !CharHelper.isAlphabeticOrWhitespace(c));
    }

    /**
     * Returns a string with all alphabetic or digit characters removed.
     *
     * @param s the string to filter
     * @return string without alphabetic characters or digits
     */
    public static String removeAlphabeticOrDigits(String s) {
        return filter(s, c -> !CharHelper.isAlphabeticOrDigit(c));
    }

    /**
     * Returns a string with all alphanumeric or whitespace characters removed.
     *
     * @param s the string to filter
     * @return string without alphanumeric characters or whitespaces
     */
    public static String removeAlphanumericOrWhitespaces(String s) {
        return filter(s, c -> !CharHelper.isAlphanumericOrWhitespace(c));
    }

    /**
     * Returns a string with all special characters removed.
     *
     * @param s the string to filter
     * @return string without special characters
     */
    public static String removeSpecialChars(String s) {
        return filter(s, c -> !CharHelper.isSpecialChar(c));
    }

    /**
     * Returns a string with all ASCII characters removed.
     *
     * @param s the string to filter
     * @return string without ASCII characters
     */
    public static String removeAscii(String s) {
        return filter(s, c -> !CharHelper.isAscii(c));
    }

    /**
     * Returns a string with all ASCII spaces (\u0020) removed.
     *
     * @param s the string to filter
     * @return string without ASCII spaces
     */
    public static String removeAsciiSpaces(String s) {
        return filter(s, c -> !CharHelper.isAsciiSpace(c));
    }

    /**
     * Returns a string with all ASCII whitespaces removed.
     *
     * @param s the string to filter
     * @return string without ASCII whitespaces
     */
    public static String removeAsciiWhitespaces(String s) {
        return filter(s, c -> !CharHelper.isAsciiWhitespace(c));
    }

    /**
     * Returns a string with all ASCII alphabetic characters (a-z, A-Z) removed.
     *
     * @param s the string to filter
     * @return string without ASCII alphabetic characters
     */
    public static String removeAsciiAlpha(String s) {
        return filter(s, c -> !CharHelper.isAsciiAlpha(c));
    }

    /**
     * Returns a string with all ASCII lowercase alphabetic characters (a-z) removed.
     *
     * @param s the string to filter
     * @return string without ASCII lowercase alphabetic characters
     */
    public static String removeAsciiAlphaLower(String s) {
        return filter(s, c -> !CharHelper.isAsciiAlphaLower(c));
    }

    /**
     * Returns a string with all ASCII uppercase alphabetic characters (A-Z) removed.
     *
     * @param s the string to filter
     * @return string without ASCII uppercase alphabetic characters
     */
    public static String removeAsciiAlphaUpper(String s) {
        return filter(s, c -> !CharHelper.isAsciiAlphaUpper(c));
    }

    /**
     * Returns a string with all ASCII numeric characters (0-9) removed.
     *
     * @param s the string to filter
     * @return string without ASCII numeric characters
     */
    public static String removeAsciiNumeric(String s) {
        return filter(s, c -> !CharHelper.isAsciiNumeric(c));
    }

    /**
     * Returns a string with all ASCII alphabetic characters (a-z, A-Z) or spaces (\u0020) removed.
     *
     * @param s the string to filter
     * @return string without ASCII alphabetic characters or spaces
     */
    public static String removeAsciiAlphaOrSpaces(String s) {
        return filter(s, c -> !CharHelper.isAsciiAlphaOrSpace(c));
    }

    /**
     * Returns a string with all ASCII alphabetic characters (a-z, A-Z) or whitespace characters removed.
     *
     * @param s the string to filter
     * @return string without ASCII alphabetic characters or whitespace characters
     */
    public static String removeAsciiAlphaOrWhitespaces(String s) {
        return filter(s, c -> !CharHelper.isAsciiAlphaOrWhitespace(c));
    }

    /**
     * Returns a string with all ASCII alphanumeric characters (a-z, A-Z, 0-9) removed.
     *
     * @param s the string to filter
     * @return string without ASCII alphanumeric characters
     */
    public static String removeAsciiAlphanumeric(String s) {
        return filter(s, c -> !CharHelper.isAsciiAlphanumeric(c));
    }

    /**
     * Returns a string with all ASCII alphanumeric characters (a-z, A-Z, 0-9) or spaces (\u0020) removed.
     *
     * @param s the string to filter
     * @return string without ASCII alphanumeric characters or spaces
     */
    public static String removeAsciiAlphanumericOrSpaces(String s) {
        return filter(s, c -> !CharHelper.isAsciiAlphanumericOrSpace(c));
    }

    /**
     * Returns a string with all ASCII alphanumeric characters (a-z, A-Z, 0-9) or whitespace characters removed.
     *
     * @param s the string to filter
     * @return string without ASCII alphanumeric characters or whitespace characters
     */
    public static String removeAsciiAlphanumericOrWhitespaces(String s) {
        return filter(s, c -> !CharHelper.isAsciiAlphanumericOrWhitespace(c));
    }

    /**
     * Counts characters in a string that match a given condition.
     *
     * @param s         the string to analyze
     * @param predicate a condition to test each character
     * @return count of characters matching the predicate
     */
    private static int count(String s, Predicate<Character> predicate) {
        return filter(s, predicate).length();
    }

    /**
     * Counts the number of whitespace characters in the string.
     *
     * @param s the string to analyze
     * @return the count of whitespace characters
     */
    public static int countWhitespaces(String s) {
        return count(s, CharHelper::isWhitespace);
    }

    /**
     * Counts the number of zero-width characters in the string.
     * <p>
     * This method counts several specific zero-width characters, including:
     * <ul>
     *     <li>Zero Width Space (U+200B)</li>
     *     <li>Zero Width Non-Joiner (U+200C)</li>
     *     <li>Zero Width Joiner (U+200D)</li>
     *     <li>Word Joiner (U+2060)</li>
     *     <li>Zero Width No-Break Space (U+FEFF), also known as Byte Order Mark (BOM)</li>
     * </ul>
     *
     * @param s the string to analyze
     * @return the count of zero-width characters
     */
    public static int countZeroWidthChars(String s) {
        return count(s, CharHelper::isZeroWidthChar);
    }

    /**
     * Counts the number of letter characters in the string.
     *
     * @param s the string to analyze
     * @return the count of letter characters
     */
    public static int countLetters(String s) {
        return count(s, CharHelper::isLetter);
    }

    /**
     * Counts the number of lowercase letter characters in the string.
     *
     * @param s the string to analyze
     * @return the count of lowercase letters
     */
    public static int countLowercase(String s) {
        return count(s, CharHelper::isLowercase);
    }

    /**
     * Counts the number of uppercase letter characters in the string.
     *
     * @param s the string to analyze
     * @return the count of uppercase letters
     */
    public static int countUppercase(String s) {
        return count(s, CharHelper::isUppercase);
    }

    /**
     * Counts the number of digit characters in the string.
     *
     * @param s the string to analyze
     * @return the count of digit characters
     */
    public static int countDigits(String s) {
        return count(s, CharHelper::isDigit);
    }

    /**
     * Counts the number of letters or whitespace characters in the string.
     *
     * @param s the string to analyze
     * @return the count of letters or whitespaces
     */
    public static int countLettersOrWhitespaces(String s) {
        return count(s, CharHelper::isLetterOrWhitespace);
    }

    /**
     * Counts the number of letters or digits in the string.
     *
     * @param s the string to analyze
     * @return the count of letters or digits
     */
    public static int countLettersOrDigits(String s) {
        return count(s, CharHelper::isLetterOrDigit);
    }

    /**
     * Counts the number of letters, digits, or whitespace characters in the string.
     *
     * @param s the string to analyze
     * @return the count of letters, digits, or whitespaces
     */
    public static int countLettersDigitsOrWhitespaces(String s) {
        return count(s, CharHelper::isLetterDigitOrWhitespace);
    }

    /**
     * Counts the number of alphabetic characters in the string.
     *
     * @param s the string to analyze
     * @return the count of alphabetic characters
     */
    public static int countAlphabetic(String s) {
        return count(s, CharHelper::isAlphabetic);
    }

    /**
     * Counts the number of alphabetic or whitespace characters in the string.
     *
     * @param s the string to analyze
     * @return the count of alphabetic characters or whitespaces
     */
    public static int countAlphabeticOrWhitespaces(String s) {
        return count(s, c -> CharHelper.isAlphabetic(c) || CharHelper.isWhitespace(c));
    }

    /**
     * Counts the number of alphabetic or digit characters in the string.
     *
     * @param s the string to analyze
     * @return the count of alphabetic characters or digits
     */
    public static int countAlphabeticOrDigits(String s) {
        return count(s, c -> CharHelper.isAlphabetic(c) || CharHelper.isDigit(c));
    }

    /**
     * Counts the number of alphanumeric or whitespace characters in the string.
     *
     * @param s the string to analyze
     * @return the count of alphanumeric characters or whitespaces
     */
    public static int countAlphanumericOrWhitespaces(String s) {
        return count(s, CharHelper::isAlphanumericOrWhitespace);
    }

    /**
     * Counts the number of special characters in the string.
     *
     * @param s the string to analyze
     * @return the count of special characters
     */
    public static int countSpecialChars(String s) {
        return count(s, CharHelper::isSpecialChar);
    }

    /**
     * Counts the number of ASCII characters in the string.
     *
     * @param s the string to analyze
     * @return the count of ASCII characters
     */
    public static int countAscii(String s) {
        return count(s, CharHelper::isAscii);
    }

    /**
     * Counts the number of ASCII spaces (\u0020) in the string.
     *
     * @param s the string to analyze
     * @return the count of ASCII spaces
     */
    public static int countAsciiSpace(String s) {
        return count(s, CharHelper::isAsciiSpace);
    }

    /**
     * Counts the number of ASCII whitespaces in the string.
     *
     * @param s the string to analyze
     * @return the count of ASCII whitespaces
     */
    public static int countAsciiWhitespace(String s) {
        return count(s, CharHelper::isAsciiWhitespace);
    }

    /**
     * Counts the number of ASCII alphabetic characters (a-z, A-Z) in the string.
     *
     * @param s the string to analyze
     * @return the count of ASCII alphabetic characters
     */
    public static int countAsciiAlpha(String s) {
        return count(s, CharHelper::isAsciiAlpha);
    }

    /**
     * Counts the number of ASCII lowercase alphabetic characters (a-z) in the string.
     *
     * @param s the string to analyze
     * @return the count of ASCII lowercase alphabetic characters
     */
    public static int countAsciiAlphaLower(String s) {
        return count(s, CharHelper::isAsciiAlphaLower);
    }

    /**
     * Counts the number of ASCII uppercase alphabetic characters (A-Z) in the string.
     *
     * @param s the string to analyze
     * @return the count of ASCII uppercase alphabetic characters
     */
    public static int countAsciiAlphaUpper(String s) {
        return count(s, CharHelper::isAsciiAlphaUpper);
    }

    /**
     * Counts the number of ASCII numeric characters (0-9) in the string.
     *
     * @param s the string to analyze
     * @return the count of ASCII numeric characters
     */
    public static int countAsciiNumeric(String s) {
        return count(s, CharHelper::isAsciiNumeric);
    }

    /**
     * Counts the number of ASCII alphanumeric characters (a-z, A-Z, 0-9) in the string.
     *
     * @param s the string to analyze
     * @return the count of ASCII alphanumeric characters
     */
    public static int countAsciiAlphanumeric(String s) {
        return count(s, CharHelper::isAsciiAlphanumeric);
    }

    /**
     * Counts the number of ASCII alphanumeric characters (a-z, A-Z, 0-9) or spaces (\u0020) in the string.
     *
     * @param s the string to analyze
     * @return the count of ASCII alphanumeric characters or spaces
     */
    public static int countAsciiAlphanumericOrSpaces(String s) {
        return count(s, CharHelper::isAsciiAlphanumericOrSpace);
    }

    /**
     * Counts the number of ASCII alphanumeric characters (a-z, A-Z, 0-9) or whitespace characters in the string.
     *
     * @param s the string to analyze
     * @return the count of ASCII alphanumeric characters or whitespace characters
     */
    public static int countAsciiAlphanumericOrWhitespaces(String s) {
        return count(s, CharHelper::isAsciiAlphanumericOrWhitespace);
    }

    /**
     * Counts the number of ASCII alphabetic characters (a-z, A-Z) or spaces (\u0020) in the string.
     *
     * @param s the string to analyze
     * @return the count of ASCII alphabetic characters or spaces
     */
    public static int countAsciiAlphaOrSpaces(String s) {
        return count(s, CharHelper::isAsciiAlphaOrSpace);
    }

    /**
     * Counts the number of ASCII alphabetic characters (a-z, A-Z) or whitespace characters in the string.
     *
     * @param s the string to analyze
     * @return the count of ASCII alphabetic characters or whitespace characters
     */
    public static int countAsciiAlphaOrWhitespaces(String s) {
        return count(s, CharHelper::isAsciiAlphaOrWhitespace);
    }
}
