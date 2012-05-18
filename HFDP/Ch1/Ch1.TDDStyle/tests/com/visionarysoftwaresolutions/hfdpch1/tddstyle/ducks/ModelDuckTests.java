package com.visionarysoftwaresolutions.hfdpch1.tddstyle.ducks;

import static org.junit.Assert.*;
import org.junit.*;
import com.visionarysoftwaresolutions.hfdpch1.tddstyle.ducks.Duck;
import com.visionarysoftwaresolutions.hfdpch1.tddstyle.ducks.ModelDuck;
import com.visionarysoftwaresolutions.hfdpch1.tddstyle.flight.*;
import com.visionarysoftwaresolutions.hfdpch1.tddstyle.quacks.*;
import com.visionarysoftwaresolutions.hfdpch1.tddstyle.testhelpers.DuckTester;

public class ModelDuckTests {
	
	private Duck modelDuck;
			
	@Before
	public void setup(){
	    modelDuck = new ModelDuck();
	 }

	@Test
	public void testInheritedSwim() {
		//Given: A Model duck
		//When: It swims using the inherited swim method
		//Then: It should demonstrate the correct swim behavior
		assertTrue(DuckTester.inheritedSwim(modelDuck));
	}
	
	@Test
	public void testDefaultFlyBehavior(){
		//Given: A Model duck
		//And: It has default flight behavior set by the constructor
		//When: The Model duck is asked to fly
		//Then: It should demonstrate the correct flight behavior
		String expected = "Do these wings look like they work? Jackass.";
		assertTrue(DuckTester.flyBehavior(modelDuck, expected));
	}
	
	@Test
	public void testDefaultQuackBehavior(){
		//Given: A Model duck
		//And: It has default quacking behavior set by the constructor
		//When: The Model duck is asked to quack
		//Then: It should demonstrate the correct quacking behavior
		String expected = "Quack fo' rizzle, bitches!";
		assertTrue(DuckTester.quackBehavior(modelDuck, expected));
	}
	
	@Test
	public void testCustomFlyBehavior(){
		//Given: A Model duck
		//And: I want to change the flight behavior at runtime from its default
		//When: The flight behavior is changed
		modelDuck.setFlyBehavior(new FlyRocketPowered());
		//And: The Model duck is asked to fly
		//Then: It should demonstrate the new correct flight behavior
		String expected = "Ass rocket ahoy! For Zephram!";
		assertTrue(DuckTester.flyBehavior(modelDuck, expected));
	}
	
	@Test
	public void testCustomQuackBehavior(){
		//Given: A Model duck
		//And: I want to change the quacking behavior at runtime from its default
		//When: The quacking behavior is changed
		modelDuck.setQuackBehavior(new Squeak());
		//And: The Model duck is asked to quack
		//Then: It should demonstrate the new correct quacking behavior
		String expected = "Squeak? And I'm a 'duck'? Odd.";
		assertTrue(DuckTester.quackBehavior(modelDuck, expected));
	}
	
	@Test
	public void testCustomDisplayImplementation(){
		//Given: A Model duck
		//When: I want to display it
		//Then: It should display correctly using its own implementation
		String expected = "I'm a model duck. A soulless golem.";
		assertTrue(DuckTester.displayImplementation(modelDuck, expected));
	}
}
