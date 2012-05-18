package com.visionarysoftwaresolutions.hfdpch1.tddstyle.quacks;

import static org.junit.Assert.*;

import org.junit.Test;

import com.visionarysoftwaresolutions.hfdpch1.tddstyle.demo.DemoMuteQuack;
import com.visionarysoftwaresolutions.hfdpch1.tddstyle.quacks.QuackBehavior;

public class DemoMuteQuackTests {
	
	@Test
	public void testCorrectQuack() {
		//Given: You have a quack behavior
		//When: It is set to MuteQuack
		QuackBehavior quackbehavior = new DemoMuteQuack();
		//Then: The quack behavior should demonstrate the correct quacking
		String expected = "...Really? I can't quack. Oddly I do seem to do Englsih pretty well.";
		assertEquals(expected, quackbehavior.quack());
	}
}