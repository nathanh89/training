package com.visionarysoftwaresolutions.hfdpch1.tddstyle.quacks;

import static org.junit.Assert.*;

import org.junit.Test;

import com.visionarysoftwaresolutions.hfdpch1.tddstyle.quacks.Quack;
import com.visionarysoftwaresolutions.hfdpch1.tddstyle.quacks.QuackBehavior;

public class QuackTests {
	
	@Test
	public void testCorrectQuack() {
		//Given: You have a quack behavior
		//When: It is set to Quack
		QuackBehavior quackbehavior = new Quack();
		//Then: The quack behavior should demonstrate the correct quacking
		String expected = "Quack fo' rizzle, bitches!";
		assertEquals(expected, quackbehavior.quack());
	}
}