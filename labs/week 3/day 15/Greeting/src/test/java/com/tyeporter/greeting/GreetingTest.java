package com.tyeporter.greeting;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GreetingTest {

	// =========================================================
    // Greet with String
    // =========================================================
   
	@Test
	public void testGreet_GivenName_GreetsPerson() {
		String actual = Greeting.greet("Bob");

		assertEquals("Hello, Bob.", actual);
	}

	@Test
	public void testGreet_GivenNull_GreetsFriend() {
		String name = null;
		String actual = Greeting.greet(name);

		assertEquals("Hello, my friend.", actual);
	}

	@Test
	public void testGreet_GivenUppercaseName_GreetPersonWithUppercase() {
		String actual = Greeting.greet("STEVE");

		assertEquals("HELLO, STEVE.", actual);
	}

	// =========================================================
    // Greet with Array of Strings
    // =========================================================

	@Test 
	public void testGreet_GivenTwoNames_GreetsTwoPeople() {
		String actual = Greeting.greet(new String[]{"Nala", "Letta"});

		assertEquals("Hello, Nala and Letta.", actual);
	}

	@Test
	public void testGreet_GivenNameAndNull_GreetsPersonAndFriend() {
		String actual = Greeting.greet(new String[]{"Brave", null});

		assertEquals("Hello, Brave and my friend.", actual);
	}

	@Test
	public void testGreet_GivenMultipleNames_GreetsPeople() {
		String actual = Greeting.greet(new String[]{"Lebron", "Anthony", "Dwight"});

		assertEquals("Hello, Lebron, Anthony, and Dwight.", actual);
	}

	@Test
	public void testGreet_GivenNameAndUppercaseName_GreetsPersonAndOtherWithUppercase() {
		String actual = Greeting.greet(new String[]{"Jordan", "BRYANT"});

		assertEquals("Hello, Jordan. AND BRYANT!", actual);
	}

	// TODO: Write tests for multiple mixed (uppercase and lowercase) names...

}
