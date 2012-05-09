package com.visionarysoftwaresolutions.refillable;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrdererTests {

	@Test
	public void testCreateOrder() {
		Orderer orderer = new Orderer();
		Cooler cooler = new Cooler(100);
		//Given I want to create a new order
		orderer.createOrder("Monster", 10, cooler);
		//Then the order should be created
		assertEquals(10, orderer.checkOrderByProductName("Monster"));
	}
	
	@Test 
	public void testAddToOrder(){
		//Given I have an order
		Orderer orderer = new Orderer();
		Cooler cooler = new Cooler(100);
		orderer.createOrder("Monster", 10, cooler);
		//And I want to add to that order
		orderer.addToOrder("Rockstar", 15, cooler);
		//Then that item should be added to the order
		assertEquals(10, orderer.checkOrderByProductName("Monster"));
		assertEquals(15, orderer.checkOrderByProductName("Rockstar"));
	}
	
	@Test
	public void testPlaceOrder(){
		//Given I have an order that is finalized
		Orderer orderer = new Orderer();
		Cooler cooler = new Cooler(100);
		orderer.createOrder("Monster", 10, cooler);
		orderer.addToOrder("Rockstar", 15, cooler);
		//When I want to place that order
		orderer.placeOrder("Energy Drinks Inc", cooler);
		//Then that order should be filled
		assertEquals(10, cooler.getBottleCountByBeverage("Monster"));
		assertEquals(15, cooler.getBottleCountByBeverage("Rockstar"));
	}

}
