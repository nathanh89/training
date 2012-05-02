package com.visionarysoftwaresolutions.refillable;

import java.util.*;

/**
 *
 * @author nathan
 */
public class Order {
    private HashMap<Bottle,Integer> items = new LinkedHashMap<Bottle, Integer>();
    
    public void addBottles(Bottle beverage, int desired) {
        int previousEntry = 0;
        if(items.containsKey(beverage)){
            previousEntry = items.get(beverage);
        }
        items.put(beverage, desired+previousEntry);
    }       
        
   int getBeverageCountByType(String beverage) {
        return items.get(new Bottle(beverage));
    }   
}
