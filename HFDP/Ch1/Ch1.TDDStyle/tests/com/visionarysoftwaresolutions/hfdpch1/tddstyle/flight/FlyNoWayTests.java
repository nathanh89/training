package com.visionarysoftwaresolutions.hfdpch1.tddstyle.flight;

import static org.junit.Assert.*;

import org.junit.Test;

import com.visionarysoftwaresolutions.hfdpch1.tddstyle.flight.FlyBehavior;
import com.visionarysoftwaresolutions.hfdpch1.tddstyle.flight.FlyNoWay;

public class FlyNoWayTests {
	
	FlyBehavior flybehavior = new FlyNoWay();

	@Test
	public void testCorrectFlight() {
		//Given: You have a flight behavior
		//When: It is set to FlyNoWay
		//Then: The flight behavior should demonstrate the correct flight
		String expected = "Do these wings look like they work? Jackass.";
		assertEquals(expected, flybehavior.fly());
	}
}