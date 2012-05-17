package com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.ducks;

import com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.flight.FlyWithWings;
import com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.quacks.Quack;


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
