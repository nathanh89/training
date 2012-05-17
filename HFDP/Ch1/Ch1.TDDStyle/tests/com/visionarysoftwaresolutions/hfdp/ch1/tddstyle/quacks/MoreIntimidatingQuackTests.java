package com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.quacks;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoreIntimidatingQuackTests {
	
	@Test
	public void testCorrectQuack() {
		//Given: You have a quack behavior
		//When: It is set to MoreIntimidatingQuack
		QuackBehavior quackbehavior = new MoreIntimidatingQuack();
		//Then: The quack behavior should demonstrate the correct quacking
		String expected = "Fool. I'll ask again...HAVE YOU SEEN THIS BOY?";
		assertEquals(expected, quackbehavior.quack());
	}
}