package com.visionarysoftwaresolutions.refillable;

public class PowerableUnit implements PowerableUnitInterface {

	private boolean poweredState = false;

	public PowerableUnit() {
		super();
	}

	@Override
	public boolean isPowerOn() {
	    return poweredState;
	}

	@Override
	public void setPowerOn(boolean powerOn) {
		poweredState = powerOn;
	}

	@Override
	public void togglePower() {
	    setPowerOn(!poweredState);
	}

}