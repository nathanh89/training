package com.visionarysoftwaresolutions.hfdpch1.tddstyle.demo;

import com.visionarysoftwaresolutions.hfdpch1.tddstyle.flight.FlyBehavior;

public class DemoFlyingSideways implements FlyBehavior{

	@Override
	public String fly(){
		return "Sideways flight? Where are your physics?!";
	}
}
