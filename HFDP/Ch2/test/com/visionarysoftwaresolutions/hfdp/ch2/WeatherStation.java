package com.visionarysoftwaresolutions.hfdp.ch2;

import java.util.ArrayList;

public class WeatherStation {
	
	static ArrayList<ObservingDisplay> displaysToUse = new ArrayList<ObservingDisplay>();

	public static void main(String args[]){
		Display firstDisplay = new Display(new CurrentConditionsDisplay());
		displaysToUse.add(firstDisplay.getCurrentDisplay());
		
		WeatherData weatherData = new WeatherData(displaysToUse);
		
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);

	}

}
