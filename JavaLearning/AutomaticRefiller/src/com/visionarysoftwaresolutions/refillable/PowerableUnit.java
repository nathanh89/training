package com.visionarysoftwaresolutions.refillable;

public class PowerableUnit {

	private boolean poweredState = false;

	public PowerableUnit() {
		super();
	}

	public boolean isPowerOn() {
	    return poweredState;
	}

	public void setPowerOn(boolean powerOn) {
		poweredState = powerOn;
	}

	public void togglePower() {
	    setPowerOn(!poweredState);
	}

}