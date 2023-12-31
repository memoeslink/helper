package org.memoeslink;

import java.util.Objects;

public class ArrayHelper {

    private ArrayHelper() {
    }

    public static <T> boolean isNullOrEmpty(T[] elements) {
        return elements == null || elements.length == 0;
    }

    public static <T> boolean isNotNullOrEmpty(T[] elements) {
        return !isNullOrEmpty(elements);
    }

    public static <T> boolean contains(T[] elements, Object occurrence) {
        if (isNullOrEmpty(elements))
            return false;

        for (Object element : elements) {
            if (element == null || occurrence == null) {
                if (element == null && occurrence == null) return true;
                continue;
            }

            if (element.getClass().equals(occurrence.getClass()) && Objects.equals(element, occurrence))
                return true;
        }
        return false;
    }

    @SafeVarargs
    public static <T> T getFirstNonNull(T... elements) {
        return getFirstNonNullOrDefault(null, elements);
    }

    @SafeVarargs
    public static <T> T getFirstNonNullOrDefault(T defaultValue, T... elements) {
        for (T element : elements) {
            if (element != null)
                return element;
        }
        return defaultValue;
    }
}
