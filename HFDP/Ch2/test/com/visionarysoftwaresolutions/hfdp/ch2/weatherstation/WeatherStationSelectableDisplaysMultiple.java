package com.visionarysoftwaresolutions.hfdp.ch2.weatherstation;

import java.util.ArrayList;

import com.visionarysoftwaresolutions.hfdp.ch2.weatherstation.CurrentConditions;
import com.visionarysoftwaresolutions.hfdp.ch2.weatherstation.Display;
import com.visionarysoftwaresolutions.hfdp.ch2.weatherstation.Forecast;
import com.visionarysoftwaresolutions.hfdp.ch2.weatherstation.ObservingDisplay;
import com.visionarysoftwaresolutions.hfdp.ch2.weatherstation.WeatherData;

public class WeatherStationSelectableDisplaysMultiple {
	
	static ArrayList<ObservingDisplay> displaysToUse = new ArrayList<ObservingDisplay>();
	static WeatherData weatherData = new WeatherData();
	
	public static void main(String args[]){
		
		//So at this point we're assuming the user has selected only one display to show.
		//I've just gone ahead and created the displaysToUse list and populated it with
		//the user's choice, but if I were doing this program for real then that would be
		//handled by some other class say, WeatherStationSetUp
		//That class would get the displays to be used, and add them a list
		//as I've done, and pass that list to this program
		
		Display firstDisplay = new Display(new CurrentConditions(weatherData));
		Display secondDisplay = new Display(new Forecast(weatherData));
		displaysToUse.add(firstDisplay.getCurrentDisplay());
		displaysToUse.add(secondDisplay.getCurrentDisplay());
		weatherData.addDisplay(displaysToUse);
		
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
		
		weatherData.deleteObserver(firstDisplay.getCurrentDisplay());
		weatherData.setMeasurements(90, 60, 32.5f);
		weatherData.setMeasurements(95, 75, 29.2f);
		weatherData.setMeasurements(100, 90, 18.5f);

	}

}
