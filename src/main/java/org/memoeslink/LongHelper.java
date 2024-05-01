package org.memoeslink;

public class LongHelper {
    public static final long INITIAL_INDEX = 0L;

    private LongHelper() {
    }

    /**
     * Checks if the given number is between the specified range (inclusive).
     *
     * @param n   the number to check
     * @param min the minimum value of the range
     * @param max the maximum value of the range
     * @return true if n is between min and max (inclusive), false otherwise
     */
    public static boolean isBetween(long n, long min, long max) {
        return min <= n && n <= max;
    }

    /**
     * Returns the index if it is within the valid range; otherwise, returns the initial index.
     *
     * @param index  the index to validate
     * @param length the length against which the index is validated
     * @return the validated index
     */
    public static long defaultIndex(long index, long length) {
        if (index >= INITIAL_INDEX && index <= length - 1L)
            return index;
        return INITIAL_INDEX;
    }

    /**
     * Returns the minimum value between the given number and the specified minimum value.
     *
     * @param n   the number to check
     * @param min the minimum value
     * @return the minimum value between n and min
     */
    public static long defaultByMin(long n, long min) {
        if (min == Long.MIN_VALUE || n < min)
            return min;
        return n;
    }

    /**
     * Returns the maximum value between the given number and the specified maximum value.
     *
     * @param n   the number to check
     * @param max the maximum value
     * @return the maximum value between n and max
     */
    public static long defaultByMax(long n, long max) {
        if (max == Long.MAX_VALUE || n > max)
            return max;
        return n;
    }

    /**
     * Returns the number within the range defined by min and max.
     *
     * @param n   the number to check
     * @param min the minimum value of the range
     * @param max the maximum value of the range
     * @return n if it's within the range, min if n is less than min, max if n is greater than max
     */
    public static long defaultByRange(long n, long min, long max) {
        if (min > max)
            return 0L;

        if (isBetween(n, min, max))
            return n;
        return n < min ? min : max;
    }

    /**
     * Checks if the given string represents a valid long integer.
     *
     * @param s the string to check
     * @return true if the string represents a valid long integer, false otherwise
     */
    public static boolean isLong(String s) {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Parses the string argument as a long integer.
     *
     * @param s the string to parse
     * @return the long integer represented by the string, or 0L if parsing fails
     */
    public static long tryParse(String s) {
        return tryParse(s, 0L);
    }

    /**
     * Parses the string argument as a long integer.
     *
     * @param s            the string to parse
     * @param defaultValue the default value to return if parsing fails
     * @return the long integer represented by the string, or defaultValue if parsing fails
     */
    public static long tryParse(String s, long defaultValue) {
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * Counts the number of digits in a given long integer.
     *
     * @param n the long integer to count digits
     * @return the number of digits in n
     */
    public static int countDigits(long n) {
        if (n == 0L)
            return 1;
        return (int) Math.log10(Math.abs(n)) + 1;
    }
}
