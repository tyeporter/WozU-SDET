package com.tyeporter.exesandohsproblem.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class XOTest {

	@Test
	public void testGetXO_GivenEqualExesAndOhs_ReturnsTrue() {
		boolean condition = XO.getXO("xxoxxooo");

		assertTrue(condition);
	}

	@Test
	public void testGetXO_GivenNoExesAndOhs_ReturnsTrue() {
		boolean condition = XO.getXO("abcdefgh");

		assertTrue(condition);
	}

	@Test
	public void testGetXO_GivenEqualExesAndOhs_WithMixedCases_ReturnsTrue() {
		boolean condition = XO.getXO("xXxoooXo");

		assertTrue(condition);
	}

}