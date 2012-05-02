package com.visionarysoftwaresolutions.refillable;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nathan
 */
public class OrderTests {
    
    @Test
    public void testAddToOrderSingleBottleType(){
        //Given my cooler is low in stock and needs to place a new order
        //And I am placing an order to a Manufacturer to replenish my cooler stock
       Order order = new Order();
       Bottle bottle = new Bottle("Mountain Dew");
       //When I specify the number of bottles requested in the order
       order.addBottles(bottle, 10);
       int result = order.getBeverageCountByType("Mountain Dew");
       //Then the bottles should be added to the order
       assertEquals(10, result);
        }
    
    @Test
    public void testAddtoOrderMultipleBottleType(){
        //Given my cooler is low in stock and needs to place a new order
        //And I am placing an order to a Manufacturer to replenish my cooler stock
        Order order = new Order();
        Bottle mountaindew = new Bottle("Mountain Dew");
        Bottle sierramist = new Bottle("Sierra Mist");
        //When I specify the number of bottles requested in the order
        order.addBottles(mountaindew, 15);
        order.addBottles(sierramist, 15);
        //Then the bottles should be added the order
        int mdresult = order.getBeverageCountByType("Mountain Dew");
        int smresult = order.getBeverageCountByType("Sierra Mist");
        assertEquals(15, mdresult);
        assertEquals(15, smresult);
        
    }
    
    @Test
    public void testAddtoOrderMultipleBottlesOfSameType(){
        //Given my cooler is low in stock and needs to place a new order
        //And I am placing an order to a Manufacturer to replenish my cooler stock
        Order order = new Order();
        Bottle mountaindew = new Bottle("Mountain Dew");
        Bottle moDew = new Bottle("Mountain Dew");
        //When I specify the number of bottles requested in the order
        order.addBottles(mountaindew, 15);
        order.addBottles(moDew, 15);
        //Then the bottles should be added the order
        assertEquals(30, order.getBeverageCountByType("Mountain Dew"));       
    }
    }
