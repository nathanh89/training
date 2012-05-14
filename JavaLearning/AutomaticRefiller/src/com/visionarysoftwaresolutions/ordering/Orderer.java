package com.visionarysoftwaresolutions.ordering;

import java.util.List;

public class Orderer {
	
	private Order pending;
	
	public void createOrder(){
		pending = new Order();
	}

	public void createOrder(Orderable product, int productQuantity, Storable deliverTo) {
		deliverTo.checkNotMoreThanCapacity(productQuantity);
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
		OrderContainer container = new OrderContainer(ordered, productQuantity);
		pending.addContainer(container);
	}

	public List<OrderContainer> placeOrder(Manufacturer manny) {
		return manny.fill(pending); 
	}

}