package com.visionarysoftwaresolutions.refillable;

import java.util.List;

import com.visionarysoftwaresolutions.ordering.OrderContainer;
import com.visionarysoftwaresolutions.ordering.Orderable;
import com.visionarysoftwaresolutions.ordering.Storable;

public class UnmotivatedStoner {
	public void stock(List<OrderContainer> containers, Storable storage) {
		for(OrderContainer container : containers){
			List<Orderable> items = container.make();
			for(Orderable anItem : items){
				storage.add((Bottle)anItem);
			}
		}
	}
}
