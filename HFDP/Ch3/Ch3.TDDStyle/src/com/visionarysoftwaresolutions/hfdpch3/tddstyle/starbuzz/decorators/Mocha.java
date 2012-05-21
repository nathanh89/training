package com.visionarysoftwaresolutions.hfdpch3.tddstyle.starbuzz.decorators;

import com.visionarysoftwaresolutions.hfdpch3.tddstyle.starbuzz.beverages.Beverage;

public class Mocha extends CondimentDecorator {
	Beverage beverage;
 
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
 
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}
 
	public double cost() {
		return .20 + beverage.cost();
	}
}