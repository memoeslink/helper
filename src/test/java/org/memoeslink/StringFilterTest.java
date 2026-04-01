package org.memoeslink;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class StringFilterTest {

    @Nested
    class KeepWhitespaces {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.keepWhitespaces(null));
        }

        @Test
        void withEmpty_returnsEmpty() {
            assertEquals("", StringFilter.keepWhitespaces(""));
        }

        @Test
        void withWhitespacesOnly_returnsUnchanged() {
            assertEquals(" \t\n", StringFilter.keepWhitespaces(" \t\n"));
        }

        @Test
        void withMixedContent_returnsOnlyWhitespaces() {
            assertEquals("  ", StringFilter.keepWhitespaces("h e l"));
        }

        @Test
        void withNoWhitespace_returnsEmpty() {
            assertEquals("", StringFilter.keepWhitespaces("hello"));
        }
    }

    @Nested
    class KeepZeroWidthSpaces {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.keepZeroWidthSpaces(null));
        }

        @Test
        void withEmpty_returnsEmpty() {
            assertEquals("", StringFilter.keepZeroWidthSpaces(""));
        }

        @Test
        void withZeroWidthSpace_returnsZeroWidthSpace() {
            assertEquals("\u200B", StringFilter.keepZeroWidthSpaces("hello\u200Bworld"));
        }

        @Test
        void withZeroWidthNonJoiner_returnsZeroWidthNonJoiner() {
            assertEquals("\u200C", StringFilter.keepZeroWidthSpaces("hello\u200Cworld"));
        }

        @Test
        void withZeroWidthJoiner_returnsZeroWidthJoiner() {
            assertEquals("\u200D", StringFilter.keepZeroWidthSpaces("hello\u200Dworld"));
        }

        @Test
        void withWordJoiner_returnsWordJoiner() {
            assertEquals("\u2060", StringFilter.keepZeroWidthSpaces("hello\u2060world"));
        }

        @Test
        void withBom_returnsBom() {
            assertEquals("\uFEFF", StringFilter.keepZeroWidthSpaces("hello\uFEFFworld"));
        }

        @Test
        void withNoZeroWidthChar_returnsEmpty() {
            assertEquals("", StringFilter.keepZeroWidthSpaces("hello"));
        }
    }

    @Nested
    class KeepLetters {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.keepLetters(null));
        }

        @Test
        void withEmpty_returnsEmpty() {
            assertEquals("", StringFilter.keepLetters(""));
        }

        @Test
        void withMixedContent_returnsOnlyLetters() {
            assertEquals("hll", StringFilter.keepLetters("h3ll0!"));
        }

        @Test
        void withNoLetters_returnsEmpty() {
            assertEquals("", StringFilter.keepLetters("123!@#"));
        }
    }

    @Nested
    class KeepLowercase {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.keepLowercase(null));
        }

        @Test
        void withEmpty_returnsEmpty() {
            assertEquals("", StringFilter.keepLowercase(""));
        }

        @Test
        void withMixedCase_returnsOnlyLowercase() {
            assertEquals("ello", StringFilter.keepLowercase("Hello"));
        }

        @Test
        void withAllUppercase_returnsEmpty() {
            assertEquals("", StringFilter.keepLowercase("HELLO"));
        }
    }

    @Nested
    class KeepUppercase {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.keepUppercase(null));
        }

        @Test
        void withEmpty_returnsEmpty() {
            assertEquals("", StringFilter.keepUppercase(""));
        }

        @Test
        void withMixedCase_returnsOnlyUppercase() {
            assertEquals("H", StringFilter.keepUppercase("Hello"));
        }

        @Test
        void withAllLowercase_returnsEmpty() {
            assertEquals("", StringFilter.keepUppercase("hello"));
        }
    }

    @Nested
    class KeepDigits {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.keepDigits(null));
        }

        @Test
        void withEmpty_returnsEmpty() {
            assertEquals("", StringFilter.keepDigits(""));
        }

        @Test
        void withMixedContent_returnsOnlyDigits() {
            assertEquals("123", StringFilter.keepDigits("h1e2l3lo"));
        }

        @Test
        void withNoDigits_returnsEmpty() {
            assertEquals("", StringFilter.keepDigits("hello"));
        }
    }

    @Nested
    class KeepLettersOrWhitespaces {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.keepLettersOrWhitespaces(null));
        }

        @Test
        void withMixedContent_returnsLettersAndWhitespaces() {
            assertEquals("hello world", StringFilter.keepLettersOrWhitespaces("hello world123!"));
        }

        @Test
        void withDigitsAndSpecialCharsOnly_returnsEmpty() {
            assertEquals("", StringFilter.keepLettersOrWhitespaces("123!@#"));
        }
    }

    @Nested
    class KeepLettersOrDigits {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.keepLettersOrDigits(null));
        }

        @Test
        void withMixedContent_returnsLettersAndDigits() {
            assertEquals("hello123", StringFilter.keepLettersOrDigits("hello 123!"));
        }

        @Test
        void withSpecialCharsOnly_returnsEmpty() {
            assertEquals("", StringFilter.keepLettersOrDigits("!@# "));
        }
    }

    @Nested
    class KeepLettersDigitsOrWhitespaces {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.keepLettersDigitsOrWhitespaces(null));
        }

        @Test
        void withMixedContent_returnsLettersDigitsAndWhitespaces() {
            assertEquals("hello 123", StringFilter.keepLettersDigitsOrWhitespaces("hello 123!@#"));
        }

        @Test
        void withSpecialCharsOnly_returnsEmpty() {
            assertEquals("", StringFilter.keepLettersDigitsOrWhitespaces("!@#"));
        }
    }

    @Nested
    class KeepAlphabetic {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.keepAlphabetic(null));
        }

        @Test
        void withMixedContent_returnsOnlyAlphabetic() {
            assertEquals("hello", StringFilter.keepAlphabetic("hello 123!"));
        }

        @Test
        void withDigitsOnly_returnsEmpty() {
            assertEquals("", StringFilter.keepAlphabetic("123"));
        }
    }

    @Nested
    class KeepAlphabeticOrWhitespaces {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.keepAlphabeticOrWhitespaces(null));
        }

        @Test
        void withMixedContent_returnsAlphabeticAndWhitespaces() {
            assertEquals("hello world", StringFilter.keepAlphabeticOrWhitespaces("hello world123!"));
        }

        @Test
        void withDigitsAndSpecialCharsOnly_returnsEmpty() {
            assertEquals("", StringFilter.keepAlphabeticOrWhitespaces("123!@#"));
        }
    }

    @Nested
    class KeepAlphabeticOrDigits {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.keepAlphabeticOrDigits(null));
        }

        @Test
        void withMixedContent_returnsAlphabeticAndDigits() {
            assertEquals("hello123", StringFilter.keepAlphabeticOrDigits("hello 123!"));
        }

        @Test
        void withSpecialCharsOnly_returnsEmpty() {
            assertEquals("", StringFilter.keepAlphabeticOrDigits("!@# "));
        }
    }

    @Nested
    class KeepAlphanumericOrWhitespaces {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.keepAlphanumericOrWhitespaces(null));
        }

        @Test
        void withMixedContent_returnsAlphanumericAndWhitespaces() {
            assertEquals("hello 123", StringFilter.keepAlphanumericOrWhitespaces("hello 123!@#"));
        }

        @Test
        void withSpecialCharsOnly_returnsEmpty() {
            assertEquals("", StringFilter.keepAlphanumericOrWhitespaces("!@#"));
        }
    }

    @Nested
    class KeepSpecialChars {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.keepSpecialChars(null));
        }

        @Test
        void withMixedContent_returnsOnlySpecialChars() {
            assertEquals("!@#", StringFilter.keepSpecialChars("hello 123!@#"));
        }

        @Test
        void withLettersAndDigitsOnly_returnsEmpty() {
            assertEquals("", StringFilter.keepSpecialChars("hello123"));
        }
    }

    @Nested
    class KeepAscii {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.keepAscii(null));
        }

        @Test
        void withMixedContent_returnsOnlyAscii() {
            assertEquals("hllo", StringFilter.keepAscii("héllo"));
        }

        @Test
        void withNonAsciiOnly_returnsEmpty() {
            assertEquals("", StringFilter.keepAscii("中文"));
        }
    }

    @Nested
    class KeepAsciiSpaces {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.keepAsciiSpaces(null));
        }

        @Test
        void withMixedContent_returnsOnlyAsciiSpaces() {
            assertEquals(" ", StringFilter.keepAsciiSpaces("h e\tl"));
        }

        @Test
        void withNoAsciiSpace_returnsEmpty() {
            assertEquals("", StringFilter.keepAsciiSpaces("hello\t"));
        }
    }

    @Nested
    class KeepAsciiWhitespaces {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.keepAsciiWhitespaces(null));
        }

        @Test
        void withMixedContent_returnsOnlyAsciiWhitespaces() {
            assertEquals(" \t", StringFilter.keepAsciiWhitespaces("h \te"));
        }

        @Test
        void withNoAsciiWhitespace_returnsEmpty() {
            assertEquals("", StringFilter.keepAsciiWhitespaces("hello"));
        }
    }

    @Nested
    class KeepAsciiAlpha {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.keepAsciiAlpha(null));
        }

        @Test
        void withMixedContent_returnsOnlyAsciiAlpha() {
            assertEquals("hello", StringFilter.keepAsciiAlpha("hello 123!"));
        }

        @Test
        void withNonAlphaOnly_returnsEmpty() {
            assertEquals("", StringFilter.keepAsciiAlpha("123 !"));
        }
    }

    @Nested
    class KeepAsciiAlphaLower {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.keepAsciiAlphaLower(null));
        }

        @Test
        void withMixedCase_returnsOnlyLowercase() {
            assertEquals("ello", StringFilter.keepAsciiAlphaLower("Hello"));
        }

        @Test
        void withAllUppercase_returnsEmpty() {
            assertEquals("", StringFilter.keepAsciiAlphaLower("HELLO"));
        }
    }

    @Nested
    class KeepAsciiAlphaUpper {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.keepAsciiAlphaUpper(null));
        }

        @Test
        void withMixedCase_returnsOnlyUppercase() {
            assertEquals("H", StringFilter.keepAsciiAlphaUpper("Hello"));
        }

        @Test
        void withAllLowercase_returnsEmpty() {
            assertEquals("", StringFilter.keepAsciiAlphaUpper("hello"));
        }
    }

    @Nested
    class KeepAsciiNumeric {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.keepAsciiNumeric(null));
        }

        @Test
        void withMixedContent_returnsOnlyDigits() {
            assertEquals("123", StringFilter.keepAsciiNumeric("hello 123!"));
        }

        @Test
        void withNoDigits_returnsEmpty() {
            assertEquals("", StringFilter.keepAsciiNumeric("hello!"));
        }
    }

    @Nested
    class KeepAsciiAlphaOrSpaces {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.keepAsciiAlphaOrSpaces(null));
        }

        @Test
        void withMixedContent_returnsAlphaAndSpaces() {
            assertEquals("hello world", StringFilter.keepAsciiAlphaOrSpaces("hello world123!\t"));
        }

        @Test
        void withDigitsAndSpecialCharsOnly_returnsEmpty() {
            assertEquals("", StringFilter.keepAsciiAlphaOrSpaces("123!@#\t"));
        }
    }

    @Nested
    class KeepAsciiAlphaOrWhitespaces {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.keepAsciiAlphaOrWhitespaces(null));
        }

        @Test
        void withMixedContent_returnsAlphaAndWhitespaces() {
            assertEquals("hello\tworld", StringFilter.keepAsciiAlphaOrWhitespaces("hello\tworld123!"));
        }

        @Test
        void withDigitsOnly_returnsEmpty() {
            assertEquals("", StringFilter.keepAsciiAlphaOrWhitespaces("123!@#"));
        }
    }

    @Nested
    class KeepAsciiAlphanumeric {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.keepAsciiAlphanumeric(null));
        }

        @Test
        void withMixedContent_returnsAlphanumeric() {
            assertEquals("hello123", StringFilter.keepAsciiAlphanumeric("hello 123!"));
        }

        @Test
        void withSpecialCharsOnly_returnsEmpty() {
            assertEquals("", StringFilter.keepAsciiAlphanumeric("!@# "));
        }
    }

    @Nested
    class KeepAsciiAlphanumericOrSpaces {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.keepAsciiAlphanumericOrSpaces(null));
        }

        @Test
        void withMixedContent_returnsAlphanumericAndSpaces() {
            assertEquals("hello 123", StringFilter.keepAsciiAlphanumericOrSpaces("hello 123!\t"));
        }

        @Test
        void withSpecialCharsOnly_returnsEmpty() {
            assertEquals("", StringFilter.keepAsciiAlphanumericOrSpaces("!@#\t"));
        }
    }

    @Nested
    class KeepAsciiAlphanumericOrWhitespaces {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.keepAsciiAlphanumericOrWhitespaces(null));
        }

        @Test
        void withMixedContent_returnsAlphanumericAndWhitespaces() {
            assertEquals("hello\t123", StringFilter.keepAsciiAlphanumericOrWhitespaces("hello\t123!@#"));
        }

        @Test
        void withSpecialCharsOnly_returnsEmpty() {
            assertEquals("", StringFilter.keepAsciiAlphanumericOrWhitespaces("!@#"));
        }
    }

    @Nested
    class RemoveWhitespaces {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.removeWhitespaces(null));
        }

        @Test
        void withEmpty_returnsEmpty() {
            assertEquals("", StringFilter.removeWhitespaces(""));
        }

        @Test
        void withMixedContent_removesWhitespaces() {
            assertEquals("hello", StringFilter.removeWhitespaces("h e l l o"));
        }

        @Test
        void withWhitespacesOnly_returnsEmpty() {
            assertEquals("", StringFilter.removeWhitespaces(" \t\n"));
        }
    }

    @Nested
    class RemoveZeroWidthSpaces {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.removeZeroWidthSpaces(null));
        }

        @Test
        void withEmpty_returnsEmpty() {
            assertEquals("", StringFilter.removeZeroWidthSpaces(""));
        }

        @Test
        void withZeroWidthSpace_removesIt() {
            assertEquals("helloworld", StringFilter.removeZeroWidthSpaces("hello\u200Bworld"));
        }

        @Test
        void withMultipleZeroWidthChars_removesAll() {
            assertEquals("helloworld", StringFilter.removeZeroWidthSpaces("hello\u200B\u200C\u200Dworld"));
        }

        @Test
        void withNoZeroWidthChar_returnsUnchanged() {
            assertEquals("hello", StringFilter.removeZeroWidthSpaces("hello"));
        }
    }

    @Nested
    class RemoveLetters {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.removeLetters(null));
        }

        @Test
        void withMixedContent_removesLetters() {
            assertEquals("123!", StringFilter.removeLetters("hello123!"));
        }

        @Test
        void withLettersOnly_returnsEmpty() {
            assertEquals("", StringFilter.removeLetters("hello"));
        }
    }

    @Nested
    class RemoveLowercase {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.removeLowercase(null));
        }

        @Test
        void withMixedCase_removesLowercase() {
            assertEquals("H", StringFilter.removeLowercase("Hello"));
        }

        @Test
        void withAllLowercase_returnsEmpty() {
            assertEquals("", StringFilter.removeLowercase("hello"));
        }
    }

    @Nested
    class RemoveUppercase {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.removeUppercase(null));
        }

        @Test
        void withMixedCase_removesUppercase() {
            assertEquals("ello", StringFilter.removeUppercase("Hello"));
        }

        @Test
        void withAllUppercase_returnsEmpty() {
            assertEquals("", StringFilter.removeUppercase("HELLO"));
        }
    }

    @Nested
    class RemoveDigits {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.removeDigits(null));
        }

        @Test
        void withMixedContent_removesDigits() {
            assertEquals("hello!", StringFilter.removeDigits("hello123!"));
        }

        @Test
        void withDigitsOnly_returnsEmpty() {
            assertEquals("", StringFilter.removeDigits("123"));
        }
    }

    @Nested
    class RemoveLettersOrWhitespaces {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.removeLettersOrWhitespaces(null));
        }

        @Test
        void withMixedContent_removesLettersAndWhitespaces() {
            assertEquals("123!", StringFilter.removeLettersOrWhitespaces("hello 123!"));
        }

        @Test
        void withLettersAndSpacesOnly_returnsEmpty() {
            assertEquals("", StringFilter.removeLettersOrWhitespaces("hello world"));
        }
    }

    @Nested
    class RemoveLettersOrDigits {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.removeLettersOrDigits(null));
        }

        @Test
        void withMixedContent_removesLettersAndDigits() {
            assertEquals(" !", StringFilter.removeLettersOrDigits("hello 123!"));
        }

        @Test
        void withLettersAndDigitsOnly_returnsEmpty() {
            assertEquals("", StringFilter.removeLettersOrDigits("hello123"));
        }
    }

    @Nested
    class RemoveLettersDigitsOrWhitespaces {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.removeLettersDigitsOrWhitespaces(null));
        }

        @Test
        void withMixedContent_removesLettersDigitsAndWhitespaces() {
            assertEquals("!@#", StringFilter.removeLettersDigitsOrWhitespaces("hello 123!@#"));
        }

        @Test
        void withLettersDigitsAndSpacesOnly_returnsEmpty() {
            assertEquals("", StringFilter.removeLettersDigitsOrWhitespaces("hello 123"));
        }
    }

    @Nested
    class RemoveAlphabetic {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.removeAlphabetic(null));
        }

        @Test
        void withMixedContent_removesAlphabetic() {
            assertEquals(" 123!", StringFilter.removeAlphabetic("hello 123!"));
        }

        @Test
        void withAlphabeticOnly_returnsEmpty() {
            assertEquals("", StringFilter.removeAlphabetic("hello"));
        }
    }

    @Nested
    class RemoveAlphabeticOrWhitespaces {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.removeAlphabeticOrWhitespaces(null));
        }

        @Test
        void withMixedContent_removesAlphabeticAndWhitespaces() {
            assertEquals("123!", StringFilter.removeAlphabeticOrWhitespaces("hello 123!"));
        }

        @Test
        void withAlphabeticAndSpacesOnly_returnsEmpty() {
            assertEquals("", StringFilter.removeAlphabeticOrWhitespaces("hello world"));
        }
    }

    @Nested
    class RemoveAlphabeticOrDigits {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.removeAlphabeticOrDigits(null));
        }

        @Test
        void withMixedContent_removesAlphabeticAndDigits() {
            assertEquals(" !", StringFilter.removeAlphabeticOrDigits("hello 123!"));
        }

        @Test
        void withAlphabeticAndDigitsOnly_returnsEmpty() {
            assertEquals("", StringFilter.removeAlphabeticOrDigits("hello123"));
        }
    }

    @Nested
    class RemoveAlphanumericOrWhitespaces {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.removeAlphanumericOrWhitespaces(null));
        }

        @Test
        void withMixedContent_removesAlphanumericAndWhitespaces() {
            assertEquals("!@#", StringFilter.removeAlphanumericOrWhitespaces("hello 123!@#"));
        }

        @Test
        void withAlphanumericAndSpacesOnly_returnsEmpty() {
            assertEquals("", StringFilter.removeAlphanumericOrWhitespaces("hello 123"));
        }
    }

    @Nested
    class RemoveSpecialChars {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.removeSpecialChars(null));
        }

        @Test
        void withMixedContent_removesSpecialChars() {
            assertEquals("hello 123", StringFilter.removeSpecialChars("hello 123!@#"));
        }

        @Test
        void withSpecialCharsOnly_returnsEmpty() {
            assertEquals("", StringFilter.removeSpecialChars("!@#"));
        }
    }

    @Nested
    class RemoveAscii {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.removeAscii(null));
        }

        @Test
        void withMixedContent_removesAscii() {
            assertEquals("é", StringFilter.removeAscii("héllo"));
        }

        @Test
        void withAsciiOnly_returnsEmpty() {
            assertEquals("", StringFilter.removeAscii("hello"));
        }
    }

    @Nested
    class RemoveAsciiSpaces {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.removeAsciiSpaces(null));
        }

        @Test
        void withMixedContent_removesAsciiSpaces() {
            assertEquals("hello\tworld", StringFilter.removeAsciiSpaces("hello \tworld"));
        }

        @Test
        void withSpacesOnly_returnsEmpty() {
            assertEquals("", StringFilter.removeAsciiSpaces("   "));
        }
    }

    @Nested
    class RemoveAsciiWhitespaces {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.removeAsciiWhitespaces(null));
        }

        @Test
        void withMixedContent_removesAsciiWhitespaces() {
            assertEquals("helloworld", StringFilter.removeAsciiWhitespaces("hello \tworld"));
        }

        @Test
        void withWhitespacesOnly_returnsEmpty() {
            assertEquals("", StringFilter.removeAsciiWhitespaces(" \t\n"));
        }
    }

    @Nested
    class RemoveAsciiAlpha {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.removeAsciiAlpha(null));
        }

        @Test
        void withMixedContent_removesAsciiAlpha() {
            assertEquals(" 123!", StringFilter.removeAsciiAlpha("hello 123!"));
        }

        @Test
        void withAsciiAlphaOnly_returnsEmpty() {
            assertEquals("", StringFilter.removeAsciiAlpha("hello"));
        }
    }

    @Nested
    class RemoveAsciiAlphaLower {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.removeAsciiAlphaLower(null));
        }

        @Test
        void withMixedCase_removesLowercase() {
            assertEquals("H", StringFilter.removeAsciiAlphaLower("Hello"));
        }

        @Test
        void withAllLowercase_returnsEmpty() {
            assertEquals("", StringFilter.removeAsciiAlphaLower("hello"));
        }
    }

    @Nested
    class RemoveAsciiAlphaUpper {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.removeAsciiAlphaUpper(null));
        }

        @Test
        void withMixedCase_removesUppercase() {
            assertEquals("ello", StringFilter.removeAsciiAlphaUpper("Hello"));
        }

        @Test
        void withAllUppercase_returnsEmpty() {
            assertEquals("", StringFilter.removeAsciiAlphaUpper("HELLO"));
        }
    }

    @Nested
    class RemoveAsciiNumeric {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.removeAsciiNumeric(null));
        }

        @Test
        void withMixedContent_removesDigits() {
            assertEquals("hello!", StringFilter.removeAsciiNumeric("hello123!"));
        }

        @Test
        void withDigitsOnly_returnsEmpty() {
            assertEquals("", StringFilter.removeAsciiNumeric("123"));
        }
    }

    @Nested
    class RemoveAsciiAlphaOrSpaces {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.removeAsciiAlphaOrSpaces(null));
        }

        @Test
        void withMixedContent_removesAlphaAndSpaces() {
            assertEquals("123!\t", StringFilter.removeAsciiAlphaOrSpaces("hello 123!\t"));
        }

        @Test
        void withAlphaAndSpacesOnly_returnsEmpty() {
            assertEquals("", StringFilter.removeAsciiAlphaOrSpaces("hello world"));
        }
    }

    @Nested
    class RemoveAsciiAlphaOrWhitespaces {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.removeAsciiAlphaOrWhitespaces(null));
        }

        @Test
        void withMixedContent_removesAlphaAndWhitespaces() {
            assertEquals("123!", StringFilter.removeAsciiAlphaOrWhitespaces("hello\t123!"));
        }

        @Test
        void withAlphaAndWhitespacesOnly_returnsEmpty() {
            assertEquals("", StringFilter.removeAsciiAlphaOrWhitespaces("hello\tworld"));
        }
    }

    @Nested
    class RemoveAsciiAlphanumeric {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.removeAsciiAlphanumeric(null));
        }

        @Test
        void withMixedContent_removesAlphanumeric() {
            assertEquals(" !", StringFilter.removeAsciiAlphanumeric("hello 123!"));
        }

        @Test
        void withAlphanumericOnly_returnsEmpty() {
            assertEquals("", StringFilter.removeAsciiAlphanumeric("hello123"));
        }
    }

    @Nested
    class RemoveAsciiAlphanumericOrSpaces {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.removeAsciiAlphanumericOrSpaces(null));
        }

        @Test
        void withMixedContent_removesAlphanumericAndSpaces() {
            assertEquals("!\t", StringFilter.removeAsciiAlphanumericOrSpaces("hello 123!\t"));
        }

        @Test
        void withAlphanumericAndSpacesOnly_returnsEmpty() {
            assertEquals("", StringFilter.removeAsciiAlphanumericOrSpaces("hello 123"));
        }
    }

    @Nested
    class RemoveAsciiAlphanumericOrWhitespaces {

        @Test
        void withNull_returnsNull() {
            assertNull(StringFilter.removeAsciiAlphanumericOrWhitespaces(null));
        }

        @Test
        void withMixedContent_removesAlphanumericAndWhitespaces() {
            assertEquals("!@#", StringFilter.removeAsciiAlphanumericOrWhitespaces("hello\t123!@#"));
        }

        @Test
        void withAlphanumericAndWhitespacesOnly_returnsEmpty() {
            assertEquals("", StringFilter.removeAsciiAlphanumericOrWhitespaces("hello\t123"));
        }
    }

    @Nested
    class CountWhitespaces {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, StringFilter.countWhitespaces(null));
        }

        @Test
        void withNoWhitespace_returnsZero() {
            assertEquals(0, StringFilter.countWhitespaces("hello"));
        }

        @Test
        void withWhitespaces_returnsCorrectCount() {
            assertEquals(2, StringFilter.countWhitespaces("h e l"));
        }
    }

    @Nested
    class CountZeroWidthChars {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, StringFilter.countZeroWidthChars(null));
        }

        @Test
        void withNoZeroWidthChar_returnsZero() {
            assertEquals(0, StringFilter.countZeroWidthChars("hello"));
        }

        @Test
        void withZeroWidthChars_returnsCorrectCount() {
            assertEquals(2, StringFilter.countZeroWidthChars("hello\u200B\u200Cworld"));
        }
    }

    @Nested
    class CountLetters {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, StringFilter.countLetters(null));
        }

        @Test
        void withNoLetters_returnsZero() {
            assertEquals(0, StringFilter.countLetters("123!"));
        }

        @Test
        void withLetters_returnsCorrectCount() {
            assertEquals(5, StringFilter.countLetters("hello123!"));
        }
    }

    @Nested
    class CountLowercase {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, StringFilter.countLowercase(null));
        }

        @Test
        void withNoLowercase_returnsZero() {
            assertEquals(0, StringFilter.countLowercase("HELLO"));
        }

        @Test
        void withLowercase_returnsCorrectCount() {
            assertEquals(4, StringFilter.countLowercase("Hello"));
        }
    }

    @Nested
    class CountUppercase {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, StringFilter.countUppercase(null));
        }

        @Test
        void withNoUppercase_returnsZero() {
            assertEquals(0, StringFilter.countUppercase("hello"));
        }

        @Test
        void withUppercase_returnsCorrectCount() {
            assertEquals(1, StringFilter.countUppercase("Hello"));
        }
    }

    @Nested
    class CountDigits {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, StringFilter.countDigits(null));
        }

        @Test
        void withNoDigits_returnsZero() {
            assertEquals(0, StringFilter.countDigits("hello"));
        }

        @Test
        void withDigits_returnsCorrectCount() {
            assertEquals(3, StringFilter.countDigits("hello123!"));
        }
    }

    @Nested
    class CountLettersOrWhitespaces {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, StringFilter.countLettersOrWhitespaces(null));
        }

        @Test
        void withLettersAndWhitespaces_returnsCorrectCount() {
            assertEquals(6, StringFilter.countLettersOrWhitespaces("hello 123!"));
        }
    }

    @Nested
    class CountLettersOrDigits {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, StringFilter.countLettersOrDigits(null));
        }

        @Test
        void withLettersAndDigits_returnsCorrectCount() {
            assertEquals(8, StringFilter.countLettersOrDigits("hello 123!"));
        }
    }

    @Nested
    class CountLettersDigitsOrWhitespaces {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, StringFilter.countLettersDigitsOrWhitespaces(null));
        }

        @Test
        void withLettersDigitsAndWhitespaces_returnsCorrectCount() {
            assertEquals(9, StringFilter.countLettersDigitsOrWhitespaces("hello 123!"));
        }
    }

    @Nested
    class CountAlphabetic {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, StringFilter.countAlphabetic(null));
        }

        @Test
        void withAlphabetic_returnsCorrectCount() {
            assertEquals(5, StringFilter.countAlphabetic("hello 123!"));
        }
    }

    @Nested
    class CountAlphabeticOrWhitespaces {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, StringFilter.countAlphabeticOrWhitespaces(null));
        }

        @Test
        void withAlphabeticAndWhitespaces_returnsCorrectCount() {
            assertEquals(6, StringFilter.countAlphabeticOrWhitespaces("hello 123!"));
        }
    }

    @Nested
    class CountAlphabeticOrDigits {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, StringFilter.countAlphabeticOrDigits(null));
        }

        @Test
        void withAlphabeticAndDigits_returnsCorrectCount() {
            assertEquals(8, StringFilter.countAlphabeticOrDigits("hello 123!"));
        }
    }

    @Nested
    class CountAlphanumericOrWhitespaces {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, StringFilter.countAlphanumericOrWhitespaces(null));
        }

        @Test
        void withAlphanumericAndWhitespaces_returnsCorrectCount() {
            assertEquals(9, StringFilter.countAlphanumericOrWhitespaces("hello 123!"));
        }
    }

    @Nested
    class CountSpecialChars {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, StringFilter.countSpecialChars(null));
        }

        @Test
        void withNoSpecialChars_returnsZero() {
            assertEquals(0, StringFilter.countSpecialChars("hello123"));
        }

        @Test
        void withSpecialChars_returnsCorrectCount() {
            assertEquals(2, StringFilter.countSpecialChars("hello!@"));
        }
    }

    @Nested
    class CountAscii {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, StringFilter.countAscii(null));
        }

        @Test
        void withAsciiChars_returnsCorrectCount() {
            assertEquals(4, StringFilter.countAscii("héllo"));
        }
    }

    @Nested
    class CountAsciiSpace {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, StringFilter.countAsciiSpace(null));
        }

        @Test
        void withAsciiSpaces_returnsCorrectCount() {
            assertEquals(2, StringFilter.countAsciiSpace("h e l"));
        }
    }

    @Nested
    class CountAsciiWhitespace {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, StringFilter.countAsciiWhitespace(null));
        }

        @Test
        void withAsciiWhitespaces_returnsCorrectCount() {
            assertEquals(2, StringFilter.countAsciiWhitespace("h \tl"));
        }
    }

    @Nested
    class CountAsciiAlpha {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, StringFilter.countAsciiAlpha(null));
        }

        @Test
        void withAsciiAlphaChars_returnsCorrectCount() {
            assertEquals(5, StringFilter.countAsciiAlpha("hello 123!"));
        }
    }

    @Nested
    class CountAsciiAlphaLower {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, StringFilter.countAsciiAlphaLower(null));
        }

        @Test
        void withLowercaseChars_returnsCorrectCount() {
            assertEquals(4, StringFilter.countAsciiAlphaLower("Hello"));
        }
    }

    @Nested
    class CountAsciiAlphaUpper {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, StringFilter.countAsciiAlphaUpper(null));
        }

        @Test
        void withUppercaseChars_returnsCorrectCount() {
            assertEquals(1, StringFilter.countAsciiAlphaUpper("Hello"));
        }
    }

    @Nested
    class CountAsciiNumeric {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, StringFilter.countAsciiNumeric(null));
        }

        @Test
        void withDigits_returnsCorrectCount() {
            assertEquals(3, StringFilter.countAsciiNumeric("hello123!"));
        }
    }

    @Nested
    class CountAsciiAlphanumeric {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, StringFilter.countAsciiAlphanumeric(null));
        }

        @Test
        void withAlphanumericChars_returnsCorrectCount() {
            assertEquals(8, StringFilter.countAsciiAlphanumeric("hello 123!"));
        }
    }

    @Nested
    class CountAsciiAlphanumericOrSpaces {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, StringFilter.countAsciiAlphanumericOrSpaces(null));
        }

        @Test
        void withAlphanumericAndSpaces_returnsCorrectCount() {
            assertEquals(9, StringFilter.countAsciiAlphanumericOrSpaces("hello 123!"));
        }
    }

    @Nested
    class CountAsciiAlphanumericOrWhitespaces {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, StringFilter.countAsciiAlphanumericOrWhitespaces(null));
        }

        @Test
        void withAlphanumericAndWhitespaces_returnsCorrectCount() {
            assertEquals(9, StringFilter.countAsciiAlphanumericOrWhitespaces("hello\t123!"));
        }
    }

    @Nested
    class CountAsciiAlphaOrSpaces {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, StringFilter.countAsciiAlphaOrSpaces(null));
        }

        @Test
        void withAlphaAndSpaces_returnsCorrectCount() {
            assertEquals(6, StringFilter.countAsciiAlphaOrSpaces("hello 123!"));
        }
    }

    @Nested
    class CountAsciiAlphaOrWhitespaces {

        @Test
        void withNull_returnsZero() {
            assertEquals(0, StringFilter.countAsciiAlphaOrWhitespaces(null));
        }

        @Test
        void withAlphaAndWhitespaces_returnsCorrectCount() {
            assertEquals(6, StringFilter.countAsciiAlphaOrWhitespaces("hello\t123!"));
        }
    }
}
