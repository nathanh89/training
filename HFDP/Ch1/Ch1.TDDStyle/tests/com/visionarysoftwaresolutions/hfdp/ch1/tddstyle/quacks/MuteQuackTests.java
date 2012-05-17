package com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.quacks;

import static org.junit.Assert.*;

import org.junit.Test;

public class MuteQuackTests {
	
	@Test
	public void testCorrectQuack() {
		//Given: You have a quack behavior
		//When: It is set to MuteQuack
		QuackBehavior quackbehavior = new MuteQuack();
		//Then: The quack behavior should demonstrate the correct quacking
		String expected = "...Really? I can't quack. Oddly I do seem to do Englsih pretty well.";
		assertEquals(expected, quackbehavior.quack());
	}
}