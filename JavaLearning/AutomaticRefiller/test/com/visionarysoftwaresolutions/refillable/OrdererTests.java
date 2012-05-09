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
	
	@Test 
	public void testAddToOrder(){
		//Given I have an order
		Orderer orderer = new Orderer();
		orderer.createOrder("Monster", 10);
		//And I want to add to that order
		orderer.addToOrder("Rockstar", 15);
		//Then that item should be added to the order
		assertEquals(10, orderer.checkOrder("Monster"));
		assertEquals(15, orderer.checkOrder("Rockstar"));
	}
	
	@Test
	public void testPlaceOrder(){
		//Given I have an order that is finalized
		Orderer orderer = new Orderer();
		orderer.createOrder("Monster", 10);
		orderer.addToOrder("Rockstar", 15);
		//When I want to place that order
		Cooler cooler = new Cooler(100);
		orderer.placeOrder("Energy Drinks Inc", cooler);
		//Then that order should be filled
		assertEquals(10, cooler.getBeverageCountByType("Monster"));
		assertEquals(15, cooler.getBeverageCountByType("Rockstar"));
	}

}