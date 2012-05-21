package com.visionarysoftwaresolutions.hfdpch3.tddstyle.starbuzz.decorators;

import com.visionarysoftwaresolutions.hfdpch3.tddstyle.starbuzz.beverages.Beverage;

public class Milk extends CondimentDecorator {
	Beverage beverage;

	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Milk";
	}

	public double cost() {
		return .10 + beverage.cost();
	}
}