package com.visionarysoftwaresolutions.refillable;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nathan
 */
public class OrderTests {
	Order order = new Order("Mountain Dew", 10 );
	
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
        order.addContainer("Sierra Mist", 15);
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
        order.addContainer("Mountain Dew", 20);
        //Then the bottles should be added the order
        assertEquals(30, order.getCountForName("Mountain Dew"));       
    }
    }
