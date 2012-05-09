package com.visionarysoftwaresolutions.refillable;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrdererTests {

	@Test
	public void testCreateOrder() {
		Orderer orderer = new Orderer();
		//Given I want to create a new order
		orderer.createOrder("Monster", 10);
		//Then the order should be created
		assertEquals(10, orderer.checkOrder("Monster"));
	}

}
