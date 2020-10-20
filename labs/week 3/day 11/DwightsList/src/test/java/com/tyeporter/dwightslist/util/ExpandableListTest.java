package com.tyeporter.dwightslist.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExpandableListTest {
    ExpandableList<String> list;

    @BeforeEach
    public void setUp_BeforeEach() {
        this.list = new ExpandableList<>();
    }

    // =========================================================
    // Initialization
    // =========================================================

    @Test
    public void testInit_LimitReturnsTen() {
        int expected = 10;
        int actual = this.list.getLimit();

        assertEquals(expected, actual);
    }

    // =========================================================
    // Adding items
    // =========================================================

    @Test
    public void testAdd_GivenItem_ReturnsTrue() {
        assertTrue(this.list.add("Java"));
    }

    @Test
    public void testAdd_IsReadOnly_ReturnsFalse() {
        this.list.setReadOnly(true);

        assertFalse(this.list.add("Java"));
    }

    // =========================================================
    // Removing items
    // =========================================================

    @Test
    public void testRemove_GivenValidIndex_ReturnsTrue() {
        this.list.add("Swift");

        assertTrue(this.list.remove(0));
    }

    @Test
    public void testRemove_GivenInvalidIndex_ReturnsFalse() {
        this.list.add("Swift");

        assertFalse(this.list.remove(1));
    }

    // =========================================================
    // Getting items
    // =========================================================
    
    @Test
    public void testGet_GivenValidIndex_ReturnsElement() {
        this.list.add("Swift");
        this.list.add("Java");

        String expected = "Swift";
        String actual = this.list.get(0);

        assertEquals(expected, actual);
    }

    @Test
    public void testGet_GivenInvalidIndex_ThrowsException() {
        this.list.add("Swift");
        this.list.add("Java");

        assertThrows(IndexOutOfBoundsException.class, () -> this.list.get(10));
    }
}
