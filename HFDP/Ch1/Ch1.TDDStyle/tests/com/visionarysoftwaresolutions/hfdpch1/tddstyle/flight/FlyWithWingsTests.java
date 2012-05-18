package com.visionarysoftwaresolutions.hfdpch1.tddstyle.flight;

import static org.junit.Assert.*;

import org.junit.Test;

import com.visionarysoftwaresolutions.hfdpch1.tddstyle.flight.FlyBehavior;
import com.visionarysoftwaresolutions.hfdpch1.tddstyle.flight.FlyWithWings;

public class FlyWithWingsTests {
	
	FlyBehavior flybehavior = new FlyWithWings();

	@Test
	public void testCorrectFlight() {
		//Given: You have a flight behavior
		//When: It is set to FlyWithWings
		//Then: The flight behavior should demonstrate the correct flight
		String expected = "I'm flying, like a boss...bird!";
		assertEquals(expected, flybehavior.fly());
	}
}
