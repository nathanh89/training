package com.visionarysoftwaresolutions.refillable;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class BottleManufacturerTests {
	BottleManufacturer manufacturer = new BottleManufacturer("test");
	
	@Test
	public void testFulfillOrder() {
		// Given: I have an order for 5 mountain dews and 10 blue machines
		Order newOrder = new Order("mountain dew", 5);
		newOrder.addContainer("blue machine", 10);
		// When: I give a Bottle Manufacturer 
		List<Bottle> result = manufacturer.fill(newOrder);
		// Then: It should give me back 15 bottles, 5 of which are mountain dew and 10 of which are blue machine
		assertEquals(15, result.size());
		
	}

}
