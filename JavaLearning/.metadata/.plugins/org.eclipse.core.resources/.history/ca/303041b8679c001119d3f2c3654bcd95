package com.visionarysoftwaresolutions.refillable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nathan
 */
public class BottleManufacturer {
	private String name;
	
	public BottleManufacturer(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Bottle> fill(Order newOrder) {
		List<Bottle> result = new ArrayList<Bottle>();
		for(OrderContainer container : newOrder){
			List<Bottle> items = container.make();
			for(Bottle anItem : items){
				result.add((Bottle)anItem);
			}
		}
		return result;
	}
}