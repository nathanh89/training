package com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.quacks;

import static org.junit.Assert.*;

import org.junit.Test;

public class SqueakTests {
	
	@Test
	public void testCorrectQuack() {
		//Given: You have a quack behavior
		//When: It is set to Squeak
		QuackBehavior quackbehavior = new Squeak();
		//Then: The quack behavior should demonstrate the correct quacking
		String expected = "Squeak? And I'm a 'duck'? Odd.";
		assertEquals(expected, quackbehavior.quack());
	}
}