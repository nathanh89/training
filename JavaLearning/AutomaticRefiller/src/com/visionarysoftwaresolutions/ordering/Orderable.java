package com.visionarysoftwaresolutions.ordering;

public interface Orderable {
	public abstract void setName(String name);
	public abstract String getName();
	public abstract void setPrice(double price);
	public abstract double getPrice();
}