package com.visionarysoftwaresolutions.ordering;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.visionarysoftwaresolutions.refillable.Bottle;
import com.visionarysoftwaresolutions.refillable.BottleManufacturer;


public class OrdererTests {
	Orderer orderer = new Orderer();
	Storable cooler = new StorageUnit(100);
	
	@Test
	public void testCreateOrder() {
		//Given I want to create a new order
		Orderable monster = new Bottle("Monster");
		orderer.createOrder(monster, 10, cooler);
		//Then the order should be created
		assertEquals(10, orderer.countProductsInOrder("Monster"));
	}
	
	@Test 
	public void testAddToOrder(){
		//Given I have an order
		Orderable monster = new Bottle("Monster");
		orderer.createOrder(monster, 10, cooler);
		//And I want to add to that order
		Orderable rockstar = new Bottle("Rockstar");
		orderer.addToOrder(rockstar, 15);
		//Then that item should be added to the order
		assertEquals(10, orderer.countProductsInOrder("Monster"));
		assertEquals(15, orderer.countProductsInOrder("Rockstar"));
	}
	
	@Test
	public void testPlaceOrder(){
		//Given I have an order that is finalized
		Orderable monster = new Bottle("Monster");
		Orderable rockstar = new Bottle("Rockstar");
		orderer.createOrder(monster, 10, cooler);
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
