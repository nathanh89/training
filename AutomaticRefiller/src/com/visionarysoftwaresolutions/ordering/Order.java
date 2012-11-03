package com.visionarysoftwaresolutions.ordering;

import java.util.*;

/**
 *
 * @author nathan
 */
public class Order implements Iterable<OrderContainer> {
    private Collection<OrderContainer> items;
    
    public Order(){
    }
    
    public Order(OrderContainer container){
    	items = new ArrayList<OrderContainer>();
    	addContainer(container);
    }
    
    public void addContainer(OrderContainer container) {
		items.add(container);
	}

	public int getCountForName(String name) {
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
