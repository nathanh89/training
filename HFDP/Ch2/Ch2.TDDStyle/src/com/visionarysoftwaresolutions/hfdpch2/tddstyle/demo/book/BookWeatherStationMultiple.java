package com.visionarysoftwaresolutions.hfdpch2.tddstyle.demo.book;

import com.visionarysoftwaresolutions.hfdpch2.tddstyle.observers.CurrentConditions;
import com.visionarysoftwaresolutions.hfdpch2.tddstyle.observers.Forecast;
import com.visionarysoftwaresolutions.hfdpch2.tddstyle.subject.WeatherData;

public class BookWeatherStationMultiple {
	
	static WeatherData weatherData = new WeatherData();
	
	public static void main(String[] args){
		
		//And the books implementation of the Observer method is not as flexible as mine
		//You can't select what displays to show beforehand, it just displays what is programmed in
		
		CurrentConditions currentDisplay = new CurrentConditions(weatherData);
		Forecast forecastDisplay = new Forecast(weatherData);
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
		
		weatherData.deleteObserver(currentDisplay);
		weatherData.setMeasurements(90, 60, 32.5f);
		weatherData.setMeasurements(95, 75, 29.2f);
		weatherData.setMeasurements(100, 90, 18.5f);
	}
}