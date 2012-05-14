package com.visionarysoftwaresolutions.ordering;


public abstract class AbstractOrderable implements Orderable {
	public String name;
	public double price;

	public void setPrice(double price) {
	    this.price = price;
	}

	public double getPrice() {
	    return price;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
}