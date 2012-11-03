package com.visionarysoftwaresolutions.ordering;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.visionarysoftwaresolutions.refillable.Bottle;
import com.visionarysoftwaresolutions.refillable.BottleManufacturer;


public class OrdererTests {
	Storable cooler = new StorageUnit(100);
	Orderer orderer = new Orderer(cooler);
	Orderable monster = new Bottle("Monster");
	
	@Test
	public void testCreateOrder() {
		//Given I want to create a new order
		orderer.createOrder(monster, 10);
		//Then the order should be created
		assertEquals(10, orderer.countProductsInOrder("Monster"));
	}
	
	@Test 
	public void testAddToOrder(){
		//Given I have an order
		orderer.createOrder(monster, 10);
		//And I want to add to that order
		Orderable rockstar = new Bottle("Rockstar");
		orderer.addToOrder(rockstar, 15);
		//Then that item should be added to the order
		assertEquals(10, orderer.countProductsInOrder("Monster"));
		assertEquals(15, orderer.countProductsInOrder("Rockstar"));
	}
	
	@Test(expected=RuntimeException.class)
	public void testOverCapacityOrderVetoAtCreation(){
		//Given I have an empty cooler with a capacity of 100
		//And I want to place an order that would cause the cooler to be over-capacity
		orderer.createOrder(monster, 105);
	}
	
	@Test(expected=RuntimeException.class)
	public void testOverCapacityOrderVetoWhenAdding(){
		//Given I have an empty cooler and a capacity of 100
		//And I have created an order
		orderer.createOrder(monster, 10);
		//When I add to the order an amount that would cause the cooler to go over capacity
		orderer.addToOrder(monster, 91);
		//Then the order should be vetoed
	}
	
	@Test
	public void testPlaceOrder(){
		//Given I have an order that is finalized
		orderer.createOrder(monster, 10);
		Orderable rockstar = new Bottle("Rockstar");
		orderer.addToOrder(rockstar, 15);
		//When I want to place that order
		Manufacturer collaborator = new BottleManufacturer("Energy Drinks Inc");
		List<OrderContainer> toStock = orderer.placeOrder(collaborator);
		//Then that order should be filled
		assertEquals(2, toStock.size());
		OrderContainer monsterContainer = toStock.get(0); 
		assertEquals(10, monsterContainer.getNumber());
		assertEquals("Monster", monsterContainer.getName());
		OrderContainer rockstarContainer = toStock.get(1); 
		assertEquals(15, rockstarContainer.getNumber());
		assertEquals("Rockstar", rockstarContainer.getName());
	}
}
