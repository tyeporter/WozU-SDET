package com.tyeporter.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import com.tyeporter.util.NiceString;

/***********************************************************
 * The NiceStringTest class tests the methods of the 
 * NiceString class
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-12-2020
 ***********************************************************/

class NiceStringTests {
	
	// Setup
	@BeforeEach
	void setUpInitialValues() {
		// TODO: Setup initial values
	}

	
	// =========================================================
    // Initialization Tests
	// =========================================================
	
	@Test 
	void testInit_HasInitialCharacterCount() {
		NiceString testString  = new NiceString();
		assertEquals(testString.getValue().length(), 0);
	}

	@Test
	void testInit_GivenString_EqualsGivenString() {
		NiceString testString  = new NiceString("Hello");
		assertEquals(testString.getValue(), "Hello");
	}

	@Test
	void testInit_GivenCharacters_EqualsCharactersJoined() {
		NiceString testString = new NiceString(new char[]{'U', 'b', 'u', 'n', 't', 'u'});
		assertEquals(testString.getValue(), "Ubuntu");
	}


	// =========================================================
    // Equate Tests
	// =========================================================

	@Test
	void testEquatable_HasSameValue_ReturnsTrue() {
		NiceString testString1 = new NiceString("Programming");
		NiceString testString2 = new NiceString("Programming");

		assertTrue(testString1.equals(testString2));

		NiceString testString3 = new NiceString(new char[]{'J', 'a', 'v', 'a'});
		NiceString testString4 = new NiceString("Java");

		assertTrue(testString3.equals(testString4));
	}

	@Test
	void testEquatable_HasSameWord_ReturnsTrue() {
		NiceString testString1 = new NiceString("lowercase");
		NiceString testString2 = new NiceString("LOWERCASE");

		assertTrue(testString1.equalsIgnoreCase(testString2));
	}


	// =========================================================
    // Query Tests
	// =========================================================

	@Test
	void testCharAt_ReturnsCharacterAtIndex() {
		NiceString testString  = new NiceString("Karibu");
		assertEquals(testString.charAt(1), 'a');
	}

	@Test
	void testContains_GivenSubstring_ReturnsBoolean() {
		NiceString testString = new NiceString("scent");
		NiceString testSubstring = new NiceString("tent");

		assertTrue(testString.contains("cent"));
		assertFalse(testString.contains(testSubstring));
	}

	@Test
	void testGetChars_ReturnsCharacterArrayRepresentationOfString() {
		NiceString testString = new NiceString("Nigeria");

		assertTrue(Arrays.equals(testString.getChars(), new char[]{'N', 'i', 'g', 'e', 'r', 'i', 'a'}));
	}

	@Test
	void testIndexOf_GivenCharacter_ReturnsIndex() {
		NiceString testString = new NiceString("Brazil");
		
		assertEquals(testString.indexOf('z'), 3);
		assertEquals(testString.indexOf('f'), -1);
	}

	@Test
	void testIsEmpty_ReturnsBoolean() {
		NiceString testString = new NiceString();

		assertEquals(testString.getValue(), "");
	}

	@Test
	void testLength_ReturnsCharacterCount() {
		NiceString testString = new NiceString("Japan");

		assertEquals(testString.length(), 5);
	}

	// =========================================================
    // Modify Tests
	// =========================================================

	@Test
	void testConcat_GivenString_ReturnsConcatenatedString() {
		NiceString testString1 = new NiceString("Programming");
		NiceString testString2 = new NiceString(" is fun");

		assertEquals(testString1.concat(testString2), "Programming is fun");
		assertEquals(testString1.concat(" is cool"), "Programming is cool");
	}

}
