package org.memoeslink;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegexFilterTest {

    @Test
    public void keepAlnum_retainsOnlyAlphanumericCharacters() {
        assertEquals("abc123", RegexFilter.keepAlnum("abc123!@#"));
    }

    @Test
    public void keepAlnum_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepAlnum(""));
    }

    @Test
    public void keepAlpha_retainsOnlyAlphabeticCharacters() {
        assertEquals("abc", RegexFilter.keepAlpha("abc123!@#"));
    }

    @Test
    public void keepAlpha_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepAlpha(""));
    }

    @Test
    public void keepAscii_retainsOnlyAsciiCharacters() {
        assertEquals("abc123!@#", RegexFilter.keepAscii("abc123!@#€"));
    }

    @Test
    public void keepAscii_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepAscii(""));
    }

    @Test
    public void keepBlank_retainsOnlySpaceAndTabCharacters() {
        assertEquals(" \t", RegexFilter.keepBlank("abc 123\t!@#"));
    }

    @Test
    public void keepBlank_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepBlank(""));
    }

    @Test
    public void keepCntrl_retainsOnlyControlCharacters() {
        assertEquals("\n\r", RegexFilter.keepCntrl("abc\n123\r!@#"));
    }

    @Test
    public void keepCntrl_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepCntrl(""));
    }

    @Test
    public void keepDigit_retainsOnlyDigitCharacters() {
        assertEquals("123", RegexFilter.keepDigit("abc123!@#"));
    }

    @Test
    public void keepDigit_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepDigit(""));
    }

    @Test
    public void keepLower_retainsOnlyLowercaseCharacters() {
        assertEquals("abc", RegexFilter.keepLower("abcABC123"));
    }

    @Test
    public void keepLower_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepLower(""));
    }

    @Test
    public void keepUpper_retainsOnlyUppercaseCharacters() {
        assertEquals("ABC", RegexFilter.keepUpper("abcABC123"));
    }

    @Test
    public void keepUpper_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepUpper(""));
    }

    @Test
    public void keepPunct_retainsOnlyPunctuationCharacters() {
        assertEquals("!@#", RegexFilter.keepPunct("abc!@#123"));
    }

    @Test
    public void keepPunct_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepPunct(""));
    }

    @Test
    public void keepGraph_retainsOnlyVisibleCharacters() {
        assertEquals("abc123", RegexFilter.keepGraph("abc 123"));
    }

    @Test
    public void keepGraph_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepGraph(""));
    }

    @Test
    public void keepPrint_retainsOnlyPrintableCharacters() {
        assertEquals("abc 123", RegexFilter.keepPrint("abc 123"));
    }

    @Test
    public void keepPrint_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepPrint(""));
    }

    @Test
    public void keepSpace_retainsOnlyWhitespaceCharacters() {
        assertEquals(" ", RegexFilter.keepSpace("abc 123"));
    }

    @Test
    public void keepSpace_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepSpace(""));
    }

    @Test
    public void keepXDigit_retainsOnlyHexadecimalDigits() {
        assertEquals("abc123DEF", RegexFilter.keepXDigit("abc123DEF!@#"));
    }

    @Test
    public void keepXDigit_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepXDigit(""));
    }

    @Test
    public void keepLetter_retainsOnlyLetterCharacters() {
        assertEquals("abc", RegexFilter.keepLetter("abc123!@#"));
    }

    @Test
    public void keepLetter_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepLetter(""));
    }

    @Test
    public void keepLowercaseLetter_retainsOnlyLowercaseLetters() {
        assertEquals("abc", RegexFilter.keepLowercaseLetter("abcABC123"));
    }

    @Test
    public void keepLowercaseLetter_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepLowercaseLetter(""));
    }

    @Test
    public void keepUppercaseLetter_retainsOnlyUppercaseLetters() {
        assertEquals("ABC", RegexFilter.keepUppercaseLetter("abcABC123"));
    }

    @Test
    public void keepUppercaseLetter_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepUppercaseLetter(""));
    }

    @Test
    public void keepTitlecaseLetter_retainsOnlyTitlecaseLetters() {
        assertEquals("ᾎ", RegexFilter.keepTitlecaseLetter("abcABC123ᾎ"));
    }

    @Test
    public void keepTitlecaseLetter_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepTitlecaseLetter(""));
    }

    @Test
    public void keepCasedLetter_retainsOnlyCasedLetters() {
        assertEquals("abcABC", RegexFilter.keepCasedLetter("abcABC123"));
    }

    @Test
    public void keepCasedLetter_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepCasedLetter(""));
    }

    @Test
    public void keepModifierLetter_retainsOnlyModifierLetters() {
        assertEquals("", RegexFilter.keepModifierLetter("abcABC123"));
    }

    @Test
    public void keepModifierLetter_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepModifierLetter(""));
    }

    @Test
    public void keepOtherLetter_retainsOnlyOtherLetters() {
        assertEquals("ƻ", RegexFilter.keepOtherLetter("abcABC123ƻ"));
    }

    @Test
    public void keepOtherLetter_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepOtherLetter(""));
    }

    @Test
    public void keepMark_retainsOnlyMarkCharacters() {
        assertEquals("\u0300\u0301\u0302\u0303\u0304", RegexFilter.keepMark("àéîõū"));
    }

    @Test
    public void keepMark_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepMark(""));
    }

    @Test
    public void keepNonSpacingMark_retainsOnlyNonSpacingMarkCharacters() {
        assertEquals("\u0300\u0301\u0302\u0303\u0304", RegexFilter.keepNonSpacingMark("àéîõū"));
    }

    @Test
    public void keepNonSpacingMark_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepNonSpacingMark(""));
    }

    @Test
    public void keepSpacingCombiningMark_retainsOnlySpacingCombiningMarkCharacters() {
        assertEquals("ाि", RegexFilter.keepSpacingCombiningMark("aाuि"));
    }

    @Test
    public void keepSpacingCombiningMark_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepSpacingCombiningMark(""));
    }

    @Test
    public void keepEnclosingMark_retainsOnlyEnclosingMarkCharacters() {
        assertEquals("⃝", RegexFilter.keepEnclosingMark("a⃝"));
    }

    @Test
    public void keepEnclosingMark_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepEnclosingMark(""));
    }

    @Test
    public void keepSeparator_retainsOnlySeparatorCharacters() {
        assertEquals(" ", RegexFilter.keepSeparator("abc 123"));
    }

    @Test
    public void keepSeparator_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepSeparator(""));
    }

    @Test
    public void keepSpaceSeparator_retainsOnlySpaceSeparatorCharacters() {
        assertEquals(" ", RegexFilter.keepSpaceSeparator("abc 123"));
    }

    @Test
    public void keepSpaceSeparator_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepSpaceSeparator(""));
    }

    @Test
    public void keepLineSeparator_retainsOnlyLineSeparatorCharacters() {
        assertEquals("\u2028", RegexFilter.keepLineSeparator("abc\u2028"));
    }

    @Test
    public void keepLineSeparator_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepLineSeparator(""));
    }

    @Test
    public void keepParagraphSeparator_retainsOnlyParagraphSeparatorCharacters() {
        assertEquals("\u2029", RegexFilter.keepParagraphSeparator("abc\u2029"));
    }

    @Test
    public void keepParagraphSeparator_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepParagraphSeparator(""));
    }

    @Test
    public void keepSymbol_retainsOnlySymbolCharacters() {
        assertEquals("$^", RegexFilter.keepSymbol("abc$%^&*()"));
    }

    @Test
    public void keepSymbol_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepSymbol(""));
    }

    @Test
    public void keepMathSymbol_retainsOnlyMathSymbolCharacters() {
        assertEquals("+−=×÷", RegexFilter.keepMathSymbol("abc+−=×÷"));
    }

    @Test
    public void keepMathSymbol_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepMathSymbol(""));
    }

    @Test
    public void keepCurrencySymbol_retainsOnlyCurrencySymbolCharacters() {
        assertEquals("$", RegexFilter.keepCurrencySymbol("abc$123"));
    }

    @Test
    public void keepCurrencySymbol_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepCurrencySymbol(""));
    }

    @Test
    public void keepModifierSymbol_retainsOnlyModifierSymbolCharacters() {
        assertEquals("^", RegexFilter.keepModifierSymbol("abc^123"));
    }

    @Test
    public void keepModifierSymbol_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepModifierSymbol(""));
    }

    @Test
    public void keepOtherSymbol_retainsOnlyOtherSymbolCharacters() {
        assertEquals("┥", RegexFilter.keepOtherSymbol("abc┥123"));
    }

    @Test
    public void keepOtherSymbol_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepOtherSymbol(""));
    }

    @Test
    public void keepNumber_retainsOnlyNumericCharacters() {
        assertEquals("123", RegexFilter.keepNumber("abc123"));
    }

    @Test
    public void keepNumber_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepNumber(""));
    }

    @Test
    public void keepDecimalDigitNumber_retainsOnlyDecimalDigitNumberCharacters() {
        assertEquals("123", RegexFilter.keepDecimalDigitNumber("abc123"));
    }

    @Test
    public void keepDecimalDigitNumber_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepDecimalDigitNumber(""));
    }

    @Test
    public void keepLetterNumber_retainsOnlyLetterNumberCharacters() {
        assertEquals("Ⅲ", RegexFilter.keepLetterNumber("abcⅢ123"));
    }

    @Test
    public void keepLetterNumber_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepLetterNumber(""));
    }

    @Test
    public void keepOtherNumber_retainsOnlyOtherNumberCharacters() {
        assertEquals("½", RegexFilter.keepOtherNumber("abc½123"));
    }

    @Test
    public void keepOtherNumber_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepOtherNumber(""));
    }

    @Test
    public void keepPunctuation_retainsOnlyPunctuationCharacters() {
        assertEquals("!@#", RegexFilter.keepPunctuation("abc!@#123"));
    }

    @Test
    public void keepPunctuation_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepPunctuation(""));
    }

    @Test
    public void keepDashPunctuation_retainsOnlyDashPunctuationCharacters() {
        assertEquals("-", RegexFilter.keepDashPunctuation("abc-123"));
    }

    @Test
    public void keepDashPunctuation_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepDashPunctuation(""));
    }

    @Test
    public void keepOpenPunctuation_retainsOnlyOpenPunctuationCharacters() {
        assertEquals("(", RegexFilter.keepOpenPunctuation("abc(123"));
    }

    @Test
    public void keepOpenPunctuation_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepOpenPunctuation(""));
    }

    @Test
    public void keepClosePunctuation_retainsOnlyClosePunctuationCharacters() {
        assertEquals(")", RegexFilter.keepClosePunctuation("abc)123"));
    }

    @Test
    public void keepClosePunctuation_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepClosePunctuation(""));
    }

    @Test
    public void keepInitialPunctuation_retainsOnlyInitialPunctuationCharacters() {
        assertEquals("“", RegexFilter.keepInitialPunctuation("abc“123"));
    }

    @Test
    public void keepInitialPunctuation_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepInitialPunctuation(""));
    }

    @Test
    public void keepFinalPunctuation_retainsOnlyFinalPunctuationCharacters() {
        assertEquals("”", RegexFilter.keepFinalPunctuation("abc”123"));
    }

    @Test
    public void keepFinalPunctuation_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepFinalPunctuation(""));
    }

    @Test
    public void keepConnectorPunctuation_retainsOnlyConnectorPunctuationCharacters() {
        assertEquals("_", RegexFilter.keepConnectorPunctuation("abc_123"));
    }

    @Test
    public void keepConnectorPunctuation_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepConnectorPunctuation(""));
    }

    @Test
    public void keepOtherPunctuation_retainsOnlyOtherPunctuationCharacters() {
        assertEquals("!@#", RegexFilter.keepOtherPunctuation("abc!@#123"));
    }

    @Test
    public void keepOtherPunctuation_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepOtherPunctuation(""));
    }

    @Test
    public void keepOther_retainsOnlyOtherCharacters() {
        assertEquals("\uFFF0", RegexFilter.keepOther("abc\uFFF0"));
    }

    @Test
    public void keepOther_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepOther(""));
    }

    @Test
    public void keepControl_retainsOnlyControlCharacters() {
        assertEquals("\u0001", RegexFilter.keepControl("abc\u0001"));
    }

    @Test
    public void keepControl_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepControl(""));
    }

    @Test
    public void keepFormat_retainsOnlyFormatCharacters() {
        assertEquals("\u200E", RegexFilter.keepFormat("abc\u200E"));
    }

    @Test
    public void keepFormat_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepFormat(""));
    }

    @Test
    public void keepPrivateUse_retainsOnlyPrivateUseCharacters() {
        assertEquals("\uE000", RegexFilter.keepPrivateUse("abc\uE000"));
    }

    @Test
    public void keepPrivateUse_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepPrivateUse(""));
    }

    @Test
    public void keepSurrogate_retainsOnlySurrogateCharacters() {
        assertEquals("\uD800", RegexFilter.keepSurrogate("abc\uD800"));
    }

    @Test
    public void keepSurrogate_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepSurrogate(""));
    }

    @Test
    public void keepUnassigned_retainsOnlyUnassignedCharacters() {
        assertEquals("\u0378", RegexFilter.keepUnassigned("abc\u0378"));
    }

    @Test
    public void keepUnassigned_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepUnassigned(""));
    }

    @Test
    public void keepZWChar_retainsOnlyZeroWidthCharacters() {
        assertEquals("\u200B", RegexFilter.keepZWChar("abc\u200B"));
    }

    @Test
    public void keepZWChar_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepZWChar(""));
    }

    @Test
    public void keepDiacriticalLetter_retainsOnlyDiacriticalLetterCharacters() {
        assertEquals("čñá", RegexFilter.keepDiacriticalLetter("abcč`ñá123"));
    }

    @Test
    public void keepDiacriticalLetter_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepDiacriticalLetter(""));
    }

    @Test
    public void keepAlnumSpace_retainsOnlyAlphanumericAndSpaceCharacters() {
        assertEquals("abc 123", RegexFilter.keepAlnumSpace("abc 123_!@#"));
    }

    @Test
    public void keepAlnumSpace_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepAlnumSpace(""));
    }

    @Test
    public void keepAlphanumeric_retainsOnlyAlphanumericCharacters() {
        assertEquals("abc123", RegexFilter.keepAlphanumeric("abc123_!@#"));
    }

    @Test
    public void keepAlphanumeric_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepAlphanumeric(""));
    }

    @Test
    public void keepAlphanumericSpace_retainsOnlyAlphanumericAndSpaceCharacters() {
        assertEquals("abc 123", RegexFilter.keepAlphanumericSpace("abc 123"));
    }

    @Test
    public void keepAlphanumericSpace_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.keepAlphanumericSpace(""));
    }

    @Test
    public void removeAlnum_removesAlphanumericCharacters() {
        assertEquals("", RegexFilter.removeAlnum("abc123"));
    }

    @Test
    public void removeAlnum_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeAlnum(""));
    }

    @Test
    public void removeAlpha_removesAlphabeticCharacters() {
        assertEquals("123", RegexFilter.removeAlpha("abc123"));
    }

    @Test
    public void removeAlpha_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeAlpha(""));
    }

    @Test
    public void removeAscii_removesAsciiCharacters() {
        assertEquals("", RegexFilter.removeAscii("abc123"));
    }

    @Test
    public void removeAscii_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeAscii(""));
    }

    @Test
    public void removeBlank_removesSpaceAndTabCharacters() {
        assertEquals("abc123", RegexFilter.removeBlank("abc 123\t"));
    }

    @Test
    public void removeBlank_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeBlank(""));
    }

    @Test
    public void removeCntrl_removesControlCharacters() {
        assertEquals("abc123", RegexFilter.removeCntrl("abc123\n"));
    }

    @Test
    public void removeCntrl_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeCntrl(""));
    }

    @Test
    public void removeDigit_removesDigitCharacters() {
        assertEquals("abc", RegexFilter.removeDigit("abc123"));
    }

    @Test
    public void removeDigit_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeDigit(""));
    }

    @Test
    public void removeLower_removesLowercaseCharacters() {
        assertEquals("123", RegexFilter.removeLower("abc123"));
    }

    @Test
    public void removeLower_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeLower(""));
    }

    @Test
    public void removeUpper_removesUppercaseCharacters() {
        assertEquals("123", RegexFilter.removeUpper("ABC123"));
    }

    @Test
    public void removeUpper_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeUpper(""));
    }

    @Test
    public void removePunct_removesPunctuationCharacters() {
        assertEquals("abc123", RegexFilter.removePunct("abc!@#123"));
    }

    @Test
    public void removePunct_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removePunct(""));
    }

    @Test
    public void removeGraph_removesVisibleCharacters() {
        assertEquals("", RegexFilter.removeGraph("abc123"));
    }

    @Test
    public void removeGraph_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeGraph(""));
    }

    @Test
    public void removePrint_removesPrintableCharacters() {
        assertEquals("", RegexFilter.removePrint("abc 123"));
    }

    @Test
    public void removePrint_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removePrint(""));
    }

    @Test
    public void removeSpace_removesWhitespaceCharacters() {
        assertEquals("abc123", RegexFilter.removeSpace("abc 123"));
    }

    @Test
    public void removeSpace_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeSpace(""));
    }

    @Test
    public void removeXDigit_removesHexadecimalDigitCharacters() {
        assertEquals("x", RegexFilter.removeXDigit("x123"));
    }

    @Test
    public void removeXDigit_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeXDigit(""));
    }

    @Test
    public void removeLetter_removesLetterCharacters() {
        assertEquals("123", RegexFilter.removeLetter("abc123"));
    }

    @Test
    public void removeLetter_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeLetter(""));
    }

    @Test
    public void removeLowercaseLetter_removesLowercaseCharacters() {
        assertEquals("123", RegexFilter.removeLowercaseLetter("abc123"));
    }

    @Test
    public void removeLowercaseLetter_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeLowercaseLetter(""));
    }

    @Test
    public void removeUppercaseLetter_removesUppercaseCharacters() {
        assertEquals("123", RegexFilter.removeUppercaseLetter("ABC123"));
    }

    @Test
    public void removeUppercaseLetter_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeUppercaseLetter(""));
    }

    @Test
    public void removeTitlecaseLetter_removesTitlecaseCharacters() {
        assertEquals("akon ulice je miran", RegexFilter.removeTitlecaseLetter("ǋakon ulice je miran"));
    }

    @Test
    public void removeTitlecaseLetter_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeTitlecaseLetter(""));
    }

    @Test
    public void removeCasedLetter_removesCasedCharacters() {
        assertEquals("123", RegexFilter.removeCasedLetter("abcABC123"));
    }

    @Test
    public void removeCasedLetter_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeCasedLetter(""));
    }

    @Test
    public void removeModifierLetter_removesModifierCharacters() {
        assertEquals("abc123", RegexFilter.removeModifierLetter("abc123ˑ"));
    }

    @Test
    public void removeModifierLetter_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeModifierLetter(""));
    }

    @Test
    public void removeOtherLetter_removesOtherCharacters() {
        assertEquals("abc123", RegexFilter.removeOtherLetter("abc123"));
    }

    @Test
    public void removeOtherLetter_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeOtherLetter(""));
    }

    @Test
    public void removeMark_removesMarkCharacters() {
        assertEquals("abc123", RegexFilter.removeMark("âbc123"));
    }

    @Test
    public void removeMark_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeMark(""));
    }

    @Test
    public void removeNonSpacingMark_removesNonSpacingMarkCharacters() {
        assertEquals("abc123", RegexFilter.removeNonSpacingMark("âbc123"));
    }

    @Test
    public void removeNonSpacingMark_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeNonSpacingMark(""));
    }

    @Test
    public void removeSpacingCombiningMark_removesSpacingCombiningMarkCharacters() {
        assertEquals("123", RegexFilter.removeSpacingCombiningMark("ः123"));
    }

    @Test
    public void removeSpacingCombiningMark_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeSpacingCombiningMark(""));
    }

    @Test
    public void removeEnclosingMark_removesEnclosingMarkCharacters() {
        assertEquals("abc123", RegexFilter.removeEnclosingMark("abc123⃠"));
    }

    @Test
    public void removeEnclosingMark_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeEnclosingMark(""));
    }

    @Test
    public void removeSeparator_removesSeparatorCharacters() {
        assertEquals("abc123", RegexFilter.removeSeparator("abc 123"));
    }

    @Test
    public void removeSeparator_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeSeparator(""));
    }

    @Test
    public void removeSpaceSeparator_removesSpaceSeparatorCharacters() {
        assertEquals("abc123", RegexFilter.removeSpaceSeparator("abc 123"));
    }

    @Test
    public void removeSpaceSeparator_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeSpaceSeparator(""));
    }

    @Test
    public void removeLineSeparator_removesLineSeparatorCharacters() {
        assertEquals("abc123", RegexFilter.removeLineSeparator("abc\u2028123"));
    }

    @Test
    public void removeLineSeparator_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeLineSeparator(""));
    }

    @Test
    public void removeParagraphSeparator_removesParagraphSeparatorCharacters() {
        assertEquals("abc123", RegexFilter.removeParagraphSeparator("abc\u2029123"));
    }

    @Test
    public void removeParagraphSeparator_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeParagraphSeparator(""));
    }

    @Test
    public void removeSymbol_removesSymbolCharacters() {
        assertEquals("abc123", RegexFilter.removeSymbol("abc$123"));
    }

    @Test
    public void removeSymbol_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeSymbol(""));
    }

    @Test
    public void removeMathSymbol_removesMathSymbolCharacters() {
        assertEquals("abc123", RegexFilter.removeMathSymbol("abc+123"));
    }

    @Test
    public void removeMathSymbol_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeMathSymbol(""));
    }

    @Test
    public void removeCurrencySymbol_removesCurrencySymbolCharacters() {
        assertEquals("100", RegexFilter.removeCurrencySymbol("$100"));
    }

    @Test
    public void removeCurrencySymbol_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeCurrencySymbol(""));
    }

    @Test
    public void removeModifierSymbol_removesModifierSymbolCharacters() {
        assertEquals("ab", RegexFilter.removeModifierSymbol("a^b"));
    }

    @Test
    public void removeModifierSymbol_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeModifierSymbol(""));
    }

    @Test
    public void removeOtherSymbol_removesOtherSymbolCharacters() {
        assertEquals("abc", RegexFilter.removeOtherSymbol("abc⎀"));
    }

    @Test
    public void removeOtherSymbol_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeOtherSymbol(""));
    }

    @Test
    public void removeNumber_removesNumberCharacters() {
        assertEquals("abc", RegexFilter.removeNumber("abc123"));
    }

    @Test
    public void removeNumber_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeNumber(""));
    }

    @Test
    public void removeDecimalDigitNumber_removesDecimalDigitNumberCharacters() {
        assertEquals("abc", RegexFilter.removeDecimalDigitNumber("abc123"));
    }

    @Test
    public void removeDecimalDigitNumber_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeDecimalDigitNumber(""));
    }

    @Test
    public void removeLetterNumber_removesLetterNumberCharacters() {
        assertEquals("abc", RegexFilter.removeLetterNumber("abcⅫ"));
    }

    @Test
    public void removeLetterNumber_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeLetterNumber(""));
    }

    @Test
    public void removeOtherNumber_removesOtherNumberCharacters() {
        assertEquals("abc", RegexFilter.removeOtherNumber("abc½"));
    }

    @Test
    public void removeOtherNumber_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeOtherNumber(""));
    }

    @Test
    public void removePunctuation_removesPunctuationCharacters() {
        assertEquals("abc123", RegexFilter.removePunctuation("abc,123"));
    }

    @Test
    public void removePunctuation_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removePunctuation(""));
    }

    @Test
    public void removeDashPunctuation_removesDashPunctuationCharacters() {
        assertEquals("abc123", RegexFilter.removeDashPunctuation("abc-123"));
    }

    @Test
    public void removeDashPunctuation_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeDashPunctuation(""));
    }

    @Test
    public void removeOpenPunctuation_removesOpenPunctuationCharacters() {
        assertEquals("Hello, world)!", RegexFilter.removeOpenPunctuation("Hello, (world)!"));
    }

    @Test
    public void removeOpenPunctuation_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeOpenPunctuation(""));
    }

    @Test
    public void removeClosePunctuation_removesClosePunctuationCharacters() {
        assertEquals("Hello, (world!", RegexFilter.removeClosePunctuation("Hello, (world)!"));
    }

    @Test
    public void removeClosePunctuation_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeClosePunctuation(""));
    }

    @Test
    public void removeInitialPunctuation_removesInitialPunctuationCharacters() {
        assertEquals("Hello, world!”", RegexFilter.removeInitialPunctuation("“Hello, world!”"));
    }

    @Test
    public void removeInitialPunctuation_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeInitialPunctuation(""));
    }

    @Test
    public void removeFinalPunctuation_removesFinalPunctuationCharacters() {
        assertEquals("“Hello, world!", RegexFilter.removeFinalPunctuation("“Hello, world!”"));
    }

    @Test
    public void removeFinalPunctuation_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeFinalPunctuation(""));
    }

    @Test
    public void removeConnectorPunctuation_removesConnectorPunctuationCharacters() {
        assertEquals("Helloworld!", RegexFilter.removeConnectorPunctuation("Hello_world!"));
    }

    @Test
    public void removeConnectorPunctuation_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeConnectorPunctuation(""));
    }

    @Test
    public void removeOtherPunctuation_removesOtherPunctuationCharacters() {
        assertEquals("Hello world", RegexFilter.removeOtherPunctuation("Hello, world!"));
    }

    @Test
    public void removeOtherPunctuation_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeOtherPunctuation(""));
    }

    @Test
    public void removeOther_removesOtherCharacters() {
        assertEquals("Helloworld!", RegexFilter.removeOther("Hello\uFFF0world!"));
    }

    @Test
    public void removeOther_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeOther(""));
    }

    @Test
    public void removeControl_removesControlCharacters() {
        assertEquals("Helloworld!", RegexFilter.removeControl("Hello\nworld!"));
    }

    @Test
    public void removeControl_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeControl(""));
    }

    @Test
    public void removeFormat_removesFormatCharacters() {
        assertEquals("Helloworld!", RegexFilter.removeFormat("Hello\u200Eworld!"));
    }

    @Test
    public void removeFormat_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeFormat(""));
    }

    @Test
    public void removePrivateUse_removesPrivateUseCharacters() {
        assertEquals("HelloWorld!", RegexFilter.removePrivateUse("Hello\uE000World!"));
    }

    @Test
    public void removePrivateUse_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removePrivateUse(""));
    }

    @Test
    public void removeSurrogate_removesSurrogateCharacters() {
        assertEquals("Hello World!", RegexFilter.removeSurrogate("Hello World!\uDC3C"));
    }

    @Test
    public void removeSurrogate_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeSurrogate(""));
    }

    @Test
    public void removeUnassigned_removesUnassignedCharacters() {
        assertEquals("HelloWorld!", RegexFilter.removeUnassigned("Hello\u0378World!"));
    }

    @Test
    public void removeUnassigned_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeUnassigned(""));
    }

    @Test
    public void removeZWChar_removesZeroWidthCharacters() {
        assertEquals("HelloWorld!", RegexFilter.removeZWChar("Hello\u200BWorld!"));
    }

    @Test
    public void removeZWChar_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeZWChar(""));
    }

    @Test
    public void removeDiacriticalLetter_removesDiacriticalLetterCharacters() {
        assertEquals("HelloWorld!", RegexFilter.removeDiacriticalLetter("HelločñáWorld!"));
    }

    @Test
    public void removeDiacriticalLetter_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeDiacriticalLetter(""));
    }

    @Test
    public void removeAlnumSpace_removesAlphanumericAndSpaceCharacters() {
        assertEquals("!", RegexFilter.removeAlnumSpace("Hello World!"));
    }

    @Test
    public void removeAlnumSpace_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeAlnumSpace(""));
    }

    @Test
    public void removeAlphanumeric_removesAlphanumericCharacters() {
        assertEquals(" !", RegexFilter.removeAlphanumeric("Hello123 World456!"));
    }

    @Test
    public void removeAlphanumeric_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeAlphanumeric(""));
    }

    @Test
    public void removeAlphanumericSpace_removesAlphanumericAndSpaceCharacters() {
        assertEquals("!", RegexFilter.removeAlphanumericSpace("Hello123 World456!"));
    }

    @Test
    public void removeAlphanumericSpace_returnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", RegexFilter.removeAlphanumericSpace(""));
    }

    @Test
    public void countAlnum_countsAlphanumericCharactersInString() {
        assertEquals(6, RegexFilter.countAlnum("abc123"));
    }

    @Test
    public void countAlnum_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countAlnum(""));
    }

    @Test
    public void countAlpha_countsAlphabeticCharactersInString() {
        assertEquals(3, RegexFilter.countAlpha("abc123"));
    }

    @Test
    public void countAlpha_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countAlpha(""));
    }

    @Test
    public void countAscii_countsAsciiCharactersInString() {
        assertEquals(6, RegexFilter.countAscii("abc123"));
    }

    @Test
    public void countAscii_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countAscii(""));
    }

    @Test
    public void countBlank_countsBlankCharactersInString() {
        assertEquals(1, RegexFilter.countBlank("Hello\tWorld"));
    }

    @Test
    public void countBlank_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countBlank(""));
    }

    @Test
    public void countCntrl_countsControlCharactersInString() {
        assertEquals(2, RegexFilter.countCntrl("\nHello\rWorld"));
    }

    @Test
    public void countCntrl_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countCntrl(""));
    }

    @Test
    public void countDigit_countsDigitCharactersInString() {
        assertEquals(6, RegexFilter.countDigit("Hello123World456"));
    }

    @Test
    public void countDigit_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countDigit(""));
    }

    @Test
    public void countLower_countsLowercaseCharactersInString() {
        assertEquals(8, RegexFilter.countLower("HelloWorld"));
    }

    @Test
    public void countLower_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countLower(""));
    }

    @Test
    public void countUpper_countsUppercaseCharactersInString() {
        assertEquals(2, RegexFilter.countUpper("HelloWorld"));
    }

    @Test
    public void countUpper_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countUpper(""));
    }

    @Test
    public void countPunct_countsPunctuationCharactersInString() {
        assertEquals(2, RegexFilter.countPunct("Hello, World!"));
    }

    @Test
    public void countPunct_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countPunct(""));
    }

    @Test
    public void countGraph_countsVisibleCharactersInString() {
        assertEquals(11, RegexFilter.countGraph("Hello World!"));
    }

    @Test
    public void countGraph_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countGraph(""));
    }

    @Test
    public void countPrint_countsPrintableCharactersInString() {
        assertEquals(12, RegexFilter.countPrint("Hello World!"));
    }

    @Test
    public void countPrint_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countPrint(""));
    }

    @Test
    public void countSpace_countsWhitespaceCharactersInString() {
        assertEquals(2, RegexFilter.countSpace("Hello\tWorld\n"));
    }

    @Test
    public void countSpace_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countSpace(""));
    }

    @Test
    public void countXDigit_countsHexadecimalDigitsInString() {
        assertEquals(6, RegexFilter.countXDigit("123abc"));
    }

    @Test
    public void countXDigit_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countXDigit(""));
    }

    @Test
    public void countLetter_countsLetterCharactersInString() {
        assertEquals(5, RegexFilter.countLetter("Hello123"));
    }

    @Test
    public void countLetter_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countLetter(""));
    }

    @Test
    public void countLowercaseLetter_countsLowercaseCharactersInString() {
        assertEquals(4, RegexFilter.countLowercaseLetter("Hello"));
    }

    @Test
    public void countLowercaseLetter_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countLowercaseLetter(""));
    }

    @Test
    public void countUppercaseLetter_countsUppercaseCharactersInString() {
        assertEquals(1, RegexFilter.countUppercaseLetter("Hello"));
    }

    @Test
    public void countUppercaseLetter_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countUppercaseLetter(""));
    }

    @Test
    public void countTitlecaseLetter_countsTitlecaseCharactersInString() {
        assertEquals(1, RegexFilter.countTitlecaseLetter("ǅak"));
    }

    @Test
    public void countTitlecaseLetter_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countTitlecaseLetter(""));
    }

    @Test
    public void countCasedLetter_countsCasedCharactersInString() {
        assertEquals(5, RegexFilter.countCasedLetter("Hello"));
    }

    @Test
    public void countCasedLetter_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countCasedLetter(""));
    }

    @Test
    public void countModifierLetter_countsModifierLetterCharactersInString() {
        assertEquals(1, RegexFilter.countModifierLetter("abcˑ"));
    }

    @Test
    public void countModifierLetter_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countModifierLetter(""));
    }

    @Test
    public void countOtherLetter_countsOtherLetterCharactersInString() {
        assertEquals(1, RegexFilter.countOtherLetter("אabc"));
    }

    @Test
    public void countOtherLetter_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countOtherLetter(""));
    }

    @Test
    public void countMark_countsMarkCharactersInString() {
        assertEquals(1, RegexFilter.countMark("abc̀"));
    }

    @Test
    public void countMark_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countMark(""));
    }

    @Test
    public void countNonSpacingMark_countsNonSpacingMarkCharactersInString() {
        assertEquals(1, RegexFilter.countNonSpacingMark("ö"));
    }

    @Test
    public void countNonSpacingMark_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countNonSpacingMark(""));
    }

    @Test
    public void countSpacingCombiningMark_countsSpacingCombiningMarkCharactersInString() {
        assertEquals(1, RegexFilter.countSpacingCombiningMark("ा"));
    }

    @Test
    public void countSpacingCombiningMark_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countSpacingCombiningMark(""));
    }

    @Test
    public void countEnclosingMark_countsEnclosingMarkCharactersInString() {
        assertEquals(1, RegexFilter.countEnclosingMark("⃝"));
    }

    @Test
    public void countEnclosingMark_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countEnclosingMark(""));
    }

    @Test
    public void countSeparator_countsSeparatorCharactersInString() {
        assertEquals(1, RegexFilter.countSeparator("Hello World"));
    }

    @Test
    public void countSeparator_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countSeparator(""));
    }

    @Test
    public void countSpaceSeparator_countsSpaceSeparatorCharactersInString() {
        assertEquals(1, RegexFilter.countSpaceSeparator("Hello World"));
    }

    @Test
    public void countSpaceSeparator_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countSpaceSeparator(""));
    }

    @Test
    public void countLineSeparator_countsLineSeparatorCharactersInString() {
        assertEquals(1, RegexFilter.countLineSeparator("Hello\u2028World"));
    }

    @Test
    public void countLineSeparator_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countLineSeparator(""));
    }

    @Test
    public void countParagraphSeparator_countsParagraphSeparatorCharactersInString() {
        assertEquals(1, RegexFilter.countParagraphSeparator("Hello\u2029World"));
    }

    @Test
    public void countParagraphSeparator_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countParagraphSeparator(""));
    }

    @Test
    public void countSymbol_countsSymbolCharactersInString() {
        assertEquals(1, RegexFilter.countSymbol("$100.00"));
    }

    @Test
    public void countSymbol_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countSymbol(""));
    }

    @Test
    public void countMathSymbol_countsMathSymbolCharactersInString() {
        assertEquals(1, RegexFilter.countMathSymbol("Hello+World"));
    }

    @Test
    public void countMathSymbol_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countMathSymbol(""));
    }

    @Test
    public void countCurrencySymbol_countsCurrencySymbolCharactersInString() {
        assertEquals(1, RegexFilter.countCurrencySymbol("Hello$World"));
    }

    @Test
    public void countCurrencySymbol_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countCurrencySymbol(""));
    }

    @Test
    public void countModifierSymbol_countsModifierSymbolCharactersInString() {
        assertEquals(1, RegexFilter.countModifierSymbol("Hello^World"));
    }

    @Test
    public void countModifierSymbol_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countModifierSymbol(""));
    }

    @Test
    public void countOtherSymbol_countsOtherSymbolCharactersInString() {
        assertEquals(1, RegexFilter.countOtherSymbol("Hello⛼World"));
    }

    @Test
    public void countOtherSymbol_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countOtherSymbol(""));
    }

    @Test
    public void countNumber_countsNumberCharactersInString() {
        assertEquals(3, RegexFilter.countNumber("Hello123World"));
    }

    @Test
    public void countNumber_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countNumber(""));
    }

    @Test
    public void countDecimalDigitNumber_countsDecimalDigitNumberCharactersInString() {
        assertEquals(3, RegexFilter.countDecimalDigitNumber("123abc"));
    }

    @Test
    public void countDecimalDigitNumber_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countDecimalDigitNumber(""));
    }

    @Test
    public void countLetterNumber_countsLetterNumberCharactersInString() {
        assertEquals(2, RegexFilter.countLetterNumber("ⅭⅧ"));
    }

    @Test
    public void countLetterNumber_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countLetterNumber(""));
    }

    @Test
    public void countOtherNumber_countsOtherNumberCharactersInString() {
        assertEquals(18, RegexFilter.countOtherNumber("½⅓⅔¼¾⅕⅖⅗⅘⅙⅚⅛⅜⅝⅞⅐⅑⅒"));
    }

    @Test
    public void countOtherNumber_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countOtherNumber(""));
    }

    @Test
    public void countPunctuation_countsPunctuationCharactersInString() {
        assertEquals(2, RegexFilter.countPunctuation("Hello, World!"));
    }

    @Test
    public void countPunctuation_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countPunctuation(""));
    }

    @Test
    public void countDashPunctuation_countsDashPunctuationCharactersInString() {
        assertEquals(1, RegexFilter.countDashPunctuation("Hello-World"));
    }

    @Test
    public void countDashPunctuation_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countDashPunctuation(""));
    }

    @Test
    public void countOpenPunctuation_countsOpenPunctuationCharactersInString() {
        assertEquals(1, RegexFilter.countOpenPunctuation("Hello (World)"));
    }

    @Test
    public void countOpenPunctuation_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countOpenPunctuation(""));
    }

    @Test
    public void countClosePunctuation_countsClosePunctuationCharactersInString() {
        assertEquals(1, RegexFilter.countClosePunctuation("Hello (World)"));
    }

    @Test
    public void countClosePunctuation_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countClosePunctuation(""));
    }

    @Test
    public void countInitialPunctuation_countsInitialPunctuationCharactersInString() {
        assertEquals(1, RegexFilter.countInitialPunctuation("‛Hello World’"));
    }

    @Test
    public void countInitialPunctuation_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countInitialPunctuation(""));
    }

    @Test
    public void countFinalPunctuation_countsFinalPunctuationCharactersInString() {
        assertEquals(1, RegexFilter.countFinalPunctuation("‛Hello World’"));
    }

    @Test
    public void countFinalPunctuation_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countFinalPunctuation(""));
    }

    @Test
    public void countConnectorPunctuation_countsConnectorPunctuationCharactersInString() {
        assertEquals(3, RegexFilter.countConnectorPunctuation("_Hello_World_"));
    }

    @Test
    public void countConnectorPunctuation_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countConnectorPunctuation(""));
    }

    @Test
    public void countOtherPunctuation_countsOtherPunctuationCharactersInString() {
        assertEquals(2, RegexFilter.countOtherPunctuation("Hello, World!"));
    }

    @Test
    public void countOtherPunctuation_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countOtherPunctuation(""));
    }

    @Test
    public void countOther_countsOtherCharactersInString() {
        assertEquals(3, RegexFilter.countOther("\uFFF0Hello\uFFF1World\uFFF2"));
    }

    @Test
    public void countOther_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countOther(""));
    }

    @Test
    public void countControl_countsControlCharactersInString() {
        assertEquals(3, RegexFilter.countControl("\u0000Hello\u0001World\u0002"));
    }

    @Test
    public void countControl_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countControl(""));
    }

    @Test
    public void countFormat_countsFormatCharactersInString() {
        assertEquals(3, RegexFilter.countFormat("\u200BHello\u200CWorld\u200D"));
    }

    @Test
    public void countFormat_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countFormat(""));
    }

    @Test
    public void countPrivateUse_countsPrivateUseCharactersInString() {
        assertEquals(3, RegexFilter.countPrivateUse("\uE000Hello\uE001World\uE002"));
    }

    @Test
    public void countPrivateUse_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countPrivateUse(""));
    }

    @Test
    public void countSurrogate_countsSurrogateCharactersInString() {
        assertEquals(1, RegexFilter.countSurrogate("Hello\uDC3CWorld!"));
    }

    @Test
    public void countSurrogate_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countSurrogate(""));
    }

    @Test
    public void countUnassigned_countsUnassignedCharactersInString() {
        assertEquals(3, RegexFilter.countUnassigned("\u0378Hello\u0379World\u0380"));
    }

    @Test
    public void countUnassigned_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countUnassigned(""));
    }

    @Test
    public void countZWChar_countsZeroWidthCharactersInString() {
        assertEquals(3, RegexFilter.countZWChar("\u200BHello\u200CWorld\u200D"));
    }

    @Test
    public void countZWChar_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countZWChar(""));
    }

    @Test
    public void countDiacriticalLetter_countsDiacriticalLetterInString() {
        assertEquals(2, RegexFilter.countDiacriticalLetter("H́ello Ŵorld"));
    }

    @Test
    public void countDiacriticalLetter_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countDiacriticalLetter(""));
    }

    @Test
    public void countAlnumSpace_countsAlphanumericAndSpaceCharactersInString() {
        assertEquals(15, RegexFilter.countAlnumSpace("Hello World 123"));
    }

    @Test
    public void countAlnumSpace_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countAlnumSpace(""));
    }

    @Test
    public void countAlphanumeric_countsAlphanumericCharactersInString() {
        assertEquals(13, RegexFilter.countAlphanumeric("HelloWorld123"));
    }

    @Test
    public void countAlphanumeric_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countAlphanumeric(""));
    }

    @Test
    public void countAlphanumericSpace_countsAlphanumericAndSpaceCharactersInString() {
        assertEquals(15, RegexFilter.countAlphanumericSpace("Hello World 123"));
    }

    @Test
    public void countAlphanumericSpace_returnsZeroWhenInputIsEmpty() {
        assertEquals(0, RegexFilter.countAlphanumericSpace(""));
    }
}