package com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.quacks;

public class Quack implements QuackBehavior{
	
	@Override
	public String quack(){
		return "Quack fo' rizzle, bitches!";
	}
}