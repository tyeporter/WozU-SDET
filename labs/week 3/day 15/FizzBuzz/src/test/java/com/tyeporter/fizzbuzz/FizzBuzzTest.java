package com.tyeporter.fizzbuzz;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {

	@Test
    public void testGenerateFizzBuzz_GivenLimitOfThree_GeneratesProperString() {
    	String expected = "1\n2\nFizz";
    	String actual = FizzBuzz.generateFizzBuzz(3);
    	assertEquals(expected, actual);
    }

    @Test
    public void testGenerateFizzBuzz_GivenLimitOfFive_GeneratesProperString() {
    	String expected = "1\n2\nFizz\n4\nBuzz";
    	String actual = FizzBuzz.generateFizzBuzz(5);

    	assertEquals(expected, actual);
    }

    @Test
    public void testGenerateFizzBuzz_GivenLimitOfFifteen_GeneratesProperString() {
    	String expected = "1\n2\nFizz\n4\nBuzz\nFizz\n7\n8\nFizz\nBuzz\n11\nFizz\n13\n14\nFizzBuzz";
    	String actual = FizzBuzz.generateFizzBuzz(15);

    	assertEquals(expected, actual);
    }

}
