package org.memoeslink;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerHelperTest {

    @Nested
    class IsBetween {

        @Test
        void withValueAtMinBoundary_returnsTrue() {
            assertTrue(IntegerHelper.isBetween(0, 0, 10));
        }

        @Test
        void withValueAtMaxBoundary_returnsTrue() {
            assertTrue(IntegerHelper.isBetween(10, 0, 10));
        }

        @Test
        void withValueInRange_returnsTrue() {
            assertTrue(IntegerHelper.isBetween(5, 0, 10));
        }

        @Test
        void withValueBelowMin_returnsFalse() {
            assertFalse(IntegerHelper.isBetween(-1, 0, 10));
        }

        @Test
        void withValueAboveMax_returnsFalse() {
            assertFalse(IntegerHelper.isBetween(11, 0, 10));
        }
    }

    @Nested
    class DefaultIndex {

        @Test
        void withValidIndex_returnsIndex() {
            assertEquals(2, IntegerHelper.defaultIndex(2, 5));
        }

        @Test
        void withIndexAtZero_returnsZero() {
            assertEquals(0, IntegerHelper.defaultIndex(0, 5));
        }

        @Test
        void withIndexAtLastPosition_returnsIndex() {
            assertEquals(4, IntegerHelper.defaultIndex(4, 5));
        }

        @Test
        void withNegativeIndex_returnsInitialIndex() {
            assertEquals(IntegerHelper.INITIAL_INDEX, IntegerHelper.defaultIndex(-1, 5));
        }

        @Test
        void withIndexEqualToLength_returnsInitialIndex() {
            assertEquals(IntegerHelper.INITIAL_INDEX, IntegerHelper.defaultIndex(5, 5));
        }

        @Test
        void withIndexAboveLength_returnsInitialIndex() {
            assertEquals(IntegerHelper.INITIAL_INDEX, IntegerHelper.defaultIndex(10, 5));
        }
    }

    @Nested
    class DefaultByMin {

        @Test
        void withValueAboveMin_returnsValue() {
            assertEquals(5, IntegerHelper.defaultByMin(5, 0));
        }

        @Test
        void withValueEqualToMin_returnsValue() {
            assertEquals(0, IntegerHelper.defaultByMin(0, 0));
        }

        @Test
        void withValueBelowMin_returnsMin() {
            assertEquals(0, IntegerHelper.defaultByMin(-1, 0));
        }

        @Test
        void withMinAsIntegerMinValue_returnsMin() {
            assertEquals(Integer.MIN_VALUE, IntegerHelper.defaultByMin(5, Integer.MIN_VALUE));
        }
    }

    @Nested
    class DefaultByMax {

        @Test
        void withValueBelowMax_returnsValue() {
            assertEquals(5, IntegerHelper.defaultByMax(5, 10));
        }

        @Test
        void withValueEqualToMax_returnsValue() {
            assertEquals(10, IntegerHelper.defaultByMax(10, 10));
        }

        @Test
        void withValueAboveMax_returnsMax() {
            assertEquals(10, IntegerHelper.defaultByMax(11, 10));
        }

        @Test
        void withMaxAsIntegerMaxValue_returnsMax() {
            assertEquals(Integer.MAX_VALUE, IntegerHelper.defaultByMax(5, Integer.MAX_VALUE));
        }
    }

    @Nested
    class DefaultByRange {

        @Test
        void withValueInRange_returnsValue() {
            assertEquals(5, IntegerHelper.defaultByRange(5, 0, 10));
        }

        @Test
        void withValueAtMinBoundary_returnsValue() {
            assertEquals(0, IntegerHelper.defaultByRange(0, 0, 10));
        }

        @Test
        void withValueAtMaxBoundary_returnsValue() {
            assertEquals(10, IntegerHelper.defaultByRange(10, 0, 10));
        }

        @Test
        void withValueBelowMin_returnsMin() {
            assertEquals(0, IntegerHelper.defaultByRange(-1, 0, 10));
        }

        @Test
        void withValueAboveMax_returnsMax() {
            assertEquals(10, IntegerHelper.defaultByRange(11, 0, 10));
        }

        @Test
        void withMinGreaterThanMax_returnsZero() {
            assertEquals(0, IntegerHelper.defaultByRange(5, 10, 0));
        }
    }

    @Nested
    class IsInteger {

        @Test
        void withValidInteger_returnsTrue() {
            assertTrue(IntegerHelper.isInteger("123"));
        }

        @Test
        void withNegativeInteger_returnsTrue() {
            assertTrue(IntegerHelper.isInteger("-123"));
        }

        @Test
        void withZero_returnsTrue() {
            assertTrue(IntegerHelper.isInteger("0"));
        }

        @Test
        void withDecimalNumber_returnsFalse() {
            assertFalse(IntegerHelper.isInteger("1.5"));
        }

        @Test
        void withLetters_returnsFalse() {
            assertFalse(IntegerHelper.isInteger("abc"));
        }

        @Test
        void withNull_returnsFalse() {
            assertFalse(IntegerHelper.isInteger(null));
        }

        @Test
        void withEmpty_returnsFalse() {
            assertFalse(IntegerHelper.isInteger(""));
        }

        @Test
        void withOverflowValue_returnsFalse() {
            assertFalse(IntegerHelper.isInteger("99999999999999"));
        }
    }

    @Nested
    class TryParse {

        @Test
        void withValidInteger_returnsParsedValue() {
            assertEquals(123, IntegerHelper.tryParse("123"));
        }

        @Test
        void withInvalidString_returnsZero() {
            assertEquals(0, IntegerHelper.tryParse("abc"));
        }

        @Test
        void withNull_returnsZero() {
            assertEquals(0, IntegerHelper.tryParse(null));
        }

        @Test
        void withValidIntegerAndCustomDefault_returnsParsedValue() {
            assertEquals(123, IntegerHelper.tryParse("123", -1));
        }

        @Test
        void withInvalidStringAndCustomDefault_returnsDefault() {
            assertEquals(-1, IntegerHelper.tryParse("abc", -1));
        }

        @Test
        void withNullAndCustomDefault_returnsDefault() {
            assertEquals(-1, IntegerHelper.tryParse(null, -1));
        }
    }

    @Nested
    class CountDigits {

        @Test
        void withSingleDigit_returnsOne() {
            assertEquals(1, IntegerHelper.countDigits(0));
        }

        @Test
        void withTwoDigits_returnsTwo() {
            assertEquals(2, IntegerHelper.countDigits(10));
        }

        @Test
        void withFiveDigits_returnsFive() {
            assertEquals(5, IntegerHelper.countDigits(12345));
        }

        @Test
        void withTenDigits_returnsTen() {
            assertEquals(10, IntegerHelper.countDigits(Integer.MAX_VALUE));
        }

        @Test
        void withNegativeNumber_returnsCorrectCount() {
            assertEquals(3, IntegerHelper.countDigits(-123));
        }
    }
}
