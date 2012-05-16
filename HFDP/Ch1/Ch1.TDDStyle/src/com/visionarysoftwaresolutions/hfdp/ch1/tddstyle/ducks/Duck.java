package com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.ducks;

import com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.flight.FlyBehavior;
import com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.quacks.QuackBehavior;


public abstract class Duck {
	
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	
	public Duck(){
		
	}
	
	public void swim(){
		System.out.println("All ducks float, even decoys!");
	}
	
	public abstract void display();
	
	public void performQuack(){
		quackBehavior.quack();
	}
	
	public void performFly(){
		flyBehavior.fly();
	}
	
	public void setFlyBehavior(FlyBehavior newFlyBehavior){
		flyBehavior = newFlyBehavior;
	}
	
	public void setQuackBehavior(QuackBehavior newQuackBehavior){
		quackBehavior = newQuackBehavior;
	}
}
