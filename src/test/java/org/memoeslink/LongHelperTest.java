package org.memoeslink;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongHelperTest {

    @Nested
    class IsBetween {

        @Test
        void withValueAtMinBoundary_returnsTrue() {
            assertTrue(LongHelper.isBetween(0L, 0L, 10L));
        }

        @Test
        void withValueAtMaxBoundary_returnsTrue() {
            assertTrue(LongHelper.isBetween(10L, 0L, 10L));
        }

        @Test
        void withValueInRange_returnsTrue() {
            assertTrue(LongHelper.isBetween(5L, 0L, 10L));
        }

        @Test
        void withValueBelowMin_returnsFalse() {
            assertFalse(LongHelper.isBetween(-1L, 0L, 10L));
        }

        @Test
        void withValueAboveMax_returnsFalse() {
            assertFalse(LongHelper.isBetween(11L, 0L, 10L));
        }
    }

    @Nested
    class DefaultIndex {

        @Test
        void withValidIndex_returnsIndex() {
            assertEquals(2L, LongHelper.defaultIndex(2L, 5L));
        }

        @Test
        void withIndexAtZero_returnsZero() {
            assertEquals(0L, LongHelper.defaultIndex(0L, 5L));
        }

        @Test
        void withIndexAtLastPosition_returnsIndex() {
            assertEquals(4L, LongHelper.defaultIndex(4L, 5L));
        }

        @Test
        void withNegativeIndex_returnsInitialIndex() {
            assertEquals(LongHelper.INITIAL_INDEX, LongHelper.defaultIndex(-1L, 5L));
        }

        @Test
        void withIndexEqualToLength_returnsInitialIndex() {
            assertEquals(LongHelper.INITIAL_INDEX, LongHelper.defaultIndex(5L, 5L));
        }

        @Test
        void withIndexAboveLength_returnsInitialIndex() {
            assertEquals(LongHelper.INITIAL_INDEX, LongHelper.defaultIndex(10L, 5L));
        }
    }

    @Nested
    class DefaultByMin {

        @Test
        void withValueAboveMin_returnsValue() {
            assertEquals(5L, LongHelper.defaultByMin(5L, 0L));
        }

        @Test
        void withValueEqualToMin_returnsValue() {
            assertEquals(0L, LongHelper.defaultByMin(0L, 0L));
        }

        @Test
        void withValueBelowMin_returnsMin() {
            assertEquals(0L, LongHelper.defaultByMin(-1L, 0L));
        }

        @Test
        void withMinAsLongMinValue_returnsMin() {
            assertEquals(Long.MIN_VALUE, LongHelper.defaultByMin(5L, Long.MIN_VALUE));
        }
    }

    @Nested
    class DefaultByMax {

        @Test
        void withValueBelowMax_returnsValue() {
            assertEquals(5L, LongHelper.defaultByMax(5L, 10L));
        }

        @Test
        void withValueEqualToMax_returnsValue() {
            assertEquals(10L, LongHelper.defaultByMax(10L, 10L));
        }

        @Test
        void withValueAboveMax_returnsMax() {
            assertEquals(10L, LongHelper.defaultByMax(11L, 10L));
        }

        @Test
        void withMaxAsLongMaxValue_returnsMax() {
            assertEquals(Long.MAX_VALUE, LongHelper.defaultByMax(5L, Long.MAX_VALUE));
        }
    }

    @Nested
    class DefaultByRange {

        @Test
        void withValueInRange_returnsValue() {
            assertEquals(5L, LongHelper.defaultByRange(5L, 0L, 10L));
        }

        @Test
        void withValueAtMinBoundary_returnsValue() {
            assertEquals(0L, LongHelper.defaultByRange(0L, 0L, 10L));
        }

        @Test
        void withValueAtMaxBoundary_returnsValue() {
            assertEquals(10L, LongHelper.defaultByRange(10L, 0L, 10L));
        }

        @Test
        void withValueBelowMin_returnsMin() {
            assertEquals(0L, LongHelper.defaultByRange(-1L, 0L, 10L));
        }

        @Test
        void withValueAboveMax_returnsMax() {
            assertEquals(10L, LongHelper.defaultByRange(11L, 0L, 10L));
        }

        @Test
        void withMinGreaterThanMax_returnsZero() {
            assertEquals(0L, LongHelper.defaultByRange(5L, 10L, 0L));
        }
    }

    @Nested
    class IsLong {

        @Test
        void withValidLong_returnsTrue() {
            assertTrue(LongHelper.isLong("123"));
        }

        @Test
        void withNegativeLong_returnsTrue() {
            assertTrue(LongHelper.isLong("-123"));
        }

        @Test
        void withZero_returnsTrue() {
            assertTrue(LongHelper.isLong("0"));
        }

        @Test
        void withLongMaxValue_returnsTrue() {
            assertTrue(LongHelper.isLong(String.valueOf(Long.MAX_VALUE)));
        }

        @Test
        void withLongMinValue_returnsTrue() {
            assertTrue(LongHelper.isLong(String.valueOf(Long.MIN_VALUE)));
        }

        @Test
        void withDecimalNumber_returnsFalse() {
            assertFalse(LongHelper.isLong("1.5"));
        }

        @Test
        void withLetters_returnsFalse() {
            assertFalse(LongHelper.isLong("abc"));
        }

        @Test
        void withNull_returnsFalse() {
            assertFalse(LongHelper.isLong(null));
        }

        @Test
        void withEmpty_returnsFalse() {
            assertFalse(LongHelper.isLong(""));
        }

        @Test
        void withOverflowValue_returnsFalse() {
            assertFalse(LongHelper.isLong("99999999999999999999999"));
        }
    }

    @Nested
    class TryParse {

        @Test
        void withValidLong_returnsParsedValue() {
            assertEquals(123L, LongHelper.tryParse("123"));
        }

        @Test
        void withInvalidString_returnsZero() {
            assertEquals(0L, LongHelper.tryParse("abc"));
        }

        @Test
        void withNull_returnsZero() {
            assertEquals(0L, LongHelper.tryParse(null));
        }

        @Test
        void withValidLongAndCustomDefault_returnsParsedValue() {
            assertEquals(123L, LongHelper.tryParse("123", -1L));
        }

        @Test
        void withInvalidStringAndCustomDefault_returnsDefault() {
            assertEquals(-1L, LongHelper.tryParse("abc", -1L));
        }

        @Test
        void withNullAndCustomDefault_returnsDefault() {
            assertEquals(-1L, LongHelper.tryParse(null, -1L));
        }
    }
}
