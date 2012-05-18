package com.visionarysoftwaresolutions.hfdpch1.tddstyle.flight;

import static org.junit.Assert.*;

import org.junit.Test;

import com.visionarysoftwaresolutions.hfdpch1.tddstyle.flight.FlyBehavior;
import com.visionarysoftwaresolutions.hfdpch1.tddstyle.flight.FlyRocketPowered;

public class FlyRocketPoweredTests {
	
	FlyBehavior flybehavior = new FlyRocketPowered();

	@Test
	public void testCorrectFlight() {
		//Given: You have a flight behavior
		//When: It is set to FlyRocketPowered
		//Then: The flight behavior should demonstrate the correct flight
		String expected = "Ass rocket ahoy! For Zephram!";
		assertEquals(expected, flybehavior.fly());
	}
}