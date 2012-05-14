package com.visionarysoftwaresolutions.ordering;

import java.util.ArrayList;
import java.util.List;

public class OrderContainer {
	private int number;
	private Orderable item;
	
	public OrderContainer(Orderable ordered, int desiredQuantity) {
		setNumber(desiredQuantity);
		setItem(ordered);
	}
	
	public String getName(){
		return item.getName();
	}
	
	public void setItem(Orderable item) {
		this.item = item;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public List<Orderable> make(){
		List<Orderable> result = new ArrayList<Orderable>();
		for(int i=0; i< number; i++){
			result.add(item);
		}
		return result;
	}
}
