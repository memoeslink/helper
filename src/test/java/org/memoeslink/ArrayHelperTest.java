package org.memoeslink;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayHelperTest {

    @Test
    void isNullOrEmpty() {
        assertTrue(ArrayHelper.isNullOrEmpty());
        assertTrue(ArrayHelper.isNullOrEmpty(new Object[0]));
        assertFalse(ArrayHelper.isNullOrEmpty("test"));
    }

    @Test
    void isNotNullOrEmpty() {
        assertFalse(ArrayHelper.isNotNullOrEmpty());
        assertFalse(ArrayHelper.isNotNullOrEmpty(new Object[0]));
        assertTrue(ArrayHelper.isNotNullOrEmpty("test"));
    }

    @Test
    void any() {
        assertFalse(ArrayHelper.any("test"));
        assertTrue(ArrayHelper.any("test", "test"));
        assertFalse(ArrayHelper.any("test", "test1", "test2"));
    }

    @Test
    void none() {
        assertTrue(ArrayHelper.none("test"));
        assertFalse(ArrayHelper.none("test", "test"));
        assertTrue(ArrayHelper.none("test", "test1", "test2"));
    }

    @Test
    void all() {
        assertFalse(ArrayHelper.all("test"));
        assertTrue(ArrayHelper.all("test", "test"));
        assertFalse(ArrayHelper.all("test", "test", "test1"));
    }

    @Test
    void getFirstNonNull() {
        assertNull(ArrayHelper.getFirstNonNull());
        assertEquals("test", ArrayHelper.getFirstNonNull("test"));
        assertEquals("test", ArrayHelper.getFirstNonNull(null, "test"));
    }

    @Test
    void getFirstNonNullOrDefault() {
        assertNull(ArrayHelper.getFirstNonNullOrDefault(null));
        assertEquals("default", ArrayHelper.getFirstNonNullOrDefault("default"));
        assertEquals("test", ArrayHelper.getFirstNonNullOrDefault("default", "test"));
    }

    @Test
    void toArrayList() {
        assertNull(ArrayHelper.toArrayList((Object[]) null));
        assertEquals(0, ArrayHelper.toArrayList().size());
        assertEquals(1, ArrayHelper.toArrayList("test").size());
    }

    @Test
    void toHashMap() {
        assertNull(ArrayHelper.toHashMap((Object[]) null));
        assertEquals(0, ArrayHelper.toHashMap().size());
        assertEquals(1, ArrayHelper.toHashMap("test").size());
    }

    @Test
    void toHashSet() {
        assertNull(ArrayHelper.toHashSet((Object[]) null));
        assertEquals(0, ArrayHelper.toHashSet().size());
        assertEquals(1, ArrayHelper.toHashSet("test").size());
    }
}