package com.visionarysoftwaresolutions.refillable;

class Cooler implements PoweredDooredUnit {
    boolean powerOn = false;
    boolean doorOpen = false;
    
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
    
    @Override
    public boolean isDoorOpen(){
        return doorOpen;
    }

    @Override
    public void operateDoor() {
        setDoorOpen(!doorOpen);
    }

    @Override
    public void setDoorOpen(boolean b) {
        doorOpen = b;
    }
}
