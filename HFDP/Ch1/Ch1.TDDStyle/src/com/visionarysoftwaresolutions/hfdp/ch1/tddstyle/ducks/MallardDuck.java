package com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.ducks;

import com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.flight.FlyWithWings;
import com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.quacks.Quack;


public class MallardDuck extends Duck{
	
	public MallardDuck(){
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}

	@Override
	public void display(){
		System.out.println("I'm a real Mallard Duck!");
	}
	
}
