package com.visionarysoftwaresolutions.hfdpch2.tddstyle.observers;

public class Display {
	ObservingDisplay currentDisplay;
	
	public Display(ObservingDisplay displayToUse){
		currentDisplay = displayToUse;
	}
	
	public ObservingDisplay getCurrentDisplay(){
		return currentDisplay;
	}
	
}
