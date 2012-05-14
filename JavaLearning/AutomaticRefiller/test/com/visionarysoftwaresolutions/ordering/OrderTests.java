package com.visionarysoftwaresolutions.ordering;

import org.junit.Test;

import com.visionarysoftwaresolutions.refillable.Bottle;

import static org.junit.Assert.*;

/**
 *
 * @author nathan
 */
public class OrderTests {
	Orderable mtDew = new Bottle("Mountain Dew");
	OrderContainer holder = new OrderContainer(mtDew, 10);
	Order order = new Order(holder);
	
    @Test
    public void testAddToOrderSingleBottleType(){
        //Given my cooler is low in stock and needs to place a new order
        //And I am placing an order to a Manufacturer to replenish my cooler stock
       
       //When I specify the number of bottles requested in the order
       int result = order.getCountForName("Mountain Dew");
       //Then the bottles should be added to the order
       assertEquals(10, result);
        }
    
    @Test
    public void testAddtoOrderMultipleBottleType(){
        //Given my cooler is low in stock and needs to place a new order
        //And I am placing an order to a Manufacturer to replenish my cooler stock
        //When I specify the number of bottles requested in the order
        OrderContainer toAdd = new OrderContainer(new Bottle("Sierra Mist"), 15);
    	order.addContainer(toAdd);
        //Then the bottles should be added the order
        int mdresult = order.getCountForName("Mountain Dew");
        int smresult = order.getCountForName("Sierra Mist");
        assertEquals(10, mdresult);
        assertEquals(15, smresult);
        
    }
    
    @Test
    public void testAddtoOrderMultipleBottlesOfSameType(){
        //Given my cooler is low in stock and needs to place a new order
        //And I am placing an order to a Manufacturer to replenish my cooler stock
        //When I specify the number of bottles requested in the order
    	OrderContainer toAdd = new OrderContainer(new Bottle("Mountain Dew"), 20);
    	order.addContainer(toAdd);
        //Then the bottles should be added the order
        assertEquals(30, order.getCountForName("Mountain Dew"));       
    }
    }
