package org.memoeslink;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StringHelperTest {

    @Test
    void isNullOrEmpty_returnsTrue_whenStringIsNull() {
        assertTrue(StringHelper.isNullOrEmpty(null));
    }

    @Test
    void isNullOrEmpty_returnsTrue_whenStringIsEmpty() {
        assertTrue(StringHelper.isNullOrEmpty(""));
    }

    @Test
    void isNullOrEmpty_returnsFalse_whenStringIsNotEmpty() {
        assertFalse(StringHelper.isNullOrEmpty("not empty"));
    }

    @Test
    void isNotNullOrEmpty_returnsFalse_whenStringIsNull() {
        assertFalse(StringHelper.isNotNullOrEmpty(null));
    }

    @Test
    void isNotNullOrEmpty_returnsFalse_whenStringIsEmpty() {
        assertFalse(StringHelper.isNotNullOrEmpty(""));
    }

    @Test
    void isNotNullOrEmpty_returnsTrue_whenStringIsNotEmpty() {
        assertTrue(StringHelper.isNotNullOrEmpty("not empty"));
    }

    @Test
    void isNullOrBlank_returnsTrue_whenStringIsNull() {
        assertTrue(StringHelper.isNullOrBlank(null));
    }

    @Test
    void isNullOrBlank_returnsTrue_whenStringIsBlank() {
        assertTrue(StringHelper.isNullOrBlank("  "));
    }

    @Test
    void isNullOrBlank_returnsFalse_whenStringIsNotBlank() {
        assertFalse(StringHelper.isNullOrBlank("not blank"));
    }

    @Test
    void isNotNullOrBlank_returnsFalse_whenStringIsNull() {
        assertFalse(StringHelper.isNotNullOrBlank(null));
    }

    @Test
    void isNotNullOrBlank_returnsFalse_whenStringIsBlank() {
        assertFalse(StringHelper.isNotNullOrBlank("  "));
    }

    @Test
    void isNotNullOrBlank_returnsTrue_whenStringIsNotBlank() {
        assertTrue(StringHelper.isNotNullOrBlank("not blank"));
    }

    @Test
    void indexOf_returnsIndex_whenCharacterIsPresent() {
        assertEquals(1, StringHelper.indexOf("hello", 'e'));
    }

    @Test
    void indexOf_returnsNegative_whenCharacterIsAbsent() {
        assertEquals(-1, StringHelper.indexOf("hello", 'z'));
    }

    @Test
    void indexOf_returnsNegative_whenStringIsNull() {
        assertEquals(-1, StringHelper.indexOf(null, 'e'));
    }

    @Test
    void indexOf_returnsIndex_whenSubstringIsPresent() {
        assertEquals(2, StringHelper.indexOf("hello", "ll"));
    }

    @Test
    void indexOf_returnsNegative_whenSubstringIsAbsent() {
        assertEquals(-1, StringHelper.indexOf("hello", "zz"));
    }

    @Test
    void indexOf_returnsNegative_whenStringIsNullForSubstring() {
        assertEquals(-1, StringHelper.indexOf(null, "ll"));
    }

    @Test
    void defaultOnNull_returnsOriginal_whenStringIsNotNull() {
        assertEquals("hello", StringHelper.defaultOnNull("hello"));
    }

    @Test
    void defaultOnNull_returnsDefault_whenStringIsNull() {
        assertEquals(StringHelper.DEFAULT_VALUE, StringHelper.defaultOnNull(null));
    }

    @Test
    void defaultIfNull_returnsOriginal_whenStringIsNotNull() {
        assertEquals("hello", StringHelper.defaultIfNull("hello"));
    }

    @Test
    void defaultIfNull_returnsEmpty_whenStringIsNull() {
        assertEquals("", StringHelper.defaultIfNull(null));
    }

    @Test
    void defaultIfNull_returnsDefaultValue_whenStringIsNull() {
        assertEquals("default", StringHelper.defaultIfNull(null, "default"));
    }

    @Test
    void defaultIfNull_returnsOriginal_whenStringIsNotNullWithDefaultValue() {
        assertEquals("hello", StringHelper.defaultIfNull("hello", "default"));
    }

    @Test
    void defaultOnEmpty_returnsDefault_whenStringIsEmpty() {
        assertEquals(StringHelper.DEFAULT_VALUE, StringHelper.defaultOnEmpty(""));
    }

    @Test
    void defaultOnEmpty_returnsString_whenStringIsNotEmpty() {
        assertEquals("not empty", StringHelper.defaultOnEmpty("not empty"));
    }

    @Test
    void defaultIfEmpty_returnsEmpty_whenStringIsEmpty() {
        assertEquals("", StringHelper.defaultIfEmpty(""));
    }

    @Test
    void defaultIfEmpty_returnsString_whenStringIsNotEmpty() {
        assertEquals("not empty", StringHelper.defaultIfEmpty("not empty"));
    }

    @Test
    void defaultIfEmpty_returnsDefault_whenStringIsEmptyAndDefaultIsProvided() {
        assertEquals("default", StringHelper.defaultIfEmpty("", "default"));
    }

    @Test
    void defaultIfEmpty_returnsString_whenStringIsNotEmptyAndDefaultIsProvided() {
        assertEquals("not empty", StringHelper.defaultIfEmpty("not empty", "default"));
    }

    @Test
    void defaultOnBlank_returnsDefault_whenStringIsBlank() {
        assertEquals(StringHelper.DEFAULT_VALUE, StringHelper.defaultOnBlank("  "));
    }

    @Test
    void defaultOnBlank_returnsString_whenStringIsNotBlank() {
        assertEquals("not blank", StringHelper.defaultOnBlank("not blank"));
    }

    @Test
    void defaultIfBlank_returnsEmpty_whenStringIsBlank() {
        assertEquals("", StringHelper.defaultIfBlank("  "));
    }

    @Test
    void defaultIfBlank_returnsString_whenStringIsNotBlank() {
        assertEquals("not blank", StringHelper.defaultIfBlank("not blank"));
    }

    @Test
    void defaultIfBlank_returnsDefault_whenStringIsBlankAndDefaultIsProvided() {
        assertEquals("default", StringHelper.defaultIfBlank("  ", "default"));
    }

    @Test
    void defaultIfBlank_returnsString_whenStringIsNotBlankAndDefaultIsProvided() {
        assertEquals("not blank", StringHelper.defaultIfBlank("not blank", "default"));
    }

    @Test
    void getFirstNonNull_returnsFirstNonNullString() {
        assertEquals("first", StringHelper.getFirstNonNull("first", null, "second"));
    }

    @Test
    void getFirstNonNull_returnsDefaultValue_whenAllNull() {
        assertNull(StringHelper.getFirstNonNull(null, null, null));
    }

    @Test
    void getFirstNonEmpty_returnsFirstNonEmptyString() {
        assertEquals("first", StringHelper.getFirstNonEmpty("first", "", "second"));
    }

    @Test
    void getFirstNonEmpty_returnsDefaultValue_whenAllEmpty() {
        assertNull(StringHelper.getFirstNonEmpty("", "", ""));
    }

    @Test
    void getFirstNonBlank_returnsFirstNonBlankString() {
        assertEquals("first", StringHelper.getFirstNonBlank("first", "  ", "second"));
    }

    @Test
    void getFirstNonBlank_returnsDefaultValue_whenAllBlank() {
        assertNull(StringHelper.getFirstNonBlank("  ", "  ", "  "));
    }

    @Test
    void getFirstNonNullOrDefault_returnsFirstNonNullString() {
        assertEquals("first", StringHelper.getFirstNonNullOrDefault("default", "first", null, "second"));
    }

    @Test
    void getFirstNonNullOrDefault_returnsDefaultValue_whenAllNull() {
        assertEquals("default", StringHelper.getFirstNonNullOrDefault("default", null, null, null));
    }

    @Test
    void getFirstNonEmptyOrDefault_returnsFirstNonEmptyString() {
        assertEquals("first", StringHelper.getFirstNonEmptyOrDefault("default", "first", "", "second"));
    }

    @Test
    void getFirstNonEmptyOrDefault_returnsDefaultValue_whenAllEmpty() {
        assertEquals("default", StringHelper.getFirstNonEmptyOrDefault("default", "", "", ""));
    }

    @Test
    void getFirstNonBlankOrDefault_returnsFirstNonBlankString() {
        assertEquals("first", StringHelper.getFirstNonBlankOrDefault("default", "first", "  ", "second"));
    }

    @Test
    void getFirstNonBlankOrDefault_returnsDefaultValue_whenAllBlank() {
        assertEquals("default", StringHelper.getFirstNonBlankOrDefault("default", "  ", "  ", "  "));
    }

    @Test
    void getFirstNonNullElseDefault_returnsFirstNonNullString() {
        assertEquals("first", StringHelper.getFirstNonNullElseDefault("first", null, "second"));
    }

    @Test
    void getFirstNonNullElseDefault_returnsDefaultValue_whenAllNull() {
        assertEquals(StringHelper.DEFAULT_VALUE, StringHelper.getFirstNonNullElseDefault(null, null, null));
    }

    @Test
    void getFirstNonEmptyElseDefault_returnsFirstNonEmptyString() {
        assertEquals("first", StringHelper.getFirstNonEmptyElseDefault("first", "", "second"));
    }

    @Test
    void getFirstNonEmptyElseDefault_returnsDefaultValue_whenAllEmpty() {
        assertEquals(StringHelper.DEFAULT_VALUE, StringHelper.getFirstNonEmptyElseDefault("", "", ""));
    }

    @Test
    void getFirstNonBlankElseDefault_returnsFirstNonBlankString() {
        assertEquals("first", StringHelper.getFirstNonBlankElseDefault("first", "  ", "second"));
    }

    @Test
    void getFirstNonBlankElseDefault_returnsDefaultValue_whenAllBlank() {
        assertEquals(StringHelper.DEFAULT_VALUE, StringHelper.getFirstNonBlankElseDefault("  ", "  ", "  "));
    }

    @Test
    void prependIfNotNull_returnsNull_whenStringIsNull() {
        assertNull(StringHelper.prependIfNotNull(null, "prefix_"));
    }

    @Test
    void prependIfNotNull_returnsPrefixedString_whenStringIsNotNull() {
        assertEquals("prefix_Hello", StringHelper.prependIfNotNull("Hello", "prefix_"));
    }

    @Test
    void prependIfNotNull_returnsStringWithDefaultPrefix_whenStringIsNotNullAndPrefixIsNull() {
        assertEquals("Hello", StringHelper.prependIfNotNull("Hello", null));
    }

    @Test
    void prependIfNotEmpty_returnsOriginalString_whenStringIsEmpty() {
        assertEquals("", StringHelper.prependIfNotEmpty("", "prefix_"));
    }

    @Test
    void prependIfNotEmpty_returnsPrefixedString_whenStringIsNotEmpty() {
        assertEquals("prefix_Hello", StringHelper.prependIfNotEmpty("Hello", "prefix_"));
    }

    @Test
    void prependIfNotEmpty_returnsStringWithDefaultPrefix_whenStringIsNotEmptyAndPrefixIsNull() {
        assertEquals("Hello", StringHelper.prependIfNotEmpty("Hello", null));
    }

    @Test
    void prependIfNotBlank_returnsOriginalString_whenStringIsBlank() {
        assertEquals("  ", StringHelper.prependIfNotBlank("  ", "prefix_"));
    }

    @Test
    void prependIfNotBlank_returnsPrefixedString_whenStringIsNotBlank() {
        assertEquals("prefix_Hello", StringHelper.prependIfNotBlank("Hello", "prefix_"));
    }

    @Test
    void prependIfNotBlank_returnsStringWithDefaultPrefix_whenStringIsNotBlankAndPrefixIsNull() {
        assertEquals("Hello", StringHelper.prependIfNotBlank("Hello", null));
    }

    @Test
    void prependSpaceIfNotNull_returnsNull_whenStringIsNull() {
        assertNull(StringHelper.prependSpaceIfNotNull(null));
    }

    @Test
    void prependSpaceIfNotNull_returnsStringWithSpacePrefix_whenStringIsNotNull() {
        assertEquals(" Hello", StringHelper.prependSpaceIfNotNull("Hello"));
    }

    @Test
    void prependSpaceIfNotEmpty_returnsOriginalString_whenStringIsEmpty() {
        assertEquals("", StringHelper.prependSpaceIfNotEmpty(""));
    }

    @Test
    void prependSpaceIfNotEmpty_returnsStringWithSpacePrefix_whenStringIsNotEmpty() {
        assertEquals(" Hello", StringHelper.prependSpaceIfNotEmpty("Hello"));
    }

    @Test
    void prependSpaceIfNotBlank_returnsOriginalString_whenStringIsBlank() {
        assertEquals("  ", StringHelper.prependSpaceIfNotBlank("  "));
    }

    @Test
    void prependSpaceIfNotBlank_returnsStringWithSpacePrefix_whenStringIsNotBlank() {
        assertEquals(" Hello", StringHelper.prependSpaceIfNotBlank("Hello"));
    }

    @Test
    void prependHyphenIfNotNull_returnsNull_whenStringIsNull() {
        assertNull(StringHelper.prependHyphenIfNotNull(null));
    }

    @Test
    void prependHyphenIfNotNull_returnsStringWithHyphenPrefix_whenStringIsNotNull() {
        assertEquals("-Hello", StringHelper.prependHyphenIfNotNull("Hello"));
    }

    @Test
    void prependHyphenIfNotEmpty_returnsOriginalString_whenStringIsEmpty() {
        assertEquals("", StringHelper.prependHyphenIfNotEmpty(""));
    }

    @Test
    void prependHyphenIfNotEmpty_returnsStringWithHyphenPrefix_whenStringIsNotEmpty() {
        assertEquals("-Hello", StringHelper.prependHyphenIfNotEmpty("Hello"));
    }

    @Test
    void prependHyphenIfNotBlank_returnsOriginalString_whenStringIsBlank() {
        assertEquals("  ", StringHelper.prependHyphenIfNotBlank("  "));
    }

    @Test
    void prependHyphenIfNotBlank_returnsStringWithHyphenPrefix_whenStringIsNotBlank() {
        assertEquals("-Hello", StringHelper.prependHyphenIfNotBlank("Hello"));
    }

    @Test
    void prependLineBreakIfNotNull_returnsNull_whenStringIsNull() {
        assertNull(StringHelper.prependLineBreakIfNotNull(null));
    }

    @Test
    void prependLineBreakIfNotNull_returnsStringWithLineBreakPrefix_whenStringIsNotNull() {
        assertEquals(System.lineSeparator() + "Hello", StringHelper.prependLineBreakIfNotNull("Hello"));
    }

    @Test
    void prependLineBreakIfNotEmpty_returnsOriginalString_whenStringIsEmpty() {
        assertEquals("", StringHelper.prependLineBreakIfNotEmpty(""));
    }

    @Test
    void prependLineBreakIfNotEmpty_returnsStringWithLineBreakPrefix_whenStringIsNotEmpty() {
        assertEquals(System.lineSeparator() + "Hello", StringHelper.prependLineBreakIfNotEmpty("Hello"));
    }

    @Test
    void prependLineBreakIfNotBlank_returnsOriginalString_whenStringIsBlank() {
        assertEquals("  ", StringHelper.prependLineBreakIfNotBlank("  "));
    }

    @Test
    void prependLineBreakIfNotBlank_returnsStringWithLineBreakPrefix_whenStringIsNotBlank() {
        assertEquals(System.lineSeparator() + "Hello", StringHelper.prependLineBreakIfNotBlank("Hello"));
    }

    @Test
    void appendIfNotNull_returnsNull_whenStringIsNull() {
        assertNull(StringHelper.appendIfNotNull(null, "_suffix"));
    }

    @Test
    void appendIfNotNull_returnsStringWithSuffix_whenStringIsNotNull() {
        assertEquals("Hello_suffix", StringHelper.appendIfNotNull("Hello", "_suffix"));
    }

    @Test
    void appendIfNotNull_returnsStringWithDefaultSuffix_whenStringIsNotNullAndSuffixIsNull() {
        assertEquals("Hello", StringHelper.appendIfNotNull("Hello", null));
    }

    @Test
    void appendIfNotEmpty_returnsOriginalString_whenStringIsEmpty() {
        assertEquals("", StringHelper.appendIfNotEmpty("", "_suffix"));
    }

    @Test
    void appendIfNotEmpty_returnsStringWithSuffix_whenStringIsNotEmpty() {
        assertEquals("Hello_suffix", StringHelper.appendIfNotEmpty("Hello", "_suffix"));
    }

    @Test
    void appendIfNotEmpty_returnsStringWithDefaultSuffix_whenStringIsNotEmptyAndSuffixIsNull() {
        assertEquals("Hello", StringHelper.appendIfNotEmpty("Hello", null));
    }

    @Test
    void appendIfNotBlank_returnsOriginalString_whenStringIsBlank() {
        assertEquals("  ", StringHelper.appendIfNotBlank("  ", "_suffix"));
    }

    @Test
    void appendIfNotBlank_returnsStringWithSuffix_whenStringIsNotBlank() {
        assertEquals("Hello_suffix", StringHelper.appendIfNotBlank("Hello", "_suffix"));
    }

    @Test
    void appendIfNotBlank_returnsStringWithDefaultSuffix_whenStringIsNotBlankAndSuffixIsNull() {
        assertEquals("Hello", StringHelper.appendIfNotBlank("Hello", null));
    }

    @Test
    void appendSpaceIfNotNull_returnsNull_whenStringIsNull() {
        assertNull(StringHelper.appendSpaceIfNotNull(null));
    }

    @Test
    void appendSpaceIfNotNull_returnsStringWithSpaceSuffix_whenStringIsNotNull() {
        assertEquals("Hello ", StringHelper.appendSpaceIfNotNull("Hello"));
    }

    @Test
    void appendSpaceIfNotEmpty_returnsOriginalString_whenStringIsEmpty() {
        assertEquals("", StringHelper.appendSpaceIfNotEmpty(""));
    }

    @Test
    void appendSpaceIfNotEmpty_returnsStringWithSpaceSuffix_whenStringIsNotEmpty() {
        assertEquals("Hello ", StringHelper.appendSpaceIfNotEmpty("Hello"));
    }

    @Test
    void appendSpaceIfNotBlank_returnsOriginalString_whenStringIsBlank() {
        assertEquals("  ", StringHelper.appendSpaceIfNotBlank("  "));
    }

    @Test
    void appendSpaceIfNotBlank_returnsStringWithSpaceSuffix_whenStringIsNotBlank() {
        assertEquals("Hello ", StringHelper.appendSpaceIfNotBlank("Hello"));
    }

    @Test
    void appendHyphenIfNotNull_returnsNull_whenStringIsNull() {
        assertNull(StringHelper.appendHyphenIfNotNull(null));
    }

    @Test
    void appendHyphenIfNotNull_returnsStringWithHyphenSuffix_whenStringIsNotNull() {
        assertEquals("Hello-", StringHelper.appendHyphenIfNotNull("Hello"));
    }

    @Test
    void appendHyphenIfNotEmpty_returnsOriginalString_whenStringIsEmpty() {
        assertEquals("", StringHelper.appendHyphenIfNotEmpty(""));
    }

    @Test
    void appendHyphenIfNotEmpty_returnsStringWithHyphenSuffix_whenStringIsNotEmpty() {
        assertEquals("Hello-", StringHelper.appendHyphenIfNotEmpty("Hello"));
    }

    @Test
    void appendHyphenIfNotBlank_returnsOriginalString_whenStringIsBlank() {
        assertEquals("  ", StringHelper.appendHyphenIfNotBlank("  "));
    }

    @Test
    void appendHyphenIfNotBlank_returnsStringWithHyphenSuffix_whenStringIsNotBlank() {
        assertEquals("Hello-", StringHelper.appendHyphenIfNotBlank("Hello"));
    }

    @Test
    void appendLineBreakIfNotNull_returnsNull_whenStringIsNull() {
        assertNull(StringHelper.appendLineBreakIfNotNull(null));
    }

    @Test
    void appendLineBreakIfNotNull_returnsStringWithLineBreakSuffix_whenStringIsNotNull() {
        assertEquals("Hello" + System.lineSeparator(), StringHelper.appendLineBreakIfNotNull("Hello"));
    }

    @Test
    void appendLineBreakIfNotEmpty_returnsOriginalString_whenStringIsEmpty() {
        assertEquals("", StringHelper.appendLineBreakIfNotEmpty(""));
    }

    @Test
    void appendLineBreakIfNotEmpty_returnsStringWithLineBreakSuffix_whenStringIsNotEmpty() {
        assertEquals("Hello" + System.lineSeparator(), StringHelper.appendLineBreakIfNotEmpty("Hello"));
    }

    @Test
    void appendLineBreakIfNotBlank_returnsOriginalString_whenStringIsBlank() {
        assertEquals("  ", StringHelper.appendLineBreakIfNotBlank("  "));
    }

    @Test
    void appendLineBreakIfNotBlank_returnsStringWithLineBreakSuffix_whenStringIsNotBlank() {
        assertEquals("Hello" + System.lineSeparator(), StringHelper.appendLineBreakIfNotBlank("Hello"));
    }

    @Test
    void affixIfNotNull_returnsNull_whenStringIsNull() {
        assertNull(StringHelper.affixIfNotNull(null, "prefix_", "_suffix"));
    }

    @Test
    void affixIfNotNull_returnsStringWithAffixes_whenStringIsNotNull() {
        assertEquals("prefix_Hello_suffix", StringHelper.affixIfNotNull("Hello", "prefix_", "_suffix"));
    }

    @Test
    void affixIfNotNull_returnsStringWithDefaultAffixes_whenStringIsNotNullAndAffixesAreNull() {
        assertEquals("defaultPrefix_Hello_defaultSuffix", StringHelper.affixIfNotNull("Hello", null, null, "defaultPrefix_", "_defaultSuffix"));
    }

    @Test
    void affixIfNotEmpty_returnsOriginalString_whenStringIsEmpty() {
        assertEquals("", StringHelper.affixIfNotEmpty("", "prefix_", "_suffix"));
    }

    @Test
    void affixIfNotEmpty_returnsStringWithAffixes_whenStringIsNotEmpty() {
        assertEquals("prefix_Hello_suffix", StringHelper.affixIfNotEmpty("Hello", "prefix_", "_suffix"));
    }

    @Test
    void affixIfNotEmpty_returnsStringWithDefaultAffixes_whenStringIsNotEmptyAndAffixesAreNull() {
        assertEquals("defaultPrefix_Hello_defaultSuffix", StringHelper.affixIfNotEmpty("Hello", null, null, "defaultPrefix_", "_defaultSuffix"));
    }

    @Test
    void affixIfNotBlank_returnsOriginalString_whenStringIsBlank() {
        assertEquals("  ", StringHelper.affixIfNotBlank("  ", "prefix_", "_suffix"));
    }

    @Test
    void affixIfNotBlank_returnsStringWithAffixes_whenStringIsNotBlank() {
        assertEquals("prefix_Hello_suffix", StringHelper.affixIfNotBlank("Hello", "prefix_", "_suffix"));
    }

    @Test
    void affixIfNotBlank_returnsStringWithDefaultAffixes_whenStringIsNotBlankAndAffixesAreNull() {
        assertEquals("defaultPrefix_Hello_defaultSuffix", StringHelper.affixIfNotBlank("Hello", null, null, "defaultPrefix_", "_defaultSuffix"));
    }

    @Test
    void affixSpacesIfNotNull_returnsNull_whenStringIsNull() {
        assertNull(StringHelper.affixSpacesIfNotNull(null));
    }

    @Test
    void affixSpacesIfNotNull_returnsStringWithSpaces_whenStringIsNotNull() {
        assertEquals(" Hello ", StringHelper.affixSpacesIfNotNull("Hello"));
    }

    @Test
    void affixSpacesIfNotEmpty_returnsOriginalString_whenStringIsEmpty() {
        assertEquals("", StringHelper.affixSpacesIfNotEmpty(""));
    }

    @Test
    void affixSpacesIfNotEmpty_returnsStringWithSpaces_whenStringIsNotEmpty() {
        assertEquals(" Hello ", StringHelper.affixSpacesIfNotEmpty("Hello"));
    }

    @Test
    void affixSpacesIfNotBlank_returnsOriginalString_whenStringIsBlank() {
        assertEquals("  ", StringHelper.affixSpacesIfNotBlank("  "));
    }

    @Test
    void affixSpacesIfNotBlank_returnsStringWithSpaces_whenStringIsNotBlank() {
        assertEquals(" Hello ", StringHelper.affixSpacesIfNotBlank("Hello"));
    }

    @Test
    void affixHyphensIfNotNull_returnsNull_whenStringIsNull() {
        assertNull(StringHelper.affixHyphensIfNotNull(null));
    }

    @Test
    void affixHyphensIfNotNull_returnsStringWithHyphens_whenStringIsNotNull() {
        assertEquals("-Hello-", StringHelper.affixHyphensIfNotNull("Hello"));
    }

    @Test
    void affixHyphensIfNotEmpty_returnsOriginalString_whenStringIsEmpty() {
        assertEquals("", StringHelper.affixHyphensIfNotEmpty(""));
    }

    @Test
    void affixHyphensIfNotEmpty_returnsStringWithHyphens_whenStringIsNotEmpty() {
        assertEquals("-Hello-", StringHelper.affixHyphensIfNotEmpty("Hello"));
    }

    @Test
    void affixHyphensIfNotBlank_returnsOriginalString_whenStringIsBlank() {
        assertEquals("  ", StringHelper.affixHyphensIfNotBlank("  "));
    }

    @Test
    void affixHyphensIfNotBlank_returnsStringWithHyphens_whenStringIsNotBlank() {
        assertEquals("-Hello-", StringHelper.affixHyphensIfNotBlank("Hello"));
    }

    @Test
    void affixLineBreaksIfNotNull_returnsNull_whenStringIsNull() {
        assertNull(StringHelper.affixLineBreaksIfNotNull(null));
    }

    @Test
    void affixLineBreaksIfNotNull_returnsStringWithLineBreaks_whenStringIsNotNull() {
        assertEquals(System.lineSeparator() + "Hello" + System.lineSeparator(), StringHelper.affixLineBreaksIfNotNull("Hello"));
    }

    @Test
    void affixLineBreaksIfNotEmpty_returnsOriginalString_whenStringIsEmpty() {
        assertEquals("", StringHelper.affixLineBreaksIfNotEmpty(""));
    }

    @Test
    void affixLineBreaksIfNotEmpty_returnsStringWithLineBreaks_whenStringIsNotEmpty() {
        assertEquals(System.lineSeparator() + "Hello" + System.lineSeparator(), StringHelper.affixLineBreaksIfNotEmpty("Hello"));
    }

    @Test
    void affixLineBreaksIfNotBlank_returnsOriginalString_whenStringIsBlank() {
        assertEquals("  ", StringHelper.affixLineBreaksIfNotBlank("  "));
    }

    @Test
    void affixLineBreaksIfNotBlank_returnsStringWithLineBreaks_whenStringIsNotBlank() {
        assertEquals(System.lineSeparator() + "Hello" + System.lineSeparator(), StringHelper.affixLineBreaksIfNotBlank("Hello"));
    }

    @Test
    void quote_returnsOriginalString_whenStringIsBlank() {
        assertEquals("  ", StringHelper.quote("  "));
    }

    @Test
    void quote_returnsQuotedString_whenStringIsNotBlank() {
        assertEquals("“Hello”", StringHelper.quote("Hello"));
    }

    @Test
    void padLeft_returnsNull_whenStringIsNull() {
        assertNull(StringHelper.padLeft(null, 5, ' '));
    }

    @Test
    void padLeft_returnsPaddedString_whenStringIsShorterThanLength() {
        assertEquals("  Hello", StringHelper.padLeft("Hello", 7, ' '));
    }

    @Test
    void padLeft_returnsOriginalString_whenStringIsLongerThanLength() {
        assertEquals("Hello", StringHelper.padLeft("Hello", 3, ' '));
    }

    @Test
    void padRight_returnsNull_whenStringIsNull() {
        assertNull(StringHelper.padRight(null, 5, ' '));
    }

    @Test
    void padRight_returnsPaddedString_whenStringIsShorterThanLength() {
        assertEquals("Hello  ", StringHelper.padRight("Hello", 7, ' '));
    }

    @Test
    void padRight_returnsOriginalString_whenStringIsLongerThanLength() {
        assertEquals("Hello", StringHelper.padRight("Hello", 3, ' '));
    }

    @Test
    void split_returnsEmptyArray_whenStringIsNull() {
        assertArrayEquals(new String[]{}, StringHelper.split(null, ","));
    }

    @Test
    void split_returnsSingleElementArray_whenDelimiterIsAbsent() {
        assertArrayEquals(new String[]{"Hello"}, StringHelper.split("Hello", ","));
    }

    @Test
    void split_returnsSplitArray_whenDelimiterIsPresent() {
        assertArrayEquals(new String[]{"Hello", "World"}, StringHelper.split("Hello,World", ","));
    }

    @Test
    void splitByChar_returnsEmptyArray_whenStringIsNull() {
        assertArrayEquals(new String[]{}, StringHelper.split(null, ','));
    }

    @Test
    void splitByChar_returnsSingleElementArray_whenDelimiterIsAbsent() {
        assertArrayEquals(new String[]{"Hello"}, StringHelper.split("Hello", ','));
    }

    @Test
    void splitByChar_returnsSplitArray_whenDelimiterIsPresent() {
        assertArrayEquals(new String[]{"Hello", "World"}, StringHelper.split("Hello,World", ','));
    }

    @Test
    void splitByDelimiter_returnsEmptyArray_whenStringIsNull() {
        assertArrayEquals(new String[]{}, StringHelper.splitByDelimiter(null, ","));
    }

    @Test
    void splitByDelimiter_returnsSingleElementArray_whenDelimiterIsAbsent() {
        assertArrayEquals(new String[]{"Hello"}, StringHelper.splitByDelimiter("Hello", ","));
    }

    @Test
    void splitByDelimiter_returnsSplitArray_whenDelimiterIsPresent() {
        assertArrayEquals(new String[]{"Hello", "World"}, StringHelper.splitByDelimiter("Hello,World", ","));
    }

    @Test
    void splitBySpace_returnsSingleElementArray_whenDelimiterIsAbsent() {
        assertArrayEquals(new String[]{"Hello"}, StringHelper.splitBySpace("Hello"));
    }

    @Test
    void splitBySpace_returnsSplitArray_whenDelimiterIsPresent() {
        assertArrayEquals(new String[]{"Hello", "World"}, StringHelper.splitBySpace("Hello World"));
    }

    @Test
    void splitByHyphen_returnsSingleElementArray_whenDelimiterIsAbsent() {
        assertArrayEquals(new String[]{"Hello"}, StringHelper.splitByHyphen("Hello"));
    }

    @Test
    void splitByHyphen_returnsSplitArray_whenDelimiterIsPresent() {
        assertArrayEquals(new String[]{"Hello", "World"}, StringHelper.splitByHyphen("Hello-World"));
    }

    @Test
    void splitByLineBreak_returnsSingleElementArray_whenDelimiterIsAbsent() {
        assertArrayEquals(new String[]{"Hello"}, StringHelper.splitByLineBreak("Hello"));
    }

    @Test
    void splitByLineBreak_returnsSplitArray_whenDelimiterIsPresent() {
        assertArrayEquals(new String[]{"Hello", "World"}, StringHelper.splitByLineBreak("Hello" + System.lineSeparator() + "World"));
    }

    @Test
    void splitByParagraphMark_returnsSingleElementArray_whenDelimiterIsAbsent() {
        assertArrayEquals(new String[]{"Hello"}, StringHelper.splitByParagraphMark("Hello"));
    }

    @Test
    void splitByParagraphMark_returnsSplitArray_whenDelimiterIsPresent() {
        assertArrayEquals(new String[]{"Hello", "World"}, StringHelper.splitByParagraphMark("Hello¶ World"));
    }

    @Test
    void splitByComma_returnsSingleElementArray_whenDelimiterIsAbsent() {
        assertArrayEquals(new String[]{"Hello"}, StringHelper.splitByComma("Hello"));
    }

    @Test
    void splitByComma_returnsSplitArray_whenDelimiterIsPresent() {
        assertArrayEquals(new String[]{"Hello", "World"}, StringHelper.splitByComma("Hello,World"));
    }

    @Test
    void splitByTab_returnsSingleElementArray_whenDelimiterIsAbsent() {
        assertArrayEquals(new String[]{"Hello"}, StringHelper.splitByTab("Hello"));
    }

    @Test
    void splitByTab_returnsSplitArray_whenDelimiterIsPresent() {
        assertArrayEquals(new String[]{"Hello", "World"}, StringHelper.splitByTab("Hello\tWorld"));
    }

    @Test
    void connect_returnsEmptyString_whenBothStringsAreNull() {
        assertEquals("", StringHelper.connect(null, null));
    }

    @Test
    void connect_returnsStringB_whenStringAIsNull() {
        assertEquals("World", StringHelper.connect(null, "World"));
    }

    @Test
    void connect_returnsStringA_whenStringBIsNull() {
        assertEquals("Hello", StringHelper.connect("Hello", null));
    }

    @Test
    void connect_returnsConcatenatedString_whenBothStringsAreNotNull() {
        assertEquals("HelloWorld", StringHelper.connect("Hello", "World"));
    }

    @Test
    void joinWithChar_returnsEmptyString_whenStringsArrayIsEmpty() {
        assertEquals("", StringHelper.join(',', new String[]{}));
    }

    @Test
    void joinWithChar_returnsSingleString_whenStringsArrayHasSingleElement() {
        assertEquals("Hello", StringHelper.join(',', new String[]{"Hello"}));
    }

    @Test
    void joinWithChar_returnsJoinedString_whenStringsArrayHasMultipleElements() {
        assertEquals("Hello,World", StringHelper.join(',', new String[]{"Hello", "World"}));
    }

    @Test
    void joinWithChar_returnsEmptyString_whenListIsNull() {
        assertNull(StringHelper.join(',', (List<String>) null));
    }

    @Test
    void joinWithChar_returnsSingleString_whenListHasSingleElement() {
        assertEquals("Hello", StringHelper.join(',', List.of("Hello")));
    }

    @Test
    void joinWithChar_returnsJoinedString_whenListHasMultipleElements() {
        assertEquals("Hello,World", StringHelper.join(',', List.of("Hello", "World")));
    }

    @Test
    void joinWithSeparator_returnsEmptyString_whenStringsArrayIsEmpty() {
        assertEquals("", StringHelper.join(",", new String[]{}));
    }

    @Test
    void joinWithSeparator_returnsSingleString_whenStringsArrayHasSingleElement() {
        assertEquals("Hello", StringHelper.join(",", new String[]{"Hello"}));
    }

    @Test
    void joinWithSeparator_returnsJoinedString_whenStringsArrayHasMultipleElements() {
        assertEquals("Hello,World", StringHelper.join(",", new String[]{"Hello", "World"}));
    }

    @Test
    void joinWithSeparator_returnsEmptyString_whenListIsNull() {
        assertNull(StringHelper.join(",", (List<String>) null));
    }

    @Test
    void joinWithSeparator_returnsSingleString_whenListHasSingleElement() {
        assertEquals("Hello", StringHelper.join(",", List.of("Hello")));
    }

    @Test
    void joinWithSeparator_returnsJoinedString_whenListHasMultipleElements() {
        assertEquals("Hello,World", StringHelper.join(",", List.of("Hello", "World")));
    }

    @Test
    void joinWithoutSeparator_returnsEmptyString_whenArrayIsEmpty() {
        assertEquals("", StringHelper.joinWithoutSeparator());
    }

    @Test
    void joinWithoutSeparator_returnsSingleString_whenArrayHasSingleElement() {
        assertEquals("Hello", StringHelper.joinWithoutSeparator("Hello"));
    }

    @Test
    void joinWithoutSeparator_returnsConcatenatedString_whenArrayHasMultipleElements() {
        assertEquals("HelloWorld", StringHelper.joinWithoutSeparator("Hello", "World"));
    }

    @Test
    void joinWithoutSeparator_returnsNull_whenListIsNull() {
        assertNull(StringHelper.joinWithoutSeparator((List<String>) null));
    }

    @Test
    void joinWithoutSeparator_returnsConcatenatedString_whenListHasMultipleElements() {
        assertEquals("HelloWorld", StringHelper.joinWithoutSeparator(Arrays.asList("Hello", "World")));
    }

    @Test
    void joinWithSpace_returnsEmptyString_whenArrayIsEmpty() {
        assertEquals("", StringHelper.joinWithSpace());
    }

    @Test
    void joinWithSpace_returnsSingleString_whenArrayHasSingleElement() {
        assertEquals("Hello", StringHelper.joinWithSpace("Hello"));
    }

    @Test
    void joinWithSpace_returnsJoinedString_whenArrayHasMultipleElements() {
        assertEquals("Hello World", StringHelper.joinWithSpace("Hello", "World"));
    }

    @Test
    void joinWithSpace_returnsNull_whenListIsNull() {
        assertNull(StringHelper.joinWithSpace((List<String>) null));
    }

    @Test
    void joinWithSpace_returnsJoinedString_whenListHasMultipleElements() {
        assertEquals("Hello World", StringHelper.joinWithSpace(Arrays.asList("Hello", "World")));
    }

    @Test
    void joinWithHyphen_returnsEmptyString_whenArrayIsEmpty() {
        assertEquals("", StringHelper.joinWithHyphen());
    }

    @Test
    void joinWithHyphen_returnsSingleString_whenArrayHasSingleElement() {
        assertEquals("Hello", StringHelper.joinWithHyphen("Hello"));
    }

    @Test
    void joinWithHyphen_returnsJoinedString_whenArrayHasMultipleElements() {
        assertEquals("Hello-World", StringHelper.joinWithHyphen("Hello", "World"));
    }

    @Test
    void joinWithHyphen_returnsNull_whenListIsNull() {
        assertNull(StringHelper.joinWithHyphen((List<String>) null));
    }

    @Test
    void joinWithHyphen_returnsJoinedString_whenListHasMultipleElements() {
        assertEquals("Hello-World", StringHelper.joinWithHyphen(Arrays.asList("Hello", "World")));
    }

    @Test
    void joinWithLineBreak_returnsLineBreakSeparatedString_whenArrayHasMultipleElements() {
        assertEquals("Hello\r\nWorld", StringHelper.joinWithLineBreak("Hello", "World"));
    }

    @Test
    void joinWithLineBreak_returnsNull_whenListIsNull() {
        assertNull(StringHelper.joinWithLineBreak((List<String>) null));
    }

    @Test
    void joinWithLineBreak_returnsLineBreakSeparatedString_whenListHasMultipleElements() {
        assertEquals("Hello\r\nWorld", StringHelper.joinWithLineBreak(Arrays.asList("Hello", "World")));
    }

    @Test
    void joinWithSlash_returnsSlashSeparatedString_whenArrayHasMultipleElements() {
        assertEquals("Hello/World", StringHelper.joinWithSlash("Hello", "World"));
    }

    @Test
    void joinWithSlash_returnsNull_whenListIsNull() {
        assertNull(StringHelper.joinWithSlash((List<String>) null));
    }

    @Test
    void joinWithSlash_returnsSlashSeparatedString_whenListHasMultipleElements() {
        assertEquals("Hello/World", StringHelper.joinWithSlash(Arrays.asList("Hello", "World")));
    }

    @Test
    void joinWithBackslash_returnsBackslashSeparatedString_whenArrayHasMultipleElements() {
        assertEquals("Hello\\World", StringHelper.joinWithBackslash("Hello", "World"));
    }

    @Test
    void joinWithBackslash_returnsNull_whenListIsNull() {
        assertNull(StringHelper.joinWithBackslash((List<String>) null));
    }

    @Test
    void joinWithBackslash_returnsBackslashSeparatedString_whenListHasMultipleElements() {
        assertEquals("Hello\\World", StringHelper.joinWithBackslash(Arrays.asList("Hello", "World")));
    }

    @Test
    void joinWithFileSeparator_returnsFileSeparatorSeparatedString_whenArrayHasMultipleElements() {
        assertEquals("Hello" + File.separator + "World", StringHelper.joinWithFileSeparator("Hello", "World"));
    }

    @Test
    void joinWithFileSeparator_returnsNull_whenListIsNull() {
        assertNull(StringHelper.joinWithFileSeparator((List<String>) null));
    }

    @Test
    void joinWithFileSeparator_returnsFileSeparatorSeparatedString_whenListHasMultipleElements() {
        assertEquals("Hello" + File.separator + "World", StringHelper.joinWithFileSeparator(Arrays.asList("Hello", "World")));
    }

    @Test
    void weld_returnsEmpty_whenBothStringsAreNullOrEmpty() {
        assertEquals("", StringHelper.weld("", ""));
        assertEquals("", StringHelper.weld(null, ""));
        assertEquals("", StringHelper.weld("", null));
        assertEquals("", StringHelper.weld(null, null));
    }

    @Test
    void weld_removesDuplicateCharacter_whenBothStringsStartAndEndWithSameCharacter() {
        assertEquals("HelloWorld", StringHelper.weld("Hello", "oWorld"));
    }

    @Test
    void weld_concatenatesStrings_whenEndingAndStartingCharactersAreDifferent() {
        assertEquals("HelloWorld", StringHelper.weld("Hello", "World"));
    }

    @Test
    void weld_removesAppropriateCharacter_whenBothStringsStartAndEndWithVowels() {
        assertEquals("Helloorld", StringHelper.weld("Hello", "oorld"));
    }

    @Test
    void repeat_returnsNull_whenStringIsNull() {
        assertNull(StringHelper.repeat(null, 5));
    }

    @Test
    void repeat_returnsNull_whenCountIsNegative() {
        assertNull(StringHelper.repeat("Hello", -1));
    }

    @Test
    void repeat_returnsRepeatedString_whenCountIsPositive() {
        assertEquals("HelloHelloHello", StringHelper.repeat("Hello", 3));
    }

    @Test
    void trim_returnsNull_whenStringIsNull() {
        assertNull(StringHelper.trim(null));
    }

    @Test
    void trim_returnsTrimmedString_whenStringIsNotNull() {
        assertEquals("Hello", StringHelper.trim(" Hello "));
    }

    @Test
    void trimToNull_returnsNull_whenStringIsNull() {
        assertNull(StringHelper.trimToNull(null));
    }

    @Test
    void trimToNull_returnsNull_whenTrimmedStringIsEmpty() {
        assertNull(StringHelper.trimToNull(" "));
    }

    @Test
    void trimToEmpty_returnsEmpty_whenStringIsNull() {
        assertEquals("", StringHelper.trimToEmpty(null));
    }

    @Test
    void trimToEmpty_returnsTrimmedString_whenStringIsNotNull() {
        assertEquals("Hello", StringHelper.trimToEmpty(" Hello "));
    }

    @Test
    void trimOrDefault_returnsDefault_whenStringIsNull() {
        assertEquals(StringHelper.DEFAULT_VALUE, StringHelper.trimOrDefault(null));
    }

    @Test
    void trimOrDefault_returnsTrimmedString_whenStringIsNotNull() {
        assertEquals("Hello", StringHelper.trimOrDefault(" Hello "));
    }

    @Test
    void trimOrDefault_returnsDefault_whenTrimmedStringIsEmpty() {
        assertEquals(StringHelper.DEFAULT_VALUE, StringHelper.trimOrDefault(" "));
    }

    @Test
    void strip_returnsNull_whenStringIsNull() {
        assertNull(StringHelper.strip(null));
    }

    @Test
    void strip_returnsStrippedString_whenStringIsNotNull() {
        assertEquals("Hello", StringHelper.strip(" Hello "));
    }

    @Test
    void stripToNull_returnsNull_whenStringIsNull() {
        assertNull(StringHelper.stripToNull(null));
    }

    @Test
    void stripToNull_returnsNull_whenStrippedStringIsEmpty() {
        assertNull(StringHelper.stripToNull(" "));
    }

    @Test
    void stripToEmpty_returnsEmpty_whenStringIsNull() {
        assertEquals("", StringHelper.stripToEmpty(null));
    }

    @Test
    void stripToEmpty_returnsStrippedString_whenStringIsNotNull() {
        assertEquals("Hello", StringHelper.stripToEmpty(" Hello "));
    }

    @Test
    void stripOrDefault_returnsDefault_whenStringIsNull() {
        assertEquals(StringHelper.DEFAULT_VALUE, StringHelper.stripOrDefault(null));
    }

    @Test
    void stripOrDefault_returnsStrippedString_whenStringIsNotNull() {
        assertEquals("Hello", StringHelper.stripOrDefault(" Hello "));
    }

    @Test
    void stripOrDefault_returnsDefault_whenStrippedStringIsEmpty() {
        assertEquals(StringHelper.DEFAULT_VALUE, StringHelper.stripOrDefault(" "));
    }

    @Test
    void stripStart_returnsOriginalString_whenStringIsNull() {
        assertNull(StringHelper.stripStart(null));
    }

    @Test
    void stripStart_returnsStrippedString_whenStringIsNotNull() {
        assertEquals("Hello ", StringHelper.stripStart(" Hello "));
    }

    @Test
    void stripEnd_returnsOriginalString_whenStringIsNull() {
        assertNull(StringHelper.stripEnd(null));
    }

    @Test
    void stripEnd_returnsStrippedString_whenStringIsNotNull() {
        assertEquals(" Hello", StringHelper.stripEnd(" Hello "));
    }

    @Test
    void stripIndent_returnsOriginalString_whenStringIsNull() {
        assertNull(StringHelper.stripIndent(null));
    }

    @Test
    void stripIndent_returnsStrippedString_whenStringIsNotNull() {
        assertEquals("Hello", StringHelper.stripIndent(" Hello "));
    }

    @Test
    void normalize_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.normalize(null));
    }

    @Test
    void normalize_returnsOriginal_whenStringIsEmpty() {
        assertEquals("", StringHelper.normalize(""));
    }

    @Test
    void normalize_returnsNormalizedString_whenStringHasDiacritics() {
        assertEquals("aeiou", StringHelper.normalize("áéíóú"));
    }

    @Test
    void normalizeAlpha_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.normalizeAlpha(null));
    }

    @Test
    void normalizeAlpha_returnsOriginal_whenStringIsEmpty() {
        assertEquals("", StringHelper.normalizeAlpha(""));
    }

    @Test
    void normalizeAlpha_returnsNormalizedString_whenStringHasNonAlphabeticCharacters() {
        assertEquals("abc", StringHelper.normalizeAlpha("abc123"));
    }

    @Test
    void normalizeAlphanumeric_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.normalizeAlphanumeric(null));
    }

    @Test
    void normalizeAlphanumeric_returnsOriginal_whenStringIsEmpty() {
        assertEquals("", StringHelper.normalizeAlphanumeric(""));
    }

    @Test
    void normalizeAlphanumeric_returnsNormalizedString_whenStringHasNonAlphanumericCharacters() {
        assertEquals("abc123", StringHelper.normalizeAlphanumeric("abc123!@#"));
    }

    @Test
    void normalizeAlphaWhitespace_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.normalizeAlphaWhitespace(null));
    }

    @Test
    void normalizeAlphaWhitespace_returnsOriginal_whenStringIsEmpty() {
        assertEquals("", StringHelper.normalizeAlphaWhitespace(""));
    }

    @Test
    void normalizeAlphaWhitespace_returnsNormalizedString_whenStringHasNonAlphabeticAndNonWhitespaceCharacters() {
        assertEquals("abc def", StringHelper.normalizeAlphaWhitespace("abc def!@#"));
    }

    @Test
    void normalizeAlphanumericWhitespace_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.normalizeAlphanumericWhitespace(null));
    }

    @Test
    void normalizeAlphanumericWhitespace_returnsOriginal_whenStringIsEmpty() {
        assertEquals("", StringHelper.normalizeAlphanumericWhitespace(""));
    }

    @Test
    void normalizeAlphanumericWhitespace_returnsNormalizedString_whenStringHasNonAlphanumericAndNonWhitespaceCharacters() {
        assertEquals("abc 123", StringHelper.normalizeAlphanumericWhitespace("abc 123!@#"));
    }

    @Test
    void stripAccents_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.stripAccents(null));
    }

    @Test
    void stripAccents_returnsOriginal_whenStringIsEmpty() {
        assertEquals("", StringHelper.stripAccents(""));
    }

    @Test
    void stripAccents_returnsStrippedString_whenStringHasAccents() {
        assertEquals("aeiou", StringHelper.stripAccents("áéíóú"));
    }

    @Test
    void toUppercase_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.toUppercase(null));
    }

    @Test
    void toUppercase_returnsUppercase_whenStringIsNotNull() {
        assertEquals("HELLO", StringHelper.toUppercase("hello"));
    }

    @Test
    void toLowercase_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.toLowercase(null));
    }

    @Test
    void toLowercase_returnsLowercase_whenStringIsNotNull() {
        assertEquals("hello", StringHelper.toLowercase("HELLO"));
    }

    @Test
    void capitalizeFirst_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.capitalizeFirst(null));
    }

    @Test
    void capitalizeFirst_returnsCapitalized_whenStringIsNotNull() {
        assertEquals("Hello", StringHelper.capitalizeFirst("hello"));
    }

    @Test
    void capitalize_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.capitalize(null));
    }

    @Test
    void capitalize_returnsCapitalized_whenStringIsNotNull() {
        assertEquals("Hello World", StringHelper.capitalize("hello world"));
    }

    @Test
    void capitalizeStart_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.capitalizeStart(null));
    }

    @Test
    void capitalizeStart_returnsCapitalized_whenStringIsNotNull() {
        assertEquals("Hello", StringHelper.capitalizeStart("hello"));
    }

    @Test
    void capitalizeStarts_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.capitalizeStarts(null));
    }

    @Test
    void capitalizeStarts_returnsCapitalized_whenStringIsNotNull() {
        assertEquals("Hello World", StringHelper.capitalizeStarts("hello world"));
    }

    @Test
    void toUppercaseExceptStart_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.toUppercaseExceptStart(null));
    }

    @Test
    void toUppercaseExceptStart_returnsModified_whenStringIsNotNull() {
        assertEquals("hELLO", StringHelper.toUppercaseExceptStart("hello"));
    }

    @Test
    void toUppercaseExceptStarts_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.toUppercaseExceptStarts(null));
    }

    @Test
    void toUppercaseExceptStarts_returnsModified_whenStringIsNotNull() {
        assertEquals("hELLO wORLD", StringHelper.toUppercaseExceptStarts("hello world"));
    }

    @Test
    void uncapitalizeStart_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.uncapitalizeStart(null));
    }

    @Test
    void uncapitalizeStart_returnsModified_whenStringIsNotNull() {
        assertEquals("hELLO", StringHelper.uncapitalizeStart("HELLO"));
    }

    @Test
    void uncapitalizeStarts_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.uncapitalizeStarts(null));
    }

    @Test
    void uncapitalizeStarts_returnsModified_whenStringIsNotNull() {
        assertEquals("hELLO wORLD", StringHelper.uncapitalizeStarts("HELLO WORLD"));
    }

    @Test
    void swapCase_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.swapCase(null));
    }

    @Test
    void swapCase_returnsSwappedCase_whenStringIsNotNull() {
        assertEquals("hELLO wORLD", StringHelper.swapCase("Hello World"));
    }

    @Test
    void randomCase_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.randomCase(null, null));
    }

    @Test
    void randomCase_returnsOriginal_whenStringIsEmpty() {
        assertEquals("", StringHelper.randomCase("", null));
    }

    @Test
    void randomCase_returnsRandomCase_whenStringIsNotEmpty() {
        String s = "Hello World";
        String result = StringHelper.randomCase(s, 123L);
        assertNotEquals(s, result);
        assertNotEquals(s.toLowerCase(), result);
        assertNotEquals(s.toUpperCase(), result);
    }

    @Test
    void randomCase_returnsDifferentResult_forDifferentSeeds() {
        assertNotEquals(StringHelper.randomCase("Hello World", 123L), StringHelper.randomCase("Hello World", 456L));
    }

    @Test
    void randomCase_returnsSameResult_forSameSeed() {
        assertEquals(StringHelper.randomCase("Hello World", 123L), StringHelper.randomCase("Hello World", 123L));
    }

    @Test
    void toCamelCase_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.toCamelCase(null));
    }

    @Test
    void toCamelCase_returnsCamelCase_whenStringIsNotNull() {
        assertEquals("helloWorld", StringHelper.toCamelCase("Hello World"));
    }

    @Test
    void toPascalCase_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.toPascalCase(null));
    }

    @Test
    void toPascalCase_returnsPascalCase_whenStringIsNotNull() {
        assertEquals("HelloWorld", StringHelper.toPascalCase("Hello World"));
    }

    @Test
    void convertCase_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.convertCase(null, CaseStyle.CAMEL_CASE));
    }

    @Test
    void convertCase_returnsOriginal_whenCaseStyleIsNull() {
        assertEquals("Hello World", StringHelper.convertCase("Hello World", null));
    }

    @Test
    void convertCase_returnsCamelCase_whenCaseStyleIsCamelCase() {
        assertEquals("helloWorld", StringHelper.convertCase("Hello World", CaseStyle.CAMEL_CASE));
    }

    @Test
    void convertCase_returnsPascalCase_whenCaseStyleIsPascalCase() {
        assertEquals("HelloWorld", StringHelper.convertCase("Hello World", CaseStyle.PASCAL_CASE));
    }

    @Test
    void convertCase_returnsSnakeCase_whenCaseStyleIsSnakeCase() {
        assertEquals("hello_world", StringHelper.convertCase("Hello World", CaseStyle.SNAKE_CASE));
    }

    @Test
    void convertCase_returnsKebabCase_whenCaseStyleIsKebabCase() {
        assertEquals("hello-world", StringHelper.convertCase("Hello World", CaseStyle.KEBAB_CASE));
    }

    @Test
    void convertCase_returnsFlatCase_whenCaseStyleIsFlatCase() {
        assertEquals("helloworld", StringHelper.convertCase("Hello World", CaseStyle.FLAT_CASE));
    }

    @Test
    void convertCase_returnsUpperFlatCase_whenCaseStyleIsUpperFlatCase() {
        assertEquals("HELLOWORLD", StringHelper.convertCase("Hello World", CaseStyle.UPPER_FLAT_CASE));
    }

    @Test
    void convertCase_returnsPascalSnakeCase_whenCaseStyleIsPascalSnakeCase() {
        assertEquals("Hello_World", StringHelper.convertCase("Hello World", CaseStyle.PASCAL_SNAKE_CASE));
    }

    @Test
    void convertCase_returnsCamelSnakeCase_whenCaseStyleIsCamelSnakeCase() {
        assertEquals("hello_World", StringHelper.convertCase("Hello World", CaseStyle.CAMEL_SNAKE_CASE));
    }

    @Test
    void convertCase_returnsScreamingSnakeCase_whenCaseStyleIsScreamingSnakeCase() {
        assertEquals("HELLO_WORLD", StringHelper.convertCase("Hello World", CaseStyle.SCREAMING_SNAKE_CASE));
    }

    @Test
    void convertCase_returnsTrainCase_whenCaseStyleIsTrainCase() {
        assertEquals("Hello-World", StringHelper.convertCase("Hello World", CaseStyle.TRAIN_CASE));
    }

    @Test
    void convertCase_returnsCobolCase_whenCaseStyleIsCobolCase() {
        assertEquals("HELLO-WORLD", StringHelper.convertCase("Hello World", CaseStyle.COBOL_CASE));
    }

    @Test
    void reverse_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.reverse(null));
    }

    @Test
    void reverse_returnsOriginal_whenStringIsEmpty() {
        assertEquals("", StringHelper.reverse(""));
    }

    @Test
    void reverse_returnsReversed_whenStringIsNotNull() {
        assertEquals("dcba", StringHelper.reverse("abcd"));
    }

    @Test
    void mask_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.mask(null));
    }

    @Test
    void mask_returnsOriginal_whenStringIsEmpty() {
        assertEquals("", StringHelper.mask(""));
    }

    @Test
    void mask_returnsMasked_whenStringIsNotNull() {
        assertEquals("***", StringHelper.mask("abc"));
    }

    @Test
    void maskWithReplacement_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.mask(null, '#'));
    }

    @Test
    void maskWithReplacement_returnsOriginal_whenStringIsEmpty() {
        assertEquals("", StringHelper.mask("", '#'));
    }

    @Test
    void maskWithReplacement_returnsMasked_whenStringIsNotNull() {
        assertEquals("###", StringHelper.mask("abc", '#'));
    }

    @Test
    void maskWithRange_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.mask(null, '#', 0, 2));
    }

    @Test
    void maskWithRange_returnsOriginal_whenStringIsEmpty() {
        assertEquals("", StringHelper.mask("", '#', 0, 2));
    }

    @Test
    void maskWithRange_returnsOriginal_whenRangeIsInvalid() {
        assertEquals("abc", StringHelper.mask("abc", '#', 2, 0));
    }

    @Test
    void maskWithRange_returnsMasked_whenRangeIsValid() {
        assertEquals("a#c", StringHelper.mask("abc", '#', 1, 1));
    }

    @Test
    void maskStart_returnsMasked_whenStringIsLongerThanFour() {
        assertEquals("*ello", StringHelper.maskStart("Hello"));
    }

    @Test
    void maskStartWithReplacement_returnsMasked_whenStringIsLongerThanFour() {
        assertEquals("#ello", StringHelper.maskStart("Hello", '#'));
    }

    @Test
    void maskStartWithUnmaskedChars_returnsMasked_whenStringIsLongerThanUnmaskedChars() {
        assertEquals("###lo", StringHelper.maskStart("Hello", '#', 2));
    }

    @Test
    void maskMiddle_masksAll_whenStringLengthIsFourOrLess() {
        assertEquals("****", StringHelper.maskMiddle("Test"));
    }

    @Test
    void maskMiddle_masksAllExceptFirstAndLast_whenStringLengthIsBetweenFiveAndEight() {
        assertEquals("T******t", StringHelper.maskMiddle("TestTest"));
    }

    @Test
    void maskMiddle_masksAllExceptFirstTwoAndLastTwo_whenStringLengthIsBetweenNineAndTwelve() {
        assertEquals("Te********st", StringHelper.maskMiddle("TestTestTest"));
    }

    @Test
    void maskMiddle_masksAllExceptFirstThreeAndLastThree_whenStringLengthIsGreaterThanTwelve() {
        assertEquals("Tes**********est", StringHelper.maskMiddle("TestTestTestTest"));
    }

    @Test
    void maskMiddle_withReplacementChar_masksAll_whenStringLengthIsFourOrLess() {
        assertEquals("####", StringHelper.maskMiddle("Test", '#'));
    }

    @Test
    void maskMiddle_withReplacementChar_masksAllExceptFirstAndLast_whenStringLengthIsBetweenFiveAndEight() {
        assertEquals("T######t", StringHelper.maskMiddle("TestTest", '#'));
    }

    @Test
    void maskMiddle_withReplacementChar_masksAllExceptFirstTwoAndLastTwo_whenStringLengthIsBetweenNineAndTwelve() {
        assertEquals("Te########st", StringHelper.maskMiddle("TestTestTest", '#'));
    }

    @Test
    void maskMiddle_withReplacementChar_masksAllExceptFirstThreeAndLastThree_whenStringLengthIsGreaterThanTwelve() {
        assertEquals("Tes##########est", StringHelper.maskMiddle("TestTestTestTest", '#'));
    }

    @Test
    void maskMiddle_withMaskedChars_masksSpecifiedNumberOfCharsInTheMiddle() {
        assertEquals("Tes**est", StringHelper.maskMiddle("TestTest", '*', 2));
    }

    @Test
    void maskMiddle_withMaskedChars_masksEntireString_whenStringLengthIsLessThanOrEqualToMaskedChars() {
        assertEquals("****", StringHelper.maskMiddle("Test", '*', 4));
    }

    @Test
    void maskEnd_returnsMasked_whenStringIsLongerThanFour() {
        assertEquals("Hell*", StringHelper.maskEnd("Hello"));
    }

    @Test
    void maskEndWithReplacement_returnsMasked_whenStringIsLongerThanFour() {
        assertEquals("Hell#", StringHelper.maskEnd("Hello", '#'));
    }

    @Test
    void maskEndWithUnmaskedChars_returnsMasked_whenStringIsLongerThanUnmaskedChars() {
        assertEquals("He###", StringHelper.maskEnd("Hello", '#', 2));
    }

    @Test
    void shuffle_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.shuffle(null, 123L));
    }

    @Test
    void shuffle_returnsOriginal_whenStringIsEmpty() {
        assertEquals("", StringHelper.shuffle("", 123L));
    }

    @Test
    void shuffle_returnsShuffled_whenStringIsNotEmpty() {
        String s = "Hello World";
        String shuffled = StringHelper.shuffle(s, 123L);
        assertNotEquals(s, shuffled);
        char[] originalChars = s.toCharArray();
        char[] shuffledChars = shuffled.toCharArray();
        Arrays.sort(originalChars);
        Arrays.sort(shuffledChars);
        assertArrayEquals(originalChars, shuffledChars);
    }

    @Test
    void shuffle_returnsDifferentResult_forDifferentSeeds() {
        assertNotEquals(StringHelper.shuffle("Hello World", 123L), StringHelper.shuffle("Hello World", 456L));
    }

    @Test
    void shuffle_returnsSameResult_forSameSeed() {
        assertEquals(StringHelper.shuffle("Hello World", 123L), StringHelper.shuffle("Hello World", 123L));
    }

    @Test
    void substring_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.substring(null, 0, 1));
    }

    @Test
    void substring_returnsOriginal_whenStringIsEmpty() {
        assertEquals("", StringHelper.substring("", 0, 1));
    }

    @Test
    void substring_returnsSubstring_whenIndicesAreValid() {
        assertEquals("el", StringHelper.substring("Hello", 1, 3));
    }

    @Test
    void substringBefore_returnsOriginal_whenSeparatorIsNull() {
        assertEquals("Hello", StringHelper.substringBefore("Hello", null));
    }

    @Test
    void substringBefore_returnsOriginal_whenSeparatorIsNotFound() {
        assertEquals("Hello", StringHelper.substringBefore("Hello", "x"));
    }

    @Test
    void substringBefore_returnsSubstring_whenSeparatorIsFound() {
        assertEquals("Hel", StringHelper.substringBefore("Hello", "lo"));
    }

    @Test
    void substringBetween_returnsNull_whenOpenOrCloseIsNull() {
        assertNull(StringHelper.substringBetween("Hello", null, "lo"));
        assertNull(StringHelper.substringBetween("Hello", "Hel", null));
    }

    @Test
    void substringBetween_returnsSubstring_whenOpenAndCloseAreFound() {
        assertEquals("", StringHelper.substringBetween("Hello", "el", "lo"));
    }

    @Test
    void substringAfter_returnsOriginal_whenSeparatorIsNull() {
        assertEquals("", StringHelper.substringAfter("Hello", null));
    }

    @Test
    void substringAfter_returnsEmpty_whenSeparatorIsNotFound() {
        assertEquals("", StringHelper.substringAfter("Hello", "x"));
    }

    @Test
    void substringAfter_returnsSubstring_whenSeparatorIsFound() {
        assertEquals("lo", StringHelper.substringAfter("Hello", "Hel"));
    }

    @Test
    void replace_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.replace(null, 'a', 'b'));
    }

    @Test
    void replace_returnsOriginal_whenStringIsEmpty() {
        assertEquals("", StringHelper.replace("", 'a', 'b'));
    }

    @Test
    void replace_returnsModified_whenOccurrenceExists() {
        assertEquals("bcb", StringHelper.replace("aca", 'a', 'b'));
    }

    @Test
    void replace_returnsOriginal_whenOccurrenceDoesNotExist() {
        assertEquals("aca", StringHelper.replace("aca", 'b', 'b'));
    }

    @Test
    void replaceString_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.replace(null, "abc", "def"));
    }

    @Test
    void replaceString_returnsOriginal_whenStringIsEmpty() {
        assertEquals("", StringHelper.replace("", "abc", "def"));
    }

    @Test
    void replaceString_returnsModified_whenOccurrenceExists() {
        assertEquals("defdef", StringHelper.replace("abcabc", "abc", "def"));
    }

    @Test
    void replaceString_returnsOriginal_whenOccurrenceDoesNotExist() {
        assertEquals("abcabc", StringHelper.replace("abcabc", "def", "def"));
    }

    @Test
    void replaceWith_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.replaceWith(null, "abc", "def"));
    }

    @Test
    void replaceWith_returnsOriginal_whenStringIsEmpty() {
        assertEquals("", StringHelper.replaceWith("", "abc", "def"));
    }

    @Test
    void replaceWith_returnsModified_whenOccurrenceExists() {
        assertEquals("defdef", StringHelper.replaceWith("abcabc", "abc", "def"));
    }

    @Test
    void replaceWith_returnsOriginal_whenOccurrenceDoesNotExist() {
        assertEquals("abcabc", StringHelper.replaceWith("abcabc", "def", "def"));
    }

    @Test
    void replaceByIndex_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.replaceByIndex(null, 1, 2, "replacement"));
    }

    @Test
    void replaceByIndex_returnsOriginal_whenIndicesAreInvalid() {
        assertEquals("abc", StringHelper.replaceByIndex("abc", 3, 1, "replacement"));
    }

    @Test
    void replaceByIndex_returnsModified_whenIndicesAreValid() {
        assertEquals("areplacementc", StringHelper.replaceByIndex("abc", 1, 2, "replacement"));
    }

    @Test
    void replaceFirstChar_returnsReplacement_whenStringIsNotNullOrEmpty() {
        assertEquals("bello", StringHelper.replaceFirstChar("hello", "b"));
    }

    @Test
    void replaceFirstChar_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.replaceFirstChar(null, "b"));
    }

    @Test
    void replaceLastChar_returnsReplacement_whenStringIsNotNullOrEmpty() {
        assertEquals("hellb", StringHelper.replaceLastChar("hello", "b"));
    }

    @Test
    void replaceLastChar_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.replaceLastChar(null, "b"));
    }

    @Test
    void replaceOnce_returnsModified_whenOccurrenceExists() {
        assertEquals("hxllo", StringHelper.replaceOnce("hello", "e", "x"));
    }

    @Test
    void replaceOnce_returnsOriginal_whenOccurrenceDoesNotExist() {
        assertEquals("hello", StringHelper.replaceOnce("hello", "x", "y"));
    }

    @Test
    void replaceFinal_returnsModified_whenOccurrenceExists() {
        assertEquals("hellx", StringHelper.replaceFinal("hello", "o", "x"));
    }

    @Test
    void replaceFinal_returnsOriginal_whenOccurrenceDoesNotExist() {
        assertEquals("hello", StringHelper.replaceFinal("hello", "x", "y"));
    }

    @Test
    void replaceFirst_returnsModified_whenRegexMatches() {
        assertEquals("hxllo", StringHelper.replaceFirst("hello", "e", "x"));
    }

    @Test
    void replaceFirst_returnsOriginal_whenRegexDoesNotMatch() {
        assertEquals("hello", StringHelper.replaceFirst("hello", "x", "y"));
    }

    @Test
    void replaceLast_returnsModified_whenRegexMatches() {
        assertEquals("hellx", StringHelper.replaceLast("hello", "o", "x"));
    }

    @Test
    void replaceLast_returnsOriginal_whenRegexDoesNotMatch() {
        assertEquals("hello", StringHelper.replaceLast("hello", "x", "y"));
    }

    @Test
    void replaceEach_returnsOriginal_whenOccurrencesOrReplacementsAreNull() {
        assertEquals("Hello, World!", StringHelper.replaceEach("Hello, World!", new String[]{"Hello", "World"}, new String[]{null, null}));
    }

    @Test
    void replaceEach_returnsReplaced_whenOccurrencesAndReplacementsAreValid() {
        assertEquals("Hello, World!", StringHelper.replaceEach("Hello, World!", new String[]{"Hi", "Earth"}, new String[]{null, null}));
    }

    @Test
    void replaceAll_returnsOriginal_whenStringIsNullOrEmpty() {
        assertNull(StringHelper.replaceAll(null, "\\s", ""));
        assertEquals("", StringHelper.replaceAll("", "\\s", ""));
    }

    @Test
    void replaceAll_returnsReplaced_whenRegexMatches() {
        assertEquals("Hello,World!", StringHelper.replaceAll("Hello, World!", "\\s", ""));
    }

    @Test
    void replaceGroup_returnsOriginal_whenStringIsNullOrEmpty() {
        assertNull(StringHelper.replaceGroup(null, "\\s", 1, ""));
        assertEquals("", StringHelper.replaceGroup("", "\\s", 1, ""));
    }

    @Test
    void replaceGroup_returnsReplaced_whenRegexMatches() {
        assertEquals("Hello, Earth!", StringHelper.replaceGroup("Hello, World!", "(\\w+), (\\w+)!", 2, 1, "Earth"));
    }

    @Test
    void replaceGroup_returnsOriginal_whenGroupOccurrenceIsInvalid() {
        assertEquals("Hello, World!", StringHelper.replaceGroup("Hello, World!", "\\w+, \\w+!", 1, 1, "Earth"));
    }

    @Test
    void replaceGroup_returnsReplaced_whenGroupOccurrenceIsValid() {
        assertEquals("Hello, World! Hello, Earth!", StringHelper.replaceGroup("Hello, World! Hello, World!", "(\\w+), (\\w+)!", 2, 2, "Earth"));
    }

    @Test
    void replaceStart_returnsReplacement_whenPrefixMatches() {
        assertEquals("Hi, World!", StringHelper.replaceStart("Hello, World!", "Hello", "Hi"));
    }

    @Test
    void replaceAnyStart_returnsReplacement_whenAnyPrefixMatches() {
        assertEquals("Hi, World!", StringHelper.replaceAnyStart("Hello, World!", "Hi", "Hello"));
    }

    @Test
    void replaceEachStart_returnsReplacement_whenAnyPrefixMatches() {
        assertEquals("Hi, World!", StringHelper.replaceEachStart("Hello, World!", new String[]{"Hello", "World"}, new String[]{"Hi", "Everyone"}));
    }

    @Test
    void replaceEnd_returnsReplacement_whenSuffixMatches() {
        assertEquals("Hello, Everyone!", StringHelper.replaceEnd("Hello, World!", "World!", "Everyone!"));
    }

    @Test
    void replaceAnyEnd_returnsReplacement_whenAnySuffixMatches() {
        assertEquals("Hello, Everyone!", StringHelper.replaceAnyEnd("Hello, World!", "Everyone!", "Hello", "World!"));
    }

    @Test
    void replaceEachEnd_returnsReplacement_whenAnySuffixMatches() {
        assertEquals("Hello, Everyone!", StringHelper.replaceEachEnd("Hello, World!", new String[]{"Hello", "World!"}, new String[]{"Hi", "Everyone!"}));
    }

    @Test
    void replaceBetweenChars_returnsOriginal_whenDelimitersAreNull() {
        assertEquals("Hello, World!", StringHelper.replaceBetweenChars("Hello, World!", '\0', '\0', "Hi"));
    }

    @Test
    void replaceBetweenChars_returnsModified_whenDelimitersAreValid() {
        assertEquals("Hid!", StringHelper.replaceBetweenChars("Hello, World!", 'H', 'd', "i"));
    }

    @Test
    void replaceBetweenChars_sameDelimiter_returnsOriginal_whenDelimiterIsNull() {
        assertEquals("Hello, World!", StringHelper.replaceBetweenChars("Hello, World!", '\0', "Hi"));
    }

    @Test
    void replaceBetweenChars_sameDelimiter_returnsModified_whenDelimiterIsValid() {
        assertEquals("extreme", StringHelper.replaceBetweenChars("example", 'e', "xtrem"));
    }

    @Test
    void replaceBetweenParentheses_returnsModified_whenStringContainsParentheses() {
        assertEquals("(Hi)", StringHelper.replaceBetweenParentheses("(Hello, World!)", "Hi"));
    }

    @Test
    void replaceBetweenParentheses_returnsOriginal_whenStringDoesNotContainParentheses() {
        assertEquals("Hello, World!", StringHelper.replaceBetweenParentheses("Hello, World!", "Hi"));
    }

    @Test
    void replaceTags_returnsOriginal_whenStringOrMapIsNull() {
        assertNull(StringHelper.replaceTags(null, new HashMap<>()));
        assertEquals("Hello, ${name}!", StringHelper.replaceTags("Hello, ${name}!", null));
    }

    @Test
    void replaceTags_returnsModified_whenTagsArePresent() {
        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("name", "World");
        assertEquals("Hello, World!", StringHelper.replaceTags("Hello, ${name}!", valuesMap));
    }

    @Test
    void remove_removesCharacterOccurrence_whenOccurrenceExists() {
        assertEquals("Hell, Wrld!", StringHelper.remove("Hello, World!", 'o'));
    }

    @Test
    void remove_returnsOriginal_whenCharacterOccurrenceDoesNotExist() {
        assertEquals("Hello, World!", StringHelper.remove("Hello, World!", 'x'));
    }

    @Test
    void remove_returnsOriginal_whenStringIsNull_andCharacterOccurrenceExists() {
        assertNull(StringHelper.remove(null, 'o'));
    }

    @Test
    void remove_removesStringOccurrence_whenOccurrenceExists() {
        assertEquals("Hell, Wrld!", StringHelper.remove("Hello, World!", "o"));
    }

    @Test
    void remove_returnsOriginal_whenStringOccurrenceDoesNotExist() {
        assertEquals("Hello, World!", StringHelper.remove("Hello, World!", "x"));
    }

    @Test
    void remove_returnsOriginal_whenStringIsNull_andStringOccurrenceExists() {
        assertNull(StringHelper.remove(null, "o"));
    }

    @Test
    void removeByIndex_returnsOriginal_whenIndicesAreInvalid() {
        assertEquals("abc", StringHelper.removeByIndex("abc", -1, 4));
    }

    @Test
    void removeByIndex_returnsModified_whenIndicesAreValid() {
        assertEquals("ac", StringHelper.removeByIndex("abc", 1, 2));
    }

    @Test
    void removeEach_returnsOriginal_whenOccurrencesAreNull() {
        assertEquals("abc", StringHelper.removeEach("abc", (String[]) null));
    }

    @Test
    void removeEach_returnsModified_whenOccurrencesExist() {
        assertEquals("c", StringHelper.removeEach("abc", "a", "b"));
    }

    @Test
    void removeAll_returnsOriginal_whenStringIsNullOrEmpty() {
        assertEquals("", StringHelper.removeAll("", "\\d"));
    }

    @Test
    void removeAll_returnsReplaced_whenRegexMatches() {
        assertEquals("abc", StringHelper.removeAll("abc123", "\\d"));
    }

    @Test
    void removeGroup_removesGroup_whenGroupExists() {
        assertEquals("abc", StringHelper.removeGroup("abc123", "(\\d+)", 1));
    }

    @Test
    void removeGroup_returnsOriginal_whenGroupDoesNotExist() {
        assertEquals("abc123", StringHelper.removeGroup("abc123", "([a-z]{3})", 2));
    }

    @Test
    void removeGroup_returnsOriginal_whenStringIsNull() {
        assertNull(null, StringHelper.removeGroup(null, "(\\d+)", 1));
    }

    @Test
    void removeGroup_occurrence_removesGroup_whenGroupExists() {
        assertEquals("abc123456", StringHelper.removeGroup("abc123abc456", "([a-z]{3})", 1, 2));
    }

    @Test
    void removeFirstChar_removesFirstChar_whenStringIsNotEmpty() {
        assertEquals("bc", StringHelper.removeFirstChar("abc"));
    }

    @Test
    void removeFirstChar_returnsEmpty_whenStringIsEmpty() {
        assertEquals("", StringHelper.removeFirstChar(""));
    }

    @Test
    void removeFirstChar_returnsNull_whenStringIsNull() {
        assertNull(StringHelper.removeFirstChar(null));
    }

    @Test
    void removeLastChar_removesLastChar_whenStringIsNotEmpty() {
        assertEquals("ab", StringHelper.removeLastChar("abc"));
    }

    @Test
    void removeLastChar_returnsEmpty_whenStringIsEmpty() {
        assertEquals("", StringHelper.removeLastChar(""));
    }

    @Test
    void removeLastChar_returnsNull_whenStringIsNull() {
        assertNull(StringHelper.removeLastChar(null));
    }

    @Test
    void removeOnce_removesOccurrence_whenOccurrenceExists() {
        assertEquals("abc", StringHelper.removeOnce("abcabc", "abc"));
    }

    @Test
    void removeOnce_returnsOriginal_whenOccurrenceDoesNotExist() {
        assertEquals("abcabc", StringHelper.removeOnce("abcabc", "def"));
    }

    @Test
    void removeOnce_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.removeOnce(null, "abc"));
    }

    @Test
    void removeFinal_removesFinalOccurrence_whenOccurrenceExists() {
        assertEquals("Hello, Wrld!", StringHelper.removeFinal("Hello, World!", "o"));
    }

    @Test
    void removeFinal_returnsOriginal_whenOccurrenceDoesNotExist() {
        assertEquals("Hello, World!", StringHelper.removeFinal("Hello, World!", "x"));
    }

    @Test
    void removeFirst_removesFirstMatch_whenRegexMatches() {
        assertEquals("Hell, World!", StringHelper.removeFirst("Hello, World!", "o"));
    }

    @Test
    void removeFirst_returnsOriginal_whenRegexDoesNotMatch() {
        assertEquals("Hello, World!", StringHelper.removeFirst("Hello, World!", "x"));
    }

    @Test
    void removeLast_removesLastMatch_whenRegexMatches() {
        assertEquals("Hello, Wrld!", StringHelper.removeLast("Hello, World!", "o"));
    }

    @Test
    void removeLast_returnsOriginal_whenRegexDoesNotMatch() {
        assertEquals("Hello, World!", StringHelper.removeLast("Hello, World!", "x"));
    }

    @Test
    void removeStart_removesPrefix_whenPrefixMatches() {
        assertEquals(", World!", StringHelper.removeStart("Hello, World!", "Hello"));
    }

    @Test
    void removeStart_returnsOriginal_whenPrefixDoesNotMatch() {
        assertEquals("Hello, World!", StringHelper.removeStart("Hello, World!", "World"));
    }

    @Test
    void removeAnyStart_removesAnyPrefix_whenAnyPrefixMatches() {
        assertEquals(", World!", StringHelper.removeAnyStart("Hello, World!", "Hello", "World"));
    }

    @Test
    void removeAnyStart_returnsOriginal_whenNoPrefixMatches() {
        assertEquals("Hello, World!", StringHelper.removeAnyStart("Hello, World!", "Hi", "World"));
    }

    @Test
    void removeEnd_removesSuffix_whenSuffixMatches() {
        assertEquals("Hello, ", StringHelper.removeEnd("Hello, World!", "World!"));
    }

    @Test
    void removeEnd_returnsOriginal_whenSuffixDoesNotMatch() {
        assertEquals("Hello, World!", StringHelper.removeEnd("Hello, World!", "Hello"));
    }

    @Test
    void removeAnyEnd_removesAnySuffix_whenAnySuffixMatches() {
        assertEquals("Hello, ", StringHelper.removeAnyEnd("Hello, World!", "Hello", "World!"));
    }

    @Test
    void removeAnyEnd_returnsOriginal_whenNoSuffixMatches() {
        assertEquals("Hello, World!", StringHelper.removeAnyEnd("Hello, World!", "Hi", "World"));
    }

    @Test
    void removeWithinDelimiters_removesContentBetweenDelimiters_whenDelimitersArePresent() {
        assertEquals("Hello !", StringHelper.removeWithinDelimiters("Hello [World]!", '[', ']'));
    }

    @Test
    void removeWithinDelimiters_returnsOriginal_whenDelimitersAreNull() {
        assertEquals("Hello [World]!", StringHelper.removeWithinDelimiters("Hello [World]!", '\0', '\0'));
    }

    @Test
    void removeWithinDelimiters_sameDelimiter_removesContentBetweenDelimiters_whenDelimitersArePresent() {
        assertEquals("Hello !", StringHelper.removeWithinDelimiters("Hello *World*!", '*'));
    }

    @Test
    void removeWithinDelimiters_sameDelimiter_returnsOriginal_whenDelimiterIsNull() {
        assertEquals("Hello *World*!", StringHelper.removeWithinDelimiters("Hello *World*!", '\0'));
    }

    @Test
    void removeWithinParentheses_removesContentBetweenParentheses_whenParenthesesArePresent() {
        assertEquals("Hello !", StringHelper.removeWithinParentheses("Hello (World)!"));
    }

    @Test
    void getFirstChar_returnsNullChar_whenStringIsNull() {
        assertEquals(CharHelper.NULL_CHAR, StringHelper.getFirstChar(null));
    }

    @Test
    void getFirstChar_returnsNullChar_whenStringIsEmpty() {
        assertEquals(CharHelper.NULL_CHAR, StringHelper.getFirstChar(""));
    }

    @Test
    void getFirstChar_returnsFirstChar_whenStringIsNotEmpty() {
        assertEquals('H', StringHelper.getFirstChar("Hello"));
    }

    @Test
    void getLastChar_returnsNullChar_whenStringIsNull() {
        assertEquals(CharHelper.NULL_CHAR, StringHelper.getLastChar(null));
    }

    @Test
    void getLastChar_returnsNullChar_whenStringIsEmpty() {
        assertEquals(CharHelper.NULL_CHAR, StringHelper.getLastChar(""));
    }

    @Test
    void getLastChar_returnsLastChar_whenStringIsNotEmpty() {
        assertEquals('o', StringHelper.getLastChar("Hello"));
    }

    @Test
    void getStart_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.getStart(null));
    }

    @Test
    void getStart_returnsOriginal_whenStringIsEmpty() {
        assertEquals("", StringHelper.getStart(""));
    }

    @Test
    void getStart_returnsFirstCharAsString_whenStringIsNotEmpty() {
        assertEquals("H", StringHelper.getStart("Hello"));
    }

    @Test
    void getEnd_returnsOriginal_whenStringIsNull() {
        assertNull(StringHelper.getEnd(null));
    }

    @Test
    void getEnd_returnsOriginal_whenStringIsEmpty() {
        assertEquals("", StringHelper.getEnd(""));
    }

    @Test
    void getEnd_returnsLastCharAsString_whenStringIsNotEmpty() {
        assertEquals("o", StringHelper.getEnd("Hello"));
    }

    @Test
    void left_returnsNull_whenStringIsNull() {
        assertNull(StringHelper.left(null, 3));
    }

    @Test
    void left_returnsOriginal_whenCountIsNegative() {
        assertEquals("Hello", StringHelper.left("Hello", -1));
    }

    @Test
    void left_returnsOriginal_whenCountExceedsLength() {
        assertEquals("Hello", StringHelper.left("Hello", 10));
    }

    @Test
    void left_returnsSubstring_whenCountIsLessThanLength() {
        assertEquals("Hel", StringHelper.left("Hello", 3));
    }

    @Test
    void right_returnsNull_whenStringIsNull() {
        assertNull(StringHelper.right(null, 3));
    }

    @Test
    void right_returnsOriginal_whenCountIsNegative() {
        assertEquals("Hello", StringHelper.right("Hello", -1));
    }

    @Test
    void right_returnsOriginal_whenCountExceedsLength() {
        assertEquals("Hello", StringHelper.right("Hello", 10));
    }

    @Test
    void right_returnsSubstring_whenCountIsLessThanLength() {
        assertEquals("llo", StringHelper.right("Hello", 3));
    }

    @Test
    void substringBeforeLast_returnsOriginal_whenSeparatorNotFound() {
        assertEquals("Hello", StringHelper.substringBeforeLast("Hello", "x"));
    }

    @Test
    void substringBeforeLast_returnsSubstring_whenSeparatorFound() {
        assertEquals("Hel", StringHelper.substringBeforeLast("Hello", "lo"));
    }

    @Test
    void substringAfterLast_returnsOriginal_whenSeparatorNotFound() {
        assertEquals("Hello", StringHelper.substringAfterLast("Hello", "x"));
    }

    @Test
    void substringAfterLast_returnsSubstring_whenSeparatorFound() {
        assertEquals("o", StringHelper.substringAfterLast("Hello", "l"));
    }

    @Test
    void equals_returnsTrue_whenBothStringsAreNull() {
        assertTrue(StringHelper.equals(null, null));
    }

    @Test
    void equals_returnsFalse_whenOneStringIsNull() {
        assertFalse(StringHelper.equals(null, "test"));
        assertFalse(StringHelper.equals("test", null));
    }

    @Test
    void equals_returnsTrue_whenStringsAreIdentical() {
        assertTrue(StringHelper.equals("test", "test"));
    }

    @Test
    void equalsIgnoreCase_returnsTrue_whenStringsAreIdenticalIgnoringCase() {
        assertTrue(StringHelper.equalsIgnoreCase("test", "TEST"));
    }

    @Test
    void equalsIgnoreCase_returnsFalse_whenOneStringIsNull() {
        assertFalse(StringHelper.equalsIgnoreCase(null, "test"));
        assertFalse(StringHelper.equalsIgnoreCase("test", null));
    }

    @Test
    void equalsAny_returnsFalse_whenStringIsNull() {
        assertFalse(StringHelper.equalsAny(null, "test1", "test2"));
    }

    @Test
    void equalsAny_returnsTrue_whenStringMatchesOneOccurrence() {
        assertTrue(StringHelper.equalsAny("test1", "test1", "test2"));
    }

    @Test
    void equalsAny_returnsFalse_whenStringMatchesNoOccurrences() {
        assertFalse(StringHelper.equalsAny("test", "test1", "test2"));
    }

    @Test
    void equalsDefault_returnsTrue_whenStringMatchesDefaultValue() {
        assertTrue(StringHelper.equalsDefault(StringHelper.DEFAULT_VALUE));
    }

    @Test
    void equalsDefault_returnsFalse_whenStringDoesNotMatchDefaultValue() {
        assertFalse(StringHelper.equalsDefault("test"));
    }

    @Test
    void startsWith_returnsTrue_whenStringStartsWithChar() {
        assertTrue(StringHelper.startsWith("hello", 'h'));
    }

    @Test
    void startsWith_returnsFalse_whenStringDoesNotStartWithChar() {
        assertFalse(StringHelper.startsWith("hello", 'a'));
    }

    @Test
    void startsWith_returnsFalse_whenStringIsNull() {
        assertFalse(StringHelper.startsWith(null, 'a'));
    }

    @Test
    void startsWithPrefix_returnsTrue_whenStringStartsWithPrefix() {
        assertTrue(StringHelper.startsWith("hello", "he"));
    }

    @Test
    void startsWithPrefix_returnsFalse_whenStringDoesNotStartWithPrefix() {
        assertFalse(StringHelper.startsWith("hello", "hi"));
    }

    @Test
    void startsWithPrefix_returnsFalse_whenStringIsNull() {
        assertFalse(StringHelper.startsWith(null, "hi"));
    }

    @Test
    void startsWithAnyChar_returnsTrue_whenStringStartsWithAnyChar() {
        assertTrue(StringHelper.startsWithAny("hello", 'h', 'a'));
    }

    @Test
    void startsWithAnyChar_returnsFalse_whenStringDoesNotStartWithAnyChar() {
        assertFalse(StringHelper.startsWithAny("hello", 'a', 'b'));
    }

    @Test
    void startsWithAnyChar_returnsFalse_whenStringIsNull() {
        assertFalse(StringHelper.startsWithAny(null, 'a', 'b'));
    }

    @Test
    void startsWithAnyPrefix_returnsTrue_whenStringStartsWithAnyPrefix() {
        assertTrue(StringHelper.startsWithAny("hello", "he", "hi"));
    }

    @Test
    void startsWithAnyPrefix_returnsFalse_whenStringDoesNotStartWithAnyPrefix() {
        assertFalse(StringHelper.startsWithAny("hello", "hi", "ha"));
    }

    @Test
    void startsWithAnyPrefix_returnsFalse_whenStringIsNull() {
        assertFalse(StringHelper.startsWithAny(null, "hi", "ha"));
    }

    @Test
    void endsWith_returnsTrue_whenStringEndsWithChar() {
        assertTrue(StringHelper.endsWith("hello", 'o'));
    }

    @Test
    void endsWith_returnsFalse_whenStringDoesNotEndWithChar() {
        assertFalse(StringHelper.endsWith("hello", 'a'));
    }

    @Test
    void endsWith_returnsFalse_whenStringIsNull() {
        assertFalse(StringHelper.endsWith(null, 'a'));
    }

    @Test
    void endsWithSuffix_returnsTrue_whenStringEndsWithSuffix() {
        assertTrue(StringHelper.endsWith("hello", "lo"));
    }

    @Test
    void endsWithSuffix_returnsFalse_whenStringDoesNotEndWithSuffix() {
        assertFalse(StringHelper.endsWith("hello", "la"));
    }

    @Test
    void endsWithSuffix_returnsFalse_whenStringIsNull() {
        assertFalse(StringHelper.endsWith(null, "la"));
    }

    @Test
    void endsWithAnyChar_returnsTrue_whenStringEndsWithAnyChar() {
        assertTrue(StringHelper.endsWithAny("hello", 'o', 'a'));
    }

    @Test
    void endsWithAnyChar_returnsFalse_whenStringDoesNotEndWithAnyChar() {
        assertFalse(StringHelper.endsWithAny("hello", 'a', 'b'));
    }

    @Test
    void endsWithAnyChar_returnsFalse_whenStringIsNull() {
        assertFalse(StringHelper.endsWithAny(null, 'a', 'b'));
    }

    @Test
    void endsWithAnySuffix_returnsTrue_whenStringEndsWithAnySuffix() {
        assertTrue(StringHelper.endsWithAny("hello", "lo", "la"));
    }

    @Test
    void endsWithAnySuffix_returnsFalse_whenStringDoesNotEndWithAnySuffix() {
        assertFalse(StringHelper.endsWithAny("hello", "la", "le"));
    }

    @Test
    void endsWithAnySuffix_returnsFalse_whenStringIsNull() {
        assertFalse(StringHelper.endsWithAny(null, "la", "le"));
    }

    @Test
    void has_returnsFalse_whenStringIsNull() {
        assertFalse(StringHelper.has(null, 'a'));
    }

    @Test
    void has_returnsFalse_whenCharacterIsNotPresent() {
        assertFalse(StringHelper.has("hello", 'z'));
    }

    @Test
    void has_returnsTrue_whenCharacterIsPresent() {
        assertTrue(StringHelper.has("hello", 'e'));
    }

    @Test
    void has_returnsFalse_whenStringIsNull_forSubstring() {
        assertFalse(StringHelper.has(null, "he"));
    }

    @Test
    void has_returnsFalse_whenSubstringIsNotPresent() {
        assertFalse(StringHelper.has("hello", "ze"));
    }

    @Test
    void has_returnsTrue_whenSubstringIsPresent() {
        assertTrue(StringHelper.has("hello", "ell"));
    }

    @Test
    void hasAny_returnsFalse_whenStringIsNull() {
        assertFalse(StringHelper.hasAny(null, 'a', 'b'));
    }

    @Test
    void hasAny_returnsFalse_whenNoCharactersArePresent() {
        assertFalse(StringHelper.hasAny("hello", 'z', 'x'));
    }

    @Test
    void hasAny_returnsTrue_whenAtLeastOneCharacterIsPresent() {
        assertTrue(StringHelper.hasAny("hello", 'e', 'z'));
    }

    @Test
    void hasAny_returnsFalse_whenStringIsNull_forAffixes() {
        assertFalse(StringHelper.hasAny(null, "he", "lo"));
    }

    @Test
    void hasAny_returnsFalse_whenNoAffixesArePresent() {
        assertFalse(StringHelper.hasAny("hello", "ze", "xa"));
    }

    @Test
    void hasAny_returnsTrue_whenAtLeastOneAffixIsPresent() {
        assertTrue(StringHelper.hasAny("hello", "ell", "ze"));
    }

    @Test
    void escapeJavaString_returnsNull_whenInputIsNull() {
        assertNull(StringHelper.escapeJavaString(null));
    }

    @Test
    void escapeJavaString_returnsEscapedString_whenInputContainsSpecialCharacters() {
        assertEquals("\\\\b\\f\\n\\r\\t\\'\\\"", StringHelper.escapeJavaString("\\b\f\n\r\t'\""));
    }

    @Test
    void escapeJavaString_returnsOriginalString_whenInputDoesNotContainSpecialCharacters() {
        assertEquals("hello", StringHelper.escapeJavaString("hello"));
    }

    @Test
    void unescapeJavaString_returnsOriginal_whenInputIsNull() {
        assertNull(StringHelper.unescapeJavaString(null));
    }

    @Test
    void unescapeJavaString_returnsOriginal_whenInputIsEmpty() {
        assertEquals("", StringHelper.unescapeJavaString(""));
    }

    @Test
    void unescapeJavaString_returnsUnescapedString_whenInputContainsEscapeSequences() {
        assertEquals("\\b\f\n\r\t'\"", StringHelper.unescapeJavaString("\\\\b\\f\\n\\r\\t\\'\\\""));
    }

    @Test
    void unescapeJavaString_returnsOriginalString_whenInputDoesNotContainEscapeSequences() {
        assertEquals("hello", StringHelper.unescapeJavaString("hello"));
    }

    @Test
    void getUnicode_returnsNull_whenInputIsNull() {
        assertNull(StringHelper.getUnicode('\0'));
    }

    @Test
    void getUnicode_returnsUnicodeString_whenInputIsNotNull() {
        assertEquals("\\u0041", StringHelper.getUnicode('A'));
    }

    @Test
    void getCharacter_returnsEmptyString_whenInputIsEmpty() {
        assertEquals("", StringHelper.getCharacter());
    }

    @Test
    void getCharacter_returnsString_whenInputIsNotEmpty() {
        assertEquals("A", StringHelper.getCharacter("U+0041"));
    }

    @Test
    void getCharacter_returnsString_whenInputContainsInvalidCodePoint() {
        assertEquals("A", StringHelper.getCharacter("U+0041", "invalid"));
    }

    @Test
    void getHexStringFromARGB_returnsDefault_whenValuesAreOutOfRange() {
        assertEquals("#FFFFFFFF", StringHelper.getHexStringFromARGB(256, 256, 256, 256));
    }

    @Test
    void getHexStringFromARGB_returnsARGBString_whenValuesAreInRange() {
        assertEquals("#FF0000FF", StringHelper.getHexStringFromARGB(255, 0, 0, 255));
    }

    @Test
    void hashcode_returnsNull_whenStringIsNull() {
        assertNull(StringHelper.hashcode(null));
    }

    @Test
    void hashcode_returnsNull_whenStringIsEmpty() {
        assertNull(StringHelper.hashcode(""));
    }

    @Test
    void hashcode_returnsHashCode_whenStringIsNotEmpty() {
        assertNotNull(StringHelper.hashcode("test"));
    }

    @Test
    void hashcode_returnsDifferentHashCodes_forDifferentStrings() {
        assertNotEquals(StringHelper.hashcode("test1"), StringHelper.hashcode("test2"));
    }

    @Test
    void hashcode_returnsSameHashCode_forSameStrings() {
        assertEquals(StringHelper.hashcode("test"), StringHelper.hashcode("test"));
    }

    @Test
    void md5_returnsMD5Hash_whenStringIsNotNull() {
        assertEquals("65a8e27d8879283831b664bd8b7f0ad4", StringHelper.md5("Hello, World!"));
    }

    @Test
    void md5_returnsEmptyString_whenStringIsNull() {
        assertNull(StringHelper.md5(null));
    }

    @Test
    void sha256_returnsSHA256Hash_whenStringIsNotNull() {
        assertEquals("dffd6021bb2bd5b0af676290809ec3a53191dd81c7f70a4b28688a362182986f", StringHelper.sha256("Hello, World!"));
    }

    @Test
    void sha256_returnsNull_whenStringIsNull() {
        assertNull(StringHelper.sha256(null));
    }

    @Test
    void sha512_returnsSHA512Hash_whenStringIsNotNull() {
        assertEquals("374d794a95cdcfd8b35993185fef9ba368f160d8daf432d08ba9f1ed1e5abe6cc69291e0fa2fe0006a52570ef18c19def4e617c33ce52ef0a6e5fbe318cb0387", StringHelper.sha512("Hello, World!"));
    }

    @Test
    void sha512_returnsNull_whenStringIsNull() {
        assertNull(StringHelper.sha512(null));
    }
}