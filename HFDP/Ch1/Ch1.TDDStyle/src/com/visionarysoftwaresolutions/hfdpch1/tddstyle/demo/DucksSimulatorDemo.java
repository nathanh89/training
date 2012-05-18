package com.visionarysoftwaresolutions.hfdpch1.tddstyle.demo;

import com.visionarysoftwaresolutions.hfdpch1.tddstyle.ducks.*;

public class DucksSimulatorDemo {

	public static void main(String[] args){
		
		SharedFunctions demoFunctions = new SharedFunctions();
		CyborgDuckFunctions demoCyborg = new CyborgDuckFunctions();
		
		Duck mallard = new MallardDuck();
		Duck modelDuck = new ModelDuck();
		Duck redheadDuck = new RedheadDuck();
		Duck rubberDuck = new RubberDuck();
		
		initialProgramHeader();
		demoFunctions.allGenericFunctions(mallard);
		demoFunctions.allGenericFunctions(modelDuck);
		demoFunctions.allGenericFunctions(redheadDuck);
		demoFunctions.allGenericFunctions(rubberDuck);
		
		uniqueHeader();
		demoCyborg.allCyborgDuckFunctions();
	}
	
	private static void initialProgramHeader(){
		System.out.println("[GENERIC DUCK TYPES]");
		System.out.println("");
	}
	
	private static void uniqueHeader(){
		System.out.println("[UNIQUE DUCK TYPES]");
		System.out.println("");
	}
}