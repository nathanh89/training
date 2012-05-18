package com.visionarysoftwaresolutions.hfdpch1.tddstyle.ducks;

import com.visionarysoftwaresolutions.hfdpch1.tddstyle.flight.*;
import com.visionarysoftwaresolutions.hfdpch1.tddstyle.quacks.*;

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
	public String performFly(){
		String niceTry = flyBehavior.fly();
		flyBehavior = new FlyRocketPowered();
		return niceTry;
	}
	
	@Override
	public String performQuack(){
		String niceTry = quackBehavior.quack();
		quackBehavior = new IntimidatingQuack();
		return niceTry;
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
