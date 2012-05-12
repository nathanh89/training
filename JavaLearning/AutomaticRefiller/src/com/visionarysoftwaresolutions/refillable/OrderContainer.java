package com.visionarysoftwaresolutions.refillable;

import java.util.ArrayList;
import java.util.List;

public class OrderContainer {
	private int number;
	private Bottle item;
	
	public OrderContainer(String desiredBeverage, int desiredQuantity) {
		setNumber(desiredQuantity);
		setItem(new Bottle(desiredBeverage));
	}
	public Consumable getItem() {
		return item;
	}
	
	public String getName(){
		return item.getBeverageName();
	}
	
	public void setItem(Bottle item) {
		this.item = item;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public List<Bottle> make(){
		List<Bottle> result = new ArrayList<Bottle>();
		for(int i=0; i< number; i++){
			result.add(item);
		}
		return result;
	}
}
