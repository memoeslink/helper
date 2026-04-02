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
    class IsIpAddress {

        @Test
        void withNull_returnsFalse() {
            assertFalse(Validation.isIpAddress(null));
        }

        @Test
        void withBlank_returnsFalse() {
            assertFalse(Validation.isIpAddress("   "));
        }

        @Test
        void withValidIpAddress_returnsTrue() {
            assertTrue(Validation.isIpAddress("192.168.0.1"));
        }

        @Test
        void withLoopbackAddress_returnsTrue() {
            assertTrue(Validation.isIpAddress("127.0.0.1"));
        }

        @Test
        void withMaxOctetValues_returnsTrue() {
            assertTrue(Validation.isIpAddress("255.255.255.255"));
        }

        @Test
        void withZeroAddress_returnsTrue() {
            assertTrue(Validation.isIpAddress("0.0.0.0"));
        }

        @Test
        void withOctetExceedingRange_returnsFalse() {
            assertFalse(Validation.isIpAddress("256.0.0.1"));
        }

        @Test
        void withMissingOctet_returnsFalse() {
            assertFalse(Validation.isIpAddress("192.168.0"));
        }

        @Test
        void withLettersInAddress_returnsFalse() {
            assertFalse(Validation.isIpAddress("192.168.a.1"));
        }
    }

    @Nested
    class IsIpv6Address {

        @Test
        void withNull_returnsFalse() {
            assertFalse(Validation.isIpv6Address(null));
        }

        @Test
        void withBlank_returnsFalse() {
            assertFalse(Validation.isIpv6Address("   "));
        }

        @Test
        void withFullIpv6Address_returnsTrue() {
            assertTrue(Validation.isIpv6Address("2001:0db8:85a3:0000:0000:8a2e:0370:7334"));
        }

        @Test
        void withLoopbackAddress_returnsTrue() {
            assertTrue(Validation.isIpv6Address("::1"));
        }

        @Test
        void withCompressedIpv6Address_returnsTrue() {
            assertTrue(Validation.isIpv6Address("2001:db8::1"));
        }

        @Test
        void withAllZerosCompressed_returnsTrue() {
            assertTrue(Validation.isIpv6Address("::"));
        }

        @Test
        void withInvalidGroupCount_returnsFalse() {
            assertFalse(Validation.isIpv6Address("2001:0db8:85a3:0000:8a2e:0370:7334"));
        }

        @Test
        void withInvalidCharacters_returnsFalse() {
            assertFalse(Validation.isIpv6Address("2001:0db8:85a3:zzzz:0000:8a2e:0370:7334"));
        }
    }

    @Nested
    class IsMacAddress {

        @Test
        void withNull_returnsFalse() {
            assertFalse(Validation.isMacAddress(null));
        }

        @Test
        void withBlank_returnsFalse() {
            assertFalse(Validation.isMacAddress("   "));
        }

        @Test
        void withColonSeparatedMac_returnsTrue() {
            assertTrue(Validation.isMacAddress("00:1A:2B:3C:4D:5E"));
        }

        @Test
        void withHyphenSeparatedMac_returnsTrue() {
            assertTrue(Validation.isMacAddress("00-1A-2B-3C-4D-5E"));
        }

        @Test
        void withLowercaseMac_returnsTrue() {
            assertTrue(Validation.isMacAddress("00:1a:2b:3c:4d:5e"));
        }

        @Test
        void withMissingGroup_returnsFalse() {
            assertFalse(Validation.isMacAddress("00:1A:2B:3C:4D"));
        }

        @Test
        void withInvalidCharacters_returnsFalse() {
            assertFalse(Validation.isMacAddress("00:1A:2B:3C:4G:5E"));
        }

        @Test
        void withNoSeparator_returnsFalse() {
            assertFalse(Validation.isMacAddress("001A2B3C4D5E"));
        }
    }

    @Nested
    class IsSlug {

        @Test
        void withNull_returnsFalse() {
            assertFalse(Validation.isSlug(null));
        }

        @Test
        void withBlank_returnsFalse() {
            assertFalse(Validation.isSlug("   "));
        }

        @Test
        void withSimpleSlug_returnsTrue() {
            assertTrue(Validation.isSlug("hello-world"));
        }

        @Test
        void withSlugWithDigits_returnsTrue() {
            assertTrue(Validation.isSlug("post-123"));
        }

        @Test
        void withSingleWord_returnsTrue() {
            assertTrue(Validation.isSlug("hello"));
        }

        @Test
        void withUppercaseChars_returnsFalse() {
            assertFalse(Validation.isSlug("Hello-World"));
        }

        @Test
        void withLeadingHyphen_returnsFalse() {
            assertFalse(Validation.isSlug("-hello-world"));
        }

        @Test
        void withTrailingHyphen_returnsFalse() {
            assertFalse(Validation.isSlug("hello-world-"));
        }

        @Test
        void withConsecutiveHyphens_returnsFalse() {
            assertFalse(Validation.isSlug("hello--world"));
        }

        @Test
        void withSpace_returnsFalse() {
            assertFalse(Validation.isSlug("hello world"));
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
    class IsUuid {

        @Test
        void withNull_returnsFalse() {
            assertFalse(Validation.isUuid(null));
        }

        @Test
        void withBlank_returnsFalse() {
            assertFalse(Validation.isUuid("   "));
        }

        @Test
        void withValidUuid_returnsTrue() {
            assertTrue(Validation.isUuid("550e8400-e29b-41d4-a716-446655440000"));
        }

        @Test
        void withUppercaseUuid_returnsTrue() {
            assertTrue(Validation.isUuid("550E8400-E29B-41D4-A716-446655440000"));
        }

        @Test
        void withMissingSegment_returnsFalse() {
            assertFalse(Validation.isUuid("550e8400-e29b-41d4-a716"));
        }

        @Test
        void withInvalidCharacters_returnsFalse() {
            assertFalse(Validation.isUuid("550e8400-e29b-41d4-a716-44665544000G"));
        }

        @Test
        void withMissingHyphens_returnsFalse() {
            assertFalse(Validation.isUuid("550e8400e29b41d4a716446655440000"));
        }
    }

    @Nested
    class IsIsbn {

        @Test
        void withNull_returnsFalse() {
            assertFalse(Validation.isIsbn(null));
        }

        @Test
        void withBlank_returnsFalse() {
            assertFalse(Validation.isIsbn("   "));
        }

        @Test
        void withValidIsbn10_returnsTrue() {
            assertTrue(Validation.isIsbn("0306406152"));
        }

        @Test
        void withValidIsbn13_returnsTrue() {
            assertTrue(Validation.isIsbn("9780306406157"));
        }

        @Test
        void withInvalidIsbn_returnsFalse() {
            assertFalse(Validation.isIsbn("1234567890"));
        }
    }

    @Nested
    class IsIsbn10 {

        @Test
        void withNull_returnsFalse() {
            assertFalse(Validation.isIsbn10(null));
        }

        @Test
        void withBlank_returnsFalse() {
            assertFalse(Validation.isIsbn10("   "));
        }

        @Test
        void withValidIsbn10_returnsTrue() {
            assertTrue(Validation.isIsbn10("0306406152"));
        }

        @Test
        void withValidIsbn10EndingInX_returnsTrue() {
            assertTrue(Validation.isIsbn10("080442957X"));
        }

        @Test
        void withInvalidChecksum_returnsFalse() {
            assertFalse(Validation.isIsbn10("0306406153"));
        }

        @Test
        void withTooShort_returnsFalse() {
            assertFalse(Validation.isIsbn10("030640615"));
        }

        @Test
        void withLettersInBody_returnsFalse() {
            assertFalse(Validation.isIsbn10("030640615A"));
        }
    }

    @Nested
    class IsIsbn13 {

        @Test
        void withNull_returnsFalse() {
            assertFalse(Validation.isIsbn13(null));
        }

        @Test
        void withBlank_returnsFalse() {
            assertFalse(Validation.isIsbn13("   "));
        }

        @Test
        void withValidIsbn13_returnsTrue() {
            assertTrue(Validation.isIsbn13("9780306406157"));
        }

        @Test
        void withValid979Isbn13_returnsTrue() {
            assertTrue(Validation.isIsbn13("9791032309667"));
        }

        @Test
        void withInvalidChecksum_returnsFalse() {
            assertFalse(Validation.isIsbn13("9780306406158"));
        }

        @Test
        void withInvalidPrefix_returnsFalse() {
            assertFalse(Validation.isIsbn13("9770306406157"));
        }

        @Test
        void withTooShort_returnsFalse() {
            assertFalse(Validation.isIsbn13("978030640615"));
        }
    }

    @Nested
    class IsCreditCard {

        @Test
        void withNull_returnsFalse() {
            assertFalse(Validation.isCreditCard(null));
        }

        @Test
        void withBlank_returnsFalse() {
            assertFalse(Validation.isCreditCard("   "));
        }

        @Test
        void withValidVisaNumber_returnsTrue() {
            assertTrue(Validation.isCreditCard("4111111111111111"));
        }

        @Test
        void withValidMastercardNumber_returnsTrue() {
            assertTrue(Validation.isCreditCard("5500005555555559"));
        }

        @Test
        void withInvalidLuhnChecksum_returnsFalse() {
            assertFalse(Validation.isCreditCard("4111111111111112"));
        }

        @Test
        void withTooShort_returnsFalse() {
            assertFalse(Validation.isCreditCard("411111111111"));
        }

        @Test
        void withLetters_returnsFalse() {
            assertFalse(Validation.isCreditCard("4111111111111abc"));
        }
    }

    @Nested
    class IsIban {

        @Test
        void withNull_returnsFalse() {
            assertFalse(Validation.isIban(null));
        }

        @Test
        void withBlank_returnsFalse() {
            assertFalse(Validation.isIban("   "));
        }

        @Test
        void withValidGbIban_returnsTrue() {
            assertTrue(Validation.isIban("GB82WEST12345698765432"));
        }

        @Test
        void withValidDeIban_returnsTrue() {
            assertTrue(Validation.isIban("DE89370400440532013000"));
        }

        @Test
        void withInvalidChecksum_returnsFalse() {
            assertFalse(Validation.isIban("GB82WEST12345698765433"));
        }

        @Test
        void withMissingCountryCode_returnsFalse() {
            assertFalse(Validation.isIban("82WEST12345698765432"));
        }

        @Test
        void withLowercaseCountryCode_returnsFalse() {
            assertFalse(Validation.isIban("gb82WEST12345698765432"));
        }
    }

    @Nested
    class IsPassword {

        @Test
        void withNull_returnsFalse() {
            assertFalse(Validation.isPassword(null));
        }

        @Test
        void withBlank_returnsFalse() {
            assertFalse(Validation.isPassword("   "));
        }

        @Test
        void withValidPassword_returnsTrue() {
            assertTrue(Validation.isPassword("Secure#1"));
        }

        @Test
        void withPasswordTooShort_returnsFalse() {
            assertFalse(Validation.isPassword("Sec#1"));
        }

        @Test
        void withMissingUppercase_returnsFalse() {
            assertFalse(Validation.isPassword("secure#1"));
        }

        @Test
        void withMissingLowercase_returnsFalse() {
            assertFalse(Validation.isPassword("SECURE#1"));
        }

        @Test
        void withMissingDigit_returnsFalse() {
            assertFalse(Validation.isPassword("Secure##"));
        }

        @Test
        void withMissingSpecialChar_returnsFalse() {
            assertFalse(Validation.isPassword("Secure11"));
        }
    }

    @Nested
    class IsPasswordWithRange {

        @Test
        void withNull_returnsFalse() {
            assertFalse(Validation.isPassword(null, 6, 20));
        }

        @Test
        void withValidPasswordInRange_returnsTrue() {
            assertTrue(Validation.isPassword("Secure#1", 6, 20));
        }

        @Test
        void withPasswordTooShort_returnsFalse() {
            assertFalse(Validation.isPassword("Se#1", 6, 20));
        }

        @Test
        void withPasswordTooLong_returnsFalse() {
            assertFalse(Validation.isPassword("Secure#1Secure#1Secur", 6, 20));
        }

        @Test
        void withPasswordAtMinBoundary_returnsTrue() {
            assertTrue(Validation.isPassword("Se#1aA", 6, 20));
        }

        @Test
        void withPasswordAtMaxBoundary_returnsTrue() {
            assertTrue(Validation.isPassword("Secure#1Secure#1Secu", 6, 20));
        }

        @Test
        void withInvalidPasswordInRange_returnsFalse() {
            assertFalse(Validation.isPassword("securepassword", 6, 20));
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
