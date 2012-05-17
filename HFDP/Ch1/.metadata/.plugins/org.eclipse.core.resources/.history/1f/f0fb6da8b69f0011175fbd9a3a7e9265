package com.visionarysoftwaresolutions.hfdp.ch1.tddsytle.simulator;

import com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.ducks.*;
import com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.flight.*;
import com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.quacks.*;

public class MiniDuckSimulator {

	public static void main(String[] args){
		
		Duck mallard = new MallardDuck();
		mallard.performQuack();
		mallard.performFly();
		
		Duck model = new ModelDuck();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
	}
}
