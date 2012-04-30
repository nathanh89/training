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
    public double beverageValue;
    
    public Bottle(String beverageName, double beverageValue){
        this.beverageName = beverageName;
        this.beverageValue = beverageValue;
    }
    
    public String getBeverageName(){
        return beverageName;
    }
    
    public double getBeverageValue(){
        return beverageValue;
    }
    
}
