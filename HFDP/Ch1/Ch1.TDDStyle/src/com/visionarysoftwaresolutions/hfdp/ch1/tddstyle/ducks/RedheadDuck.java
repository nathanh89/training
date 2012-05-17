package com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.ducks;

import com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.flight.FlyWithWings;
import com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.quacks.GingerQuack;

public class RedheadDuck extends Duck{
	
	public RedheadDuck(){
		flyBehavior = new FlyWithWings();
		quackBehavior = new GingerQuack();
	}
	
	@Override
	public String display(){
		return "I'm a Ginger duck. Be afraid.";
	}
}
