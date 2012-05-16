package com.visionarysoftwaresolutions.hfdp.ch2.weatherstation;

public class Display {
	ObservingDisplay currentDisplay;
	
	public Display(ObservingDisplay displayToUse){
		currentDisplay = displayToUse;
	}
	
	public ObservingDisplay getCurrentDisplay(){
		return currentDisplay;
	}
	
}
