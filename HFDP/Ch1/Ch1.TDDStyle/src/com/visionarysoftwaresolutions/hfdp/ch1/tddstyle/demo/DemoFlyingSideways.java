package com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.demo;

import com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.flight.FlyBehavior;

public class DemoFlyingSideways implements FlyBehavior{

	@Override
	public String fly(){
		return "Sideways flight? Where are your physics?!";
	}
}
