package org.memoeslink;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringValidationTest {

    @Nested
    class HasSpace {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasSpace(null));
        }

        @Test
        void withEmpty_returnsFalse() {
            assertFalse(StringValidation.hasSpace(""));
        }

        @Test
        void withSpace_returnsTrue() {
            assertTrue(StringValidation.hasSpace("hello world"));
        }

        @Test
        void withNoSpace_returnsFalse() {
            assertFalse(StringValidation.hasSpace("hello"));
        }
    }

    @Nested
    class HasWhitespace {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasWhitespace(null));
        }

        @Test
        void withEmpty_returnsFalse() {
            assertFalse(StringValidation.hasWhitespace(""));
        }

        @Test
        void withSpace_returnsTrue() {
            assertTrue(StringValidation.hasWhitespace("hello world"));
        }

        @Test
        void withTab_returnsTrue() {
            assertTrue(StringValidation.hasWhitespace("hello\tworld"));
        }

        @Test
        void withNewline_returnsTrue() {
            assertTrue(StringValidation.hasWhitespace("hello\nworld"));
        }

        @Test
        void withNoWhitespace_returnsFalse() {
            assertFalse(StringValidation.hasWhitespace("hello"));
        }
    }

    @Nested
    class HasZeroWidthChar {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasZeroWidthChar(null));
        }

        @Test
        void withEmpty_returnsFalse() {
            assertFalse(StringValidation.hasZeroWidthChar(""));
        }

        @Test
        void withZeroWidthSpace_returnsTrue() {
            assertTrue(StringValidation.hasZeroWidthChar("hello\u200Bworld"));
        }

        @Test
        void withZeroWidthNonJoiner_returnsTrue() {
            assertTrue(StringValidation.hasZeroWidthChar("hello\u200Cworld"));
        }

        @Test
        void withZeroWidthJoiner_returnsTrue() {
            assertTrue(StringValidation.hasZeroWidthChar("hello\u200Dworld"));
        }

        @Test
        void withWordJoiner_returnsTrue() {
            assertTrue(StringValidation.hasZeroWidthChar("hello\u2060world"));
        }

        @Test
        void withBom_returnsTrue() {
            assertTrue(StringValidation.hasZeroWidthChar("hello\uFEFFworld"));
        }

        @Test
        void withNoZeroWidthChar_returnsFalse() {
            assertFalse(StringValidation.hasZeroWidthChar("hello"));
        }
    }

    @Nested
    class HasLetter {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasLetter(null));
        }

        @Test
        void withEmpty_returnsFalse() {
            assertFalse(StringValidation.hasLetter(""));
        }

        @Test
        void withLetter_returnsTrue() {
            assertTrue(StringValidation.hasLetter("a1"));
        }

        @Test
        void withDigitsOnly_returnsFalse() {
            assertFalse(StringValidation.hasLetter("123"));
        }
    }

    @Nested
    class HasLowercase {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasLowercase(null));
        }

        @Test
        void withLowercaseLetter_returnsTrue() {
            assertTrue(StringValidation.hasLowercase("Hello"));
        }

        @Test
        void withAllUppercase_returnsFalse() {
            assertFalse(StringValidation.hasLowercase("HELLO"));
        }
    }

    @Nested
    class HasUppercase {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasUppercase(null));
        }

        @Test
        void withUppercaseLetter_returnsTrue() {
            assertTrue(StringValidation.hasUppercase("Hello"));
        }

        @Test
        void withAllLowercase_returnsFalse() {
            assertFalse(StringValidation.hasUppercase("hello"));
        }
    }

    @Nested
    class HasDigit {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasDigit(null));
        }

        @Test
        void withDigit_returnsTrue() {
            assertTrue(StringValidation.hasDigit("abc1"));
        }

        @Test
        void withLettersOnly_returnsFalse() {
            assertFalse(StringValidation.hasDigit("abc"));
        }
    }

    @Nested
    class HasLetterOrWhitespace {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasLetterOrWhitespace(null));
        }

        @Test
        void withLetter_returnsTrue() {
            assertTrue(StringValidation.hasLetterOrWhitespace("a1"));
        }

        @Test
        void withWhitespace_returnsTrue() {
            assertTrue(StringValidation.hasLetterOrWhitespace("1 2"));
        }

        @Test
        void withDigitsOnly_returnsFalse() {
            assertFalse(StringValidation.hasLetterOrWhitespace("123"));
        }
    }

    @Nested
    class HasLetterOrDigit {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasLetterOrDigit(null));
        }

        @Test
        void withLetter_returnsTrue() {
            assertTrue(StringValidation.hasLetterOrDigit("a!"));
        }

        @Test
        void withDigit_returnsTrue() {
            assertTrue(StringValidation.hasLetterOrDigit("1!"));
        }

        @Test
        void withSpecialCharsOnly_returnsFalse() {
            assertFalse(StringValidation.hasLetterOrDigit("!@#"));
        }
    }

    @Nested
    class HasLetterDigitOrSpace {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasLetterDigitOrSpace(null));
        }

        @Test
        void withLetter_returnsTrue() {
            assertTrue(StringValidation.hasLetterDigitOrSpace("a!"));
        }

        @Test
        void withDigit_returnsTrue() {
            assertTrue(StringValidation.hasLetterDigitOrSpace("1!"));
        }

        @Test
        void withWhitespace_returnsTrue() {
            assertTrue(StringValidation.hasLetterDigitOrSpace("! !"));
        }

        @Test
        void withSpecialCharsOnly_returnsFalse() {
            assertFalse(StringValidation.hasLetterDigitOrSpace("!@#"));
        }
    }

    @Nested
    class HasAlphabetic {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasAlphabetic(null));
        }

        @Test
        void withAlphabeticChar_returnsTrue() {
            assertTrue(StringValidation.hasAlphabetic("a1"));
        }

        @Test
        void withDigitsOnly_returnsFalse() {
            assertFalse(StringValidation.hasAlphabetic("123"));
        }
    }

    @Nested
    class HasAlphabeticOrWhitespace {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasAlphabeticOrWhitespace(null));
        }

        @Test
        void withAlphabeticChar_returnsTrue() {
            assertTrue(StringValidation.hasAlphabeticOrWhitespace("a1"));
        }

        @Test
        void withWhitespace_returnsTrue() {
            assertTrue(StringValidation.hasAlphabeticOrWhitespace("1 2"));
        }

        @Test
        void withDigitsOnly_returnsFalse() {
            assertFalse(StringValidation.hasAlphabeticOrWhitespace("123"));
        }
    }

    @Nested
    class HasAlphabeticOrDigit {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasAlphabeticOrDigit(null));
        }

        @Test
        void withAlphabeticChar_returnsTrue() {
            assertTrue(StringValidation.hasAlphabeticOrDigit("a!"));
        }

        @Test
        void withDigit_returnsTrue() {
            assertTrue(StringValidation.hasAlphabeticOrDigit("1!"));
        }

        @Test
        void withSpecialCharsOnly_returnsFalse() {
            assertFalse(StringValidation.hasAlphabeticOrDigit("!@#"));
        }
    }

    @Nested
    class HasAlphanumericOrWhitespace {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasAlphanumericOrWhitespace(null));
        }

        @Test
        void withAlphanumericChar_returnsTrue() {
            assertTrue(StringValidation.hasAlphanumericOrWhitespace("a!"));
        }

        @Test
        void withWhitespace_returnsTrue() {
            assertTrue(StringValidation.hasAlphanumericOrWhitespace("! !"));
        }

        @Test
        void withSpecialCharsOnly_returnsFalse() {
            assertFalse(StringValidation.hasAlphanumericOrWhitespace("!@#"));
        }
    }

    @Nested
    class HasSpecialChar {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasSpecialChar(null));
        }

        @Test
        void withSpecialChar_returnsTrue() {
            assertTrue(StringValidation.hasSpecialChar("hello!"));
        }

        @Test
        void withLettersAndDigitsOnly_returnsFalse() {
            assertFalse(StringValidation.hasSpecialChar("hello123"));
        }
    }

    @Nested
    class HasConsonant {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasConsonant(null));
        }

        @Test
        void withConsonant_returnsTrue() {
            assertTrue(StringValidation.hasConsonant("hello"));
        }

        @Test
        void withVowelsOnly_returnsFalse() {
            assertFalse(StringValidation.hasConsonant("aeiou"));
        }
    }

    @Nested
    class HasVowel {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasVowel(null));
        }

        @Test
        void withVowel_returnsTrue() {
            assertTrue(StringValidation.hasVowel("hello"));
        }

        @Test
        void withConsonantsOnly_returnsFalse() {
            assertFalse(StringValidation.hasVowel("bcdfg"));
        }
    }

    @Nested
    class HasGlobalLetter {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasGlobalLetter(null));
        }

        @Test
        void withGlobalLetter_returnsTrue() {
            assertTrue(StringValidation.hasGlobalLetter("ñoño"));
        }

        @Test
        void withDigitsOnly_returnsFalse() {
            assertFalse(StringValidation.hasGlobalLetter("123"));
        }
    }

    @Nested
    class HasGlobalConsonant {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasGlobalConsonant(null));
        }

        @Test
        void withGlobalConsonant_returnsTrue() {
            assertTrue(StringValidation.hasGlobalConsonant("ñoño"));
        }

        @Test
        void withGlobalVowelsOnly_returnsFalse() {
            assertFalse(StringValidation.hasGlobalConsonant("aeiou"));
        }
    }

    @Nested
    class HasGlobalVowel {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasGlobalVowel(null));
        }

        @Test
        void withGlobalVowel_returnsTrue() {
            assertTrue(StringValidation.hasGlobalVowel("café"));
        }

        @Test
        void withConsonantsOnly_returnsFalse() {
            assertFalse(StringValidation.hasGlobalVowel("bcdfg"));
        }
    }

    @Nested
    class HasNonClusterConsonant {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasNonClusterConsonant(null));
        }

        @Test
        void withNonClusterConsonant_returnsTrue() {
            assertTrue(StringValidation.hasNonClusterConsonant("hello"));
        }

        @Test
        void withVowelsOnly_returnsFalse() {
            assertFalse(StringValidation.hasNonClusterConsonant("aeiou"));
        }
    }

    @Nested
    class HasAccentedLetter {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasAccentedLetter(null));
        }

        @Test
        void withAccentedLetter_returnsTrue() {
            assertTrue(StringValidation.hasAccentedLetter("café"));
        }

        @Test
        void withNoAccentedLetter_returnsFalse() {
            assertFalse(StringValidation.hasAccentedLetter("hello"));
        }
    }

    @Nested
    class HasUnaccentedLetter {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasUnaccentedLetter(null));
        }

        @Test
        void withUnaccentedLetter_returnsTrue() {
            assertTrue(StringValidation.hasUnaccentedLetter("café"));
        }

        @Test
        void withAccentedLettersOnly_returnsFalse() {
            assertFalse(StringValidation.hasUnaccentedLetter("áéíóú"));
        }
    }

    @Nested
    class HasAccentedConsonant {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasAccentedConsonant(null));
        }

        @Test
        void withAccentedConsonant_returnsTrue() {
            assertTrue(StringValidation.hasAccentedConsonant("mañana"));
        }

        @Test
        void withNoAccentedConsonant_returnsFalse() {
            assertFalse(StringValidation.hasAccentedConsonant("hello"));
        }
    }

    @Nested
    class HasUnaccentedConsonant {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasUnaccentedConsonant(null));
        }

        @Test
        void withUnaccentedConsonant_returnsTrue() {
            assertTrue(StringValidation.hasUnaccentedConsonant("hello"));
        }

        @Test
        void withVowelsOnly_returnsFalse() {
            assertFalse(StringValidation.hasUnaccentedConsonant("aeiou"));
        }
    }

    @Nested
    class HasAccentedVowel {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasAccentedVowel(null));
        }

        @Test
        void withAccentedVowel_returnsTrue() {
            assertTrue(StringValidation.hasAccentedVowel("café"));
        }

        @Test
        void withNoAccentedVowel_returnsFalse() {
            assertFalse(StringValidation.hasAccentedVowel("hello"));
        }
    }

    @Nested
    class HasUnaccentedVowel {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasUnaccentedVowel(null));
        }

        @Test
        void withUnaccentedVowel_returnsTrue() {
            assertTrue(StringValidation.hasUnaccentedVowel("hello"));
        }

        @Test
        void withAccentedVowelsOnly_returnsFalse() {
            assertFalse(StringValidation.hasUnaccentedVowel("áéíóú"));
        }
    }

    @Nested
    class HasSpecialLetter {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasSpecialLetter(null));
        }

        @Test
        void withSpecialLetter_returnsTrue() {
            assertTrue(StringValidation.hasSpecialLetter("中文"));
        }

        @Test
        void withLatinLettersOnly_returnsFalse() {
            assertFalse(StringValidation.hasSpecialLetter("hello"));
        }
    }

    @Nested
    class HasAscii {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasAscii(null));
        }

        @Test
        void withAsciiChar_returnsTrue() {
            assertTrue(StringValidation.hasAscii("hello"));
        }

        @Test
        void withNonAsciiOnly_returnsFalse() {
            assertFalse(StringValidation.hasAscii("中文"));
        }
    }

    @Nested
    class HasAsciiSpace {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasAsciiSpace(null));
        }

        @Test
        void withAsciiSpace_returnsTrue() {
            assertTrue(StringValidation.hasAsciiSpace("hello world"));
        }

        @Test
        void withNoAsciiSpace_returnsFalse() {
            assertFalse(StringValidation.hasAsciiSpace("hello"));
        }
    }

    @Nested
    class HasAsciiWhitespace {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasAsciiWhitespace(null));
        }

        @Test
        void withTab_returnsTrue() {
            assertTrue(StringValidation.hasAsciiWhitespace("hello\tworld"));
        }

        @Test
        void withNoWhitespace_returnsFalse() {
            assertFalse(StringValidation.hasAsciiWhitespace("hello"));
        }
    }

    @Nested
    class HasAsciiAlpha {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasAsciiAlpha(null));
        }

        @Test
        void withAsciiAlpha_returnsTrue() {
            assertTrue(StringValidation.hasAsciiAlpha("a1"));
        }

        @Test
        void withDigitsOnly_returnsFalse() {
            assertFalse(StringValidation.hasAsciiAlpha("123"));
        }
    }

    @Nested
    class HasAsciiAlphaLower {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasAsciiAlphaLower(null));
        }

        @Test
        void withLowercaseChar_returnsTrue() {
            assertTrue(StringValidation.hasAsciiAlphaLower("Hello"));
        }

        @Test
        void withUppercaseOnly_returnsFalse() {
            assertFalse(StringValidation.hasAsciiAlphaLower("HELLO"));
        }
    }

    @Nested
    class HasAsciiAlphaUpper {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasAsciiAlphaUpper(null));
        }

        @Test
        void withUppercaseChar_returnsTrue() {
            assertTrue(StringValidation.hasAsciiAlphaUpper("Hello"));
        }

        @Test
        void withLowercaseOnly_returnsFalse() {
            assertFalse(StringValidation.hasAsciiAlphaUpper("hello"));
        }
    }

    @Nested
    class HasAsciiNumeric {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasAsciiNumeric(null));
        }

        @Test
        void withDigit_returnsTrue() {
            assertTrue(StringValidation.hasAsciiNumeric("abc1"));
        }

        @Test
        void withLettersOnly_returnsFalse() {
            assertFalse(StringValidation.hasAsciiNumeric("abc"));
        }
    }

    @Nested
    class HasAsciiAlphaOrSpace {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasAsciiAlphaOrSpace(null));
        }

        @Test
        void withAlphaChar_returnsTrue() {
            assertTrue(StringValidation.hasAsciiAlphaOrSpace("1a"));
        }

        @Test
        void withSpace_returnsTrue() {
            assertTrue(StringValidation.hasAsciiAlphaOrSpace("1 2"));
        }

        @Test
        void withDigitsOnly_returnsFalse() {
            assertFalse(StringValidation.hasAsciiAlphaOrSpace("123"));
        }
    }

    @Nested
    class HasAsciiAlphaOrWhitespace {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasAsciiAlphaOrWhitespace(null));
        }

        @Test
        void withAlphaChar_returnsTrue() {
            assertTrue(StringValidation.hasAsciiAlphaOrWhitespace("1a"));
        }

        @Test
        void withTab_returnsTrue() {
            assertTrue(StringValidation.hasAsciiAlphaOrWhitespace("1\t2"));
        }

        @Test
        void withDigitsOnly_returnsFalse() {
            assertFalse(StringValidation.hasAsciiAlphaOrWhitespace("123"));
        }
    }

    @Nested
    class HasAsciiAlphanumeric {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasAsciiAlphanumeric(null));
        }

        @Test
        void withAlphanumericChar_returnsTrue() {
            assertTrue(StringValidation.hasAsciiAlphanumeric("!a"));
        }

        @Test
        void withSpecialCharsOnly_returnsFalse() {
            assertFalse(StringValidation.hasAsciiAlphanumeric("!@#"));
        }
    }

    @Nested
    class HasAsciiAlphanumericOrSpace {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasAsciiAlphanumericOrSpace(null));
        }

        @Test
        void withAlphanumericChar_returnsTrue() {
            assertTrue(StringValidation.hasAsciiAlphanumericOrSpace("!a"));
        }

        @Test
        void withSpace_returnsTrue() {
            assertTrue(StringValidation.hasAsciiAlphanumericOrSpace("! !"));
        }

        @Test
        void withSpecialCharsOnly_returnsFalse() {
            assertFalse(StringValidation.hasAsciiAlphanumericOrSpace("!@#"));
        }
    }

    @Nested
    class HasAsciiAlphanumericOrWhitespace {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasAsciiAlphanumericOrWhitespace(null));
        }

        @Test
        void withAlphanumericChar_returnsTrue() {
            assertTrue(StringValidation.hasAsciiAlphanumericOrWhitespace("!a"));
        }

        @Test
        void withTab_returnsTrue() {
            assertTrue(StringValidation.hasAsciiAlphanumericOrWhitespace("!\t!"));
        }

        @Test
        void withSpecialCharsOnly_returnsFalse() {
            assertFalse(StringValidation.hasAsciiAlphanumericOrWhitespace("!@#"));
        }
    }

    @Nested
    class HasDiacritic {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.hasDiacritic(null));
        }

        @Test
        void withEmpty_returnsFalse() {
            assertFalse(StringValidation.hasDiacritic(""));
        }

        @Test
        void withDiacriticChar_returnsTrue() {
            assertTrue(StringValidation.hasDiacritic("café"));
        }

        @Test
        void withNoDiacriticChar_returnsFalse() {
            assertFalse(StringValidation.hasDiacritic("hello"));
        }
    }

    @Nested
    class HasNoSpace {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoSpace(null));
        }

        @Test
        void withEmpty_returnsTrue() {
            assertTrue(StringValidation.hasNoSpace(""));
        }

        @Test
        void withNoSpace_returnsTrue() {
            assertTrue(StringValidation.hasNoSpace("hello"));
        }

        @Test
        void withSpace_returnsFalse() {
            assertFalse(StringValidation.hasNoSpace("hello world"));
        }
    }

    @Nested
    class HasNoWhitespace {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoWhitespace(null));
        }

        @Test
        void withNoWhitespace_returnsTrue() {
            assertTrue(StringValidation.hasNoWhitespace("hello"));
        }

        @Test
        void withTab_returnsFalse() {
            assertFalse(StringValidation.hasNoWhitespace("hello\tworld"));
        }
    }

    @Nested
    class HasNoZeroWidthChar {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoZeroWidthChar(null));
        }

        @Test
        void withNoZeroWidthChar_returnsTrue() {
            assertTrue(StringValidation.hasNoZeroWidthChar("hello"));
        }

        @Test
        void withZeroWidthChar_returnsFalse() {
            assertFalse(StringValidation.hasNoZeroWidthChar("hello\u200Bworld"));
        }
    }

    @Nested
    class HasNoLetter {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoLetter(null));
        }

        @Test
        void withDigitsOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoLetter("123"));
        }

        @Test
        void withLetter_returnsFalse() {
            assertFalse(StringValidation.hasNoLetter("a1"));
        }
    }

    @Nested
    class HasNoLowercase {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoLowercase(null));
        }

        @Test
        void withAllUppercase_returnsTrue() {
            assertTrue(StringValidation.hasNoLowercase("HELLO"));
        }

        @Test
        void withLowercaseLetter_returnsFalse() {
            assertFalse(StringValidation.hasNoLowercase("Hello"));
        }
    }

    @Nested
    class HasNoUppercase {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoUppercase(null));
        }

        @Test
        void withAllLowercase_returnsTrue() {
            assertTrue(StringValidation.hasNoUppercase("hello"));
        }

        @Test
        void withUppercaseLetter_returnsFalse() {
            assertFalse(StringValidation.hasNoUppercase("Hello"));
        }
    }

    @Nested
    class HasNoDigit {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoDigit(null));
        }

        @Test
        void withLettersOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoDigit("hello"));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(StringValidation.hasNoDigit("hello1"));
        }
    }

    @Nested
    class HasNoLetterOrWhitespace {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoLetterOrWhitespace(null));
        }

        @Test
        void withDigitsAndSpecialCharsOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoLetterOrWhitespace("1!2@"));
        }

        @Test
        void withLetter_returnsFalse() {
            assertFalse(StringValidation.hasNoLetterOrWhitespace("1a"));
        }

        @Test
        void withWhitespace_returnsFalse() {
            assertFalse(StringValidation.hasNoLetterOrWhitespace("1 2"));
        }
    }

    @Nested
    class HasNoLetterOrDigit {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoLetterOrDigit(null));
        }

        @Test
        void withSpecialCharsOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoLetterOrDigit("!@#"));
        }

        @Test
        void withLetter_returnsFalse() {
            assertFalse(StringValidation.hasNoLetterOrDigit("!a"));
        }
    }

    @Nested
    class HasNoLetterDigitOrSpace {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoLetterDigitOrSpace(null));
        }

        @Test
        void withSpecialCharsOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoLetterDigitOrSpace("!@#"));
        }

        @Test
        void withWhitespace_returnsFalse() {
            assertFalse(StringValidation.hasNoLetterDigitOrSpace("! !"));
        }
    }

    @Nested
    class HasNoAlphabetic {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoAlphabetic(null));
        }

        @Test
        void withDigitsOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoAlphabetic("123"));
        }

        @Test
        void withAlphabeticChar_returnsFalse() {
            assertFalse(StringValidation.hasNoAlphabetic("a1"));
        }
    }

    @Nested
    class HasNoAlphabeticOrWhitespace {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoAlphabeticOrWhitespace(null));
        }

        @Test
        void withDigitsAndSpecialCharsOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoAlphabeticOrWhitespace("1!2@"));
        }

        @Test
        void withAlphabeticChar_returnsFalse() {
            assertFalse(StringValidation.hasNoAlphabeticOrWhitespace("1a"));
        }
    }

    @Nested
    class HasNoAlphabeticOrDigit {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoAlphabeticOrDigit(null));
        }

        @Test
        void withSpecialCharsOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoAlphabeticOrDigit("!@#"));
        }

        @Test
        void withAlphabeticChar_returnsFalse() {
            assertFalse(StringValidation.hasNoAlphabeticOrDigit("!a"));
        }
    }

    @Nested
    class HasNoAlphanumericOrWhitespace {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoAlphanumericOrWhitespace(null));
        }

        @Test
        void withSpecialCharsOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoAlphanumericOrWhitespace("!@#"));
        }

        @Test
        void withAlphanumericChar_returnsFalse() {
            assertFalse(StringValidation.hasNoAlphanumericOrWhitespace("!a"));
        }
    }

    @Nested
    class HasNoSpecialChar {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoSpecialChar(null));
        }

        @Test
        void withLettersAndDigitsOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoSpecialChar("hello123"));
        }

        @Test
        void withSpecialChar_returnsFalse() {
            assertFalse(StringValidation.hasNoSpecialChar("hello!"));
        }
    }

    @Nested
    class HasNoConsonant {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoConsonant(null));
        }

        @Test
        void withVowelsOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoConsonant("aeiou"));
        }

        @Test
        void withConsonant_returnsFalse() {
            assertFalse(StringValidation.hasNoConsonant("hello"));
        }
    }

    @Nested
    class HasNoVowel {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoVowel(null));
        }

        @Test
        void withConsonantsOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoVowel("bcdfg"));
        }

        @Test
        void withVowel_returnsFalse() {
            assertFalse(StringValidation.hasNoVowel("hello"));
        }
    }

    @Nested
    class HasNoGlobalLetter {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoGlobalLetter(null));
        }

        @Test
        void withDigitsOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoGlobalLetter("123"));
        }

        @Test
        void withGlobalLetter_returnsFalse() {
            assertFalse(StringValidation.hasNoGlobalLetter("ñoño"));
        }
    }

    @Nested
    class HasNoGlobalConsonant {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoGlobalConsonant(null));
        }

        @Test
        void withGlobalVowelsOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoGlobalConsonant("aeiou"));
        }

        @Test
        void withGlobalConsonant_returnsFalse() {
            assertFalse(StringValidation.hasNoGlobalConsonant("ñoño"));
        }
    }

    @Nested
    class HasNoGlobalVowel {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoGlobalVowel(null));
        }

        @Test
        void withConsonantsOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoGlobalVowel("bcdfg"));
        }

        @Test
        void withGlobalVowel_returnsFalse() {
            assertFalse(StringValidation.hasNoGlobalVowel("café"));
        }
    }

    @Nested
    class HasNoNonClusterConsonant {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoNonClusterConsonant(null));
        }

        @Test
        void withVowelsOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoNonClusterConsonant("aeiou"));
        }

        @Test
        void withNonClusterConsonant_returnsFalse() {
            assertFalse(StringValidation.hasNoNonClusterConsonant("hello"));
        }
    }

    @Nested
    class HasNoAccentedLetter {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoAccentedLetter(null));
        }

        @Test
        void withNoAccentedLetter_returnsTrue() {
            assertTrue(StringValidation.hasNoAccentedLetter("hello"));
        }

        @Test
        void withAccentedLetter_returnsFalse() {
            assertFalse(StringValidation.hasNoAccentedLetter("café"));
        }
    }

    @Nested
    class HasNoUnaccentedLetter {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoUnaccentedLetter(null));
        }

        @Test
        void withAccentedLettersOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoUnaccentedLetter("áéíóú"));
        }

        @Test
        void withUnaccentedLetter_returnsFalse() {
            assertFalse(StringValidation.hasNoUnaccentedLetter("café"));
        }
    }

    @Nested
    class HasNoAccentedConsonant {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoAccentedConsonant(null));
        }

        @Test
        void withNoAccentedConsonant_returnsTrue() {
            assertTrue(StringValidation.hasNoAccentedConsonant("hello"));
        }

        @Test
        void withAccentedConsonant_returnsFalse() {
            assertFalse(StringValidation.hasNoAccentedConsonant("mañana"));
        }
    }

    @Nested
    class HasNoUnaccentedConsonant {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoUnaccentedConsonant(null));
        }

        @Test
        void withVowelsOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoUnaccentedConsonant("aeiou"));
        }

        @Test
        void withUnaccentedConsonant_returnsFalse() {
            assertFalse(StringValidation.hasNoUnaccentedConsonant("hello"));
        }
    }

    @Nested
    class HasNoAccentedVowel {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoAccentedVowel(null));
        }

        @Test
        void withNoAccentedVowel_returnsTrue() {
            assertTrue(StringValidation.hasNoAccentedVowel("hello"));
        }

        @Test
        void withAccentedVowel_returnsFalse() {
            assertFalse(StringValidation.hasNoAccentedVowel("café"));
        }
    }

    @Nested
    class HasNoUnaccentedVowel {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoUnaccentedVowel(null));
        }

        @Test
        void withAccentedVowelsOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoUnaccentedVowel("áéíóú"));
        }

        @Test
        void withUnaccentedVowel_returnsFalse() {
            assertFalse(StringValidation.hasNoUnaccentedVowel("café"));
        }
    }

    @Nested
    class HasNoSpecialLetter {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoSpecialLetter(null));
        }

        @Test
        void withLatinLettersOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoSpecialLetter("hello"));
        }

        @Test
        void withSpecialLetter_returnsFalse() {
            assertFalse(StringValidation.hasNoSpecialLetter("中文"));
        }
    }

    @Nested
    class HasNoAscii {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoAscii(null));
        }

        @Test
        void withNonAsciiOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoAscii("中文"));
        }

        @Test
        void withAsciiChar_returnsFalse() {
            assertFalse(StringValidation.hasNoAscii("hello"));
        }
    }

    @Nested
    class HasNoAsciiSpace {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoAsciiSpace(null));
        }

        @Test
        void withNoAsciiSpace_returnsTrue() {
            assertTrue(StringValidation.hasNoAsciiSpace("hello"));
        }

        @Test
        void withAsciiSpace_returnsFalse() {
            assertFalse(StringValidation.hasNoAsciiSpace("hello world"));
        }
    }

    @Nested
    class HasNoAsciiWhitespace {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoAsciiWhitespace(null));
        }

        @Test
        void withNoAsciiWhitespace_returnsTrue() {
            assertTrue(StringValidation.hasNoAsciiWhitespace("hello"));
        }

        @Test
        void withTab_returnsFalse() {
            assertFalse(StringValidation.hasNoAsciiWhitespace("hello\tworld"));
        }
    }

    @Nested
    class HasNoAsciiAlpha {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoAsciiAlpha(null));
        }

        @Test
        void withDigitsOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoAsciiAlpha("123"));
        }

        @Test
        void withAsciiAlpha_returnsFalse() {
            assertFalse(StringValidation.hasNoAsciiAlpha("a1"));
        }
    }

    @Nested
    class HasNoAsciiAlphaLower {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoAsciiAlphaLower(null));
        }

        @Test
        void withUppercaseOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoAsciiAlphaLower("HELLO"));
        }

        @Test
        void withLowercaseChar_returnsFalse() {
            assertFalse(StringValidation.hasNoAsciiAlphaLower("Hello"));
        }
    }

    @Nested
    class HasNoAsciiAlphaUpper {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoAsciiAlphaUpper(null));
        }

        @Test
        void withLowercaseOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoAsciiAlphaUpper("hello"));
        }

        @Test
        void withUppercaseChar_returnsFalse() {
            assertFalse(StringValidation.hasNoAsciiAlphaUpper("Hello"));
        }
    }

    @Nested
    class HasNoAsciiNumeric {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoAsciiNumeric(null));
        }

        @Test
        void withLettersOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoAsciiNumeric("hello"));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(StringValidation.hasNoAsciiNumeric("hello1"));
        }
    }

    @Nested
    class HasNoAsciiAlphaOrSpace {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoAsciiAlphaOrSpace(null));
        }

        @Test
        void withDigitsAndSpecialCharsOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoAsciiAlphaOrSpace("1!2@"));
        }

        @Test
        void withAsciiAlpha_returnsFalse() {
            assertFalse(StringValidation.hasNoAsciiAlphaOrSpace("1a"));
        }

        @Test
        void withSpace_returnsFalse() {
            assertFalse(StringValidation.hasNoAsciiAlphaOrSpace("1 2"));
        }
    }

    @Nested
    class HasNoAsciiAlphaOrWhitespace {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoAsciiAlphaOrWhitespace(null));
        }

        @Test
        void withDigitsAndSpecialCharsOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoAsciiAlphaOrWhitespace("1!2@"));
        }

        @Test
        void withAsciiAlpha_returnsFalse() {
            assertFalse(StringValidation.hasNoAsciiAlphaOrWhitespace("1a"));
        }
    }

    @Nested
    class HasNoAsciiAlphanumeric {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoAsciiAlphanumeric(null));
        }

        @Test
        void withSpecialCharsOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoAsciiAlphanumeric("!@#"));
        }

        @Test
        void withAlphanumericChar_returnsFalse() {
            assertFalse(StringValidation.hasNoAsciiAlphanumeric("!a"));
        }
    }

    @Nested
    class HasNoAsciiAlphanumericOrSpace {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoAsciiAlphanumericOrSpace(null));
        }

        @Test
        void withSpecialCharsOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoAsciiAlphanumericOrSpace("!@#"));
        }

        @Test
        void withSpace_returnsFalse() {
            assertFalse(StringValidation.hasNoAsciiAlphanumericOrSpace("! !"));
        }
    }

    @Nested
    class HasNoAsciiAlphanumericOrWhitespace {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoAsciiAlphanumericOrWhitespace(null));
        }

        @Test
        void withSpecialCharsOnly_returnsTrue() {
            assertTrue(StringValidation.hasNoAsciiAlphanumericOrWhitespace("!@#"));
        }

        @Test
        void withAlphanumericChar_returnsFalse() {
            assertFalse(StringValidation.hasNoAsciiAlphanumericOrWhitespace("!a"));
        }
    }

    @Nested
    class HasNoDiacritic {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringValidation.hasNoDiacritic(null));
        }

        @Test
        void withNoDiacriticChar_returnsTrue() {
            assertTrue(StringValidation.hasNoDiacritic("hello"));
        }

        @Test
        void withDiacriticChar_returnsFalse() {
            assertFalse(StringValidation.hasNoDiacritic("café"));
        }
    }

    @Nested
    class IsOnlySpace {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlySpace(null));
        }

        @Test
        void withEmpty_returnsFalse() {
            assertFalse(StringValidation.isOnlySpace(""));
        }

        @Test
        void withSpaceOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlySpace("   "));
        }

        @Test
        void withMixedContent_returnsFalse() {
            assertFalse(StringValidation.isOnlySpace("a "));
        }
    }

    @Nested
    class IsOnlyWhitespace {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyWhitespace(null));
        }

        @Test
        void withWhitespaceOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyWhitespace(" \t\n"));
        }

        @Test
        void withMixedContent_returnsFalse() {
            assertFalse(StringValidation.isOnlyWhitespace("a "));
        }
    }

    @Nested
    class IsOnlyZeroWidthChar {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyZeroWidthChar(null));
        }

        @Test
        void withZeroWidthCharsOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyZeroWidthChar("\u200B\u200C"));
        }

        @Test
        void withMixedContent_returnsFalse() {
            assertFalse(StringValidation.isOnlyZeroWidthChar("a\u200B"));
        }
    }

    @Nested
    class IsOnlyLetter {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyLetter(null));
        }

        @Test
        void withLettersOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyLetter("hello"));
        }

        @Test
        void withLetterAndDigit_returnsFalse() {
            assertFalse(StringValidation.isOnlyLetter("hello1"));
        }
    }

    @Nested
    class IsOnlyLowercase {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyLowercase(null));
        }

        @Test
        void withAllLowercase_returnsTrue() {
            assertTrue(StringValidation.isOnlyLowercase("hello"));
        }

        @Test
        void withUppercaseLetter_returnsFalse() {
            assertFalse(StringValidation.isOnlyLowercase("Hello"));
        }
    }

    @Nested
    class IsOnlyUppercase {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyUppercase(null));
        }

        @Test
        void withAllUppercase_returnsTrue() {
            assertTrue(StringValidation.isOnlyUppercase("HELLO"));
        }

        @Test
        void withLowercaseLetter_returnsFalse() {
            assertFalse(StringValidation.isOnlyUppercase("Hello"));
        }
    }

    @Nested
    class IsOnlyDigit {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyDigit(null));
        }

        @Test
        void withDigitsOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyDigit("123"));
        }

        @Test
        void withLetterAndDigit_returnsFalse() {
            assertFalse(StringValidation.isOnlyDigit("1a"));
        }
    }

    @Nested
    class IsOnlyLetterOrWhitespace {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyLetterOrWhitespace(null));
        }

        @Test
        void withLettersAndSpaces_returnsTrue() {
            assertTrue(StringValidation.isOnlyLetterOrWhitespace("hello world"));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(StringValidation.isOnlyLetterOrWhitespace("hello1"));
        }
    }

    @Nested
    class IsOnlyLetterOrDigit {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyLetterOrDigit(null));
        }

        @Test
        void withLettersAndDigits_returnsTrue() {
            assertTrue(StringValidation.isOnlyLetterOrDigit("hello123"));
        }

        @Test
        void withSpecialChar_returnsFalse() {
            assertFalse(StringValidation.isOnlyLetterOrDigit("hello!"));
        }
    }

    @Nested
    class IsOnlyLetterDigitOrSpace {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyLetterDigitOrSpace(null));
        }

        @Test
        void withLettersDigitsAndSpaces_returnsTrue() {
            assertTrue(StringValidation.isOnlyLetterDigitOrSpace("hello 123"));
        }

        @Test
        void withSpecialChar_returnsFalse() {
            assertFalse(StringValidation.isOnlyLetterDigitOrSpace("hello!"));
        }
    }

    @Nested
    class IsOnlyAlphabetic {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyAlphabetic(null));
        }

        @Test
        void withAlphabeticCharsOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyAlphabetic("hello"));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(StringValidation.isOnlyAlphabetic("hello1"));
        }
    }

    @Nested
    class IsOnlyAlphabeticOrWhitespace {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyAlphabeticOrWhitespace(null));
        }

        @Test
        void withAlphabeticAndWhitespace_returnsTrue() {
            assertTrue(StringValidation.isOnlyAlphabeticOrWhitespace("hello world"));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(StringValidation.isOnlyAlphabeticOrWhitespace("hello1"));
        }
    }

    @Nested
    class IsOnlyAlphabeticOrDigit {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyAlphabeticOrDigit(null));
        }

        @Test
        void withAlphabeticAndDigits_returnsTrue() {
            assertTrue(StringValidation.isOnlyAlphabeticOrDigit("hello123"));
        }

        @Test
        void withSpecialChar_returnsFalse() {
            assertFalse(StringValidation.isOnlyAlphabeticOrDigit("hello!"));
        }
    }

    @Nested
    class IsOnlyAlphanumericOrWhitespace {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyAlphanumericOrWhitespace(null));
        }

        @Test
        void withAlphanumericAndWhitespace_returnsTrue() {
            assertTrue(StringValidation.isOnlyAlphanumericOrWhitespace("hello 123"));
        }

        @Test
        void withSpecialChar_returnsFalse() {
            assertFalse(StringValidation.isOnlyAlphanumericOrWhitespace("hello!"));
        }
    }

    @Nested
    class IsOnlySpecialChar {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlySpecialChar(null));
        }

        @Test
        void withSpecialCharsOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlySpecialChar("!@#"));
        }

        @Test
        void withLetter_returnsFalse() {
            assertFalse(StringValidation.isOnlySpecialChar("!a"));
        }
    }

    @Nested
    class IsOnlyConsonant {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyConsonant(null));
        }

        @Test
        void withConsonantsOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyConsonant("bcdfg"));
        }

        @Test
        void withVowel_returnsFalse() {
            assertFalse(StringValidation.isOnlyConsonant("hello"));
        }
    }

    @Nested
    class IsOnlyVowel {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyVowel(null));
        }

        @Test
        void withVowelsOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyVowel("aeiou"));
        }

        @Test
        void withConsonant_returnsFalse() {
            assertFalse(StringValidation.isOnlyVowel("hello"));
        }
    }

    @Nested
    class IsOnlyGlobalLetter {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyGlobalLetter(null));
        }

        @Test
        void withGlobalLettersOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyGlobalLetter("ñoño"));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(StringValidation.isOnlyGlobalLetter("ñ1"));
        }
    }

    @Nested
    class IsOnlyGlobalConsonant {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyGlobalConsonant(null));
        }

        @Test
        void withGlobalConsonantsOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyGlobalConsonant("bcdfñ"));
        }

        @Test
        void withGlobalVowel_returnsFalse() {
            assertFalse(StringValidation.isOnlyGlobalConsonant("bcdfa"));
        }
    }

    @Nested
    class IsOnlyGlobalVowel {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyGlobalVowel(null));
        }

        @Test
        void withGlobalVowelsOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyGlobalVowel("aeiouáéíóú"));
        }

        @Test
        void withConsonant_returnsFalse() {
            assertFalse(StringValidation.isOnlyGlobalVowel("aeiob"));
        }
    }

    @Nested
    class IsOnlyNonClusterConsonant {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyNonClusterConsonant(null));
        }

        @Test
        void withNonClusterConsonantsOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyNonClusterConsonant("hjqv"));
        }

        @Test
        void withClusterConsonant_returnsFalse() {
            assertFalse(StringValidation.isOnlyNonClusterConsonant("hb"));
        }
    }

    @Nested
    class IsOnlyAccentedLetter {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyAccentedLetter(null));
        }

        @Test
        void withAccentedLettersOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyAccentedLetter("áéíóú"));
        }

        @Test
        void withUnaccentedLetter_returnsFalse() {
            assertFalse(StringValidation.isOnlyAccentedLetter("café"));
        }
    }

    @Nested
    class IsOnlyUnaccentedLetter {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyUnaccentedLetter(null));
        }

        @Test
        void withUnaccentedLettersOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyUnaccentedLetter("hello"));
        }

        @Test
        void withAccentedLetter_returnsFalse() {
            assertFalse(StringValidation.isOnlyUnaccentedLetter("café"));
        }
    }

    @Nested
    class IsOnlyAccentedConsonant {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyAccentedConsonant(null));
        }

        @Test
        void withUnaccentedConsonant_returnsFalse() {
            assertFalse(StringValidation.isOnlyAccentedConsonant("hello"));
        }
    }

    @Nested
    class IsOnlyUnaccentedConsonant {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyUnaccentedConsonant(null));
        }

        @Test
        void withUnaccentedConsonantsOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyUnaccentedConsonant("bcdfg"));
        }

        @Test
        void withVowel_returnsFalse() {
            assertFalse(StringValidation.isOnlyUnaccentedConsonant("hello"));
        }
    }

    @Nested
    class IsOnlyAccentedVowel {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyAccentedVowel(null));
        }

        @Test
        void withAccentedVowelsOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyAccentedVowel("áéíóú"));
        }

        @Test
        void withUnaccentedVowel_returnsFalse() {
            assertFalse(StringValidation.isOnlyAccentedVowel("aéíóú"));
        }
    }

    @Nested
    class IsOnlyUnaccentedVowel {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyUnaccentedVowel(null));
        }

        @Test
        void withUnaccentedVowelsOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyUnaccentedVowel("aeiou"));
        }

        @Test
        void withAccentedVowel_returnsFalse() {
            assertFalse(StringValidation.isOnlyUnaccentedVowel("aeiouá"));
        }
    }

    @Nested
    class IsOnlySpecialLetter {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlySpecialLetter(null));
        }

        @Test
        void withSpecialLettersOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlySpecialLetter("中文"));
        }

        @Test
        void withLatinLetter_returnsFalse() {
            assertFalse(StringValidation.isOnlySpecialLetter("中a"));
        }
    }

    @Nested
    class IsOnlyAscii {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyAscii(null));
        }

        @Test
        void withAsciiOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyAscii("hello123"));
        }

        @Test
        void withNonAsciiChar_returnsFalse() {
            assertFalse(StringValidation.isOnlyAscii("héllo"));
        }
    }

    @Nested
    class IsOnlyAsciiSpace {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyAsciiSpace(null));
        }

        @Test
        void withSpacesOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyAsciiSpace("   "));
        }

        @Test
        void withTab_returnsFalse() {
            assertFalse(StringValidation.isOnlyAsciiSpace(" \t "));
        }
    }

    @Nested
    class IsOnlyAsciiWhitespace {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyAsciiWhitespace(null));
        }

        @Test
        void withAsciiWhitespaceOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyAsciiWhitespace(" \t\n"));
        }

        @Test
        void withLetter_returnsFalse() {
            assertFalse(StringValidation.isOnlyAsciiWhitespace(" a "));
        }
    }

    @Nested
    class IsOnlyAsciiAlpha {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyAsciiAlpha(null));
        }

        @Test
        void withAsciiAlphaOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyAsciiAlpha("hello"));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(StringValidation.isOnlyAsciiAlpha("hello1"));
        }
    }

    @Nested
    class IsOnlyAsciiAlphaLower {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyAsciiAlphaLower(null));
        }

        @Test
        void withLowercaseOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyAsciiAlphaLower("hello"));
        }

        @Test
        void withUppercaseLetter_returnsFalse() {
            assertFalse(StringValidation.isOnlyAsciiAlphaLower("Hello"));
        }
    }

    @Nested
    class IsOnlyAsciiAlphaUpper {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyAsciiAlphaUpper(null));
        }

        @Test
        void withUppercaseOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyAsciiAlphaUpper("HELLO"));
        }

        @Test
        void withLowercaseLetter_returnsFalse() {
            assertFalse(StringValidation.isOnlyAsciiAlphaUpper("Hello"));
        }
    }

    @Nested
    class IsOnlyAsciiNumeric {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyAsciiNumeric(null));
        }

        @Test
        void withDigitsOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyAsciiNumeric("123"));
        }

        @Test
        void withLetter_returnsFalse() {
            assertFalse(StringValidation.isOnlyAsciiNumeric("1a"));
        }
    }

    @Nested
    class IsOnlyAsciiAlphaOrSpace {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyAsciiAlphaOrSpace(null));
        }

        @Test
        void withAlphaAndSpaceOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyAsciiAlphaOrSpace("hello world"));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(StringValidation.isOnlyAsciiAlphaOrSpace("hello1"));
        }
    }

    @Nested
    class IsOnlyAsciiAlphaOrWhitespace {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyAsciiAlphaOrWhitespace(null));
        }

        @Test
        void withAlphaAndWhitespaceOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyAsciiAlphaOrWhitespace("hello\tworld"));
        }

        @Test
        void withDigit_returnsFalse() {
            assertFalse(StringValidation.isOnlyAsciiAlphaOrWhitespace("hello1"));
        }
    }

    @Nested
    class IsOnlyAsciiAlphanumeric {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyAsciiAlphanumeric(null));
        }

        @Test
        void withAlphanumericOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyAsciiAlphanumeric("hello123"));
        }

        @Test
        void withSpecialChar_returnsFalse() {
            assertFalse(StringValidation.isOnlyAsciiAlphanumeric("hello!"));
        }
    }

    @Nested
    class IsOnlyAsciiAlphanumericOrSpace {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyAsciiAlphanumericOrSpace(null));
        }

        @Test
        void withAlphanumericAndSpaceOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyAsciiAlphanumericOrSpace("hello 123"));
        }

        @Test
        void withSpecialChar_returnsFalse() {
            assertFalse(StringValidation.isOnlyAsciiAlphanumericOrSpace("hello!"));
        }
    }

    @Nested
    class IsOnlyAsciiAlphanumericOrWhitespace {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringValidation.isOnlyAsciiAlphanumericOrWhitespace(null));
        }

        @Test
        void withAlphanumericAndWhitespaceOnly_returnsTrue() {
            assertTrue(StringValidation.isOnlyAsciiAlphanumericOrWhitespace("hello\t123"));
        }

        @Test
        void withSpecialChar_returnsFalse() {
            assertFalse(StringValidation.isOnlyAsciiAlphanumericOrWhitespace("hello!"));
        }
    }
}
