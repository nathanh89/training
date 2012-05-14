package com.visionarysoftwaresolutions.ordering;

import com.visionarysoftwaresolutions.refillable.interfaces.Doored;


public interface Storable extends Doored {

	public abstract int getPercentFull();

	public abstract void setCapacity(int desired);

	public abstract int getCapacity();

	public abstract void checkNotMoreThanCapacity(int desired)
			throws RuntimeException;

	public abstract void add(Orderable item);
	public abstract void remove(Orderable item);

}