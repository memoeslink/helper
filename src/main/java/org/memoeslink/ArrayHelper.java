package org.memoeslink;

import java.util.*;

public class ArrayHelper {

    private ArrayHelper() {
    }

    /**
     * Checks if the provided array is {@code null} or empty.
     *
     * @param elements the array to check
     * @param <T>      the type of elements in the array
     * @return {@code true} if the array is {@code null} or empty, {@code false} otherwise
     */
    @SafeVarargs
    public static <T> boolean isNullOrEmpty(T... elements) {
        return elements == null || elements.length == 0;
    }

    /**
     * Checks if the provided array is not {@code null} and not empty.
     *
     * @param elements the array to check
     * @param <T>      the type of elements in the array
     * @return {@code true} if the array is not {@code null} and not empty, {@code false} otherwise
     */
    @SafeVarargs
    public static <T> boolean isNotNullOrEmpty(T... elements) {
        return !isNullOrEmpty(elements);
    }

    /**
     * Checks if the array contains the given object.
     *
     * @param elements   the array to search in
     * @param occurrence the object being searched for
     * @param <T>        the type of elements in the array
     * @return {@code true} if the array contains the object, {@code false} otherwise
     */
    @SafeVarargs
    public static <T> boolean any(T occurrence, T... elements) {
        if (isNullOrEmpty(elements)) return false;

        for (T element : elements) {
            if (Objects.equals(element, occurrence)) return true;
        }
        return false;
    }

    /**
     * Checks if none of the elements in the array matches the given object.
     *
     * @param elements   the array to search in
     * @param occurrence the object being searched for
     * @param <T>        the type of elements in the array
     * @return {@code true} if none of the elements match the object, {@code false} otherwise
     */
    @SafeVarargs
    public static <T> boolean none(T occurrence, T... elements) {
        return !any(occurrence, elements);
    }

    /**
     * Checks if all elements in the array match the given object.
     *
     * @param elements   the array to search in
     * @param occurrence the object being searched for
     * @param <T>        the type of elements in the array
     * @return {@code true} if all elements match the object, {@code false} otherwise
     */
    @SafeVarargs
    public static <T> boolean all(T occurrence, T... elements) {
        if (isNullOrEmpty(elements)) return false;

        for (T element : elements) {
            if (!Objects.equals(element, occurrence)) return false;
        }
        return true;
    }

    /**
     * Gets the first non-null element from the array.
     *
     * @param elements the array from which to get the first non-null element
     * @param <T>      the type of elements in the array
     * @return the first non-null element from the array, or {@code null} if all elements are {@code null}
     */
    @SafeVarargs
    public static <T> T getFirstNonNull(T... elements) {
        return getFirstNonNullOrDefault(null, elements);
    }

    /**
     * Gets the first non-null element from the array or a default value if all elements are {@code null}.
     *
     * @param defaultValue the default value to return if all elements are {@code null}
     * @param elements     the array from which to get the first non-null element
     * @param <T>          the type of elements in the array
     * @return the first non-null element from the array, or the default value if all elements are {@code null}
     */
    @SafeVarargs
    public static <T> T getFirstNonNullOrDefault(T defaultValue, T... elements) {
        if (isNullOrEmpty(elements)) return defaultValue;

        for (T element : elements) {
            if (element != null) return element;
        }
        return defaultValue;
    }

    /**
     * Converts an array into an {@code ArrayList}.
     *
     * @param <T>      The type of elements in the input array and the resulting {@code ArrayList}.
     * @param elements The array to be converted into an {@code ArrayList}.
     * @return An {@code ArrayList} containing the elements of the input array, or {@code null} if the input array is {@code null}.
     */
    @SafeVarargs
    public static <T> List<T> toArrayList(T... elements) {
        if (elements == null) return null;
        return new ArrayList<>(Arrays.asList(elements));
    }

    /**
     * Converts an array into a {@code HashMap} where each element is mapped to its index.
     *
     * @param <T>      The type of elements in the input array and the values of the resulting {@code HashMap}.
     * @param elements The array to be converted into a {@code HashMap}.
     * @return A {@code HashMap} mapping each element's index to the element itself, or {@code null} if the input array is {@code null}.
     */
    @SafeVarargs
    public static <T> Map<Integer, T> toHashMap(T... elements) {
        if (elements == null) return null;
        Map<Integer, T> map = new HashMap<>();

        for (int i = 0; i < elements.length; i++) {
            map.put(i, elements[i]);
        }
        return map;
    }

    /**
     * Converts an array into a {@code HashSet}.
     *
     * @param <T>      The type of elements in the input array and the resulting {@code HashSet}.
     * @param elements The array to be converted into a {@code HashSet}.
     * @return A {@code HashSet} containing unique elements from the input array, or {@code null} if the input array is {@code null}.
     */
    @SafeVarargs
    public static <T> Set<T> toHashSet(T... elements) {
        if (elements == null) return null;
        return new HashSet<>(Arrays.asList(elements));
    }
}
