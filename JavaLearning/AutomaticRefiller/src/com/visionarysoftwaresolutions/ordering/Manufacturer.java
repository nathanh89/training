package com.visionarysoftwaresolutions.ordering;

import java.util.List;


public interface Manufacturer {

	public abstract String getName();

	public abstract void setName(String name);

	public abstract List<OrderContainer> fill(Order newOrder);

}