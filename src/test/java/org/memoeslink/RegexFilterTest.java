package org.memoeslink;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class RegexFilterTest {

    @Nested
    class KeepAlnum {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepAlnum(null));
        }

        @Test
        void withEmpty_returnsEmpty() {
            assertEquals("", RegexFilter.keepAlnum(""));
        }

        @Test
        void withMixedContent_returnsOnlyAlnum() {
            assertEquals("hello123", RegexFilter.keepAlnum("hello 123!"));
        }

        @Test
        void withNoAlnum_returnsEmpty() {
            assertEquals("", RegexFilter.keepAlnum("!@# "));
        }
    }

    @Nested
    class RemoveAlnum {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeAlnum(null));
        }

        @Test
        void withMixedContent_removesAlnum() {
            assertEquals(" !", RegexFilter.removeAlnum("hello 123!"));
        }

        @Test
        void withAlnumOnly_returnsEmpty() {
            assertEquals("", RegexFilter.removeAlnum("hello123"));
        }
    }

    @Nested
    class KeepAlpha {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepAlpha(null));
        }

        @Test
        void withMixedContent_returnsOnlyAlpha() {
            assertEquals("hello", RegexFilter.keepAlpha("hello 123!"));
        }

        @Test
        void withNoAlpha_returnsEmpty() {
            assertEquals("", RegexFilter.keepAlpha("123 !"));
        }
    }

    @Nested
    class RemoveAlpha {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeAlpha(null));
        }

        @Test
        void withMixedContent_removesAlpha() {
            assertEquals(" 123!", RegexFilter.removeAlpha("hello 123!"));
        }

        @Test
        void withAlphaOnly_returnsEmpty() {
            assertEquals("", RegexFilter.removeAlpha("hello"));
        }
    }

    @Nested
    class KeepAscii {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepAscii(null));
        }

        @Test
        void withMixedContent_returnsOnlyAscii() {
            assertEquals("hllo", RegexFilter.keepAscii("héllo"));
        }

        @Test
        void withNonAsciiOnly_returnsEmpty() {
            assertEquals("", RegexFilter.keepAscii("中文"));
        }
    }

    @Nested
    class RemoveAscii {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeAscii(null));
        }

        @Test
        void withMixedContent_removesAscii() {
            assertEquals("é", RegexFilter.removeAscii("héllo"));
        }

        @Test
        void withAsciiOnly_returnsEmpty() {
            assertEquals("", RegexFilter.removeAscii("hello"));
        }
    }

    @Nested
    class KeepBlank {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepBlank(null));
        }

        @Test
        void withMixedContent_returnsOnlySpacesAndTabs() {
            assertEquals(" \t", RegexFilter.keepBlank("h \te"));
        }

        @Test
        void withNoBlank_returnsEmpty() {
            assertEquals("", RegexFilter.keepBlank("hello"));
        }
    }

    @Nested
    class RemoveBlank {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeBlank(null));
        }

        @Test
        void withMixedContent_removesSpacesAndTabs() {
            assertEquals("he", RegexFilter.removeBlank("h \te"));
        }

        @Test
        void withBlankOnly_returnsEmpty() {
            assertEquals("", RegexFilter.removeBlank(" \t"));
        }
    }

    @Nested
    class KeepCntrl {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepCntrl(null));
        }

        @Test
        void withMixedContent_returnsOnlyControlChars() {
            assertEquals("\u0001", RegexFilter.keepCntrl("hello\u0001"));
        }

        @Test
        void withNoControlChar_returnsEmpty() {
            assertEquals("", RegexFilter.keepCntrl("hello"));
        }
    }

    @Nested
    class RemoveCntrl {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeCntrl(null));
        }

        @Test
        void withMixedContent_removesControlChars() {
            assertEquals("hello", RegexFilter.removeCntrl("hello\u0001"));
        }

        @Test
        void withControlCharOnly_returnsEmpty() {
            assertEquals("", RegexFilter.removeCntrl("\u0001\u0002"));
        }
    }

    @Nested
    class KeepDigit {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepDigit(null));
        }

        @Test
        void withMixedContent_returnsOnlyDigits() {
            assertEquals("123", RegexFilter.keepDigit("hello 123!"));
        }

        @Test
        void withNoDigit_returnsEmpty() {
            assertEquals("", RegexFilter.keepDigit("hello!"));
        }
    }

    @Nested
    class RemoveDigit {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeDigit(null));
        }

        @Test
        void withMixedContent_removesDigits() {
            assertEquals("hello !", RegexFilter.removeDigit("hello 123!"));
        }

        @Test
        void withDigitsOnly_returnsEmpty() {
            assertEquals("", RegexFilter.removeDigit("123"));
        }
    }

    @Nested
    class KeepLower {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepLower(null));
        }

        @Test
        void withMixedCase_returnsOnlyLowercase() {
            assertEquals("ello", RegexFilter.keepLower("Hello"));
        }

        @Test
        void withAllUppercase_returnsEmpty() {
            assertEquals("", RegexFilter.keepLower("HELLO"));
        }
    }

    @Nested
    class RemoveLower {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeLower(null));
        }

        @Test
        void withMixedCase_removesLowercase() {
            assertEquals("H", RegexFilter.removeLower("Hello"));
        }

        @Test
        void withAllLowercase_returnsEmpty() {
            assertEquals("", RegexFilter.removeLower("hello"));
        }
    }

    @Nested
    class KeepUpper {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepUpper(null));
        }

        @Test
        void withMixedCase_returnsOnlyUppercase() {
            assertEquals("H", RegexFilter.keepUpper("Hello"));
        }

        @Test
        void withAllLowercase_returnsEmpty() {
            assertEquals("", RegexFilter.keepUpper("hello"));
        }
    }

    @Nested
    class RemoveUpper {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeUpper(null));
        }

        @Test
        void withMixedCase_removesUppercase() {
            assertEquals("ello", RegexFilter.removeUpper("Hello"));
        }

        @Test
        void withAllUppercase_returnsEmpty() {
            assertEquals("", RegexFilter.removeUpper("HELLO"));
        }
    }

    @Nested
    class KeepPunct {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepPunct(null));
        }

        @Test
        void withMixedContent_returnsOnlyPunct() {
            assertEquals("!,", RegexFilter.keepPunct("hello!, world"));
        }

        @Test
        void withNoPunct_returnsEmpty() {
            assertEquals("", RegexFilter.keepPunct("hello123"));
        }
    }

    @Nested
    class RemovePunct {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removePunct(null));
        }

        @Test
        void withMixedContent_removesPunct() {
            assertEquals("hello world", RegexFilter.removePunct("hello!, world"));
        }

        @Test
        void withPunctOnly_returnsEmpty() {
            assertEquals("", RegexFilter.removePunct("!,."));
        }
    }

    @Nested
    class KeepGraph {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepGraph(null));
        }

        @Test
        void withMixedContent_returnsOnlyVisibleChars() {
            assertEquals("hello!", RegexFilter.keepGraph("hello! "));
        }

        @Test
        void withSpaceOnly_returnsEmpty() {
            assertEquals("", RegexFilter.keepGraph("   "));
        }
    }

    @Nested
    class RemoveGraph {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeGraph(null));
        }

        @Test
        void withMixedContent_removesVisibleChars() {
            assertEquals(" ", RegexFilter.removeGraph("hello! "));
        }

        @Test
        void withVisibleCharsOnly_returnsEmpty() {
            assertEquals("", RegexFilter.removeGraph("hello!"));
        }
    }

    @Nested
    class KeepPrint {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepPrint(null));
        }

        @Test
        void withMixedContent_returnsOnlyPrintableChars() {
            assertEquals("hello! ", RegexFilter.keepPrint("hello! \u0001"));
        }

        @Test
        void withControlCharsOnly_returnsEmpty() {
            assertEquals("", RegexFilter.keepPrint("\u0001\u0002"));
        }
    }

    @Nested
    class RemovePrint {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removePrint(null));
        }

        @Test
        void withMixedContent_removesPrintableChars() {
            assertEquals("\u0001", RegexFilter.removePrint("hello! \u0001"));
        }

        @Test
        void withPrintableCharsOnly_returnsEmpty() {
            assertEquals("", RegexFilter.removePrint("hello! "));
        }
    }

    @Nested
    class KeepSpace {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepSpace(null));
        }

        @Test
        void withMixedContent_returnsOnlyWhitespace() {
            assertEquals(" \t\n", RegexFilter.keepSpace("h \t\ne"));
        }

        @Test
        void withNoWhitespace_returnsEmpty() {
            assertEquals("", RegexFilter.keepSpace("hello"));
        }
    }

    @Nested
    class RemoveSpace {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeSpace(null));
        }

        @Test
        void withMixedContent_removesWhitespace() {
            assertEquals("he", RegexFilter.removeSpace("h \t\ne"));
        }

        @Test
        void withWhitespaceOnly_returnsEmpty() {
            assertEquals("", RegexFilter.removeSpace(" \t\n"));
        }
    }

    @Nested
    class KeepXDigit {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepXDigit(null));
        }

        @Test
        void withMixedContent_returnsOnlyHexChars() {
            assertEquals("1a2b", RegexFilter.keepXDigit("1a2b!gz"));
        }

        @Test
        void withNoHexChar_returnsEmpty() {
            assertEquals("", RegexFilter.keepXDigit("ghi!"));
        }
    }

    @Nested
    class RemoveXDigit {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeXDigit(null));
        }

        @Test
        void withMixedContent_removesHexChars() {
            assertEquals("!gz", RegexFilter.removeXDigit("1a2b!gz"));
        }

        @Test
        void withHexCharsOnly_returnsEmpty() {
            assertEquals("", RegexFilter.removeXDigit("1a2bFF"));
        }
    }

    @Nested
    class KeepLetter {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepLetter(null));
        }

        @Test
        void withMixedContent_returnsOnlyLetters() {
            assertEquals("héllo", RegexFilter.keepLetter("héllo 123!"));
        }

        @Test
        void withNoLetter_returnsEmpty() {
            assertEquals("", RegexFilter.keepLetter("123 !"));
        }
    }

    @Nested
    class RemoveLetter {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeLetter(null));
        }

        @Test
        void withMixedContent_removesLetters() {
            assertEquals(" 123!", RegexFilter.removeLetter("héllo 123!"));
        }

        @Test
        void withLettersOnly_returnsEmpty() {
            assertEquals("", RegexFilter.removeLetter("héllo"));
        }
    }

    @Nested
    class KeepLowercaseLetter {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepLowercaseLetter(null));
        }

        @Test
        void withMixedCase_returnsOnlyLowercaseLetters() {
            assertEquals("éllo", RegexFilter.keepLowercaseLetter("Héllo"));
        }

        @Test
        void withAllUppercase_returnsEmpty() {
            assertEquals("", RegexFilter.keepLowercaseLetter("HELLO"));
        }
    }

    @Nested
    class RemoveLowercaseLetter {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeLowercaseLetter(null));
        }

        @Test
        void withMixedCase_removesLowercaseLetters() {
            assertEquals("H", RegexFilter.removeLowercaseLetter("Héllo"));
        }

        @Test
        void withAllLowercase_returnsEmpty() {
            assertEquals("", RegexFilter.removeLowercaseLetter("héllo"));
        }
    }

    @Nested
    class KeepUppercaseLetter {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepUppercaseLetter(null));
        }

        @Test
        void withMixedCase_returnsOnlyUppercaseLetters() {
            assertEquals("H", RegexFilter.keepUppercaseLetter("Héllo"));
        }

        @Test
        void withAllLowercase_returnsEmpty() {
            assertEquals("", RegexFilter.keepUppercaseLetter("héllo"));
        }
    }

    @Nested
    class RemoveUppercaseLetter {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeUppercaseLetter(null));
        }

        @Test
        void withMixedCase_removesUppercaseLetters() {
            assertEquals("éllo", RegexFilter.removeUppercaseLetter("Héllo"));
        }

        @Test
        void withAllUppercase_returnsEmpty() {
            assertEquals("", RegexFilter.removeUppercaseLetter("HELLO"));
        }
    }

    @Nested
    class KeepTitlecaseLetter {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepTitlecaseLetter(null));
        }

        @Test
        void withTitlecaseLetter_returnsTitlecaseLetter() {
            assertEquals("\u01F2", RegexFilter.keepTitlecaseLetter("hello\u01F2world"));
        }

        @Test
        void withNoTitlecaseLetter_returnsEmpty() {
            assertEquals("", RegexFilter.keepTitlecaseLetter("hello"));
        }
    }

    @Nested
    class RemoveTitlecaseLetter {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeTitlecaseLetter(null));
        }

        @Test
        void withTitlecaseLetter_removesTitlecaseLetter() {
            assertEquals("helloworld", RegexFilter.removeTitlecaseLetter("hello\u01F2world"));
        }

        @Test
        void withNoTitlecaseLetter_returnsUnchanged() {
            assertEquals("hello", RegexFilter.removeTitlecaseLetter("hello"));
        }
    }

    @Nested
    class KeepCasedLetter {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepCasedLetter(null));
        }

        @Test
        void withMixedContent_returnsOnlyCasedLetters() {
            assertEquals("Hello", RegexFilter.keepCasedLetter("Hello 123!"));
        }

        @Test
        void withNoCasedLetter_returnsEmpty() {
            assertEquals("", RegexFilter.keepCasedLetter("123 !"));
        }
    }

    @Nested
    class RemoveCasedLetter {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeCasedLetter(null));
        }

        @Test
        void withMixedContent_removesCasedLetters() {
            assertEquals(" 123!", RegexFilter.removeCasedLetter("Hello 123!"));
        }

        @Test
        void withCasedLettersOnly_returnsEmpty() {
            assertEquals("", RegexFilter.removeCasedLetter("Hello"));
        }
    }

    @Nested
    class KeepModifierLetter {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepModifierLetter(null));
        }

        @Test
        void withModifierLetter_returnsModifierLetter() {
            assertEquals("\u02B0", RegexFilter.keepModifierLetter("hello\u02B0world"));
        }

        @Test
        void withNoModifierLetter_returnsEmpty() {
            assertEquals("", RegexFilter.keepModifierLetter("hello"));
        }
    }

    @Nested
    class RemoveModifierLetter {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeModifierLetter(null));
        }

        @Test
        void withModifierLetter_removesModifierLetter() {
            assertEquals("helloworld", RegexFilter.removeModifierLetter("hello\u02B0world"));
        }

        @Test
        void withNoModifierLetter_returnsUnchanged() {
            assertEquals("hello", RegexFilter.removeModifierLetter("hello"));
        }
    }

    @Nested
    class KeepOtherLetter {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepOtherLetter(null));
        }

        @Test
        void withOtherLetter_returnsOtherLetter() {
            assertEquals("中文", RegexFilter.keepOtherLetter("hello中文"));
        }

        @Test
        void withNoOtherLetter_returnsEmpty() {
            assertEquals("", RegexFilter.keepOtherLetter("hello"));
        }
    }

    @Nested
    class RemoveOtherLetter {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeOtherLetter(null));
        }

        @Test
        void withOtherLetter_removesOtherLetter() {
            assertEquals("hello", RegexFilter.removeOtherLetter("hello中文"));
        }

        @Test
        void withOtherLettersOnly_returnsEmpty() {
            assertEquals("", RegexFilter.removeOtherLetter("中文"));
        }
    }

    @Nested
    class KeepMark {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepMark(null));
        }

        @Test
        void withMarkChar_returnsMarkChar() {
            assertEquals("\u0300", RegexFilter.keepMark("hello\u0300"));
        }

        @Test
        void withNoMarkChar_returnsEmpty() {
            assertEquals("", RegexFilter.keepMark("hello"));
        }
    }

    @Nested
    class RemoveMark {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeMark(null));
        }

        @Test
        void withMarkChar_removesMarkChar() {
            assertEquals("hello", RegexFilter.removeMark("hello\u0300"));
        }

        @Test
        void withNoMarkChar_returnsUnchanged() {
            assertEquals("hello", RegexFilter.removeMark("hello"));
        }
    }

    @Nested
    class KeepSeparator {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepSeparator(null));
        }

        @Test
        void withSeparatorChar_returnsSeparatorChar() {
            assertEquals(" ", RegexFilter.keepSeparator("hello world"));
        }

        @Test
        void withNoSeparatorChar_returnsEmpty() {
            assertEquals("", RegexFilter.keepSeparator("hello!"));
        }
    }

    @Nested
    class RemoveSeparator {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeSeparator(null));
        }

        @Test
        void withSeparatorChar_removesSeparatorChar() {
            assertEquals("helloworld", RegexFilter.removeSeparator("hello world"));
        }

        @Test
        void withNoSeparatorChar_returnsUnchanged() {
            assertEquals("hello!", RegexFilter.removeSeparator("hello!"));
        }
    }

    @Nested
    class KeepSymbol {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepSymbol(null));
        }

        @Test
        void withSymbol_returnsSymbol() {
            assertEquals("$+", RegexFilter.keepSymbol("hello$+world"));
        }

        @Test
        void withNoSymbol_returnsEmpty() {
            assertEquals("", RegexFilter.keepSymbol("hello"));
        }
    }

    @Nested
    class RemoveSymbol {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeSymbol(null));
        }

        @Test
        void withSymbol_removesSymbol() {
            assertEquals("helloworld", RegexFilter.removeSymbol("hello$+world"));
        }

        @Test
        void withNoSymbol_returnsUnchanged() {
            assertEquals("hello", RegexFilter.removeSymbol("hello"));
        }
    }

    @Nested
    class KeepMathSymbol {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepMathSymbol(null));
        }

        @Test
        void withMathSymbol_returnsMathSymbol() {
            assertEquals("+", RegexFilter.keepMathSymbol("hello+world"));
        }

        @Test
        void withNoMathSymbol_returnsEmpty() {
            assertEquals("", RegexFilter.keepMathSymbol("hello"));
        }
    }

    @Nested
    class RemoveMathSymbol {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeMathSymbol(null));
        }

        @Test
        void withMathSymbol_removesMathSymbol() {
            assertEquals("helloworld", RegexFilter.removeMathSymbol("hello+world"));
        }

        @Test
        void withNoMathSymbol_returnsUnchanged() {
            assertEquals("hello", RegexFilter.removeMathSymbol("hello"));
        }
    }

    @Nested
    class KeepCurrencySymbol {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepCurrencySymbol(null));
        }

        @Test
        void withCurrencySymbol_returnsCurrencySymbol() {
            assertEquals("$", RegexFilter.keepCurrencySymbol("hello$world"));
        }

        @Test
        void withNoCurrencySymbol_returnsEmpty() {
            assertEquals("", RegexFilter.keepCurrencySymbol("hello"));
        }
    }

    @Nested
    class RemoveCurrencySymbol {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeCurrencySymbol(null));
        }

        @Test
        void withCurrencySymbol_removesCurrencySymbol() {
            assertEquals("helloworld", RegexFilter.removeCurrencySymbol("hello$world"));
        }

        @Test
        void withNoCurrencySymbol_returnsUnchanged() {
            assertEquals("hello", RegexFilter.removeCurrencySymbol("hello"));
        }
    }

    @Nested
    class KeepNumber {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepNumber(null));
        }

        @Test
        void withMixedContent_returnsOnlyNumbers() {
            assertEquals("123", RegexFilter.keepNumber("hello 123!"));
        }

        @Test
        void withNoNumber_returnsEmpty() {
            assertEquals("", RegexFilter.keepNumber("hello!"));
        }
    }

    @Nested
    class RemoveNumber {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeNumber(null));
        }

        @Test
        void withMixedContent_removesNumbers() {
            assertEquals("hello !", RegexFilter.removeNumber("hello 123!"));
        }

        @Test
        void withNumbersOnly_returnsEmpty() {
            assertEquals("", RegexFilter.removeNumber("123"));
        }
    }

    @Nested
    class KeepDecimalDigitNumber {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepDecimalDigitNumber(null));
        }

        @Test
        void withMixedContent_returnsOnlyDecimalDigits() {
            assertEquals("123", RegexFilter.keepDecimalDigitNumber("hello 123!"));
        }

        @Test
        void withNoDecimalDigit_returnsEmpty() {
            assertEquals("", RegexFilter.keepDecimalDigitNumber("hello!"));
        }
    }

    @Nested
    class RemoveDecimalDigitNumber {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeDecimalDigitNumber(null));
        }

        @Test
        void withMixedContent_removesDecimalDigits() {
            assertEquals("hello !", RegexFilter.removeDecimalDigitNumber("hello 123!"));
        }

        @Test
        void withDecimalDigitsOnly_returnsEmpty() {
            assertEquals("", RegexFilter.removeDecimalDigitNumber("123"));
        }
    }

    @Nested
    class KeepLetterNumber {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepLetterNumber(null));
        }

        @Test
        void withLetterNumber_returnsLetterNumber() {
            assertEquals("\u2160", RegexFilter.keepLetterNumber("hello\u2160world"));
        }

        @Test
        void withNoLetterNumber_returnsEmpty() {
            assertEquals("", RegexFilter.keepLetterNumber("hello123"));
        }
    }

    @Nested
    class RemoveLetterNumber {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeLetterNumber(null));
        }

        @Test
        void withLetterNumber_removesLetterNumber() {
            assertEquals("helloworld", RegexFilter.removeLetterNumber("hello\u2160world"));
        }

        @Test
        void withNoLetterNumber_returnsUnchanged() {
            assertEquals("hello", RegexFilter.removeLetterNumber("hello"));
        }
    }

    @Nested
    class KeepPunctuation {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepPunctuation(null));
        }

        @Test
        void withMixedContent_returnsOnlyPunctuation() {
            assertEquals("!,", RegexFilter.keepPunctuation("hello!, world"));
        }

        @Test
        void withNoPunctuation_returnsEmpty() {
            assertEquals("", RegexFilter.keepPunctuation("hello123"));
        }
    }

    @Nested
    class RemovePunctuation {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removePunctuation(null));
        }

        @Test
        void withMixedContent_removesPunctuation() {
            assertEquals("hello world", RegexFilter.removePunctuation("hello!, world"));
        }

        @Test
        void withPunctuationOnly_returnsEmpty() {
            assertEquals("", RegexFilter.removePunctuation("!,."));
        }
    }

    @Nested
    class KeepDashPunctuation {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepDashPunctuation(null));
        }

        @Test
        void withDashPunctuation_returnsDashPunctuation() {
            assertEquals("-", RegexFilter.keepDashPunctuation("hello-world"));
        }

        @Test
        void withNoDashPunctuation_returnsEmpty() {
            assertEquals("", RegexFilter.keepDashPunctuation("hello!"));
        }
    }

    @Nested
    class RemoveDashPunctuation {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeDashPunctuation(null));
        }

        @Test
        void withDashPunctuation_removesDashPunctuation() {
            assertEquals("helloworld", RegexFilter.removeDashPunctuation("hello-world"));
        }

        @Test
        void withNoDashPunctuation_returnsUnchanged() {
            assertEquals("hello", RegexFilter.removeDashPunctuation("hello"));
        }
    }

    @Nested
    class KeepOpenPunctuation {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepOpenPunctuation(null));
        }

        @Test
        void withOpenPunctuation_returnsOpenPunctuation() {
            assertEquals("([", RegexFilter.keepOpenPunctuation("(hello[world"));
        }

        @Test
        void withNoOpenPunctuation_returnsEmpty() {
            assertEquals("", RegexFilter.keepOpenPunctuation("hello!"));
        }
    }

    @Nested
    class RemoveOpenPunctuation {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeOpenPunctuation(null));
        }

        @Test
        void withOpenPunctuation_removesOpenPunctuation() {
            assertEquals("helloworld", RegexFilter.removeOpenPunctuation("(hello[world"));
        }

        @Test
        void withNoOpenPunctuation_returnsUnchanged() {
            assertEquals("hello", RegexFilter.removeOpenPunctuation("hello"));
        }
    }

    @Nested
    class KeepClosePunctuation {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepClosePunctuation(null));
        }

        @Test
        void withClosePunctuation_returnsClosePunctuation() {
            assertEquals(")]", RegexFilter.keepClosePunctuation("hello)world]"));
        }

        @Test
        void withNoClosePunctuation_returnsEmpty() {
            assertEquals("", RegexFilter.keepClosePunctuation("hello!"));
        }
    }

    @Nested
    class RemoveClosePunctuation {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeClosePunctuation(null));
        }

        @Test
        void withClosePunctuation_removesClosePunctuation() {
            assertEquals("helloworld", RegexFilter.removeClosePunctuation("hello)world]"));
        }

        @Test
        void withNoClosePunctuation_returnsUnchanged() {
            assertEquals("hello", RegexFilter.removeClosePunctuation("hello"));
        }
    }

    @Nested
    class KeepOtherPunctuation {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepOtherPunctuation(null));
        }

        @Test
        void withOtherPunctuation_returnsOtherPunctuation() {
            assertEquals("!", RegexFilter.keepOtherPunctuation("hello!"));
        }

        @Test
        void withNoOtherPunctuation_returnsEmpty() {
            assertEquals("", RegexFilter.keepOtherPunctuation("hello"));
        }
    }

    @Nested
    class RemoveOtherPunctuation {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeOtherPunctuation(null));
        }

        @Test
        void withOtherPunctuation_removesOtherPunctuation() {
            assertEquals("hello", RegexFilter.removeOtherPunctuation("hello!"));
        }

        @Test
        void withNoOtherPunctuation_returnsUnchanged() {
            assertEquals("hello", RegexFilter.removeOtherPunctuation("hello"));
        }
    }

    @Nested
    class KeepZWChar {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepZWChar(null));
        }

        @Test
        void withZeroWidthChar_returnsZeroWidthChar() {
            assertEquals("\u200B", RegexFilter.keepZWChar("hello\u200Bworld"));
        }

        @Test
        void withNoZeroWidthChar_returnsEmpty() {
            assertEquals("", RegexFilter.keepZWChar("hello"));
        }
    }

    @Nested
    class RemoveZWChar {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeZWChar(null));
        }

        @Test
        void withZeroWidthChar_removesZeroWidthChar() {
            assertEquals("helloworld", RegexFilter.removeZWChar("hello\u200Bworld"));
        }

        @Test
        void withNoZeroWidthChar_returnsUnchanged() {
            assertEquals("hello", RegexFilter.removeZWChar("hello"));
        }
    }

    @Nested
    class KeepDiacriticalLetter {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepDiacriticalLetter(null));
        }

        @Test
        void withDiacriticalLetter_returnsDiacriticalLetter() {
            assertEquals("é", RegexFilter.keepDiacriticalLetter("café"));
        }

        @Test
        void withNoDiacriticalLetter_returnsEmpty() {
            assertEquals("", RegexFilter.keepDiacriticalLetter("hello"));
        }
    }

    @Nested
    class RemoveDiacriticalLetter {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeDiacriticalLetter(null));
        }

        @Test
        void withDiacriticalLetter_removesDiacriticalLetter() {
            assertEquals("caf", RegexFilter.removeDiacriticalLetter("café"));
        }

        @Test
        void withNoDiacriticalLetter_returnsUnchanged() {
            assertEquals("hello", RegexFilter.removeDiacriticalLetter("hello"));
        }
    }

    @Nested
    class KeepAlnumSpace {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepAlnumSpace(null));
        }

        @Test
        void withMixedContent_returnsAlnumAndSpaces() {
            assertEquals("hello 123", RegexFilter.keepAlnumSpace("hello 123!"));
        }

        @Test
        void withSpecialCharsOnly_returnsEmpty() {
            assertEquals("", RegexFilter.keepAlnumSpace("!@#"));
        }
    }

    @Nested
    class RemoveAlnumSpace {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeAlnumSpace(null));
        }

        @Test
        void withMixedContent_removesAlnumAndSpaces() {
            assertEquals("!", RegexFilter.removeAlnumSpace("hello 123!"));
        }

        @Test
        void withAlnumAndSpaceOnly_returnsEmpty() {
            assertEquals("", RegexFilter.removeAlnumSpace("hello 123"));
        }
    }

    @Nested
    class KeepAlphanumeric {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepAlphanumeric(null));
        }

        @Test
        void withMixedContent_returnsOnlyAlphanumeric() {
            assertEquals("héllo123", RegexFilter.keepAlphanumeric("héllo 123!"));
        }

        @Test
        void withSpecialCharsOnly_returnsEmpty() {
            assertEquals("", RegexFilter.keepAlphanumeric("!@# "));
        }
    }

    @Nested
    class RemoveAlphanumeric {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeAlphanumeric(null));
        }

        @Test
        void withMixedContent_removesAlphanumeric() {
            assertEquals(" !", RegexFilter.removeAlphanumeric("héllo 123!"));
        }

        @Test
        void withAlphanumericOnly_returnsEmpty() {
            assertEquals("", RegexFilter.removeAlphanumeric("héllo123"));
        }
    }

    @Nested
    class KeepAlphanumericSpace {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.keepAlphanumericSpace(null));
        }

        @Test
        void withMixedContent_returnsAlphanumericAndSpaces() {
            assertEquals("héllo 123", RegexFilter.keepAlphanumericSpace("héllo 123!"));
        }

        @Test
        void withSpecialCharsOnly_returnsEmpty() {
            assertEquals("", RegexFilter.keepAlphanumericSpace("!@#"));
        }
    }

    @Nested
    class RemoveAlphanumericSpace {

        @Test
        void withNull_returnsNull() {
            assertNull(RegexFilter.removeAlphanumericSpace(null));
        }

        @Test
        void withMixedContent_removesAlphanumericAndSpaces() {
            assertEquals("!", RegexFilter.removeAlphanumericSpace("héllo 123!"));
        }

        @Test
        void withAlphanumericAndSpaceOnly_returnsEmpty() {
            assertEquals("", RegexFilter.removeAlphanumericSpace("héllo 123"));
        }
    }

    @Nested
    class CountAlnum {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, RegexFilter.countAlnum(null));
        }

        @Test
        void withNoAlnum_returnsZero() {
            assertEquals(0, RegexFilter.countAlnum("!@# "));
        }

        @Test
        void withAlnum_returnsCorrectCount() {
            assertEquals(8, RegexFilter.countAlnum("hello 123!"));
        }
    }

    @Nested
    class CountAlpha {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, RegexFilter.countAlpha(null));
        }

        @Test
        void withNoAlpha_returnsZero() {
            assertEquals(0, RegexFilter.countAlpha("123 !"));
        }

        @Test
        void withAlpha_returnsCorrectCount() {
            assertEquals(5, RegexFilter.countAlpha("hello 123!"));
        }
    }

    @Nested
    class CountAscii {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, RegexFilter.countAscii(null));
        }

        @Test
        void withNonAsciiOnly_returnsZero() {
            assertEquals(0, RegexFilter.countAscii("中文"));
        }

        @Test
        void withAscii_returnsCorrectCount() {
            assertEquals(4, RegexFilter.countAscii("héllo"));
        }
    }

    @Nested
    class CountBlank {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, RegexFilter.countBlank(null));
        }

        @Test
        void withNoBlank_returnsZero() {
            assertEquals(0, RegexFilter.countBlank("hello"));
        }

        @Test
        void withBlank_returnsCorrectCount() {
            assertEquals(2, RegexFilter.countBlank("h \te"));
        }
    }

    @Nested
    class CountDigit {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, RegexFilter.countDigit(null));
        }

        @Test
        void withNoDigit_returnsZero() {
            assertEquals(0, RegexFilter.countDigit("hello!"));
        }

        @Test
        void withDigits_returnsCorrectCount() {
            assertEquals(3, RegexFilter.countDigit("hello 123!"));
        }
    }

    @Nested
    class CountLower {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, RegexFilter.countLower(null));
        }

        @Test
        void withNoLowercase_returnsZero() {
            assertEquals(0, RegexFilter.countLower("HELLO"));
        }

        @Test
        void withLowercase_returnsCorrectCount() {
            assertEquals(4, RegexFilter.countLower("Hello"));
        }
    }

    @Nested
    class CountUpper {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, RegexFilter.countUpper(null));
        }

        @Test
        void withNoUppercase_returnsZero() {
            assertEquals(0, RegexFilter.countUpper("hello"));
        }

        @Test
        void withUppercase_returnsCorrectCount() {
            assertEquals(1, RegexFilter.countUpper("Hello"));
        }
    }

    @Nested
    class CountPunct {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, RegexFilter.countPunct(null));
        }

        @Test
        void withNoPunct_returnsZero() {
            assertEquals(0, RegexFilter.countPunct("hello123"));
        }

        @Test
        void withPunct_returnsCorrectCount() {
            assertEquals(2, RegexFilter.countPunct("hello!,"));
        }
    }

    @Nested
    class CountGraph {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, RegexFilter.countGraph(null));
        }

        @Test
        void withSpaceOnly_returnsZero() {
            assertEquals(0, RegexFilter.countGraph("   "));
        }

        @Test
        void withVisibleChars_returnsCorrectCount() {
            assertEquals(6, RegexFilter.countGraph("hello! "));
        }
    }

    @Nested
    class CountPrint {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, RegexFilter.countPrint(null));
        }

        @Test
        void withControlCharOnly_returnsZero() {
            assertEquals(0, RegexFilter.countPrint("\u0001\u0002"));
        }

        @Test
        void withPrintableChars_returnsCorrectCount() {
            assertEquals(7, RegexFilter.countPrint("hello! "));
        }
    }

    @Nested
    class CountSpace {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, RegexFilter.countSpace(null));
        }

        @Test
        void withNoWhitespace_returnsZero() {
            assertEquals(0, RegexFilter.countSpace("hello"));
        }

        @Test
        void withWhitespace_returnsCorrectCount() {
            assertEquals(3, RegexFilter.countSpace("h \t\ne"));
        }
    }

    @Nested
    class CountXDigit {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, RegexFilter.countXDigit(null));
        }

        @Test
        void withNoHexChar_returnsZero() {
            assertEquals(0, RegexFilter.countXDigit("ghi!"));
        }

        @Test
        void withHexChars_returnsCorrectCount() {
            assertEquals(4, RegexFilter.countXDigit("1a2b!gz"));
        }
    }

    @Nested
    class CountLetter {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, RegexFilter.countLetter(null));
        }

        @Test
        void withNoLetter_returnsZero() {
            assertEquals(0, RegexFilter.countLetter("123 !"));
        }

        @Test
        void withLetters_returnsCorrectCount() {
            assertEquals(5, RegexFilter.countLetter("héllo 123!"));
        }
    }

    @Nested
    class CountAlphanumeric {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, RegexFilter.countAlphanumeric(null));
        }

        @Test
        void withNoAlphanumeric_returnsZero() {
            assertEquals(0, RegexFilter.countAlphanumeric("!@# "));
        }

        @Test
        void withAlphanumeric_returnsCorrectCount() {
            assertEquals(8, RegexFilter.countAlphanumeric("héllo 123!"));
        }
    }

    @Nested
    class CountAlphanumericSpace {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, RegexFilter.countAlphanumericSpace(null));
        }

        @Test
        void withNoAlphanumericOrSpace_returnsZero() {
            assertEquals(0, RegexFilter.countAlphanumericSpace("!@#"));
        }

        @Test
        void withAlphanumericAndSpaces_returnsCorrectCount() {
            assertEquals(9, RegexFilter.countAlphanumericSpace("héllo 123!"));
        }
    }

    @Nested
    class CountAlnumSpace {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, RegexFilter.countAlnumSpace(null));
        }

        @Test
        void withNoAlnumOrSpace_returnsZero() {
            assertEquals(0, RegexFilter.countAlnumSpace("!@#"));
        }

        @Test
        void withAlnumAndSpaces_returnsCorrectCount() {
            assertEquals(9, RegexFilter.countAlnumSpace("hello 123!"));
        }
    }

    @Nested
    class CountDiacriticalLetter {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, RegexFilter.countDiacriticalLetter(null));
        }

        @Test
        void withNoDiacriticalLetter_returnsZero() {
            assertEquals(0, RegexFilter.countDiacriticalLetter("hello"));
        }

        @Test
        void withDiacriticalLetters_returnsCorrectCount() {
            assertEquals(1, RegexFilter.countDiacriticalLetter("café"));
        }
    }
}
