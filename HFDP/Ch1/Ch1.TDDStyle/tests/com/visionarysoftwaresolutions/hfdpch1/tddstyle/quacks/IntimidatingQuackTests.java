package com.visionarysoftwaresolutions.hfdpch1.tddstyle.quacks;

import static org.junit.Assert.*;

import org.junit.Test;

import com.visionarysoftwaresolutions.hfdpch1.tddstyle.quacks.IntimidatingQuack;
import com.visionarysoftwaresolutions.hfdpch1.tddstyle.quacks.QuackBehavior;

public class IntimidatingQuackTests {
	
	@Test
	public void testCorrectQuack() {
		//Given: You have a quack behavior
		//When: It is set to GingerQuack
		QuackBehavior quackbehavior = new IntimidatingQuack();
		//Then: The quack behavior should demonstrate the correct quacking
		String expected = "Do you know John Connor? HAVE YOU SEEN THIS BOY?";
		assertEquals(expected, quackbehavior.quack());
	}
}