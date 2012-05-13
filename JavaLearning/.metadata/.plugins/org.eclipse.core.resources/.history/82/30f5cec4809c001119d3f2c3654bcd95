package com.visionarysoftwaresolutions.refillable;

public class StorageUnit extends PowerableUnit implements StorageUnitInterface{

	private boolean doorOpen = false;

	public StorageUnit() {
		super();
	}

	@Override
	public boolean isDoorOpen() {
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