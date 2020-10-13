package com.tyeporter.tests;

import static org.junit.jupiter.api.Assertions.*;

import com.tyeporter.innerclass.OuterClass;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class OuterClassTests {
	// Properties
	OuterClass outer;
	
	// =========================================================
	// Setup & Braakdown 
	// =========================================================
	@BeforeEach
	void setUp() {
		outer = new OuterClass();
	}

	// =========================================================
	// Initialization
	// =========================================================
	@Test
	void testInit_HasOuterStringValue() {
		assertTrue(outer.getOuterString().equals("Hello "));
	}

	// =========================================================
	// InnerClass
	// =========================================================
	@Nested
	@DisplayName("Inner Class Tests")
	class InnerClassTests {
		// Properties
		OuterClass.InnerClass inner;

		// =========================================================
		// Setup & Braakdown 
		// =========================================================
		@BeforeEach
		void setUp() {
			inner = outer.new InnerClass("Java");
		}

		// =========================================================
		// Initialization
		// =========================================================
		@Test
		void testInit_HasInnerStringValue() {
			assertTrue(inner.getInnerString().equals("Hello Java"));
		}

	}

}
