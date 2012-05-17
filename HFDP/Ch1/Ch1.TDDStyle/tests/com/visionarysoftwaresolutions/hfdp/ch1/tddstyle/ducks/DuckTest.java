package com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.ducks;

public class DuckTest {
	
	private static String expectedSwim = "All ducks float, even decoys!";
	
	public static boolean inheritedSwim(Duck duck){
		String result = duck.swim();
		return (result == expectedSwim);
	}
	
	public static boolean flyBehavior(Duck duck, String expected){
		String result = duck.performFly();
		return (result == expected);
	}
	
	public static boolean quackBehavior(Duck duck, String expected){
		String result = duck.performQuack();
		return (result == expected);
	}
	
	public static boolean displayImplementation(Duck duck, String expected){
		String result = duck.display();
		return (result == expected);
	}
}
