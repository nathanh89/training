package com.visionarysoftwaresolutions.refillable;

import java.util.Objects;

/**
 *
 * @author nathan
 */
public class Bottle {
    private final String beverageName;
    public double beveragePrice;
    
    public Bottle(String beverageName){
        this.beverageName = beverageName;
    }
    
    public void setBeveragePrice(double beveragePrice){
        this.beveragePrice = beveragePrice;
    }
    
    public String getBeverageName(){
        return beverageName;
    }
    
    public double getBeverageValue(){
        return beveragePrice;
    }
    
    @Override
    public boolean equals(Object another){
        if (!(another instanceof Bottle)){
            return false;
        }
        Bottle toCompare = (Bottle) another;
        return getBeverageName().equalsIgnoreCase(toCompare.getBeverageName()) &&
               getBeverageValue() == toCompare.getBeverageValue();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.beverageName);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.beveragePrice) ^ (Double.doubleToLongBits(this.beveragePrice) >>> 32));
        return hash;
    }
}
