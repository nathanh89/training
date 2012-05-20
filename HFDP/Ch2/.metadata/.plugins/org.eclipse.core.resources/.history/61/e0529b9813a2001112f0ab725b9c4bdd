package com.visionarysoftwaresolutions.hfdpch2.tddstyle.demo.custom;

import com.visionarysoftwaresolutions.hfdpch2.tddstyle.observers.*;

public class InputReference {
	
	public static Display createDisplayByInput(int index){
		if(index == 1){
			Display currentConditions = new Display(new CurrentConditions());
			return currentConditions;
		}
		if(index == 2){
			Display forecast = new Display(new Forecast());
			return forecast;
		}
		if(index == 3){
			Display heatIndex = new Display(new HeatIndex());
			return heatIndex;
		}
		else{
			Display statistics = new Display(new Statistics());
			return statistics;
		}
	}
}
