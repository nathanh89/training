package com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.ducks;

import static org.junit.Assert.*;
import org.junit.*;
import com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.flight.*;
import com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.quacks.*;

public class MallardTests {
	
	private Duck mallard;
			
	@Before
	public void setup(){
	    mallard = new MallardDuck();
	 }

	@Test
	public void testInheritedSwim() {
		//Given: A Mallard duck
		//When: It swims using the inherited swim method
		//Then: It should demonstrate the correct swim behavior
		assertTrue(DuckTest.inheritedSwim(mallard));
	}
	
	@Test
	public void testDefaultFlyBehavior(){
		//Given: A Mallard duck
		//And: It has default flight behavior set by the constructor
		//When: The Mallard is asked to fly
		//Then: It should demonstrate the correct flight behavior
		String expected = "I'm flying, like a boss...bird!";
		assertTrue(DuckTest.flyBehavior(mallard, expected));
	}
	
	@Test
	public void testDefaultQuackBehavior(){
		//Given: A Mallard duck
		//And: It has default quacking behavior set by the constructor
		//When: The Mallard is asked to quack
		//Then: It should demonstrate the correct quacking behavior
		String expected = "Quack fo' rizzle, bitches!";
		assertTrue(DuckTest.quackBehavior(mallard, expected));
	}
	
	@Test
	public void testCustomFlyBehavior(){
		//Given: A Mallard duck
		//And: I want to change the flight behavior at runtime from its default
		//When: The flight behavior is changed
		mallard.setFlyBehavior(new FlyRocketPowered());
		//And: The Mallard is asked to fly
		//Then: It should demonstrate the new correct flight behavior
		String expected = "Ass rocket ahoy! For Zephram!";
		assertTrue(DuckTest.flyBehavior(mallard, expected));
	}
	
	@Test
	public void testCustomQuackBehavior(){
		//Given: A Mallard duck
		//And: I want to change the quacking behavior at runtime from its default
		//When: The quacking behavior is changed
		mallard.setQuackBehavior(new Squeak());
		//And: The Mallard is asked to quack
		//Then: It should demonstrate the new correct quacking behavior
		String expected = "Squeak? And I'm a 'duck'? Odd.";
		assertTrue(DuckTest.quackBehavior(mallard, expected));
	}
	
	@Test
	public void testCustomDisplayImplementation(){
		//Given: A Mallard duck
		//When: I want to display it
		//Then: It should display correctly using its implementation
		String expected = "Big whoop. A mallard.";
		assertTrue(DuckTest.displayImplementation(mallard, expected));
	}
}
