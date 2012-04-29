package com.visionarysoftwaresolutions.refillable;

class Cooler implements PoweredUnit{
    boolean powerOn;
    
    @Override
    public boolean isPowerOn() {
        return powerOn;
    }

    @Override
    public void setPowerOn(boolean powerOn) {
        this.powerOn = powerOn;
    }

    @Override
    public void togglePower() {
        setPowerOn(!powerOn);
    }
}
