package org.memoeslink;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringHelperTest {

    @Nested
    class IsNullOrEmpty {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringHelper.isNullOrEmpty(null));
        }

        @Test
        void withEmptyString_returnsTrue() {
            assertTrue(StringHelper.isNullOrEmpty(""));
        }

        @Test
        void withBlankString_returnsFalse() {
            assertFalse(StringHelper.isNullOrEmpty(" "));
        }

        @Test
        void withNonEmptyString_returnsFalse() {
            assertFalse(StringHelper.isNullOrEmpty("hello"));
        }
    }

    @Nested
    class IsNotNullOrEmpty {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringHelper.isNotNullOrEmpty(null));
        }

        @Test
        void withEmptyString_returnsFalse() {
            assertFalse(StringHelper.isNotNullOrEmpty(""));
        }

        @Test
        void withNonEmptyString_returnsTrue() {
            assertTrue(StringHelper.isNotNullOrEmpty("hello"));
        }
    }

    @Nested
    class IsNullOrBlank {

        @Test
        void withNull_returnsTrue() {
            assertTrue(StringHelper.isNullOrBlank(null));
        }

        @Test
        void withEmptyString_returnsTrue() {
            assertTrue(StringHelper.isNullOrBlank(""));
        }

        @Test
        void withBlankString_returnsTrue() {
            assertTrue(StringHelper.isNullOrBlank("   "));
        }

        @Test
        void withNonBlankString_returnsFalse() {
            assertFalse(StringHelper.isNullOrBlank("hello"));
        }
    }

    @Nested
    class IsNotNullOrBlank {

        @Test
        void withNull_returnsFalse() {
            assertFalse(StringHelper.isNotNullOrBlank(null));
        }

        @Test
        void withBlankString_returnsFalse() {
            assertFalse(StringHelper.isNotNullOrBlank("   "));
        }

        @Test
        void withNonBlankString_returnsTrue() {
            assertTrue(StringHelper.isNotNullOrBlank("hello"));
        }
    }

    @Nested
    class IndexOf {

        @Test
        void withNullString_returnsIndexNotFound() {
            assertEquals(StringHelper.INDEX_NOT_FOUND, StringHelper.indexOf(null, 'a'));
        }

        @Test
        void withEmptyString_returnsIndexNotFound() {
            assertEquals(StringHelper.INDEX_NOT_FOUND, StringHelper.indexOf("", 'a'));
        }

        @Test
        void withPresentChar_returnsCorrectIndex() {
            assertEquals(1, StringHelper.indexOf("hello", 'e'));
        }

        @Test
        void withAbsentChar_returnsIndexNotFound() {
            assertEquals(StringHelper.INDEX_NOT_FOUND, StringHelper.indexOf("hello", 'z'));
        }

        @Test
        void withNullStringAndSubstring_returnsIndexNotFound() {
            assertEquals(StringHelper.INDEX_NOT_FOUND, StringHelper.indexOf(null, "el"));
        }

        @Test
        void withPresentSubstring_returnsCorrectIndex() {
            assertEquals(1, StringHelper.indexOf("hello", "el"));
        }

        @Test
        void withAbsentSubstring_returnsIndexNotFound() {
            assertEquals(StringHelper.INDEX_NOT_FOUND, StringHelper.indexOf("hello", "xyz"));
        }
    }

    @Nested
    class DefaultOnNull {

        @Test
        void withNull_returnsDefaultValue() {
            assertEquals(StringHelper.DEFAULT_VALUE, StringHelper.defaultOnNull(null));
        }

        @Test
        void withNonNull_returnsOriginal() {
            assertEquals("hello", StringHelper.defaultOnNull("hello"));
        }
    }

    @Nested
    class DefaultIfNull {

        @Test
        void withNull_returnsEmpty() {
            assertEquals("", StringHelper.defaultIfNull(null));
        }

        @Test
        void withNonNull_returnsOriginal() {
            assertEquals("hello", StringHelper.defaultIfNull("hello"));
        }

        @Test
        void withNullAndCustomDefault_returnsCustomDefault() {
            assertEquals("fallback", StringHelper.defaultIfNull(null, "fallback"));
        }

        @Test
        void withNullAndNullDefault_returnsEmpty() {
            assertEquals("", StringHelper.defaultIfNull(null, null));
        }
    }

    @Nested
    class DefaultOnEmpty {

        @Test
        void withEmpty_returnsDefaultValue() {
            assertEquals(StringHelper.DEFAULT_VALUE, StringHelper.defaultOnEmpty(""));
        }

        @Test
        void withNonEmpty_returnsOriginal() {
            assertEquals("hello", StringHelper.defaultOnEmpty("hello"));
        }
    }

    @Nested
    class DefaultIfEmpty {

        @Test
        void withNull_returnsCustomDefault() {
            assertEquals("fallback", StringHelper.defaultIfEmpty(null, "fallback"));
        }

        @Test
        void withEmpty_returnsCustomDefault() {
            assertEquals("fallback", StringHelper.defaultIfEmpty("", "fallback"));
        }

        @Test
        void withNonEmpty_returnsOriginal() {
            assertEquals("hello", StringHelper.defaultIfEmpty("hello", "fallback"));
        }
    }

    @Nested
    class DefaultIfBlank {

        @Test
        void withNull_returnsCustomDefault() {
            assertEquals("fallback", StringHelper.defaultIfBlank(null, "fallback"));
        }

        @Test
        void withBlank_returnsCustomDefault() {
            assertEquals("fallback", StringHelper.defaultIfBlank("   ", "fallback"));
        }

        @Test
        void withNonBlank_returnsOriginal() {
            assertEquals("hello", StringHelper.defaultIfBlank("hello", "fallback"));
        }
    }

    @Nested
    class GetFirstNonNull {

        @Test
        void withAllNull_returnsNull() {
            assertNull(StringHelper.getFirstNonNull(null, null));
        }

        @Test
        void withFirstNonNull_returnsFirst() {
            assertEquals("a", StringHelper.getFirstNonNull("a", "b"));
        }

        @Test
        void withFirstNullSecondNonNull_returnsSecond() {
            assertEquals("b", StringHelper.getFirstNonNull(null, "b"));
        }
    }

    @Nested
    class GetFirstNonEmpty {

        @Test
        void withAllEmpty_returnsNull() {
            assertNull(StringHelper.getFirstNonEmpty("", ""));
        }

        @Test
        void withFirstNonEmpty_returnsFirst() {
            assertEquals("a", StringHelper.getFirstNonEmpty("a", "b"));
        }

        @Test
        void withFirstEmptySecondNonEmpty_returnsSecond() {
            assertEquals("b", StringHelper.getFirstNonEmpty("", "b"));
        }
    }

    @Nested
    class GetFirstNonBlank {

        @Test
        void withAllBlank_returnsNull() {
            assertNull(StringHelper.getFirstNonBlank("  ", "  "));
        }

        @Test
        void withFirstBlankSecondNonBlank_returnsSecond() {
            assertEquals("b", StringHelper.getFirstNonBlank("  ", "b"));
        }
    }

    @Nested
    class PrependIfNotNull {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.prependIfNotNull(null, ">>"));
        }

        @Test
        void withNonNull_returnsPrepended() {
            assertEquals(">>hello", StringHelper.prependIfNotNull("hello", ">>"));
        }

        @Test
        void withNullPrefix_prependsEmpty() {
            assertEquals("hello", StringHelper.prependIfNotNull("hello", null));
        }
    }

    @Nested
    class PrependIfNotEmpty {

        @Test
        void withEmpty_returnsEmpty() {
            assertEquals("", StringHelper.prependIfNotEmpty("", ">>"));
        }

        @Test
        void withNonEmpty_returnsPrepended() {
            assertEquals(">>hello", StringHelper.prependIfNotEmpty("hello", ">>"));
        }
    }

    @Nested
    class PrependIfNotBlank {

        @Test
        void withBlank_returnsBlank() {
            String blank = "   ";
            assertEquals(blank, StringHelper.prependIfNotBlank(blank, ">>"));
        }

        @Test
        void withNonBlank_returnsPrepended() {
            assertEquals(">>hello", StringHelper.prependIfNotBlank("hello", ">>"));
        }
    }

    @Nested
    class PrependSpaceIfNotNull {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.prependSpaceIfNotNull(null));
        }

        @Test
        void withNonNull_returnsPrependedWithSpace() {
            assertEquals(" hello", StringHelper.prependSpaceIfNotNull("hello"));
        }
    }

    @Nested
    class PrependHyphenIfNotNull {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.prependHyphenIfNotNull(null));
        }

        @Test
        void withNonNull_returnsPrependedWithHyphen() {
            assertEquals("-hello", StringHelper.prependHyphenIfNotNull("hello"));
        }
    }

    @Nested
    class AppendIfNotNull {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.appendIfNotNull(null, "<<"));
        }

        @Test
        void withNonNull_returnsAppended() {
            assertEquals("hello<<", StringHelper.appendIfNotNull("hello", "<<"));
        }

        @Test
        void withNullSuffix_appendsEmpty() {
            assertEquals("hello", StringHelper.appendIfNotNull("hello", null));
        }
    }

    @Nested
    class AppendIfNotEmpty {

        @Test
        void withEmpty_returnsEmpty() {
            assertEquals("", StringHelper.appendIfNotEmpty("", "<<"));
        }

        @Test
        void withNonEmpty_returnsAppended() {
            assertEquals("hello<<", StringHelper.appendIfNotEmpty("hello", "<<"));
        }
    }

    @Nested
    class AppendIfNotBlank {

        @Test
        void withBlank_returnsBlank() {
            String blank = "   ";
            assertEquals(blank, StringHelper.appendIfNotBlank(blank, "<<"));
        }

        @Test
        void withNonBlank_returnsAppended() {
            assertEquals("hello<<", StringHelper.appendIfNotBlank("hello", "<<"));
        }
    }

    @Nested
    class AppendSpaceIfNotNull {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.appendSpaceIfNotNull(null));
        }

        @Test
        void withNonNull_returnsAppendedWithSpace() {
            assertEquals("hello ", StringHelper.appendSpaceIfNotNull("hello"));
        }
    }

    @Nested
    class AppendHyphenIfNotNull {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.appendHyphenIfNotNull(null));
        }

        @Test
        void withNonNull_returnsAppendedWithHyphen() {
            assertEquals("hello-", StringHelper.appendHyphenIfNotNull("hello"));
        }
    }

    @Nested
    class AffixIfNotNull {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.affixIfNotNull(null, "<<", ">>"));
        }

        @Test
        void withNonNull_returnsAffixed() {
            assertEquals("<<hello>>", StringHelper.affixIfNotNull("hello", "<<", ">>"));
        }
    }

    @Nested
    class AffixIfNotEmpty {

        @Test
        void withEmpty_returnsEmpty() {
            assertEquals("", StringHelper.affixIfNotEmpty("", "<<", ">>"));
        }

        @Test
        void withNonEmpty_returnsAffixed() {
            assertEquals("<<hello>>", StringHelper.affixIfNotEmpty("hello", "<<", ">>"));
        }
    }

    @Nested
    class AffixIfNotBlank {

        @Test
        void withBlank_returnsBlank() {
            String blank = "   ";
            assertEquals(blank, StringHelper.affixIfNotBlank(blank, "<<", ">>"));
        }

        @Test
        void withNonBlank_returnsAffixed() {
            assertEquals("<<hello>>", StringHelper.affixIfNotBlank("hello", "<<", ">>"));
        }
    }

    @Nested
    class Quote {

        @Test
        void withBlank_returnsBlank() {
            assertEquals("   ", StringHelper.quote("   "));
        }

        @Test
        void withNonBlank_returnsQuoted() {
            assertEquals("“hello”", StringHelper.quote("hello"));
        }
    }

    @Nested
    class PadLeft {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.padLeft(null, 5, '0'));
        }

        @Test
        void withStringShorterThanLength_returnsPadded() {
            assertEquals("000hi", StringHelper.padLeft("hi", 5, '0'));
        }

        @Test
        void withStringEqualToLength_returnsUnchanged() {
            assertEquals("hello", StringHelper.padLeft("hello", 5, '0'));
        }

        @Test
        void withStringLongerThanLength_returnsUnchanged() {
            assertEquals("hello!", StringHelper.padLeft("hello!", 3, '0'));
        }

        @Test
        void withNullPadChar_usesSpace() {
            assertEquals("   hi", StringHelper.padLeft("hi", 5, '\0'));
        }
    }

    @Nested
    class PadRight {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.padRight(null, 5, '0'));
        }

        @Test
        void withStringShorterThanLength_returnsPadded() {
            assertEquals("hi000", StringHelper.padRight("hi", 5, '0'));
        }

        @Test
        void withStringEqualToLength_returnsUnchanged() {
            assertEquals("hello", StringHelper.padRight("hello", 5, '0'));
        }

        @Test
        void withNullPadChar_usesSpace() {
            assertEquals("hi   ", StringHelper.padRight("hi", 5, '\0'));
        }
    }

    @Nested
    class Split {

        @Test
        void withNullString_returnsEmptyArray() {
            assertArrayEquals(new String[]{}, StringHelper.split(null, ","));
        }

        @Test
        void withNullRegex_returnsEmptyArray() {
            assertArrayEquals(new String[]{}, StringHelper.split("a,b", null));
        }

        @Test
        void withValidRegex_returnsParts() {
            assertArrayEquals(new String[]{"a", "b", "c"}, StringHelper.split("a,b,c", ","));
        }

        @Test
        void withNullStringAndCharDelimiter_returnsEmptyArray() {
            assertArrayEquals(new String[]{}, StringHelper.split(null, ','));
        }

        @Test
        void withCharDelimiter_returnsParts() {
            String[] result = StringHelper.split("a,b,c", ',');
            assertArrayEquals(new String[]{"a", "b", "c"}, result);
        }
    }

    @Nested
    class SplitBySpace {

        @Test
        void withSpaceSeparatedWords_returnsParts() {
            assertArrayEquals(new String[]{"hello", "world"}, StringHelper.splitBySpace("hello world"));
        }
    }

    @Nested
    class SplitByHyphen {

        @Test
        void withHyphenSeparatedWords_returnsParts() {
            assertArrayEquals(new String[]{"a", "b", "c"}, StringHelper.splitByHyphen("a-b-c"));
        }
    }

    @Nested
    class SplitByComma {

        @Test
        void withCommaSeparatedWords_returnsParts() {
            assertArrayEquals(new String[]{"a", "b", "c"}, StringHelper.splitByComma("a, b, c"));
        }
    }

    @Nested
    class Connect {

        @Test
        void withBothNull_returnsEmpty() {
            assertEquals("", StringHelper.connect(null, null));
        }

        @Test
        void withFirstNull_returnsSecond() {
            assertEquals("b", StringHelper.connect(null, "b"));
        }

        @Test
        void withBothNonNull_returnsConcatenated() {
            assertEquals("ab", StringHelper.connect("a", "b"));
        }
    }

    @Nested
    class Join {

        @Test
        void withNullArray_returnsNull() {
            assertNull(StringHelper.join(",", (String[]) null));
        }

        @Test
        void withNonNullStrings_returnsJoined() {
            assertEquals("a,b,c", StringHelper.join(",", "a", "b", "c"));
        }

        @Test
        void withEmptyStrings_skipsEmpties() {
            assertEquals("a,c", StringHelper.join(",", "a", "", "c"));
        }

        @Test
        void withNullSeparator_treatsAsEmpty() {
            assertEquals("abc", StringHelper.join(null, "a", "b", "c"));
        }
    }

    @Nested
    class JoinWithoutSeparator {

        @Test
        void withMultipleStrings_returnsConcatenated() {
            assertEquals("abc", StringHelper.joinWithoutSeparator("a", "b", "c"));
        }
    }

    @Nested
    class JoinWithSpace {

        @Test
        void withMultipleStrings_returnsSpaceJoined() {
            assertEquals("a b c", StringHelper.joinWithSpace("a", "b", "c"));
        }
    }

    @Nested
    class JoinWithHyphen {

        @Test
        void withMultipleStrings_returnsHyphenJoined() {
            assertEquals("a-b-c", StringHelper.joinWithHyphen("a", "b", "c"));
        }
    }

    @Nested
    class Weld {

        @Test
        void withNullFirst_returnsEmpty() {
            assertEquals("", StringHelper.weld(null, "world"));
        }

        @Test
        void withNullSecond_returnsEmpty() {
            assertEquals("", StringHelper.weld("hello", null));
        }

        @Test
        void withSameEndingAndStarting_removesDuplicate() {
            assertEquals("hello", StringHelper.weld("hell", "lo"));
        }

        @Test
        void withNonLetterBoundary_concatenates() {
            assertEquals("hello world", StringHelper.weld("hello ", "world"));
        }
    }

    @Nested
    class Repeat {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.repeat(null, 3));
        }

        @Test
        void withNegativeCount_returnsNull() {
            assertNull(StringHelper.repeat("ab", -1));
        }

        @Test
        void withZeroCount_returnsEmpty() {
            assertEquals("", StringHelper.repeat("ab", 0));
        }

        @Test
        void withPositiveCount_returnsRepeated() {
            assertEquals("ababab", StringHelper.repeat("ab", 3));
        }
    }

    @Nested
    class Trim {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.trim(null));
        }

        @Test
        void withPaddedString_returnsTrimmed() {
            assertEquals("hello", StringHelper.trim("  hello  "));
        }
    }

    @Nested
    class TrimToNull {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.trimToNull(null));
        }

        @Test
        void withBlank_returnsNull() {
            assertNull(StringHelper.trimToNull("   "));
        }

        @Test
        void withPaddedString_returnsTrimmed() {
            assertEquals("hello", StringHelper.trimToNull("  hello  "));
        }
    }

    @Nested
    class TrimToEmpty {

        @Test
        void withNull_returnsEmpty() {
            assertEquals("", StringHelper.trimToEmpty(null));
        }

        @Test
        void withPaddedString_returnsTrimmed() {
            assertEquals("hello", StringHelper.trimToEmpty("  hello  "));
        }
    }

    @Nested
    class Strip {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.strip(null));
        }

        @Test
        void withPaddedString_returnsStripped() {
            assertEquals("hello", StringHelper.strip("  hello  "));
        }
    }

    @Nested
    class StripToNull {

        @Test
        void withBlank_returnsNull() {
            assertNull(StringHelper.stripToNull("   "));
        }

        @Test
        void withPaddedString_returnsStripped() {
            assertEquals("hello", StringHelper.stripToNull("  hello  "));
        }
    }

    @Nested
    class StripToEmpty {

        @Test
        void withNull_returnsEmpty() {
            assertEquals("", StringHelper.stripToEmpty(null));
        }

        @Test
        void withPaddedString_returnsStripped() {
            assertEquals("hello", StringHelper.stripToEmpty("  hello  "));
        }
    }

    @Nested
    class StripStart {

        @Test
        void withLeadingWhitespace_removesLeading() {
            assertEquals("hello  ", StringHelper.stripStart("  hello  "));
        }

        @Test
        void withNoLeadingWhitespace_returnsUnchanged() {
            assertEquals("hello", StringHelper.stripStart("hello"));
        }
    }

    @Nested
    class StripEnd {

        @Test
        void withTrailingWhitespace_removesTrailing() {
            assertEquals("  hello", StringHelper.stripEnd("  hello  "));
        }

        @Test
        void withNoTrailingWhitespace_returnsUnchanged() {
            assertEquals("hello", StringHelper.stripEnd("hello"));
        }
    }

    @Nested
    class StripIndent {

        @Test
        void withBothSidesPadded_stripsAll() {
            assertEquals("hello", StringHelper.stripIndent("  hello  "));
        }
    }

    @Nested
    class Normalize {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.normalize(null));
        }

        @Test
        void withAccentedChars_stripsAccents() {
            assertEquals("hello", StringHelper.normalize("héllo"));
        }

        @Test
        void withPureAscii_returnsUnchanged() {
            assertEquals("hello", StringHelper.normalize("hello"));
        }
    }

    @Nested
    class NormalizeAlpha {

        @Test
        void withMixedContent_keepsOnlyAlpha() {
            assertEquals("hello", StringHelper.normalizeAlpha("héllo123!"));
        }
    }

    @Nested
    class NormalizeAlphanumeric {

        @Test
        void withMixedContent_keepsAlphanumeric() {
            assertEquals("hello123", StringHelper.normalizeAlphanumeric("héllo123!"));
        }
    }

    @Nested
    class StripAccents {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.stripAccents(null));
        }

        @Test
        void withAccentedChars_stripsAccents() {
            assertEquals("aeiou", StringHelper.stripAccents("áéíóú"));
        }

        @Test
        void withNoAccents_returnsUnchanged() {
            assertEquals("hello", StringHelper.stripAccents("hello"));
        }
    }

    @Nested
    class ToUppercase {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.toUppercase(null));
        }

        @Test
        void withLowercase_returnsUppercase() {
            assertEquals("HELLO", StringHelper.toUppercase("hello"));
        }
    }

    @Nested
    class ToLowercase {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.toLowercase(null));
        }

        @Test
        void withUppercase_returnsLowercase() {
            assertEquals("hello", StringHelper.toLowercase("HELLO"));
        }
    }

    @Nested
    class CapitalizeFirst {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.capitalizeFirst(null));
        }

        @Test
        void withLowercase_capitalizesFirstOnly() {
            assertEquals("Hello world", StringHelper.capitalizeFirst("hello world"));
        }

        @Test
        void withAllUppercase_lowercasesRestOfFirstWord() {
            assertEquals("Hello world", StringHelper.capitalizeFirst("HELLO WORLD"));
        }
    }

    @Nested
    class Capitalize {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.capitalize(null));
        }

        @Test
        void withMultipleWords_capitalizesEachWord() {
            assertEquals("Hello World", StringHelper.capitalize("hello world"));
        }
    }

    @Nested
    class CapitalizeStart {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.capitalizeStart(null));
        }

        @Test
        void withLowercaseFirst_capitalizesFirst() {
            assertEquals("Hello world", StringHelper.capitalizeStart("hello world"));
        }
    }

    @Nested
    class CapitalizeStarts {

        @Test
        void withMultipleWords_capitalizesEachStart() {
            assertEquals("Hello World", StringHelper.capitalizeStarts("hello world"));
        }
    }

    @Nested
    class SwapCase {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.swapCase(null));
        }

        @Test
        void withMixedCase_swapsAll() {
            assertEquals("hELLO", StringHelper.swapCase("Hello"));
        }
    }

    @Nested
    class RandomCase {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.randomCase(null, 42L));
        }

        @Test
        void withFixedSeed_returnsDeterministicResult() {
            String first = StringHelper.randomCase("hello world", 42L);
            String second = StringHelper.randomCase("hello world", 42L);
            assertEquals(first, second);
        }

        @Test
        void withFixedSeed_resultContainsOnlyLettersAndSpaces() {
            String result = StringHelper.randomCase("hello world", 42L);
            assertTrue(result.chars().allMatch(c -> Character.isLetter(c) || Character.isWhitespace(c)));
        }
    }

    @Nested
    class ToCamelCase {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.toCamelCase(null));
        }

        @Test
        void withSpaceSeparatedWords_returnsCamelCase() {
            assertEquals("helloWorld", StringHelper.toCamelCase("hello world"));
        }

        @Test
        void withHyphenSeparatedWords_returnsCamelCase() {
            assertEquals("helloWorld", StringHelper.toCamelCase("hello-world"));
        }
    }

    @Nested
    class ToPascalCase {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.toPascalCase(null));
        }

        @Test
        void withSpaceSeparatedWords_returnsPascalCase() {
            assertEquals("HelloWorld", StringHelper.toPascalCase("hello world"));
        }
    }

    @Nested
    class ConvertCase {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.convertCase(null, CaseStyle.SNAKE_CASE));
        }

        @Test
        void withNullCaseStyle_returnsOriginal() {
            assertEquals("hello world", StringHelper.convertCase("hello world", null));
        }

        @Test
        void withSnakeCase_returnsSnakeCase() {
            assertEquals("hello_world", StringHelper.convertCase("hello world", CaseStyle.SNAKE_CASE));
        }

        @Test
        void withKebabCase_returnsKebabCase() {
            assertEquals("hello-world", StringHelper.convertCase("hello world", CaseStyle.KEBAB_CASE));
        }

        @Test
        void withScreamingSnakeCase_returnsScreamingSnake() {
            assertEquals("HELLO_WORLD", StringHelper.convertCase("hello world", CaseStyle.SCREAMING_SNAKE_CASE));
        }

        @Test
        void withFlatCase_returnsFlatCase() {
            assertEquals("helloworld", StringHelper.convertCase("hello world", CaseStyle.FLAT_CASE));
        }

        @Test
        void withUpperFlatCase_returnsUpperFlatCase() {
            assertEquals("HELLOWORLD", StringHelper.convertCase("hello world", CaseStyle.UPPER_FLAT_CASE));
        }

        @Test
        void withTrainCase_returnsTrainCase() {
            assertEquals("Hello-World", StringHelper.convertCase("hello world", CaseStyle.TRAIN_CASE));
        }

        @Test
        void withCobolCase_returnsCobolCase() {
            assertEquals("HELLO-WORLD", StringHelper.convertCase("hello world", CaseStyle.COBOL_CASE));
        }

        @Test
        void withPascalSnakeCase_returnsPascalSnakeCase() {
            assertEquals("Hello_World", StringHelper.convertCase("hello world", CaseStyle.PASCAL_SNAKE_CASE));
        }

        @Test
        void withCamelSnakeCase_returnsCamelSnakeCase() {
            assertEquals("hello_World", StringHelper.convertCase("hello world", CaseStyle.CAMEL_SNAKE_CASE));
        }
    }

    @Nested
    class Reverse {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.reverse(null));
        }

        @Test
        void withString_returnsReversed() {
            assertEquals("olleh", StringHelper.reverse("hello"));
        }

        @Test
        void withSingleChar_returnsSame() {
            assertEquals("a", StringHelper.reverse("a"));
        }
    }

    @Nested
    class Mask {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.mask(null));
        }

        @Test
        void withString_masksNonSpaceChars() {
            assertEquals("***** *****", StringHelper.mask("hello world"));
        }

        @Test
        void withCustomReplacement_usesCustomChar() {
            assertEquals("##### #####", StringHelper.mask("hello world", '#'));
        }

        @Test
        void withValidRange_masksRange() {
            assertEquals("he***!", StringHelper.mask("hello!", '*', 2, 4));
        }

        @Test
        void withInvalidRange_returnsOriginal() {
            assertEquals("hello", StringHelper.mask("hello", '*', 4, 2));
        }
    }

    @Nested
    class MaskStart {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.maskStart(null));
        }

        @Test
        void withLongString_masksAllButLastFour() {
            assertEquals("******orld", StringHelper.maskStart("helloworld"));
        }

        @Test
        void withShortString_masksAll() {
            assertEquals("***", StringHelper.maskStart("hi!"));
        }

        @Test
        void withCustomUnmaskedCount_leavesCountUnmasked() {
            assertEquals("***lo", StringHelper.maskStart("hello", '*', 2));
        }
    }

    @Nested
    class MaskEnd {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.maskEnd(null));
        }

        @Test
        void withLongString_masksAllAfterFour() {
            assertEquals("hell******", StringHelper.maskEnd("helloworld"));
        }

        @Test
        void withCustomUnmaskedCount_leavesCountUnmasked() {
            assertEquals("hel**", StringHelper.maskEnd("hello", '*', 3));
        }
    }

    @Nested
    class MaskMiddle {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.maskMiddle(null));
        }

        @Test
        void withShortString_masksAll() {
            assertEquals("****", StringHelper.maskMiddle("hi!!"));
        }

        @Test
        void withCustomMaskedCount_masksMiddle() {
            assertEquals("he*lo", StringHelper.maskMiddle("hello", '*', 1));
        }
    }

    @Nested
    class Shuffle {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.shuffle(null, 42L));
        }

        @Test
        void withFixedSeed_returnsDeterministicResult() {
            String first = StringHelper.shuffle("hello", 42L);
            String second = StringHelper.shuffle("hello", 42L);
            assertEquals(first, second);
        }

        @Test
        void withFixedSeed_containsSameChars() {
            String original = "hello";
            String shuffled = StringHelper.shuffle(original, 42L);
            assertEquals(original.length(), shuffled.length());
            for (char c : original.toCharArray()) {
                assertTrue(shuffled.contains(String.valueOf(c)));
            }
        }
    }

    @Nested
    class Substring {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.substring(null, 0, 3));
        }

        @Test
        void withValidRange_returnsSubstring() {
            assertEquals("ell", StringHelper.substring("hello", 1, 4));
        }

        @Test
        void withNegativeStart_offsetsFromEnd() {
            assertEquals("lo", StringHelper.substring("hello", -2, 5));
        }
    }

    @Nested
    class SubstringBefore {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.substringBefore(null, "."));
        }

        @Test
        void withPresentSeparator_returnsBeforeSeparator() {
            assertEquals("hello", StringHelper.substringBefore("hello.world", "."));
        }

        @Test
        void withAbsentSeparator_returnsOriginal() {
            assertEquals("hello", StringHelper.substringBefore("hello", "."));
        }

        @Test
        void withEmptySeparator_returnsEmpty() {
            assertEquals("", StringHelper.substringBefore("hello", ""));
        }
    }

    @Nested
    class SubstringBetween {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.substringBetween(null, "[", "]"));
        }

        @Test
        void withPresentDelimiters_returnsContentBetween() {
            assertEquals("world", StringHelper.substringBetween("[world]", "[", "]"));
        }

        @Test
        void withAbsentDelimiters_returnsNull() {
            assertNull(StringHelper.substringBetween("hello", "[", "]"));
        }
    }

    @Nested
    class SubstringAfter {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.substringAfter(null, "."));
        }

        @Test
        void withPresentSeparator_returnsAfterSeparator() {
            assertEquals("world", StringHelper.substringAfter("hello.world", "."));
        }

        @Test
        void withAbsentSeparator_returnsEmpty() {
            assertEquals("", StringHelper.substringAfter("hello", "."));
        }
    }

    @Nested
    class Replace {

        @Test
        void withNullString_returnsNull() {
            assertNull(StringHelper.replace(null, "a", "b"));
        }

        @Test
        void withPresentOccurrence_replacesAll() {
            assertEquals("hxllx", StringHelper.replace("hello", 'e', 'x').replace('o', 'x'));
        }

        @Test
        void withSubstringOccurrence_replacesAll() {
            assertEquals("hXXo", StringHelper.replace("hello", "ell", "XX"));
        }
    }

    @Nested
    class ReplaceByIndex {

        @Test
        void withValidRange_replacesRange() {
            assertEquals("hXXXo", StringHelper.replaceByIndex("hello", 1, 4, "XXX"));
        }

        @Test
        void withInvalidRange_returnsOriginal() {
            assertEquals("hello", StringHelper.replaceByIndex("hello", 4, 1, "X"));
        }
    }

    @Nested
    class ReplaceFirstChar {

        @Test
        void withNonEmpty_replacesFirstChar() {
            assertEquals("Xello", StringHelper.replaceFirstChar("hello", "X"));
        }

        @Test
        void withEmpty_returnsEmpty() {
            assertEquals("", StringHelper.replaceFirstChar("", "X"));
        }
    }

    @Nested
    class ReplaceLastChar {

        @Test
        void withNonEmpty_replacesLastChar() {
            assertEquals("hellX", StringHelper.replaceLastChar("hello", "X"));
        }
    }

    @Nested
    class ReplaceOnce {

        @Test
        void withPresentOccurrence_replacesFirstOnly() {
            assertEquals("Xello hello", StringHelper.replaceOnce("hello hello", "h", "X"));
        }
    }

    @Nested
    class ReplaceFinal {

        @Test
        void withPresentOccurrence_replacesLastOnly() {
            assertEquals("hello Xello", StringHelper.replaceFinal("hello hello", "h", "X"));
        }
    }

    @Nested
    class ReplaceAll {

        @Test
        void withRegexPattern_replacesAllMatches() {
            assertEquals("X X X", StringHelper.replaceAll("a b c", "[a-c]", "X"));
        }
    }

    @Nested
    class ReplaceStart {

        @Test
        void withMatchingPrefix_replacesStart() {
            assertEquals("Xello", StringHelper.replaceStart("hello", "h", "X"));
        }

        @Test
        void withNonMatchingPrefix_returnsOriginal() {
            assertEquals("hello", StringHelper.replaceStart("hello", "z", "X"));
        }
    }

    @Nested
    class ReplaceEnd {

        @Test
        void withMatchingSuffix_replacesEnd() {
            assertEquals("hellX", StringHelper.replaceEnd("hello", "o", "X"));
        }

        @Test
        void withNonMatchingSuffix_returnsOriginal() {
            assertEquals("hello", StringHelper.replaceEnd("hello", "z", "X"));
        }
    }

    @Nested
    class ReplaceBetweenDelimiters {

        @Test
        void withMatchingDelimiters_replacesContent() {
            assertEquals("(X)", StringHelper.replaceBetweenDelimiters("(hello)", '(', ')', "X"));
        }
    }

    @Nested
    class ReplaceWithinDelimiters {

        @Test
        void withMatchingDelimiters_replacesIncludingDelimiters() {
            assertEquals("X", StringHelper.replaceWithinDelimiters("(hello)", '(', ')', "X"));
        }
    }

    @Nested
    class Remove {

        @Test
        void withPresentChar_removesAll() {
            assertEquals("hllo", StringHelper.remove("hello", 'e'));
        }

        @Test
        void withPresentSubstring_removesAll() {
            assertEquals("ho", StringHelper.remove("hello", "ell"));
        }
    }

    @Nested
    class RemoveByIndex {

        @Test
        void withValidRange_removesRange() {
            assertEquals("ho", StringHelper.removeByIndex("hello", 1, 4));
        }
    }

    @Nested
    class RemoveEach {

        @Test
        void withMultipleOccurrences_removesAll() {
            assertEquals("hll", StringHelper.removeEach("hello", "e", "o"));
        }
    }

    @Nested
    class RemoveAll {

        @Test
        void withRegexPattern_removesAllMatches() {
            assertEquals("hll wrld", StringHelper.removeAll("hello world", "[aeiou]"));
        }
    }

    @Nested
    class RemoveFirstChar {

        @Test
        void withNonEmpty_removesFirstChar() {
            assertEquals("ello", StringHelper.removeFirstChar("hello"));
        }

        @Test
        void withEmpty_returnsEmpty() {
            assertEquals("", StringHelper.removeFirstChar(""));
        }
    }

    @Nested
    class RemoveLastChar {

        @Test
        void withNonEmpty_removesLastChar() {
            assertEquals("hell", StringHelper.removeLastChar("hello"));
        }
    }

    @Nested
    class RemoveStart {

        @Test
        void withMatchingPrefix_removesStart() {
            assertEquals("ello", StringHelper.removeStart("hello", "h"));
        }

        @Test
        void withNonMatchingPrefix_returnsOriginal() {
            assertEquals("hello", StringHelper.removeStart("hello", "z"));
        }
    }

    @Nested
    class RemoveEnd {

        @Test
        void withMatchingSuffix_removesEnd() {
            assertEquals("hell", StringHelper.removeEnd("hello", "o"));
        }

        @Test
        void withNonMatchingSuffix_returnsOriginal() {
            assertEquals("hello", StringHelper.removeEnd("hello", "z"));
        }
    }

    @Nested
    class RemoveBetweenParentheses {

        @Test
        void withParenthesizedContent_removesContent() {
            assertEquals("()", StringHelper.removeBetweenParentheses("(hello)"));
        }
    }

    @Nested
    class RemoveWithinParentheses {

        @Test
        void withParenthesizedContent_removesAllIncludingParens() {
            assertEquals("", StringHelper.removeWithinParentheses("(hello)"));
        }
    }

    @Nested
    class GetFirstChar {

        @Test
        void withNonEmpty_returnsFirstChar() {
            assertEquals('h', StringHelper.getFirstChar("hello"));
        }

        @Test
        void withNull_returnsNullChar() {
            assertEquals(CharHelper.NULL_CHAR, StringHelper.getFirstChar(null));
        }
    }

    @Nested
    class GetLastChar {

        @Test
        void withNonEmpty_returnsLastChar() {
            assertEquals('o', StringHelper.getLastChar("hello"));
        }

        @Test
        void withNull_returnsNullChar() {
            assertEquals(CharHelper.NULL_CHAR, StringHelper.getLastChar(null));
        }
    }

    @Nested
    class GetStart {

        @Test
        void withNonEmpty_returnsFirstCharAsString() {
            assertEquals("h", StringHelper.getStart("hello"));
        }

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.getStart(null));
        }
    }

    @Nested
    class GetEnd {

        @Test
        void withNonEmpty_returnsLastCharAsString() {
            assertEquals("o", StringHelper.getEnd("hello"));
        }

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.getEnd(null));
        }
    }

    @Nested
    class Left {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.left(null, 3));
        }

        @Test
        void withNInRange_returnsLeftN() {
            assertEquals("hel", StringHelper.left("hello", 3));
        }

        @Test
        void withNGreaterThanLength_returnsEntireString() {
            assertEquals("hello", StringHelper.left("hello", 10));
        }

        @Test
        void withNegativeN_returnsOriginal() {
            assertEquals("hello", StringHelper.left("hello", -1));
        }
    }

    @Nested
    class Right {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.right(null, 3));
        }

        @Test
        void withNInRange_returnsRightN() {
            assertEquals("llo", StringHelper.right("hello", 3));
        }

        @Test
        void withNGreaterThanLength_returnsEntireString() {
            assertEquals("hello", StringHelper.right("hello", 10));
        }
    }

    @Nested
    class SubstringBeforeLast {

        @Test
        void withPresentSeparator_returnsBeforeLast() {
            assertEquals("a.b", StringHelper.substringBeforeLast("a.b.c", "."));
        }

        @Test
        void withAbsentSeparator_returnsOriginal() {
            assertEquals("hello", StringHelper.substringBeforeLast("hello", "."));
        }
    }

    @Nested
    class SubstringAfterLast {

        @Test
        void withPresentSeparator_returnsAfterLast() {
            assertEquals("c", StringHelper.substringAfterLast("a.b.c", "."));
        }

        @Test
        void withAbsentSeparator_returnsOriginal() {
            assertEquals("hello", StringHelper.substringAfterLast("hello", "."));
        }
    }

    @Nested
    class Equals {

        @Test
        void withBothNull_returnsTrue() {
            assertTrue(StringHelper.equals(null, null));
        }

        @Test
        void withOneNull_returnsFalse() {
            assertFalse(StringHelper.equals(null, "a"));
        }

        @Test
        void withEqualStrings_returnsTrue() {
            assertTrue(StringHelper.equals("hello", "hello"));
        }

        @Test
        void withDifferentStrings_returnsFalse() {
            assertFalse(StringHelper.equals("hello", "world"));
        }
    }

    @Nested
    class EqualsIgnoreCase {

        @Test
        void withSameStringDifferentCase_returnsTrue() {
            assertTrue(StringHelper.equalsIgnoreCase("HELLO", "hello"));
        }

        @Test
        void withDifferentStrings_returnsFalse() {
            assertFalse(StringHelper.equalsIgnoreCase("hello", "world"));
        }
    }

    @Nested
    class EqualsAny {

        @Test
        void withMatchingOccurrence_returnsTrue() {
            assertTrue(StringHelper.equalsAny("b", "a", "b", "c"));
        }

        @Test
        void withNoMatchingOccurrence_returnsFalse() {
            assertFalse(StringHelper.equalsAny("z", "a", "b", "c"));
        }
    }

    @Nested
    class StartsWith {

        @Test
        void withMatchingPrefix_returnsTrue() {
            assertTrue(StringHelper.startsWith("hello", "hel"));
        }

        @Test
        void withNonMatchingPrefix_returnsFalse() {
            assertFalse(StringHelper.startsWith("hello", "world"));
        }

        @Test
        void withMatchingChar_returnsTrue() {
            assertTrue(StringHelper.startsWith("hello", 'h'));
        }

        @Test
        void withNonMatchingChar_returnsFalse() {
            assertFalse(StringHelper.startsWith("hello", 'z'));
        }
    }

    @Nested
    class StartsWithAny {

        @Test
        void withOneMatchingPrefix_returnsTrue() {
            assertTrue(StringHelper.startsWithAny("hello", "world", "hel"));
        }

        @Test
        void withNoMatchingPrefix_returnsFalse() {
            assertFalse(StringHelper.startsWithAny("hello", "foo", "bar"));
        }
    }

    @Nested
    class EndsWith {

        @Test
        void withMatchingSuffix_returnsTrue() {
            assertTrue(StringHelper.endsWith("hello", "llo"));
        }

        @Test
        void withNonMatchingSuffix_returnsFalse() {
            assertFalse(StringHelper.endsWith("hello", "world"));
        }

        @Test
        void withMatchingChar_returnsTrue() {
            assertTrue(StringHelper.endsWith("hello", 'o'));
        }

        @Test
        void withNonMatchingChar_returnsFalse() {
            assertFalse(StringHelper.endsWith("hello", 'z'));
        }
    }

    @Nested
    class EndsWithAny {

        @Test
        void withOneMatchingSuffix_returnsTrue() {
            assertTrue(StringHelper.endsWithAny("hello", "foo", "llo"));
        }

        @Test
        void withNoMatchingSuffix_returnsFalse() {
            assertFalse(StringHelper.endsWithAny("hello", "foo", "bar"));
        }
    }

    @Nested
    class Has {

        @Test
        void withPresentChar_returnsTrue() {
            assertTrue(StringHelper.has("hello", 'e'));
        }

        @Test
        void withAbsentChar_returnsFalse() {
            assertFalse(StringHelper.has("hello", 'z'));
        }

        @Test
        void withPresentSubstring_returnsTrue() {
            assertTrue(StringHelper.has("hello", "ell"));
        }

        @Test
        void withAbsentSubstring_returnsFalse() {
            assertFalse(StringHelper.has("hello", "xyz"));
        }
    }

    @Nested
    class HasAny {

        @Test
        void withOneMatchingChar_returnsTrue() {
            assertTrue(StringHelper.hasAny("hello", 'z', 'e'));
        }

        @Test
        void withNoMatchingChar_returnsFalse() {
            assertFalse(StringHelper.hasAny("hello", 'x', 'y', 'z'));
        }

        @Test
        void withOneMatchingAffix_returnsTrue() {
            assertTrue(StringHelper.hasAny("hello", "xyz", "ell"));
        }

        @Test
        void withNoMatchingAffix_returnsFalse() {
            assertFalse(StringHelper.hasAny("hello", "foo", "bar"));
        }
    }

    @Nested
    class Hashcode {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.hashcode(null));
        }

        @Test
        void withSameString_returnsSameHash() {
            assertEquals(StringHelper.hashcode("hello"), StringHelper.hashcode("hello"));
        }

        @Test
        void withDifferentStrings_returnsDifferentHashes() {
            assertNotEquals(StringHelper.hashcode("hello"), StringHelper.hashcode("world"));
        }
    }

    @Nested
    class Md5 {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.md5(null));
        }

        @Test
        void withKnownInput_returnsExpectedHash() {
            assertEquals("5d41402abc4b2a76b9719d911017c592", StringHelper.md5("hello"));
        }
    }

    @Nested
    class Sha256 {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.sha256(null));
        }

        @Test
        void withKnownInput_returnsExpectedHash() {
            assertEquals(
                    "2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824",
                    StringHelper.sha256("hello")
            );
        }
    }

    @Nested
    class GetUnicode {

        @Test
        void withNullChar_returnsNull() {
            assertNull(StringHelper.getUnicode('\0'));
        }

        @Test
        void withChar_returnsUnicodeRepresentation() {
            assertEquals("\\u0041", StringHelper.getUnicode('A'));
        }
    }

    @Nested
    class EscapeJavaString {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.escapeJavaString(null));
        }

        @Test
        void withNewline_escapesNewline() {
            assertEquals("\\n", StringHelper.escapeJavaString("\n"));
        }

        @Test
        void withTab_escapesTab() {
            assertEquals("\\t", StringHelper.escapeJavaString("\t"));
        }

        @Test
        void withBackslash_escapesBackslash() {
            assertEquals("\\\\", StringHelper.escapeJavaString("\\"));
        }
    }

    @Nested
    class UnescapeJavaString {

        @Test
        void withNull_returnsNull() {
            assertNull(StringHelper.unescapeJavaString(null));
        }

        @Test
        void withEscapedNewline_returnsNewline() {
            assertEquals("\n", StringHelper.unescapeJavaString("\\n"));
        }

        @Test
        void withEscapedTab_returnsTab() {
            assertEquals("\t", StringHelper.unescapeJavaString("\\t"));
        }

        @Test
        void withEscapedBackslash_returnsBackslash() {
            assertEquals("\\", StringHelper.unescapeJavaString("\\\\"));
        }
    }

    @Nested
    class ReplaceTags {

        @Test
        void withNullString_returnsNull() {
            assertNull(StringHelper.replaceTags(null, java.util.Map.of("name", "world")));
        }

        @Test
        void withNullMap_returnsOriginal() {
            assertEquals("hello ${name}", StringHelper.replaceTags("hello ${name}", null));
        }

        @Test
        void withValidTag_replacesTag() {
            assertEquals("hello world", StringHelper.replaceTags("hello ${name}", java.util.Map.of("name", "world")));
        }
    }
}
