package com.visionarysoftwaresolutions.hfdpch2.tddstyle.demo.custom;

import com.visionarysoftwaresolutions.hfdpch2.tddstyle.subject.WeatherData;

public class WeatherStationSelectableDisplays {
	
	static WeatherData weatherData = new WeatherData();
	
	public static void main(String args[]){
		
		StationSetUp setUp = new StationSetUp();
		
		setUp.promptForDisplays();
		for(Integer currentInput : setUp.getDesiredDisplays()){
			InputReference.createDisplayByInput(currentInput, weatherData);
		}
		
		System.out.println("Three rounds of updating for the displays you chose:");
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
		}
}
