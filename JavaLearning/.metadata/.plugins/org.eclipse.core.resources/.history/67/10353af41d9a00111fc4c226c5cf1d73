package com.visionarysoftwaresolutions.refillable;

public class Orderer {
	
	private Order pending;
	
	public void createOrder(){
	}

	public void createOrder(String productName, int productQuantity, Cooler deliverTo) {
		deliverTo.checkNotMoreThanCapacity(productQuantity);
		pending = new Order(productName, productQuantity);		
	}
	
	public Order checkOrder(){
		return pending;
	}
	
	public int checkOrderByProductName(String productName){
		return pending.getCountForName(productName);
	}

	public void addToOrder(String productName, int productQuantity, Cooler deliverTo) {
		pending.addContainer(productName, productQuantity);
	}

	public void placeOrder(String manufacturer, Cooler deliverTo) {
		BottleManufacturer orderFiller = new BottleManufacturer(manufacturer);
		deliverTo.addBottles(orderFiller.fill(pending));
	}

}
