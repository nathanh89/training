package com.visionarysoftwaresolutions.refillable;

import java.util.Objects;

/**
 *
 * @author nathan
 */
public class Bottle implements Orderable {
    private final String name;
    public double price;
    
    public Bottle(String beverageName){
        this.name = beverageName;
    }
    
    public void setBeveragePrice(double beveragePrice){
        this.price = beveragePrice;
    }

    @Override
	public String getName(){
        return name;
    }
    
    public double getBeverageValue(){
        return price;
    }
    
    @Override
    public boolean equals(Object another){
        if (!(another instanceof Bottle)){
            return false;
        }
        Bottle toCompare = (Bottle) another;
        return getName().equalsIgnoreCase(toCompare.getName()) &&
               getBeverageValue() == toCompare.getBeverageValue();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        return hash;
    }
}
