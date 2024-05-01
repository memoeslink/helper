package org.memoeslink;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongHelperTest {

    @Test
    void isBetween_returnsTrue_whenNumberIsInRange() {
        assertTrue(LongHelper.isBetween(5L, 0L, 10L));
    }

    @Test
    void isBetween_returnsFalse_whenNumberIsOutOfRange() {
        assertFalse(LongHelper.isBetween(15L, 0L, 10L));
    }

    @Test
    void defaultIndex_returnsInitialIndex_whenIndexIsOutOfRange() {
        assertEquals(LongHelper.INITIAL_INDEX, LongHelper.defaultIndex(10L, 5L));
    }

    @Test
    void defaultIndex_returnsIndex_whenIndexIsInRange() {
        assertEquals(3L, LongHelper.defaultIndex(3L, 5L));
    }

    @Test
    void defaultByMin_returnsMin_whenNumberIsLessThanMin() {
        assertEquals(Long.MIN_VALUE, LongHelper.defaultByMin(Long.MIN_VALUE - 1, Long.MIN_VALUE));
    }

    @Test
    void defaultByMin_returnsNumber_whenNumberIsGreaterThanMin() {
        assertEquals(5L, LongHelper.defaultByMin(5L, 0L));
    }

    @Test
    void defaultByMax_returnsMax_whenNumberIsGreaterThanMax() {
        assertEquals(Long.MAX_VALUE, LongHelper.defaultByMax(Long.MAX_VALUE + 1, Long.MAX_VALUE));
    }

    @Test
    void defaultByMax_returnsNumber_whenNumberIsLessThanMax() {
        assertEquals(5L, LongHelper.defaultByMax(5L, 10L));
    }

    @Test
    void defaultByRange_returnsMin_whenNumberIsLessThanMin() {
        assertEquals(0L, LongHelper.defaultByRange(-1L, 0L, 10L));
    }

    @Test
    void defaultByRange_returnsMax_whenNumberIsGreaterThanMax() {
        assertEquals(10L, LongHelper.defaultByRange(15L, 0L, 10L));
    }

    @Test
    void defaultByRange_returnsNumber_whenNumberIsInRange() {
        assertEquals(5L, LongHelper.defaultByRange(5L, 0L, 10L));
    }

    @Test
    void isLong_returnsTrue_whenStringIsLong() {
        assertTrue(LongHelper.isLong("1234567890"));
    }

    @Test
    void isLong_returnsFalse_whenStringIsNotLong() {
        assertFalse(LongHelper.isLong("NotALong"));
    }

    @Test
    void tryParse_returnsParsedLong_whenStringIsLong() {
        assertEquals(1234567890L, LongHelper.tryParse("1234567890"));
    }

    @Test
    void tryParse_returnsZero_whenStringIsNotLong() {
        assertEquals(0L, LongHelper.tryParse("NotALong"));
    }

    @Test
    void tryParseWithDefault_returnsParsedLong_whenStringIsLong() {
        assertEquals(1234567890L, LongHelper.tryParse("1234567890", 1L));
    }

    @Test
    void tryParseWithDefault_returnsDefault_whenStringIsNotLong() {
        assertEquals(1L, LongHelper.tryParse("NotALong", 1L));
    }

    @Test
    void countDigits_returnsCorrectCount_whenNumberIsPositive() {
        assertEquals(10, LongHelper.countDigits(1234567890L));
    }

    @Test
    void countDigits_returnsCorrectCount_whenNumberIsNegative() {
        assertEquals(10, LongHelper.countDigits(-1234567890L));
    }

    @Test
    void countDigits_returnsOne_whenNumberIsZero() {
        assertEquals(1, LongHelper.countDigits(0L));
    }
}