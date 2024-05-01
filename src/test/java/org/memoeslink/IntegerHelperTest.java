package org.memoeslink;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerHelperTest {

    @Test
    void isBetween_returnsTrue_whenNumberIsWithinRange() {
        assertTrue(IntegerHelper.isBetween(5, 1, 10));
    }

    @Test
    void isBetween_returnsFalse_whenNumberIsOutsideRange() {
        assertFalse(IntegerHelper.isBetween(11, 1, 10));
    }

    @Test
    void defaultIndex_returnsInitialIndex_whenIndexIsInvalid() {
        assertEquals(IntegerHelper.INITIAL_INDEX, IntegerHelper.defaultIndex(-1, 10));
    }

    @Test
    void defaultIndex_returnsIndex_whenIndexIsValid() {
        assertEquals(5, IntegerHelper.defaultIndex(5, 10));
    }

    @Test
    void defaultByMin_returnsMin_whenNumberIsLessThanMin() {
        assertEquals(1, IntegerHelper.defaultByMin(0, 1));
    }

    @Test
    void defaultByMin_returnsNumber_whenNumberIsGreaterThanMin() {
        assertEquals(2, IntegerHelper.defaultByMin(2, 1));
    }

    @Test
    void defaultByMax_returnsMax_whenNumberIsGreaterThanMax() {
        assertEquals(10, IntegerHelper.defaultByMax(11, 10));
    }

    @Test
    void defaultByMax_returnsNumber_whenNumberIsLessThanMax() {
        assertEquals(9, IntegerHelper.defaultByMax(9, 10));
    }

    @Test
    void defaultByRange_returnsMin_whenNumberIsLessThanMin() {
        assertEquals(1, IntegerHelper.defaultByRange(0, 1, 10));
    }

    @Test
    void defaultByRange_returnsMax_whenNumberIsGreaterThanMax() {
        assertEquals(10, IntegerHelper.defaultByRange(11, 1, 10));
    }

    @Test
    void defaultByRange_returnsNumber_whenNumberIsWithinRange() {
        assertEquals(5, IntegerHelper.defaultByRange(5, 1, 10));
    }

    @Test
    void isInteger_returnsTrue_whenStringIsInteger() {
        assertTrue(IntegerHelper.isInteger("123"));
    }

    @Test
    void isInteger_returnsFalse_whenStringIsNotInteger() {
        assertFalse(IntegerHelper.isInteger("abc"));
    }

    @Test
    void tryParse_returnsDefaultValue_whenStringIsNotInteger() {
        assertEquals(0, IntegerHelper.tryParse("abc", 0));
    }

    @Test
    void tryParse_returnsParsedInteger_whenStringIsInteger() {
        assertEquals(123, IntegerHelper.tryParse("123", 0));
    }

    @Test
    void tryParseWithDefaultZero_returnsZero_whenStringIsNotInteger() {
        assertEquals(0, IntegerHelper.tryParse("abc"));
    }

    @Test
    void tryParseWithDefaultZero_returnsParsedInteger_whenStringIsInteger() {
        assertEquals(123, IntegerHelper.tryParse("123"));
    }

    @Test
    void countDigits_returnsCorrectCount_whenNumberIsPositive() {
        assertEquals(3, IntegerHelper.countDigits(123));
    }

    @Test
    void countDigits_returnsCorrectCount_whenNumberIsNegative() {
        assertEquals(3, IntegerHelper.countDigits(-123));
    }

    @Test
    void countDigits_returnsCorrectCount_whenNumberIsZero() {
        assertEquals(1, IntegerHelper.countDigits(0));
    }
}
