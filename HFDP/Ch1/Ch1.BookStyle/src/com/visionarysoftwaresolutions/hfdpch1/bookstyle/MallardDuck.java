package com.visionarysoftwaresolutions.hfdpch1.bookstyle;


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
