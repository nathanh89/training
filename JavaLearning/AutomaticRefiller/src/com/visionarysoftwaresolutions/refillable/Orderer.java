package com.visionarysoftwaresolutions.refillable;

public class Orderer {
	
	private Order pending;

	public void createOrder(String productName, int productQuantity) {
		pending = new Order(productName, productQuantity);		
	}
	
	public int checkOrder(String productName){
		return pending.getCountForName(productName);
	}

}
