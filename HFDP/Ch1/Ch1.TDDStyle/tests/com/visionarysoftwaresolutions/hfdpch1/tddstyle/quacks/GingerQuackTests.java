package com.visionarysoftwaresolutions.hfdpch1.tddstyle.quacks;

import static org.junit.Assert.*;

import org.junit.Test;

import com.visionarysoftwaresolutions.hfdpch1.tddstyle.quacks.GingerQuack;
import com.visionarysoftwaresolutions.hfdpch1.tddstyle.quacks.QuackBehavior;

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
