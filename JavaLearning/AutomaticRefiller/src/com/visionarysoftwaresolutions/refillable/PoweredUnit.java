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
