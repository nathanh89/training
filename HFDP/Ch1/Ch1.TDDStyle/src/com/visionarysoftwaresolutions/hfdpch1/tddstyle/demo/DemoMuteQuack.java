package com.visionarysoftwaresolutions.hfdpch1.tddstyle.demo;

import com.visionarysoftwaresolutions.hfdpch1.tddstyle.quacks.QuackBehavior;

public class DemoMuteQuack implements QuackBehavior{
	
	public String quack(){
		return "...Really? I can't quack. Oddly I do seem to do Englsih pretty well.";
	}

}
