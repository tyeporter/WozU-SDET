package com.tyeporter.recreatelinkedlist.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NiceLinkedListTests {
    NiceLinkedList<String> niceLinkedList;

    @BeforeEach
    void testSetUp() {
        niceLinkedList = new NiceLinkedList<>("Java");
    }

    // =========================================================
	// Initialization
	// =========================================================

    @Test
    void testInit_HasHead() {
        assertEquals("Java", niceLinkedList.get(0));
    }

    // =========================================================
	// Adding
	// =========================================================

    @Test
    void testAdd_AppendsItem() {
        niceLinkedList.add("Swift");

        assertEquals(2, niceLinkedList.size());
        assertEquals("Swift", niceLinkedList.get(1));
    }

    @Test
    void testAdd_GivenIndex_InsertsItem() {
        niceLinkedList.add("Swift");
        niceLinkedList.add(1, "Rust");

        assertEquals(3, niceLinkedList.size());
        assertEquals("Rust", niceLinkedList.get(1));
    }

    // =========================================================
	// Getting
    // =========================================================

    @Test
    void testGet_ReturnsItem() {
        niceLinkedList.add("Swift");
        niceLinkedList.add("Rust");

        assertEquals("Swift", niceLinkedList.get(1));
    }

    // =========================================================
	// Removing
    // =========================================================
    
    @Test
    void testRemoving_DeletesHead() {
        niceLinkedList.add("Swift");

        assertEquals("Java", niceLinkedList.remove());
        assertEquals("Swift", niceLinkedList.get(0));
    }

    @Test
    void testRemoving_GivenIndex_DeletesItem() {
        niceLinkedList.add("Swift");
        niceLinkedList.add(1, "Rust");

        assertEquals("Java", niceLinkedList.remove(0));
        assertEquals("Rust", niceLinkedList.get(0));
    }

    @Test
    void testRemoving_GivenValue_DeletesItem() {
        niceLinkedList.add("Swift");
        niceLinkedList.add(1, "Rust");

        assertEquals("Rust", niceLinkedList.remove("Rust"));
        assertEquals("Swift", niceLinkedList.get(1));
    }

    // =========================================================
	// List Size
    // =========================================================

    @Test
    void testSize_ReturnNumberOfItems() {
        niceLinkedList.add("Swift");
        niceLinkedList.add("Rust");
        niceLinkedList.add("C++");
        niceLinkedList.add("Python");

        niceLinkedList.remove("C++");
        assertEquals(4, niceLinkedList.size());
    }

}
