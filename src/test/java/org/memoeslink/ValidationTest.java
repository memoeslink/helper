package org.memoeslink;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidationTest {

    @Nested
    class IsName {

        @Test
        void withNull_returnsFalse() {
            assertFalse(Validation.isName(null));
        }

        @Test
        void withBlank_returnsFalse() {
            assertFalse(Validation.isName("   "));
        }

        @Test
        void withSimpleName_returnsTrue() {
            assertTrue(Validation.isName("John"));
        }

        @Test
        void withFullName_returnsTrue() {
            assertTrue(Validation.isName("John Doe"));
        }

        @Test
        void withHyphenatedName_returnsTrue() {
            assertTrue(Validation.isName("Laureen Kesner-Graver"));
        }

        @Test
        void withAccentedName_returnsTrue() {
            assertTrue(Validation.isName("José de la Cruz Nuñez"));
        }

        @Test
        void withLeadingDigit_returnsFalse() {
            assertFalse(Validation.isName("1John"));
        }

        @Test
        void withSpecialChars_returnsFalse() {
            assertFalse(Validation.isName("John@Doe"));
        }
    }

    @Nested
    class IsUsername {

        @Test
        void withNull_returnsFalse() {
            assertFalse(Validation.isUsername(null));
        }

        @Test
        void withBlank_returnsFalse() {
            assertFalse(Validation.isUsername("   "));
        }

        @Test
        void withSimpleUsername_returnsTrue() {
            assertTrue(Validation.isUsername("user2000"));
        }

        @Test
        void withUsernameWithUnderscore_returnsTrue() {
            assertTrue(Validation.isUsername("doom_master"));
        }

        @Test
        void withUsernameWithHyphen_returnsTrue() {
            assertTrue(Validation.isUsername("green-robot"));
        }

        @Test
        void withUsernameWithDot_returnsTrue() {
            assertTrue(Validation.isUsername("john.doe"));
        }

        @Test
        void withUsernameWithSpace_returnsFalse() {
            assertFalse(Validation.isUsername("john doe"));
        }

        @Test
        void withUsernameWithSpecialChar_returnsFalse() {
            assertFalse(Validation.isUsername("john@doe"));
        }
    }

    @Nested
    class IsUsernameWithRange {

        @Test
        void withNull_returnsFalse() {
            assertFalse(Validation.isUsername(null, 3, 20));
        }

        @Test
        void withValidUsernameInRange_returnsTrue() {
            assertTrue(Validation.isUsername("user2000", 3, 20));
        }

        @Test
        void withValidUsernameTooShort_returnsFalse() {
            assertFalse(Validation.isUsername("ab", 3, 20));
        }

        @Test
        void withValidUsernameTooLong_returnsFalse() {
            assertFalse(Validation.isUsername("averylongusernamethatexceedslimit", 3, 20));
        }

        @Test
        void withUsernameAtMinBoundary_returnsTrue() {
            assertTrue(Validation.isUsername("abc", 3, 20));
        }

        @Test
        void withUsernameAtMaxBoundary_returnsTrue() {
            assertTrue(Validation.isUsername("abcdefghijklmnopqrst", 3, 20));
        }

        @Test
        void withInvalidUsernameInRange_returnsFalse() {
            assertFalse(Validation.isUsername("john doe", 3, 20));
        }
    }

    @Nested
    class IsEmailAddress {

        @Test
        void withNull_returnsFalse() {
            assertFalse(Validation.isEmailAddress(null));
        }

        @Test
        void withBlank_returnsFalse() {
            assertFalse(Validation.isEmailAddress("   "));
        }

        @Test
        void withValidEmail_returnsTrue() {
            assertTrue(Validation.isEmailAddress("example@mail.com"));
        }

        @Test
        void withSubdomainEmail_returnsTrue() {
            assertTrue(Validation.isEmailAddress("test.email@sample-domain.com"));
        }

        @Test
        void withEmailWithPlusTag_returnsTrue() {
            assertTrue(Validation.isEmailAddress("user+tag@example.com"));
        }

        @Test
        void withMissingAtSign_returnsFalse() {
            assertFalse(Validation.isEmailAddress("examplemail.com"));
        }

        @Test
        void withMissingDomain_returnsFalse() {
            assertFalse(Validation.isEmailAddress("example@"));
        }

        @Test
        void withMissingTld_returnsFalse() {
            assertFalse(Validation.isEmailAddress("example@mail"));
        }

        @Test
        void withSpaceInEmail_returnsFalse() {
            assertFalse(Validation.isEmailAddress("exam ple@mail.com"));
        }
    }

    @Nested
    class IsUrl {

        @Test
        void withNull_returnsFalse() {
            assertFalse(Validation.isUrl(null));
        }

        @Test
        void withBlank_returnsFalse() {
            assertFalse(Validation.isUrl("   "));
        }

        @Test
        void withSimpleDomain_returnsTrue() {
            assertTrue(Validation.isUrl("www.test.com"));
        }

        @Test
        void withHttpsUrl_returnsTrue() {
            assertTrue(Validation.isUrl("https://www.google.com/"));
        }

        @Test
        void withHttpUrl_returnsTrue() {
            assertTrue(Validation.isUrl("http://example.com"));
        }

        @Test
        void withUrlWithPath_returnsTrue() {
            assertTrue(Validation.isUrl("https://example.com/path/to/page"));
        }

        @Test
        void withFtpUrl_returnsTrue() {
            assertTrue(Validation.isUrl("ftp://files.example.com:21/resource"));
        }

        @Test
        void withPlainString_returnsFalse() {
            assertFalse(Validation.isUrl("not a url"));
        }
    }

    @Nested
    class IsPhone {

        @Test
        void withNull_returnsFalse() {
            assertFalse(Validation.isPhone(null));
        }

        @Test
        void withBlank_returnsFalse() {
            assertFalse(Validation.isPhone("   "));
        }

        @Test
        void withSimplePhone_returnsTrue() {
            assertTrue(Validation.isPhone("5500001234"));
        }

        @Test
        void withPhoneWithCountryCode_returnsTrue() {
            assertTrue(Validation.isPhone("+52 (449) 100 9999"));
        }

        @Test
        void withPhoneWithHyphens_returnsTrue() {
            assertTrue(Validation.isPhone("33-0000-9999"));
        }

        @Test
        void withPhoneWithDots_returnsTrue() {
            assertTrue(Validation.isPhone("449.100.9999"));
        }

        @Test
        void withPhoneWithExcessiveSpaces_returnsTrue() {
            assertTrue(Validation.isPhone("449  100  9999"));
        }

        @Test
        void withLettersInPhone_returnsFalse() {
            assertFalse(Validation.isPhone("abc1234567"));
        }
    }

    @Nested
    class IsHexColor {

        @Test
        void withNull_returnsFalse() {
            assertFalse(Validation.isHexColor(null));
        }

        @Test
        void withBlank_returnsFalse() {
            assertFalse(Validation.isHexColor("   "));
        }

        @Test
        void withShortHexColor_returnsTrue() {
            assertTrue(Validation.isHexColor("#FFF"));
        }

        @Test
        void withFullHexColor_returnsTrue() {
            assertTrue(Validation.isHexColor("#FFFFFF"));
        }

        @Test
        void withHexColorWithAlpha_returnsTrue() {
            assertTrue(Validation.isHexColor("#FFFFFFFF"));
        }

        @Test
        void withLowercaseHexColor_returnsTrue() {
            assertTrue(Validation.isHexColor("#ffffff"));
        }

        @Test
        void withMissingHash_returnsFalse() {
            assertFalse(Validation.isHexColor("FFFFFF"));
        }

        @Test
        void withInvalidLength_returnsFalse() {
            assertFalse(Validation.isHexColor("#FFFF"));
        }

        @Test
        void withInvalidChars_returnsFalse() {
            assertFalse(Validation.isHexColor("#GGGGGG"));
        }
    }

    @Nested
    class IsUtf {

        @Test
        void withNull_returnsFalse() {
            assertFalse(Validation.isUtf(null));
        }

        @Test
        void withBlank_returnsFalse() {
            assertFalse(Validation.isUtf("   "));
        }

        @Test
        void withValidFourDigitUtf_returnsTrue() {
            assertTrue(Validation.isUtf("U+0041"));
        }

        @Test
        void withValidFiveDigitUtf_returnsTrue() {
            assertTrue(Validation.isUtf("U+1F600"));
        }

        @Test
        void withLowercasePrefix_returnsFalse() {
            assertFalse(Validation.isUtf("u+0041"));
        }

        @Test
        void withMissingPlus_returnsFalse() {
            assertFalse(Validation.isUtf("U0041"));
        }

        @Test
        void withTooFewDigits_returnsFalse() {
            assertFalse(Validation.isUtf("U+041"));
        }

        @Test
        void withNonHexDigits_returnsFalse() {
            assertFalse(Validation.isUtf("U+GGGG"));
        }
    }

    @Nested
    class IsLocale {

        @Test
        void withNull_returnsFalse() {
            assertFalse(Validation.isLocale(null));
        }

        @Test
        void withBlank_returnsFalse() {
            assertFalse(Validation.isLocale("   "));
        }

        @Test
        void withLanguageOnly_returnsTrue() {
            assertTrue(Validation.isLocale("es"));
        }

        @Test
        void withLanguageAndCountryHyphen_returnsTrue() {
            assertTrue(Validation.isLocale("en-US"));
        }

        @Test
        void withLanguageAndCountryUnderscore_returnsTrue() {
            assertTrue(Validation.isLocale("pt_BR"));
        }

        @Test
        void withFourLetterLanguage_returnsTrue() {
            assertTrue(Validation.isLocale("hant"));
        }

        @Test
        void withSingleLetter_returnsFalse() {
            assertFalse(Validation.isLocale("e"));
        }

        @Test
        void withSpaceInLocale_returnsFalse() {
            assertFalse(Validation.isLocale("en US"));
        }
    }

    @Nested
    class IsDate {

        @Test
        void withNull_returnsFalse() {
            assertFalse(Validation.isDate(null));
        }

        @Test
        void withBlank_returnsFalse() {
            assertFalse(Validation.isDate("   "));
        }

        @Test
        void withIso8601Date_returnsTrue() {
            assertTrue(Validation.isDate("2024-06-15"));
        }

        @Test
        void withCompactDate_returnsTrue() {
            assertTrue(Validation.isDate("20240615"));
        }

        @Test
        void withSlashSeparatedDate_returnsTrue() {
            assertTrue(Validation.isDate("2024/06/15"));
        }

        @Test
        void withInvalidDate_returnsFalse() {
            assertFalse(Validation.isDate("not-a-date"));
        }

        @Test
        void withInvalidMonth_returnsFalse() {
            assertFalse(Validation.isDate("2024-13-01"));
        }

        @Test
        void withInvalidDay_returnsFalse() {
            assertFalse(Validation.isDate("2024-06-31"));
        }
    }

    @Nested
    class IsIsoDate {

        @Test
        void withNull_returnsFalse() {
            assertFalse(Validation.isIsoDate(null));
        }

        @Test
        void withBlank_returnsFalse() {
            assertFalse(Validation.isIsoDate("   "));
        }

        @Test
        void withIso8601Date_returnsTrue() {
            assertTrue(Validation.isIsoDate("2024-06-15"));
        }

        @Test
        void withBasicIsoDate_returnsTrue() {
            assertTrue(Validation.isIsoDate("20240615"));
        }

        @Test
        void withInvalidFormat_returnsFalse() {
            assertFalse(Validation.isIsoDate("2024/06/15"));
        }

        @Test
        void withInvalidDate_returnsFalse() {
            assertFalse(Validation.isIsoDate("not-a-date"));
        }
    }

    @Nested
    class IsYyyyMmDdDate {

        @Test
        void withNull_returnsFalse() {
            assertFalse(Validation.isYyyyMmDdDate(null));
        }

        @Test
        void withBlank_returnsFalse() {
            assertFalse(Validation.isYyyyMmDdDate("   "));
        }

        @Test
        void withIso8601Date_returnsTrue() {
            assertTrue(Validation.isYyyyMmDdDate("2024-06-15"));
        }

        @Test
        void withCompactDate_returnsTrue() {
            assertTrue(Validation.isYyyyMmDdDate("20240615"));
        }

        @Test
        void withSlashSeparatedDate_returnsTrue() {
            assertTrue(Validation.isYyyyMmDdDate("2024/06/15"));
        }

        @Test
        void withYearBelowRange_returnsFalse() {
            assertFalse(Validation.isYyyyMmDdDate("1580-01-01"));
        }

        @Test
        void withYearAboveRange_returnsFalse() {
            assertFalse(Validation.isYyyyMmDdDate("2501-01-01"));
        }

        @Test
        void withYearAtMinBoundary_returnsTrue() {
            assertTrue(Validation.isYyyyMmDdDate("1581-01-01"));
        }

        @Test
        void withYearAtMaxBoundary_returnsTrue() {
            assertTrue(Validation.isYyyyMmDdDate("2500-12-31"));
        }

        @Test
        void withInvalidMonth_returnsFalse() {
            assertFalse(Validation.isYyyyMmDdDate("2024-13-01"));
        }

        @Test
        void withInvalidDay_returnsFalse() {
            assertFalse(Validation.isYyyyMmDdDate("2024-06-31"));
        }

        @Test
        void withLeapYearFeb29_returnsTrue() {
            assertTrue(Validation.isYyyyMmDdDate("2024-02-29"));
        }

        @Test
        void withNonLeapYearFeb29_returnsFalse() {
            assertFalse(Validation.isYyyyMmDdDate("2023-02-29"));
        }

        @Test
        void withLeapYearDivisibleBy400_returnsTrue() {
            assertTrue(Validation.isYyyyMmDdDate("2000-02-29"));
        }

        @Test
        void withNonLeapYearDivisibleBy100_returnsFalse() {
            assertFalse(Validation.isYyyyMmDdDate("1900-02-29"));
        }
    }
}
