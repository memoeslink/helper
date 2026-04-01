package org.memoeslink;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharHelperTest {

    @Nested
    class DefaultIfNull {

        @Test
        void withNullChar_returnsDefault() {
            assertEquals('a', CharHelper.defaultIfNull('\0', 'a'));
        }

        @Test
        void withNonNullChar_returnsOriginal() {
            assertEquals('b', CharHelper.defaultIfNull('b', 'a'));
        }

        @Test
        void withNullCharAndNullDefault_returnsNullChar() {
            assertEquals('\0', CharHelper.defaultIfNull('\0', '\0'));
        }
    }

    @Nested
    class EqualsAny {

        @Test
        void withNullArray_returnsFalse() {
            assertFalse(CharHelper.equalsAny('a', (char[]) null));
        }

        @Test
        void withMatchingChar_returnsTrue() {
            assertTrue(CharHelper.equalsAny('b', 'a', 'b', 'c'));
        }

        @Test
        void withNoMatchingChar_returnsFalse() {
            assertFalse(CharHelper.equalsAny('z', 'a', 'b', 'c'));
        }

        @Test
        void withEmptyArray_returnsFalse() {
            assertFalse(CharHelper.equalsAny('a', new char[]{}));
        }
    }

    @Nested
    class IsNull {

        @Test
        void withNullChar_returnsTrue() {
            assertTrue(CharHelper.isNull('\0'));
        }

        @Test
        void withNonNullChar_returnsFalse() {
            assertFalse(CharHelper.isNull('a'));
        }

        @Test
        void withNullCharAsInt_returnsTrue() {
            assertTrue(CharHelper.isNull(0));
        }

        @Test
        void withNonNullCharAsInt_returnsFalse() {
            assertFalse(CharHelper.isNull((int) 'a'));
        }
    }

    @Nested
    class IsSpace {

        @Test
        void withSpace_returnsTrue() {
            assertTrue(CharHelper.isSpace(' '));
        }

        @Test
        void withTab_returnsFalse() {
            assertFalse(CharHelper.isSpace('\t'));
        }

        @Test
        void withLetter_returnsFalse() {
            assertFalse(CharHelper.isSpace('a'));
        }

        @Test
        void withNullChar_returnsFalse() {
            assertFalse(CharHelper.isSpace('\0'));
        }
    }

    @Nested
    class IsWhitespace {

        @Test
        void withSpace_returnsTrue() {
            assertTrue(CharHelper.isWhitespace(' '));
        }

        @Test
        void withTab_returnsTrue() {
            assertTrue(CharHelper.isWhitespace('\t'));
        }

        @Test
        void withNewline_returnsTrue() {
            assertTrue(CharHelper.isWhitespace('\n'));
        }

        @Test
        void withLetter_returnsFalse() {
            assertFalse(CharHelper.isWhitespace('a'));
        }

        @Test
        void withNullChar_returnsFalse() {
            assertFalse(CharHelper.isWhitespace('\0'));
        }
    }

    @Nested
    class IsZeroWidthChar {

        @Test
        void withZeroWidthSpace_returnsTrue() {
            assertTrue(CharHelper.isZeroWidthChar('\u200B'));
        }

        @Test
        void withZeroWidthNonJoiner_returnsTrue() {
            assertTrue(CharHelper.isZeroWidthChar('\u200C'));
        }

        @Test
        void withZeroWidthJoiner_returnsTrue() {
            assertTrue(CharHelper.isZeroWidthChar('\u200D'));
        }

        @Test
        void withWordJoiner_returnsTrue() {
            assertTrue(CharHelper.isZeroWidthChar('\u2060'));
        }

        @Test
        void withBom_returnsTrue() {
            assertTrue(CharHelper.isZeroWidthChar('\uFEFF'));
        }

        @Test
        void withLetter_returnsFalse() {
            assertFalse(CharHelper.isZeroWidthChar('a'));
        }

        @Test
        void withNullChar_returnsFalse() {
            assertFalse(CharHelper.isZeroWidthChar('\0'));
        }
    }

    @Nested
    class IsLetter {

        @Test
        void withLetter_returnsTrue() {
            assertTrue(CharHelper.isLetter('a'));
        }

        @Test
        void withAccentedLetter_returnsTrue() {
            assertTrue(CharHelper.isLetter('é'));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(CharHelper.isLetter('1'));
        }

        @Test
        void withSpecialChar_returnsFalse() {
            assertFalse(CharHelper.isLetter('!'));
        }

        @Test
        void withNullChar_returnsFalse() {
            assertFalse(CharHelper.isLetter('\0'));
        }
    }

    @Nested
    class IsLowercase {

        @Test
        void withLowercaseLetter_returnsTrue() {
            assertTrue(CharHelper.isLowercase('a'));
        }

        @Test
        void withUppercaseLetter_returnsFalse() {
            assertFalse(CharHelper.isLowercase('A'));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(CharHelper.isLowercase('1'));
        }

        @Test
        void withNullChar_returnsFalse() {
            assertFalse(CharHelper.isLowercase('\0'));
        }
    }

    @Nested
    class IsUppercase {

        @Test
        void withUppercaseLetter_returnsTrue() {
            assertTrue(CharHelper.isUppercase('A'));
        }

        @Test
        void withLowercaseLetter_returnsFalse() {
            assertFalse(CharHelper.isUppercase('a'));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(CharHelper.isUppercase('1'));
        }

        @Test
        void withNullChar_returnsFalse() {
            assertFalse(CharHelper.isUppercase('\0'));
        }
    }

    @Nested
    class IsDigit {

        @Test
        void withDigit_returnsTrue() {
            assertTrue(CharHelper.isDigit('5'));
        }

        @Test
        void withLetter_returnsFalse() {
            assertFalse(CharHelper.isDigit('a'));
        }

        @Test
        void withSpecialChar_returnsFalse() {
            assertFalse(CharHelper.isDigit('!'));
        }

        @Test
        void withNullChar_returnsFalse() {
            assertFalse(CharHelper.isDigit('\0'));
        }
    }

    @Nested
    class IsLetterOrWhitespace {

        @Test
        void withLetter_returnsTrue() {
            assertTrue(CharHelper.isLetterOrWhitespace('a'));
        }

        @Test
        void withWhitespace_returnsTrue() {
            assertTrue(CharHelper.isLetterOrWhitespace(' '));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(CharHelper.isLetterOrWhitespace('1'));
        }

        @Test
        void withSpecialChar_returnsFalse() {
            assertFalse(CharHelper.isLetterOrWhitespace('!'));
        }
    }

    @Nested
    class IsLetterOrDigit {

        @Test
        void withLetter_returnsTrue() {
            assertTrue(CharHelper.isLetterOrDigit('a'));
        }

        @Test
        void withDigit_returnsTrue() {
            assertTrue(CharHelper.isLetterOrDigit('1'));
        }

        @Test
        void withWhitespace_returnsFalse() {
            assertFalse(CharHelper.isLetterOrDigit(' '));
        }

        @Test
        void withSpecialChar_returnsFalse() {
            assertFalse(CharHelper.isLetterOrDigit('!'));
        }
    }

    @Nested
    class IsLetterDigitOrWhitespace {

        @Test
        void withLetter_returnsTrue() {
            assertTrue(CharHelper.isLetterDigitOrWhitespace('a'));
        }

        @Test
        void withDigit_returnsTrue() {
            assertTrue(CharHelper.isLetterDigitOrWhitespace('1'));
        }

        @Test
        void withWhitespace_returnsTrue() {
            assertTrue(CharHelper.isLetterDigitOrWhitespace(' '));
        }

        @Test
        void withSpecialChar_returnsFalse() {
            assertFalse(CharHelper.isLetterDigitOrWhitespace('!'));
        }
    }

    @Nested
    class IsAlphabetic {

        @Test
        void withLatinLetter_returnsTrue() {
            assertTrue(CharHelper.isAlphabetic('a'));
        }

        @Test
        void withNonLatinLetter_returnsTrue() {
            assertTrue(CharHelper.isAlphabetic('ñ'));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(CharHelper.isAlphabetic('1'));
        }

        @Test
        void withSpecialChar_returnsFalse() {
            assertFalse(CharHelper.isAlphabetic('!'));
        }
    }

    @Nested
    class IsAlphabeticOrWhitespace {

        @Test
        void withLetter_returnsTrue() {
            assertTrue(CharHelper.isAlphabeticOrWhitespace('a'));
        }

        @Test
        void withWhitespace_returnsTrue() {
            assertTrue(CharHelper.isAlphabeticOrWhitespace(' '));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(CharHelper.isAlphabeticOrWhitespace('1'));
        }

        @Test
        void withSpecialChar_returnsFalse() {
            assertFalse(CharHelper.isAlphabeticOrWhitespace('!'));
        }
    }

    @Nested
    class IsAlphabeticOrDigit {

        @Test
        void withLetter_returnsTrue() {
            assertTrue(CharHelper.isAlphabeticOrDigit('a'));
        }

        @Test
        void withDigit_returnsTrue() {
            assertTrue(CharHelper.isAlphabeticOrDigit('1'));
        }

        @Test
        void withWhitespace_returnsFalse() {
            assertFalse(CharHelper.isAlphabeticOrDigit(' '));
        }

        @Test
        void withSpecialChar_returnsFalse() {
            assertFalse(CharHelper.isAlphabeticOrDigit('!'));
        }
    }

    @Nested
    class IsAlphanumericOrWhitespace {

        @Test
        void withLetter_returnsTrue() {
            assertTrue(CharHelper.isAlphanumericOrWhitespace('a'));
        }

        @Test
        void withDigit_returnsTrue() {
            assertTrue(CharHelper.isAlphanumericOrWhitespace('1'));
        }

        @Test
        void withWhitespace_returnsTrue() {
            assertTrue(CharHelper.isAlphanumericOrWhitespace(' '));
        }

        @Test
        void withSpecialChar_returnsFalse() {
            assertFalse(CharHelper.isAlphanumericOrWhitespace('!'));
        }
    }

    @Nested
    class IsSpecialChar {

        @Test
        void withSpecialChar_returnsTrue() {
            assertTrue(CharHelper.isSpecialChar('!'));
        }

        @Test
        void withLetter_returnsFalse() {
            assertFalse(CharHelper.isSpecialChar('a'));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(CharHelper.isSpecialChar('1'));
        }

        @Test
        void withWhitespace_returnsFalse() {
            assertFalse(CharHelper.isSpecialChar(' '));
        }
    }

    @Nested
    class IsDiacritic {

        @Test
        void withNullChar_returnsFalse() {
            assertFalse(CharHelper.isDiacritic('\0'));
        }

        @Test
        void withDiacriticChar_returnsTrue() {
            assertTrue(CharHelper.isDiacritic('\u0301'));
        }

        @Test
        void withLetter_returnsFalse() {
            assertFalse(CharHelper.isDiacritic('a'));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(CharHelper.isDiacritic('1'));
        }
    }

    @Nested
    class IsConsonant {

        @Test
        void withNullChar_returnsFalse() {
            assertFalse(CharHelper.isConsonant('\0'));
        }

        @Test
        void withConsonant_returnsTrue() {
            assertTrue(CharHelper.isConsonant('b'));
        }

        @Test
        void withUppercaseConsonant_returnsTrue() {
            assertTrue(CharHelper.isConsonant('B'));
        }

        @Test
        void withVowel_returnsFalse() {
            assertFalse(CharHelper.isConsonant('a'));
        }

        @Test
        void withAccentedConsonant_returnsTrue() {
            assertTrue(CharHelper.isConsonant('ñ'));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(CharHelper.isConsonant('1'));
        }
    }

    @Nested
    class IsVowel {

        @Test
        void withNullChar_returnsFalse() {
            assertFalse(CharHelper.isVowel('\0'));
        }

        @Test
        void withVowel_returnsTrue() {
            assertTrue(CharHelper.isVowel('a'));
        }

        @Test
        void withUppercaseVowel_returnsTrue() {
            assertTrue(CharHelper.isVowel('A'));
        }

        @Test
        void withConsonant_returnsFalse() {
            assertFalse(CharHelper.isVowel('b'));
        }

        @Test
        void withAccentedVowel_returnsTrue() {
            assertTrue(CharHelper.isVowel('é'));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(CharHelper.isVowel('1'));
        }
    }

    @Nested
    class IsGlobalLetter {

        @Test
        void withLatinLetter_returnsTrue() {
            assertTrue(CharHelper.isGlobalLetter('a'));
        }

        @Test
        void withGlobalConsonant_returnsTrue() {
            assertTrue(CharHelper.isGlobalLetter('ñ'));
        }

        @Test
        void withGlobalVowel_returnsTrue() {
            assertTrue(CharHelper.isGlobalLetter('é'));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(CharHelper.isGlobalLetter('1'));
        }

        @Test
        void withSpecialChar_returnsFalse() {
            assertFalse(CharHelper.isGlobalLetter('!'));
        }
    }

    @Nested
    class IsGlobalConsonant {

        @Test
        void withConsonant_returnsTrue() {
            assertTrue(CharHelper.isGlobalConsonant('b'));
        }

        @Test
        void withGlobalConsonant_returnsTrue() {
            assertTrue(CharHelper.isGlobalConsonant('ñ'));
        }

        @Test
        void withVowel_returnsFalse() {
            assertFalse(CharHelper.isGlobalConsonant('a'));
        }

        @Test
        void withGlobalVowel_returnsFalse() {
            assertFalse(CharHelper.isGlobalConsonant('é'));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(CharHelper.isGlobalConsonant('1'));
        }
    }

    @Nested
    class IsGlobalVowel {

        @Test
        void withVowel_returnsTrue() {
            assertTrue(CharHelper.isGlobalVowel('a'));
        }

        @Test
        void withAccentedVowel_returnsTrue() {
            assertTrue(CharHelper.isGlobalVowel('é'));
        }

        @Test
        void withConsonant_returnsFalse() {
            assertFalse(CharHelper.isGlobalVowel('b'));
        }

        @Test
        void withGlobalConsonant_returnsFalse() {
            assertFalse(CharHelper.isGlobalVowel('ñ'));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(CharHelper.isGlobalVowel('1'));
        }
    }

    @Nested
    class IsNonClusterConsonant {

        @Test
        void withNonClusterConsonant_returnsTrue() {
            assertTrue(CharHelper.isNonClusterConsonant('h'));
        }

        @Test
        void withUppercaseNonClusterConsonant_returnsTrue() {
            assertTrue(CharHelper.isNonClusterConsonant('H'));
        }

        @Test
        void withGlobalNonClusterConsonant_returnsTrue() {
            assertTrue(CharHelper.isNonClusterConsonant('ñ'));
        }

        @Test
        void withClusterConsonant_returnsFalse() {
            assertFalse(CharHelper.isNonClusterConsonant('b'));
        }

        @Test
        void withVowel_returnsFalse() {
            assertFalse(CharHelper.isNonClusterConsonant('a'));
        }
    }

    @Nested
    class IsAccentedLetter {

        @Test
        void withNullChar_returnsFalse() {
            assertFalse(CharHelper.isAccentedLetter('\0'));
        }

        @Test
        void withAccentedLetter_returnsTrue() {
            assertTrue(CharHelper.isAccentedLetter('é'));
        }

        @Test
        void withAccentedConsonant_returnsTrue() {
            assertTrue(CharHelper.isAccentedLetter('ñ'));
        }

        @Test
        void withUnaccentedLetter_returnsFalse() {
            assertFalse(CharHelper.isAccentedLetter('a'));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(CharHelper.isAccentedLetter('1'));
        }
    }

    @Nested
    class IsUnaccentedLetter {

        @Test
        void withUnaccentedLetter_returnsTrue() {
            assertTrue(CharHelper.isUnaccentedLetter('a'));
        }

        @Test
        void withAccentedLetter_returnsFalse() {
            assertFalse(CharHelper.isUnaccentedLetter('é'));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(CharHelper.isUnaccentedLetter('1'));
        }

        @Test
        void withSpecialChar_returnsFalse() {
            assertFalse(CharHelper.isUnaccentedLetter('!'));
        }
    }

    @Nested
    class IsAccentedConsonant {

        @Test
        void withNullChar_returnsFalse() {
            assertFalse(CharHelper.isAccentedConsonant('\0'));
        }

        @Test
        void withAccentedConsonant_returnsTrue() {
            assertTrue(CharHelper.isAccentedConsonant('ñ'));
        }

        @Test
        void withUnaccentedConsonant_returnsFalse() {
            assertFalse(CharHelper.isAccentedConsonant('b'));
        }

        @Test
        void withAccentedVowel_returnsFalse() {
            assertFalse(CharHelper.isAccentedConsonant('é'));
        }
    }

    @Nested
    class IsUnaccentedConsonant {

        @Test
        void withUnaccentedConsonant_returnsTrue() {
            assertTrue(CharHelper.isUnaccentedConsonant('b'));
        }

        @Test
        void withUppercaseUnaccentedConsonant_returnsTrue() {
            assertTrue(CharHelper.isUnaccentedConsonant('B'));
        }

        @Test
        void withAccentedConsonant_returnsFalse() {
            assertFalse(CharHelper.isUnaccentedConsonant('ñ'));
        }

        @Test
        void withVowel_returnsFalse() {
            assertFalse(CharHelper.isUnaccentedConsonant('a'));
        }
    }

    @Nested
    class IsAccentedVowel {

        @Test
        void withNullChar_returnsFalse() {
            assertFalse(CharHelper.isAccentedVowel('\0'));
        }

        @Test
        void withAccentedVowel_returnsTrue() {
            assertTrue(CharHelper.isAccentedVowel('é'));
        }

        @Test
        void withUnaccentedVowel_returnsFalse() {
            assertFalse(CharHelper.isAccentedVowel('a'));
        }

        @Test
        void withAccentedConsonant_returnsFalse() {
            assertFalse(CharHelper.isAccentedVowel('ñ'));
        }
    }

    @Nested
    class IsUnaccentedVowel {

        @Test
        void withUnaccentedVowel_returnsTrue() {
            assertTrue(CharHelper.isUnaccentedVowel('a'));
        }

        @Test
        void withUppercaseUnaccentedVowel_returnsTrue() {
            assertTrue(CharHelper.isUnaccentedVowel('A'));
        }

        @Test
        void withAccentedVowel_returnsFalse() {
            assertFalse(CharHelper.isUnaccentedVowel('é'));
        }

        @Test
        void withConsonant_returnsFalse() {
            assertFalse(CharHelper.isUnaccentedVowel('b'));
        }
    }

    @Nested
    class IsSpecialLetter {

        @Test
        void withSpecialLetter_returnsTrue() {
            assertTrue(CharHelper.isSpecialLetter('中'));
        }

        @Test
        void withVowel_returnsFalse() {
            assertFalse(CharHelper.isSpecialLetter('a'));
        }

        @Test
        void withConsonant_returnsFalse() {
            assertFalse(CharHelper.isSpecialLetter('b'));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(CharHelper.isSpecialLetter('1'));
        }
    }

    @Nested
    class IsDelimiter {

        @Test
        void withSpace_returnsTrue() {
            assertTrue(CharHelper.isDelimiter(' '));
        }

        @Test
        void withUnderscore_returnsTrue() {
            assertTrue(CharHelper.isDelimiter('_'));
        }

        @Test
        void withHyphen_returnsTrue() {
            assertTrue(CharHelper.isDelimiter('-'));
        }

        @Test
        void withLetter_returnsFalse() {
            assertFalse(CharHelper.isDelimiter('a'));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(CharHelper.isDelimiter('1'));
        }

        @Test
        void withSpecialChar_returnsFalse() {
            assertFalse(CharHelper.isDelimiter('!'));
        }
    }

    @Nested
    class IsAscii {

        @Test
        void withAsciiLetter_returnsTrue() {
            assertTrue(CharHelper.isAscii('a'));
        }

        @Test
        void withAsciiDigit_returnsTrue() {
            assertTrue(CharHelper.isAscii('1'));
        }

        @Test
        void withAsciiSpecialChar_returnsTrue() {
            assertTrue(CharHelper.isAscii('!'));
        }

        @Test
        void withNonAsciiChar_returnsFalse() {
            assertFalse(CharHelper.isAscii('é'));
        }

        @Test
        void withNullChar_returnsTrue() {
            assertTrue(CharHelper.isAscii('\0'));
        }
    }

    @Nested
    class IsAsciiSpace {

        @Test
        void withSpace_returnsTrue() {
            assertTrue(CharHelper.isAsciiSpace(' '));
        }

        @Test
        void withTab_returnsFalse() {
            assertFalse(CharHelper.isAsciiSpace('\t'));
        }

        @Test
        void withLetter_returnsFalse() {
            assertFalse(CharHelper.isAsciiSpace('a'));
        }
    }

    @Nested
    class IsAsciiWhitespace {

        @Test
        void withSpace_returnsTrue() {
            assertTrue(CharHelper.isAsciiWhitespace(' '));
        }

        @Test
        void withTab_returnsTrue() {
            assertTrue(CharHelper.isAsciiWhitespace('\t'));
        }

        @Test
        void withNewline_returnsTrue() {
            assertTrue(CharHelper.isAsciiWhitespace('\n'));
        }

        @Test
        void withLetter_returnsFalse() {
            assertFalse(CharHelper.isAsciiWhitespace('a'));
        }

        @Test
        void withNonAsciiWhitespace_returnsFalse() {
            assertFalse(CharHelper.isAsciiWhitespace('\u00A0'));
        }
    }

    @Nested
    class IsAsciiAlpha {

        @Test
        void withLowercaseLetter_returnsTrue() {
            assertTrue(CharHelper.isAsciiAlpha('a'));
        }

        @Test
        void withUppercaseLetter_returnsTrue() {
            assertTrue(CharHelper.isAsciiAlpha('A'));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(CharHelper.isAsciiAlpha('1'));
        }

        @Test
        void withNonAsciiLetter_returnsFalse() {
            assertFalse(CharHelper.isAsciiAlpha('é'));
        }
    }

    @Nested
    class IsAsciiAlphaLower {

        @Test
        void withLowercaseLetter_returnsTrue() {
            assertTrue(CharHelper.isAsciiAlphaLower('a'));
        }

        @Test
        void withUppercaseLetter_returnsFalse() {
            assertFalse(CharHelper.isAsciiAlphaLower('A'));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(CharHelper.isAsciiAlphaLower('1'));
        }
    }

    @Nested
    class IsAsciiAlphaUpper {

        @Test
        void withUppercaseLetter_returnsTrue() {
            assertTrue(CharHelper.isAsciiAlphaUpper('A'));
        }

        @Test
        void withLowercaseLetter_returnsFalse() {
            assertFalse(CharHelper.isAsciiAlphaUpper('a'));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(CharHelper.isAsciiAlphaUpper('1'));
        }
    }

    @Nested
    class IsAsciiNumeric {

        @Test
        void withDigit_returnsTrue() {
            assertTrue(CharHelper.isAsciiNumeric('5'));
        }

        @Test
        void withLetter_returnsFalse() {
            assertFalse(CharHelper.isAsciiNumeric('a'));
        }

        @Test
        void withSpecialChar_returnsFalse() {
            assertFalse(CharHelper.isAsciiNumeric('!'));
        }
    }

    @Nested
    class IsAsciiAlphaOrSpace {

        @Test
        void withLetter_returnsTrue() {
            assertTrue(CharHelper.isAsciiAlphaOrSpace('a'));
        }

        @Test
        void withSpace_returnsTrue() {
            assertTrue(CharHelper.isAsciiAlphaOrSpace(' '));
        }

        @Test
        void withTab_returnsFalse() {
            assertFalse(CharHelper.isAsciiAlphaOrSpace('\t'));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(CharHelper.isAsciiAlphaOrSpace('1'));
        }
    }

    @Nested
    class IsAsciiAlphaOrWhitespace {

        @Test
        void withLetter_returnsTrue() {
            assertTrue(CharHelper.isAsciiAlphaOrWhitespace('a'));
        }

        @Test
        void withTab_returnsTrue() {
            assertTrue(CharHelper.isAsciiAlphaOrWhitespace('\t'));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(CharHelper.isAsciiAlphaOrWhitespace('1'));
        }

        @Test
        void withNonAsciiLetter_returnsFalse() {
            assertFalse(CharHelper.isAsciiAlphaOrWhitespace('é'));
        }
    }

    @Nested
    class IsAsciiAlphanumeric {

        @Test
        void withLetter_returnsTrue() {
            assertTrue(CharHelper.isAsciiAlphanumeric('a'));
        }

        @Test
        void withDigit_returnsTrue() {
            assertTrue(CharHelper.isAsciiAlphanumeric('1'));
        }

        @Test
        void withSpace_returnsFalse() {
            assertFalse(CharHelper.isAsciiAlphanumeric(' '));
        }

        @Test
        void withSpecialChar_returnsFalse() {
            assertFalse(CharHelper.isAsciiAlphanumeric('!'));
        }
    }

    @Nested
    class IsAsciiAlphanumericOrSpace {

        @Test
        void withLetter_returnsTrue() {
            assertTrue(CharHelper.isAsciiAlphanumericOrSpace('a'));
        }

        @Test
        void withDigit_returnsTrue() {
            assertTrue(CharHelper.isAsciiAlphanumericOrSpace('1'));
        }

        @Test
        void withSpace_returnsTrue() {
            assertTrue(CharHelper.isAsciiAlphanumericOrSpace(' '));
        }

        @Test
        void withTab_returnsFalse() {
            assertFalse(CharHelper.isAsciiAlphanumericOrSpace('\t'));
        }

        @Test
        void withSpecialChar_returnsFalse() {
            assertFalse(CharHelper.isAsciiAlphanumericOrSpace('!'));
        }
    }

    @Nested
    class IsAsciiAlphanumericOrWhitespace {

        @Test
        void withLetter_returnsTrue() {
            assertTrue(CharHelper.isAsciiAlphanumericOrWhitespace('a'));
        }

        @Test
        void withDigit_returnsTrue() {
            assertTrue(CharHelper.isAsciiAlphanumericOrWhitespace('1'));
        }

        @Test
        void withTab_returnsTrue() {
            assertTrue(CharHelper.isAsciiAlphanumericOrWhitespace('\t'));
        }

        @Test
        void withSpecialChar_returnsFalse() {
            assertFalse(CharHelper.isAsciiAlphanumericOrWhitespace('!'));
        }

        @Test
        void withNonAsciiLetter_returnsFalse() {
            assertFalse(CharHelper.isAsciiAlphanumericOrWhitespace('é'));
        }
    }
}
