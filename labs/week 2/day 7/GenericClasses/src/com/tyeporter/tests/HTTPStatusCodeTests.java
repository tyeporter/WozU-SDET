package com.tyeporter.tests;

import static org.junit.jupiter.api.Assertions.*;
import com.tyeporter.httpstatuscode.HTTPStatusCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HTTPStatusCodeTests {
	// Test Properties
	HTTPStatusCode<Integer, String> statusCode;

	// =========================================================
	// Setup & Breakdown 
	// =========================================================
	@BeforeEach
	void setUp() {
		statusCode = new HTTPStatusCode<>();
		statusCode.setCode(200);
		statusCode.setMessage("OK");
	}

	// =========================================================
	// Initialization 
	// =========================================================
	@Test
	void testInit_PropertieTypesHaveBounds() {
		assertTrue(statusCode.getCode().getClass().getSuperclass() == Number.class);
		assertTrue(CharSequence.class.isAssignableFrom(statusCode.getMessage().getClass()));
	}

	// =========================================================
	// String Representation
	// =========================================================
	@Test
	void testToString_ReturnsFormattedString() {
		String statusCodeAsString = statusCode.toString();

		assertEquals(statusCodeAsString, "(200, OK)");
	}

}
