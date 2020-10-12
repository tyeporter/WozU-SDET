package com.tyeporter.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import com.tyeporter.util.MathUtil;

class MathUtilTests {

	MathUtil mathUtil;

	// Setup
	@BeforeEach
	void setUpInitialValues() {
		mathUtil = new MathUtil();
	}

	@Test
	@DisplayName("The add() methed should return sum")
	void add_Should_ReturnSum() {
		assertEquals(mathUtil.add(1, 2), 3, "add(1, 2) should return 3");
	}

	@Test
	@DisplayName("The subtract() methed should return difference")
	void subtract_Should_ReturnDifference() {
		assertEquals(mathUtil.subtract(9, 5), 4, "subtract(9, 5) should return 4");
	}

}
