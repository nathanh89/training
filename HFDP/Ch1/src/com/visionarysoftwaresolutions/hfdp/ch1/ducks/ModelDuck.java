package com.visionarysoftwaresolutions.hfdp.ch1.ducks;

import com.visionarysoftwaresolutions.hfdp.ch1.flight.*;
import com.visionarysoftwaresolutions.hfdp.ch1.quacks.*;

public class ModelDuck extends Duck{

	public ModelDuck(){
		flyBehavior = new FlyNoWay();
		quackBehavior = new Quack();
	}
	
	public void display(){
		System.out.println("I'm a model duck. A souless golem.");
	}
}
