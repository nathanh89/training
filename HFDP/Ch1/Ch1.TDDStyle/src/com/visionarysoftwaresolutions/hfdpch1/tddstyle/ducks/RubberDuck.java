package com.visionarysoftwaresolutions.hfdpch1.tddstyle.ducks;

import com.visionarysoftwaresolutions.hfdpch1.tddstyle.flight.FlyNoWay;
import com.visionarysoftwaresolutions.hfdpch1.tddstyle.quacks.Squeak;

public class RubberDuck extends Duck{
	
	public RubberDuck(){
		flyBehavior = new FlyNoWay();
		quackBehavior = new Squeak();
	}
	
	@Override
	public String display(){
		return "Burt's always invading my bathtime with Ernie...";
	}
}
