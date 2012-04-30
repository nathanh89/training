/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.visionarysoftwaresolutions.refillable;

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
    
}
