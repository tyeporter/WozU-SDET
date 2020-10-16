package com.tyeporter.recreatelinkedlist.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NiceNodeTests {
    NiceNode<String> niceNode;

    @BeforeEach
    void testSetUp() {
        niceNode = new NiceNode<>("My String");
    }

    // =========================================================
	// Initialization
	// =========================================================

    @Test
    void testInit_HasValue() {
        assertEquals("My String", niceNode.getValue());
    }
    
    @Test
    void testInit_NextIsNull() {
        assertEquals(null, niceNode.getNext());
    }

}
