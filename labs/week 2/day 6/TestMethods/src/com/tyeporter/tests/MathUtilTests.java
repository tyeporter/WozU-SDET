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

	@Test
	@DisplayName("The divide() methed should return quotient")
	void divide_Should_ReturnQuotient() {
		assertEquals(mathUtil.divide(42, 7), 6, "divide(42, 7) should return 6");
	}

	@Test
	@DisplayName("The multiply() methed should return product")
	void multiply_Should_ReturnProduct() {
		assertEquals(mathUtil.multiply(6, 6), 36, "multiply(6, 6) should return 36");
	}

	@Test
	@DisplayName("The circumference() methed given radius should return circumference of circle")
	void circumferenceGivenRadius_Should_ReturnCircumference() {
		assertEquals(mathUtil.circumference(4), 25.132741228718345, "circumference(4) should return 25.132741228718345");
	}

}
