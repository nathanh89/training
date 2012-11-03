package com.visionarysoftwaresolutions.ordering;

import java.util.List;

public class Orderer {
	private Order pending;
	private Storable deliverable;
	
	public Orderer(Storable deliverTo){
		deliverable = deliverTo;
	}
	public void createOrder(){
		pending = new Order();
	}

	public void createOrder(Orderable product, int productQuantity) {
		deliverable.checkNotMoreThanCapacity(productQuantity);
		OrderContainer toHold = new OrderContainer(product, productQuantity);
		pending = new Order(toHold);		
	}
	
	public Order checkOrder(){
		return pending;
	}
	
	public int countProductsInOrder(String product){
		return pending.getCountForName(product);
	}

	public void addToOrder(Orderable ordered, int productQuantity) {
		int newDesired = productQuantity+pending.getCountForName(ordered.getName());
		deliverable.checkNotMoreThanCapacity(newDesired);
		OrderContainer container = new OrderContainer(ordered, productQuantity);
		pending.addContainer(container);
	}

	public List<OrderContainer> placeOrder(Manufacturer manny) {
		int totalSize = 0;
		for(OrderContainer container : pending){
			totalSize += container.getNumber();
		}
		deliverable.checkNotMoreThanCapacity(totalSize);
		return manny.fill(pending); 
	}
}