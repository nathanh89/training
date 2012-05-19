package com.visionarysoftwaresolutions.hfdpch2.tddstyle.demo.custom;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InputValidatorTests {
	
	InputValidator validator;
	
	@Before
	public void setup(){
		validator = new InputValidator();
	}

	@Test
	public void testStringIntegerConversion() {
		//Given: An input validator
		//And: I want it to convert integer Strings into int variables
		//When: I input an integer
		int result = validator.isInteger("2");
		//Then the input should be accepted and turned into an int
		assertEquals(2, result);
	}
	
	@Test
	public void testNonIntegerRejection(){
		//Given: An input validator
		//And: I do not want to accept an input unless it is an integer
		//When: I input something besides an integer
		//Then: The exception should be caught, and a 0 returned rather than a valid input
		assertEquals(0, validator.isInteger("a"));
	}
	
	@Test
	public void testWithinRange(){
		//Given: A validated integer input
		//And: I want to check it is within an accepted range
		//When: It is within the accepted range
		//Then: It should pass the range check
		assertTrue(validator.isInRange(1));
	}
	
	@Test
	public void testOutOfRangeRejection(){
		//Given: A validated integer input
		//And: I want to check it is within an accepted range
		//When: It is not within the accepted range
		//Then: It should not pass the range check
		assertFalse(validator.isInRange(6));
	}
}