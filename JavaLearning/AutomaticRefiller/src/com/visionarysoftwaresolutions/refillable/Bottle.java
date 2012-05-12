package com.visionarysoftwaresolutions.refillable;

import java.util.Objects;


/**
 *
 * @author nathan
 */
public class Bottle extends Consumable {
	
    final String containedBeverage;
    
    public Bottle(String beverageName){
        containedBeverage = beverageName;
    }
    
    public String getBeverageName(){
        return containedBeverage;
    }

	@Override
	public boolean equals(Object another) {
	    if (!(another instanceof Bottle)){
	        return false;
	    }
	    Bottle toCompare = (Bottle) another;
	    return getBeverageName().equalsIgnoreCase(toCompare.getBeverageName()) &&
	           getPrice() == toCompare.getPrice();
	}

	@Override
	public int hashCode() {
	    int hash = 3;
	    hash = 59 * hash + Objects.hashCode(this.containedBeverage);
	    hash = 59 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
	    return hash;
	}
}
