package com.tyeporter.fibonacci.coolmath;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CoolMathTest {

	@Test
	public void testFibonacci_GivenZero_ReturnsZero() {
		int actual = CoolMath.fibonacci(0);

		assertEquals(0, actual);
	}

	@Test 
	public void testFibonacci_GivenOne_ReturnsOne() {
		int actual = CoolMath.fibonacci(1);

		assertEquals(1, actual);;
	}

	@Test
	public void testFibonacci_GivenFour_ReturnsThree() {
		int actual = CoolMath.fibonacci(4);

		assertEquals(3, actual);
	}

	@Test
	public void testFibonacci_GivenEight_ReturnsTwentyOne() {
		int actual = CoolMath.fibonacci(8);

		assertEquals(21, actual);
	}

	@Test
	public void testFibonacci_GivenTwelve_ReturnsOneHundredFourtyFour() {
		int actual = CoolMath.fibonacci(12);

		assertEquals(144, actual);
	}

	@Test
	public void testFibonacci_GivenSixteen_ReturnsNineHundredEightySeven() {
		int actual = CoolMath.fibonacci(16);

		assertEquals(987, actual);
	}

}