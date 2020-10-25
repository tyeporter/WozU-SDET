package com.tyeporter.removestringspacesproblem.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class NiceStringTest {

	@Test
	public void testRemoveSpaces_GivenString_ReturnsString() {
		String actual = NiceString.removeSpaces("my string");

		assertEquals(String.class, actual.getClass());
	}

	@Test
	public void testRemoveSpaces_GivenStringWithSpaces_ReturnsSameStringWithoutSpaces() {
		String expected = "Java'scool!";
		String actual = NiceString.removeSpaces("Java's cool!");


		assertEquals(expected, actual.toString());
	}

	@Test
	public void testRemoveSpaces_GivenStringWithConsecutiveSpace_ReturnsSameStringWithoutSpaces() {
		String expected = "Programmingisfun!";
		String actual = NiceString.removeSpaces("Programming  is    fun!");

		assertEquals(expected, actual);
	}

}