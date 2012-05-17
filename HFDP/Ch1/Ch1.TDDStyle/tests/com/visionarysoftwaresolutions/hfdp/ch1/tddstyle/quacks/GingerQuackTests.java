package com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.quacks;

import static org.junit.Assert.*;

import org.junit.Test;

public class GingerQuackTests {
	
	@Test
	public void testCorrectQuack() {
		//Given: You have a quack behavior
		//When: It is set to GingerQuack
		QuackBehavior quackbehavior = new GingerQuack();
		//Then: The quack behavior should demonstrate the correct quacking
		String expected = "Quack! (But with a dash of ginger...)";
		assertEquals(expected, quackbehavior.quack());
	}
}
