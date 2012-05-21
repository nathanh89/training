package com.visionarysoftwaresolutions.hfdpch3.tddstyle.starbuzz.beverages;

public abstract class Beverage {
	
	String description = "Unknown Beverage";
	
	public String getDescription(){
		return description;
	}
	
	public abstract double cost();

}
