package org.memoeslink;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringValidationTest {

    @Test
    void hasSpace_withSpace_returnsTrue() {
        assertTrue(StringValidation.hasSpace("Hello World"));
    }

    @Test
    void hasSpace_withoutSpace_returnsFalse() {
        assertFalse(StringValidation.hasSpace("HelloWorld"));
    }

    @Test
    void hasWhitespace_withWhitespace_returnsTrue() {
        assertTrue(StringValidation.hasWhitespace("Hello\tWorld"));
    }

    @Test
    void hasWhitespace_withoutWhitespace_returnsFalse() {
        assertFalse(StringValidation.hasWhitespace("HelloWorld"));
    }

    @Test
    void hasZeroWidthChar_withZeroWidthChar_returnsTrue() {
        assertTrue(StringValidation.hasZeroWidthChar("Hello\u200BWorld"));
    }

    @Test
    void hasZeroWidthChar_withoutZeroWidthChar_returnsFalse() {
        assertFalse(StringValidation.hasZeroWidthChar("HelloWorld"));
    }

    @Test
    void hasLetter_withLetter_returnsTrue() {
        assertTrue(StringValidation.hasLetter("Hello123"));
    }

    @Test
    void hasLetter_withoutLetter_returnsFalse() {
        assertFalse(StringValidation.hasLetter("123456"));
    }

    @Test
    void hasLowercase_withLowercase_returnsTrue() {
        assertTrue(StringValidation.hasLowercase("Hello"));
    }

    @Test
    void hasLowercase_withoutLowercase_returnsFalse() {
        assertFalse(StringValidation.hasLowercase("HELLO"));
    }

    @Test
    void hasUppercase_withUppercase_returnsTrue() {
        assertTrue(StringValidation.hasUppercase("Hello"));
    }

    @Test
    void hasUppercase_withoutUppercase_returnsFalse() {
        assertFalse(StringValidation.hasUppercase("hello"));
    }

    @Test
    void hasDigit_withDigit_returnsTrue() {
        assertTrue(StringValidation.hasDigit("123"));
    }

    @Test
    void hasDigit_withoutDigit_returnsFalse() {
        assertFalse(StringValidation.hasDigit("abc"));
    }

    @Test
    void hasLetterOrWhitespace_withLetterOrWhitespace_returnsTrue() {
        assertTrue(StringValidation.hasLetterOrWhitespace("Hello World"));
    }

    @Test
    void hasLetterOrWhitespace_withoutLetterOrWhitespace_returnsFalse() {
        assertFalse(StringValidation.hasLetterOrWhitespace("123456"));
    }

    @Test
    void hasLetterOrDigit_withLetterOrDigit_returnsTrue() {
        assertTrue(StringValidation.hasLetterOrDigit("Hello123"));
    }

    @Test
    void hasLetterOrDigit_withoutLetterOrDigit_returnsFalse() {
        assertFalse(StringValidation.hasLetterOrDigit("!@#"));
    }

    @Test
    void hasLetterDigitOrSpace_withLetterDigitOrSpace_returnsTrue() {
        assertTrue(StringValidation.hasLetterDigitOrSpace("Hello 123"));
    }

    @Test
    void hasLetterDigitOrSpace_withoutLetterDigitOrSpace_returnsFalse() {
        assertFalse(StringValidation.hasLetterDigitOrSpace("!@#"));
    }

    @Test
    void hasAlphabetic_withAlphabetic_returnsTrue() {
        assertTrue(StringValidation.hasAlphabetic("Hello"));
    }

    @Test
    void hasAlphabetic_withoutAlphabetic_returnsFalse() {
        assertFalse(StringValidation.hasAlphabetic("123456"));
    }

    @Test
    void hasAlphabeticOrWhitespace_withAlphabeticOrWhitespace_returnsTrue() {
        assertTrue(StringValidation.hasAlphabeticOrWhitespace("Hello World"));
    }

    @Test
    void hasAlphabeticOrWhitespace_withoutAlphabeticOrWhitespace_returnsFalse() {
        assertFalse(StringValidation.hasAlphabeticOrWhitespace("123456"));
    }

    @Test
    void hasAlphabeticOrDigit_withAlphabeticOrDigit_returnsTrue() {
        assertTrue(StringValidation.hasAlphabeticOrDigit("Hello123"));
    }

    @Test
    void hasAlphabeticOrDigit_withoutAlphabeticOrDigit_returnsFalse() {
        assertFalse(StringValidation.hasAlphabeticOrDigit("!@#"));
    }

    @Test
    void hasAlphanumericOrWhitespace_withAlphanumericOrWhitespace_returnsTrue() {
        assertTrue(StringValidation.hasAlphanumericOrWhitespace("Hello 123"));
    }

    @Test
    void hasAlphanumericOrWhitespace_withoutAlphanumericOrWhitespace_returnsFalse() {
        assertFalse(StringValidation.hasAlphanumericOrWhitespace("!@#"));
    }

    @Test
    void hasSpecialChar_withSpecialChar_returnsTrue() {
        assertTrue(StringValidation.hasSpecialChar("!@#"));
    }

    @Test
    void hasSpecialChar_withoutSpecialChar_returnsFalse() {
        assertFalse(StringValidation.hasSpecialChar("Hello123"));
    }

    @Test
    void hasConsonant_withConsonant_returnsTrue() {
        assertTrue(StringValidation.hasConsonant("Hello"));
    }

    @Test
    void hasConsonant_withoutConsonant_returnsFalse() {
        assertFalse(StringValidation.hasConsonant("aeiou"));
    }

    @Test
    void hasVowel_withVowel_returnsTrue() {
        assertTrue(StringValidation.hasVowel("Hello"));
    }

    @Test
    void hasVowel_withoutVowel_returnsFalse() {
        assertFalse(StringValidation.hasVowel("bcdfg"));
    }

    @Test
    void hasGlobalLetter_withGlobalLetter_returnsTrue() {
        assertTrue(StringValidation.hasGlobalLetter("ĀĆĖĪŌŪ"));
    }

    @Test
    void hasGlobalLetter_withoutGlobalLetter_returnsFalse() {
        assertFalse(StringValidation.hasGlobalLetter("123456"));
    }

    @Test
    void hasGlobalConsonant_withGlobalConsonant_returnsTrue() {
        assertTrue(StringValidation.hasGlobalConsonant("ĆĞĶŁŃŘŠŽ"));
    }

    @Test
    void hasGlobalConsonant_withoutGlobalConsonant_returnsFalse() {
        assertFalse(StringValidation.hasGlobalConsonant("AEIOU"));
    }

    @Test
    void hasGlobalVowel_withGlobalVowel_returnsTrue() {
        assertTrue(StringValidation.hasGlobalVowel("ĀĒĪŌŪ"));
    }

    @Test
    void hasGlobalVowel_withoutGlobalVowel_returnsFalse() {
        assertFalse(StringValidation.hasGlobalVowel("BCDFG"));
    }

    @Test
    void hasNonClusterConsonant_withNonClusterConsonant_returnsTrue() {
        assertTrue(StringValidation.hasNonClusterConsonant("željezničarom"));
    }

    @Test
    void hasNonClusterConsonant_withoutNonClusterConsonant_returnsFalse() {
        assertFalse(StringValidation.hasNonClusterConsonant("tree"));
    }

    @Test
    void hasAccentedLetter_withAccentedLetter_returnsTrue() {
        assertTrue(StringValidation.hasAccentedLetter("ĀĆĖĪŌŪ"));
    }

    @Test
    void hasAccentedLetter_withoutAccentedLetter_returnsFalse() {
        assertFalse(StringValidation.hasAccentedLetter("ACEIOU"));
    }

    @Test
    void hasUnaccentedLetter_withUnaccentedLetter_returnsTrue() {
        assertTrue(StringValidation.hasUnaccentedLetter("ACEIOU"));
    }

    @Test
    void hasUnaccentedLetter_withoutUnaccentedLetter_returnsFalse() {
        assertFalse(StringValidation.hasUnaccentedLetter("ĀĆĖĪŌŪ"));
    }

    @Test
    void hasAccentedConsonant_withAccentedConsonant_returnsTrue() {
        assertTrue(StringValidation.hasAccentedConsonant("ĆĞĶŁŃŘŠŽ"));
    }

    @Test
    void hasAccentedConsonant_withoutAccentedConsonant_returnsFalse() {
        assertFalse(StringValidation.hasAccentedConsonant("CGKLNRSZ"));
    }

    @Test
    void hasUnaccentedConsonant_withUnaccentedConsonant_returnsTrue() {
        assertTrue(StringValidation.hasUnaccentedConsonant("CGKLNRSZ"));
    }

    @Test
    void hasUnaccentedConsonant_withoutUnaccentedConsonant_returnsFalse() {
        assertFalse(StringValidation.hasUnaccentedConsonant("ĆĞĶŁŃŘŠŽ"));
    }

    @Test
    void hasAccentedVowel_withAccentedVowel_returnsTrue() {
        assertTrue(StringValidation.hasAccentedVowel("résumé"));
    }

    @Test
    void hasAccentedVowel_withoutAccentedVowel_returnsFalse() {
        assertFalse(StringValidation.hasAccentedVowel("resume"));
    }

    @Test
    void hasUnaccentedVowel_withUnaccentedVowel_returnsTrue() {
        assertTrue(StringValidation.hasUnaccentedVowel("resume"));
    }

    @Test
    void hasUnaccentedVowel_withoutUnaccentedVowel_returnsFalse() {
        assertFalse(StringValidation.hasUnaccentedVowel("rsm"));
    }

    @Test
    void hasSpecialLetter_withSpecialLetter_returnsTrue() {
        assertTrue(StringValidation.hasSpecialLetter("батько"));
    }

    @Test
    void hasSpecialLetter_withoutSpecialLetter_returnsFalse() {
        assertFalse(StringValidation.hasSpecialLetter("facade"));
    }

    @Test
    void hasAscii_withAscii_returnsTrue() {
        assertTrue(StringValidation.hasAscii("Hello"));
    }

    @Test
    void hasAscii_withoutAscii_returnsFalse() {
        assertFalse(StringValidation.hasAscii("Спасибо"));
    }

    @Test
    void hasAsciiSpace_withAsciiSpace_returnsTrue() {
        assertTrue(StringValidation.hasAsciiSpace("Hello World"));
    }

    @Test
    void hasAsciiSpace_withoutAsciiSpace_returnsFalse() {
        assertFalse(StringValidation.hasAsciiSpace("HelloWorld"));
    }

    @Test
    void hasAsciiWhitespace_withAsciiWhitespace_returnsTrue() {
        assertTrue(StringValidation.hasAsciiWhitespace("Hello\tWorld"));
    }

    @Test
    void hasAsciiWhitespace_withoutAsciiWhitespace_returnsFalse() {
        assertFalse(StringValidation.hasAsciiWhitespace("HelloWorld"));
    }

    @Test
    void hasAsciiAlpha_withAsciiAlpha_returnsTrue() {
        assertTrue(StringValidation.hasAsciiAlpha("Hello"));
    }

    @Test
    void hasAsciiAlpha_withoutAsciiAlpha_returnsFalse() {
        assertFalse(StringValidation.hasAsciiAlpha("こんにちは"));
    }

    @Test
    void hasAsciiAlphaLower_withAsciiAlphaLower_returnsTrue() {
        assertTrue(StringValidation.hasAsciiAlphaLower("hello"));
    }

    @Test
    void hasAsciiAlphaLower_withoutAsciiAlphaLower_returnsFalse() {
        assertFalse(StringValidation.hasAsciiAlphaLower("HELLO"));
    }

    @Test
    void hasAsciiAlphaUpper_withAsciiAlphaUpper_returnsTrue() {
        assertTrue(StringValidation.hasAsciiAlphaUpper("HELLO"));
    }

    @Test
    void hasAsciiAlphaUpper_withoutAsciiAlphaUpper_returnsFalse() {
        assertFalse(StringValidation.hasAsciiAlphaUpper("hello"));
    }

    @Test
    void hasAsciiNumeric_withAsciiNumeric_returnsTrue() {
        assertTrue(StringValidation.hasAsciiNumeric("123"));
    }

    @Test
    void hasAsciiNumeric_withoutAsciiNumeric_returnsFalse() {
        assertFalse(StringValidation.hasAsciiNumeric("abc"));
    }

    @Test
    void hasAsciiAlphaOrSpace_withAsciiAlphaOrSpace_returnsTrue() {
        assertTrue(StringValidation.hasAsciiAlphaOrSpace("Hello World"));
    }

    @Test
    void hasAsciiAlphaOrSpace_withoutAsciiAlphaOrSpace_returnsFalse() {
        assertFalse(StringValidation.hasAsciiAlphaOrSpace("123"));
    }

    @Test
    void hasAsciiAlphaOrWhitespace_withAsciiAlphaOrWhitespace_returnsTrue() {
        assertTrue(StringValidation.hasAsciiAlphaOrWhitespace("Hello\tWorld"));
    }

    @Test
    void hasAsciiAlphaOrWhitespace_withoutAsciiAlphaOrWhitespace_returnsFalse() {
        assertFalse(StringValidation.hasAsciiAlphaOrWhitespace("123"));
    }

    @Test
    void hasAsciiAlphanumeric_withAsciiAlphanumeric_returnsTrue() {
        assertTrue(StringValidation.hasAsciiAlphanumeric("Hello123"));
    }

    @Test
    void hasAsciiAlphanumeric_withoutAsciiAlphanumeric_returnsFalse() {
        assertFalse(StringValidation.hasAsciiAlphanumeric("!@#"));
    }

    @Test
    void hasAsciiAlphanumericOrSpace_withAsciiAlphanumericOrSpace_returnsTrue() {
        assertTrue(StringValidation.hasAsciiAlphanumericOrSpace("Hello 123"));
    }

    @Test
    void hasAsciiAlphanumericOrSpace_withoutAsciiAlphanumericOrSpace_returnsFalse() {
        assertFalse(StringValidation.hasAsciiAlphanumericOrSpace("!@#"));
    }

    @Test
    void hasAsciiAlphanumericOrWhitespace_withAsciiAlphanumericOrWhitespace_returnsTrue() {
        assertTrue(StringValidation.hasAsciiAlphanumericOrWhitespace("Hello 123"));
    }

    @Test
    void hasAsciiAlphanumericOrWhitespace_withoutAsciiAlphanumericOrWhitespace_returnsFalse() {
        assertFalse(StringValidation.hasAsciiAlphanumericOrWhitespace("!@#"));
    }

    @Test
    void hasDiacritic_withDiacritic_returnsTrue() {
        assertTrue(StringValidation.hasDiacritic("résumé"));
    }

    @Test
    void hasDiacritic_withoutDiacritic_returnsFalse() {
        assertFalse(StringValidation.hasDiacritic("resume"));
    }

    @Test
    void hasNoSpace_withSpace_returnsFalse() {
        assertFalse(StringValidation.hasNoSpace("Hello World"));
    }

    @Test
    void hasNoSpace_withoutSpace_returnsTrue() {
        assertTrue(StringValidation.hasNoSpace("HelloWorld"));
    }

    @Test
    void hasNoWhitespace_withWhitespace_returnsFalse() {
        assertFalse(StringValidation.hasNoWhitespace("Hello\tWorld"));
    }

    @Test
    void hasNoWhitespace_withoutWhitespace_returnsTrue() {
        assertTrue(StringValidation.hasNoWhitespace("HelloWorld"));
    }

    @Test
    void hasNoZeroWidthChar_withZeroWidthChar_returnsFalse() {
        assertFalse(StringValidation.hasNoZeroWidthChar("Hello\u200BWorld"));
    }

    @Test
    void hasNoZeroWidthChar_withoutZeroWidthChar_returnsTrue() {
        assertTrue(StringValidation.hasNoZeroWidthChar("HelloWorld"));
    }

    @Test
    void hasNoLetter_withLetter_returnsFalse() {
        assertFalse(StringValidation.hasNoLetter("Hello123"));
    }

    @Test
    void hasNoLetter_withoutLetter_returnsTrue() {
        assertTrue(StringValidation.hasNoLetter("123456"));
    }

    @Test
    void hasNoLowercase_withLowercase_returnsFalse() {
        assertFalse(StringValidation.hasNoLowercase("Hello"));
    }

    @Test
    void hasNoLowercase_withoutLowercase_returnsTrue() {
        assertTrue(StringValidation.hasNoLowercase("HELLO"));
    }

    @Test
    void hasNoUppercase_withUppercase_returnsFalse() {
        assertFalse(StringValidation.hasNoUppercase("Hello"));
    }

    @Test
    void hasNoUppercase_withoutUppercase_returnsTrue() {
        assertTrue(StringValidation.hasNoUppercase("hello"));
    }

    @Test
    void hasNoDigit_withDigit_returnsFalse() {
        assertFalse(StringValidation.hasNoDigit("123"));
    }

    @Test
    void hasNoDigit_withoutDigit_returnsTrue() {
        assertTrue(StringValidation.hasNoDigit("abc"));
    }

    @Test
    void hasNoLetterOrWhitespace_withLetterOrWhitespace_returnsFalse() {
        assertFalse(StringValidation.hasNoLetterOrWhitespace("Hello World"));
    }

    @Test
    void hasNoLetterOrWhitespace_withoutLetterOrWhitespace_returnsTrue() {
        assertTrue(StringValidation.hasNoLetterOrWhitespace("123456"));
    }

    @Test
    void hasNoLetterOrDigit_withLetterOrDigit_returnsFalse() {
        assertFalse(StringValidation.hasNoLetterOrDigit("Hello123"));
    }

    @Test
    void hasNoLetterOrDigit_withoutLetterOrDigit_returnsTrue() {
        assertTrue(StringValidation.hasNoLetterOrDigit("!@#"));
    }

    @Test
    void hasNoLetterDigitOrSpace_withLetterDigitOrSpace_returnsFalse() {
        assertFalse(StringValidation.hasNoLetterDigitOrSpace("Hello 123"));
    }

    @Test
    void hasNoLetterDigitOrSpace_withoutLetterDigitOrSpace_returnsTrue() {
        assertTrue(StringValidation.hasNoLetterDigitOrSpace("!@#"));
    }

    @Test
    void hasNoAlphabetic_withAlphabetic_returnsFalse() {
        assertFalse(StringValidation.hasNoAlphabetic("Hello"));
    }

    @Test
    void hasNoAlphabetic_withoutAlphabetic_returnsTrue() {
        assertTrue(StringValidation.hasNoAlphabetic("123456"));
    }

    @Test
    void hasNoAlphabeticOrWhitespace_withAlphabeticOrWhitespace_returnsFalse() {
        assertFalse(StringValidation.hasNoAlphabeticOrWhitespace("Hello World"));
    }

    @Test
    void hasNoAlphabeticOrWhitespace_withoutAlphabeticOrWhitespace_returnsTrue() {
        assertTrue(StringValidation.hasNoAlphabeticOrWhitespace("123456"));
    }

    @Test
    void hasNoAlphabeticOrDigit_withAlphabeticOrDigit_returnsFalse() {
        assertFalse(StringValidation.hasNoAlphabeticOrDigit("Hello123"));
    }

    @Test
    void hasNoAlphabeticOrDigit_withoutAlphabeticOrDigit_returnsTrue() {
        assertTrue(StringValidation.hasNoAlphabeticOrDigit("!@#"));
    }

    @Test
    void hasNoAlphanumericOrWhitespace_withAlphanumericOrWhitespace_returnsFalse() {
        assertFalse(StringValidation.hasNoAlphanumericOrWhitespace("Hello 123"));
    }

    @Test
    void hasNoAlphanumericOrWhitespace_withoutAlphanumericOrWhitespace_returnsTrue() {
        assertTrue(StringValidation.hasNoAlphanumericOrWhitespace("!@#"));
    }

    @Test
    void hasNoSpecialChar_withSpecialChar_returnsFalse() {
        assertFalse(StringValidation.hasNoSpecialChar("!@#"));
    }

    @Test
    void hasNoSpecialChar_withoutSpecialChar_returnsTrue() {
        assertTrue(StringValidation.hasNoSpecialChar("Hello123"));
    }

    @Test
    void hasNoConsonant_withConsonant_returnsFalse() {
        assertFalse(StringValidation.hasNoConsonant("Hello"));
    }

    @Test
    void hasNoConsonant_withoutConsonant_returnsTrue() {
        assertTrue(StringValidation.hasNoConsonant("aeiou"));
    }

    @Test
    void hasNoVowel_withVowel_returnsFalse() {
        assertFalse(StringValidation.hasNoVowel("Hello"));
    }

    @Test
    void hasNoVowel_withoutVowel_returnsTrue() {
        assertTrue(StringValidation.hasNoVowel("bcdfg"));
    }

    @Test
    void hasNoGlobalLetter_withGlobalLetter_returnsFalse() {
        assertFalse(StringValidation.hasNoGlobalLetter("Hello"));
    }

    @Test
    void hasNoGlobalLetter_withoutGlobalLetter_returnsTrue() {
        assertTrue(StringValidation.hasNoGlobalLetter("123"));
    }

    @Test
    void hasNoGlobalConsonant_withGlobalConsonant_returnsFalse() {
        assertFalse(StringValidation.hasNoGlobalConsonant("Hello"));
    }

    @Test
    void hasNoGlobalConsonant_withoutGlobalConsonant_returnsTrue() {
        assertTrue(StringValidation.hasNoGlobalConsonant("aeiou"));
    }

    @Test
    void hasNoGlobalVowel_withGlobalVowel_returnsFalse() {
        assertFalse(StringValidation.hasNoGlobalVowel("Hello"));
    }

    @Test
    void hasNoGlobalVowel_withoutGlobalVowel_returnsTrue() {
        assertTrue(StringValidation.hasNoGlobalVowel("bcdfg"));
    }

    @Test
    void hasNoNonClusterConsonant_withNonClusterConsonant_returnsFalse() {
        assertFalse(StringValidation.hasNoNonClusterConsonant("Hello"));
    }

    @Test
    void hasNoNonClusterConsonant_withoutNonClusterConsonant_returnsTrue() {
        assertTrue(StringValidation.hasNoNonClusterConsonant("aeiou"));
    }

    @Test
    void hasNoAccentedLetter_withAccentedLetter_returnsFalse() {
        assertFalse(StringValidation.hasNoAccentedLetter("résumé"));
    }

    @Test
    void hasNoAccentedLetter_withoutAccentedLetter_returnsTrue() {
        assertTrue(StringValidation.hasNoAccentedLetter("resume"));
    }

    @Test
    void hasNoUnaccentedLetter_withUnaccentedLetter_returnsFalse() {
        assertFalse(StringValidation.hasNoUnaccentedLetter("Hello"));
    }

    @Test
    void hasNoUnaccentedLetter_withoutUnaccentedLetter_returnsTrue() {
        assertTrue(StringValidation.hasNoUnaccentedLetter("áéíóúüñ"));
    }

    @Test
    void hasNoAccentedConsonant_withAccentedConsonant_returnsFalse() {
        assertFalse(StringValidation.hasNoAccentedConsonant("reçu"));
    }

    @Test
    void hasNoAccentedConsonant_withoutAccentedConsonant_returnsTrue() {
        assertTrue(StringValidation.hasNoAccentedConsonant("resume"));
    }

    @Test
    void hasNoUnaccentedConsonant_withUnaccentedConsonant_returnsFalse() {
        assertFalse(StringValidation.hasNoUnaccentedConsonant("Hello"));
    }

    @Test
    void hasNoUnaccentedConsonant_withoutUnaccentedConsonant_returnsTrue() {
        assertTrue(StringValidation.hasNoUnaccentedConsonant("áéíóúüñçàèìòù"));
    }

    @Test
    void hasNoAccentedVowel_withAccentedVowel_returnsFalse() {
        assertFalse(StringValidation.hasNoAccentedVowel("résumé"));
    }

    @Test
    void hasNoAccentedVowel_withoutAccentedVowel_returnsTrue() {
        assertTrue(StringValidation.hasNoAccentedVowel("resume"));
    }

    @Test
    void hasNoUnaccentedVowel_withUnaccentedVowel_returnsFalse() {
        assertFalse(StringValidation.hasNoUnaccentedVowel("Hello"));
    }

    @Test
    void hasNoUnaccentedVowel_withoutUnaccentedVowel_returnsTrue() {
        assertTrue(StringValidation.hasNoUnaccentedVowel("sí"));
    }

    @Test
    void hasNoSpecialLetter_withSpecialLetter_returnsFalse() {
        assertFalse(StringValidation.hasNoSpecialLetter("아이"));
    }

    @Test
    void hasNoSpecialLetter_withoutSpecialLetter_returnsTrue() {
        assertTrue(StringValidation.hasNoSpecialLetter("facade"));
    }

    @Test
    void hasNoAscii_withAscii_returnsFalse() {
        assertFalse(StringValidation.hasNoAscii("Hello"));
    }

    @Test
    void hasNoAscii_withoutAscii_returnsTrue() {
        assertTrue(StringValidation.hasNoAscii("βαθμός"));
    }

    @Test
    void hasNoAsciiSpace_withAsciiSpace_returnsFalse() {
        assertFalse(StringValidation.hasNoAsciiSpace("Hello World"));
    }

    @Test
    void hasNoAsciiSpace_withoutAsciiSpace_returnsTrue() {
        assertTrue(StringValidation.hasNoAsciiSpace("HelloWorld"));
    }

    @Test
    void hasNoAsciiWhitespace_withAsciiWhitespace_returnsFalse() {
        assertFalse(StringValidation.hasNoAsciiWhitespace("Hello\tWorld"));
    }

    @Test
    void hasNoAsciiWhitespace_withoutAsciiWhitespace_returnsTrue() {
        assertTrue(StringValidation.hasNoAsciiWhitespace("HelloWorld"));
    }

    @Test
    void hasNoAsciiAlpha_withAsciiAlpha_returnsFalse() {
        assertFalse(StringValidation.hasNoAsciiAlpha("Hello"));
    }

    @Test
    void hasNoAsciiAlpha_withoutAsciiAlpha_returnsTrue() {
        assertTrue(StringValidation.hasNoAsciiAlpha("123"));
    }

    @Test
    void hasNoAsciiAlphaLower_withLowercase_returnsFalse() {
        assertFalse(StringValidation.hasNoAsciiAlphaLower("hello"));
    }

    @Test
    void hasNoAsciiAlphaLower_withoutLowercase_returnsTrue() {
        assertTrue(StringValidation.hasNoAsciiAlphaLower("HELLO"));
    }

    @Test
    void hasNoAsciiAlphaUpper_withUppercase_returnsFalse() {
        assertFalse(StringValidation.hasNoAsciiAlphaUpper("HELLO"));
    }

    @Test
    void hasNoAsciiAlphaUpper_withoutUppercase_returnsTrue() {
        assertTrue(StringValidation.hasNoAsciiAlphaUpper("hello"));
    }

    @Test
    void hasNoAsciiNumeric_withNumeric_returnsFalse() {
        assertFalse(StringValidation.hasNoAsciiNumeric("123"));
    }

    @Test
    void hasNoAsciiNumeric_withoutNumeric_returnsTrue() {
        assertTrue(StringValidation.hasNoAsciiNumeric("abc"));
    }

    @Test
    void hasNoAsciiAlphaOrSpace_withAlphaOrSpace_returnsFalse() {
        assertFalse(StringValidation.hasNoAsciiAlphaOrSpace("Hello World"));
    }

    @Test
    void hasNoAsciiAlphaOrSpace_withoutAlphaOrSpace_returnsTrue() {
        assertTrue(StringValidation.hasNoAsciiAlphaOrSpace("123"));
    }

    @Test
    void hasNoAsciiAlphaOrWhitespace_withAlphaOrWhitespace_returnsFalse() {
        assertFalse(StringValidation.hasNoAsciiAlphaOrWhitespace("Hello\tWorld"));
    }

    @Test
    void hasNoAsciiAlphaOrWhitespace_withoutAlphaOrWhitespace_returnsTrue() {
        assertTrue(StringValidation.hasNoAsciiAlphaOrWhitespace("123"));
    }

    @Test
    void hasNoAsciiAlphanumeric_withAlphanumeric_returnsFalse() {
        assertFalse(StringValidation.hasNoAsciiAlphanumeric("Hello123"));
    }

    @Test
    void hasNoAsciiAlphanumeric_withoutAlphanumeric_returnsTrue() {
        assertTrue(StringValidation.hasNoAsciiAlphanumeric("!@#"));
    }

    @Test
    void hasNoAsciiAlphanumericOrSpace_withAlphanumericOrSpace_returnsFalse() {
        assertFalse(StringValidation.hasNoAsciiAlphanumericOrSpace("Hello 123"));
    }

    @Test
    void hasNoAsciiAlphanumericOrSpace_withoutAlphanumericOrSpace_returnsTrue() {
        assertTrue(StringValidation.hasNoAsciiAlphanumericOrSpace("!@#"));
    }

    @Test
    void hasNoAsciiAlphanumericOrWhitespace_withAlphanumericOrWhitespace_returnsFalse() {
        assertFalse(StringValidation.hasNoAsciiAlphanumericOrWhitespace("Hello 123"));
    }

    @Test
    void hasNoAsciiAlphanumericOrWhitespace_withoutAlphanumericOrWhitespace_returnsTrue() {
        assertTrue(StringValidation.hasNoAsciiAlphanumericOrWhitespace("!@#"));
    }

    @Test
    void hasNoDiacritic_withDiacritic_returnsFalse() {
        assertFalse(StringValidation.hasNoDiacritic("résumé"));
    }

    @Test
    void hasNoDiacritic_withoutDiacritic_returnsTrue() {
        assertTrue(StringValidation.hasNoDiacritic("resume"));
    }

    @Test
    void isOnlySpace_withOnlySpaces_returnsTrue() {
        assertTrue(StringValidation.isOnlySpace("     "));
    }

    @Test
    void isOnlySpace_withNonSpaceCharacter_returnsFalse() {
        assertFalse(StringValidation.isOnlySpace(" hello "));
    }

    @Test
    void isOnlyWhitespace_withOnlyWhitespace_returnsTrue() {
        assertTrue(StringValidation.isOnlyWhitespace("\t\n\r "));
    }

    @Test
    void isOnlyWhitespace_withNonWhitespaceCharacter_returnsFalse() {
        assertFalse(StringValidation.isOnlyWhitespace("hello\t\n\r "));
    }

    @Test
    void isOnlyZeroWidthChar_withOnlyZeroWidthChars_returnsTrue() {
        assertTrue(StringValidation.isOnlyZeroWidthChar("\u200B\u200C\u200D\u2060\uFEFF"));
    }

    @Test
    void isOnlyZeroWidthChar_withNonZeroWidthChar_returnsFalse() {
        assertFalse(StringValidation.isOnlyZeroWidthChar("h\u200B"));
    }

    @Test
    void isOnlyLetter_withOnlyLetters_returnsTrue() {
        assertTrue(StringValidation.isOnlyLetter("hello"));
    }

    @Test
    void isOnlyLetter_withNonLetterCharacter_returnsFalse() {
        assertFalse(StringValidation.isOnlyLetter("hello123"));
    }

    @Test
    void isOnlyLowercase_withOnlyLowercase_returnsTrue() {
        assertTrue(StringValidation.isOnlyLowercase("hello"));
    }

    @Test
    void isOnlyLowercase_withUppercase_returnsFalse() {
        assertFalse(StringValidation.isOnlyLowercase("Hello"));
    }

    @Test
    void isOnlyUppercase_withOnlyUppercase_returnsTrue() {
        assertTrue(StringValidation.isOnlyUppercase("HELLO"));
    }

    @Test
    void isOnlyUppercase_withLowercase_returnsFalse() {
        assertFalse(StringValidation.isOnlyUppercase("Hello"));
    }

    @Test
    void isOnlyDigit_withOnlyDigits_returnsTrue() {
        assertTrue(StringValidation.isOnlyDigit("1234567890"));
    }

    @Test
    void isOnlyDigit_withNonDigitCharacter_returnsFalse() {
        assertFalse(StringValidation.isOnlyDigit("123abc"));
    }

    @Test
    void isOnlyLetterOrWhitespace_withOnlyLettersOrWhitespace_returnsTrue() {
        assertTrue(StringValidation.isOnlyLetterOrWhitespace("hello world"));
    }

    @Test
    void isOnlyLetterOrWhitespace_withNonLetterOrWhitespaceCharacter_returnsFalse() {
        assertFalse(StringValidation.isOnlyLetterOrWhitespace("hello_world"));
    }

    @Test
    void isOnlyLetterOrDigit_withOnlyLettersOrDigits_returnsTrue() {
        assertTrue(StringValidation.isOnlyLetterOrDigit("hello123"));
    }

    @Test
    void isOnlyLetterOrDigit_withNonLetterOrDigitCharacter_returnsFalse() {
        assertFalse(StringValidation.isOnlyLetterOrDigit("hello_123"));
    }

    @Test
    void isOnlyLetterDigitOrSpace_withOnlyLettersDigitsOrSpace_returnsTrue() {
        assertTrue(StringValidation.isOnlyLetterDigitOrSpace("hello 123"));
    }

    @Test
    void isOnlyLetterDigitOrSpace_withNonLetterDigitOrSpaceCharacter_returnsFalse() {
        assertFalse(StringValidation.isOnlyLetterDigitOrSpace("hello_123"));
    }

    @Test
    void isOnlyAlphabetic_withOnlyAlphabetic_returnsTrue() {
        assertTrue(StringValidation.isOnlyAlphabetic("Hello"));
    }

    @Test
    void isOnlyAlphabetic_withNonAlphabeticCharacter_returnsFalse() {
        assertFalse(StringValidation.isOnlyAlphabetic("Hello123"));
    }

    @Test
    void isOnlyAlphabeticOrWhitespace_withAlphabeticOrWhitespace_returnsTrue() {
        assertTrue(StringValidation.isOnlyAlphabeticOrWhitespace("Hello World"));
    }

    @Test
    void isOnlyAlphabeticOrWhitespace_withNonAlphabeticOrWhitespace_returnsFalse() {
        assertFalse(StringValidation.isOnlyAlphabeticOrWhitespace("Hello_World"));
    }

    @Test
    void isOnlyAlphabeticOrDigit_withAlphabeticOrDigit_returnsTrue() {
        assertTrue(StringValidation.isOnlyAlphabeticOrDigit("Hello123"));
    }

    @Test
    void isOnlyAlphabeticOrDigit_withNonAlphabeticOrDigit_returnsFalse() {
        assertFalse(StringValidation.isOnlyAlphabeticOrDigit("Hello_123"));
    }

    @Test
    void isOnlyAlphanumericOrWhitespace_withAlphanumericOrWhitespace_returnsTrue() {
        assertTrue(StringValidation.isOnlyAlphanumericOrWhitespace("Hello 123"));
    }

    @Test
    void isOnlyAlphanumericOrWhitespace_withNonAlphanumericOrWhitespace_returnsFalse() {
        assertFalse(StringValidation.isOnlyAlphanumericOrWhitespace("Hello_123"));
    }

    @Test
    void isOnlySpecialChar_withSpecialChar_returnsTrue() {
        assertTrue(StringValidation.isOnlySpecialChar("!@#"));
    }

    @Test
    void isOnlySpecialChar_withNonSpecialChar_returnsFalse() {
        assertFalse(StringValidation.isOnlySpecialChar("Hello"));
    }

    @Test
    void isOnlyConsonant_withConsonant_returnsTrue() {
        assertTrue(StringValidation.isOnlyConsonant("bcdfg"));
    }

    @Test
    void isOnlyConsonant_withNonConsonant_returnsFalse() {
        assertFalse(StringValidation.isOnlyConsonant("aeiou"));
    }

    @Test
    void isOnlyVowel_withVowel_returnsTrue() {
        assertTrue(StringValidation.isOnlyVowel("aeiou"));
    }

    @Test
    void isOnlyVowel_withNonVowel_returnsFalse() {
        assertFalse(StringValidation.isOnlyVowel("bcdfg"));
    }

    @Test
    void isOnlyGlobalLetter_withGlobalLetter_returnsTrue() {
        assertTrue(StringValidation.isOnlyGlobalLetter("Hello"));
    }

    @Test
    void isOnlyGlobalLetter_withNonGlobalLetter_returnsFalse() {
        assertFalse(StringValidation.isOnlyGlobalLetter("123"));
    }

    @Test
    void isOnlyGlobalConsonant_withGlobalConsonant_returnsTrue() {
        assertTrue(StringValidation.isOnlyGlobalConsonant("bcdfg"));
    }

    @Test
    void isOnlyGlobalConsonant_withNonGlobalConsonant_returnsFalse() {
        assertFalse(StringValidation.isOnlyGlobalConsonant("aeiou"));
    }

    @Test
    void isOnlyGlobalVowel_withGlobalVowel_returnsTrue() {
        assertTrue(StringValidation.isOnlyGlobalVowel("aeiou"));
    }

    @Test
    void isOnlyGlobalVowel_withNonGlobalVowel_returnsFalse() {
        assertFalse(StringValidation.isOnlyGlobalVowel("bcdfg"));
    }

    @Test
    void isOnlyNonClusterConsonant_withNonClusterConsonant_returnsTrue() {
        assertTrue(StringValidation.isOnlyNonClusterConsonant("xxx"));
    }

    @Test
    void isOnlyNonClusterConsonant_withClusterConsonant_returnsFalse() {
        assertFalse(StringValidation.isOnlyNonClusterConsonant("bcdfg"));
    }

    @Test
    void isOnlyAccentedLetter_withAccentedLetters_returnsTrue() {
        assertTrue(StringValidation.isOnlyAccentedLetter("éèêë"));
    }

    @Test
    void isOnlyAccentedLetter_withNonAccentedLetters_returnsFalse() {
        assertFalse(StringValidation.isOnlyAccentedLetter("abcd"));
    }

    @Test
    void isOnlyUnaccentedLetter_withUnaccentedLetters_returnsTrue() {
        assertTrue(StringValidation.isOnlyUnaccentedLetter("abcd"));
    }

    @Test
    void isOnlyUnaccentedLetter_withAccentedLetters_returnsFalse() {
        assertFalse(StringValidation.isOnlyUnaccentedLetter("éèêë"));
    }

    @Test
    void isOnlyAccentedConsonant_withAccentedConsonants_returnsTrue() {
        assertTrue(StringValidation.isOnlyAccentedConsonant("ç"));
    }

    @Test
    void isOnlyAccentedConsonant_withNonAccentedConsonants_returnsFalse() {
        assertFalse(StringValidation.isOnlyAccentedConsonant("bcd"));
    }

    @Test
    void isOnlyUnaccentedConsonant_withUnaccentedConsonants_returnsTrue() {
        assertTrue(StringValidation.isOnlyUnaccentedConsonant("bcd"));
    }

    @Test
    void isOnlyUnaccentedConsonant_withAccentedConsonants_returnsFalse() {
        assertFalse(StringValidation.isOnlyUnaccentedConsonant("ç"));
    }

    @Test
    void isOnlyAccentedVowel_withAccentedVowels_returnsTrue() {
        assertTrue(StringValidation.isOnlyAccentedVowel("éèêë"));
    }

    @Test
    void isOnlyAccentedVowel_withNonAccentedVowels_returnsFalse() {
        assertFalse(StringValidation.isOnlyAccentedVowel("aeiou"));
    }

    @Test
    void isOnlyUnaccentedVowel_withUnaccentedVowels_returnsTrue() {
        assertTrue(StringValidation.isOnlyUnaccentedVowel("aeiou"));
    }

    @Test
    void isOnlyUnaccentedVowel_withAccentedVowels_returnsFalse() {
        assertFalse(StringValidation.isOnlyUnaccentedVowel("éèêë"));
    }

    @Test
    void isOnlySpecialLetter_withSpecialLetters_returnsTrue() {
        assertTrue(StringValidation.isOnlySpecialLetter("שלום"));
    }

    @Test
    void isOnlySpecialLetter_withNonSpecialLetters_returnsFalse() {
        assertFalse(StringValidation.isOnlySpecialLetter("abcd"));
    }

    @Test
    void isOnlyAscii_withAsciiCharacters_returnsTrue() {
        assertTrue(StringValidation.isOnlyAscii("abcd1234"));
    }

    @Test
    void isOnlyAscii_withNonAsciiCharacters_returnsFalse() {
        assertFalse(StringValidation.isOnlyAscii("éèêë"));
    }

    @Test
    void isOnlyAsciiSpace_withAsciiSpaces_returnsTrue() {
        assertTrue(StringValidation.isOnlyAsciiSpace("    "));
    }

    @Test
    void isOnlyAsciiSpace_withNonAsciiSpaces_returnsFalse() {
        assertFalse(StringValidation.isOnlyAsciiSpace("abcd"));
    }

    @Test
    void isOnlyAsciiWhitespace_withAsciiWhitespaces_returnsTrue() {
        assertTrue(StringValidation.isOnlyAsciiWhitespace(" \t\n\r"));
    }

    @Test
    void isOnlyAsciiWhitespace_withNonAsciiWhitespaces_returnsFalse() {
        assertFalse(StringValidation.isOnlyAsciiWhitespace("abcd"));
    }

    @Test
    void isOnlyAsciiAlpha_withOnlyAsciiAlpha_returnsTrue() {
        assertTrue(StringValidation.isOnlyAsciiAlpha("abcdABCD"));
    }

    @Test
    void isOnlyAsciiAlpha_withNonAsciiAlpha_returnsFalse() {
        assertFalse(StringValidation.isOnlyAsciiAlpha("abcd1234"));
    }

    @Test
    void isOnlyAsciiAlphaLower_withOnlyAsciiAlphaLower_returnsTrue() {
        assertTrue(StringValidation.isOnlyAsciiAlphaLower("abcd"));
    }

    @Test
    void isOnlyAsciiAlphaLower_withNonAsciiAlphaLower_returnsFalse() {
        assertFalse(StringValidation.isOnlyAsciiAlphaLower("abcdABCD"));
    }

    @Test
    void isOnlyAsciiAlphaUpper_withOnlyAsciiAlphaUpper_returnsTrue() {
        assertTrue(StringValidation.isOnlyAsciiAlphaUpper("ABCD"));
    }

    @Test
    void isOnlyAsciiAlphaUpper_withNonAsciiAlphaUpper_returnsFalse() {
        assertFalse(StringValidation.isOnlyAsciiAlphaUpper("abcdABCD"));
    }

    @Test
    void isOnlyAsciiNumeric_withOnlyAsciiNumeric_returnsTrue() {
        assertTrue(StringValidation.isOnlyAsciiNumeric("1234"));
    }

    @Test
    void isOnlyAsciiNumeric_withNonAsciiNumeric_returnsFalse() {
        assertFalse(StringValidation.isOnlyAsciiNumeric("abcd1234"));
    }

    @Test
    void isOnlyAsciiAlphaOrSpace_withOnlyAsciiAlphaOrSpace_returnsTrue() {
        assertTrue(StringValidation.isOnlyAsciiAlphaOrSpace("abcd ABCD"));
    }

    @Test
    void isOnlyAsciiAlphaOrSpace_withNonAsciiAlphaOrSpace_returnsFalse() {
        assertFalse(StringValidation.isOnlyAsciiAlphaOrSpace("abcd1234"));
    }

    @Test
    void isOnlyAsciiAlphaOrWhitespace_withOnlyAsciiAlphaOrWhitespace_returnsTrue() {
        assertTrue(StringValidation.isOnlyAsciiAlphaOrWhitespace("abcd \t\n\rABCD"));
    }

    @Test
    void isOnlyAsciiAlphaOrWhitespace_withNonAsciiAlphaOrWhitespace_returnsFalse() {
        assertFalse(StringValidation.isOnlyAsciiAlphaOrWhitespace("abcd1234"));
    }

    @Test
    void isOnlyAsciiAlphanumeric_withOnlyAsciiAlphanumeric_returnsTrue() {
        assertTrue(StringValidation.isOnlyAsciiAlphanumeric("abcd1234ABCD"));
    }

    @Test
    void isOnlyAsciiAlphanumeric_withNonAsciiAlphanumeric_returnsFalse() {
        assertFalse(StringValidation.isOnlyAsciiAlphanumeric("abcd1234!"));
    }

    @Test
    void isOnlyAsciiAlphanumericOrSpace_withOnlyAsciiAlphanumericOrSpace_returnsTrue() {
        assertTrue(StringValidation.isOnlyAsciiAlphanumericOrSpace("abcd 1234 ABCD"));
    }

    @Test
    void isOnlyAsciiAlphanumericOrSpace_withNonAsciiAlphanumericOrSpace_returnsFalse() {
        assertFalse(StringValidation.isOnlyAsciiAlphanumericOrSpace("abcd1234!"));
    }

    @Test
    void isOnlyAsciiAlphanumericOrWhitespace_withOnlyAsciiAlphanumericOrWhitespace_returnsTrue() {
        assertTrue(StringValidation.isOnlyAsciiAlphanumericOrWhitespace("abcd \t\n\r1234 ABCD"));
    }

    @Test
    void isOnlyAsciiAlphanumericOrWhitespace_withNonAsciiAlphanumericOrWhitespace_returnsFalse() {
        assertFalse(StringValidation.isOnlyAsciiAlphanumericOrWhitespace("abcd1234!"));
    }
}