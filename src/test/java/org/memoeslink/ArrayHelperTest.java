package org.memoeslink;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ArrayHelperTest {

    @Nested
    class IsNullOrEmpty {

        @Test
        void withNull_returnsTrue() {
            assertTrue(ArrayHelper.isNullOrEmpty((String[]) null));
        }

        @Test
        void withEmptyArray_returnsTrue() {
            assertTrue(ArrayHelper.isNullOrEmpty(new String[]{}));
        }

        @Test
        void withNonEmptyArray_returnsFalse() {
            assertFalse(ArrayHelper.isNullOrEmpty("a", "b"));
        }

        @Test
        void withSingleElement_returnsFalse() {
            assertFalse(ArrayHelper.isNullOrEmpty("a"));
        }
    }

    @Nested
    class IsNotNullOrEmpty {

        @Test
        void withNull_returnsFalse() {
            assertFalse(ArrayHelper.isNotNullOrEmpty((String[]) null));
        }

        @Test
        void withEmptyArray_returnsFalse() {
            assertFalse(ArrayHelper.isNotNullOrEmpty(new String[]{}));
        }

        @Test
        void withNonEmptyArray_returnsTrue() {
            assertTrue(ArrayHelper.isNotNullOrEmpty("a", "b"));
        }
    }

    @Nested
    class Any {

        @Test
        void withNullArray_returnsFalse() {
            assertFalse(ArrayHelper.any("a", (String[]) null));
        }

        @Test
        void withEmptyArray_returnsFalse() {
            assertFalse(ArrayHelper.any("a", new String[]{}));
        }

        @Test
        void withMatchingElement_returnsTrue() {
            assertTrue(ArrayHelper.any("b", "a", "b", "c"));
        }

        @Test
        void withNoMatchingElement_returnsFalse() {
            assertFalse(ArrayHelper.any("z", "a", "b", "c"));
        }

        @Test
        void withNullOccurrenceAndNullInArray_returnsTrue() {
            assertTrue(ArrayHelper.any(null, "a", null, "c"));
        }

        @Test
        void withNullOccurrenceAndNoNullInArray_returnsFalse() {
            assertFalse(ArrayHelper.any(null, "a", "b", "c"));
        }
    }

    @Nested
    class None {

        @Test
        void withNullArray_returnsTrue() {
            assertTrue(ArrayHelper.none("a", (String[]) null));
        }

        @Test
        void withEmptyArray_returnsTrue() {
            assertTrue(ArrayHelper.none("a", new String[]{}));
        }

        @Test
        void withMatchingElement_returnsFalse() {
            assertFalse(ArrayHelper.none("b", "a", "b", "c"));
        }

        @Test
        void withNoMatchingElement_returnsTrue() {
            assertTrue(ArrayHelper.none("z", "a", "b", "c"));
        }
    }

    @Nested
    class All {

        @Test
        void withNullArray_returnsFalse() {
            assertFalse(ArrayHelper.all("a", (String[]) null));
        }

        @Test
        void withEmptyArray_returnsFalse() {
            assertFalse(ArrayHelper.all("a", new String[]{}));
        }

        @Test
        void withAllMatchingElements_returnsTrue() {
            assertTrue(ArrayHelper.all("a", "a", "a", "a"));
        }

        @Test
        void withOneNonMatchingElement_returnsFalse() {
            assertFalse(ArrayHelper.all("a", "a", "a", "b"));
        }

        @Test
        void withNoMatchingElements_returnsFalse() {
            assertFalse(ArrayHelper.all("a", "b", "c", "d"));
        }
    }

    @Nested
    class GetFirstNonNull {

        @Test
        void withNullArray_returnsNull() {
            assertNull(ArrayHelper.getFirstNonNull((String[]) null));
        }

        @Test
        void withAllNullElements_returnsNull() {
            assertNull(ArrayHelper.getFirstNonNull(null, null, null));
        }

        @Test
        void withFirstNonNull_returnsFirst() {
            assertEquals("a", ArrayHelper.getFirstNonNull("a", "b", "c"));
        }

        @Test
        void withFirstNullSecondNonNull_returnsSecond() {
            assertEquals("b", ArrayHelper.getFirstNonNull(null, "b", "c"));
        }
    }

    @Nested
    class GetFirstNonNullOrDefault {

        @Test
        void withNullArray_returnsDefault() {
            assertEquals("default", ArrayHelper.getFirstNonNullOrDefault("default", (String[]) null));
        }

        @Test
        void withAllNullElements_returnsDefault() {
            assertEquals("default", ArrayHelper.getFirstNonNullOrDefault("default", null, null));
        }

        @Test
        void withFirstNonNull_returnsFirst() {
            assertEquals("a", ArrayHelper.getFirstNonNullOrDefault("default", "a", "b"));
        }

        @Test
        void withFirstNullSecondNonNull_returnsSecond() {
            assertEquals("b", ArrayHelper.getFirstNonNullOrDefault("default", null, "b"));
        }

        @Test
        void withNullDefault_returnsNull() {
            assertNull(ArrayHelper.getFirstNonNullOrDefault(null, (String[]) null));
        }
    }

    @Nested
    class ToArrayList {

        @Test
        void withNull_returnsNull() {
            assertNull(ArrayHelper.toArrayList((String[]) null));
        }

        @Test
        void withEmptyArray_returnsEmptyList() {
            List<String> result = ArrayHelper.toArrayList(new String[]{});
            assertNotNull(result);
            assertTrue(result.isEmpty());
        }

        @Test
        void withElements_returnsListWithSameElements() {
            List<String> result = ArrayHelper.toArrayList("a", "b", "c");
            assertEquals(List.of("a", "b", "c"), result);
        }

        @Test
        void withElements_returnsListOfCorrectSize() {
            List<String> result = ArrayHelper.toArrayList("a", "b", "c");
            assertEquals(3, result.size());
        }
    }

    @Nested
    class ToHashMap {

        @Test
        void withNull_returnsNull() {
            assertNull(ArrayHelper.toHashMap((String[]) null));
        }

        @Test
        void withEmptyArray_returnsEmptyMap() {
            Map<Integer, String> result = ArrayHelper.toHashMap(new String[]{});
            assertNotNull(result);
            assertTrue(result.isEmpty());
        }

        @Test
        void withElements_mapsIndexToElement() {
            Map<Integer, String> result = ArrayHelper.toHashMap("a", "b", "c");
            assertAll(
                    () -> assertEquals("a", result.get(0)),
                    () -> assertEquals("b", result.get(1)),
                    () -> assertEquals("c", result.get(2))
            );
        }

        @Test
        void withElements_returnsMapOfCorrectSize() {
            Map<Integer, String> result = ArrayHelper.toHashMap("a", "b", "c");
            assertEquals(3, result.size());
        }
    }

    @Nested
    class ToHashSet {

        @Test
        void withNull_returnsNull() {
            assertNull(ArrayHelper.toHashSet((String[]) null));
        }

        @Test
        void withEmptyArray_returnsEmptySet() {
            Set<String> result = ArrayHelper.toHashSet(new String[]{});
            assertNotNull(result);
            assertTrue(result.isEmpty());
        }

        @Test
        void withElements_returnsSetWithSameElements() {
            Set<String> result = ArrayHelper.toHashSet("a", "b", "c");
            assertEquals(Set.of("a", "b", "c"), result);
        }

        @Test
        void withDuplicateElements_returnsSetWithUniqueElements() {
            Set<String> result = ArrayHelper.toHashSet("a", "a", "b");
            assertEquals(2, result.size());
            assertTrue(result.contains("a"));
            assertTrue(result.contains("b"));
        }
    }
}
