/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.visionarysoftwaresolutions.refillable;

/**
 *
 * @author nathan
 */
public interface PoweredUnit {
    boolean isPowerOn();
    void setPowerOn(boolean powerOn);
    void togglePower();
}
