package com.visionarysoftwaresolutions.hfdpch3.tddstyle.starbuzz.decorators;

import com.visionarysoftwaresolutions.hfdpch3.tddstyle.starbuzz.beverages.Beverage;
 
public class Whip extends CondimentDecorator {
	Beverage beverage;
 
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
 
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}
 
	public double cost() {
		return .10 + beverage.cost();
	}
}