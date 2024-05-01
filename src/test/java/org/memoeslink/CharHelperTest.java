package org.memoeslink;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharHelperTest {

    @Test
    void defaultIfNull_returnsDefault_whenCharIsNull() {
        assertEquals('a', CharHelper.defaultIfNull('\0', 'a'));
    }

    @Test
    void defaultIfNull_returnsChar_whenCharIsNotNull() {
        assertEquals('b', CharHelper.defaultIfNull('b', 'a'));
    }

    @Test
    void equalsAny_returnsTrue_whenCharMatches() {
        assertTrue(CharHelper.equalsAny('a', 'a', 'b', 'c'));
    }

    @Test
    void equalsAny_returnsFalse_whenCharDoesNotMatch() {
        assertFalse(CharHelper.equalsAny('d', 'a', 'b', 'c'));
    }

    @Test
    void isNull_returnsTrue_whenCharIsNull() {
        assertTrue(CharHelper.isNull('\0'));
    }

    @Test
    void isNull_returnsFalse_whenCharIsNotNull() {
        assertFalse(CharHelper.isNull('a'));
    }

    @Test
    void isSpace_returnsTrue_whenCharIsSpace() {
        assertTrue(CharHelper.isSpace(' '));
    }

    @Test
    void isSpace_returnsFalse_whenCharIsNotSpace() {
        assertFalse(CharHelper.isSpace('a'));
    }

    @Test
    void isWhitespace_returnsTrue_whenCharIsWhitespace() {
        assertTrue(CharHelper.isWhitespace(' '));
    }

    @Test
    void isWhitespace_returnsFalse_whenCharIsNotWhitespace() {
        assertFalse(CharHelper.isWhitespace('a'));
    }

    @Test
    void isZeroWidthChar_returnsTrue_whenCharIsZeroWidth() {
        assertTrue(CharHelper.isZeroWidthChar('\u200B'));
    }

    @Test
    void isZeroWidthChar_returnsFalse_whenCharIsNotZeroWidth() {
        assertFalse(CharHelper.isZeroWidthChar('a'));
    }

    @Test
    void isLetter_returnsTrue_whenCharIsLetter() {
        assertTrue(CharHelper.isLetter('a'));
    }

    @Test
    void isLetter_returnsFalse_whenCharIsNotLetter() {
        assertFalse(CharHelper.isLetter('1'));
    }

    @Test
    void isLowercase_returnsTrue_whenCharIsLowercase() {
        assertTrue(CharHelper.isLowercase('a'));
    }

    @Test
    void isLowercase_returnsFalse_whenCharIsNotLowercase() {
        assertFalse(CharHelper.isLowercase('A'));
    }

    @Test
    void isUppercase_returnsTrue_whenCharIsUppercase() {
        assertTrue(CharHelper.isUppercase('Z'));
    }

    @Test
    void isUppercase_returnsFalse_whenCharIsNotUppercase() {
        assertFalse(CharHelper.isUppercase('z'));
    }

    @Test
    void isDigit_returnsTrue_whenCharIsDigit() {
        assertTrue(CharHelper.isDigit('5'));
    }

    @Test
    void isDigit_returnsFalse_whenCharIsNotDigit() {
        assertFalse(CharHelper.isDigit('a'));
    }

    @Test
    void isLetterOrWhitespace_returnsTrue_whenCharIsLetter() {
        assertTrue(CharHelper.isLetterOrWhitespace('A'));
    }

    @Test
    void isLetterOrWhitespace_returnsTrue_whenCharIsWhitespace() {
        assertTrue(CharHelper.isLetterOrWhitespace(' '));
    }

    @Test
    void isLetterOrWhitespace_returnsFalse_whenCharIsNeitherLetterNorWhitespace() {
        assertFalse(CharHelper.isLetterOrWhitespace('#'));
    }

    @Test
    void isLetterOrDigit_returnsTrue_whenCharIsLetter() {
        assertTrue(CharHelper.isLetterOrDigit('a'));
    }

    @Test
    void isLetterOrDigit_returnsTrue_whenCharIsDigit() {
        assertTrue(CharHelper.isLetterOrDigit('1'));
    }

    @Test
    void isLetterOrDigit_returnsFalse_whenCharIsNeitherLetterNorDigit() {
        assertFalse(CharHelper.isLetterOrDigit('#'));
    }

    @Test
    void isLetterDigitOrWhitespace_returnsTrue_whenCharIsLetter() {
        assertTrue(CharHelper.isLetterDigitOrWhitespace('a'));
    }

    @Test
    void isLetterDigitOrWhitespace_returnsTrue_whenCharIsDigit() {
        assertTrue(CharHelper.isLetterDigitOrWhitespace('1'));
    }

    @Test
    void isLetterDigitOrWhitespace_returnsTrue_whenCharIsWhitespace() {
        assertTrue(CharHelper.isLetterDigitOrWhitespace(' '));
    }

    @Test
    void isLetterDigitOrWhitespace_returnsFalse_whenCharIsSpecialChar() {
        assertFalse(CharHelper.isLetterDigitOrWhitespace('#'));
    }

    @Test
    void isAlphabetic_returnsTrue_whenCharIsAlphabetic() {
        assertTrue(CharHelper.isAlphabetic('a'));
    }

    @Test
    void isAlphabetic_returnsFalse_whenCharIsNotAlphabetic() {
        assertFalse(CharHelper.isAlphabetic('1'));
    }

    @Test
    void isAlphabeticOrWhitespace_returnsTrue_whenCharIsAlphabetic() {
        assertTrue(CharHelper.isAlphabeticOrWhitespace('a'));
    }

    @Test
    void isAlphabeticOrWhitespace_returnsTrue_whenCharIsWhitespace() {
        assertTrue(CharHelper.isAlphabeticOrWhitespace(' '));
    }

    @Test
    void isAlphabeticOrWhitespace_returnsFalse_whenCharIsSpecialChar() {
        assertFalse(CharHelper.isAlphabeticOrWhitespace('#'));
    }

    @Test
    void isAlphabeticOrDigit_returnsTrue_whenCharIsAlphabetic() {
        assertTrue(CharHelper.isAlphabeticOrDigit('a'));
    }

    @Test
    void isAlphabeticOrDigit_returnsTrue_whenCharIsDigit() {
        assertTrue(CharHelper.isAlphabeticOrDigit('1'));
    }

    @Test
    void isAlphabeticOrDigit_returnsFalse_whenCharIsSpecialChar() {
        assertFalse(CharHelper.isAlphabeticOrDigit('#'));
    }

    @Test
    void isAlphanumericOrWhitespace_returnsTrue_whenCharIsAlphanumeric() {
        assertTrue(CharHelper.isAlphanumericOrWhitespace('A'));
    }

    @Test
    void isAlphanumericOrWhitespace_returnsTrue_whenCharIsWhitespace() {
        assertTrue(CharHelper.isAlphanumericOrWhitespace(' '));
    }

    @Test
    void isAlphanumericOrWhitespace_returnsFalse_whenCharIsSpecialChar() {
        assertFalse(CharHelper.isAlphanumericOrWhitespace('#'));
    }

    @Test
    void isSpecialChar_returnsTrue_whenCharIsSpecialChar() {
        assertTrue(CharHelper.isSpecialChar('#'));
    }

    @Test
    void isSpecialChar_returnsFalse_whenCharIsAlphanumeric() {
        assertFalse(CharHelper.isSpecialChar('A'));
    }

    @Test
    void isSpecialChar_returnsFalse_whenCharIsWhitespace() {
        assertFalse(CharHelper.isSpecialChar(' '));
    }

    @Test
    void isDiacritic_returnsTrue_whenCharIsDiacritic() {
        assertTrue(CharHelper.isDiacritic('^'));
    }

    @Test
    void isDiacritic_returnsFalse_whenCharIsNotDiacritic() {
        assertFalse(CharHelper.isDiacritic('a'));
    }

    @Test
    void isConsonant_returnsTrue_whenCharIsConsonant() {
        assertTrue(CharHelper.isConsonant('b'));
    }

    @Test
    void isConsonant_returnsFalse_whenCharIsVowel() {
        assertFalse(CharHelper.isConsonant('a'));
    }

    @Test
    void isVowel_returnsTrue_whenCharIsVowel() {
        assertTrue(CharHelper.isVowel('a'));
    }

    @Test
    void isVowel_returnsFalse_whenCharIsConsonant() {
        assertFalse(CharHelper.isVowel('b'));
    }

    @Test
    void isGlobalLetter_returnsTrue_whenCharIsGlobalLetter() {
        assertTrue(CharHelper.isGlobalLetter('a'));
        assertTrue(CharHelper.isGlobalLetter('A'));
        assertTrue(CharHelper.isGlobalLetter('ç'));
    }

    @Test
    void isGlobalLetter_returnsFalse_whenCharIsNotGlobalLetter() {
        assertFalse(CharHelper.isGlobalLetter('1'));
        assertFalse(CharHelper.isGlobalLetter('#'));
    }

    @Test
    void isGlobalConsonant_returnsTrue_whenCharIsGlobalConsonant() {
        assertTrue(CharHelper.isGlobalConsonant('b'));
        assertTrue(CharHelper.isGlobalConsonant('B'));
        assertTrue(CharHelper.isGlobalConsonant('ç'));
    }

    @Test
    void isGlobalConsonant_returnsFalse_whenCharIsNotGlobalConsonant() {
        assertFalse(CharHelper.isGlobalConsonant('a'));
        assertFalse(CharHelper.isGlobalConsonant('1'));
        assertFalse(CharHelper.isGlobalConsonant('#'));
    }

    @Test
    void isGlobalVowel_returnsTrue_whenCharIsGlobalVowel() {
        assertTrue(CharHelper.isGlobalVowel('a'));
        assertTrue(CharHelper.isGlobalVowel('A'));
        assertTrue(CharHelper.isGlobalVowel('é'));
    }

    @Test
    void isGlobalVowel_returnsFalse_whenCharIsNotGlobalVowel() {
        assertFalse(CharHelper.isGlobalVowel('b'));
        assertFalse(CharHelper.isGlobalVowel('1'));
        assertFalse(CharHelper.isGlobalVowel('#'));
    }

    @Test
    void isNonClusterConsonant_returnsTrue_whenCharIsNonClusterConsonant() {
        assertTrue(CharHelper.isNonClusterConsonant('h'));
    }

    @Test
    void isNonClusterConsonant_returnsFalse_whenCharIsNotNonClusterConsonant() {
        assertFalse(CharHelper.isNonClusterConsonant('b'));
        assertFalse(CharHelper.isNonClusterConsonant('1'));
        assertFalse(CharHelper.isNonClusterConsonant('#'));
    }

    @Test
    void isAccentedLetter_returnsTrue_whenCharIsAccentedLetter() {
        assertTrue(CharHelper.isAccentedLetter('é'));
    }

    @Test
    void isAccentedLetter_returnsFalse_whenCharIsUnaccentedLetter() {
        assertFalse(CharHelper.isAccentedLetter('e'));
    }

    @Test
    void isUnaccentedLetter_returnsTrue_whenCharIsUnaccentedLetter() {
        assertTrue(CharHelper.isUnaccentedLetter('e'));
    }

    @Test
    void isUnaccentedLetter_returnsFalse_whenCharIsAccentedLetter() {
        assertFalse(CharHelper.isUnaccentedLetter('é'));
    }

    @Test
    void isAccentedConsonant_returnsTrue_whenCharIsAccentedConsonant() {
        assertTrue(CharHelper.isAccentedConsonant('ç'));
    }

    @Test
    void isAccentedConsonant_returnsFalse_whenCharIsUnaccentedConsonant() {
        assertFalse(CharHelper.isAccentedConsonant('c'));
    }

    @Test
    void isUnaccentedConsonant_returnsTrue_whenCharIsUnaccentedConsonant() {
        assertTrue(CharHelper.isUnaccentedConsonant('c'));
    }

    @Test
    void isUnaccentedConsonant_returnsFalse_whenCharIsAccentedConsonant() {
        assertFalse(CharHelper.isUnaccentedConsonant('ç'));
    }

    @Test
    void isAccentedVowel_returnsTrue_whenCharIsAccentedVowel() {
        assertTrue(CharHelper.isAccentedVowel('é'));
    }

    @Test
    void isAccentedVowel_returnsFalse_whenCharIsUnaccentedVowel() {
        assertFalse(CharHelper.isAccentedVowel('e'));
    }

    @Test
    void isUnaccentedVowel_returnsTrue_whenCharIsUnaccentedVowel() {
        assertTrue(CharHelper.isUnaccentedVowel('e'));
    }

    @Test
    void isUnaccentedVowel_returnsFalse_whenCharIsAccentedVowel() {
        assertFalse(CharHelper.isUnaccentedVowel('é'));
    }

    @Test
    void isSpecialLetter_returnsTrue_whenCharIsSpecialLetter() {
        assertTrue(CharHelper.isSpecialLetter('ҍ'));
    }

    @Test
    void isSpecialLetter_returnsFalse_whenCharIsVowel() {
        assertFalse(CharHelper.isSpecialLetter('a'));
    }

    @Test
    void isSpecialLetter_returnsFalse_whenCharIsConsonant() {
        assertFalse(CharHelper.isSpecialLetter('b'));
    }

    @Test
    void isDelimiter_returnsTrue_whenCharIsDelimiter() {
        assertTrue(CharHelper.isDelimiter('_'));
        assertTrue(CharHelper.isDelimiter('-'));
        assertTrue(CharHelper.isDelimiter(' '));
    }

    @Test
    void isDelimiter_returnsFalse_whenCharIsNotDelimiter() {
        assertFalse(CharHelper.isDelimiter('a'));
    }

    @Test
    void isAscii_returnsTrue_whenCharIsAscii() {
        assertTrue(CharHelper.isAscii('A'));
        assertTrue(CharHelper.isAscii(65));
    }

    @Test
    void isAscii_returnsFalse_whenCharIsNotAscii() {
        assertFalse(CharHelper.isAscii('Ā'));
        assertFalse(CharHelper.isAscii(256));
    }

    @Test
    void isAsciiSpace_returnsTrue_whenCharIsAsciiSpace() {
        assertTrue(CharHelper.isAsciiSpace(' '));
        assertTrue(CharHelper.isAsciiSpace(32));
    }

    @Test
    void isAsciiSpace_returnsFalse_whenCharIsNotAsciiSpace() {
        assertFalse(CharHelper.isAsciiSpace('A'));
        assertFalse(CharHelper.isAsciiSpace(65));
    }

    @Test
    void isAsciiWhitespace_returnsTrue_whenCharIsAsciiWhitespace() {
        assertTrue(CharHelper.isAsciiWhitespace(' '));
        assertTrue(CharHelper.isAsciiWhitespace('\t'));
        assertTrue(CharHelper.isAsciiWhitespace('\n'));
        assertTrue(CharHelper.isAsciiWhitespace('\r'));
        assertTrue(CharHelper.isAsciiWhitespace(32));
        assertTrue(CharHelper.isAsciiWhitespace(9));
        assertTrue(CharHelper.isAsciiWhitespace(10));
        assertTrue(CharHelper.isAsciiWhitespace(13));
    }

    @Test
    void isAsciiWhitespace_returnsFalse_whenCharIsNotAsciiWhitespace() {
        assertFalse(CharHelper.isAsciiWhitespace('A'));
        assertFalse(CharHelper.isAsciiWhitespace(65));
    }

    @Test
    void isAsciiAlpha_returnsTrue_whenCharIsAsciiAlpha() {
        assertTrue(CharHelper.isAsciiAlpha('A'));
        assertTrue(CharHelper.isAsciiAlpha('z'));
    }

    @Test
    void isAsciiAlpha_returnsFalse_whenCharIsNotAsciiAlpha() {
        assertFalse(CharHelper.isAsciiAlpha('1'));
        assertFalse(CharHelper.isAsciiAlpha('!'));
    }

    @Test
    void isAsciiAlphaLower_returnsTrue_whenCharIsAsciiAlphaLower() {
        assertTrue(CharHelper.isAsciiAlphaLower('a'));
        assertTrue(CharHelper.isAsciiAlphaLower('z'));
    }

    @Test
    void isAsciiAlphaLower_returnsFalse_whenCharIsNotAsciiAlphaLower() {
        assertFalse(CharHelper.isAsciiAlphaLower('A'));
        assertFalse(CharHelper.isAsciiAlphaLower('Z'));
        assertFalse(CharHelper.isAsciiAlphaLower('1'));
    }

    @Test
    void isAsciiAlphaUpper_returnsTrue_whenCharIsAsciiAlphaUpper() {
        assertTrue(CharHelper.isAsciiAlphaUpper('A'));
        assertTrue(CharHelper.isAsciiAlphaUpper('Z'));
    }

    @Test
    void isAsciiAlphaUpper_returnsFalse_whenCharIsNotAsciiAlphaUpper() {
        assertFalse(CharHelper.isAsciiAlphaUpper('a'));
        assertFalse(CharHelper.isAsciiAlphaUpper('z'));
        assertFalse(CharHelper.isAsciiAlphaUpper('1'));
    }

    @Test
    void isAsciiNumeric_returnsTrue_whenCharIsNumeric() {
        assertTrue(CharHelper.isAsciiNumeric('5'));
    }

    @Test
    void isAsciiNumeric_returnsFalse_whenCharIsNotNumeric() {
        assertFalse(CharHelper.isAsciiNumeric('a'));
    }

    @Test
    void isAsciiAlphaOrSpace_returnsTrue_whenCharIsAlpha() {
        assertTrue(CharHelper.isAsciiAlphaOrSpace('A'));
    }

    @Test
    void isAsciiAlphaOrSpace_returnsTrue_whenCharIsSpace() {
        assertTrue(CharHelper.isAsciiAlphaOrSpace(' '));
    }

    @Test
    void isAsciiAlphaOrSpace_returnsFalse_whenCharIsSpecialChar() {
        assertFalse(CharHelper.isAsciiAlphaOrSpace('#'));
    }

    @Test
    void isAsciiAlphaOrWhitespace_returnsTrue_whenCharIsAlpha() {
        assertTrue(CharHelper.isAsciiAlphaOrWhitespace('A'));
    }

    @Test
    void isAsciiAlphaOrWhitespace_returnsTrue_whenCharIsWhitespace() {
        assertTrue(CharHelper.isAsciiAlphaOrWhitespace('\t'));
    }

    @Test
    void isAsciiAlphaOrWhitespace_returnsFalse_whenCharIsSpecialChar() {
        assertFalse(CharHelper.isAsciiAlphaOrWhitespace('#'));
    }

    @Test
    void isAsciiAlphanumeric_returnsTrue_whenCharIsAlpha() {
        assertTrue(CharHelper.isAsciiAlphanumeric('A'));
    }

    @Test
    void isAsciiAlphanumeric_returnsTrue_whenCharIsNumeric() {
        assertTrue(CharHelper.isAsciiAlphanumeric('5'));
    }

    @Test
    void isAsciiAlphanumeric_returnsFalse_whenCharIsSpecialChar() {
        assertFalse(CharHelper.isAsciiAlphanumeric('#'));
    }

    @Test
    void isAsciiAlphanumericOrSpace_returnsTrue_whenCharIsAlphanumericOrSpace() {
        assertTrue(CharHelper.isAsciiAlphanumericOrSpace('A'));
        assertTrue(CharHelper.isAsciiAlphanumericOrSpace('5'));
        assertTrue(CharHelper.isAsciiAlphanumericOrSpace(' '));
    }

    @Test
    void isAsciiAlphanumericOrSpace_returnsFalse_whenCharIsNotAlphanumericOrSpace() {
        assertFalse(CharHelper.isAsciiAlphanumericOrSpace('#'));
    }

    @Test
    void isAsciiAlphanumericOrWhitespace_returnsTrue_whenCharIsAlphanumericOrWhitespace() {
        assertTrue(CharHelper.isAsciiAlphanumericOrWhitespace('A'));
        assertTrue(CharHelper.isAsciiAlphanumericOrWhitespace('5'));
        assertTrue(CharHelper.isAsciiAlphanumericOrWhitespace(' '));
        assertTrue(CharHelper.isAsciiAlphanumericOrWhitespace('\t'));
    }

    @Test
    void isAsciiAlphanumericOrWhitespace_returnsFalse_whenCharIsNotAlphanumericOrWhitespace() {
        assertFalse(CharHelper.isAsciiAlphanumericOrWhitespace('#'));
    }

    @Test
    void getHexDigit_returnsHexDigit_whenValueIsWithinRange() {
        assertEquals('a', CharHelper.getHexDigit(10));
        assertEquals('f', CharHelper.getHexDigit(15));
    }

    @Test
    void getHexDigit_returnsZero_whenValueIsNegative() {
        assertEquals('0', CharHelper.getHexDigit(-1));
    }

    @Test
    void getHexDigit_returnsCorrectHexDigit_whenValueIsAboveRange() {
        assertEquals('a', CharHelper.getHexDigit(26));
    }
}
