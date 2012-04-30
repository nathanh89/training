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
    
    public Bottle(String beverageName){
        this.beverageName = beverageName;
    }
    
    public String getBeverageName(){
        return beverageName;
    }
    
}
