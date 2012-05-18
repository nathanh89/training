package com.visionarysoftwaresolutions.hfdpch1.tddstyle.demo;

import com.visionarysoftwaresolutions.hfdpch1.tddstyle.ducks.CyborgDuck;

public class CyborgDuckFunctions {

	public void allCyborgDuckFunctions(){
		CyborgDuck demoCyborgDuck = new CyborgDuck();
		System.out.println("--CyborgDuck Functions--");
		SharedFunctions.displayFunction(demoCyborgDuck);
		SharedFunctions.swimFunction(demoCyborgDuck);
		SharedFunctions.quackFunction(demoCyborgDuck);
		SharedFunctions.flyFunction(demoCyborgDuck);
		System.out.println("*Cyborg Duck Rejects Change!*");
		SharedFunctions.newQuackFunction(demoCyborgDuck);
		SharedFunctions.quackFunction(demoCyborgDuck);
		System.out.println("*Cyborg Duck Rejects Change!*");
		SharedFunctions.newFlyFunction(demoCyborgDuck);
		SharedFunctions.flyFunction(demoCyborgDuck);
	}
}
