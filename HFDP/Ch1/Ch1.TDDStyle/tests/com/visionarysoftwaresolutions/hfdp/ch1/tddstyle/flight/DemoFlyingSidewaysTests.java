package com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.flight;

import static org.junit.Assert.*;

import org.junit.Test;

import com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.demo.DemoFlyingSideways;

public class DemoFlyingSidewaysTests {
	
	FlyBehavior flybehavior = new DemoFlyingSideways();

	@Test
	public void testCorrectFlight() {
		//Given: You have a flight behavior
		//When: It is set to FlyingSideways
		//Then: The flight behavior should demonstrate the correct flight
		String expected = "Sideways flight? Where are your physics?!";
		assertEquals(expected, flybehavior.fly());
	}
}
