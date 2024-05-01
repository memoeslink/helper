package org.memoeslink;

public class IntegerHelper {
    public static final int INITIAL_INDEX = 0;

    private IntegerHelper() {
    }

    /**
     * Checks if a number is within a specified range.
     *
     * @param n   the number to check
     * @param min the minimum value of the range
     * @param max the maximum value of the range
     * @return {@code true} if {@code n} is between {@code min} and {@code max}, {@code false} otherwise
     */
    public static boolean isBetween(int n, int min, int max) {
        return min <= n && n <= max;
    }

    /**
     * Returns the index if it is within the specified length, otherwise returns the initial index value.
     *
     * @param index  the index to check
     * @param length the length to compare against
     * @return the index if it's valid, otherwise the initial index
     */
    public static int defaultIndex(int index, int length) {
        if (index >= INITIAL_INDEX && index <= length - 1)
            return index;
        return INITIAL_INDEX;
    }

    /**
     * Returns the minimum of two integers, or the specified minimum value if the given integer is less than it.
     *
     * @param n   the integer to check
     * @param min the minimum value
     * @return the lesser of the two values
     */
    public static int defaultByMin(int n, int min) {
        if (min == Integer.MIN_VALUE || n < min)
            return min;
        return n;
    }

    /**
     * Returns the maximum of two integers, or the specified maximum value if the given integer is greater than it.
     *
     * @param n   the integer to check
     * @param max the maximum value
     * @return the greater of the two values
     */
    public static int defaultByMax(int n, int max) {
        if (max == Integer.MAX_VALUE || n > max)
            return max;
        return n;
    }

    /**
     * Returns the value within the range defined by the minimum and maximum values.
     *
     * @param n   the value to check
     * @param min the minimum value of the range
     * @param max the maximum value of the range
     * @return the value within the specified range
     */
    public static int defaultByRange(int n, int min, int max) {
        if (min > max)
            return 0;

        if (isBetween(n, min, max))
            return n;
        return n < min ? min : max;
    }

    /**
     * Checks if a given string represents a valid integer.
     *
     * @param s the string to check
     * @return {@code true} if the string can be parsed as an integer, {@code false} otherwise
     */
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Parses the specified string as an integer, returning the default value if parsing fails.
     *
     * @param s            the string to parse
     * @param defaultValue the default value to return if parsing fails
     * @return the parsed integer value or the default value if parsing fails
     */
    public static int tryParse(String s, int defaultValue) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * Parses the specified string as an integer, returning 0 if parsing fails.
     *
     * @param s the string to parse
     * @return the parsed integer value or 0 if parsing fails
     */
    public static int tryParse(String s) {
        return tryParse(s, 0);
    }

    /**
     * Counts the number of digits in the given integer.
     *
     * @param n the integer to count digits for
     * @return the number of digits in the integer
     */
    public static int countDigits(int n) {
        if (n < 0)
            n *= -1;

        if (n < 100000) {
            if (n < 100) {
                if (n < 10) return 1;
                else return 2;
            } else {
                if (n < 1000) return 3;
                else if (n < 10000) return 4;
                else return 5;
            }
        } else {
            if (n < 10000000) {
                if (n < 1000000) return 6;
                else return 7;
            } else {
                if (n < 100000000) return 8;
                else if (n < 1000000000) return 9;
                else return 10;
            }
        }
    }
}
