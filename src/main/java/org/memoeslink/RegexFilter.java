package org.memoeslink;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFilter {
    public static final Pattern ALNUM_PATTERN = Pattern.compile(UnicodeCharCategory.ALNUM_REGEX);
    public static final Pattern ALPHA_PATTERN = Pattern.compile(UnicodeCharCategory.ALPHA_REGEX);
    public static final Pattern ASCII_PATTERN = Pattern.compile(UnicodeCharCategory.ASCII_REGEX);
    public static final Pattern BLANK_PATTERN = Pattern.compile(UnicodeCharCategory.BLANK_REGEX);
    public static final Pattern CNTRL_PATTERN = Pattern.compile(UnicodeCharCategory.CNTRL_REGEX);
    public static final Pattern DIGIT_PATTERN = Pattern.compile(UnicodeCharCategory.DIGIT_REGEX);
    public static final Pattern LOWER_PATTERN = Pattern.compile(UnicodeCharCategory.LOWER_REGEX);
    public static final Pattern UPPER_PATTERN = Pattern.compile(UnicodeCharCategory.UPPER_REGEX);
    public static final Pattern PUNCT_PATTERN = Pattern.compile(UnicodeCharCategory.PUNCT_REGEX);
    public static final Pattern GRAPH_PATTERN = Pattern.compile(UnicodeCharCategory.GRAPH_REGEX);
    public static final Pattern PRINT_PATTERN = Pattern.compile(UnicodeCharCategory.PRINT_REGEX);
    public static final Pattern SPACE_PATTERN = Pattern.compile(UnicodeCharCategory.SPACE_REGEX);
    public static final Pattern XDIGIT_PATTERN = Pattern.compile(UnicodeCharCategory.XDIGIT_REGEX);
    public static final Pattern LETTER_PATTERN = Pattern.compile(UnicodeCharCategory.LETTER_REGEX);
    public static final Pattern LOWERCASE_LETTER_PATTERN = Pattern.compile(UnicodeCharCategory.LOWERCASE_LETTER_REGEX);
    public static final Pattern UPPERCASE_LETTER_PATTERN = Pattern.compile(UnicodeCharCategory.UPPERCASE_LETTER_REGEX);
    public static final Pattern TITLECASE_LETTER_PATTERN = Pattern.compile(UnicodeCharCategory.TITLECASE_LETTER_REGEX);
    public static final Pattern CASED_LETTER_PATTERN = Pattern.compile(UnicodeCharCategory.CASED_LETTER_REGEX);
    public static final Pattern MODIFIER_LETTER_PATTERN = Pattern.compile(UnicodeCharCategory.MODIFIER_LETTER_REGEX);
    public static final Pattern OTHER_LETTER_PATTERN = Pattern.compile(UnicodeCharCategory.OTHER_LETTER_REGEX);
    public static final Pattern MARK_PATTERN = Pattern.compile(UnicodeCharCategory.MARK_REGEX);
    public static final Pattern NON_SPACING_MARK_PATTERN = Pattern.compile(UnicodeCharCategory.NON_SPACING_MARK_REGEX);
    public static final Pattern SPACING_COMBINING_MARK_PATTERN = Pattern.compile(UnicodeCharCategory.SPACING_COMBINING_MARK_REGEX);
    public static final Pattern ENCLOSING_MARK_PATTERN = Pattern.compile(UnicodeCharCategory.ENCLOSING_MARK_REGEX);
    public static final Pattern SEPARATOR_PATTERN = Pattern.compile(UnicodeCharCategory.SEPARATOR_REGEX);
    public static final Pattern SPACE_SEPARATOR_PATTERN = Pattern.compile(UnicodeCharCategory.SPACE_SEPARATOR_REGEX);
    public static final Pattern LINE_SEPARATOR_PATTERN = Pattern.compile(UnicodeCharCategory.LINE_SEPARATOR_REGEX);
    public static final Pattern PARAGRAPH_SEPARATOR_PATTERN = Pattern.compile(UnicodeCharCategory.PARAGRAPH_SEPARATOR_REGEX);
    public static final Pattern SYMBOL_PATTERN = Pattern.compile(UnicodeCharCategory.SYMBOL_REGEX);
    public static final Pattern MATH_SYMBOL_PATTERN = Pattern.compile(UnicodeCharCategory.MATH_SYMBOL_REGEX);
    public static final Pattern CURRENCY_SYMBOL_PATTERN = Pattern.compile(UnicodeCharCategory.CURRENCY_SYMBOL_REGEX);
    public static final Pattern MODIFIER_SYMBOL_PATTERN = Pattern.compile(UnicodeCharCategory.MODIFIER_SYMBOL_REGEX);
    public static final Pattern OTHER_SYMBOL_PATTERN = Pattern.compile(UnicodeCharCategory.OTHER_SYMBOL_REGEX);
    public static final Pattern NUMBER_PATTERN = Pattern.compile(UnicodeCharCategory.NUMBER_REGEX);
    public static final Pattern DECIMAL_DIGIT_NUMBER_PATTERN = Pattern.compile(UnicodeCharCategory.DECIMAL_DIGIT_NUMBER_REGEX);
    public static final Pattern LETTER_NUMBER_PATTERN = Pattern.compile(UnicodeCharCategory.LETTER_NUMBER_REGEX);
    public static final Pattern OTHER_NUMBER_PATTERN = Pattern.compile(UnicodeCharCategory.OTHER_NUMBER_REGEX);
    public static final Pattern PUNCTUATION_PATTERN = Pattern.compile(UnicodeCharCategory.PUNCTUATION_REGEX);
    public static final Pattern DASH_PUNCTUATION_PATTERN = Pattern.compile(UnicodeCharCategory.DASH_PUNCTUATION_REGEX);
    public static final Pattern OPEN_PUNCTUATION_PATTERN = Pattern.compile(UnicodeCharCategory.OPEN_PUNCTUATION_REGEX);
    public static final Pattern CLOSE_PUNCTUATION_PATTERN = Pattern.compile(UnicodeCharCategory.CLOSE_PUNCTUATION_REGEX);
    public static final Pattern INITIAL_PUNCTUATION_PATTERN = Pattern.compile(UnicodeCharCategory.INITIAL_PUNCTUATION_REGEX);
    public static final Pattern FINAL_PUNCTUATION_PATTERN = Pattern.compile(UnicodeCharCategory.FINAL_PUNCTUATION_REGEX);
    public static final Pattern CONNECTOR_PUNCTUATION_PATTERN = Pattern.compile(UnicodeCharCategory.CONNECTOR_PUNCTUATION_REGEX);
    public static final Pattern OTHER_PUNCTUATION_PATTERN = Pattern.compile(UnicodeCharCategory.OTHER_PUNCTUATION_REGEX);
    public static final Pattern OTHER_PATTERN = Pattern.compile(UnicodeCharCategory.OTHER_REGEX);
    public static final Pattern CONTROL_PATTERN = Pattern.compile(UnicodeCharCategory.CONTROL_REGEX);
    public static final Pattern FORMAT_PATTERN = Pattern.compile(UnicodeCharCategory.FORMAT_REGEX);
    public static final Pattern PRIVATE_USE_PATTERN = Pattern.compile(UnicodeCharCategory.PRIVATE_USE_REGEX);
    public static final Pattern SURROGATE_PATTERN = Pattern.compile(UnicodeCharCategory.SURROGATE_REGEX);
    public static final Pattern UNASSIGNED_PATTERN = Pattern.compile(UnicodeCharCategory.UNASSIGNED_REGEX);
    public static final Pattern ZW_CHAR_PATTERN = Pattern.compile(UnicodeCharCategory.ZERO_WIDTH_CHAR_REGEX);
    public static final Pattern DIACRITICAL_LETTER_PATTERN = Pattern.compile(UnicodeCharCategory.DIACRITICAL_LETTER_REGEX);
    public static final Pattern DIACRITIC_PATTERN = Pattern.compile(UnicodeCharCategory.DIACRITIC_REGEX);
    public static final Pattern ALNUM_SPACE_PATTERN = Pattern.compile("[" + UnicodeCharCategory.ALNUM_REGEX + UnicodeCharCategory.SPACE_REGEX + "]");
    public static final Pattern ALPHANUMERIC_PATTERN = Pattern.compile("[" + UnicodeCharCategory.LETTER_REGEX + UnicodeCharCategory.DIGIT_REGEX + "]");
    public static final Pattern ALPHANUMERIC_SPACE_PATTERN = Pattern.compile("[" + UnicodeCharCategory.LETTER_REGEX + UnicodeCharCategory.DIGIT_REGEX + UnicodeCharCategory.SPACE_REGEX + "]");
    public static final Pattern EXCEPT_ALNUM_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_ALNUM_REGEX);
    public static final Pattern EXCEPT_ALPHA_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_ALPHA_REGEX);
    public static final Pattern EXCEPT_ASCII_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_ASCII_REGEX);
    public static final Pattern EXCEPT_BLANK_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_BLANK_REGEX);
    public static final Pattern EXCEPT_CNTRL_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_CNTRL_REGEX);
    public static final Pattern EXCEPT_DIGIT_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_DIGIT_REGEX);
    public static final Pattern EXCEPT_LOWER_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_LOWER_REGEX);
    public static final Pattern EXCEPT_UPPER_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_UPPER_REGEX);
    public static final Pattern EXCEPT_PUNCT_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_PUNCT_REGEX);
    public static final Pattern EXCEPT_GRAPH_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_GRAPH_REGEX);
    public static final Pattern EXCEPT_PRINT_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_PRINT_REGEX);
    public static final Pattern EXCEPT_SPACE_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_SPACE_REGEX);
    public static final Pattern EXCEPT_XDIGIT_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_XDIGIT_REGEX);
    public static final Pattern EXCEPT_LETTER_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_LETTER_REGEX);
    public static final Pattern EXCEPT_LOWERCASE_LETTER_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_LOWERCASE_LETTER_REGEX);
    public static final Pattern EXCEPT_UPPERCASE_LETTER_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_UPPERCASE_LETTER_REGEX);
    public static final Pattern EXCEPT_TITLECASE_LETTER_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_TITLECASE_LETTER_REGEX);
    public static final Pattern EXCEPT_CASED_LETTER_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_CASED_LETTER_REGEX);
    public static final Pattern EXCEPT_MODIFIER_LETTER_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_MODIFIER_LETTER_REGEX);
    public static final Pattern EXCEPT_OTHER_LETTER_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_OTHER_LETTER_REGEX);
    public static final Pattern EXCEPT_MARK_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_MARK_REGEX);
    public static final Pattern EXCEPT_NON_SPACING_MARK_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_NON_SPACING_MARK_REGEX);
    public static final Pattern EXCEPT_SPACING_COMBINING_MARK_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_SPACING_COMBINING_MARK_REGEX);
    public static final Pattern EXCEPT_ENCLOSING_MARK_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_ENCLOSING_MARK_REGEX);
    public static final Pattern EXCEPT_SEPARATOR_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_SEPARATOR_REGEX);
    public static final Pattern EXCEPT_SPACE_SEPARATOR_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_SPACE_SEPARATOR_REGEX);
    public static final Pattern EXCEPT_LINE_SEPARATOR_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_LINE_SEPARATOR_REGEX);
    public static final Pattern EXCEPT_PARAGRAPH_SEPARATOR_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_PARAGRAPH_SEPARATOR_REGEX);
    public static final Pattern EXCEPT_SYMBOL_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_SYMBOL_REGEX);
    public static final Pattern EXCEPT_MATH_SYMBOL_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_MATH_SYMBOL_REGEX);
    public static final Pattern EXCEPT_CURRENCY_SYMBOL_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_CURRENCY_SYMBOL_REGEX);
    public static final Pattern EXCEPT_MODIFIER_SYMBOL_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_MODIFIER_SYMBOL_REGEX);
    public static final Pattern EXCEPT_OTHER_SYMBOL_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_OTHER_SYMBOL_REGEX);
    public static final Pattern EXCEPT_NUMBER_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_NUMBER_REGEX);
    public static final Pattern EXCEPT_DECIMAL_DIGIT_NUMBER_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_DECIMAL_DIGIT_NUMBER_REGEX);
    public static final Pattern EXCEPT_LETTER_NUMBER_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_LETTER_NUMBER_REGEX);
    public static final Pattern EXCEPT_OTHER_NUMBER_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_OTHER_NUMBER_REGEX);
    public static final Pattern EXCEPT_PUNCTUATION_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_PUNCTUATION_REGEX);
    public static final Pattern EXCEPT_DASH_PUNCTUATION_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_DASH_PUNCTUATION_REGEX);
    public static final Pattern EXCEPT_OPEN_PUNCTUATION_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_OPEN_PUNCTUATION_REGEX);
    public static final Pattern EXCEPT_CLOSE_PUNCTUATION_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_CLOSE_PUNCTUATION_REGEX);
    public static final Pattern EXCEPT_INITIAL_PUNCTUATION_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_INITIAL_PUNCTUATION_REGEX);
    public static final Pattern EXCEPT_FINAL_PUNCTUATION_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_FINAL_PUNCTUATION_REGEX);
    public static final Pattern EXCEPT_CONNECTOR_PUNCTUATION_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_CONNECTOR_PUNCTUATION_REGEX);
    public static final Pattern EXCEPT_OTHER_PUNCTUATION_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_OTHER_PUNCTUATION_REGEX);
    public static final Pattern EXCEPT_OTHER_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_OTHER_REGEX);
    public static final Pattern EXCEPT_CONTROL_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_CONTROL_REGEX);
    public static final Pattern EXCEPT_FORMAT_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_FORMAT_REGEX);
    public static final Pattern EXCEPT_PRIVATE_USE_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_PRIVATE_USE_REGEX);
    public static final Pattern EXCEPT_SURROGATE_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_SURROGATE_REGEX);
    public static final Pattern EXCEPT_UNASSIGNED_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_UNASSIGNED_REGEX);
    public static final Pattern EXCEPT_ZW_CHAR_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_ZERO_WIDTH_CHAR_REGEX);
    public static final Pattern EXCEPT_DIACRITICAL_LETTER_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_DIACRITICAL_LETTER_REGEX);
    public static final Pattern EXCEPT_ALNUM_SPACE_PATTERN = Pattern.compile("[^" + UnicodeCharCategory.ALNUM_REGEX + UnicodeCharCategory.SPACE_REGEX + "]");
    public static final Pattern EXCEPT_ALPHANUMERIC_PATTERN = Pattern.compile("[^" + UnicodeCharCategory.LETTER_REGEX + UnicodeCharCategory.DIGIT_REGEX + "]");
    public static final Pattern EXCEPT_ALPHANUMERIC_SPACE_PATTERN = Pattern.compile("[^" + UnicodeCharCategory.LETTER_REGEX + UnicodeCharCategory.DIGIT_REGEX + UnicodeCharCategory.SPACE_REGEX + "]");
    public static final Pattern EXCEPT_DIACRITIC_PATTERN = Pattern.compile(UnicodeCharCategory.EXCEPT_DIACRITIC_REGEX);

    private RegexFilter() {
    }

    /**
     * Filters the given string, keeping only characters that match the specified pattern.
     *
     * @param s       the string to be filtered
     * @param pattern the regex pattern to match characters
     * @return a string containing only characters that match the pattern
     */
    private static String filter(String s, Pattern pattern) {
        if (StringHelper.isNullOrEmpty(s)) return s;
        Matcher matcher = pattern.matcher(s);
        StringBuilder sb = new StringBuilder();

        while (matcher.find()) {
            sb.append(matcher.group());
        }
        return sb.toString();
    }

    /**
     * Retains only alphanumeric characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only alphanumeric characters
     */
    public static String keepAlnum(String s) {
        return filter(s, ALNUM_PATTERN);
    }

    /**
     * Retains only alphabetic characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only alphabetic characters
     */
    public static String keepAlpha(String s) {
        return filter(s, ALPHA_PATTERN);
    }

    /**
     * Retains only ASCII characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only ASCII characters
     */
    public static String keepAscii(String s) {
        return filter(s, ASCII_PATTERN);
    }

    /**
     * Retains only space and tab characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only space and tab characters
     */
    public static String keepBlank(String s) {
        return filter(s, BLANK_PATTERN);
    }

    /**
     * Retains only control characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only control characters
     */
    public static String keepCntrl(String s) {
        return filter(s, CNTRL_PATTERN);
    }

    /**
     * Retains only digit characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only digit characters
     */
    public static String keepDigit(String s) {
        return filter(s, DIGIT_PATTERN);
    }

    /**
     * Retains only lowercase alphabetic characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only lowercase alphabetic characters
     */
    public static String keepLower(String s) {
        return filter(s, LOWER_PATTERN);
    }

    /**
     * Retains only uppercase alphabetic characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only uppercase alphabetic characters
     */
    public static String keepUpper(String s) {
        return filter(s, UPPER_PATTERN);
    }

    /**
     * Retains only punctuation characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only punctuation characters
     */
    public static String keepPunct(String s) {
        return filter(s, PUNCT_PATTERN);
    }

    /**
     * Retains only visible characters (excluding spaces) in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only visible characters
     */
    public static String keepGraph(String s) {
        return filter(s, GRAPH_PATTERN);
    }

    /**
     * Retains only printable characters, including spaces, in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only printable characters
     */
    public static String keepPrint(String s) {
        return filter(s, PRINT_PATTERN);
    }

    /**
     * Retains only whitespaces (\t\n\x0B\f\r) in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only whitespaces
     */
    public static String keepSpace(String s) {
        return filter(s, SPACE_PATTERN);
    }

    /**
     * Retains only hexadecimal digit characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only hexadecimal digit characters
     */
    public static String keepXDigit(String s) {
        return filter(s, XDIGIT_PATTERN);
    }

    /**
     * Retains only letter characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only letter characters
     */
    public static String keepLetter(String s) {
        return filter(s, LETTER_PATTERN);
    }

    /**
     * Retains only lowercase letter characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only lowercase letter characters
     */
    public static String keepLowercaseLetter(String s) {
        return filter(s, LOWERCASE_LETTER_PATTERN);
    }

    /**
     * Retains only uppercase letter characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only uppercase letter characters
     */
    public static String keepUppercaseLetter(String s) {
        return filter(s, UPPERCASE_LETTER_PATTERN);
    }

    /**
     * Retains only titlecase letter characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only titlecase letter characters
     */
    public static String keepTitlecaseLetter(String s) {
        return filter(s, TITLECASE_LETTER_PATTERN);
    }

    /**
     * Retains only cased letter characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only cased letter characters
     */
    public static String keepCasedLetter(String s) {
        return filter(s, CASED_LETTER_PATTERN);
    }

    /**
     * Retains only modifier letter characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only modifier letter characters
     */
    public static String keepModifierLetter(String s) {
        return filter(s, MODIFIER_LETTER_PATTERN);
    }

    /**
     * Retains only other letter characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only other letter characters
     */
    public static String keepOtherLetter(String s) {
        return filter(s, OTHER_LETTER_PATTERN);
    }

    /**
     * Retains only mark characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only mark characters
     */
    public static String keepMark(String s) {
        return filter(s, MARK_PATTERN);
    }

    /**
     * Retains only non-spacing mark characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only non-spacing mark characters
     */
    public static String keepNonSpacingMark(String s) {
        return filter(s, NON_SPACING_MARK_PATTERN);
    }

    /**
     * Retains only spacing combining mark characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only spacing combining mark characters
     */
    public static String keepSpacingCombiningMark(String s) {
        return filter(s, SPACING_COMBINING_MARK_PATTERN);
    }

    /**
     * Retains only enclosing mark characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only enclosing mark characters
     */
    public static String keepEnclosingMark(String s) {
        return filter(s, ENCLOSING_MARK_PATTERN);
    }

    /**
     * Retains only separator characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only separator characters
     */
    public static String keepSeparator(String s) {
        return filter(s, SEPARATOR_PATTERN);
    }

    /**
     * Retains only space separator characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only space separator characters
     */
    public static String keepSpaceSeparator(String s) {
        return filter(s, SPACE_SEPARATOR_PATTERN);
    }

    /**
     * Retains only line separator characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only line separator characters
     */
    public static String keepLineSeparator(String s) {
        return filter(s, LINE_SEPARATOR_PATTERN);
    }

    /**
     * Retains only paragraph separator characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only paragraph separator characters
     */
    public static String keepParagraphSeparator(String s) {
        return filter(s, PARAGRAPH_SEPARATOR_PATTERN);
    }

    /**
     * Retains only symbol characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only symbol characters
     */
    public static String keepSymbol(String s) {
        return filter(s, SYMBOL_PATTERN);
    }

    /**
     * Retains only mathematical symbol characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only mathematical symbol characters
     */
    public static String keepMathSymbol(String s) {
        return filter(s, MATH_SYMBOL_PATTERN);
    }

    /**
     * Retains only currency symbol characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only currency symbol characters
     */
    public static String keepCurrencySymbol(String s) {
        return filter(s, CURRENCY_SYMBOL_PATTERN);
    }

    /**
     * Retains only modifier symbol characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only modifier symbol characters
     */
    public static String keepModifierSymbol(String s) {
        return filter(s, MODIFIER_SYMBOL_PATTERN);
    }

    /**
     * Retains only other symbol characters that do not fall into the categories of math symbols, currency symbols, or modifier symbols in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only other symbol characters
     */
    public static String keepOtherSymbol(String s) {
        return filter(s, OTHER_SYMBOL_PATTERN);
    }

    /**
     * Retains only numeric characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only numeric characters
     */
    public static String keepNumber(String s) {
        return filter(s, NUMBER_PATTERN);
    }

    /**
     * Retains only decimal digit number characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only decimal digit number characters
     */
    public static String keepDecimalDigitNumber(String s) {
        return filter(s, DECIMAL_DIGIT_NUMBER_PATTERN);
    }

    /**
     * Retains only letter number characters, such as Roman numerals, in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only letter number characters
     */
    public static String keepLetterNumber(String s) {
        return filter(s, LETTER_NUMBER_PATTERN);
    }

    /**
     * Retains only other number characters that are not decimal digit numbers or letter numbers in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only other number characters
     */
    public static String keepOtherNumber(String s) {
        return filter(s, OTHER_NUMBER_PATTERN);
    }

    /**
     * Retains only punctuation characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only punctuation characters
     */
    public static String keepPunctuation(String s) {
        return filter(s, PUNCTUATION_PATTERN);
    }

    /**
     * Retains only dash punctuation characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only dash punctuation characters
     */
    public static String keepDashPunctuation(String s) {
        return filter(s, DASH_PUNCTUATION_PATTERN);
    }

    /**
     * Retains only opening punctuation characters, such as open brackets, in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only opening punctuation characters
     */
    public static String keepOpenPunctuation(String s) {
        return filter(s, OPEN_PUNCTUATION_PATTERN);
    }

    /**
     * Retains only closing punctuation characters, such as close brackets, in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only closing punctuation characters
     */
    public static String keepClosePunctuation(String s) {
        return filter(s, CLOSE_PUNCTUATION_PATTERN);
    }

    /**
     * Retains only initial quote or opening quote punctuation characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only initial punctuation characters
     */
    public static String keepInitialPunctuation(String s) {
        return filter(s, INITIAL_PUNCTUATION_PATTERN);
    }

    /**
     * Retains only final quote or closing quote punctuation characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only final punctuation characters
     */
    public static String keepFinalPunctuation(String s) {
        return filter(s, FINAL_PUNCTUATION_PATTERN);
    }

    /**
     * Retains only connector punctuation characters, such as underscores, that connect words in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only connector punctuation characters
     */
    public static String keepConnectorPunctuation(String s) {
        return filter(s, CONNECTOR_PUNCTUATION_PATTERN);
    }

    /**
     * Retains only other punctuation characters not classified under dash, open, close, initial, or final punctuation categories in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only other punctuation characters
     */
    public static String keepOtherPunctuation(String s) {
        return filter(s, OTHER_PUNCTUATION_PATTERN);
    }

    /**
     * Retains only characters classified as 'other', including invisible control characters and unused code points, in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only characters classified as 'other'
     */
    public static String keepOther(String s) {
        return filter(s, OTHER_PATTERN);
    }

    /**
     * Retains only control characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only control characters
     */
    public static String keepControl(String s) {
        return filter(s, CONTROL_PATTERN);
    }

    /**
     * Retains only format characters used for text presentation in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only format characters
     */
    public static String keepFormat(String s) {
        return filter(s, FORMAT_PATTERN);
    }

    /**
     * Retains only characters designated for private use in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only private use characters
     */
    public static String keepPrivateUse(String s) {
        return filter(s, PRIVATE_USE_PATTERN);
    }

    /**
     * Retains only surrogate pair characters in UTF-16 encoding in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only surrogate pair characters
     */
    public static String keepSurrogate(String s) {
        return filter(s, SURROGATE_PATTERN);
    }

    /**
     * Retains only unassigned characters in the Unicode standard in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only unassigned characters
     */
    public static String keepUnassigned(String s) {
        return filter(s, UNASSIGNED_PATTERN);
    }

    /**
     * Retains only zero-width characters in the given string.
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
     * @param s the string to be filtered
     * @return a string containing only zero-width characters
     */
    public static String keepZWChar(String s) {
        return filter(s, ZW_CHAR_PATTERN);
    }

    /**
     * Retains only diacritical letters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only diacritical letters
     */
    public static String keepDiacriticalLetter(String s) {
        return filter(s, DIACRITICAL_LETTER_PATTERN);
    }

    /**
     * Retains only alphanumeric and space characters in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only alphanumeric and space characters
     */
    public static String keepAlnumSpace(String s) {
        return filter(s, ALNUM_SPACE_PATTERN);
    }

    /**
     * Retains only alphanumeric characters, including letters and digits, in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only alphanumeric characters
     */
    public static String keepAlphanumeric(String s) {
        return filter(s, ALPHANUMERIC_PATTERN);
    }

    /**
     * Retains only alphanumeric characters and spaces in the given string.
     *
     * @param s the string to be filtered
     * @return a string containing only alphanumeric characters and spaces
     */
    public static String keepAlphanumericSpace(String s) {
        return filter(s, ALPHANUMERIC_SPACE_PATTERN);
    }

    /**
     * Removes all alphanumeric characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all alphanumeric characters removed
     */
    public static String removeAlnum(String s) {
        return filter(s, EXCEPT_ALNUM_PATTERN);
    }

    /**
     * Removes all alphabetic characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all alphabetic characters removed
     */
    public static String removeAlpha(String s) {
        return filter(s, EXCEPT_ALPHA_PATTERN);
    }

    /**
     * Removes all ASCII characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all ASCII characters removed
     */
    public static String removeAscii(String s) {
        return filter(s, EXCEPT_ASCII_PATTERN);
    }

    /**
     * Removes all space and tab characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all space and tab characters removed
     */
    public static String removeBlank(String s) {
        return filter(s, EXCEPT_BLANK_PATTERN);
    }

    /**
     * Removes all control characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all control characters removed
     */
    public static String removeCntrl(String s) {
        return filter(s, EXCEPT_CNTRL_PATTERN);
    }

    /**
     * Removes all digit characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all digit characters removed
     */
    public static String removeDigit(String s) {
        return filter(s, EXCEPT_DIGIT_PATTERN);
    }

    /**
     * Removes all lowercase alphabetic characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all lowercase alphabetic characters removed
     */
    public static String removeLower(String s) {
        return filter(s, EXCEPT_LOWER_PATTERN);
    }

    /**
     * Removes all uppercase alphabetic characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all uppercase alphabetic characters removed
     */
    public static String removeUpper(String s) {
        return filter(s, EXCEPT_UPPER_PATTERN);
    }

    /**
     * Removes all punctuation characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all punctuation characters removed
     */
    public static String removePunct(String s) {
        return filter(s, EXCEPT_PUNCT_PATTERN);
    }

    /**
     * Removes all visible characters (excluding spaces) from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all visible characters removed
     */
    public static String removeGraph(String s) {
        return filter(s, EXCEPT_GRAPH_PATTERN);
    }

    /**
     * Removes all printable characters, including spaces, from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all printable characters removed
     */
    public static String removePrint(String s) {
        return filter(s, EXCEPT_PRINT_PATTERN);
    }

    /**
     * Removes all whitespaces (\t\n\x0B\f\r) from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all whitespaces removed
     */
    public static String removeSpace(String s) {
        return filter(s, EXCEPT_SPACE_PATTERN);
    }

    /**
     * Removes all hexadecimal digit characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all hexadecimal digit characters removed
     */
    public static String removeXDigit(String s) {
        return filter(s, EXCEPT_XDIGIT_PATTERN);
    }

    /**
     * Removes all letter characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all letter characters removed
     */
    public static String removeLetter(String s) {
        return filter(s, EXCEPT_LETTER_PATTERN);
    }

    /**
     * Removes all lowercase letter characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all lowercase letter characters removed
     */
    public static String removeLowercaseLetter(String s) {
        return filter(s, EXCEPT_LOWERCASE_LETTER_PATTERN);
    }

    /**
     * Removes all uppercase letter characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all uppercase letter characters removed
     */
    public static String removeUppercaseLetter(String s) {
        return filter(s, EXCEPT_UPPERCASE_LETTER_PATTERN);
    }

    /**
     * Removes all titlecase letter characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all titlecase letter characters removed
     */
    public static String removeTitlecaseLetter(String s) {
        return filter(s, EXCEPT_TITLECASE_LETTER_PATTERN);
    }

    /**
     * Removes all cased letter characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all cased letter characters removed
     */
    public static String removeCasedLetter(String s) {
        return filter(s, EXCEPT_CASED_LETTER_PATTERN);
    }

    /**
     * Removes all modifier letter characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all modifier letter characters removed
     */
    public static String removeModifierLetter(String s) {
        return filter(s, EXCEPT_MODIFIER_LETTER_PATTERN);
    }

    /**
     * Removes all other letter characters that do not fall into the standard letter categories from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all other letter characters removed
     */
    public static String removeOtherLetter(String s) {
        return filter(s, EXCEPT_OTHER_LETTER_PATTERN);
    }

    /**
     * Removes all mark characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all mark characters removed
     */
    public static String removeMark(String s) {
        return filter(s, EXCEPT_MARK_PATTERN);
    }

    /**
     * Removes all non-spacing mark characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all non-spacing mark characters removed
     */
    public static String removeNonSpacingMark(String s) {
        return filter(s, EXCEPT_NON_SPACING_MARK_PATTERN);
    }

    /**
     * Removes all spacing combining mark characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all spacing combining mark characters removed
     */
    public static String removeSpacingCombiningMark(String s) {
        return filter(s, EXCEPT_SPACING_COMBINING_MARK_PATTERN);
    }

    /**
     * Removes all enclosing mark characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all enclosing mark characters removed
     */
    public static String removeEnclosingMark(String s) {
        return filter(s, EXCEPT_ENCLOSING_MARK_PATTERN);
    }

    /**
     * Removes all separator characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all separator characters removed
     */
    public static String removeSeparator(String s) {
        return filter(s, EXCEPT_SEPARATOR_PATTERN);
    }

    /**
     * Removes all space separator characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all space separator characters removed
     */
    public static String removeSpaceSeparator(String s) {
        return filter(s, EXCEPT_SPACE_SEPARATOR_PATTERN);
    }

    /**
     * Removes all line separator characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all line separator characters removed
     */
    public static String removeLineSeparator(String s) {
        return filter(s, EXCEPT_LINE_SEPARATOR_PATTERN);
    }

    /**
     * Removes all paragraph separator characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all paragraph separator characters removed
     */
    public static String removeParagraphSeparator(String s) {
        return filter(s, EXCEPT_PARAGRAPH_SEPARATOR_PATTERN);
    }

    /**
     * Removes all symbol characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all symbol characters removed
     */
    public static String removeSymbol(String s) {
        return filter(s, EXCEPT_SYMBOL_PATTERN);
    }

    /**
     * Removes all mathematical symbol characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all mathematical symbol characters removed
     */
    public static String removeMathSymbol(String s) {
        return filter(s, EXCEPT_MATH_SYMBOL_PATTERN);
    }

    /**
     * Removes all currency symbol characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all currency symbol characters removed
     */
    public static String removeCurrencySymbol(String s) {
        return filter(s, EXCEPT_CURRENCY_SYMBOL_PATTERN);
    }

    /**
     * Removes all modifier symbol characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all modifier symbol characters removed
     */
    public static String removeModifierSymbol(String s) {
        return filter(s, EXCEPT_MODIFIER_SYMBOL_PATTERN);
    }

    /**
     * Removes all other symbol characters not classified as math, currency, or modifier symbols from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all other symbol characters removed
     */
    public static String removeOtherSymbol(String s) {
        return filter(s, EXCEPT_OTHER_SYMBOL_PATTERN);
    }

    /**
     * Removes all number characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all number characters removed
     */
    public static String removeNumber(String s) {
        return filter(s, EXCEPT_NUMBER_PATTERN);
    }

    /**
     * Removes all decimal digit number characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all decimal digit number characters removed
     */
    public static String removeDecimalDigitNumber(String s) {
        return filter(s, EXCEPT_DECIMAL_DIGIT_NUMBER_PATTERN);
    }

    /**
     * Removes all letter number characters, such as Roman numerals, from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all letter number characters removed
     */
    public static String removeLetterNumber(String s) {
        return filter(s, EXCEPT_LETTER_NUMBER_PATTERN);
    }

    /**
     * Removes all other number characters not classified as decimal digit numbers or letter numbers from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all other number characters removed
     */
    public static String removeOtherNumber(String s) {
        return filter(s, EXCEPT_OTHER_NUMBER_PATTERN);
    }

    /**
     * Removes all punctuation characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all punctuation characters removed
     */
    public static String removePunctuation(String s) {
        return filter(s, EXCEPT_PUNCTUATION_PATTERN);
    }

    /**
     * Removes all dash punctuation characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all dash punctuation characters removed
     */
    public static String removeDashPunctuation(String s) {
        return filter(s, EXCEPT_DASH_PUNCTUATION_PATTERN);
    }

    /**
     * Removes all open punctuation characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all open punctuation characters removed
     */
    public static String removeOpenPunctuation(String s) {
        return filter(s, EXCEPT_OPEN_PUNCTUATION_PATTERN);
    }

    /**
     * Removes all close punctuation characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all close punctuation characters removed
     */
    public static String removeClosePunctuation(String s) {
        return filter(s, EXCEPT_CLOSE_PUNCTUATION_PATTERN);
    }

    /**
     * Removes all initial quote or opening quote punctuation characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all initial punctuation characters removed
     */
    public static String removeInitialPunctuation(String s) {
        return filter(s, EXCEPT_INITIAL_PUNCTUATION_PATTERN);
    }

    /**
     * Removes all final quote or closing quote punctuation characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all final punctuation characters removed
     */
    public static String removeFinalPunctuation(String s) {
        return filter(s, EXCEPT_FINAL_PUNCTUATION_PATTERN);
    }

    /**
     * Removes all connector punctuation characters, such as underscores, that connect words from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all connector punctuation characters removed
     */
    public static String removeConnectorPunctuation(String s) {
        return filter(s, EXCEPT_CONNECTOR_PUNCTUATION_PATTERN);
    }

    /**
     * Removes all other punctuation characters not classified under specific categories from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all other punctuation characters removed
     */
    public static String removeOtherPunctuation(String s) {
        return filter(s, EXCEPT_OTHER_PUNCTUATION_PATTERN);
    }

    /**
     * Removes all characters classified as 'other', including invisible control characters and unused code points, from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all characters classified as 'other' removed
     */
    public static String removeOther(String s) {
        return filter(s, EXCEPT_OTHER_PATTERN);
    }

    /**
     * Removes all control characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all control characters removed
     */
    public static String removeControl(String s) {
        return filter(s, EXCEPT_CONTROL_PATTERN);
    }

    /**
     * Removes all format characters used for text presentation from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all format characters removed
     */
    public static String removeFormat(String s) {
        return filter(s, EXCEPT_FORMAT_PATTERN);
    }

    /**
     * Removes all characters designated for private use from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all private use characters removed
     */
    public static String removePrivateUse(String s) {
        return filter(s, EXCEPT_PRIVATE_USE_PATTERN);
    }

    /**
     * Removes all surrogate pair characters in UTF-16 encoding from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all surrogate pair characters removed
     */
    public static String removeSurrogate(String s) {
        return filter(s, EXCEPT_SURROGATE_PATTERN);
    }

    /**
     * Removes all unassigned characters in the Unicode standard from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all unassigned characters removed
     */
    public static String removeUnassigned(String s) {
        return filter(s, EXCEPT_UNASSIGNED_PATTERN);
    }

    /**
     * Removes all zero-width characters from the given string.
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
     * @param s the string to be filtered
     * @return a string with all zero-width characters removed
     */
    public static String removeZWChar(String s) {
        return filter(s, EXCEPT_ZW_CHAR_PATTERN);
    }

    /**
     * Removes all diacritical letters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all diacritical letters
     */
    public static String removeDiacriticalLetter(String s) {
        return filter(s, EXCEPT_DIACRITICAL_LETTER_PATTERN);
    }

    /**
     * Removes all alphanumeric and space characters from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all alphanumeric and space characters removed
     */
    public static String removeAlnumSpace(String s) {
        return filter(s, EXCEPT_ALNUM_SPACE_PATTERN);
    }

    /**
     * Removes all alphanumeric characters, including letters and digits, from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all alphanumeric characters removed
     */
    public static String removeAlphanumeric(String s) {
        return filter(s, EXCEPT_ALPHANUMERIC_PATTERN);
    }

    /**
     * Removes all alphanumeric characters and spaces from the given string.
     *
     * @param s the string to be filtered
     * @return a string with all alphanumeric characters and spaces removed
     */
    public static String removeAlphanumericSpace(String s) {
        return filter(s, EXCEPT_ALPHANUMERIC_SPACE_PATTERN);
    }

    /**
     * Counts the number of characters in the given string that match the specified pattern.
     *
     * @param s       the string whose matching characters are to be counted
     * @param pattern the pattern to match characters against
     * @return the number of characters that match the pattern
     */
    private static int count(String s, Pattern pattern) {
        return filter(s, pattern).length();
    }

    /**
     * Counts the number of alphanumeric characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of alphanumeric characters
     */
    public static int countAlnum(String s) {
        return count(s, ALNUM_PATTERN);
    }

    /**
     * Counts the number of alphabetic characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of alphabetic characters
     */
    public static int countAlpha(String s) {
        return count(s, ALPHA_PATTERN);
    }

    /**
     * Counts the number of ASCII characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of ASCII characters
     */
    public static int countAscii(String s) {
        return count(s, ASCII_PATTERN);
    }

    /**
     * Counts the number of blank characters (space or tab) in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of blank characters
     */
    public static int countBlank(String s) {
        return count(s, BLANK_PATTERN);
    }

    /**
     * Counts the number of control characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of control characters
     */
    public static int countCntrl(String s) {
        return count(s, CNTRL_PATTERN);
    }

    /**
     * Counts the number of digit characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of digit characters
     */
    public static int countDigit(String s) {
        return count(s, DIGIT_PATTERN);
    }

    /**
     * Counts the number of lowercase alphabetic characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of lowercase alphabetic characters
     */
    public static int countLower(String s) {
        return count(s, LOWER_PATTERN);
    }

    /**
     * Counts the number of uppercase alphabetic characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of uppercase alphabetic characters
     */
    public static int countUpper(String s) {
        return count(s, UPPER_PATTERN);
    }

    /**
     * Counts the number of punctuation characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of punctuation characters
     */
    public static int countPunct(String s) {
        return count(s, PUNCT_PATTERN);
    }

    /**
     * Counts the number of visible characters (excluding spaces) in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of visible characters
     */
    public static int countGraph(String s) {
        return count(s, GRAPH_PATTERN);
    }

    /**
     * Counts the number of printable characters, including spaces, in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of printable characters
     */
    public static int countPrint(String s) {
        return count(s, PRINT_PATTERN);
    }

    /**
     * Counts the number of whitespaces (\t\n\x0B\f\r) in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of whitespaces
     */
    public static int countSpace(String s) {
        return count(s, SPACE_PATTERN);
    }

    /**
     * Counts the number of hexadecimal digit characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of hexadecimal digit characters
     */
    public static int countXDigit(String s) {
        return count(s, XDIGIT_PATTERN);
    }

    /**
     * Counts the number of letter characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of letter characters
     */
    public static int countLetter(String s) {
        return count(s, LETTER_PATTERN);
    }

    /**
     * Counts the number of lowercase letter characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of lowercase letter characters
     */
    public static int countLowercaseLetter(String s) {
        return count(s, LOWERCASE_LETTER_PATTERN);
    }

    /**
     * Counts the number of uppercase letter characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of uppercase letter characters
     */
    public static int countUppercaseLetter(String s) {
        return count(s, UPPERCASE_LETTER_PATTERN);
    }

    /**
     * Counts the number of titlecase letter characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of titlecase letter characters
     */
    public static int countTitlecaseLetter(String s) {
        return count(s, TITLECASE_LETTER_PATTERN);
    }

    /**
     * Counts the number of cased letter characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of cased letter characters
     */
    public static int countCasedLetter(String s) {
        return count(s, CASED_LETTER_PATTERN);
    }

    /**
     * Counts the number of modifier letter characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of modifier letter characters
     */
    public static int countModifierLetter(String s) {
        return count(s, MODIFIER_LETTER_PATTERN);
    }

    /**
     * Counts the number of other letter characters that do not fall into the standard letter categories in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of other letter characters
     */
    public static int countOtherLetter(String s) {
        return count(s, OTHER_LETTER_PATTERN);
    }

    /**
     * Counts the number of mark characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of mark characters
     */
    public static int countMark(String s) {
        return count(s, MARK_PATTERN);
    }

    /**
     * Counts the number of non-spacing mark characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of non-spacing mark characters
     */
    public static int countNonSpacingMark(String s) {
        return count(s, NON_SPACING_MARK_PATTERN);
    }

    /**
     * Counts the number of spacing combining mark characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of spacing combining mark characters
     */
    public static int countSpacingCombiningMark(String s) {
        return count(s, SPACING_COMBINING_MARK_PATTERN);
    }

    /**
     * Counts the number of enclosing mark characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of enclosing mark characters
     */
    public static int countEnclosingMark(String s) {
        return count(s, ENCLOSING_MARK_PATTERN);
    }

    /**
     * Counts the number of separator characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of separator characters
     */
    public static int countSeparator(String s) {
        return count(s, SEPARATOR_PATTERN);
    }

    /**
     * Counts the number of space separator characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of space separator characters
     */
    public static int countSpaceSeparator(String s) {
        return count(s, SPACE_SEPARATOR_PATTERN);
    }

    /**
     * Counts the number of line separator characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of line separator characters
     */
    public static int countLineSeparator(String s) {
        return count(s, LINE_SEPARATOR_PATTERN);
    }

    /**
     * Counts the number of paragraph separator characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of paragraph separator characters
     */
    public static int countParagraphSeparator(String s) {
        return count(s, PARAGRAPH_SEPARATOR_PATTERN);
    }

    /**
     * Counts the number of symbol characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of symbol characters
     */
    public static int countSymbol(String s) {
        return count(s, SYMBOL_PATTERN);
    }

    /**
     * Counts the number of mathematical symbol characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of mathematical symbol characters
     */
    public static int countMathSymbol(String s) {
        return count(s, MATH_SYMBOL_PATTERN);
    }

    /**
     * Counts the number of currency symbol characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of currency symbol characters
     */
    public static int countCurrencySymbol(String s) {
        return count(s, CURRENCY_SYMBOL_PATTERN);
    }

    /**
     * Counts the number of modifier symbol characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of modifier symbol characters
     */
    public static int countModifierSymbol(String s) {
        return count(s, MODIFIER_SYMBOL_PATTERN);
    }

    /**
     * Counts the number of other symbol characters not classified as math, currency, or modifier symbols in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of other symbol characters
     */
    public static int countOtherSymbol(String s) {
        return count(s, OTHER_SYMBOL_PATTERN);
    }

    /**
     * Counts the number of numeric characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of numeric characters
     */
    public static int countNumber(String s) {
        return count(s, NUMBER_PATTERN);
    }

    /**
     * Counts the number of decimal digit number characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of decimal digit number characters
     */
    public static int countDecimalDigitNumber(String s) {
        return count(s, DECIMAL_DIGIT_NUMBER_PATTERN);
    }

    /**
     * Counts the number of letter number characters, such as Roman numerals, in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of letter number characters
     */
    public static int countLetterNumber(String s) {
        return count(s, LETTER_NUMBER_PATTERN);
    }

    /**
     * Counts the number of other number characters that are not classified as decimal digit numbers or letter numbers in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of other number characters
     */
    public static int countOtherNumber(String s) {
        return count(s, OTHER_NUMBER_PATTERN);
    }

    /**
     * Counts the number of punctuation characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of punctuation characters
     */
    public static int countPunctuation(String s) {
        return count(s, PUNCTUATION_PATTERN);
    }

    /**
     * Counts the number of dash punctuation characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of dash punctuation characters
     */
    public static int countDashPunctuation(String s) {
        return count(s, DASH_PUNCTUATION_PATTERN);
    }

    /**
     * Counts the number of open punctuation characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of open punctuation characters
     */
    public static int countOpenPunctuation(String s) {
        return count(s, OPEN_PUNCTUATION_PATTERN);
    }

    /**
     * Counts the number of close punctuation characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of close punctuation characters
     */
    public static int countClosePunctuation(String s) {
        return count(s, CLOSE_PUNCTUATION_PATTERN);
    }

    /**
     * Counts the number of initial punctuation characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of initial punctuation characters
     */
    public static int countInitialPunctuation(String s) {
        return count(s, INITIAL_PUNCTUATION_PATTERN);
    }

    /**
     * Counts the number of final punctuation characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of final punctuation characters
     */
    public static int countFinalPunctuation(String s) {
        return count(s, FINAL_PUNCTUATION_PATTERN);
    }

    /**
     * Counts the number of connector punctuation characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of connector punctuation characters
     */
    public static int countConnectorPunctuation(String s) {
        return count(s, CONNECTOR_PUNCTUATION_PATTERN);
    }

    /**
     * Counts the number of other punctuation characters not classified under specific categories in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of other punctuation characters
     */
    public static int countOtherPunctuation(String s) {
        return count(s, OTHER_PUNCTUATION_PATTERN);
    }

    /**
     * Counts the number of characters classified as 'other', including invisible control characters and unused code points, in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of 'other' characters
     */
    public static int countOther(String s) {
        return count(s, OTHER_PATTERN);
    }

    /**
     * Counts the number of control characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of control characters
     */
    public static int countControl(String s) {
        return count(s, CONTROL_PATTERN);
    }

    /**
     * Counts the number of format characters used for text presentation in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of format characters
     */
    public static int countFormat(String s) {
        return count(s, FORMAT_PATTERN);
    }

    /**
     * Counts the number of characters designated for private use in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of private use characters
     */
    public static int countPrivateUse(String s) {
        return count(s, PRIVATE_USE_PATTERN);
    }

    /**
     * Counts the number of surrogate pair characters in UTF-16 encoding in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of surrogate pair characters
     */
    public static int countSurrogate(String s) {
        return count(s, SURROGATE_PATTERN);
    }

    /**
     * Counts the number of unassigned characters in the Unicode standard in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of unassigned characters
     */
    public static int countUnassigned(String s) {
        return count(s, UNASSIGNED_PATTERN);
    }

    /**
     * Counts the number of zero-width characters in the given string.
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
     * @param s the string whose matching characters are to be counted
     * @return the number of zero-width characters
     */
    public static int countZWChar(String s) {
        return count(s, ZW_CHAR_PATTERN);
    }

    /**
     * Counts the number of diacritical letters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of diacritical letters
     */
    public static int countDiacriticalLetter(String s) {
        return count(s, DIACRITICAL_LETTER_PATTERN);
    }

    /**
     * Counts the number of alphanumeric and space characters in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of alphanumeric and space characters
     */
    public static int countAlnumSpace(String s) {
        return count(s, ALNUM_SPACE_PATTERN);
    }

    /**
     * Counts the number of alphanumeric characters, including letters and digits, in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of alphanumeric characters
     */
    public static int countAlphanumeric(String s) {
        return count(s, ALPHANUMERIC_PATTERN);
    }

    /**
     * Counts the number of alphanumeric characters and spaces in the given string.
     *
     * @param s the string whose matching characters are to be counted
     * @return the number of alphanumeric characters and spaces
     */
    public static int countAlphanumericSpace(String s) {
        return count(s, ALPHANUMERIC_SPACE_PATTERN);
    }
}
