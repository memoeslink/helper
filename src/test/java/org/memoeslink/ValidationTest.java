package org.memoeslink;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidationTest {

    @Test
    void testIsName_returnsFalse_whenNameIsNullOrBlank() {
        assertFalse(Validation.isName(null));
        assertFalse(Validation.isName(""));
        assertFalse(Validation.isName("  "));
    }

    @Test
    void isName_returnsFalse_whenNameIsInvalid() {
        assertFalse(Validation.isName("1234"));
    }

    @Test
    void isName_returnsTrue_whenNameIsValid() {
        assertTrue(Validation.isName("Juan"));
        assertTrue(Validation.isName("John Doe"));
        assertTrue(Validation.isName("Ana María Ruíz López"));
        assertTrue(Validation.isName("Elizabeth M. Joy-Winston"));
    }

    @Test
    void isUsername_returnsFalse_whenUsernameIsNullOrBlank() {
        assertFalse(Validation.isUsername(null));
        assertFalse(Validation.isUsername(""));
        assertFalse(Validation.isUsername("  "));
    }

    @Test
    void isUsername_returnsFalse_whenUsernameIsInvalid() {
        assertFalse(Validation.isUsername("user 2000"));
    }

    @Test
    void isUsername_returnsTrue_whenUsernameIsValid() {
        assertTrue(Validation.isUsername("user2000"));
        assertTrue(Validation.isUsername("test"));
        assertTrue(Validation.isUsername("admin_2000"));
        assertTrue(Validation.isUsername("XxXuser-1XxX"));
    }

    @Test
    void isUsernameWithLength_returnsFalse_whenUsernameIsNullOrBlank() {
        assertFalse(Validation.isUsername(null, 1, 10));
        assertFalse(Validation.isUsername("", 1, 10));
        assertFalse(Validation.isUsername("  ", 1, 10));
    }

    @Test
    void isUsernameWithLength_returnsFalse_whenUsernameIsShort() {
        assertFalse(Validation.isUsername("us", 3, 10));
    }

    @Test
    void isUsernameWithLength_returnsFalse_whenUsernameIsLong() {
        assertFalse(Validation.isUsername("username2000", 3, 10));
    }

    @Test
    void isUsernameWithLength_returnsFalse_whenUsernameIsInvalid() {
        assertFalse(Validation.isUsername("user 2000", 3, 10));
    }

    @Test
    void isUsernameWithLength_returnsTrue_whenUsernameIsValid() {
        assertTrue(Validation.isUsername("user2000", 3, 10));
    }

    @Test
    void isEmailAddress_returnsFalse_whenEmailIsNullOrBlank() {
        assertFalse(Validation.isEmailAddress(null));
        assertFalse(Validation.isEmailAddress(""));
        assertFalse(Validation.isEmailAddress("  "));
    }

    @Test
    void isEmailAddress_returnsFalse_whenEmailIsInvalid() {
        assertFalse(Validation.isEmailAddress("email"));
        assertFalse(Validation.isEmailAddress("example@mail"));
    }

    @Test
    void isEmailAddress_returnsTrue_whenEmailIsValid() {
        assertTrue(Validation.isEmailAddress("example@mail.com"));
        assertTrue(Validation.isEmailAddress("test@gmail.com"));
        assertTrue(Validation.isEmailAddress("test@provider-company.com.us"));
        assertTrue(Validation.isEmailAddress("hr.department@brand.nz"));
    }

    @Test
    void isUrl_returnsFalse_whenUrlIsNullOrBlank() {
        assertFalse(Validation.isUrl(null));
        assertFalse(Validation.isUrl(""));
        assertFalse(Validation.isUrl("  "));
    }

    @Test
    void isUrl_returnsFalse_whenUrlIsInvalid() {
        assertFalse(Validation.isUrl("url"));
    }

    @Test
    void isUrl_returnsTrue_whenUrlIsValid() {
        assertTrue(Validation.isUrl("google.com"));
        assertTrue(Validation.isUrl("https://www.google.com/"));
        assertTrue(Validation.isUrl("https://medium.com/@mirzahssn/create-aar-file-in-android-e1ff009ba899"));
        assertTrue(Validation.isUrl("http://www.domain.com/page?key1=value1&key2=value2"));
        assertTrue(Validation.isUrl("ftp://username:password@server.com:21/directory/subdirectory/file.txt"));
    }

    @Test
    void isPhone_returnsFalse_whenPhoneIsNull() {
        assertFalse(Validation.isPhone(null));
        assertFalse(Validation.isPhone(""));
        assertFalse(Validation.isPhone("  "));
    }

    @Test
    void isPhone_returnsFalse_whenPhoneIsInvalid() {
        assertFalse(Validation.isPhone("phone"));
        assertFalse(Validation.isPhone("1234"));
    }

    @Test
    void isPhone_returnsTrue_whenPhoneIsValid() {
        assertTrue(Validation.isPhone("+52 (449) 100 9999"));
        assertTrue(Validation.isPhone("+52 (449) 100 9999"));
        assertTrue(Validation.isPhone("9102030"));
        assertTrue(Validation.isPhone("552092000"));
        assertTrue(Validation.isPhone("+33 1 09 75 83 51"));
    }

    @Test
    void isHexColor_returnsFalse_whenColorIsNullOrBlank() {
        assertFalse(Validation.isHexColor(null));
        assertFalse(Validation.isHexColor(""));
        assertFalse(Validation.isHexColor("  "));
    }

    @Test
    void isHexColor_returnsFalse_whenColorIsInvalid() {
        assertFalse(Validation.isHexColor("#ZZZZZZ"));
    }

    @Test
    void isHexColor_returnsTrue_whenColorIsValid() {
        assertTrue(Validation.isHexColor("#FFFFFF"));
        assertTrue(Validation.isHexColor("#000"));
        assertTrue(Validation.isHexColor("#FFFF0080"));
        assertTrue(Validation.isHexColor("#FF0000"));
    }

    @Test
    void isUtf_returnsFalse_whenUtfIsNullOrBlank() {
        assertFalse(Validation.isUtf(null));
        assertFalse(Validation.isUtf(""));
        assertFalse(Validation.isUtf("  "));
    }

    @Test
    void isUtf_returnsFalse_whenUtfIsInvalid() {
        assertFalse(Validation.isUtf("1234"));
        assertFalse(Validation.isUtf("U+ZZZZ"));
    }

    @Test
    void isUtf_returnsTrue_whenUtfIsValid() {
        assertTrue(Validation.isUtf("U+1234"));
        assertTrue(Validation.isUtf("U+0000"));
        assertTrue(Validation.isUtf("U+0020"));
        assertTrue(Validation.isUtf("U+FE31"));
    }

    @Test
    void isLocale_returnsFalse_whenLocaleIsNullOrBlank() {
        assertFalse(Validation.isLocale(null));
        assertFalse(Validation.isLocale(""));
        assertFalse(Validation.isLocale("  "));
    }

    @Test
    void isLocale_returnsFalse_whenLocaleIsInvalid() {
        assertFalse(Validation.isLocale("english-US"));
    }

    @Test
    void isLocale_returnsTrue_whenLocaleIsValid() {
        assertTrue(Validation.isLocale("en-US"));
        assertTrue(Validation.isLocale("en"));
        assertTrue(Validation.isLocale("az_Cyrl_AZ"));
        assertTrue(Validation.isLocale("cgg_UG"));
    }

    @Test
    void isDate_returnsFalse_whenDateIsNullOrBlank() {
        assertFalse(Validation.isDate(null));
        assertFalse(Validation.isDate(""));
        assertFalse(Validation.isDate("  "));
    }

    @Test
    void isDate_returnsFalse_whenDateIsInvalid() {
        assertFalse(Validation.isDate("2020-13-01"));
        assertFalse(Validation.isDate("2020-02-30"));
        assertFalse(Validation.isDate("2020/13/01"));
        assertFalse(Validation.isDate("2020/02/30"));
        assertFalse(Validation.isDate("20201301"));
        assertFalse(Validation.isDate("20200230"));
        assertFalse(Validation.isDate("1-12-20"));
        assertFalse(Validation.isDate("20230229"));
        assertFalse(Validation.isDate("2005/13/01"));
        assertFalse(Validation.isDate("2005-12-32"));
    }

    @Test
    void isDate_returnsTrue_whenDateIsValid() {
        assertTrue(Validation.isDate("2020-12-31"));
        assertTrue(Validation.isDate("2020/12/31"));
        assertTrue(Validation.isDate("20201231"));
        assertTrue(Validation.isDate("2000-01-31"));
        assertTrue(Validation.isDate("20000101"));
        assertTrue(Validation.isDate("2024.02.29"));
        assertTrue(Validation.isDate("2024-10-03"));
        assertTrue(Validation.isDate("1987/05/24"));
    }

    @Test
    void isIsoDate_returnsFalse_whenDateIsNullOrBlank() {
        assertFalse(Validation.isIsoDate(null));
        assertFalse(Validation.isIsoDate(""));
        assertFalse(Validation.isIsoDate("  "));
    }

    @Test
    void isIsoDate_returnsFalse_whenDateIsInvalid() {
        assertFalse(Validation.isIsoDate("2020-13-01"));
        assertFalse(Validation.isIsoDate("2020-02-30"));
        assertFalse(Validation.isIsoDate("20201301"));
        assertFalse(Validation.isIsoDate("20200230"));
        assertFalse(Validation.isIsoDate("2000/01/31"));
        assertFalse(Validation.isIsoDate("2005/03/01"));
        assertFalse(Validation.isIsoDate("1980-04-31"));
        assertFalse(Validation.isIsoDate("999-01-01"));
    }

    @Test
    void isIsoDate_returnsTrue_whenDateIsValid() {
        assertTrue(Validation.isIsoDate("2020-12-31"));
        assertTrue(Validation.isIsoDate("20201231"));
        assertTrue(Validation.isIsoDate("2000-01-31"));
        assertTrue(Validation.isIsoDate("19901024"));
        assertTrue(Validation.isIsoDate("1965-06-11"));
        assertTrue(Validation.isIsoDate("0000-01-01"));
    }

    @Test
    void isYyyyMmDdDate_returnsFalse_whenDateIsNullOrBlank() {
        assertFalse(Validation.isYyyyMmDdDate(null));
        assertFalse(Validation.isYyyyMmDdDate(""));
        assertFalse(Validation.isYyyyMmDdDate("  "));
    }

    @Test
    void isYyyyMmDdDate_returnsFalse_whenDateIsInvalid() {
        assertFalse(Validation.isYyyyMmDdDate("2020-13-01"));
        assertFalse(Validation.isYyyyMmDdDate("2020-02-30"));
        assertFalse(Validation.isYyyyMmDdDate("2020/13/01"));
        assertFalse(Validation.isYyyyMmDdDate("2020/02/30"));
        assertFalse(Validation.isYyyyMmDdDate("20201301"));
        assertFalse(Validation.isYyyyMmDdDate("20200230"));
        assertFalse(Validation.isYyyyMmDdDate("99/09/02"));
        assertFalse(Validation.isYyyyMmDdDate("1980-04-31"));
        assertFalse(Validation.isYyyyMmDdDate("1580-12-31"));
        assertFalse(Validation.isYyyyMmDdDate("2501/01/01"));
    }

    @Test
    void isYyyyMmDdDate_returnsTrue_whenDateIsValid() {
        assertTrue(Validation.isYyyyMmDdDate("2020-12-31"));
        assertTrue(Validation.isYyyyMmDdDate("2020/12/31"));
        assertTrue(Validation.isYyyyMmDdDate("20201231"));
        assertTrue(Validation.isYyyyMmDdDate("2000-01-31"));
        assertTrue(Validation.isYyyyMmDdDate("2000/01/31"));
        assertTrue(Validation.isYyyyMmDdDate("2020_01_01"));
        assertTrue(Validation.isYyyyMmDdDate("1999-12-31"));
        assertTrue(Validation.isYyyyMmDdDate("1581-01-01"));
        assertTrue(Validation.isYyyyMmDdDate("2500/12/31"));
    }
}