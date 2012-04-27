package com.visionarysoftwaresolutions.refillable;

class Cooler {
    private boolean powerOn = false;

    public boolean isPowerOn() {
        return powerOn;
    }

    public void setPowerOn(boolean powerOn) {
        this.powerOn = powerOn;
    }

    void togglePower() {
        setPowerOn(!powerOn);
    }
}
