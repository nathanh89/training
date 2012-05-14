package com.visionarysoftwaresolutions.refillable;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.visionarysoftwaresolutions.ordering.Manufacturer;
import com.visionarysoftwaresolutions.ordering.Order;
import com.visionarysoftwaresolutions.ordering.OrderContainer;
import com.visionarysoftwaresolutions.ordering.Orderable;

public class BottleManufacturerTests {
	Manufacturer manufacturer = new BottleManufacturer("test");
	
	@Test
	public void testFulfillOrder() {
		// Given: I have an order for 5 mountain dews and 10 blue machines
		Orderable bottle = new Bottle("mountain dew");
		OrderContainer holder = new OrderContainer(bottle, 5);
		Order newOrder = new Order(holder);
		Orderable bottle2 = new Bottle("blue machine");
		OrderContainer holder2 = new OrderContainer(bottle2, 10);
		newOrder.addContainer(holder2);
		// When: I give a Bottle Manufacturer 
		List<OrderContainer> result = manufacturer.fill(newOrder);
		// Then: It should give me back 15 bottles, 5 of which are mountain dew and 10 of which are blue machine
		assertEquals(2, result.size());
		OrderContainer dews = result.get(0);
		assertEquals("mountain dew", dews.getName());
		assertEquals(5, dews.getNumber());
		OrderContainer blues = result.get(1);
		assertEquals("blue machine", blues.getName());
		assertEquals(10, blues.getNumber());
		
	}

}
