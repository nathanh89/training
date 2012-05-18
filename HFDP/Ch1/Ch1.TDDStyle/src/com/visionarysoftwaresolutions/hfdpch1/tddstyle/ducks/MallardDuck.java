package com.visionarysoftwaresolutions.hfdpch1.tddstyle.ducks;

import com.visionarysoftwaresolutions.hfdpch1.tddstyle.flight.FlyWithWings;
import com.visionarysoftwaresolutions.hfdpch1.tddstyle.quacks.Quack;


public class MallardDuck extends Duck{
	
	public MallardDuck(){
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}

	@Override
	public String display(){
		return "Big whoop. A mallard.";
	}
}