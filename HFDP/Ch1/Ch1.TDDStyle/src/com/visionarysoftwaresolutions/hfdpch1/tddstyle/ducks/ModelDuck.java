package com.visionarysoftwaresolutions.hfdpch1.tddstyle.ducks;

import com.visionarysoftwaresolutions.hfdpch1.tddstyle.flight.FlyNoWay;
import com.visionarysoftwaresolutions.hfdpch1.tddstyle.quacks.Quack;

public class ModelDuck extends Duck{

	public ModelDuck(){
		flyBehavior = new FlyNoWay();
		quackBehavior = new Quack();
	}
	
	@Override
	public String display(){
		return "I'm a model duck. A soulless golem.";
	}
}