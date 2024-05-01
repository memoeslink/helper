package org.memoeslink;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringFilterTest {

    @Test
    void keepWhitespaces_keepsOnlyWhitespaceCharacters() {
        assertEquals(" ", StringFilter.keepWhitespaces("Hello World!"));
    }

    @Test
    void keepZeroWidthSpaces_keepsOnlyZeroWidthCharacters() {
        assertEquals("\u200B", StringFilter.keepZeroWidthSpaces("Hello\u200BWorld!"));
    }

    @Test
    void keepLetters_keepsOnlyLetterCharacters() {
        assertEquals("Hello", StringFilter.keepLetters("Hello123!"));
    }

    @Test
    void keepLowercase_keepsOnlyLowercaseCharacters() {
        assertEquals("ello", StringFilter.keepLowercase("Hello123!"));
    }

    @Test
    void keepUppercase_keepsOnlyUppercaseCharacters() {
        assertEquals("H", StringFilter.keepUppercase("Hello123!"));
    }

    @Test
    void keepDigits_keepsOnlyDigitCharacters() {
        assertEquals("123", StringFilter.keepDigits("Hello123!"));
    }

    @Test
    void keepLettersOrWhitespaces_keepsOnlyLettersOrWhitespaces() {
        assertEquals("Hello World", StringFilter.keepLettersOrWhitespaces("Hello World!123"));
    }

    @Test
    void keepLettersOrDigits_keepsOnlyLettersOrDigits() {
        assertEquals("HelloWorld123", StringFilter.keepLettersOrDigits("Hello World!123"));
    }

    @Test
    void keepLettersDigitsOrWhitespaces_keepsOnlyLettersDigitsOrWhitespaces() {
        assertEquals("Hello World123", StringFilter.keepLettersDigitsOrWhitespaces("Hello World!123"));
    }

    @Test
    void keepAlphabetic_keepsOnlyAlphabeticCharacters() {
        assertEquals("Hello", StringFilter.keepAlphabetic("Hello123!"));
    }

    @Test
    void keepAlphabeticOrWhitespaces_keepsOnlyAlphabeticOrWhitespaceCharacters() {
        assertEquals("Hello World", StringFilter.keepAlphabeticOrWhitespaces("Hello World!123"));
    }

    @Test
    void keepAlphabeticOrDigits_keepsOnlyAlphabeticOrDigitCharacters() {
        assertEquals("HelloWorld123", StringFilter.keepAlphabeticOrDigits("Hello World!123"));
    }

    @Test
    void keepAlphanumericOrWhitespaces_keepsOnlyAlphanumericOrWhitespaceCharacters() {
        assertEquals("Hello World123", StringFilter.keepAlphanumericOrWhitespaces("Hello World!123"));
    }

    @Test
    void keepSpecialChars_keepsOnlySpecialCharacters() {
        assertEquals("!", StringFilter.keepSpecialChars("Hello World!123"));
    }

    @Test
    void keepAscii_keepsOnlyAsciiCharacters() {
        assertEquals("Hello World!123", StringFilter.keepAscii("Hello World!123\u200B"));
    }

    @Test
    void keepAsciiSpaces_keepsOnlyAsciiSpaces() {
        assertEquals(" ", StringFilter.keepAsciiSpaces("Hello World!123"));
    }

    @Test
    void keepAsciiWhitespaces_keepsOnlyAsciiWhitespaces() {
        assertEquals(" ", StringFilter.keepAsciiWhitespaces("Hello World!123"));
    }

    @Test
    void keepAsciiAlpha_keepsOnlyAsciiAlphabeticCharacters() {
        assertEquals("HelloWorld", StringFilter.keepAsciiAlpha("Hello World!123"));
    }

    @Test
    void keepAsciiAlphaLower_keepsOnlyAsciiLowercaseAlphabeticCharacters() {
        assertEquals("elloorld", StringFilter.keepAsciiAlphaLower("Hello World!123"));
    }

    @Test
    void keepAsciiAlphaUpper_keepsOnlyAsciiUppercaseAlphabeticCharacters() {
        assertEquals("HW", StringFilter.keepAsciiAlphaUpper("Hello World!123"));
    }

    @Test
    void keepAsciiNumeric_keepsOnlyAsciiNumericCharacters() {
        assertEquals("123", StringFilter.keepAsciiNumeric("Hello World!123"));
    }

    @Test
    void keepAsciiAlphaOrSpaces_keepsOnlyAsciiAlphaOrSpaces() {
        assertEquals("Hello World", StringFilter.keepAsciiAlphaOrSpaces("Hello World!123"));
    }

    @Test
    void keepAsciiAlphaOrWhitespaces_keepsOnlyAsciiAlphaOrWhitespaces() {
        assertEquals("Hello World", StringFilter.keepAsciiAlphaOrWhitespaces("Hello World!123"));
    }

    @Test
    void keepAsciiAlphanumeric_keepsOnlyAsciiAlphanumeric() {
        assertEquals("HelloWorld123", StringFilter.keepAsciiAlphanumeric("Hello World!123"));
    }

    @Test
    void keepAsciiAlphanumericOrSpaces_keepsOnlyAsciiAlphanumericOrSpaces() {
        assertEquals("Hello World123", StringFilter.keepAsciiAlphanumericOrSpaces("Hello World!123"));
    }

    @Test
    void keepAsciiAlphanumericOrWhitespaces_keepsOnlyAsciiAlphanumericOrWhitespaces() {
        assertEquals("Hello World123", StringFilter.keepAsciiAlphanumericOrWhitespaces("Hello World!123"));
    }

    @Test
    void removeWhitespaces_removesAllWhitespaces() {
        assertEquals("HelloWorld!123", StringFilter.removeWhitespaces("Hello World!123"));
    }

    @Test
    void removeZeroWidthSpaces_removesAllZeroWidthSpaces() {
        assertEquals("HelloWorld!123", StringFilter.removeZeroWidthSpaces("Hello\u200BWorld!123"));
    }

    @Test
    void removeLetters_removesAllLetterCharacters() {
        assertEquals("123!", StringFilter.removeLetters("Hello123!"));
    }

    @Test
    void removeLowercase_removesAllLowercaseCharacters() {
        assertEquals("H123!", StringFilter.removeLowercase("Hello123!"));
    }

    @Test
    void removeUppercase_removesAllUppercaseCharacters() {
        assertEquals("ello123!", StringFilter.removeUppercase("Hello123!"));
    }

    @Test
    void removeDigits_removesAllDigitCharacters() {
        assertEquals("Hello!", StringFilter.removeDigits("Hello123!"));
    }

    @Test
    void removeLettersOrWhitespaces_removesAllLettersOrWhitespaces() {
        assertEquals("!123", StringFilter.removeLettersOrWhitespaces("Hello World!123"));
    }

    @Test
    void removeLettersOrDigits_removesAllLettersOrDigits() {
        assertEquals(" !", StringFilter.removeLettersOrDigits("Hello World!123"));
    }

    @Test
    void removeLettersDigitsOrWhitespaces_removesAllLettersDigitsOrWhitespaces() {
        assertEquals("!", StringFilter.removeLettersDigitsOrWhitespaces("Hello World!123"));
    }

    @Test
    void removeAlphabetic_removesAllAlphabeticCharacters() {
        assertEquals("123!", StringFilter.removeAlphabetic("Hello123!"));
    }

    @Test
    void removeAlphabeticOrWhitespaces_removesAllAlphabeticOrWhitespaceCharacters() {
        assertEquals("!123", StringFilter.removeAlphabeticOrWhitespaces("Hello World!123"));
    }

    @Test
    void removeAlphabeticOrDigits_removesAllAlphabeticOrDigitCharacters() {
        assertEquals(" !", StringFilter.removeAlphabeticOrDigits("Hello World!123"));
    }

    @Test
    void removeAlphanumericOrWhitespaces_removesAllAlphanumericOrWhitespaceCharacters() {
        assertEquals("!", StringFilter.removeAlphanumericOrWhitespaces("Hello World!123"));
    }

    @Test
    void removeSpecialChars_removesAllSpecialCharacters() {
        assertEquals("Hello World123", StringFilter.removeSpecialChars("Hello World!123"));
    }

    @Test
    void removeAscii_removesAllAsciiCharacters() {
        assertEquals("\u200B", StringFilter.removeAscii("Hello World!123\u200B"));
    }

    @Test
    void removeAsciiSpaces_removesAllAsciiSpaces() {
        assertEquals("HelloWorld!123", StringFilter.removeAsciiSpaces("Hello World!123"));
    }

    @Test
    void removeAsciiWhitespaces_removesAllAsciiWhitespaces() {
        assertEquals("HelloWorld!123", StringFilter.removeAsciiWhitespaces("Hello World!123"));
    }

    @Test
    void removeAsciiAlpha_removesAllAsciiAlphabeticCharacters() {
        assertEquals(" !123", StringFilter.removeAsciiAlpha("Hello World!123"));
    }

    @Test
    void removeAsciiAlphaLower_removesAllAsciiLowercaseAlphabeticCharacters() {
        assertEquals("H W!123", StringFilter.removeAsciiAlphaLower("Hello World!123"));
    }

    @Test
    void removeAsciiAlphaUpper_removesAllAsciiUppercaseAlphabeticCharacters() {
        assertEquals("ello orld!123", StringFilter.removeAsciiAlphaUpper("Hello World!123"));
    }

    @Test
    void removeAsciiNumeric_removesAllAsciiNumericCharacters() {
        assertEquals("Hello World!", StringFilter.removeAsciiNumeric("Hello World!123"));
    }

    @Test
    void removeAsciiAlphaOrSpaces_removesAllAsciiAlphabeticCharactersOrSpaces() {
        assertEquals("!123", StringFilter.removeAsciiAlphaOrSpaces("Hello World!123"));
    }

    @Test
    void removeAsciiAlphaOrWhitespaces_removesAllAsciiAlphabeticCharactersOrWhitespaces() {
        assertEquals("!123", StringFilter.removeAsciiAlphaOrWhitespaces("Hello World!123"));
    }

    @Test
    void removeAsciiAlphanumeric_removesAllAsciiAlphanumericCharacters() {
        assertEquals(" !", StringFilter.removeAsciiAlphanumeric("Hello World!123"));
    }

    @Test
    void removeAsciiAlphanumericOrSpaces_removesAllAsciiAlphanumericCharactersOrSpaces() {
        assertEquals("!", StringFilter.removeAsciiAlphanumericOrSpaces("Hello World!123"));
    }

    @Test
    void removeAsciiAlphanumericOrWhitespaces_removesAllAsciiAlphanumericCharactersOrWhitespaces() {
        assertEquals("!", StringFilter.removeAsciiAlphanumericOrWhitespaces("Hello World!123"));
    }

    @Test
    void countWhitespaces_countsCorrectly() {
        assertEquals(1, StringFilter.countWhitespaces("Hello World!123"));
    }

    @Test
    void countZeroWidthChars_countsCorrectly() {
        assertEquals(1, StringFilter.countZeroWidthChars("Hello\u200BWorld!"));
    }

    @Test
    void countLetters_countsCorrectly() {
        assertEquals(5, StringFilter.countLetters("Hello123!"));
    }

    @Test
    void countLowercase_countsCorrectly() {
        assertEquals(4, StringFilter.countLowercase("Hello123!"));
    }

    @Test
    void countUppercase_countsCorrectly() {
        assertEquals(1, StringFilter.countUppercase("Hello123!"));
    }

    @Test
    void countDigits_countsCorrectly() {
        assertEquals(3, StringFilter.countDigits("Hello123!"));
    }

    @Test
    void countLettersOrWhitespaces_countsCorrectly() {
        assertEquals(11, StringFilter.countLettersOrWhitespaces("Hello World!123"));
    }

    @Test
    void countLettersOrDigits_countsCorrectly() {
        assertEquals(13, StringFilter.countLettersOrDigits("Hello World!123"));
    }

    @Test
    void countLettersDigitsOrWhitespaces_countsCorrectly() {
        assertEquals(14, StringFilter.countLettersDigitsOrWhitespaces("Hello World!123"));
    }

    @Test
    void countAlphabetic_countsCorrectly() {
        assertEquals(5, StringFilter.countAlphabetic("Hello123!"));
    }

    @Test
    void countAlphabeticOrWhitespaces_countsCorrectly() {
        assertEquals(11, StringFilter.countAlphabeticOrWhitespaces("Hello World!123"));
    }

    @Test
    void countAlphabeticOrDigits_countsCorrectly() {
        assertEquals(13, StringFilter.countAlphabeticOrDigits("Hello World!123"));
    }

    @Test
    void countAlphanumericOrWhitespaces_countsCorrectly() {
        assertEquals(14, StringFilter.countAlphanumericOrWhitespaces("Hello World!123"));
    }

    @Test
    void countSpecialChars_countsCorrectly() {
        assertEquals(1, StringFilter.countSpecialChars("Hello World!123"));
    }

    @Test
    void countAscii_countsCorrectly() {
        assertEquals(15, StringFilter.countAscii("Hello World!123\u200B"));
    }

    @Test
    void countAsciiSpace_countsCorrectly() {
        assertEquals(1, StringFilter.countAsciiSpace("Hello World!123"));
    }

    @Test
    void countAsciiWhitespace_countsCorrectly() {
        assertEquals(1, StringFilter.countAsciiWhitespace("Hello World!123"));
    }

    @Test
    void countAsciiAlpha_countsCorrectly() {
        assertEquals(10, StringFilter.countAsciiAlpha("Hello World!123"));
    }

    @Test
    void countAsciiAlphaLower_countsCorrectly() {
        assertEquals(8, StringFilter.countAsciiAlphaLower("Hello World!123"));
    }

    @Test
    void countAsciiAlphaUpper_countsCorrectly() {
        assertEquals(2, StringFilter.countAsciiAlphaUpper("Hello World!123"));
    }

    @Test
    void countAsciiNumeric_countsCorrectly() {
        assertEquals(3, StringFilter.countAsciiNumeric("Hello World!123"));
    }

    @Test
    void countAsciiAlphanumeric_countsCorrectly() {
        assertEquals(13, StringFilter.countAsciiAlphanumeric("Hello World!123"));
    }

    @Test
    void countAsciiAlphanumericOrSpaces_countsCorrectly() {
        assertEquals(14, StringFilter.countAsciiAlphanumericOrSpaces("Hello World!123"));
    }

    @Test
    void countAsciiAlphanumericOrWhitespaces_countsCorrectly() {
        assertEquals(14, StringFilter.countAsciiAlphanumericOrWhitespaces("Hello World!123"));
    }

    @Test
    void countAsciiAlphaOrSpaces_countsCorrectly() {
        assertEquals(11, StringFilter.countAsciiAlphaOrSpaces("Hello World!123"));
    }

    @Test
    void countAsciiAlphaOrWhitespaces_countsCorrectly() {
        assertEquals(11, StringFilter.countAsciiAlphaOrWhitespaces("Hello World!123"));
    }
}