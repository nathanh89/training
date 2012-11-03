package com.visionarysoftwaresolutions.refillable;

import java.util.ArrayList;
import java.util.List;

import com.visionarysoftwaresolutions.ordering.Manufacturer;
import com.visionarysoftwaresolutions.ordering.Order;
import com.visionarysoftwaresolutions.ordering.OrderContainer;

/**
 *
 * @author nathan
 */
public class BottleManufacturer implements Manufacturer {
	private String name;
	
	public BottleManufacturer(String name) {
		setName(name);
	}

	/* (non-Javadoc)
	 * @see com.visionarysoftwaresolutions.refillable.Manufacturer#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see com.visionarysoftwaresolutions.refillable.Manufacturer#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see com.visionarysoftwaresolutions.refillable.Manufacturer#fill(com.visionarysoftwaresolutions.ordering.Order)
	 */
	@Override
	public List<OrderContainer> fill(Order newOrder) {
		List<OrderContainer> filled = new ArrayList<OrderContainer>();
		for(OrderContainer container : newOrder){
			filled.add(container);
		}
		return filled;
	}
}