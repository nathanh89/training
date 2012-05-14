package com.visionarysoftwaresolutions.refillable;

import com.visionarysoftwaresolutions.refillable.interfaces.Powerable;

public class PowerableUnit implements Powerable {

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