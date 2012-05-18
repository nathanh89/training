package com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.simulator;

import com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.ducks.*;
import com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.flight.*;
import com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.quacks.*;

public class MiniDuckSimulator {

	public static void main(String[] args){
		
		Duck mallard = new MallardDuck();
		System.out.println(mallard.performQuack());
		System.out.println(mallard.performFly());
		
		Duck model = new ModelDuck();
		System.out.println(model.performFly());
		model.setFlyBehavior(new FlyRocketPowered());
		System.out.println(model.performFly());
	}
}
