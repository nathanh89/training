package com.visionarysoftwaresolutions.refillable;

import java.util.*;

/**
 *
 * @author nathan
 */
public class Order implements Iterable<OrderContainer> {
    private Collection<OrderContainer> items;
    
    public Order(String desiredBeverage, int desiredQuantity){
    	items = new ArrayList<OrderContainer>();
    	addContainer(desiredBeverage, desiredQuantity);
    }
    
    public void addContainer(String desiredBeverage, int desiredQuantity) {
		items.add(new OrderContainer(desiredBeverage, desiredQuantity));
	}

	int getCountForName(String name) {
        return countItems(name);
	}
	
	private int countItems(String name){
		int count = 0;
        for(OrderContainer aContainer : items){
        	count += (aContainer.getName().equalsIgnoreCase(name)) ? aContainer.getNumber() : 0;
        }
        return count;
	}

	@Override
	public Iterator<OrderContainer> iterator() {
		return items.iterator();
	}
}
