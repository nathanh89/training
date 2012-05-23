package com.visionarysoftwaresolutions.hfdpch7.bookstyle.turducken;

public class DuckTestDrive {
	
	public static void main(String[] args){
		
		MallardDuck duck = new MallardDuck();
		WildTurkey turkey = new WildTurkey();
		Duck turkeyAdapter = new TurkeyAdapter(turkey);
		
		System.out.println("The turkey says:");
		turkey.gobble();
		turkey.fly();
		
		System.out.println("\nAnd the duck says:");
		testDuck(duck);
		
		System.out.println("\nThe Turduck says:");
		testDuck(turkeyAdapter);
	}
	
	static void testDuck(Duck duck){
		duck.quack();
		duck.fly();
	}
}
