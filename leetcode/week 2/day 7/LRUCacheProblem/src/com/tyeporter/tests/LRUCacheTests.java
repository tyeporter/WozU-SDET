package com.tyeporter.tests;

import static org.junit.jupiter.api.Assertions.*;
import com.tyeporter.cache.LRUCache;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LRUCacheTests {
	
	// Test Properties
	LRUCache cache;

	// =========================================================
	// Test Setup & Breakdown
	// =========================================================
	@BeforeEach
	void setUp() {
		cache = new LRUCache(5);
	}

	// =========================================================
	// LRUCache Initialization
	// =========================================================
	@Test
	void testInit_HasCapacity() {
		assertEquals(cache.getCapacity(), 5);
	}

	// =========================================================
	// LRUCache Get & Put
	// =========================================================
	@Test
	void testGet_ReturnsInteger() {
		cache.put(2, 9);

		assertEquals(cache.get(2), 9);
		assertEquals(cache.get(3), -1);
	}

	@Test 
	void testPut_CapacityReached_RemovesItemFromCache() {
		cache.put(2, 20);
		cache.put(4, 40);
		cache.put(6, 60);
		cache.put(8, 80);
		cache.put(10, 100);
		cache.put(12, 120);

		assertEquals(cache.get(4), 40);
		assertEquals(cache.get(2), -1);
	}

}
