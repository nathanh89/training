package com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.ducks;

import com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.flight.FlyBehavior;
import com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.flight.FlyNiceTry;
import com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.flight.FlyRocketPowered;
import com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.quacks.IntimidatingQuack;
import com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.quacks.MoreIntimidatingQuack;
import com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.quacks.QuackBehavior;

public class CyborgDuck extends Duck{
	
	public CyborgDuck(){
		flyBehavior = new FlyRocketPowered();
		quackBehavior = new IntimidatingQuack();
	}
	
	@Override
	public String display(){
		return "Unblinking blood-red eyes stare into your soul. You now understand fear."; 
	}
	
	@Override
	public void setFlyBehavior(FlyBehavior newFlyBehavior){
		newFlyBehavior = new FlyNiceTry();
		flyBehavior = newFlyBehavior;
	}
	
	@Override
	public void setQuackBehavior(QuackBehavior newQuackBehavior){
		newQuackBehavior = new MoreIntimidatingQuack();
		quackBehavior = newQuackBehavior;
	}
}
